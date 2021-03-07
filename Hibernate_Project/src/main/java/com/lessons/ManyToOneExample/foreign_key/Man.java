package com.lessons.ManyToOneExample.foreign_key;

import javax.persistence.*;
import javax.persistence.ManyToOne;

@Entity(name = "Man")
@Table(name = "man")
public class Man {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;

    @ManyToOne
    @JoinColumn(name = "zodiac_id")
    private ZodiacSign zodiacSign;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public ZodiacSign getZodiacSign() {
        return zodiacSign;
    }

    public void setZodiacSign(ZodiacSign zodiacSign) {
        this.zodiacSign = zodiacSign;
    }

    @Override
    public String toString() {
        return "Man{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", zodiacSign=" + zodiacSign.getZodiacName() +
                '}';
    }
}
