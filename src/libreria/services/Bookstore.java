package libreria.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import libreria.models.Book;
import libreria.models.Client;

/**
 * Clase servicio que gestiona la lógica principal de la librería. Centraliza
 * las operaciones (Alta Cohesión).
 */
public class Bookstore {

    private List<Book> catalog;
    private List<Client> clients;

    public Bookstore() {
        this.catalog = new ArrayList<>();
        this.clients = new ArrayList<>();
    }

    public void addBook(Book book) {
        if (book != null && !catalog.contains(book)) {
            catalog.add(book);
        }
    }

    public void registerClient(Client client) {
        if (client != null && !clients.contains(client)) {
            clients.add(client);
        }
    }

    // Uso de Streams para búsquedas limpias y eficientes (Clean Code)
    public List<Book> searchBookByTitle(String title) {
        return catalog.stream()
                .filter(b -> b.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    public List<Book> searchBookByAuthor(String authorName) {
        return catalog.stream()
                .filter(b -> b.getAuthors().stream()
                .anyMatch(a -> a.getName().toLowerCase().contains(authorName.toLowerCase())))
                .collect(Collectors.toList());
    }

    public Optional<Client> findClientById(String id) {
        return clients.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst();
    }

    public Optional<Book> findBookByIsbn(String isbn) {
        return catalog.stream()
                .filter(b -> b.getIsbn().equals(isbn))
                .findFirst();
    }

    /**
     * Vende un libro a un cliente. Actualiza disponibilidad y la lista del
     * cliente.
     */
    public boolean sellBook(String isbn, String clientId) {
        Optional<Book> bookOpt = findBookByIsbn(isbn);
        Optional<Client> clientOpt = findClientById(clientId);

        if (bookOpt.isPresent() && clientOpt.isPresent()) {
            Book book = bookOpt.get();
            Client client = clientOpt.get();

            if (book.isAvailable()) {
                book.decreaseStock();
                client.addPurchasedBook(book);
                return true;
            } else {
                System.out.println("Error: El libro está agotado.");
                return false;
            }
        }
        System.out.println("Error: Libro o Cliente no encontrado.");
        return false;
    }

    public void showCatalog() {
        System.out.println("\n--- Catálogo de la Librería ---");
        printBooksTable(catalog);
    }

    /**
     * Imprime una lista de libros en un formato de tabla.
     */
    public void printBooksTable(List<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No hay libros para mostrar.");
            return;
        }

        // 1. Imprimir la cabecera de la tabla con anchos fijos
        System.out.printf("%-7s | %-40s | %-25s | %-4s | %-8s | %-5s | %-25s%n",
                "ISBN", "TÍTULO", "AUTOR(ES)", "AÑO", "PRECIO", "STOCK", "TIPO / DETALLE");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");

        // 2. Iterar e imprimir cada fila alineada
        for (Book book : books) {
            // Unir múltiples autores con comas
            String authors = book.getAuthors().stream()
                    .map(a -> a.getName())
                    .collect(Collectors.joining(", "));
            // Truncar textos largos para que no rompan la tabla
            if (authors.length() > 25) {
                authors = authors.substring(0, 22) + "...";
            }

            String title = book.getTitle();
            if (title.length() > 40) {
                title = title.substring(0, 37) + "...";
            }

            // Obtener el detalle específico según la clase hija (Polimorfismo / InstanceOf)
            String detail = "General";
            if (book instanceof libreria.models.Novel) {
                detail = "Novela (" + ((libreria.models.Novel) book).getGenre() + ")";
            } else if (book instanceof libreria.models.TextBook) {
                detail = "Texto (" + ((libreria.models.TextBook) book).getEducationalLevel() + ")";
            }

            // Imprimir la fila formateada
            System.out.printf("%-7s | %-40s | %-25s | %-4d | $%7.2f | %-5d | %-25s%n",
                    book.getIsbn(), title, authors, book.getPublicationYear(), book.getPrice(), book.getStock(), detail);
        }
    }
}
