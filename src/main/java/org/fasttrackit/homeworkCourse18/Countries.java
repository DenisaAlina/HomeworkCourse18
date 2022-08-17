package org.fasttrackit.homeworkCourse18;

import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("countries")
public class Countries {

    CountryService countryService = new CountryService(new CountryReader());

    public Countries() throws IOException {
    }


    // @GetMapping
    // List<Country> listCountries(){
    //   return countryService.listAllCountries();
    //}


    @GetMapping("names")
    List<String> listNames() {
        return countryService.listAllCountryNames();
    }

    @GetMapping("{countryId}/capital")
    String getCapital(@PathVariable Integer countryId) {
        return countryService.getCapitalOfACountry(countryId);
    }

    @GetMapping("{countryId}/population")
    Long getPopulation(@PathVariable Integer countryId) {
        return countryService.getPopulationOfACountry(countryId);
    }

    @GetMapping("{countryId}/neighbours")
    List<String> getCountryNeighbours(@PathVariable Integer countryId) {
        return countryService.getCountryNeighbours(countryId);
    }

    //compilation error for same annotation
    @GetMapping
    List<Country> getCountryThatNeighbour(@RequestParam String includeNeighbour, @RequestParam String excludeNeighbour) {
        return countryService.getCountriesThatNeighbour(includeNeighbour, excludeNeighbour);
    }
}
