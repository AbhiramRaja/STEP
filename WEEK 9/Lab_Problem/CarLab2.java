public class CarLab2 {
    static class Car {
        private String brand;
        private String model;
        private double price;

        public Car(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Car{" + "brand='" + brand + '\'' + ", model='" + model + '\'' + ", price=" + price + '}';
        }
    }

    public static void main(String[] args) {
        Car c = new Car("Toyota", "Corolla", 23000);
        System.out.println(c); // invokes toString()
        System.out.println("Class name: " + c.getClass().getName());
    }
}