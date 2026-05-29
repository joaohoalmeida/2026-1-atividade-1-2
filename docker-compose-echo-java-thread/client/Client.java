import java.io.*;
import java.net.Socket;

public class Client {

    String name;

    Client(String name) throws IOException{
        
        Socket socket = new Socket("echo-server", 6789);
        System.out.println("Conectado ao servidor!");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = in_socket.readLine();
        System.out.println("O servidor enviou: " + message);

        int i = 0;
        while (true){
            out_socket.println(name + " - Testando: " + i++);
            try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            if (i == 10){ break; }
        }
        
        socket.close();
        System.out.println("Comunicacão fechada");
    
    }

    public static void main(String[] args){
        try{
            String name = args.length > 0 ? args[0] : "Cliente";
            new Client(name);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
