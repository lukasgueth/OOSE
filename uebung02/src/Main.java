import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;



public class Main {


    public static void main(String[] args) {
        // aufgabe1();
        // aufgabe2();
        aufgabe3();
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
                while (counter <= 100) {
                    System.out.println(counter);
                    counter++;
                }
            }
        }).start();
    }

    public static void aufgabe3() {
        /*Aufgabe 3.a: Ein Lambda Ausdruck sind Methoden ohne Namen, welche aus einer liste aus Paramaetern, einem Pfeil "->" und einem
         Funktionstrumpf sie sind in den meisten Fällen wesentlich kürzer als eine Methode.

         Aufgabe 3.b: Ein Lambda Ausdruck kann eine anonyme Klasse ersetzten wenn diese nur eine Methode hat.
         */
        List<Person> persons = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Type \":go\" to stop adding persons.");
        int counter = 1;
        boolean end = false;
        do {
            System.out.println("\nPerson " + Integer.toString(counter));
            System.out.print("surname: ");
            String surnameInput = sc.next();
            if (!surnameInput.equals(":go")) {
                System.out.print("name: ");
                String nameInput = sc.next();

                if (!nameInput.equals(":go")) {
                    persons.add(new Person() {


                        @Override
                        public void setName(String name) {
                            this.name = name;
                        }

                        @Override
                        public String getName() {
                            return this.name;
                        }

                        @Override
                        public void setSurname(String surname) {
                            this.surname = surname;
                        }

                        @Override
                        public String getSurname() {
                            return this.surname;
                        }

                        String surname = "";
                        String name = "";
                    });
                    persons.get(counter-1).setSurname(surnameInput);
                    persons.get(counter-1).setName(nameInput);

                }
                else end = true;
            } else end = true;
            counter++;
        } while (!end);



        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int surnameComparison = o1.surname.compareToIgnoreCase(o2.surname);
                if (surnameComparison != 0)
                    return surnameComparison;
                int nameComparison = Character.toString(o1.name.charAt(2)).compareToIgnoreCase(Character.toString(o2.name.charAt(2)));
                return nameComparison;
            }
        });
        for(int i = 0; i < persons.size(); i++){
            System.out.println(persons.get(i).getName() + ", " + persons.get(i).getSurname());
        }
    }

    public static void aufgabe4() {
        String testPhrase = "Das ist in der Remigiusstraße 13, 53111 Bonn";
        System.out.println(Parser.parseStreet(testPhrase));
        testPhrase = "500g Mehl 123,2 ml Milch";
        System.out.println(Parser.extractNumberFromStr(testPhrase));
        String testPhonenumber = "+49 0228-234235";
        System.out.println(Parser.isValidPhonenumber(testPhonenumber));
    }

    public static void aufgabe5() {
        /*
        a)
            void  eat (){} an gegebener Stelle würde, weil Hamburger von Fastfood erbt, die Methode eat ohne Probleme überschreiben
        b)
            void eat() throws Exception {} kann nicht kompilieren, da die Überschriebene Methode eat in Fastfood  eine Subklasse von Exception schmeißt.
            Sub-exceptions in der erbenden Klasse zu generalisieren ist nicht möglich.
        c)
            void eat(int y) throws Exception {} kann kompilieren, da keine Methode überschrieben wird aus Fastfood, eat() und eat(int y) coexistieren sozusagen in Hamburger, ohne Probleme
         */
    }
}

