package com.lessons.auto_generated_tables;

import javax.persistence.*;

@Entity
@Table
public class Some {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long some_id;
    @Column
    private String someName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Thing thing;

    public Long getSome_id() {
        return some_id;
    }

    public void setSome_id(Long some_id) {
        this.some_id = some_id;
    }

    public String getSomeName() {
        return someName;
    }

    public void setSomeName(String someName) {
        this.someName = someName;
    }

    public Thing getThing() {
        return thing;
    }

    public void setThing(Thing thing) {
        this.thing = thing;
    }

    @Override
    public String toString() {
        return "Some{" +
                "some_id=" + some_id +
                ", someName='" + someName + '\'' +
                ", thing=" + thing +
                '}';
    }
}
