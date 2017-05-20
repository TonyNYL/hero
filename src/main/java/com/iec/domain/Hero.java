package com.iec.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tony on 2017/5/18.
 */
@Entity
public class Hero implements Serializable{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String picture;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category")
    private Category category;

    public Hero() {
    }

    public Hero(String name, String picture, Category category) {
        this.name = name;
        this.picture = picture;
        this.category = category;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
