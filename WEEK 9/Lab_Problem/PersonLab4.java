public class PersonLab4 {
    static class Address implements Cloneable {
        String street;
        String city;

        public Address(String street, String city) {
            this.street = street;
            this.city = city;
        }

        @Override
        protected Address clone() {
            try {
                return (Address) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        @Override
        public String toString() {
            return "Address{" + "street='" + street + '\'' + ", city='" + city + '\'' + '}';
        }
    }

    static class Person implements Cloneable {
        String name;
        Address address;

        public Person(String name, Address address) {
            this.name = name;
            this.address = address;
        }

        // shallow clone
        @Override
        protected Person clone() {
            try {
                return (Person) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        // deep clone
        protected Person deepClone() {
            Address addrClone = this.address.clone();
            return new Person(this.name, addrClone);
        }

        @Override
        public String toString() {
            return "Person{" + "name='" + name + '\'' + ", address=" + address + '}';
        }
    }

    public static void main(String[] args) {
        Address a = new Address("221B Baker Street", "London");
        Person original = new Person("Sherlock", a);

        Person shallow = original.clone();
        Person deep = original.deepClone();

        System.out.println("Before changes:");
        System.out.println("Original: " + original);
        System.out.println("Shallow: " + shallow);
        System.out.println("Deep: " + deep);

        // modify address in shallow clone
        shallow.address.city = "Oxford";

        System.out.println("\nAfter modifying shallow.address.city to Oxford:");
        System.out.println("Original: " + original);
        System.out.println("Shallow: " + shallow);
        System.out.println("Deep: " + deep);

        // modify deep clone address
        deep.address.city = "Cambridge";
        System.out.println("\nAfter modifying deep.address.city to Cambridge:");
        System.out.println("Original: " + original);
        System.out.println("Deep: " + deep);
    }
}