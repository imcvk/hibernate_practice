package org.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    @Temporal(TemporalType.DATE)
    Date date_purchesed;
    @Temporal(TemporalType.DATE)
    Date date_of_registration;
    @OneToOne
    User user;
}
