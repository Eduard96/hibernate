package com.lessons.oneToOneExample.foreign_key;

import javax.persistence.OneToOne;
import javax.persistence.*;

@Entity
@Table(name = "persons")
public class Person_2 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int personId;
    @Column(name = "name")
    private String name;

    //mappedBy has to match with field in ARMPassport class
    @OneToOne(mappedBy = "person2", fetch = FetchType.LAZY, optional = false)
    private ARMPassport arm_passport;

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public ARMPassport getArm_passport() {
        return arm_passport;
    }

    public void setArm_passport(ARMPassport locations) {
        this.arm_passport = locations;
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
