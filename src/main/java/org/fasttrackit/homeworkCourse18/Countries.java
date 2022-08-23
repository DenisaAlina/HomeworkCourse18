package org.fasttrackit.homeworkCourse18;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("countries")
public class Countries {

    @Autowired
    CountryService countryService;

    public Countries() throws IOException {
    }


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

    @GetMapping
    List<Country> getCountryThatNeighbour(@RequestParam(required = false) String includeNeighbour, @RequestParam(required = false) String excludeNeighbour) {
        if (includeNeighbour == null && excludeNeighbour == null) {
            return countryService.listAllCountries();
        } else {
            return countryService.getCountriesThatNeighbour(includeNeighbour, excludeNeighbour);
        }
    }
}
