import com.sun.glass.ui.Size;

import javax.swing.*;
import java.awt.*;

public class Canvas {
    JFrame frame = new JFrame("지수's 그림판");//프레임 생성
    Canvas(){
        //frame.setLayout(null);
        //frame.getContentPane().setBackground(Color.black);
        //frame.setResizable(false);
        //frame.setLocationRelativeTo(null);//그림판 뜨는 위치
        frame.setPreferredSize(new Dimension(1000, 750));//프레임 크기
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//끄기
        frame.pack();
        frame.setVisible(true);

    }
}
