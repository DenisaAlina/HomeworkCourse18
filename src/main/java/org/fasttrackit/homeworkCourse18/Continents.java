package org.fasttrackit.homeworkCourse18;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("continents")
public class Continents {

    CountryService countryService=new CountryService( new CountryReader());

    public Continents() throws IOException {
    }

   // @GetMapping("{continentName}/countries")
    //List<Country> getCountries(@PathVariable String continentName){
      // return countryService.getCountriesInContinent(continentName);
    //}


    //compilation error for same annotation
    @GetMapping("{continentName}/countries")
    List<Country> getCountriesWithPopulationGreatherThan(@PathVariable String continentName,
                                                         @RequestParam Long minPopulation){
        return countryService.getCountries(continentName, minPopulation);
    }
}
