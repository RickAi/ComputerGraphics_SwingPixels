import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import utils.PrintUtils;

import GraphicsObjects.Point3f;
import Line_Algorithms.ExplicitLine;
import Line_Algorithms.ImplicitLine;
import Line_Algorithms.ParametricLine;
import Triangle_Algorithms.ParametricTriangle;

/*
 * 
 * This class to test your work and for you to make lines to draw your house , it will not compile till all the methods are complete in the other classes 
 * 
 */
public class Drawing2D extends JPanel {

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
		
		
//		ExplicitLine FirstLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(200, 100, 0));
//		ImplicitLine SecondLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(200, 200, 0)); // 200
//		ParametricLine ThirdLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(75, 200, 0));
//		
//		FirstLine.drawLine(g);
//		SecondLine.drawLine(g);
//		ThirdLine.drawLine(g);
		
		// Remove the comments for Explicit line and test it
//		ExplicitLine FirstLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(200, 100, 0));
//		ExplicitLine SecondLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(200, 200, 0)); 
//		ExplicitLine ThirdLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(75, 200, 0));
//		ExplicitLine FourthLine = new ExplicitLine(new Point3f(0, 0, 0), new Point3f(25, 200, 0));
//
//		FirstLine.drawLine(g);
//		SecondLine.drawLine(g);
//		ThirdLine.drawLine(g);
//		FourthLine.drawLine(g);
		

//		ImplicitLine FirstLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(200, 100, 0));
//		ImplicitLine SecondLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(200, 200, 0));
//		ImplicitLine ThirdLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(75, 200, 0));
//		ImplicitLine FourthLine = new ImplicitLine(new Point3f(0, 0, 0), new Point3f(25, 200, 0));
//
//		FirstLine.drawLine(g);
//		SecondLine.drawLine(g);
//		ThirdLine.drawLine(g);
//		FourthLine.drawLine(g);

//		ParametricLine FirstLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(200, 100, 0));
//		ParametricLine SecondLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(200, 200, 0));
//		ParametricLine ThirdLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(75, 200, 0));
//		ParametricLine FourthLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(25, 200, 0));
//
//		FirstLine.drawLine(g);
//		SecondLine.drawLine(g);
//		ThirdLine.drawLine(g);
//		FourthLine.drawLine(g);

//		ParametricLine FirstLine = new ParametricLine(new Point3f(0, 0, 0), new Point3f(0, 300, 0));
//		ParametricLine SecondLine = new ParametricLine(new Point3f(0, 300, 0), new Point3f(300, 300, 0));
//		ParametricLine ThirdLine = new ParametricLine(new Point3f(300, 300, 0), new Point3f(300, 0, 0));
//		ParametricLine FourthLine = new ParametricLine(new Point3f(300, 0, 0), new Point3f(0, 0, 0));
//
//		FirstLine.drawLine(g);
//		SecondLine.drawLine(g);
//		ThirdLine.drawLine(g);
//		FourthLine.drawLine(g);

		ParametricTriangle MyFirstTriangle = new ParametricTriangle(new Point3f(200, 0, 0), new Point3f(400,200, 0),
				new Point3f(200, 370, 0));

		 MyFirstTriangle.drawTriangle(g);
		
		//insert your house drawings here 

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
