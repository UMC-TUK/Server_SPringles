package com.example.trip.trip;

import com.example.trip.attraction.Attraction;
import lombok.*;
import org.w3c.dom.Attr;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor (access = AccessLevel.PROTECTED)
public class Trip {
    @Id @GeneratedValue
    private Long id;
    @ElementCollection
    private List<String> attractions = new ArrayList<>();
    private String memberId;
    private LocalDate tripDate;

    @Builder
    public Trip(String memberId, LocalDate tripDate, List<String>attractions) {
        this.attractions = attractions;
        this.memberId = memberId;
        this.tripDate = tripDate;
    }
}
