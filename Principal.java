public class Principal {
    public static void main(String[] args) {
        GestorBiblioteca gb = new GestorBiblioteca();
        gb.crearBaseYCargarDatos();
        gb.mostrarTotalPeliculas();
        gb.contarPeliculas();
    }
}