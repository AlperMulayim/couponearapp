package com.alper.couponear.users;

import com.alper.couponear.referencesystem.UserReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Value("${appset.totalusercards}")
    private Integer totalUserCards;
    @Autowired
    private  UserRepository userRepository;

    @GetMapping
    public List<User> getUsers(){
        return  userRepository.findAll();
    }

    @PostMapping
    public User addUser(@RequestBody User user){
        user.setAvailableSystemCards(totalUserCards);
        return userRepository.save(user);
    }

    @PostMapping("/reference")
    public User addReferance(@RequestBody UserReference reference){
        User referenceUser = User.builder()
                .name(reference.getName())
                .surname(reference.getSurname())
                .email(reference.getEmail())
                .availableSystemCards(totalUserCards)
                .uid("UR-"+reference.getName().substring(0,3))
                .build();

        Optional<User> referee = userRepository.findById(reference.getRefereeId());
        if(referee.isPresent()){
            referee.get().getReferences().add(referenceUser);
        }
        return  userRepository.save(referenceUser);
    }
}
