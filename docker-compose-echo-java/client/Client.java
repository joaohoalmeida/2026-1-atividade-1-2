import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    Client() throws IOException{
        
        Socket socket = new Socket("localhost", 6789);
        System.out.println("Conectado ao servidor!");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
        Scanner sc = new Scanner(System.in);

        String message = in_socket.readLine();
        System.out.println("O servidor enviou: " + message);

        message = sc.nextLine();
        out_socket.println(message);

        socket.close();
        System.out.println("Comunicacão fechada");
    
    }

    public static void main(String[] args){
        try{
            new Client();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
