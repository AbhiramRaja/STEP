public class BookLab1 {
    static class Book {
        private String title;
        private String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Book book = (Book) o;
            return title.equals(book.title) && author.equals(book.author);
        }

        @Override
        public int hashCode() {
            return java.util.Objects.hash(title, author);
        }

        @Override
        public String toString() {
            return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + '}';
        }
    }

    public static void main(String[] args) {
        Book b1 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book b2 = new Book("The Hobbit", "J.R.R. Tolkien");
        Book b3 = b1;

        System.out.println("b1 == b2: " + (b1 == b2));
        System.out.println("b1.equals(b2): " + b1.equals(b2));
        System.out.println("b1 == b3: " + (b1 == b3));

        System.out.println("b1: " + b1);
        System.out.println("b2: " + b2);
    }
}