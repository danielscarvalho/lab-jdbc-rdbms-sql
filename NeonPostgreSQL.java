import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// JDBC Driver PostgreSQL: https://jdbc.postgresql.org/download/
// https://neon.com/ - PostgreSQL Neon Cloud
// https://jdbc.postgresql.org/documentation/

public class NeonPostgreSQL {

    private static String JDBC_URL;

    public static void main(String[] args) {
        
        try {
            JDBC_URL = System.getenv("neon_postgresql_url");
        } catch (Exception e) {
        } //try
        
        System.out.println("Conectando ao banco de dados Neon PostgreSQL...\n");

        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {

            // SELECT version()
            try (ResultSet rs = stmt.executeQuery("SELECT version()")) {
                if (rs.next()) {
                    System.out.println("version():");
                    System.out.println("  " + rs.getString(1));
                } //if
            } //try

            System.out.println();

            // SELECT now()
            try (ResultSet rs = stmt.executeQuery("SELECT now()")) {
                if (rs.next()) {
                    System.out.println("now():");
                    System.out.println("  " + rs.getString(1));
                } //if
            } //try

        } catch (Exception e) {
            System.err.println("Erro ao conectar ou executar query: " + e.getMessage());
            e.printStackTrace();
        } finnaly {
           stmt.close();
           conn.close();
        }//try
    } // main
} // NeonPostgreSQL
