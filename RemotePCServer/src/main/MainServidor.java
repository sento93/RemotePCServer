package main;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.util.Enumeration;

import socket.HiloServidor;
import socket.MyStreamSocket;

public class MainServidor {
	
	/** Puerto por defecto de la conexion */
	private static final int PUERTO=4444;
   
   public static void main(String[] args) {  
	   int puerto = PUERTO;
	   ServerSocket myConnectionSocket=null;
	   try {
		   boolean buscando=true;
		   Enumeration<NetworkInterface> e = NetworkInterface.getNetworkInterfaces();
		   while (e.hasMoreElements()&&buscando){
		   Enumeration<InetAddress> ee = e.nextElement().getInetAddresses();
		   			while (ee.hasMoreElements()){
		       		InetAddress i = ee.nextElement();
		       		if(i.getClass().equals(Inet4Address.class)&&!i.getHostAddress().startsWith("127")){
		       	   		System.out.println("IP="+i.getHostAddress());
		       	   		buscando=false;
		       	   		break;
		       		}
		   		}
		   }
		   myConnectionSocket = new ServerSocket(puerto); 
		   while (true) // Repite un bucle infinito para captar conexiones
			   new Thread(new HiloServidor(new MyStreamSocket(myConnectionSocket.accept( )))).start();
	   } catch (Exception ex) {	   
		   ex.printStackTrace();
	   }
   } //fin main
} // fin class