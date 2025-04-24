package org.example.driverservice.model;

import jakarta.persistence.*;

@Entity
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nationality;
    private int age;
    private String team;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getNationality() { return nationality; }
    public void setNationality(String nationality) { this.nationality = nationality; }

    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    public String getTeam() { return team; }
    public void setTeam(String team) { this.team = team; }
}
