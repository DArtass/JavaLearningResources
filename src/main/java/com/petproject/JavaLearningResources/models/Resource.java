package com.petproject.JavaLearningResources.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name, description, link, type;
    private int useful, numberJumps;
    //private ResourceType type;

    public Resource() {
    }

    public Resource(String name, String description, String link, String type, int useful) {
        this.name = name;
        this.description = description;
        this.link = link;
        this.type = type;
        this.useful = useful;
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

    public String getLink() { return link; }

    public void setLink(String link) { this.link = link; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) { this.type = type; }

    public int getUseful() {
        return useful;
    }

    public void setUseful(int useful) {
        this.useful = useful;
    }

    public int getNumberJumps() {
        return numberJumps;
    }

    public void setNumberJumps(int numberJumps) {
        this.numberJumps = numberJumps;
    }
}
