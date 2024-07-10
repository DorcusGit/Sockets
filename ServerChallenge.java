import java.net.*;
import java.io.*;
import java.sql.*;

public class ServerChallenge {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try{
        ServerSocket ss=new ServerSocket(6728);
        System.out.println("\tMathematics Challenge System. waiting for the client.....");  
       //establish database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mathematicschallenge","root","");
        System.out.println("Server has connected to the database.");
        }catch(IOException |ClassNotFoundException |SQLException e){
            e.printStackTrace();

        }
    }}