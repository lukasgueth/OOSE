import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Collections;

public class Main {
    static Person p1 = new Person("Lukas", "Lukas", 20);
    static Person p2 = new Person("Henrik", "Theisen", 19);

    public static void main(String[] args) {
        System.out.println("\n===== Aufgabe 1 =====");
        // aufgabe1();
        System.out.println("==========\n");

        System.out.println("\n===== Aufgabe 2 =====");
        // aufgabe2();
        System.out.println("==========");

        System.out.println("\n===== Aufgabe 3 =====");
        // aufgabe3();
        System.out.println("==========");

        System.out.println("\n===== Aufgabe 4 =====");
        aufgabe4();
        System.out.println("==========");
    }

    private static void aufgabe1() {
        // b)
        var sorter = new PersonenSortierer();
        sorter.compare(p1, p2);
        // c)
        var listOfPersons = new ArrayList<Person>(2);
        listOfPersons.add(p1);
        listOfPersons.add(p2);
        Collections.sort(listOfPersons, Person::compareTo);
        for (Person p: listOfPersons)
            p.print();
        Collections.sort(listOfPersons, sorter);
        for (Person p: listOfPersons)
            p.print();

        Collections.max(listOfPersons, Person::compareTo).print();
        Collections.min(listOfPersons, Person::compareTo).print();
        Collections.max(listOfPersons, sorter).print();
        Collections.min(listOfPersons, sorter).print();
    }

    private static void aufgabe2() {
        // a)
        var persons = new HashMap<String, Person>();
        persons.put(p1.getFullname(), p1);
        persons.put(p2.getFullname(), p2);
        persons.forEach((key, person) -> person.print());

        // b)
        /*
        Das Laden eines Objekts aus einer Hashmap geht schneller, da hier mit dem Schlüssel direkt auf
        das in der Hashmap gespeicherte Objekt zugegriffen werden kann.

        Beim Durchsuchen der Liste müsste mit einem Suchalgorithmus der entsprechende Schlüssel gefunden werden.
        Das kann im best case eine Laufzeit von einer Abfrage haben, kann aber auch eine Laufzeit von z.B. O(n) haben.
        */

        // c)
        /*
        Man könnte per .keySet() ein Set der Schlüssel erhalten. Über diese iterieren und dann die entsprechenden
        Personen per .get() erhalten.
        Des weiteren, könnte man z.B. per .values() alle Personen der HashMap erhalten und über diese Collection
        iterieren.
        */
    }

    private static void aufgabe3() {
        // a)
        new PrimzahlRechner(0, 1000);
        new PrimzahlRechner(1000, 2000);
        new PrimzahlRechner(2000, 3000);
        new PrimzahlRechner(3000, 4000);

        // b)
        /*
        Man kann auch einfach Threads mit java.util.Thread Threads benutzen.
        */
    }

    private static void aufgabe4() {
        var incrementer1 = new Inkrementierer(new Zähler());
        System.out.println("Asynchronously increment counter.");
        incrementer1.asyncIncrement();

        var incrementer2 = new Inkrementierer(new Zähler());
        System.out.println("\nSynchronously increment counter.");
        incrementer2.syncIncrement();
    }
}
