package com.umc.week.trip.repository;

import com.umc.week.trip.entity.Trip;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip,Long> {

    @Query("select r from Trip ")
    Page<Trip> findTripWithPagination(Pageable pageable);

}
