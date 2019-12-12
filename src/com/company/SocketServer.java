package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main( String[] args ) throws IOException {
        ServerSocket serverSocket = new ServerSocket ( 8080 );
        Socket socket = serverSocket.accept ( );
        DataInputStream dataInputStream = new DataInputStream ( socket.getInputStream ( ) );
        DataOutputStream dataOutputStream = new DataOutputStream ( socket.getOutputStream ( ) );
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );

        String str = " ";
        String str2 = " ";

        while (!str.equals ( "stop" )) {
            str = dataInputStream.readUTF ( );
            System.out.println ( "Client says: " + str );
            str2 = reader.readLine ( );
            dataOutputStream.writeUTF ( str2 );
            dataOutputStream.flush ( );
        }
        dataInputStream.close ( );
        socket.close ( );
        serverSocket.close ( );
    }
}
