package libreria.models;

import java.util.Objects;

/**
 * Representa a un autor en el sistema. Cumple con el principio de
 * Responsabilidad Única (SRP) al solo manejar los datos del autor.
 */
public class Author {

    private String name;
    private String nationality;

    public Author(String name, String nationality) {
        // Validaciones Fail-Fast (Programador Pragmático)
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor no puede estar vacío.");
        }
        this.name = name;
        this.nationality = nationality;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Author author = (Author) o;
        return Objects.equals(name, author.name) && Objects.equals(nationality, author.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, nationality);
    }

    @Override
    public String toString() {
        return name + " (" + nationality + ")";
    }
}
