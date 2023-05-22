package com.example.usedcar.ServiceTest;

import com.example.usedcar.dto.requestdto.UsedCarRequestDto;
import com.example.usedcar.dto.responsedto.UsedCarResponseDto;
import com.example.usedcar.repository.UsedCarRepository;
import com.example.usedcar.service.UsedCarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceTest {
    @Autowired
    UsedCarRepository usedCarRepository;
    @Autowired
    UsedCarService usedCarService;

    @Test
    void 차량저장(){
        //given
        UsedCarRequestDto usedCarRequestDto = new UsedCarRequestDto("흰색",100L,100L,"소나타","2001년01월");
        //when
        Long id1 = usedCarService.saveUsedCar(usedCarRequestDto);
        UsedCarResponseDto result = usedCarService.getUsedCar(id1);
        assertEquals(id1,result.getId());
    }

}
