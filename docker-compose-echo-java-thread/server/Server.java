import java.io.*;
import java.net.*;

public class Server{

    public Server() throws IOException{

        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Porta 6789 aberta");

        while (true){
            Socket socket = serverSocket.accept();

            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            
            out_socket.println("Bem-vindo ao servidor!");

            String message;

            while ((message = in_socket.readLine()) != null){
                System.out.println("Cliente enviou " + message);
            }

            socket.close();
        }

    }

    private int clientNumber = 1;

    public int getClientNumber(){
        return clientNumber++;
    }

    public static void main(String[] args){
        try{
            new Server();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}

