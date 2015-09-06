package socket;

import java.net.*;
import java.io.*;

public class MyStreamSocket extends Socket {
   private Socket  socket;
   private BufferedReader input;

   public MyStreamSocket(InetAddress acceptorHost, int acceptorPort ) throws SocketException, IOException{
      socket = new Socket(acceptorHost, acceptorPort );
      setStreams( );

   }

   public MyStreamSocket(Socket socket)  throws IOException {
      this.socket = socket;
      setStreams( );
   }

   private void setStreams( ) throws IOException{
      // get an input stream for reading from the data socket
      InputStream inStream = socket.getInputStream();
      input = new BufferedReader(new InputStreamReader(inStream));
   }

   public String receiveMessage( )
		throws IOException {	
      // read a line from the data stream
      String message = input.readLine( );  
      return message;
   } //end receiveMessage

   public void close( )
		throws IOException {	
      socket.close( );
   }
} //end class
