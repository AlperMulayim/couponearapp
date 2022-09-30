package com.alper.couponear.users;

import com.alper.couponear.referencesystem.ReferenceSystem;
import com.alper.couponear.referencesystem.UserReference;
import com.alper.couponear.security.JwtTokenPorvider;
import com.alper.couponear.security.LoginRequest;
import com.alper.couponear.security.LoginResponse;
import com.alper.couponear.security.WebSecurityConfig;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Value("${appset.totalusercards}")
    private Integer totalUserCards;
    @Autowired
    private  UserRepository userRepository;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenPorvider tokenProvider;

    @GetMapping
    public List<User> getUsers(){
        return  userRepository.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        user.setAvailableSystemCards(totalUserCards);
        String uid = UUID.randomUUID().toString().substring(0,10);
        user.setUid(uid);
        return userRepository.save(user);
    }

    @PostMapping("/reference")
    public User addReferance(@RequestBody UserReference reference){
        String uuid = UUID.randomUUID().toString().substring(0,10);
        User referenceUser = User.builder()
                .name(reference.getName())
                .surname(reference.getSurname())
                .email(reference.getEmail())
                .availableSystemCards(totalUserCards)
                .uid("REU-" + uuid)
                .build();

        Optional<User> referee = userRepository.findById(reference.getRefereeId());

        if(referee.isPresent()){
            referee.get().getReferences().add(referenceUser);
            Integer referencePoint = new ReferenceSystem()
                    .calculateReferencePoint(referee.get().getReferences().size());
            referee.get().setAvailableSystemCards(referee.get().getAvailableSystemCards() + referencePoint);
        }
        return  userRepository.save(referenceUser);
    }



    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@RequestBody LoginRequest loginRequest){
          String token = null;
//        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//                loginRequest.getMail(),  new BCryptPasswordEncoder().encode("a")));

//
//        if(authentication.isAuthenticated()){
//            token= tokenProvider.generate(loginRequest.getMail());
//        }

        token = tokenProvider.generate(loginRequest.getMail());

        return ResponseEntity.ok(LoginResponse.builder()
                        .mail(loginRequest.getMail())
                        .token(token)
                .build());
    }
}
