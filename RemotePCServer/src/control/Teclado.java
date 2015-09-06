package control;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import enums.EspecialesTeclado;

public class Teclado {
	
	private Robot robot;
	
	public Teclado(Robot robot){
		super();
		this.robot=robot;
	}
	
	public void especiales(EspecialesTeclado enu){
		switch(enu){
		case TAB:
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
			break;
		case CTRL_P:
			robot.keyPress(KeyEvent.VK_CONTROL);
			break;
		case CTRL_S:
			robot.keyRelease(KeyEvent.VK_CONTROL);
			break;
		case WIN:
			robot.keyPress(KeyEvent.VK_WINDOWS);
			robot.keyRelease(KeyEvent.VK_WINDOWS);
			break;
		case ALT_P:
			robot.keyPress(KeyEvent.VK_ALT);
			break;
		case ALT_S:
			robot.keyRelease(KeyEvent.VK_ALT);
			break;
		case ENTRAR:
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			break;
		case BACKSPACE:
			robot.keyPress(8);
			robot.keyRelease(8);
			break;
		case ESC:
			robot.keyPress(KeyEvent.VK_ESCAPE);
			robot.keyRelease(KeyEvent.VK_ESCAPE);
			break;
		case BLOQ_MAYUS:
			robot.keyPress(KeyEvent.VK_CAPS_LOCK);
			robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
			break;
		case MAYUS_P:
			robot.keyPress(KeyEvent.VK_SHIFT);
			break;
		case MAYUS_S:
			robot.keyRelease(KeyEvent.VK_SHIFT);
			break;
		case SUPR:
			robot.keyPress(KeyEvent.VK_DELETE);
			robot.keyRelease(KeyEvent.VK_DELETE);
			break;
		case ALT_GR_P:
			robot.keyPress(KeyEvent.VK_ALT_GRAPH);
			break;
		case ALT_GR_S:
			robot.keyRelease(KeyEvent.VK_ALT_GRAPH);
			break;
		case INICIO:
			robot.keyPress(36);
			robot.keyRelease(36);
			break;
		case FIN:
			robot.keyPress(KeyEvent.VK_END);
			robot.keyRelease(KeyEvent.VK_END);
			break;
		case F1:
			robot.keyPress(KeyEvent.VK_F1);
			robot.keyRelease(KeyEvent.VK_F1);
			break;
		case F2:
			robot.keyPress(KeyEvent.VK_F2);
			robot.keyRelease(KeyEvent.VK_F2);
			break;
		case F3:
			robot.keyPress(KeyEvent.VK_F3);
			robot.keyRelease(KeyEvent.VK_F3);
			break;
		case F4:
			robot.keyPress(KeyEvent.VK_F4);
			robot.keyRelease(KeyEvent.VK_F4);
			break;
		case F5:
			robot.keyPress(KeyEvent.VK_F5);
			robot.keyRelease(KeyEvent.VK_F5);
			break;
		case F6:
			robot.keyPress(KeyEvent.VK_F6);
			robot.keyRelease(KeyEvent.VK_F6);
			break;
		case F7:
			robot.keyPress(KeyEvent.VK_F7);
			robot.keyRelease(KeyEvent.VK_F7);
			break;
		case F8:
			robot.keyPress(KeyEvent.VK_F8);
			robot.keyRelease(KeyEvent.VK_F8);
			break;
		case F9:
			robot.keyPress(KeyEvent.VK_F9);
			robot.keyRelease(KeyEvent.VK_F9);
			break;
		case F10:
			robot.keyPress(KeyEvent.VK_F10);
			robot.keyRelease(KeyEvent.VK_F10);
			break;
		case F11:
			robot.keyPress(KeyEvent.VK_F11);
			robot.keyRelease(KeyEvent.VK_F11);
			break;
		case F12:
			robot.keyPress(KeyEvent.VK_F12);
			robot.keyRelease(KeyEvent.VK_F12);
			break;
		}
	}
	
	public void escribir(String text){
		int cod;
		char c='0';
		for(int i=0;i<text.length();i++){
			try{
				c=text.charAt(i);
				if("%?@#^{}|".contains(c+""))
					throw new IllegalArgumentException();
				else{
					cod=KeyEvent.getExtendedKeyCodeForChar(c);
					if(";=\"*:!$&>_".contains(c+"")){
						robot.keyPress(16);
						robot.keyPress(cod);
						robot.keyRelease(cod);
						robot.keyRelease(16);
					}else{
						robot.keyPress(cod);
						robot.keyRelease(cod);
					}
				}
			}catch(IllegalArgumentException e){
				System.out.println("El caracter "+ c +" no esta reconocido por el programa.");
			}
		}
	}
}
