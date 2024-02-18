package org.mainapp;

import com.github.javafaker.Faker;
import org.DAO.DB_Operations;
import org.entities.Address;
import org.entities.User;
import org.entities.Vehicle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Main {
    public static void main(String[] args) {
        DB_Operations dbOperations = new DB_Operations();
        System.out.println(dbOperations.saveObject(createUserObject()));
//        User u = new User();
//        System.out.println(dbOperations.getUser(u.getUserid()));
//        dbOperations.deleteObject(u);
    }

    public static User createUserObject() {
        Faker f = new Faker();
        User u = new User();
        u.setUsername(f.name().name());
        Vehicle vehicle = Main.createVehicleObject(f);
        u.setV(vehicle);
        vehicle.setUser(u);
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Address a = createAddressObject(f);
            a.setUser(u);
            addresses.add(a);

        }
        u.setAddresses(addresses);
        System.out.println(addresses);
        return u;
    }

    public static Vehicle createVehicleObject(Faker f) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName("Punch");
        vehicle.setDate_of_registration(new Date());
        vehicle.setDate_purchesed(f.date().birthday());
        return vehicle;
    }

    public static Address createAddressObject(Faker f) {
        Address address = new Address();
        address.setAddress(f.address().fullAddress());
        return address;
    }
}
