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
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/challenge","root","");
        System.out.println("Server has connected to the database.");
        while(true){
            //accept client connection
        Socket soc=ss.accept();
        System.out.println(" Client has connected at " +soc);
        BufferedReader B=new BufferedReader(new InputStreamReader(soc.getInputStream()));
        PrintWriter out=new PrintWriter(soc.getOutputStream());

        //handling client's request
        Clienthandler c=new Clienthandler(soc, con);
        c.start();
        }}catch(IOException |ClassNotFoundException |SQLException e){
            e.printStackTrace();

        }
    }}