import java.util.HashSet;

public class EmployeeAuth {
    public static void main(String[] args) {
        Employee e1 = new Employee("BL001", "Ritika");
        Employee e2 = new Employee("BL001", "Ritika S.");
        Employee e3 = new Employee("BL002", "Rahul");

        System.out.println("e1 == e2: " + (e1 == e2));
        System.out.println("e1.equals(e2): " + e1.equals(e2));

        HashSet<Employee> set = new HashSet<>();
        set.add(e1);
        set.add(e2);
        set.add(e3);

        System.out.println("HashSet contents:");
        for (Employee e : set) System.out.println(e);
    }
}