package org.fasttrackit.homeworkCourse18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("continents")
public class Continents {
    @Autowired
    CountryService countryService;

    public Continents() throws IOException {
    }


    @GetMapping("{continentName}/countries")
    List<Country> getCountriesWithPopulationGreatherThan(@PathVariable String continentName,
                                                         @RequestParam(required = false) Long minPopulation) {

        if (minPopulation == null) {
            return countryService.getCountriesInContinent(continentName);
        } else {
            return countryService.getCountries(continentName, minPopulation);
        }
    }
}
