import java.util.HashSet;
import java.util.Objects;

public class StudentDemo {
    static class Student {
        private int rollNo;
        private String name;

        public Student(int rollNo, String name) {
            this.rollNo = rollNo;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return rollNo == student.rollNo;
        }

        @Override
        public int hashCode() {
            return Objects.hash(rollNo);
        }

        @Override
        public String toString() {
            return "Student{" + "rollNo=" + rollNo + ", name='" + name + "'}";
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student(1, "Alice");
        Student s2 = new Student(1, "Alicia");
        Student s3 = new Student(2, "Bob");

        HashSet<Student> set = new HashSet<>();
        set.add(s1);
        set.add(s2); // duplicate rollNo -> should not be added
        set.add(s3);

        System.out.println("HashSet contents:");
        for (Student s : set) {
            System.out.println(s);
        }
    }
}