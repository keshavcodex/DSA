package oops.staticExample;

public class main {
    public static void main(String[] args) {
        Human keshav = new Human(23, "keshav", 1000000, false);
        Human rahul = new Human(34, "rahul", 900000, true);
        Human keshav2 = new Human(23, "keshav", 1000000, false);
        Human rahul2 = new Human(34, "rahul", 900000, true);
        System.out.println(Human.population);
    }
}

