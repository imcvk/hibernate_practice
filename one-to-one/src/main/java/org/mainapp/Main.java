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
        Faker f = new Faker();
        DB_Operations dbOperations = new DB_Operations();
        User u = createUserObject();
        u.setV(createVehicleObject(u, f));
        List<Address> addresses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            addresses.add(createAddressObject(u, f));
        }
        u.setAddresses(addresses);
        dbOperations.saveObject(u);
    }

    public static User createUserObject() {
        Faker f = new Faker();
        User u = new User();
        u.setUsername(f.name().name());
        Vehicle vehicle = Main.createVehicleObject(f);
        u.setV(vehicle);
        return u;
    }

    public static Vehicle createVehicleObject(User u, Faker f) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(f.country().name());
        vehicle.setUser(u);
        return vehicle;
    }

    public static Address createAddressObject(User u, Faker f) {

        Address a = new Address();
        a.setAddress(f.address().fullAddress());
        a.setUser(u);
        return a;
    }

}
