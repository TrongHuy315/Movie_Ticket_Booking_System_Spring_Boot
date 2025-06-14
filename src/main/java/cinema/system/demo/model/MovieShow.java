package cinema.system.demo.model;

import java.time.LocalDate;
import java.time.LocalTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class MovieShow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDate date;

    private LocalTime beginTime;

    private LocalTime endTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Room room;

    @OneToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Movie movie;

    
}
