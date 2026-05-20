import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable{
    private Socket socket;
    private Server server;

    public ServerThread(Socket socket, Server server){
        this.socket = socket;
        this.server = server;
    }

    @Override
    public void run(){
        try{    
            int clientNumber = server.getClientNumber();
            System.out.println("Client " + clientNumber + " no endereco " + socket.getInetAddress() + " conectou!");

            BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
            
            out_socket.println("Bem-vindo ao servidor!");

            String message = in_socket.readLine();
            System.out.println("Cliente enviou: " + message);

            socket.close();
            System.out.println("Client " + clientNumber + " no endereco " + socket.getInetAddress() + " desconectou!");


        } catch (Exception e){
            e.printStackTrace();
        }
    }
}