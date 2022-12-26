import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Stack;
import java.util.Vector;

import javax.swing.*;

public class Draw extends JPanel implements MouseListener, MouseMotionListener {
    Vector<Point> vStart = new Vector<>();
    Vector<Point> vEnd = new Vector<>();
    static Vector<Integer> vMode = new Vector<>();
    Vector<Color> vColor = new Vector<>();
    Vector<Integer> vStroke = new Vector<>();
    boolean flag = false;
    Point endPoint = new Point();
    Point startPoint = new Point();
    //Vector<Undo> move = new Vector<>();
    Stack<Undo> movePen = new Stack<>();
    Stack<Undo> moveFigure = new Stack<>();


        public Draw(){
        addMouseListener(this);
        addMouseMotionListener(this);
        setBackground(Color.WHITE);
        setSize(950, 700);

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startPoint = e.getPoint();
        vStart.add(e.getPoint());
        vMode.add(Buttons.buttonType);

        if(Buttons.distinction == 0)
            vColor.add(Buttons.color);
        else
            vColor.add(Buttons.color2);

        vStroke.add(Toolbar.stroke);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        flag = false;
        vEnd.add(e.getPoint());
        if(Buttons.buttonType == 1 || Buttons.buttonType == 2 || Buttons.buttonType == 3) {//도형일때
            if (Buttons.distinction == 0)
                moveFigure.add(new Undo(startPoint, endPoint, Buttons.color, Buttons.buttonType, Toolbar.stroke));
            else
                moveFigure.add(new Undo(startPoint, endPoint, Buttons.color2, Buttons.buttonType, Toolbar.stroke));
        }
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
        if(Buttons.buttonType == 0 ||Buttons.buttonType == 4 ){
            vEnd.add(e.getPoint());
            repaint();
            vStart.add(e.getPoint());
            vMode.add(Buttons.buttonType);

            if(Buttons.distinction == 0)
                vColor.add(Buttons.color);
            else
                vColor.add(Buttons.color2);

            vStroke.add(Toolbar.stroke);
        }
        else if (Buttons.buttonType == 1 || Buttons.buttonType == 2 || Buttons.buttonType == 3) {
            flag = true;
            endPoint = (e.getPoint());
            repaint();
       }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int i = 0; i < vEnd.size(); i++) {

            Point s = vStart.get(i);
            Point e = vEnd.get(i);
            g.setColor(Color.BLACK);
            g.setColor(vColor.get(i));
            g2.setStroke(new BasicStroke(vStroke.get(i),BasicStroke.CAP_ROUND,0));

            if(Buttons.undo == true) {
                if (Buttons.buttonType == 0 || Buttons.buttonType == 4) {//펜, 지우개 일때
                    if (Buttons.distinction == 0)
                        movePen.add(new Undo(startPoint, endPoint, Buttons.color, Buttons.buttonType, Toolbar.stroke));
                    else
                        movePen.add(new Undo(startPoint, endPoint, Buttons.color2, Buttons.buttonType, Toolbar.stroke));
                }
            }

            if (vMode.get(i) == 0) {//스케치
                g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());
            } else if (vMode.get(i) == 1) {//직선
                g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());
            } else if (vMode.get(i) == 2) {//사각형
                g.drawRect(Math.min((int) s.getX(),(int) e.getX()), Math.min((int) s.getY(),(int) e.getY()), Math.abs((int) e.getX() - (int) s.getX()), Math.abs((int) e.getY() - (int) s.getY()));
                //g.drawRoundRect(Math.min((int) s.getX(),(int) e.getX()), Math.min((int) s.getY(),(int) e.getY()), Math.abs((int) e.getX() - (int) s.getX()), Math.abs((int) e.getY() - (int) s.getY()),30,30);
            } else if (vMode.get(i) == 3) {//원
                g.drawOval(Math.min((int) s.getX(),(int) e.getX()), Math.min((int) s.getY(),(int) e.getY()), Math.abs((int) e.getX() - (int) s.getX()), Math.abs((int) e.getY() - (int) s.getY()));
            } else if (vMode.get(i) == 4) {//지우개
                g.setColor(Color.white);
                g.drawLine((int) s.getX(), (int) s.getY(), (int) e.getX(), (int) e.getY());
            } else
                System.out.println("못그려요");
        }
        if (flag == true) {
            Point a = startPoint;
            Point b = endPoint;
            g.setColor(Color.lightGray);
            ((Graphics2D) g).setStroke(new BasicStroke(5, BasicStroke.CAP_ROUND, 0));
            if (Buttons.buttonType == 1) {
                g.drawLine((int) a.getX(), (int) a.getY(), (int) b.getX(), (int) b.getY());
                flag = false;
            } else if (Buttons.buttonType == 2) {
                g.drawRect(Math.min((int) a.getX(), (int) b.getX()), Math.min((int) a.getY(), (int) b.getY()), Math.abs((int) a.getX() - (int) b.getX()), Math.abs((int) a.getY() - (int) b.getY()));
                flag = false;
            } else if (Buttons.buttonType == 3) {
                g.drawOval(Math.min((int) a.getX(), (int) b.getX()), Math.min((int) a.getY(), (int) b.getY()), Math.abs((int) a.getX() - (int) b.getX()), Math.abs((int) a.getY() - (int) b.getY()));

            }
        }
    }
}
