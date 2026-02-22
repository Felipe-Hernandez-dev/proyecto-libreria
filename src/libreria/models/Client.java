package libreria.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Representa un Cliente de la librería.
 */
public class Client {

    private String id;
    private String name;
    private List<Book> purchasedBooks;

    public Client(String id, String name) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID no válido.");
        }
        this.id = id;
        this.name = name;
        this.purchasedBooks = new ArrayList<>();
    }

    public void addPurchasedBook(Book book) {
        if (book != null) {
            this.purchasedBooks.add(book);
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Retorna una copia para proteger la encapsulación (Pragmatic Programmer)
    public List<Book> getPurchasedBooks() {
        return new ArrayList<>(purchasedBooks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Client client = (Client) o;
        return Objects.equals(id, client.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Cliente [" + id + "] " + name + " | Libros comprados: " + purchasedBooks.size();
    }
}
