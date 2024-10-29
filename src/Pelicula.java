public class Pelicula {
    private String titulo;
    private String genero;
    private int year;

    public Pelicula(String titulo, String genero, int year) {
        this.titulo = titulo;
        this.genero = genero;
        this.year = year;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", year=" + year +
                '}';
    }
}
