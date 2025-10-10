import java.util.ArrayList;
import java.util.List;

public class LibraryDemo {
    static class Book implements Cloneable {
        String title;
        String author;

        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        @Override
        protected Book clone() {
            try {
                return (Book) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }

        @Override
        public String toString() {
            return "Book{" + "title='" + title + '\'' + ", author='" + author + '\'' + '}';
        }
    }

    static class Library implements Cloneable {
        List<Book> books = new ArrayList<>();

        public Library() {}

        public void addBook(Book b) {
            books.add(b);
        }

        // shallow clone: copies the list reference (but we'll demonstrate both below)
        @Override
        protected Library clone() throws CloneNotSupportedException {
            Library cloned = (Library) super.clone();
            // shallow: share same book list reference
            cloned.books = this.books;
            return cloned;
        }

        public Library deepClone() {
            Library cloned = new Library();
            for (Book b : this.books) {
                cloned.books.add(b.clone());
            }
            return cloned;
        }

        @Override
        public String toString() {
            return "Library{" + "books=" + books + '}';
        }
    }

    public static void main(String[] args) throws Exception {
        Library lib = new Library();
        lib.addBook(new Book("1984", "George Orwell"));
        lib.addBook(new Book("Brave New World", "Aldous Huxley"));

        Library shallow = lib.clone();
        Library deep = lib.deepClone();

        System.out.println("Before modification:");
        System.out.println("Original: " + lib);
        System.out.println("Shallow: " + shallow);
        System.out.println("Deep: " + deep);

        // modify a book in shallow clone
        shallow.books.get(0).title = "Nineteen Eighty-Four (modified)";

        System.out.println("\nAfter modifying shallow clone:");
        System.out.println("Original: " + lib);
        System.out.println("Shallow: " + shallow);
        System.out.println("Deep: " + deep);

        // modify a book in deep clone
        deep.books.get(1).title = "Brave New World (modified)";
        System.out.println("\nAfter modifying deep clone:");
        System.out.println("Original: " + lib);
        System.out.println("Deep: " + deep);
    }
}