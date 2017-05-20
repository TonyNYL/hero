package com.iec.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tony on 2017/5/18.
 */
@Entity
public class Hero implements Serializable{

    public Hero(String name, String category, String picture) {
        this.name = name;
        this.category = category;
        this.picture = picture;
    }

    public Hero() {
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String picture;

    @Column
    private String category;

}
