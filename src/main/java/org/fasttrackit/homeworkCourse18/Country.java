package org.fasttrackit.homeworkCourse18;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Country {
    private String name;
    private String capital;
    private Long population;
    private Long area;
    private String continent;
    private List<String> neighbours;

    private Integer id;


    public Country(String name, String capital, Long population, Long area, String continent, List<String> neighbours, Integer id) {
        this.name = name;
        this.capital = capital;
        this.population = population;
        this.area = area;
        this.continent = continent;
        this.neighbours = neighbours;
        this.id = id;
    }
}

