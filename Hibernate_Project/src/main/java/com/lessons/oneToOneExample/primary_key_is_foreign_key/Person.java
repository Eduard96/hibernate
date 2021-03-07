package com.lessons.oneToOneExample.primary_key_is_foreign_key;

import javax.persistence.*;
import javax.persistence.OneToOne;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;
    @Column(name = "name")
    private String name;

    //mappedBy has to match with field in Location class
    @OneToOne(mappedBy = "person", fetch = FetchType.LAZY, optional = false)
    private Locations locations;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public Locations getLocations() {
        return locations;
    }

    public void setLocations(Locations locations) {
        this.locations = locations;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    @Override
    public String toString() {
        return "{Person " + getPersonId() + " " + getName() + "}";
    }
}
