public class VehicleRental {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Sedan", 1500);
        System.out.println(v1);
        System.out.println("Class: " + v1.getClass().getName());

        Vehicle v2 = new Vehicle("MH12CD5678", "SUV", 2500);
        System.out.println(v2);
        System.out.println("v1 == v2: " + (v1 == v2));
        System.out.println("v1.equals(v2): " + v1.equals(v2));
    }
}