import java.awt.*;
import java.util.Vector;

public class Undo {
    private Point Start;
    private Point End;
    private Color Color;
    private int Mode;
    private int Storke;

    Undo(Point s, Point e, Color c, int m, int t){
        Start = s;
        End = e;
        Color = c;
        Mode = m;
        Storke = t;
    }

    public Point getStart() {
        return Start;
    }

    public void setStart(Point start) {
        Start = start;
    }

    public Point getEnd() {
        return End;
    }

    public void setEnd(Point end) {
        End = end;
    }

    public java.awt.Color getColor() {
        return Color;
    }

    public void setColor(java.awt.Color color) {
        Color = color;
    }

    public int getMode() {
        return Mode;
    }

    public void setMode(int mode) {
        Mode = mode;
    }

    public int getStorke() {
        return Storke;
    }

    public void setStorke(int storke) {
        Storke = storke;
    }
}
