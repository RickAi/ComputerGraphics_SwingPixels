package Line_Algorithms;

import java.awt.Graphics;

import GraphicsObjects.Point3f;

public class ParametricLine {
	
	public static final float INCREASED_FACTOR = 0.001f;

	Point3f startPoint;
	Point3f endPoint;

	public ParametricLine(Point3f Start, Point3f End) {
		this.startPoint = Start;
		this.endPoint = End;

	}

	public void drawLine(Graphics g) {
		// get the intern of X, Y
		float startX = startPoint.x;
		float endX = endPoint.x;
		float startY = startPoint.y;
		float endY = endPoint.y;
		float internY = endY - startY;
		float internX = endX - startX;
		float currentX = 0.0f;
		float currentY = 0.0f;
		
		// increase it by the increased factor, set the pixel by a loop
		for(float increasedF = 0; increasedF <= 1.0f; increasedF += INCREASED_FACTOR){
			currentX = startX + internX * increasedF;
			currentY = startY + internY * increasedF;
			setPixel(g, (int)currentX, (int)currentY);
		}
	}

	// I have implemented this method to adapt Swings coordinate system
	public void setPixel(Graphics g, int x, int y) {
		g.drawRect(x + 500, 500 - y, 1, 1); // + 500 offset is to make the
											// centre 0,0 at centre of the
											// screen for swing :-)

	}
}
