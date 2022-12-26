import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Canvas canvas = new Canvas();
        Toolbar toolbar = new Toolbar();
        Draw draw = new Draw();

        canvas.frame.add(toolbar, BorderLayout.NORTH);
        canvas.frame.add(draw);//panel
    }
}