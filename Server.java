import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080); 
        System.out.println("Server started on port 8080");

        Socket clientSocket = serverSocket.accept(); 
        System.out.println("Client connected");

        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String data = in.readLine(); 

        System.out.println("Received data from client: " + data);

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        out.println("Data received successfully!"); 

        clientSocket.close();
        serverSocket.close();
    }
}