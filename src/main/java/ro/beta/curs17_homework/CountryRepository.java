package ro.beta.curs17_homework;

import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CountryRepository {
    private final Integer id;
    private final String name;
    private final String capital;
    private final long population;
    private final Integer area;
    private final String continent;
    private final List<String> neighbours;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }

    public long getPopulation() {
        return population;
    }

    public Integer getArea() {
        return area;
    }

    public String getContinent() {
        return continent;
    }

    public List<String> getNeighbours() {
        return neighbours;
    }
}
