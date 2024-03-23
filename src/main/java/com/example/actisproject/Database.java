package com.example.actisproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;

public class Database {
    public static void CreateDatabase() {
        String url = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            String sql = "DROP DATABASE testdb;";
            statement.executeUpdate(sql);
            sql = "CREATE DATABASE testdb;";
            statement.executeUpdate(sql);
            System.out.println("Databáze úspěšně vytvořena. Tvorba tablu: ");
            String personProps = "(name ,surname ,age ,birthday)";
            statement.execute("DROP TABLE person");
            statement.executeUpdate("CREATE TABLE person (name VARCHAR(30),surname VARCHAR(30),age INT,birthday DATE);");
            System.out.println("Table úspěšně vytvořen. Vložení hodnot:");
            statement.execute("INSERT INTO person " + personProps + " VALUES ('Jiri', 'Boruvka', 24, '2000-02-27');");
            statement.execute("INSERT INTO person " + personProps + " VALUES ('Martin', 'Zeleny', 31, '1992-09-11');");
            System.out.println("Lidé úspěšně přidáni do databáze.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String databaseGet(){
        System.out.println("g");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "12345"); Statement statement = connection.createStatement()) {
            String command = "SELECT * FROM person;";
            System.out.println(statement.enquoteLiteral(command));

            final ResultSet rs = statement.executeQuery(command);
//https://stackoverflow.com/questions/52361300/java-spring-boot-postgresql-with-hikaricp-get-raw-string-output-from-statement
            StringBuilder sb = new StringBuilder();
            int columns = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                int row = rs.getRow();//přidává na začátek řádku číslo samotného řádku
                sb.append(rs.getRow()).append(";");
                for (int i = 1 ; i <= columns ; i++) {
                    sb.append(rs.getObject(i)).append('|');
                }
            }
            return sb.toString();

            //return String.format("%s",statement.execute(command));
        }catch (SQLException ignored) {
            System.out.println("posrar :3");
            return "bububu";
        }
    }

    /*@GetMapping("/database")
    public String databasePull(@RequestParam(value = "dbname", defaultValue = "testdb") String dbname) {
        System.out.println("g");
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/", "postgres", "12345"); Statement statement = connection.createStatement()) {
            String command = "SELECT * FROM person;";
            System.out.println(statement.execute(command));
            return String.format("%s",statement.execute(command));
        }catch (SQLException ignored) {
            System.out.println("bububu");
            return "bububu";
        }
    }*/
}