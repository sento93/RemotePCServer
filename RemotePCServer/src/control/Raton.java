package control;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;

public class Raton {
	
	private Robot robot;
	
	public Raton(Robot robot){
		super();
		this.robot=robot;
	}

	public void mover(int x,int y){
		try {
			Point p=MouseInfo.getPointerInfo().getLocation();
			this.robot.mouseMove(p.x+x,p.y+y);
		}catch(NullPointerException e) {
			this.robot.mouseMove(Math.abs(x),Math.abs(y));
		}
	}
	
	public void clickIzq(){
		pulsarClickIzq();
		soltarClickIzq();
	}
	
	public void pulsarClickIzq() {
		this.robot.mousePress(InputEvent.BUTTON1_MASK);
	}
	
	public void soltarClickIzq() {
		this.robot.mouseRelease(InputEvent.BUTTON1_MASK);
	}
	
	public void clickDer(){
		this.robot.mousePress(InputEvent.BUTTON3_MASK);
		this.robot.mouseRelease(InputEvent.BUTTON3_MASK);
	}
	
	public void clickScroll() {
		this.robot.mousePress(InputEvent.BUTTON2_MASK);
		this.robot.mouseRelease(InputEvent.BUTTON2_MASK);
	}
	
	public void scroll(int scroll){
		this.robot.mouseWheel(scroll);
	}

}
