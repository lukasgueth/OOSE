public class Person implements Comparable<Person> {
   public final String name;
   public final String surname;
   public final Integer age;

   public Person(String name, String surname, Integer age) {
       this.name = name;
       this.surname = surname;
       this.age = age;
   }

    @Override
    public int compareTo(Person p) {
        if (this.surname.compareToIgnoreCase(p.surname) != 0)
            return this.surname.compareToIgnoreCase(p.surname);
        if (this.name.compareToIgnoreCase(p.name) != 0)
            return this.name.compareToIgnoreCase(p.name);
        if (this.age != p.age)
            return this.age - p.age;

        return 0;
    }

   public void print() {
       System.out.println(this.name + " is " + this.age + " years old.");
   }

    public String getFullname() {
       return this.name + " " + this.surname;
    }
}
