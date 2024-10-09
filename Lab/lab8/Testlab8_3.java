package lab8;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Testlab8_3 implements ActionListener {
	static int i = 0;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Test");
        frame.setSize(250, 300);
        frame.setEnabled(true);

        JPanel center = new JPanel();
        JButton jb = new JButton("Click");
        center.add(jb);

        frame.setVisible(true);
        frame.getContentPane().add(center, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        jb.addActionListener((e)-> {
			
 
//        	@Override
//            public void actionPerformed(ActionEvent e) {
                {if (e.getSource() == jb) {
                	i++;
                	jb.setText("" + i);
                }
            }
            
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
