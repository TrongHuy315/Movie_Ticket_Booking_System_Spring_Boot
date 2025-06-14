package cinema.system.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private Integer x;

    @Column(nullable = false)
    private Integer y;

    private Boolean isEmpty;

    private Boolean isChildren;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private Room room;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonManagedReference
    private User user;
}
