package com.lessons.ManyToManyExample;

import javax.persistence.ManyToMany;
import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "readers")
public class Reader {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "lastname")
    private String lastname;

    /**
     * Instead of name in JoinColumn
     * we can use referencedColumnName
     */
    @ManyToMany
//    @JoinTable(name = "readers_subs",
//            joinColumns = {@JoinColumn(name = "reader_id")},
//            inverseJoinColumns = {@JoinColumn(name = "subs_id")})
    @JoinTable(
            joinColumns = {@JoinColumn(referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(referencedColumnName = "id")})
    private Set<Subscriber> subscribers;

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

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public void setSubscribers(Set<Subscriber> subscribers) {
        this.subscribers = subscribers;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", subscribers=" + subscribers +
                '}';
    }
}
