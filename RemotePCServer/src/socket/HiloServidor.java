package socket;

import java.awt.Robot;

import control.Raton;
import control.Teclado;
import enums.EspecialesTeclado;
import socket.MyStreamSocket;

public class HiloServidor implements Runnable {
	private MyStreamSocket myDataSocket;
	private Raton raton;
	private Teclado teclado;

	/**
	 * Construye el objeto a ejecutar por la hebra para servir a un cliente
	 * @param	myDataSocket	socket stream para comunicarse con el cliente
	 */
	
   public HiloServidor(MyStreamSocket myDataSocket) {
	   this.myDataSocket=myDataSocket;
	   try{
		   Robot robot=new Robot();
		   this.raton=new Raton(robot);
		   this.teclado=new Teclado(robot);
	   }catch(Exception e){}
   }
 
   /**
	* Gestiona una sesion con un cliente	
   */
   public void run( ) {
      boolean done = false;
      try {
         while (!done) {
        	 // Recibe una peticion del cliente
        	 String datos=this.myDataSocket.receiveMessage();
        	 // Extrae la operación y los argumentos
             switch(datos.charAt(0)){
             case 'k':
            	 this.teclado.escribir(datos.substring(1));
            	 break;
             case 'm':
            	 String[]params=datos.split("#");
            	 this.raton.mover(Integer.parseInt(params[1]),Integer.parseInt(params[2]));
            	 break;
             case 'c':
            	 switch(datos.charAt(1)) {
            	 case'l':
            		 this.raton.clickIzq();
            		 break;
            	 case'r':
            		 this.raton.clickDer();
            		 break;
            	 case'p':
            		 this.raton.pulsarClickIzq();
            		 break;
            	 case's':
            		 this.raton.soltarClickIzq();
            		 break;
            	 case'c':
            		 this.raton.clickScroll();
            		 break;
            	 }
            	 break;
             case 's':
            	 this.raton.scroll(Integer.parseInt(datos.substring(1)));
            	 break;
             case'e':
            	 switch(datos.charAt(1)){
            	 case'x':
            		 this.teclado.especiales(EspecialesTeclado.ESC);
            		 break;
            	 case'b':
            		 this.teclado.especiales(EspecialesTeclado.BLOQ_MAYUS);
            		 break;
            	 case'm':
            		 switch(datos.charAt(2)){
            		 case'p':
            			 this.teclado.especiales(EspecialesTeclado.MAYUS_P);
            			 break;
            		 case's':
            			 this.teclado.especiales(EspecialesTeclado.MAYUS_S);
            			 break;
            		 }
            		 break;
            	 case's':
            		 this.teclado.especiales(EspecialesTeclado.SUPR);
            		 break;
            	 case't':
            		 this.teclado.especiales(EspecialesTeclado.TAB);
            		 break;
            	 case'c':
            		 switch(datos.charAt(2)){
            		 case'p':
            			 this.teclado.especiales(EspecialesTeclado.CTRL_P);
            			 break;
            		 case's':
            			 this.teclado.especiales(EspecialesTeclado.CTRL_S);
            			 break;
            		 }
            		 break;
            	 case'w':
            		 this.teclado.especiales(EspecialesTeclado.WIN);
            		 break;
            	 case'a':
            		 switch(datos.charAt(2)){
            		 case'p':
            			 this.teclado.especiales(EspecialesTeclado.ALT_P);
            			 break;
            		 case's':
            			 this.teclado.especiales(EspecialesTeclado.ALT_S);
            			 break;
            		 }
            		 break;
            	 case'd':
            		 this.teclado.especiales(EspecialesTeclado.BACKSPACE);
            		 break;
            	 case 'e':
            		 this.teclado.especiales(EspecialesTeclado.ENTRAR);
            		 break;
            	 case 'g':
            		 switch(datos.charAt(2)){
            		 case'p':
            			 this.teclado.especiales(EspecialesTeclado.ALT_GR_P);
            			 break;
            		 case's':
            			 this.teclado.especiales(EspecialesTeclado.ALT_GR_S);
            			 break;
            		 }
            		 break;
            	 case'i':
            		 this.teclado.especiales(EspecialesTeclado.INICIO);
            		 break;
            	 case'n':
            		 this.teclado.especiales(EspecialesTeclado.FIN);
            		 break;
            	 case'f':
            		 switch(datos.substring(2)) {
            		 case"1":
            			 this.teclado.especiales(EspecialesTeclado.F1);
            			 break;
            		 case"2":
            			 this.teclado.especiales(EspecialesTeclado.F2);
            			 break;
            		 case"3":
            			 this.teclado.especiales(EspecialesTeclado.F3);
            			 break;
            		 case"4":
            			 this.teclado.especiales(EspecialesTeclado.F4);
            			 break;
            		 case"5":
            			 this.teclado.especiales(EspecialesTeclado.F5);
            			 break;
            		 case"6":
            			 this.teclado.especiales(EspecialesTeclado.F6);
            			 break;
            		 case"7":
            			 this.teclado.especiales(EspecialesTeclado.F7);
            			 break;
            		 case"8":
            			 this.teclado.especiales(EspecialesTeclado.F8);
            			 break;
            		 case"9":
            			 this.teclado.especiales(EspecialesTeclado.F9);
            			 break;
            		 case"10":
            			 this.teclado.especiales(EspecialesTeclado.F10);
            			 break;
            		 case"11":
            			 this.teclado.especiales(EspecialesTeclado.F11);
            			 break;
            		 case"12":
            			 this.teclado.especiales(EspecialesTeclado.F12);
            			 break;
            		 }
            		 break;
            	 }
            	 break;
             case '0':
            	 done=true;
            	 this.myDataSocket.close();
            	 break;
             }
       } // fin while   
     }catch (NullPointerException ex) {

     }catch(Exception ex){
    	 ex.printStackTrace();
     }
   } //fin run
} //fin class 
