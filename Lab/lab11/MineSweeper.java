package lab11;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.Border;

public class MineSweeper extends JFrame {
	private int row;
	private int col;
	private JButton[][] buttons;
	private boolean[][] mines;
	private boolean gameover = false;
	private int totalClicked = 0;
	private int totalMines = 0;
	private int totalFlags = 0;
	private int totalCells = 0;
	private JLabel flagLeft;

	public MineSweeper() {
		this("MineSweeper", 10, 10, 10);
	}

	public MineSweeper(String title, int row, int col, int bombs) { // Contractor
		super(title);
		this.col = col;
		this.row = row;
		init(bombs);
		buttonsField();
		displayField();

		setSize(500, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	private void bombed(int i, int j) {
		if (mines[i][j]) {
			gameover = true;
			for (int i1 = 0; i1 < row; i1++) {
				for (int j1 = 0; j1 < col; j1++) {
					buttons[i1][j1].setEnabled(false);
					if (mines[i1][j1] == true) {
						buttons[i1][j1].setText("X");
						buttons[i1][j1].setBackground(Color.ORANGE);
						buttons[i1][j1].setFont(new Font("Consolas", Font.BOLD, 20));
					}
				}
			}
			buttons[i][j].setBackground(Color.RED);
		}
		restartGame();

		return;
	}

	private void flagClick(int i, int j) {
		if (buttons[i][j].getText().equals(">")) {
			buttons[i][j].setText("");
			flagLeft.setText("" + ++totalFlags);

		} else if (buttons[i][j].getBackground() == Color.GREEN) {
			buttons[i][j].setText(">");
			flagLeft.setText("" + --totalFlags);

		}
		buttons[i][j].setFont(new Font("Consolas", Font.BOLD, 20));
		buttons[i][j].setForeground(Color.RED);
	}

	private void init(int i) { // amount mines
		totalMines = i;
		totalFlags = i;
		totalCells = row * col - totalMines;
		mines = new boolean[row][col];
		Random r = new Random();
		while (i > 0) {
			int ranX = r.nextInt(row - 1);
			int ranY = r.nextInt(col - 1);
			if (!mines[ranX][ranY]) { // setting mine
				mines[ranX][ranY] = true;
				i--;
			}
		}
	}

	private int count(int x, int y) {
		int x1 = x - 1 < 0 ? 0 : x - 1;
		int y1 = y - 1 < 0 ? 0 : y - 1;
		int x2 = x + 2 > row - 1 ? row - 1 : x + 2; // bound of row
		int y2 = y + 2 > col - 1 ? col - 1 : y + 2; // bound of cols

		int c = 0;
		for (int i = x1; i < x2; i++)
			for (int j = y1; j < y2; j++)
				if (mines[i][j] == true)
					c++;

		return c;
	}

	private void reveal(int i, int j) {

		if (i == -1 || j == col || i == row || j == -1)
			return;

		if (buttons[i][j].getText().equals(">")) // button has revealed
			flagLeft.setText("" + ++totalFlags);

		if (buttons[i][j].getBackground() == Color.GRAY) // button has revealed
			return;

		int c = count(i, j);
		++totalClicked;

		buttons[i][j].setBackground(Color.GRAY);
		buttons[i][j].setEnabled(false);
		buttons[i][j].setText(c == 0 ? "" : "" + c);
		buttons[i][j].setFont(new Font("Consolas", Font.BOLD, 20));
		if (totalClicked == totalCells)
			if (totalFlags == 0)
				winGame();

		if (c > 0)
			return;

		reveal(i - 1, j); // up
		reveal(i, j + 1); // right
		reveal(i + 1, j); // down
		reveal(i, j - 1); // left

	}

	private void buttonsField() {
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(row, col));
		buttons = new JButton[row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				buttons[i][j] = new JButton();
				buttons[i][j].setBackground(Color.GREEN);

				// if (mines[i][j]) // cheat mode
				// buttons[i][j].setText("B");

				buttons[i][j].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						JButton b = (JButton) e.getSource();
						for (int i = 0; i < row; i++) {
							for (int j = 0; j < col; j++) {
								if (b == buttons[i][j] && !(mines[i][j]))
									reveal(i, j);
								else if (b == buttons[i][j] && (mines[i][j]))
									bombed(i, j);
							}
						}

					}
				});

				buttons[i][j].addMouseListener(new MouseAdapter() {

					@Override
					public void mouseClicked(MouseEvent e) {
						JButton b = (JButton) e.getSource();
						if (SwingUtilities.isRightMouseButton(e) && !(gameover))
							for (int i = 0; i < row; i++) {
								for (int j = 0; j < col; j++) {
									if (b == buttons[i][j] && !(buttons[i][j].getBackground() == Color.GRAY))
										flagClick(i, j);
								}
							}

						winCondition();
					}
				});
				jPanel.add(buttons[i][j]);
			}
		}
		add(jPanel);
	}

	private void displayField() {
		JPanel display = new JPanel();
		display.setLayout(new BorderLayout());

		JPanel showAmountFlag = new JPanel();
		flagLeft = new JLabel();
		flagLeft.setText("" + totalFlags); // total flags = total mines
		flagLeft.setFont(new Font("Consolas", Font.BOLD, 36));
		flagLeft.setVerticalAlignment(JLabel.CENTER);
		showAmountFlag.add(flagLeft);
		display.add(showAmountFlag, BorderLayout.WEST);
		add(display, BorderLayout.NORTH);

		JPanel optionSettings = new JPanel();
		optionSettings.setSize(10, 10);
		optionSettings.setLayout(new GridLayout(1, 2));

		JButton reset = new JButton();
		reset.setText("Reset!");
		reset.setFont(new Font("Arial", Font.BOLD, 16));
		reset.setForeground(Color.BLUE);
		reset.addActionListener((e) -> {
			newGame();
		});
		optionSettings.add(reset);
		display.add(optionSettings, BorderLayout.EAST);

	}

	private void winCondition() {
		if (totalClicked == totalCells)
			if (totalFlags == 0)
				winGame();
	}

	private void newGame() {
		totalCells = 0;
		totalFlags = 0;
		totalMines = 0;
		totalClicked = 0;
		dispose();
		main(null);
	}

	private void winGame() {
		JOptionPane.showConfirmDialog(null, "YOU WIN!!!", "MineSweeper", JOptionPane.CLOSED_OPTION);
		restartGame();
	}

	private void restartGame() {
		int choose = JOptionPane.showConfirmDialog(null, "Do you want to restart the game?", "MineSweeper",
				JOptionPane.YES_NO_OPTION);
		if (choose == 0) // Yes
			newGame();
		else if (choose == 1) // No
			dispose();

	}

	public static void main(String[] args) {
		new MineSweeper();

	}

}
