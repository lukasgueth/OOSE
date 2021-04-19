import java.util.Comparator;

public class PersonenSortierer implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        if (p1.name.compareToIgnoreCase(p2.name) != 0)
            return p1.name.compareToIgnoreCase(p2.name);
        if (p1.surname.compareToIgnoreCase(p2.surname) != 0)
            return p1.surname.compareToIgnoreCase(p2.surname);
        if (p1.age != p2.age)
            return p1.age - p2.age;

        return 0;
    }
}
