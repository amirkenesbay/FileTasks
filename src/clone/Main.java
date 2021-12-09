package clone;

public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Person person2 = foo(person);

        person.setName("Amir");
        person2.setName("AmirClone");

        System.out.println(person.getName());
        System.out.println(person2.getName());
    }

    public static Person foo(Person person2){
        Person p = null;
        try {
            p = (Person) person2.clone();
        } catch (CloneNotSupportedException e){
            e.printStackTrace();
        }
        return p;
    }
}
