package libreria.models;

/**
 * Entidad que representa una Novela. Hereda de Book.
 */
public class Novel extends Book {

    private String genre;

    public Novel(String title, String isbn, double price, int publicationYear, int stock, String genre) {
        super(title, isbn, price, publicationYear, stock);
        if (genre == null || genre.trim().isEmpty()) {
            throw new IllegalArgumentException("El género es obligatorio.");
        }
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Novela | Género: " + genre;
    }
}
