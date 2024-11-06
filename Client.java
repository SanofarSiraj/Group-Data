import java.io.*;
import java.net.Socket;

public class Client {
    private Socket clientSocket;
    private OutputStream output;
    private InputStream input;
    private PrintWriter writer;
    private BufferedReader reader;

    private String ipAddress;
    private int port;

    public static void main(String[] args) { // Temporary main-method for testing
        Client client = new Client();
        client.startConnection("localhost", 8888);
    }

    public void startConnection(String ipAddress, int port){
        try {
            System.out.println("Establishing connection to Server...");

            clientSocket = new Socket(ipAddress, port);
            output = clientSocket.getOutputStream();

            System.out.println("Connection to Server established.");

            writer = new PrintWriter(output, true);
            input = clientSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(input));

        } catch (IOException e) {
            System.out.println("Connection failed to Server failed.");
        }

    }

    public static void handleCommunications(){
        String outMessage;
        String inMessage;
        /*String s1 = "i shot " + getCoordinate;
        String s2 = "h shot " + getCoordinate;
        String s2 = "m shot " + getCoordinate;
        String s3 = "game over";
        String s4 = "s shot " + getCoordinate;

        while(amountOfShips == 0){
            //  Could use an int for amount of ships, if int reaches 0 (aka, all ships destroyed)
                the loop ends, and a game over message pops up.

                // Problem with this loop, both server and client will go simultaneously
                   instead of taking turns

                inMessage = reader.readLine();

                if(getFirstShot()){ // Might need to change depending on how the method for firing works
                    outMessage = s1
                    writer.println(outMessage)

                    setFirstShot(false);
                }
                else if(hit){
                   if(sankShip){

                   }
                   else{

                   }
                }
                else if(miss){

                }
                else if(amountOfShips == 0){

                }
        }*/
    }

    public void stopConnection(){
        // when all ships are destroyed on either side, run this method

        /*try {
            clientSocket.close();
            output.close();
            writer.close();
            input.close();
            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred while trying to stop the connection.");
        }*/
    }
}
