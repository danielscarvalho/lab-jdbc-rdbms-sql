import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

// JDBC Driver PostgreSQL: https://jdbc.postgresql.org/download/

public class LegoSets {

    private static String JDBC_URL;

    public static void main(String[] args) {
        
        try {
            JDBC_URL = System.getenv("neon_postgresql_url");
        } catch (Exception e) {
        } //try
        
        System.out.println("Conectando ao banco de dados Neon PostgreSQL...\n");

        try (Connection conn = DriverManager.getConnection(JDBC_URL);
             Statement stmt = conn.createStatement()) {

            // SELECT lego_sets
            try (ResultSet rs = stmt.executeQuery("SELECT * from lego_sets")) {
                while (rs.next()) {
                    
                    System.out.println(rs.getString(1) +
                                       ";" +
                                       rs.getString(2)  +
                                       ";" +
                                       rs.getString(3) );

                } //while
            } //try

            System.out.println();

        } catch (Exception e) {
            System.err.println("Erro ao conectar ou executar query: " + e.getMessage());
            e.printStackTrace();
        } //try
    } // main
} // NeonPostgreSQL
