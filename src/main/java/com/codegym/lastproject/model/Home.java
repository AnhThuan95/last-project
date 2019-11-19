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

    @ManyToOne
    @JoinColumn(name = "catergoty_id")
    private Category category;

    public Home(){}

    public Home(String name, String room, String address, int bedroom, int bathroom, String description, Float priceByNight){
        this.name = name;
        this.room = room;
        this.address = address;
        this.bedroom = bedroom;
        this.bathroom = bathroom;
        this.description = description;
        this.priceByNight = priceByNight;
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
}
