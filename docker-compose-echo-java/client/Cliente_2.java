import java.io.*;
import java.net.Socket;

public class Cliente_2 {

    Cliente_2() throws IOException{
        
        Socket socket = new Socket("echo-server", 6789);
        System.out.println("Cliente 2 conectado ao servidor!");

        BufferedReader in_socket = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out_socket = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);

        String message = in_socket.readLine();
        System.out.println("O servidor enviou para o Cliente 2: " + message);

        int i = 0;
        while (true){
            out_socket.println("Cliente 2 - Testando: " + i++);
            try { Thread.sleep(200); } catch (InterruptedException e) { e.printStackTrace(); }
            if (i == 10){ break; }
        }
        
        socket.close();
        System.out.println("Comunicacão do Cliente 2 fechada");
    
    }

    public static void main(String[] args){
        try{
            new Cliente_2();

        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
