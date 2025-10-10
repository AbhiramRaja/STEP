public class ContactInfo implements Cloneable {
    String email;
    String phone;

    public ContactInfo(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    @Override
    protected ContactInfo clone() {
        try {
            return (ContactInfo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return "ContactInfo{" + "email='" + email + '\'' + ", phone='" + phone + '\'' + '}';
    }
}