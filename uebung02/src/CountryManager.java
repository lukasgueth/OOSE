import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CountryManager {
    private final List<String> countries;
    private final String countriesFilePath = "./src/countries.txt";

    public CountryManager() {
        this.countries = new ArrayList<>();
        this.readCountriesFile();
    }

    private void readCountriesFile() {
        try {
            File countriesFile = new File(this.countriesFilePath);
            Scanner reader = new Scanner(countriesFile);
            while (reader.hasNextLine())
                this.countries.add(reader.nextLine());
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }

    private void addCountryToCountriesFile(String country) {
        try {
            FileWriter writer = new FileWriter(this.countriesFilePath, true);
            writer.write("\n" + country);
            writer.close();
            System.out.println("Successfully wrote \"" + country + "\" to countries.txt.");
        } catch (IOException e) {
            System.out.println("Something went wrong while country \"" + country + "\" to countries.txt!");
            e.printStackTrace();
        }
    }

    public List<String> getCountries() { return this.countries; }

    public List<String> searchCountries(String searchString) {
        return this.countries.stream().filter((country) ->
                country.contains(searchString)).collect(Collectors.toList()
        );
    }

    public void addCountry(String country) {
        String countryRegex = "^[A-Z][a-zA-Z]{2,}$";
        if (country.matches(countryRegex) && !this.countries.contains(country)) {
            this.addCountryToCountriesFile(country);
            this.countries.add(country);
        } else System.out.println("Invalid country name or country already exists!");
    }
}
