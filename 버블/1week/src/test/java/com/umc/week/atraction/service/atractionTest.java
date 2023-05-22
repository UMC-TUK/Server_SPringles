package com.umc.week.atraction.service;

import com.umc.week.atraction.dto.AtractionRequest;
import com.umc.week.atraction.entity.Atraction;
import com.umc.week.atraction.repository.AtractionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.shadow.com.univocity.parsers.annotations.EnumOptions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.any;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class atractionTest {

    @InjectMocks
    private AtractionService atractionService;
    @Mock
    private AtractionRepository atractionRepository;
    @Mock
    private static Atraction expectAtraction;

    @BeforeAll
    static void setup() {
        expectAtraction = Atraction.builder()
                .place("해운대")
                .weather("여름")
                .address("부산")
                .build();
    }

    @BeforeEach
    void setupEach(){
        when(atractionRepository.save(any())).thenReturn(expectAtraction);
    }

    @Test
    @DisplayName("저장")
    void save() {
        //given
        AtractionRequest givenAtraction = AtractionRequest.builder().build();
        //when
        Atraction actualAtraction = atractionService.addAtraction(givenAtraction);
        //then
        assertAll(() -> assertEquals(expectAtraction,actualAtraction));

    }
}


