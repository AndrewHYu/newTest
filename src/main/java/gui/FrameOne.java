package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Andrew  on 2016/8/31.
 */
public class FrameOne extends JFrame implements ActionListener{
    private JButton jb1=new JButton("新窗口");
     public FrameOne(){
         this.add(jb1);
         jb1.addActionListener(this);
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
         setVisible(true);
    }
    public static void main(String[]args){
        new FrameOne();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==jb1){
            new FrameTwo();
        }
    }
}
