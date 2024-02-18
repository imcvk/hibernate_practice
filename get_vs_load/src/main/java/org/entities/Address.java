package org.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long address_id;
    String address;
    @ManyToOne
    User user;

    @Override
    public String toString() {
        return "Address{" +
                "address_id=" + address_id +
                ", address='" + address + '\'' +
                ", user=" + user +
                '}';
    }
}
