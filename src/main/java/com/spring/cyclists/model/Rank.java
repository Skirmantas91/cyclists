package com.spring.cyclists.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "rank")
public class Rank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "rank")
    private int rank;

    public Rank() {

    }

    public Rank(Long id, String name, int rank) {
        this.id = id;
        this.name = name;
        this.rank = rank;
    }

    public Rank(String name, int rank) {
        this.name = name;
        this.rank = rank;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCyclistName() {
        return name;
    }

    public void setCyclistName(String cyclistName) {
        this.name = cyclistName;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Rank{" +
                "id=" + id +
                ", cyclistName='" + name + '\'' +
                ", rank=" + rank +
                '}';
    }
}
