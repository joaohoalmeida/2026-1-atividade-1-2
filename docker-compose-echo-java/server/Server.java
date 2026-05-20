import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server{

    public Server() throws IOException{

        ServerSocket serverSocket = new ServerSocket(6789);
        System.out.println("Porta 6789 aberta");

        while (true){
            Socket socket = serverSocket.accept();

            ServerThread serverThread = new ServerThread(socket, this);
            Thread thread = new Thread(serverThread);
            thread.start();
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

