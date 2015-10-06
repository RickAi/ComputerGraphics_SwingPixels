import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.PrintUtils;

import GraphicsObjects.Point3f;
import Line_Algorithms.ExplicitLine;
import Line_Algorithms.ImplicitLine;
import Line_Algorithms.ParametricLine;
import Triangle_Algorithms.HouseRectangle;
import Triangle_Algorithms.HouseTriangle;
import Triangle_Algorithms.ParametricTriangle;

/*
 * 
 * This class to test your work and for you to make lines to draw your house , it will not compile till all the methods are complete in the other classes 
 * 
 */
public class Drawing2D extends JPanel {

	public static final float WINDOWS_INTERN = 5.0f;
	public static final float WINDOWS_WIDTH = 40f;

	public Drawing2D() // set up graphics window
	{
		setBackground(Color.WHITE);

	}

	public void paintComponent(Graphics g) // draw graphics in the panel
	{
		int width = getWidth(); // width of window in pixels
		int height = getHeight(); // height of window in pixels

		// as swing starts at 0 , 0 , will need to modify drawing

		super.paintComponent(g); // call superclass to make panel display
									// correctly

		g.setColor(Color.BLACK);

		// ExplicitLine FirstLine = new ExplicitLine(new Point3f(0, 0, 0), new
		// Point3f(200, 100, 0));
		// ImplicitLine SecondLine = new ImplicitLine(new Point3f(0, 0, 0), new
		// Point3f(200, 200, 0)); // 200
		// ParametricLine ThirdLine = new ParametricLine(new Point3f(0, 0, 0),
		// new Point3f(75, 200, 0));
		//
		// FirstLine.drawLine(g);
		// SecondLine.drawLine(g);
		// ThirdLine.drawLine(g);

		// Remove the comments for Explicit line and test it
		// ExplicitLine FirstLine = new ExplicitLine(new Point3f(0, 0, 0), new
		// Point3f(200, 100, 0));
		// ExplicitLine SecondLine = new ExplicitLine(new Point3f(0, 0, 0), new
		// Point3f(200, 200, 0));
		// ExplicitLine ThirdLine = new ExplicitLine(new Point3f(0, 0, 0), new
		// Point3f(75, 200, 0));
		// ExplicitLine FourthLine = new ExplicitLine(new Point3f(0, 0, 0), new
		// Point3f(25, 200, 0));
		//
		// FirstLine.drawLine(g);
		// SecondLine.drawLine(g);
		// ThirdLine.drawLine(g);
		// FourthLine.drawLine(g);

		// ImplicitLine FirstLine = new ImplicitLine(new Point3f(0, 0, 0), new
		// Point3f(200, 100, 0));
		// ImplicitLine SecondLine = new ImplicitLine(new Point3f(0, 0, 0), new
		// Point3f(200, 200, 0));
		// ImplicitLine ThirdLine = new ImplicitLine(new Point3f(0, 0, 0), new
		// Point3f(75, 200, 0));
		// ImplicitLine FourthLine = new ImplicitLine(new Point3f(0, 0, 0), new
		// Point3f(25, 200, 0));
		//
		// FirstLine.drawLine(g);
		// SecondLine.drawLine(g);
		// ThirdLine.drawLine(g);
		// FourthLine.drawLine(g);

		// ParametricLine FirstLine = new ParametricLine(new Point3f(0, 0, 0),
		// new Point3f(200, 100, 0));
		// ParametricLine SecondLine = new ParametricLine(new Point3f(0, 0, 0),
		// new Point3f(200, 200, 0));
		// ParametricLine ThirdLine = new ParametricLine(new Point3f(0, 0, 0),
		// new Point3f(75, 200, 0));
		// ParametricLine FourthLine = new ParametricLine(new Point3f(0, 0, 0),
		// new Point3f(25, 200, 0));
		//
		// FirstLine.drawLine(g);
		// SecondLine.drawLine(g);
		// ThirdLine.drawLine(g);
		// FourthLine.drawLine(g);

		// ParametricLine FirstLine = new ParametricLine(new Point3f(0, 0, 0),
		// new Point3f(0, 300, 0));
		// ParametricLine SecondLine = new ParametricLine(new Point3f(0, 300,
		// 0), new Point3f(300, 300, 0));
		// ParametricLine ThirdLine = new ParametricLine(new Point3f(300, 300,
		// 0), new Point3f(300, 0, 0));
		// ParametricLine FourthLine = new ParametricLine(new Point3f(300, 0,
		// 0), new Point3f(0, 0, 0));
		//
		// FirstLine.drawLine(g);
		// SecondLine.drawLine(g);
		// ThirdLine.drawLine(g);
		// FourthLine.drawLine(g);

		// ParametricTriangle MyFirstTriangle = new ParametricTriangle(new
		// Point3f(200, 0, 0), new Point3f(400,200, 0),
		// new Point3f(200, 370, 0));
		//
		// MyFirstTriangle.drawTriangle(g);

		// insert your house drawings here
		drawHouse(g);

	}

