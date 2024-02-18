package org.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;


//this is used to tell that this is entity class and table need to create for this one.
@Entity
//used to set table attributes
@Table(name = "user_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userid;
    String username;
    @OneToOne(cascade = CascadeType.ALL)
    Vehicle v;
    @OneToMany(cascade = CascadeType.ALL)
    List<Address> addresses;

}
