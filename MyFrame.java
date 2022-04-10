package stepa_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class MyFrame extends JFrame {
    Solution solve = new Solution(new ArrayList<>());

    public MyFrame(String title) {
        super(title);
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        addMouseListener(new MyMouseListener());
        setVisible(true);
        repaint();
    }

    public void drawCircle(Graphics g, Circle newCircle){
        g.drawOval((int) (newCircle.point.x - newCircle.radius), (int) (newCircle.point.y - newCircle.radius), (int) newCircle.radius * 2, (int) newCircle.radius * 2);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        for (int i = 0; i < solve.circles.size(); i++) {
            Circle newCircle = solve.circles.get(i);
            g.setColor(Color.BLACK);
            drawCircle(g, newCircle);
        }
        List<Line> lines = solve.findLines(solve.circles);

        for (int j = 0; j < lines.size(); j++) {
            g.drawLine((int) lines.get(j).p1.x, (int) lines.get(j).p1.y, (int) lines.get(j).p2.x, (int) lines.get(j).p2.y);
        }

        Line line = solve.findMaxLength(lines);
        g.setColor(Color.BLUE);
        drawCircle(g, line.c1);
        drawCircle(g, line.c2);
        g.setColor(Color.RED);
        g.drawLine((int) line.p1.x, (int) line.p1.y, (int) line.p2.x, (int) line.p2.y);

    }

    private class MyMouseListener implements MouseListener {
        Point rememberedPoint;

        @Override
        public void mouseClicked(MouseEvent e) {
            Point newPoint = new Point(e.getX(), e.getY());
            if (rememberedPoint != null) {
                Circle circle = new Circle(rememberedPoint, newPoint);
                solve.circles.add(circle);
                rememberedPoint = null;
                repaint();
            } else {
                rememberedPoint = newPoint;
            }

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}


