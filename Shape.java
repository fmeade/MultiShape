import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;


public class Shape implements MoveableShape
{

	/* x and y coordinates */
	private int x, y, x2, y2;
	
	/* Boolean for multiple shapes*/
	private boolean draw1, draw2;
	
	private Color[] color = {Color.blue,Color.red,Color.gray,Color.black,Color.cyan,Color.green,
							 Color.yellow,Color.lightGray,Color.magenta,Color.darkGray,
							 Color.orange,Color.pink};
	
	int choice;
	
	/**
	 * PlaneShape object
	 * 
	 * @param _x x coordinate
	 * @param _y y coordinate
	 * @param _choice shape choice
	 */
	public Shape(int _x,int _y, int _choice)
	{
		x = _x;
		y = _y;
		x2 = 0;
		y2 = _y;
		draw1 = true;
		draw2 = false;
		choice = _choice;
	}
	
	/**
	 * Draws chosen shape, and draws wrapped shape
	 */
	@Override
	public void draw(Graphics2D g2) 
	{
		if(x == 500)
		{
			x2 = 0;
			draw2 = true;
			
			if(x == 570)
			{
				draw1 = false;
				x = -1;
			}
		}
		
		if(x2 == 500)
		{
			x = 0;
			draw1 = true;
			
			if(x2 == 570)
			{
				draw2 = false;
				x2 = -1;
			}
		}
		
		if(choice == 1)
		{
			if(draw1)
			{
				Point2D.Double p1 = new Point2D.Double(-65 + x, 50 + y);
				Point2D.Double p2 = new Point2D.Double(-65 + x, 90 + y);
				Point2D.Double p3 = new Point2D.Double(-55 + x, 60 + y);
				Point2D.Double p4 = new Point2D.Double(-55 + x, 80 + y);
				Point2D.Double p5 = new Point2D.Double(-10 + x, 60 + y);
				Point2D.Double p6 = new Point2D.Double(-10 + x, 80 + y);
				Point2D.Double p7 = new Point2D.Double(x, 70 + y);
				Point2D.Double p8 = new Point2D.Double(-40 + x, 60 + y);
				Point2D.Double p9 = new Point2D.Double(-20 + x, 60 + y);
				Point2D.Double p10 = new Point2D.Double(-30 + x, 0 + y);
				Point2D.Double p11 = new Point2D.Double(-40 + x, 80 + y);
				Point2D.Double p12 = new Point2D.Double(-20 + x, 80 + y);
				Point2D.Double p13 = new Point2D.Double(-30 + x, 140 + y);

				Line2D.Double tail1 = new Line2D.Double(p1, p2);
				Line2D.Double tail2 = new Line2D.Double(p1, p3);
				Line2D.Double tail3 = new Line2D.Double(p2, p4);
				Line2D.Double body1 = new Line2D.Double(p3, p5);
				Line2D.Double body2 = new Line2D.Double(p4, p6);
				Line2D.Double nose1 = new Line2D.Double(p5, p7);
				Line2D.Double nose2 = new Line2D.Double(p6, p7);
				Line2D.Double wing1 = new Line2D.Double(p8, p10);
				Line2D.Double wing2 = new Line2D.Double(p9, p10);
				Line2D.Double wing3 = new Line2D.Double(p11, p13);
				Line2D.Double wing4 = new Line2D.Double(p12, p13);

				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(tail1);
				g2.draw(tail2);
				g2.draw(tail3);
				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(body1);
				g2.draw(body2);
				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(nose1);
				g2.draw(nose2);
				g2.draw(wing1);
				g2.draw(wing2);
				g2.draw(wing3);
				g2.draw(wing4);
			}

			if(draw2)
			{
				Point2D.Double r1 = new Point2D.Double(-65 + x2, 50 + y2);
				Point2D.Double r2 = new Point2D.Double(-65 + x2, 90 + y2);
				Point2D.Double r3 = new Point2D.Double(-55 + x2, 60 + y2);
				Point2D.Double r4 = new Point2D.Double(-55 + x2, 80 + y2);
				Point2D.Double r5 = new Point2D.Double(-10 + x2, 60 + y2);
				Point2D.Double r6 = new Point2D.Double(-10 + x2, 80 + y2);
				Point2D.Double r7 = new Point2D.Double(0 + x2, 70 + y2);
				Point2D.Double r8 = new Point2D.Double(-40 + x2, 60 + y2);
				Point2D.Double r9 = new Point2D.Double(-20 + x2, 60 + y2);
				Point2D.Double r10 = new Point2D.Double(-30 + x2, 0 + y2);
				Point2D.Double r11 = new Point2D.Double(-40 + x2, 80 + y2);
				Point2D.Double r12 = new Point2D.Double(-20 + x2, 80 + y2);
				Point2D.Double r13 = new Point2D.Double(-30 + x2, 140 + y2);

				Line2D.Double secondTail1 = new Line2D.Double(r1, r2);
				Line2D.Double secondTail2 = new Line2D.Double(r1, r3);
				Line2D.Double secondTail3 = new Line2D.Double(r2, r4);
				Line2D.Double secondBody1 = new Line2D.Double(r3, r5);
				Line2D.Double secondBody2 = new Line2D.Double(r4, r6);
				Line2D.Double secondNose1 = new Line2D.Double(r5, r7);
				Line2D.Double secondNose2 = new Line2D.Double(r6, r7);
				Line2D.Double secondWing1 = new Line2D.Double(r8, r10);
				Line2D.Double secondWing2 = new Line2D.Double(r9, r10);
				Line2D.Double secondWing3 = new Line2D.Double(r11, r13);
				Line2D.Double secondWing4 = new Line2D.Double(r12, r13);

				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(secondTail1);
				g2.draw(secondTail2);
				g2.draw(secondTail3);
				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(secondBody1);
				g2.draw(secondBody2);
				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(secondNose1);
				g2.draw(secondNose2);
				g2.draw(secondWing1);
				g2.draw(secondWing2);
				g2.draw(secondWing3);
				g2.draw(secondWing4);
			}
		}
		else if(choice == 2)
		{
			if(draw1)
			{
				Point2D.Double p1 = new Point2D.Double(-50 + x, 20 + y);
				Point2D.Double p2 = new Point2D.Double(-30 + x, 40 + y);
				Point2D.Double p3 = new Point2D.Double(-50 + x, 40 + y);
				Point2D.Double p4 = new Point2D.Double(-50 + x, 60 + y);
				Point2D.Double p5 = new Point2D.Double(-65 + x, 60 + y);
				Point2D.Double p6 = new Point2D.Double(x, 60 + y);
				Point2D.Double p7 = new Point2D.Double(-60 + x, 80 + y);
				Point2D.Double p8 = new Point2D.Double(-10 + x, 80 + y);
			
				Line2D.Double flag1 = new Line2D.Double(p1, p2);
				Line2D.Double flag2 = new Line2D.Double(p2, p3);
				Line2D.Double flagPole = new Line2D.Double(p1, p4);
				Line2D.Double boatTop = new Line2D.Double(p5, p6);
				Line2D.Double boatBase = new Line2D.Double(p7, p8);
				Line2D.Double leftSide = new Line2D.Double(p5, p7);
				Line2D.Double rightSide = new Line2D.Double(p6, p8);
			
				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(flag1);
				g2.draw(flag2);
				g2.draw(flagPole);
				g2.draw(boatTop);
				g2.draw(boatBase);
				g2.draw(leftSide);
				g2.draw(rightSide);
			}
			
			if(draw2)
			{
				Point2D.Double r1 = new Point2D.Double(-50 + x2, 20 + y2);
				Point2D.Double r2 = new Point2D.Double(-30 + x2, 40 + y2);
				Point2D.Double r3 = new Point2D.Double(-50 + x2, 40 + y2);
				Point2D.Double r4 = new Point2D.Double(-50 + x2, 60 + y2);
				Point2D.Double r5 = new Point2D.Double(-65 + x2, 60 + y2);
				Point2D.Double r6 = new Point2D.Double(x2, 60 + y2);
				Point2D.Double r7 = new Point2D.Double(-60 + x2, 80 + y2);
				Point2D.Double r8 = new Point2D.Double(-10 + x2, 80 + y2);
			
				Line2D.Double secondFlag1 = new Line2D.Double(r1, r2);
				Line2D.Double secondFlag2 = new Line2D.Double(r2, r3);
				Line2D.Double secondFlagPole = new Line2D.Double(r1, r4);
				Line2D.Double secondBoatTop = new Line2D.Double(r5, r6);
				Line2D.Double secondBoatBase = new Line2D.Double(r7, r8);
				Line2D.Double secondLeftSide = new Line2D.Double(r5, r7);
				Line2D.Double secondRightSide = new Line2D.Double(r6, r8);
			
				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(secondFlag1);
				g2.draw(secondFlag2);
				g2.draw(secondFlagPole);
				g2.draw(secondBoatTop);
				g2.draw(secondBoatBase);
				g2.draw(secondLeftSide);
				g2.draw(secondRightSide);
			}
			
		}
		else
		{
			if(draw1)
			{
				Ellipse2D.Double clock = new Ellipse2D.Double(-100 + x, 0 + y, 100, 100);
				Ellipse2D.Double clock2 = new Ellipse2D.Double(-95 + x, 5 + y, 90, 90);
				Line2D.Double hourHand = new Line2D.Double(-50 + x, 15 + y, -50 + x, 50 + y);
				Line2D.Double minuteHand = new Line2D.Double(-10 + x, 50 + y, -50 + x, 50 + y);

				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.fill(clock);
				g2.setColor(Color.white);
				g2.fill(clock2);
				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(hourHand);
				g2.draw(minuteHand);
			}
			
			if(draw2)
			{
				Ellipse2D.Double secondClock = new Ellipse2D.Double(-100 + x2, 0 + y2, 100, 100);
				Ellipse2D.Double secondClock2 = new Ellipse2D.Double(-95 + x2, 5 + y2, 90, 90);
				Line2D.Double secondHourHand = new Line2D.Double(-50 + x2, 15 + y2, -50 + x2, 50 + y2);
				Line2D.Double secondMinuteHand = new Line2D.Double(-10 + x2, 50 + y2, -50 + x2, 50 + y2);

				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.fill(secondClock);
				g2.setColor(Color.white);
				g2.fill(secondClock2);
				g2.setColor(color[(int)(Math.random()*color.length)]);
				g2.draw(secondHourHand);
				g2.draw(secondMinuteHand);
			}
		}
	}

	@Override
	public void translate(int dx, int dy) 
	{
		x += dx;
		x2 += dx;
		y += dy;
		y2 += dy;
		
	}

}
