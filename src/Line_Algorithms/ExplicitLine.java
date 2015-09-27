package Line_Algorithms;

import java.awt.Graphics;

import GraphicsObjects.Point3f;

public class ExplicitLine {

	Point3f startPoint;
	Point3f endPoint;
	float slope;

	public ExplicitLine(Point3f Start, Point3f End) {
		this.startPoint = Start;
		this.endPoint = End;
		slope = getSlope();
	}

	// use rise divide run we can get slope
	public float getSlope() {
		float rise = endPoint.y - startPoint.y;
		float run = endPoint.x - startPoint.x;
		
		if(run == 0){
			return 0;
		}
		
		return rise/run;
	}
	
	public void drawLine(Graphics g) {
		// get all the x, y infos from point class, cast float value to int in the right time
		float tempSlope = this.slope;
		float lineSlope = 0;
		float resY = 0;
		float resX = 0;
		
		// Bresenham’s Algorithm
		if(Math.abs(tempSlope) < 1){
			lineSlope = tempSlope;
			
			for(float currentX = startPoint.x; currentX < endPoint.x; currentX++){
				resY = lineSlope * currentX + startPoint.y;
				setPixel(g, (int)currentX, (int)resY);
			}
		} else{
			lineSlope = 1/tempSlope;
			
			// call setPixel method in this method
			for(float currentY = startPoint.y; currentY < endPoint.y; currentY++){
				resX = lineSlope * currentY + startPoint.x;
				setPixel(g, (int)resX, (int)currentY);
			}
		}
	}

	// I have implemented this method to adapt Swings coordinate system
	public void setPixel(Graphics g, int x, int y) {
		g.drawRect(x + 500, 500 - y, 1, 1); // + 500 offset is to make the
											// centre 0,0 at centre of the
											// screen

	}

}
