import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * An icon that contains a moveable shape.
 * 
 * @author fmeade
 */
public class ShapeIcon implements Icon
{
	/* Width of the shape */
	private int width;
	
	/* Height of the shape */
	private int height;
	
	/* ArrayList of the shapes */
	private ArrayList<Shape> shapes;
	
	/**
	 * Constructor that instantiates the instance variables.
	 * 
	 * @param _width width of the shape
	 * @param _height height of the shape
	 */
	public ShapeIcon(int _w, int _h)
	{
		width = _w;
		height = _h;
		shapes = new ArrayList<Shape>();
	}

	/** getters */
	public int getIconWidth() { return width; }
	public int getIconHeight(){ return height; }
	
	/**
	 * adds a new shape to the window
	 * @param newShape new shape
	 */
	public void addShape(Shape newShape){ shapes.add(newShape); }
	
	
	/** Removes the shape from the window. */
	public void remove()
	{
		if(shapes.isEmpty() == false)
			shapes.remove(shapes.size() - 1);
	}
	
	
	/** Removes all the shapes from the window. */
	public void removeAll(){ shapes.removeAll(shapes); }
	
	
	/** Sets the shapes on the window in motion. */
	public void move()
	{
		int i = 0;
		
		while(i < shapes.size())
		{
			shapes.get(i).translate(1, 0);
			i++;
		}
	}

	/**
	 * Puts the shape onto the window.
	 * 
	 * @param _c shape
	 * @param _g shape
	 * @param _x x coordinate
	 * @param _y y coordinate
	 */
	public void paintIcon(Component _c, Graphics _g, int _x, int _y)
	{
		Graphics2D g2 = (Graphics2D) _g;
		int i = 0;
		
		while(i < shapes.size())
		{
			shapes.get(i).draw(g2);
			i++;
		}
	}
}


