package ro.beta.curs17_homework;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class CountryReader {
    public List<CountryRepository> readCountriesFromFile() throws IOException {
        List<CountryRepository> countries = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader("countries"));
        String line;
        int idCounter = 1;

        while ((line = reader.readLine()) != null) {
            String[] fields = line.split("\\|");
            String name = fields[0];
            String capital = fields[1];
            long population = Long.parseLong(fields[2]);
            Integer area = Integer.parseInt(fields[3]);
            String continent = fields[4];
            List<String> neighbours = Arrays.asList(fields[5].split("~"));
            CountryRepository country = new CountryRepository(idCounter++, name, capital, population, area, continent, neighbours);
            countries.add(country);
        }
        reader.close();
        return countries;
    }
}
