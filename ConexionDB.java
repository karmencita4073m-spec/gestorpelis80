import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static final String URL = "jdbc:h2:file:./datos/biblioteca;DB_CLOSE_ON_EXIT=FALSE";
    public static final String USER = "sa";
    public static final String PASS = "";

    public Connection conectar() throws SQLException {
        Connection conn = null;
        try {
            Class.forName("org.h2.Driver");
            conn = DriverManager.getConnection(URL, USER, PASS);
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontró el driver H2: " + e.getMessage());
            throw new SQLException("Driver no disponible", e);
        }
    }

    public void cerrar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar: " + e.getMessage());
        }
    }
}