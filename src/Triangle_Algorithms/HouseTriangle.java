package Triangle_Algorithms;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import utils.PrintUtils;

import GraphicsObjects.Point3f;

public class HouseTriangle extends ParametricTriangle {

	private Color color;
	private float red;
	private float green;
	private float blue;

	public HouseTriangle(Point3f a, Point3f b, Point3f c) {
		super(a, b, c);
	}

	public void setColor(Color color) {
		this.color = color;
		
		red = color.getRed()/255f;
		green = color.getGreen()/255f;
		blue = color.getBlue()/255f;
	}

	@Override
	protected void drawColors(Graphics g) {
		// init the storage variable
		float currentX = 0.0f;
		float currentY = 0.0f;
		Point3f tempPoint3f;

		// use two inbeded loop, judge the alpha, gamma, beta values
		for (currentX = minX; currentX < maxX; currentX += INCREASED_FACTOR) {
			for (currentY = minY; currentY < maxY; currentY += INCREASED_FACTOR) {
				tempPoint3f = new Point3f(currentX, currentY, 0);

				if(isInsideTriangle(tempPoint3f)){
					setPixel(g, (int)currentX, (int)currentY, red, green, blue);
				}
			}
		}
	}

	// if the area of three small triangle is equal to the area of big triangle
	// then the point is inside the triangle
	private boolean isInsideTriangle(Point3f checkedPoint) {
        float abc = triangleArea(pointA, pointB, pointC);
        float abp = triangleArea(pointA, pointB, checkedPoint);
        float acp = triangleArea(pointA, pointC, checkedPoint);
        float bcp = triangleArea(pointB, pointC, checkedPoint);
        return (abc == (abp + acp + bcp));
    } 
	 
	// return the area of this triangle 
	private float triangleArea(Point3f a, Point3f b, Point3f c) {
        float result = (float) Math.abs((a.x * b.y + b.x * c.y + c.x * a.y - b.x * a.y
                - c.x * b.y - a.x * c.y) / 2.0D);
        return result;
    } 

}
