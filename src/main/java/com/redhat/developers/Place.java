package com.redhat.developers;

import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Place extends PanacheEntity {
    public String city;
    public String country;
    public String month;
    public String year;

    public static List<Place> findByMonth(String month) {
        return find("month", month).list();
    }
}
