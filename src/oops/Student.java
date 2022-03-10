package oops;

public class Student {
    int roll;
    String name;
    float marks;

    Student(int roll, String name, float marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }
    public static void main(String[] args) {
        Student keshav = new Student(13, "chintu", 5.5f);
        Student rahul = new Student(13, "ral", 5.5f);
//        System.out.println(keshav.roll);
//        System.out.println(keshav.name);
//        System.out.println(keshav.marks);
        keshav.changeName("keshav");
        keshav.greeting();
        rahul.changeName("rahul");
        rahul.greeting();
    }
    void greeting(){
        System.out.println("Good morning "+ name);
    }
    void changeName(String name){
        this.name = name;
    }
}
