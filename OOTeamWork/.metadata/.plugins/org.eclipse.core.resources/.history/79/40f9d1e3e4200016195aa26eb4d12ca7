package sde;

import java.awt.*;
import java.awt.geom.*;
import java.awt.geom.Ellipse2D.Double;



public class State extends DiagramElement{
	Ellipse2D.Double currentS;
	State(int x, int y)
	{
		loc = new Point(x,y);
		
	}
	@Override
	public void paint(Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		s = new Ellipse2D.Double(loc.x-35,loc.y-35,70,70);
		currentS = (Double) s;
        g2d.draw(s);
	}
	@Override
	public boolean intersect(Point p) {
		return true;	
	}
	public boolean isContain(int x,int y)
	{
		if(currentS.contains(x, y))
		{
			return true;
		}
		return false;
	}

	public void setLoc(int x, int y) {
		currentS.x += x;
		currentS.y += y;
	}
	
}