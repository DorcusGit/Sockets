import java.io.*;
import java.net.*;
import java.util.List;
import java.util.Map;

public class ClientChallenge {
    public static void main(String[] args) throws ClassNotFoundException {
        
        try{
Socket soc=new Socket("localhost", 6728);
BufferedReader B=new BufferedReader(new InputStreamReader(System.in));
PrintWriter P=new PrintWriter(soc.getOutputStream(),true);
BufferedReader Br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
        }catch(IOException e){
            e.printStackTrace();
        }
    }}