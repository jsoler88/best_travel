package com.debuggeando_ideas.best_travel.domain.entitites.jpa;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerEntity implements Serializable {

    @Id
    private String dni;
    @Column(length = 50)
    private String fullName;
    @Column(length = 20)
    private String creditCard;
    @Column(length = 12)
    private String phoneNumber;
    private Integer totalFlights;
    private Integer totalLodgings;
    private Integer totalTours;
}
