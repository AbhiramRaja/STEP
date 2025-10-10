public class Employee {
    private String empCode;
    private String name;

    public Employee(String empCode, String name) {
        this.empCode = empCode;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return empCode != null ? empCode.equals(employee.empCode) : employee.empCode == null;
    }

    @Override
    public int hashCode() {
        return empCode != null ? empCode.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Employee{" + "empCode='" + empCode + '\'' + ", name='" + name + '\'' + '}';
    }

    public String getEmpCode() { return empCode; }
    public String getName() { return name; }
}