package com.example.usedcar.repository;

import com.example.usedcar.entity.UsedCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
public interface UsedCarRepository extends JpaRepository<UsedCar,Long> {
    @Transactional
    @Modifying
    @Query("UPDATE UsedCar u SET u.name = :name WHERE u.id = :id")
    void updateName(@Param("id")Long id,@Param("name")String name);

    @Transactional
    @Modifying
    @Query("UPDATE UsedCar u SET u.name = :name,u.color = :color, u.mileage = :mileage, " +
            "u.price = :price, u.model_year = :model_year WHERE u.id = :id")
    void updateAll(@Param("id")Long id,@Param("name")String name
                    ,@Param("color")String color,@Param("mileage")Long mileage,@Param("price")Long price
                    ,@Param("model_year")String model_year
    );
}
