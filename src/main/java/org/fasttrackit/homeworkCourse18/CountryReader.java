package org.fasttrackit.homeworkCourse18;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.regex.Pattern;

public class CountryReader {


    private List<Country> list;
    private static AtomicInteger uniqueId = new AtomicInteger();

    public CountryReader() throws IOException {
        this.list = readCountries();
    }

    public List<Country> getList() {
        return list;
    }

    public List<Country> readCountries() throws IOException {
        List<Country> list = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader((new FileReader(("File/countries2.txt"))));
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            list.add((countryFromLine(line)));

        }
        return list;
    }

    public static Country countryFromLine(String line) {
        String[] tokens = line.split((Pattern.quote("|")));
        // if(tokens.length==5){
        //    return new Country(tokens[0], tokens[1], Long.parseLong(tokens[2]), Long.parseLong(tokens[3]), tokens[4], null, uniqueId.incrementAndGet());
        // }else {
        List<String> neighbours = tokens.length == 5 ? null : Arrays.asList(tokens[5].split(Pattern.quote("~")));
        return new Country(tokens[0], tokens[1], Long.parseLong(tokens[2]), Long.parseLong(tokens[3]), tokens[4], neighbours, uniqueId.incrementAndGet());
        // }

    }
}
