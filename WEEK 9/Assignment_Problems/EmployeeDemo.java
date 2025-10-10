public class EmployeeDemo {
    static class Employee {
        private int id;
        private String name;
        private double salary;

        public Employee(int id, String name, double salary) {
            this.id = id;
            this.name = name;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee(1, "Alice", 50000);
        Employee e2 = new Employee(2, "Bob", 60000);
        Employee e3 = new Employee(3, "Charlie", 55000);

        System.out.println(e1.toString());
        System.out.println(e2);
        System.out.println(e3);

        System.out.println("Class name of e1: " + e1.getClass().getName());
        System.out.println("Class name of e2: " + e2.getClass().getName());
    }
}