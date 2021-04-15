public class Person implements Comparable<Person> {
   private final String name;
   private final String surname;
   private final Integer age;

   public Person(String name, String surname, Integer age) {
       this.name = name;
       this.surname = surname;
       this.age = age;
   }

   public void print() {
       String message = this.name;
       if (this.surname.compareTo(this.name) != 0)
           message += " " + this.surname;
       message += " is " + this.age + " years old.";
       System.out.println(message);
   }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
}
