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
		s = new Ellipse2D.Double(loc.x-70,loc.y-70,150,150);
		currentS = (Double) s;
        g2d.draw(s);
	}
	@Override
	public boolean intersect(Point p) {
		return true;	
	}

	
}