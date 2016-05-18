package team87;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
/**
 * @web http://java-buddy.blogspot.com/
 */
public class JavaSwingDrawing extends JComponent {
     
    int mouseX, mouseY;
    int mouseX_dragged, mouseY_dragged;
    boolean mouseDragged;
 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            createAndShowGUI();
        });
    }
 
    public JavaSwingDrawing() {
        addMouseListener(myMouseAdapter);
        addMouseMotionListener(myMouseAdapter);
    }
     
    MouseAdapter myMouseAdapter = new MouseAdapter(){
 
        @Override
        public void mousePressed(MouseEvent e) {
            mouseX = e.getX();
            mouseY = e.getY();
            mouseDragged = false;
            repaint();
        }
 
        @Override
        public void mouseDragged(MouseEvent e) {
            mouseX_dragged = e.getX();
            mouseY_dragged = e.getY();
            mouseDragged = true;
            repaint();
        }
 
    };
 
    @Override
    public void paint(Graphics g) {
         
        Graphics2D graphics2d = (Graphics2D)g;
        graphics2d.setColor(Color.blue);
        if(mouseDragged){
            int x, y;
            int w, h;
             
            if(mouseX > mouseX_dragged){
                x = mouseX_dragged;
                w = mouseX - mouseX_dragged;
            }else{
                x = mouseX;
                w = mouseX_dragged - mouseX;
            }
             
            if(mouseY > mouseY_dragged){
                y = mouseY_dragged;
                h = mouseY - mouseY_dragged;
            }else{
                y = mouseY;
                h = mouseY_dragged - mouseY;
            }
             
            graphics2d.drawOval(x, y, w, h);
        }else{
            graphics2d.fillOval(mouseX-5, mouseY-5, 10, 10);
        }
    }
 
    private static void createAndShowGUI() {
        JFrame myFrame = new JFrame();
        myFrame.setTitle("java-buddy.blogspot.com");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setSize(new Dimension(400, 300));
        myFrame.setLayout(new BorderLayout());
        myFrame.add(new JavaSwingDrawing(), BorderLayout.CENTER);
        myFrame.setVisible(true);
    }
}
