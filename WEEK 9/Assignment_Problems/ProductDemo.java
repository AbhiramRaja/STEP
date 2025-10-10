public class ProductDemo {
    static class Product {
        private int productId;
        private String productName;

        public Product(int productId, String productName) {
            this.productId = productId;
            this.productName = productName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Product product = (Product) o;
            return productId == product.productId;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(productId);
        }
    }

    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop");
        Product p2 = new Product(101, "Laptop");
        Product p3 = p1;

        System.out.println("p1 == p2: " + (p1 == p2));
        System.out.println("p1.equals(p2): " + p1.equals(p2));
        System.out.println("p1 == p3: " + (p1 == p3));
    }
}