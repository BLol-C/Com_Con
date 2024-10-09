package lab10;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

import java.awt.event.*;

public class CalculatorV2 extends JFrame implements ActionListener{
	private JTextField display;
	private JPanel northPanel;
	private JPanel centerPanel;
	private JButton buttons[];
	private String btext[] = {"7", "8" ,"9", "x" ,"0", "1", "2", "3" , "4", "5", "6",  "+", "-", "x" , "/", "=", "C","CE", "+/-","."};
	
	public CalculatorV2(String title) {
		super(title);
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(getCenterPanel(), BorderLayout.SOUTH);
		
		
		setSize(350,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	private JPanel getNorthPanel() {
		northPanel = new JPanel();
		display = new JTextField("0");
		
		
		return northPanel;
	}
	
	private JPanel getCenterPanel() {
		buttons = new JButton[btext.length];
		centerPanel = new JPanel();
		for(int i = 0; i < btext.length ; i++) {
			buttons[i] = new JButton(btext[i]);
			buttons[i].setFont(new Font("Consolas", Font.PLAIN, 35));
			buttons[i].addActionListener(this);
			centerPanel.add(buttons[i]);
		}
		return centerPanel;
	}
		
	
	public static void main(String[] args) {
		new CalculatorV2("Calculator");
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
