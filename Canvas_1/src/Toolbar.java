import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Toolbar extends JToolBar implements ChangeListener {
    static int stroke = 5;
    public Toolbar(){
        setBackground(Buttons.pretty);

        Buttons btn = new Buttons();
        JSlider strokeS = new JSlider(0,30,5);

        add(new Label("                          "));

        add(btn.buttons[1]);
        add(btn.buttons[2]);
        add(btn.buttons[3]);
        add(btn.buttons[0]);
        add(btn.buttons[4]);
        add(btn.buttons[5]);
        add(btn.buttons[6]);
        add(btn.buttons[7]);
        add(btn.buttons[8]);
        add(btn.buttons[9]);

        btn.buttons[5].setBackground(Color.black);//색상 설정 초기 버튼색
        btn.buttons[6].setBackground(Color.blue);

        strokeS.setMajorTickSpacing(5);
        strokeS.setMinorTickSpacing(1);
        strokeS.setPaintTicks(true); //눈금을 표시한다.
        strokeS.setPaintLabels(true);
        strokeS.addChangeListener(this);
        //strokeS.set
        add(strokeS);
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        JSlider value = (JSlider)e.getSource();
        stroke = value.getValue();
    }
}
