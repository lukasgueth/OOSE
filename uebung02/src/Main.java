import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // aufgabe1();
         aufgabe2();
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

    public static void aufgabe2() {
        /*Aufgabe 2.a: Eine Anonyme Klasse ist Klasse ohne eigenen Namen und Konstruktor, dessen Objekte direkt angelegt werden müssen.
        * Die Anonyme Klasse erweitert dabei eine existierende Klasse oder implementiert ein Interface.
        * Dadurch, das sie keinen eigenen Namen hat kann sie nicht wieder verwendet werden und wird meistens nur verwendet,
        * wenn man einmalig ein Objekt braucht. Dadurch das man keine eigene Klasse schreiben muss, kann man mit Anonymen
        * Klassen Aufwand sparen */

        // Aufgabe 2.b:
        new Thread(new Runnable() {
            @Override
            public void run() {
                int counter = 0;
                while( counter <=100){
                    System.out.println(counter);
                    counter ++;
                }
            }
        }).start();
    }

    public static void aufgabe3() {}

    public static void aufgabe4() {
        String testPhrase = "Das ist in der Remigiusstraße 13, 53111 Bonn";
        System.out.println(Parser.parseStreet(testPhrase));
        testPhrase = "500g Mehl 123,2 ml Milch";
        System.out.println(Parser.extractNumberFromStr(testPhrase));
    }

    public static void aufgabe5() {}
}
