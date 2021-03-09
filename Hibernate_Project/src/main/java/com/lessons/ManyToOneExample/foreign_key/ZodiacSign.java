package com.lessons.ManyToOneExample.foreign_key;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "ZodiacSign")
@Table(name = "zodiac_sign")
public class ZodiacSign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "zodiac_name")
    private String zodiacName;

    @OneToMany(mappedBy = "zodiacSign", fetch = FetchType.LAZY)
    private Set<Man> people;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getZodiacName() {
        return zodiacName;
    }

    public void setZodiacName(String zodiacName) {
        this.zodiacName = zodiacName;
    }

    public Set<Man> getPeople() {
        return people;
    }

    public void setPeople(Set<Man> people) {
        this.people = people;
    }

    @Override
    public String toString() {
        return "ZodiacSign{" +
                "id=" + id +
                ", zodiacName='" + zodiacName + '\'' +
                ", people=" + people +
                '}';
    }
}
