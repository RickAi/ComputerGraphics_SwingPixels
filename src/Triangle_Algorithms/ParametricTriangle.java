package Triangle_Algorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Arrays;

import GraphicsObjects.Point3f;
import GraphicsObjects.Vector3f;

public class ParametricTriangle {
	
	public static final float INCREASED_FACTOR = 1f;

	protected Point3f pointA;
	protected Point3f pointB;
	protected Point3f pointC;
	
	float minX;
	float maxX;
	float minY;
	float maxY;
	
	float bToAC;
	float aToBC;
	float cToAB;

	public ParametricTriangle(Point3f a, Point3f b, Point3f c) {
		pointA = a;
		pointB = b;
		pointC = c;
		
		// init values
		initArray();
		initDistances();
	}

	private void initDistances() {
		// init the distance between vertices and lines
		bToAC = distance(pointB, pointA, pointC);
		aToBC = distance(pointA, pointB, pointC);
		cToAB = distance(pointC, pointA, pointB);
	}

	private void initArray() {
		// init x, y values array
		float[] xs = new float[]{pointA.x, pointB.x, pointC.x};
		float[] ys = new float[]{pointA.y, pointB.y, pointC.y};
		
		// sort two array
		Arrays.sort(xs);
		Arrays.sort(ys);
		
		// init the max and min value of x and y
		minX = xs[0];
		minY = ys[0];
		maxX = xs[2];
		maxY = ys[2];
	}

	// Implement in Parametric form ,and comment what it does
	public void drawTriangle(Graphics g) {
		// draw three line first
		drawLine(g, pointA, pointB);
		drawLine(g, pointB, pointC);
		drawLine(g, pointC, pointA);
		
		// draw colors by two line loops
		drawColors(g);
	}


	protected void drawColors(Graphics g) {
		// init the storage variable
		float currentX = 0.0f;
		float currentY = 0.0f;
		float alpha = 0.0f;
		float gamma = 0.0f;
		float beta = 0.0f;
		Point3f tempPoint3f;
		
		// use two inbeded loop, judge the alpha, gamma, beta values
		for(currentX = minX; currentX < maxX; currentX += INCREASED_FACTOR){
			for(currentY = minY; currentY < maxY; currentY += INCREASED_FACTOR){
				tempPoint3f = new Point3f(currentX, currentY, 0);
				
				// use distance to get the alpha gamma and beta
				alpha = distance(tempPoint3f, pointB, pointC)/aToBC;
				gamma = distance(tempPoint3f, pointA, pointC)/bToAC;
				beta = 1 - alpha - gamma;
				
				// if the one of RGB is smaller than 0, ignore it
				if(alpha < 0.0 || gamma < 0.0 || beta < 0.0 ){
					continue;
				}
				setPixel(g, (int)currentX, (int)currentY, alpha, gamma, beta);
			}
		}
	}
	
	private void drawLine(Graphics g, Point3f startPoint, Point3f endPoint) {
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
		for (float increasedF = 0; increasedF <= 1.0f; increasedF += INCREASED_FACTOR) {
			currentX = startX + internX * increasedF;
			currentY = startY + internY * increasedF;
			setPixel(g, (int) currentX, (int) currentY, 0, 0, 0);
		}
	}
	
	// I have implemented this method to adapt Swings coordinate system
	public void setPixel(Graphics g, int x, int y, float R, float G, float B) {

		Color pixelColour = new Color(R, G, B);
		g.setColor(pixelColour);
		g.drawRect(x + 500, 500 - y, 1, 1); // + 500 offset is to make the
											// centre 0,0 at centre of the
											// screen

	}

	// get the distance between a point to a line
	public float distance(Point3f checkedPoint, Point3f beginP,
			Point3f endP) {
		// calculate normal of the line
		Vector3f vectorA = new Vector3f(endP.x-beginP.x, endP.y-beginP.y, 0);
		Vector3f vectorN = vectorA.normal();
		// caculate the vector of the checked point and the start point
		Vector3f vectorV = new Vector3f(checkedPoint.x-beginP.x, checkedPoint.y-beginP.y, 0);
		return (vectorN.dot(vectorV)/vectorN.length());
	}

}
