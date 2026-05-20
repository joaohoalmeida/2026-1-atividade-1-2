import java.io.*;
import java.net.Socket;

public class Client {

    Client() throws IOException{
        
        Socket socket = new Socket("echo-server", 6789);
        System.out.println("Conectado ao servidor!");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = in_socket.readLine();
        System.out.println("O servidor enviou: " + message);

        String response = "Olá do cliente Java!";
        out_socket.println(response);

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
