public class OuterLab5 {
    private String message;

    public OuterLab5(String message) {
        this.message = message;
    }

    class Inner {
        public void display() {
            System.out.println("Message from outer: " + message);
        }
    }

    public static void main(String[] args) {
        OuterLab5 outer = new OuterLab5("Hello from Outer class!");
        OuterLab5.Inner inner = outer.new Inner();
        inner.display();
    }
}