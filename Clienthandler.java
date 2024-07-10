import java.net.*;
import java.sql.*;

public class Clienthandler extends Thread{
    private final Socket soc;
    private final Connection con;
    public ClientHandler(Socket soc, Connection con) {
        this.con = con;
        this.soc=soc;
    }

    @Override
    public void start() {
        try{
            BufferedReader in = new BufferedReader(new InputStreamReader(soc.getInputStream()));
            PrintWriter out = new PrintWriter(soc.getOutputStream(), true);

            String command = in.readLine();
            System.out.println("Received command from client: " + command);
        }}}