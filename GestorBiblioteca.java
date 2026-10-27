import java.sql.Connection;
import.java.sql.Statement;
import java.SQLException;
public class GestotBiblioteca {
    private final ConexionDB cx = new ConexionDb();
    public void crearBaseYCargarDatos() {
        try (Connection c = cx.conectar();
             Statement st = c.createStatement() {

                 st.execute("DROP TABLE IF EXISTS  PELICULA;");
                 st.execute("DROP TABLE IF EXISTS GENERO;");
            st.execute("DROP TABLE IF EXISTS DIRECTOR;");
            st.execute("DROP TABLE IF EXISTS ACTORRES Y PERSONAJES PRINCIPALEE;")




            st.execute("CREATE TABLE IF EXISTS GENERO (" + " id categoria INT PRIMARY KEY AUTO_INCREMENT," +
                    "nombre VARCHAR(50) NOT NULL,descripcion VARCHAR(200));");
            st.execute("CREATE TABLE IF EXISTS DIRECTOR (" + " id autor INT PRIMARY KEY AUTO_INCREMENT," +
                    "nombre VARCHAR(50) NOT NULL,apellido VARCHAR(200));");
            st.execute("CREATE TABLE IF EXITS PELICULA (" + " id autor INT PRIMARY KEY AUTO_INCREMENT," +
                    "nombre VARCHAR(50) NOT NULL,apellido VARCHAR(200));");

            st.execute("CREATE TABLE IF EXISTS ACTORES Y PERSONAJES PRINCIPALES(" + " id autor INT PRIMARY KEY AUTO_INCREMENT," +
                    "nombre VARCHAR(50) NOT NULL,apellido VARCHAR(200));");





        }





    }






}