package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketClient {
    public static void main( String[] args ) throws IOException {
        Socket localhost = null;
        try {
            localhost = new Socket ( "localhost" , 8080 );
        }
        catch ( IOException e ) {
            System.out.println ("Сервер не запущен" );
        }
        DataInputStream dataInputStream = new DataInputStream ( localhost.getInputStream ( ) );
        DataOutputStream dataOutputStream = new DataOutputStream ( localhost.getOutputStream ( ) );
        BufferedReader reader = new BufferedReader ( new InputStreamReader ( System.in ) );

        String str = "";
        String str2 = "";
        while (!str.equals ( "stop" )) {
            str = reader.readLine ( );
            dataOutputStream.writeUTF ( str );
            try {
                dataOutputStream.flush ( );
            }
            catch ( IOException e ) {
                System.out.println ( "Сервер закончил свою работу");
            }
            str2 = dataInputStream.readUTF ( );
            System.out.println ( "Server says: " + str2 );


        }
        dataOutputStream.close ( );
        localhost.close ( );

    }
}
