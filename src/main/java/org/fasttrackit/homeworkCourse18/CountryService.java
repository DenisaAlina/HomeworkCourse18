package org.fasttrackit.homeworkCourse18;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    private final List<Country> list;

    public CountryService(CountryReader countryReader) {
        this.list = countryReader.getList();
    }

    public List<Country> listAllCountries() {
        return list;
    }

    public List<String> listAllCountryNames() {
        return list.stream()
                .map(country -> country.getName())
                .toList();
    }

    public String getCapitalOfACountry(Integer id) {
        return list.stream()
                .filter(country -> country.getId().equals(id))
                .map(country -> country.getCapital())
                .findFirst()
                .get();
    }

    public Long getPopulationOfACountry(Integer id) {
        return list.stream()
                .filter(country -> country.getId().equals(id))
                .map(country -> country.getPopulation())
                .findFirst()
                .get();
    }

    public List<Country> getCountriesInContinent(String continentName) {
        return list.stream()
                .filter(country -> country.getContinent().equals(continentName))
                .toList();
    }

    public List<String> getCountryNeighbours(Integer countryId) {
        Optional<Country> result = list.stream()
                .filter(country -> country.getId().equals(countryId))
                .findFirst();
        if (result.isPresent()) {
            return result.map(country -> country.getNeighbours()).get();


        }
        return null;
    }

    public List<Country> getCountries(String continentName, Long minPopulation) {
        return list.stream()
                .filter(country -> country.getContinent().equals(continentName))
                .filter(country -> country.getPopulation() > minPopulation)
                .toList();
    }

    public List<Country> getCountriesThatNeighbour(String includeNeighbour, String excludeNeighbour) {
        return list.stream()
                .filter(country -> country.getNeighbours() != null && country.getNeighbours().contains(includeNeighbour))
                .filter(country -> country.getNeighbours() != null && !country.getNeighbours().contains(excludeNeighbour))
                .toList();
    }
}
