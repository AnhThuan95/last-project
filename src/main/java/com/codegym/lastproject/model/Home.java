package com.codegym.lastproject.model;

import javax.persistence.*;

@Entity
@Table(name = "homes")
public class Home {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String room;

    private String address;

    private int bedroom;

    private int bathroom;

    private String description;

    private Float priceByNight;

    @Enumerated(EnumType.STRING)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "host_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "catergoty_id")
    private Category category;

    public Home(){}

    public Home(String name, Category category, User user, String room, String address, int bedroom, int bathroom, String description, Float priceByNight){
        this.name = name;
        this.category = category;
        this.room = room;
        this.address = address;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.description = description;
        this.priceByNight = priceByNight;
        this.status = status;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedroom() {
        return bedroom;
    }

    public void setBedroom(int bedroom) {
        this.bedroom = bedroom;
    }

    public int getBathroom() {
        return bathroom;
    }

    public void setBathroom(int bathroom) {
        this.bathroom = bathroom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPriceByNight() {
        return priceByNight;
    }

    public void setPriceByNight(Float priceByNight) {
        this.priceByNight = priceByNight;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
