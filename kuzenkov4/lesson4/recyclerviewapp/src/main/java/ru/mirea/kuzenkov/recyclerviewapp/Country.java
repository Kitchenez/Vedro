package ru.mirea.kuzenkov.recyclerviewapp;

public class Country {
    private final String countryName;
    private final int flagResource;
    private final int population;
    public Country(String countryName, int flagResource, int population) {
        this.countryName = countryName;
        this.flagResource = flagResource;
        this.population = population;
    }
    public int getPopulation() {
        return population;
    }
    public String getCountryName() {
        return countryName;
    }
    public int getFlagResource() {
        return flagResource;
    }
    @Override
    public String toString() {
        return this.countryName+" (Population: "+ this.population+")";
    }
}