package libreria.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase abstracta que define el contrato base para cualquier tipo de libro.
 * Aplica el principio Abierto/Cerrado (OCP) permitiendo extender nuevos tipos
 * de libros.
 */
public abstract class Book {

    private String title;
    private String isbn;
    private double price;
    private int publicationYear;
    private List<Author> authors;
    private int stock; // Representa la disponibilidad

    public Book(String title, String isbn, double price, int publicationYear, int stock) {
        if (price < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo.");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("El stock no puede ser negativo.");
        }

        this.title = title;
        this.isbn = isbn;
        this.price = price;
        this.publicationYear = publicationYear;
        this.stock = stock;
        this.authors = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        if (author != null && !authors.contains(author)) {
            this.authors.add(author);
        }
    }

    public boolean isAvailable() {
        return this.stock > 0;
    }

    public void decreaseStock() {
        if (isAvailable()) {
            this.stock--;
        } else {
            throw new IllegalStateException("El libro no tiene stock disponible.");
        }
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getIsbn() {
        return isbn;
    }

    public double getPrice() {
        return price;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public List<Author> getAuthors() {
        return new ArrayList<>(authors);
    } // Retorna copia para inmutabilidad

    public int getStock() {
        return stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    @Override
    public String toString() {
        return String.format("ISBN: %s | Título: '%s' | Año: %d | Precio: $%.2f | Stock: %d",
                isbn, title, publicationYear, price, stock);
    }
}
