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
while(true){
    System.out.println("\t Welcome to mathematics Challenge System ");
    System.out.println("enter command of your choice from the menu");
    System.out.println("menu\n\n Register  username lastname firstname emailAddress date_of_birth  school_registration_number image _file.png\n\n viewChallenges -displays the challenges \n\n attempt challenge challenge number \n\n view applicants\n\n confirm yes/no username");
    String choice=B.readLine();
    //sending to the server
    P.println(choice);
    //handle which ever response from the server
    if (choice.startsWith("register")) {
        String message = Br.readLine();
        System.out.println(message);
    }else
    if(choice.startsWith("viewChallenges")){
        try {
            //object input stream to read a list of challenges from the server
            ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
            
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> challenges = (List<Map<String, Object>>) in.readObject();
            for (Map<String, Object> challenge : challenges) {
                System.out.println(challenge);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        //response from the server from the attempt challenge method
    }else
    if(choice.startsWith("attempt challenge")){
        String message = Br.readLine();
        System.out.println(message);
        //response from the server from the view applicants method
    }else if(choice.startsWith("view applicants")){
       ObjectInputStream in = new ObjectInputStream(soc.getInputStream());
                @SuppressWarnings("unchecked")
                List<Map<String, Object>> applicants = (List<Map<String, Object>>) in.readObject();
                for (Map<String, Object> applicant : applicants) {
                    System.out.println(applicant);}
    }else if(choice.startsWith("confirm yes/no username")){
        String message = Br.readLine();
        System.out.println(message);
    }

    }
        }catch(IOException e){
            e.printStackTrace();
        }
    }}