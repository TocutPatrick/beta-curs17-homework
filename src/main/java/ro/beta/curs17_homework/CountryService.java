package ro.beta.curs17_homework;

import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CountryService {
    private final List<CountryRepository> countries;

    public CountryService(CountryReader countryReader) throws IOException {
        this.countries = countryReader.readCountriesFromFile();
    }

    public List<CountryRepository> listAllCountries(){
        return countries;
    }

    public List<String> listAllCountriesNames(){
        List<String> list = new ArrayList<>();
        for(CountryRepository country : countries){
            list.add(country.getName());
        }
        return list;
    }

    public String getCapitalOfCountry(String name){
        for(CountryRepository country : countries){
            if(country.getName().equalsIgnoreCase(name)){
                return country.getCapital();
            }
        }
        return null;
    }

    public long getPopulation(String name){
        for(CountryRepository country : countries){
            if(country.getName().equalsIgnoreCase(name)){
                return country.getPopulation();
            }
        }
        return 0;
    }

    public List<CountryRepository> getCountriesInContinent(String continent){
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continent))
                .toList();
    }

    public List<String> getCountryNeighbours(String name){
        for(CountryRepository country : countries){
            if(country.getName().equalsIgnoreCase(name)){
                return country.getNeighbours();
            }
        }
        return null;
    }

    public List<CountryRepository> sortByContinentAndPopulation(String continent, long population){
        return countries.stream()
                .filter(country -> country.getContinent().equalsIgnoreCase(continent) && country.getPopulation() > population)
                .toList();
    }

    public List<CountryRepository> sortByNeighbours(String neighbour, String notNeighbour){
        return countries.stream()
                .filter(country -> country.getNeighbours().contains(neighbour) && !country.getNeighbours().contains(notNeighbour))
                .toList();

    }

}
