public class StudentRegistration {
    static class Student implements Cloneable {
        String id;
        String name;
        ContactInfo contact;

        public Student(String id, String name, ContactInfo contact) {
            this.id = id;
            this.name = name;
            this.contact = contact;
        }

        // shallow clone
        @Override
        protected Student clone() {
            try {
                return (Student) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        // deep clone
        protected Student deepClone() {
            ContactInfo c = this.contact.clone();
            return new Student(this.id, this.name, c);
        }

        @Override
        public String toString() {
            return "Student{" + "id='" + id + '\'' + ", name='" + name + '\'' + ", contact=" + contact + '}';
        }
    }

    public static void main(String[] args) {
        ContactInfo ci = new ContactInfo("alice@example.com", "1234567890");
        Student original = new Student("S01", "Alice", ci);

        Student shallow = original.clone();
        Student deep = original.deepClone();

        System.out.println("Before changes:");
        System.out.println(original);
        System.out.println(shallow);
        System.out.println(deep);

        // modify shallow's contact
        shallow.contact.email = "alice+shallow@example.com";
        System.out.println("\nAfter modifying shallow.contact.email:");
        System.out.println(original);
        System.out.println(shallow);
        System.out.println(deep);
    }
}