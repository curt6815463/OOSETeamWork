package team87;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ShapeClicker {

    public ShapeClicker() {
        JFrame frame = new JFrame();
        frame.setTitle("Shape Clicker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        initComponents(frame);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {

        //create frame and components on EDT
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ShapeClicker();
            }
        });
    }

    private void initComponents(JFrame frame) {
        frame.add(new ShapePanel());
    }
}

//custom panel
class myEllipse extends Ellipse2D.Double
{
	String title;
	double x,y;
	myEllipse(double x,double y ,double weight,double height,String str)
	{
		super(x,y,weight,height);
		title = str;
		this.x = x;
		this.y = y;
	}
	public String getTitle()
	{
		return title;
	}
	public int getx()
	{
		return (int)x;
	}
	public int gety()
	{
		return (int)y;
	}
}
class ShapePanel extends JPanel {

    private Dimension dim = new Dimension(800, 600);
    private final ArrayList<Shape> shapes;

    public ShapePanel() {
        shapes = new ArrayList<>();
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me)
            {
            	shapes.add(new myEllipse(me.getX()-50, me.getY()-50, 100, 100,"asdf"));

            	repaint();
            }
            public void mouseClicked(MouseEvent me) {
            	
            	
                for (Shape s : shapes) {

                    if (s.contains(me.getPoint())) {                                      
                    	shapes.remove(s);
                    }
                }
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        Graphics2D g2d = (Graphics2D) grphcs;
        for (Shape s : shapes) {
            g2d.draw(s);
            g2d.drawString(((myEllipse)s).getTitle(),((myEllipse)s).getx() , ((myEllipse)s).gety());
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return dim;
    }
}
