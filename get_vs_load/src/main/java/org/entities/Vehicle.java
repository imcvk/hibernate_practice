package org.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_purchesed=" + date_purchesed +
                ", date_of_registration=" + date_of_registration +
                ", user=" + user +
                '}';
    }
}
