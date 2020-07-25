package com.dell.projects.comicBooksDatasetOptimiser.entity;

import javax.persistence.*;
import java.util.Set;


@Entity
public class ComicCharacter {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String[] alias;


    @ManyToMany
    private Set<Planet> planets;

    @ManyToOne
    private Category category;

    @ManyToMany
    private Set<Power> powerSet;

    public ComicCharacter() {

    }

    public ComicCharacter(String name, String[] alias) {
        this.name = name;
        this.alias = alias;
    }


    public ComicCharacter(String name, String[] alias, Set<Planet> planets, Category category, Set<Power> powerSet) {

        this.name = name;
        this.alias = alias;
        this.planets = planets;
        this.category = category;
        this.powerSet = powerSet;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAlias() {
        return alias;
    }

    public void setAlias(String[] alias) {
        this.alias = alias;
    }

    public Set<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planet> planets) {
        this.planets = planets;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Set<Power> getPowerSet() {
        return powerSet;
    }

    public void setPowerSet(Set<Power> powerSet) {
        this.powerSet = powerSet;
    }


}
