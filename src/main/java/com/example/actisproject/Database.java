package com.example.actisproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.*;

public class Database {
    /* default připojení k db
    String url = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement()) {

        } catch (SQLException e) {
            e.printStackTrace();
        }
     */
    public static String personProps = "(name ,surname ,age ,birthday, gender)";
    public static void CreateDatabase() {
        String url = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE DATABASE testdb;");
            //System.out.println("Databáze úspěšně vytvořena. Tvorba tablu: ");
            String sql = "DROP DATABASE testdb;";
            statement.executeUpdate(sql);
            statement.executeUpdate("CREATE TABLE person (name VARCHAR(30),surname VARCHAR(30),age INT,birthday DATE, gender BOOLEAN);"); //muž je pravda, žena je nepravda
            //System.out.println("Table úspěšně vytvořen. Vložení hodnot:");
            statement.execute("INSERT INTO person " + personProps + " VALUES ('Jiri', 'Boruvka', 24, '2000-02-27', true);");
            statement.execute("INSERT INTO person " + personProps + " VALUES ('Martin', 'Zeleny', 31, '1992-09-11', true);");
            //System.out.println("Lidé úspěšně přidáni do databáze.");
            System.out.println("Databáze s hodnotami úspěšně vytvořena.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void addPerson(String name, String surname, Integer age, Date birthday, Boolean gender){
        String url = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement()) {
            String command = "INSERT INTO person " + personProps + " VALUES ('" + name + "', '" + surname + "', '" + age + "', '" + birthday + "', '" + gender + "');";
            System.out.println("Člověk: " + name + " byl úspěšně přidán do databáze.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void DropDatabase() {
        String url = "jdbc:postgresql://localhost:5432/";
        String username = "postgres";
        String password = "12345";

        try (Connection connection = DriverManager.getConnection(url, username, password); Statement statement = connection.createStatement()) {
            statement.execute("DROP TABLE person");
            statement.execute("DROP DATABASE testdb;");
            System.out.println("Databáze úspěšně dropnuta!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String get(){ //dá ve stupidním formátu všechny hodnoty
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
        }catch (SQLException ignored) {
            System.out.println("posrar :3");
            return "bububu";
        }
    }

}