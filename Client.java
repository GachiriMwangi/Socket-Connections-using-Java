import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter data to send to server: ");
        String data = scanner.nextLine();

        Socket socket = new Socket("localhost", 8080); 
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(data);

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = in.readLine();

        System.out.println("Server response: " + response);
        scanner.close();
        socket.close();
    }
}