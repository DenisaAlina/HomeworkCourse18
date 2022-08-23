package org.fasttrackit.homeworkCourse18;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

@Component
public class CountryReader {


    private List<Country> list;

    public CountryReader() throws IOException {
        this.list = readCountries();
    }

    public List<Country> getList() {
        return list;
    }

    public List<Country> readCountries() throws IOException {
        List<Country> list = new ArrayList<>();
        AtomicInteger uniqueId = new AtomicInteger();
        BufferedReader bufferedReader = new BufferedReader((new FileReader(("File/countries2.txt"))));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add((countryFromLine(line, uniqueId.incrementAndGet())));

        }
        return list;
    }

    public static Country countryFromLine(String line, int id) {
        String[] tokens = line.split((Pattern.quote("|")));
        List<String> neighbours = tokens.length == 5 ? null : Arrays.asList(tokens[5].split(Pattern.quote("~")));
        return new Country(tokens[0], tokens[1], Long.parseLong(tokens[2]), Long.parseLong(tokens[3]), tokens[4], neighbours, id);

    }
}
