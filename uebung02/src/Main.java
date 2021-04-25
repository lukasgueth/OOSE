import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // aufgabe1();
        // aufgabe2();
        // aufgabe3();
        // aufgabe4();
        // aufgabe5();
    }

    public static void aufgabe1() {
        CountryManager manager = new CountryManager();
        System.out.println(manager.getCountries());
        System.out.println(manager.searchCountries("ha"));
        manager.addCountry("Testland");
    }

    public static void aufgabe2() {}

    public static void aufgabe3() {}

    public static void aufgabe4() {}

    public static void aufgabe5() {}
}
