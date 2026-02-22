package libreria;

import java.util.Scanner;
import libreria.models.Author;
import libreria.models.Client;
import libreria.models.Novel;
import libreria.models.TextBook;
import libreria.services.Bookstore;

/**
 * Clase principal. Gestiona la interactividad con el usuario.
 */
public class Main {

    private static Bookstore bookstore = new Bookstore();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        seedData(); // Cargar datos iniciales de prueba

        boolean running = true;
        while (running) {
            System.out.println("\n====== SISTEMA DE GESTIÓN DE LIBRERÍA ======");
            System.out.println("1. Ver catálogo de libros");
            System.out.println("2. Buscar libro por título");
            System.out.println("3. Buscar libro por autor");
            System.out.println("4. Registrar nueva venta");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            String option = scanner.nextLine();

            switch (option) {
                case "1":
                    bookstore.showCatalog();
                    break;
                case "2":
                    searchByTitle();
                    break;
                case "3":
                    searchByAuthor();
                    break;
                case "4":
                    processSale();
                    break;
                case "5":
                    running = false;
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }

    private static void searchByTitle() {
        System.out.print("Ingrese el título a buscar: ");
        String title = scanner.nextLine();
        var results = bookstore.searchBookByTitle(title);

        if (results.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            System.out.println("\n--- Resultados de Búsqueda ---");
            results.forEach(System.out::println);
        }
    }

    private static void searchByAuthor() {
        System.out.print("Ingrese el nombre del autor a buscar: ");
        String author = scanner.nextLine();
        var results = bookstore.searchBookByAuthor(author);

        if (results.isEmpty()) {
            System.out.println("No se encontraron libros de ese autor.");
        } else {
            System.out.println("\n--- Resultados de Búsqueda ---");
            results.forEach(System.out::println);
        }
    }

    private static void processSale() {
        System.out.println("\n--- Registrar Venta ---");
        System.out.print("Ingrese el ID del Cliente (Ej: C001, C002): ");
        String clientId = scanner.nextLine();
        System.out.print("Ingrese el ISBN del Libro a comprar: ");
        String isbn = scanner.nextLine();

        boolean success = bookstore.sellBook(isbn, clientId);
        if (success) {
            System.out.println("¡Venta registrada con éxito!");
            // Mostrar estado actualizado del cliente
            bookstore.findClientById(clientId).ifPresent(c
                    -> System.out.println("Estado actual del cliente: " + c)
            );
        } else {
            System.out.println("La venta no pudo ser procesada.");
        }
    }

    /**
     * Datos pre-cargados para que el sistema sea funcional inmediatamente.
     */
    private static void seedData() {
        // --- Autores ---
        Author tolkien = new Author("J.R.R. Tolkien", "Británica");
        Author baldor = new Author("Aurelio Baldor", "Cubana");
        Author hunt = new Author("Andy Hunt", "Estadounidense");
        Author thomas = new Author("Dave Thomas", "Británica");
        Author martin = new Author("Robert C. Martin", "Estadounidense");
        Author rowling = new Author("J.K. Rowling", "Británica");
        Author poe = new Author("Edgar Allan Poe", "Estadounidense");
        Author mendoza = new Author("Mario Mendoza", "Colombiana");

        // --- Libros Originales ---
        Novel lotr = new Novel("El Señor de los Anillos", "978-1", 25.50, 1954, 5, "Fantasía");
        lotr.addAuthor(tolkien);

        TextBook algebra = new TextBook("Álgebra de Baldor", "978-2", 30.00, 1941, 10, "Secundaria");
        algebra.addAuthor(baldor);

        // --- Desarrollo de Software (TextBooks) ---
        TextBook programadorPragmatico = new TextBook("El Programador Pragmático", "978-3", 45.50, 1999, 15, "Profesional");
        programadorPragmatico.addAuthor(hunt);
        programadorPragmatico.addAuthor(thomas);

        TextBook codigoLimpio = new TextBook("Código Limpio", "978-4", 50.00, 2008, 20, "Profesional");
        codigoLimpio.addAuthor(martin);

        TextBook arquitecturaLimpia = new TextBook("Arquitectura Limpia", "978-5", 55.00, 2017, 12, "Profesional");
        arquitecturaLimpia.addAuthor(martin);

        Novel hpPiedraFilosofal = new Novel("Harry Potter y la piedra filosofal", "978-6", 20.00, 1997, 50, "Fantasía Juvenil");
        hpPiedraFilosofal.addAuthor(rowling);

        Novel hpCamaraSecreta = new Novel("Harry Potter y la cámara secreta", "978-7", 22.00, 1998, 45, "Fantasía Juvenil");
        hpCamaraSecreta.addAuthor(rowling);

        Novel hpPrisioneroAzkaban = new Novel("Harry Potter y el prisionero de Azkaban", "978-8", 24.00, 1999, 40, "Fantasía Juvenil");
        hpPrisioneroAzkaban.addAuthor(rowling);

        Novel hpCalizFuego = new Novel("Harry Potter y el cáliz de fuego", "978-9", 25.00, 2000, 35, "Fantasía Juvenil");
        hpCalizFuego.addAuthor(rowling);

        Novel hpOrdenFenix = new Novel("Harry Potter y la Orden del Fénix", "978-10", 28.00, 2003, 30, "Fantasía Juvenil");
        hpOrdenFenix.addAuthor(rowling);

        Novel hpMisterioPrincipe = new Novel("Harry Potter y el misterio del príncipe", "978-11", 26.00, 2005, 30, "Fantasía Juvenil");
        hpMisterioPrincipe.addAuthor(rowling);

        Novel hpReliquiasMuerte = new Novel("Harry Potter y las reliquias de la Muerte", "978-12", 29.00, 2007, 30, "Fantasía Juvenil");
        hpReliquiasMuerte.addAuthor(rowling);

        // --- Cuentos de Edgar Allan Poe (Novels) ---
        Novel cuentosPoe = new Novel("Cuentos Completos", "978-13", 18.00, 1845, 25, "Terror / Gótico");
        cuentosPoe.addAuthor(poe);

        // --- Libros de Mario Mendoza (Novels) ---
        Novel satanas = new Novel("Satanás", "978-14", 21.00, 2002, 18, "Ficción Contemporánea");
        satanas.addAuthor(mendoza);

        Novel scorpioCity = new Novel("Scorpio City", "978-15", 19.00, 1998, 10, "Novela Negra");
        scorpioCity.addAuthor(mendoza);

        Novel budaBlues = new Novel("Buda Blues", "978-16", 20.00, 2009, 12, "Ficción Contemporánea");
        budaBlues.addAuthor(mendoza);

        Novel ladyMasacre = new Novel("Lady Masacre", "978-17", 22.50, 2013, 15, "Novela Negra");
        ladyMasacre.addAuthor(mendoza);

        // ==========================================================
        // ¡ESTO ES LO QUE FALTABA! AGREGAR TODO AL SISTEMA
        // ==========================================================
        // 1. Agregar los libros al catálogo de la librería
        bookstore.addBook(lotr);
        bookstore.addBook(algebra);
        bookstore.addBook(programadorPragmatico);
        bookstore.addBook(codigoLimpio);
        bookstore.addBook(arquitecturaLimpia);
        bookstore.addBook(hpPiedraFilosofal);
        bookstore.addBook(hpCamaraSecreta);
        bookstore.addBook(hpPrisioneroAzkaban);
        bookstore.addBook(hpCalizFuego);
        bookstore.addBook(hpOrdenFenix);
        bookstore.addBook(hpMisterioPrincipe);
        bookstore.addBook(hpReliquiasMuerte);
        bookstore.addBook(cuentosPoe);
        bookstore.addBook(satanas);
        bookstore.addBook(scorpioCity);
        bookstore.addBook(budaBlues);
        bookstore.addBook(ladyMasacre);

        // 2. Crear y registrar clientes de prueba para poder realizar ventas
        Client client1 = new Client("C001", "Felipe Hernandez");
        Client client2 = new Client("C002", "Javier Diaz");

        bookstore.registerClient(client1);
        bookstore.registerClient(client2);
    }
}
