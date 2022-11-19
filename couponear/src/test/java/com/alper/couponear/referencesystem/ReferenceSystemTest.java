package com.alper.couponear.referencesystem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ReferenceSystemTest {

    private ReferenceSystem referenceSystem;
    @BeforeEach
    void init(){
       referenceSystem = new ReferenceSystem();
    }
    @Test
    void whenNumOfRefZeroPointIsZero() {
        assertEquals(0, referenceSystem.calculateReferencePoint(0));
    }

    @Test
    void whenNumOfRef11RefZeroPoint5(){
        assertEquals(5, referenceSystem.calculateReferencePoint(11));

    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "11,5", "10,0","25,5","101,10"}, delimiter = ',')
    void parameterTes7t(Integer input, Integer exp){
        assertEquals(exp, referenceSystem.calculateReferencePoint(input));
    }
}