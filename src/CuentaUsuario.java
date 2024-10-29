import java.util.ArrayList;

public class CuentaUsuario {
    private String nombreUsuario;
    private String password;
    private Plan plan;
    private boolean pagado;

    public CuentaUsuario(String nombreUsuario, String password, Plan plan) throws CuentaExistenteException {
        if (nombreUsuario == null || nombreUsuario.isEmpty()) {
            throw new IllegalArgumentException("El nombre del usuario no puede estar vacio");
        }
        if (password.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe de tener al menos 8 caracteres");
        }
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.plan = plan;
        this.pagado = false; // Al principio solamente se crea la cuenta
    }

    public void pagarSuscripcion() throws CuentaYaPagadaException {
        if (pagado) {
            throw new CuentaYaPagadaException("La suscripcion ya esta pagada");
        }
        this.pagado = true;
        System.out.println("Suscripcion pagada correctamente");
    }

    public void verPeliculas(ArrayList<Pelicula> peliculas) throws CuentaNoPagadaException {
        if (!pagado) {
            throw new CuentaNoPagadaException("Debe de pagar la suscripción antes de ver Peliculas");
        }
        System.out.println("\n ----Lista de Peliculas-----");
        for (Pelicula pelicula : peliculas) {
            System.out.println(pelicula);
        }
    }

    public void cancelarSuscripciones() {
        this.pagado = false;
        System.out.println("Membresia cancelada");
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public boolean isPagado() {
        return pagado;
    }
}
