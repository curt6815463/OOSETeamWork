package teamwork;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class RectangleDrawWithDrag extends JPanel{

    private static final int D_W = 400;
    private static final int D_H = 400;
    private static final Color DEFAULT_COLOR = Color.GRAY;
    private static final Color SELECT_COLOR = Color.BLUE;
    private static final Color CURSOR_COLOR = new Color(100, 100, 100, 100);

    private Point p1;
    private Point p2;
    private Rectangle2D rectangle;
    private List<ColoredRectangle> rectangles;

    public RectangleDrawWithDrag() {
        rectangles = createRectangleList();
        addMouseListener(new MouseAdapter(){
            public void mousePressed(MouseEvent e) {
                p1 = e.getPoint();
                rectangle = new Rectangle2D.Double(p1.x, p1.y, p1.x - p1.x, p1.y - p1.y);
            }
        });
        addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseDragged(MouseEvent e) {
                p2 = e.getPoint();
                if (isPointTwoInQuadOne(p1, p2)) {
                    rectangle.setRect(p2.x, p2.y, p1.x - p2.x, p1.y - p2.y);
                } else {
                    rectangle.setRect(p1.x, p1.y, p2.x - p1.x, p2.y - p1.y);  
                }
                checkRectangleContainment();
                repaint();
            }
        });
    }

    public void checkRectangleContainment() {
        for (ColoredRectangle rects: rectangles) {
            if (rectangle.contains(rects.getRectangle())) {
                rects.setColor(SELECT_COLOR);
            } else {
                rects.setColor(DEFAULT_COLOR);
            }
        }
    }

    public boolean isPointTwoInQuadOne(Point p1, Point p2) {
        return p1.x >= p2.x && p1.y >= p2.y;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        for (ColoredRectangle rect: rectangles) {
            rect.draw(g2);
        }
        if (rectangle != null) {
            g2.setColor(CURSOR_COLOR);
            g2.fill(rectangle);
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(D_W, D_H);
    }

    private List<ColoredRectangle> createRectangleList() {
        List<ColoredRectangle> rects = new ArrayList<>();
        Random rand= new Random();
        for (int i = 0; i < 20; i++) {
            rects.add(new ColoredRectangle(rand.nextInt(D_W), rand.nextInt(D_H)));
        }
        return rects;
    }

    public class ColoredRectangle {
        Rectangle2D rectangle;
        Color color = DEFAULT_COLOR;
        double size = 20;

        public ColoredRectangle(double x, double y) {
            rectangle = new Rectangle2D.Double(x, y, size, size);
        }

        public ColoredRectangle(double x, double y, double size) {
            this.size = size;
            rectangle = new Rectangle2D.Double(x, y, size, size);
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public Rectangle2D getRectangle() {
            return rectangle;
        }

        public void draw(Graphics2D g2) {
            g2.setColor(color);
            g2.fill(rectangle);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame frame = new JFrame();
                frame.add(new RectangleDrawWithDrag());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
