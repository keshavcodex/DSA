package oops.generics.comparing;

public class Student implements Comparable<Student>{
    private int rollNo;
    public float marks;

    public Student(int rollNo, float marks) {
        this.rollNo = rollNo;
        this.marks = marks;
    }

    @Override
    public int compareTo(Student o) {
        int diff = (int)(this.marks - o.marks);
        //if diff == 0: means both are equal
        //if diff < 0: means o is bigger else o is smaller
        return diff;
    }

    @Override
    public String toString() {
        return "marks: " + marks;
    }
}
