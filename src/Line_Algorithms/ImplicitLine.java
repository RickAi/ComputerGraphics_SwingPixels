package Line_Algorithms;

import java.awt.Graphics;

import GraphicsObjects.Point3f;
import GraphicsObjects.Vector3f;

public class ImplicitLine {

	public static final float LINE_WIDTH = 2.0f;

	Point3f startPoint;
	Point3f endPoint;

	public ImplicitLine(Point3f Start, Point3f End) {
		this.startPoint = Start;
		this.endPoint = End;

	}

	public void drawLine(Graphics g) {
		// get the x, y of start and end points first
		float startX = startPoint.x;
		float endX = endPoint.x;
		float startY = startPoint.y;
		float endY = endPoint.y;

		// use two loops to set the pixels according to the width
		for (float currentX = startX; currentX < endX; currentX++) {
			for (float currentY = startY; currentY < endY; currentY++) {
				if (Math.abs(distance(new Point3f(currentX, currentY, 0),
						startPoint, endPoint)) < LINE_WIDTH / 2) {
					setPixel(g, (int) currentX, (int) currentY);
				}
			}
		}
	}

	// get the checked point distance to the begin and end points
	public float distance(Point3f checkedPoint, Point3f beginP, Point3f endP) {
		// calculate normal of the line
		Vector3f vectorA = new Vector3f(endP.x - beginP.x, endP.y - beginP.y, 0);
		Vector3f vectorN = vectorA.normal();
		// caculate the vector of the checked point and the start point
		Vector3f vectorV = new Vector3f(checkedPoint.x - beginP.x,
				checkedPoint.y - beginP.y, 0);
		return (vectorN.dot(vectorV) / vectorN.length());
	}

	// I have implemented this method to adapt Swings coordinate system
	public void setPixel(Graphics g, int x, int y) {
		g.drawRect(x + 500, 500 - y, 1, 1); // + 500 offset is to make the
											// centre 0,0 at centre of the
											// screen

	}

}
