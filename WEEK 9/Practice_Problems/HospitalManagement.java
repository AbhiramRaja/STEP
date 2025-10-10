public class HospitalManagement {
    public static void main(String[] args) {
        Hospital hosp = new Hospital("City Hospital");
        Hospital.Department d1 = hosp.createDepartment("Emergency");
        Hospital.Department d2 = hosp.createDepartment("Cardiology");

        d1.display();
        d2.display();
    }
}