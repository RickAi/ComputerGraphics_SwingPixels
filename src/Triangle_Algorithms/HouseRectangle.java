package Triangle_Algorithms;

import java.awt.Color;
import java.awt.Graphics;

public class HouseRectangle {
	
	private HouseTriangle triangleUp;
	private HouseTriangle triangleDown;
	
	public HouseRectangle(HouseTriangle triangleUp, HouseTriangle triangleDown, Color color) {
		this.triangleUp = triangleUp;
		this.triangleDown = triangleDown;
		this.triangleUp.setColor(color);
		this.triangleDown.setColor(color);
	}
	
	public void drawRectangle(Graphics g){
		triangleUp.drawTriangle(g);
		triangleDown.drawTriangle(g);
	}

}
