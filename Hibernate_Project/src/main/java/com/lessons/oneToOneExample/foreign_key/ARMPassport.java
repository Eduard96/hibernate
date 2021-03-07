package com.lessons.oneToOneExample.foreign_key;

import javax.persistence.*;
import javax.persistence.OneToOne;

@Entity
@Table(name = "arm_passport")
public class ARMPassport {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "serial")
    private String serial;

    @OneToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id")
    private Person_2 person2;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Person_2 getPerson() {
        return person2;
    }

    public void setPerson(Person_2 person2) {
        this.person2 = person2;
    }

    @Override
    public String toString() {
        return "ARMPassport{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                ", person=" + person2 +
                '}';
    }
}
