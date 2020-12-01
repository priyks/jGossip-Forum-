package forum.bean;

//import java.sql.*;

public class DBConnection{
        private static String dbname = "jdbc:odbc:jspforum";
        private static String dbdriver = "sun.jdbc.odbc.JdbcOdbcDriver";
        private static String username = "fahmie";
        private static String passwd = "fahmie";

        public static String getDBDriver(){
                return dbdriver;
        }

        public static String getDBName(){
                return dbname;
        }

        public static String getDBUsername(){
                return username;
        }

        public static String getDBPasswd(){
                return passwd;
        }
}


/*

Class.forName(DBConnection.getDBDriver());
con = DriverManager.getConnection(DBConnection.getDBName(),DBConnection.getDBUsername(),DBConnection.getDBPasswd());

*/
