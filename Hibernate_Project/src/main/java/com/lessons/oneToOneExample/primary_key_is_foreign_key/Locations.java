package com.lessons.oneToOneExample.primary_key_is_foreign_key;

import javax.persistence.*;
import javax.persistence.OneToOne;

@Entity
@Table(name = "locations")
public class Locations {

    /**
     * p_location_id is a Primary key and foreign key
     */

    @Id
    @Column(name = "p_location_id")
    private Integer personLocationId;
    @Column(name = "loc_name")
    private String locationName;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    //@JoinColumn(name = "p_location_id")
    private Person person = new Person();

    public Integer getPersonLocationId() {
        return personLocationId;
    }

    public void setPersonLocationId(Integer personLocationId) {
        this.personLocationId = personLocationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
        setPersonLocationId(person.getPersonId());
    }

    @Override
    public String toString() {
        return "Locations{" +
                "personLocationId=" + personLocationId +
                ", locationName='" + locationName + '\'' +
                ", person=" + person.toString() +
                '}';
    }
}
