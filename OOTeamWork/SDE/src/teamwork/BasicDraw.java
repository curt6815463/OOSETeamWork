package teamwork;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JComponent;
import javax.swing.JFrame;

public class BasicDraw {
  public static void main(String[] args) {
    new BasicDraw();
  }

  BasicDraw() {
    JFrame frame = new JFrame();

    frame.add(new MyComponent());

    frame.setSize(300, 300);
    frame.setVisible(true);
  }

}

class MyComponent extends JComponent {

  public void paint(Graphics g) {
    // Retrieve the graphics context; this object is used to paint shapes
    Graphics2D g2d = (Graphics2D) g;

    // Determine if antialiasing is enabled
    RenderingHints rhints = g2d.getRenderingHints();
    boolean antialiasOn = rhints.containsValue(RenderingHints.VALUE_ANTIALIAS_ON);

    // Enable antialiasing for shapes
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

  }

}