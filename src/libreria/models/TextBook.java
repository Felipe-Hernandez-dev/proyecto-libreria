package libreria.models;

/**
 * Entidad que representa un Libro de Texto. Hereda de Book (Herencia -
 * Reutilización de código).
 */
public class TextBook extends Book {

    private String educationalLevel;

    public TextBook(String title, String isbn, double price, int publicationYear, int stock, String educationalLevel) {
        super(title, isbn, price, publicationYear, stock);
        if (educationalLevel == null || educationalLevel.trim().isEmpty()) {
            throw new IllegalArgumentException("El nivel educativo es obligatorio.");
        }
        this.educationalLevel = educationalLevel;
    }

    public String getEducationalLevel() {
        return educationalLevel;
    }

    @Override
    public String toString() {
        return super.toString() + " | Tipo: Texto | Nivel: " + educationalLevel;
    }
}
