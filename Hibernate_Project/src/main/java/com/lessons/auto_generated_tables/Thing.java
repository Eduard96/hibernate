package com.lessons.auto_generated_tables;

import javax.persistence.*;

@Entity
@Table
public class Thing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long thing_id;
    @Column
    private String thingName;

    @OneToOne(mappedBy = "thing", fetch = FetchType.LAZY)
    private Some some;

    public Long getThing_id() {
        return thing_id;
    }

    public void setThing_id(Long thing_id) {
        this.thing_id = thing_id;
    }

    public String getThingName() {
        return thingName;
    }

    public void setThingName(String thingName) {
        this.thingName = thingName;
    }

    public Some getSome() {
        return some;
    }

    public void setSome(Some some) {
        this.some = some;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "thing_id=" + thing_id +
                ", thingName='" + thingName + '\'' +
                ", some=" + some.getSomeName() +
                '}';
    }
}
