/**
 * Week 14 - Java DB
 *
 * This program executes various SQL queries.
 * The database is created from "Week 14 DB.sql"
 *
 * @author Florin
 */

import java.sql.*;
import java.util.Scanner;

public class JavaDB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("----------------------------------------");
            System.out.println("[1] First query\n" +
                    "[2] Second query\n" +
                    "[3] Third query\n" +
                    "[4] Fourth query\n" +
                    "[5] Fifth query\n" +
                    "[6] Exit");
            System.out.println("----------------------------------------");

            int tempChoice = sc.nextInt();
            choice = tempChoice;

            switch (choice){
                case 1:
                    displayClasses();
                    enterToContinue();
                    break;
                case 2:
                    displayClassesByID();
                    enterToContinue();
                    break;
                case 3:
                    displayCoursesIntro();
                    enterToContinue();
                    break;
                case 4:
                    displayClassesByDeptAndNumber();
                    enterToContinue();
                    break;
                case 5:
                    displayClassesByProfName();
                    enterToContinue();
                    break;
                case 6:
                    System.out.println("Exiting Program...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong input!");
                    enterToContinue();
                    break;
            }
        } while (choice != 6);
    }

    public static void enterToContinue(){
        System.out.println("Press Enter to continue...");
        try{System.in.read();}
        catch(Exception e){}

    }

    public static void displayClassesByProfName() {
        Connection conn = getConnection("mysql", "localhost", "3306", "schooldb", "root", "ADDPASSWORD");
        if (conn == null) return;
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select a.* from classes a where a.courseid in " +
                    "(select b.courseid from coursesprofs b where b.profid in (select profid from profs where profname like \"Cos%\"));");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();


            while (rs.next()) {
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    Object object = rs.getObject(columnIndex);
                    System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
                System.out.println("\n");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void displayClassesByDeptAndNumber() {
        Connection conn = getConnection("mysql", "localhost", "3306", "schooldb", "root", "ADDPASSWORD");
        if (conn == null) return;
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select a.* from classes a where a.courseid in (select courseid from crosslistings where dept like \"%cos%\" and coursenum like \"3%\");");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();


            while (rs.next()) {
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    Object object = rs.getObject(columnIndex);
                    System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
                System.out.println("\n");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


    public static void displayCoursesIntro() {
        Connection conn = getConnection("mysql", "localhost", "3306", "schooldb", "root", "ADDPASSWORD");
        if (conn == null) return;
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select a.* from classes a where a.courseid in (select courseid from courses where title like \"%Intro%\");");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();


            while (rs.next()) {
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    Object object = rs.getObject(columnIndex);
                    System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
                System.out.println("\n");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static void displayClassesByID() {
        Connection conn = getConnection("mysql", "localhost", "3306", "schooldb", "root", "ADDPASSWORD");
        if (conn == null) return;
        Statement st = null;
        ResultSet rs = null;
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter course ID (enter MATH101 for a quick demo): ");
        String id = sc.nextLine();
        String querry = "select * from courses where courseid = '" + id + "'";


        try {
            st = conn.createStatement();
            rs = st.executeQuery(querry);
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();


            while (rs.next()) {
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    Object object = rs.getObject(columnIndex);
                    System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
                System.out.println("\n");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }


    public static void displayClasses() {
        Connection conn = getConnection("mysql", "localhost", "3306", "schooldb", "root", "ADDPASSWORD");
        if (conn == null) return;
        Statement st = null;
        ResultSet rs = null;

        try {
            st = conn.createStatement();
            rs = st.executeQuery("select * from classes");
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();


            while (rs.next()) {
                for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                    Object object = rs.getObject(columnIndex);
                    System.out.printf("%s, ", object == null ? "NULL" : object.toString());
                }
                System.out.println("\n");
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static Connection getConnection(String dbType, String host, String port, String dbName, String username, String password){
        Connection conn = null;
        DriverManager.setLoginTimeout(60);

        try{
            StringBuilder connectionURL = new StringBuilder();
            connectionURL.append("jdbc:");
            connectionURL.append(dbType);
            connectionURL.append("://");
            connectionURL.append(host);
            connectionURL.append(":");
            connectionURL.append(port);
            connectionURL.append("/");
            connectionURL.append(dbName);
            connectionURL.append("?user=");
            connectionURL.append(username);
            connectionURL.append("&password=");
            connectionURL.append(password);

            return DriverManager.getConnection(connectionURL.toString());
        } catch (SQLException e) {
            System.out.println("cannot connect to db: " + e.getMessage());
        }
        return null;
    }
}

