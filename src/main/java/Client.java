import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    static Scanner scanStr = new Scanner(System.in);
    public static final String LOCALHOST = "localhost";
    public static final int PORT = 8089;
    public static void main(String[] args) {

        try {
            Socket socket = new Socket(LOCALHOST, PORT);

            PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream());

            String message;
            String answerForServer;

            answerForServer = scanStr.nextLine();
            out.println(answerForServer);

            while (true){
                message = in.nextLine();
                System.out.println("Сообщение от сервера" + message);

                answerForServer = scanStr.nextLine();
                out.println(answerForServer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
