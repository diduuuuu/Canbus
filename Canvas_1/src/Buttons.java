import com.sun.glass.ui.Size;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Buttons {
    static JButton[] buttons = new JButton[11];
    static int buttonType = 0;
    static JColorChooser cd = new JColorChooser();
    static Color color = Color.BLACK;
    static Color color2 = Color.BLUE;
    static int counter1 = 1;
    static int counter2 = 0;
    static int distinction = 0;


    Buttons() {
        for (int i = 0; i < 5; i++) {
            buttons[i] = new JButton(new ImageIcon("icon/" + i + ".png"));
            buttons[i].setBackground(Color.PINK);
        }
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonType = 0;
                for(int i = 0; i < 5; i++){
                    if(i == 0)
                        buttons[i].setBackground(Color.white);
                    else
                        buttons[i].setBackground(Color.PINK);
                }
            }
        });
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonType = 1;
                for(int i = 0; i < 5; i++){
                    if(i == 1)
                        buttons[i].setBackground(Color.white);
                    else
                        buttons[i].setBackground(Color.PINK);
                }
            }
        });
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonType = 2;
                for(int i = 0; i < 5; i++){
                    if(i == 2)
                        buttons[i].setBackground(Color.white);
                    else
                        buttons[i].setBackground(Color.PINK);
                }
            }
        });
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonType = 3;
                for(int i = 0; i < 5; i++){
                    if(i == 3)
                        buttons[i].setBackground(Color.white);
                    else
                        buttons[i].setBackground(Color.PINK);
                }
            }
        });
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonType = 4;
                for(int i = 0; i < 5; i++){
                    if(i == 4)
                        buttons[i].setBackground(Color.white);
                    else
                        buttons[i].setBackground(Color.PINK);
                }
            }
        });
        buttons[5] = new JButton("               ");
        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttons[5].setSize(50,25);
                    if(distinction == 0){//현재 설정 값이 5인 상태
                        if (counter1 == 0){
                            buttons[5].setBackground(color);
                            buttons[5].setText("      V      ");
                            buttons[6].setText("                 ");
                            counter1 += 1;
                        }
                        else if (counter1 == 1){
                            color = cd.showDialog(null, "색상", Color.BLACK);
                            buttons[5].setBackground(color);
                            counter1 -= 1;
                    }
                }
                    else if(distinction == 1){//현재 설정값이 6인 상태
                        buttons[5].setBackground(color);
                        buttons[5].setText("      V      ");
                        buttons[6].setText("                ");
                        counter1 = 1;
                        distinction = 0;
                    }
            }
        });

        buttons[6] = new JButton("               ");
        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(distinction == 1){
                    if (counter2 == 0){
                        buttons[6].setBackground(color2);
                        buttons[6].setText("      V      ");
                        buttons[5].setText("                ");
                        counter2 += 1;
                    }
                    else if (counter2 == 1){
                        color2 = cd.showDialog(null, "색상", Color.BLACK);
                        buttons[6].setBackground(color2);
                        counter2 -= 1;
                    }
                }
                else if(distinction == 0){
                    buttons[6].setBackground(color2);
                    buttons[6].setText("      V      ");
                    buttons[5].setText("                ");
                    distinction = 1;
                    counter2 = 1;
                }
            }
        });
        buttons[7] = new JButton("파일 저장");
        buttons[7].setBackground(Color.PINK);
        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonType = 7;
                File file = new File();
            }
        });
        buttons[8] = new JButton("이전");
        buttons[8].setBackground(Color.PINK);
        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonType = 8;
            }
        });
        buttons[9] = new JButton("이후");
        buttons[9].setBackground(Color.PINK);
        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonType = 9;
            }
        });
    }
}
