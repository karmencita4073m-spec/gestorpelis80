import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GestorBiblioteca {
    private final ConexionDB cx = new ConexionDB();

    public void crearBaseYCargarDatos() {
        try (Connection c = cx.conectar();
             Statement st = c.createStatement()) {

            st.execute("CREATE TABLE IF NOT EXISTS franquicias (" +
                    "id INT PRIMARY KEY, nombre VARCHAR(100))");
            st.execute("CREATE TABLE IF NOT EXISTS directores (" +
                    "id INT PRIMARY KEY, nombre VARCHAR(100))");
            st.execute("CREATE TABLE IF NOT EXISTS peliculas (" +
                    "id INT PRIMARY KEY, titulo VARCHAR(150), anio INT, " +
                    "id_franquicia INT, id_director INT)");
            st.execute("CREATE TABLE IF NOT EXISTS actores (" +
                    "id INT PRIMARY KEY, nombre VARCHAR(100))");
            st.execute("CREATE TABLE IF NOT EXISTS reparto (" +
                    "id_pelicula INT, id_actor INT)");

            st.execute("INSERT INTO franquicias VALUES (1,'Superman'),(2,'Regreso al Futuro')");
            st.execute("INSERT INTO directores VALUES (1,'Richard Donner'),(4,'Robert Zemeckis')");
            st.execute("INSERT INTO peliculas VALUES " +
                    "(1, 'Superman: La película',1978,1,1)," +
                    "(2, 'Superman II',1980,1,1)," +
                    "(3, 'Superman III',1983,1,1)," +
                    "(4, 'Superman IV',1987,1,1)," +
                    "(5, 'Regreso al Futuro',1985,2,4)," +
                    "(6, 'Regreso al Futuro II',1989,2,4)," +
                    "(7, 'Regreso al Futuro III',1990,2,4)");

        } catch (SQLException e) {
            System.out.println("No se pudieron crear las tablas o cargar los datos");
            e.printStackTrace();
        }
    }

    public void mostrarTotalPeliculas() {
        try (Connection c = cx.conectar();
             Statement st = c.createStatement()) {

            String consulta = "SELECT p.id, p.titulo, p.anio, f.nombre " +
                    "FROM peliculas p " +
                    "JOIN franquicias f ON p.id_franquicia = f.id";

            ResultSet rs = st.executeQuery(consulta);
            System.out.println("\nCatálogo de películas disponibles:");

            while (rs.next()) {
                System.out.printf("%d- %s (%d) | Franquicia: %s%n",
                        rs.getInt("id"),
                        rs.getString("titulo"),
                        rs.getInt("anio"),
                        rs.getString("nombre"));
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar el listado");
            e.printStackTrace();
        }
    }

    public void contarPeliculas() {
        try (Connection c = cx.conectar();
             Statement st = c.createStatement()) {

            ResultSet rs = st.executeQuery("SELECT COUNT(*) total FROM peliculas");
            if (rs.next()) {
                System.out.println("\nTotal de películas guardadas: " + rs.getInt("total"));
            }
        } catch (SQLException e) {
            System.out.println("No se pudo contar las películas");
            e.printStackTrace();
        }
    }
}