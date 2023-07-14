import javax.sound.sampled.Port;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    static Scanner scanStr = new Scanner(System.in);

    public static final int PORT = 8089;

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            Socket clientSocket = serverSocket.accept();
            System.out.println("Клиент подключился!");

            PrintWriter out = new PrintWriter(clientSocket.getOutputStream());
            Scanner in = new Scanner(clientSocket.getInputStream());

            String welcome = in.nextLine();
            System.out.println(welcome);
            out.println("Добро пожаловать в чат. Напишите свое первое сообщение =)\nЕсли захотите выйти из чата," +
                    " введите \"exit\"");
            System.out.println("Приветсивие отправлено!");

            String message;
            String answerForClient;

            while(true){
                message = in.nextLine();
                if (message.equals("exit")){
                    break;
                }
                System.out.println("Сообщение от клиента: " + message + "\nНапишите ваш ответ:\n");

                answerForClient = scanStr.nextLine();
                out.println(answerForClient);
            }

            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
