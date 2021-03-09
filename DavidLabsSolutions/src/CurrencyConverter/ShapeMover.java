package CurrencyConverter;

import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

public class ShapeMover extends JFrame implements ActionListener {

    private CanvasPanel drawingArea = new CanvasPanel();

    private JButton change = new JButton("Change Shape");


    public ShapeMover()
    {
        setLayout(new FlowLayout());

        setSize(750,750);
    }

    public void init()
    {
        change.addActionListener(this);
        add(change);

        add(drawingArea);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        drawingArea.changeShape();
    }

    class CanvasPanel extends JPanel implements MouseListener, MouseInputListener {

        private ArrayList<Shape> shapes = new ArrayList<>();

        private boolean isPressed = false;

        private int activeShape = -1;

        private int currentShape = 1;


        public CanvasPanel()
        {
            addMouseListener(this);
            addMouseMotionListener(this);
            setBackground(Color.GRAY);
            setPreferredSize(new Dimension(700,700));
        }

        public void drawShapes(Graphics g)
        {
            Graphics2D g2d = (Graphics2D) g;

            g2d.setColor(Color.BLUE);

            for(Shape s : shapes)
            {
                g2d.fill(s);
            }
        }

        public void changeShape()
        {
            if (currentShape == 1)
                currentShape = 2;
            else
                currentShape = 1;
        }

        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);

            drawShapes(g);

        }

        @Override
        public void mouseClicked(MouseEvent e) {

        }

        @Override
        public void mousePressed(MouseEvent e) {

            for(int i = 0; i < shapes.size(); i++)
            {
                Shape shape = shapes.get(i);

                if(shape.contains(e.getPoint()))
                {
                    activeShape = i;
                    isPressed = true;
                    break;
                }
            }

        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if(!isPressed)
            {
                if (currentShape == 1)
                {
                    shapes.add(new Ellipse2D.Double(e.getX() -20, e.getY() -20, 40, 40));
                }
                else
                {
                    shapes.add(new Rectangle2D.Double(e.getX() -20, e.getY() -20, 40, 40));
                }
            }

            isPressed = false;

            activeShape = -1;

            repaint();

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {
            //System.out.println("Just Dragging");
            if(isPressed)
            {
                Shape s = shapes.get(activeShape);
                if (s instanceof Ellipse2D)
                {
                    shapes.set(activeShape, new Ellipse2D.Double(e.getX() - 20, e.getY()- 20, 40,40));
                }
                else {
                    shapes.set(activeShape, new Rectangle2D.Double(e.getX() - 20, e.getY() - 20, 40, 40));
                }

            }

            repaint();
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            //System.out.println("Just Moving");
        }
    }

    public static void main(String[] args) {
        new ShapeMover().init();

    }
}