	private void drawHouse(Graphics g) {
		// draw the roof
		HouseTriangle roofTriangle = new HouseTriangle(
				new Point3f(-350, 200, 0), new Point3f(350, 200, 0),
				new Point3f(0, 400, 0));
		roofTriangle.setColor(new Color(0, 127, 255));
		roofTriangle.drawTriangle(g);

		// draw the house base
		HouseTriangle baseTriangleUp = new HouseTriangle(new Point3f(-350, 195,
				0), new Point3f(350, 195, 0), new Point3f(350, -100, 0));
		HouseTriangle baseTriangleDown = new HouseTriangle(new Point3f(-350,
				195, 0), new Point3f(350, -100, 0), new Point3f(-350, -100, 0));
		HouseRectangle baseRectangle = new HouseRectangle(baseTriangleUp,
				baseTriangleDown, new Color(0, 127, 255));
		baseRectangle.drawRectangle(g);

		// draw the door
		HouseTriangle doorTriangleUp = new HouseTriangle(
				new Point3f(100, 80, 0), new Point3f(210, 80, 0), new Point3f(
						210, -100, 0));
		HouseTriangle doorTriangleDown = new HouseTriangle(new Point3f(100, 80,
				0), new Point3f(100, -100, 0), new Point3f(210, -100, 0));
		HouseRectangle doorRectangle = new HouseRectangle(doorTriangleUp,
				doorTriangleDown, new Color(227, 15, 0));
		doorRectangle.drawRectangle(g);

		// draw the base windows
		drawWindows(g, new Point3f(-200, 80, 0));
		// draw the roof windows
		drawWindows(g, new Point3f(150, 300, 0));
		// draw the chimney
		drawChimney(g, new Point3f(-150, 400, 0), 60, 200);
	}

	private void drawChimney(Graphics g, Point3f leftUpPoint, int width,
			int height) {
		HouseTriangle upTriangle = new HouseTriangle(leftUpPoint, 
				new Point3f(leftUpPoint.x - width, leftUpPoint.y, 0), 
				new Point3f(leftUpPoint.x, leftUpPoint.y - height, 0));
		HouseTriangle downTriangle = new HouseTriangle(
				new Point3f(leftUpPoint.x - width, leftUpPoint.y, 0),
				new Point3f(leftUpPoint.x, leftUpPoint.y - height, 0),
				new Point3f(leftUpPoint.x - width, leftUpPoint.y-height, 0));
		HouseRectangle chimneyRectangle = new HouseRectangle(upTriangle, downTriangle, new Color(0, 127, 255));
		chimneyRectangle.drawRectangle(g);
	}

	private void drawWindows(Graphics g, Point3f leftUpPoint) {
		float leftX = leftUpPoint.x;
		float middleX1 = leftX - WINDOWS_WIDTH;
		float middleX2 = middleX1 - WINDOWS_INTERN;
		float rightX = middleX2 - WINDOWS_WIDTH;
		float upY = leftUpPoint.y;
		float middleY1 = upY - WINDOWS_WIDTH;
		float middleY2 = middleY1 - WINDOWS_INTERN;
		float downY = middleY2 - WINDOWS_WIDTH;

		// Left up window
		HouseTriangle leftUpWindowTriUp = new HouseTriangle(new Point3f(leftX,
				upY, 0), new Point3f(middleX1, upY, 0), new Point3f(middleX1,
				middleY1, 0));
		HouseTriangle leftUpWindowTriDown = new HouseTriangle(new Point3f(
				leftX, upY, 0), new Point3f(leftX, middleY1, 0), new Point3f(
				middleX1, middleY1, 0));
		HouseRectangle leftUpWindowRect = new HouseRectangle(leftUpWindowTriUp,
				leftUpWindowTriDown, new Color(227, 15, 0));
		leftUpWindowRect.drawRectangle(g);

		// Right up window
		HouseTriangle rightUpWindowTriUp = new HouseTriangle(new Point3f(
				middleX2, upY, 0), new Point3f(rightX, upY, 0), new Point3f(
				rightX, middleY1, 0));
		HouseTriangle rightUpWindowTriDown = new HouseTriangle(new Point3f(
				middleX2, upY, 0), new Point3f(middleX2, middleY1, 0),
				new Point3f(rightX, middleY1, 0));
		HouseRectangle rightUpWindowRect = new HouseRectangle(
				rightUpWindowTriUp, rightUpWindowTriDown, new Color(227, 15, 0));
		rightUpWindowRect.drawRectangle(g);

		// Left down window
		HouseTriangle leftDownWindowTriUp = new HouseTriangle(new Point3f(
				leftX, middleY2, 0), new Point3f(middleX1, middleY2, 0),
				new Point3f(middleX1, downY, 0));
		HouseTriangle leftDownWindowTriDown = new HouseTriangle(new Point3f(
				leftX, middleY2, 0), new Point3f(leftX, downY, 0), new Point3f(
				middleX1, downY, 0));
		HouseRectangle leftDownWindowRect = new HouseRectangle(
				leftDownWindowTriUp, leftDownWindowTriDown, new Color(227, 15,
						0));
		leftDownWindowRect.drawRectangle(g);

		// Right down window
		HouseTriangle rightDownWindowTriUp = new HouseTriangle(new Point3f(
				middleX2, middleY2, 0), new Point3f(rightX, middleY2, 0),
				new Point3f(rightX, downY, 0));
		HouseTriangle rightDownWindowTriDown = new HouseTriangle(new Point3f(
				middleX2, middleY2, 0), new Point3f(middleX2, downY, 0),
				new Point3f(rightX, downY, 0));
		HouseRectangle rightDownWindowRect = new HouseRectangle(
				rightDownWindowTriUp, rightDownWindowTriDown, new Color(227,
						15, 0));
		rightDownWindowRect.drawRectangle(g);
	}

	public static void main(String[] args) {
		Drawing2D panel = new Drawing2D();
		JFrame ScreenToDrawOn = new JFrame();
		ScreenToDrawOn.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ScreenToDrawOn.setTitle("2D Drawing Application");
		ScreenToDrawOn.setSize(1000, 1000); // window is 500 pixels wide, 400
											// high
		ScreenToDrawOn.setVisible(true);
		ScreenToDrawOn.add(panel);

	}

}
