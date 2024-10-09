package lab10;

import java.text.DecimalFormat;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calculator extends JFrame {
    private JButton button_1, button_2, button_3, button_4, button_5,
            button_6, button_7, button_8, button_9, button_0, button_add,
            button_subtract, button_multiply, button_divide, button_equals,
            button_clear, button_clearEntry, button_negate, button_del, button_dot;
    private double result = 0;
    private boolean operatorPressed = false;
    private String operator = "";
    private JTextField tf;
    private JPanel panel;
    

    public Calculator(String title) {
        super(title);
        setLayout(new BorderLayout());

        tf = new JTextField("0");
        tf.setEditable(false);
        tf.setFont(new Font("Arial", Font.PLAIN, 35));
        tf.setHorizontalAlignment(JTextField.RIGHT);
        add(tf, BorderLayout.NORTH);

        // Area Buttons
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        // Button management
        createButtons();
        addToPanel();
        addButtonEvents();

        add(panel, BorderLayout.CENTER);

        setSize(300, 350);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createButtons() {
        // Create Buttons
        // # Number 0-9
        button_1 = new JButton("1");
        button_2 = new JButton("2");
        button_3 = new JButton("3");
        button_4 = new JButton("4");
        button_5 = new JButton("5");
        button_6 = new JButton("6");
        button_7 = new JButton("7");
        button_8 = new JButton("8");
        button_9 = new JButton("9");
        button_0 = new JButton("0");
        // # Operators
        button_add = new JButton("+");
        button_subtract = new JButton("-");
        button_multiply = new JButton("*");
        button_divide = new JButton("/");
        button_equals = new JButton("=");
        // # Special Buttons
        button_clear = new JButton("C");
        button_clearEntry = new JButton("CE");
        button_negate = new JButton("+/-");
        button_del = new JButton("Del");
        button_dot = new JButton(".");
    }

    private void addToPanel() {
        panel.add(button_clearEntry);
        panel.add(button_clear);
        panel.add(button_del);
        panel.add(button_divide);
        panel.add(button_7);
        panel.add(button_8);
        panel.add(button_9);
        panel.add(button_multiply);
        panel.add(button_4);
        panel.add(button_5);
        panel.add(button_6);
        panel.add(button_subtract);
        panel.add(button_1);
        panel.add(button_2);
        panel.add(button_3);
        panel.add(button_add);
        panel.add(button_negate);
        panel.add(button_0);
        panel.add(button_dot);
        panel.add(button_equals);
    }

    private void addButtonEvents() {
        button_0.addActionListener((e) -> numberInput("0"));
        button_1.addActionListener((e) -> numberInput("1"));
        button_2.addActionListener((e) -> numberInput("2"));
        button_3.addActionListener((e) -> numberInput("3"));
        button_4.addActionListener((e) -> numberInput("4"));
        button_5.addActionListener((e) -> numberInput("5"));
        button_6.addActionListener((e) -> numberInput("6"));
        button_7.addActionListener((e) -> numberInput("7"));
        button_8.addActionListener((e) -> numberInput("8"));
        button_9.addActionListener((e) -> numberInput("9"));
        button_dot.addActionListener((e) -> numberInput("."));

        button_add.addActionListener((e) -> operatorInput("+"));
        button_subtract.addActionListener((e) -> operatorInput("-"));
        button_multiply.addActionListener((e) -> operatorInput("*"));
        button_divide.addActionListener((e) -> operatorInput("/"));

        button_clear.addActionListener((e) -> specialInput("C"));
        button_clearEntry.addActionListener((e) -> specialInput("CE"));
        button_del.addActionListener((e) -> specialInput("Del"));
        button_negate.addActionListener((e) -> specialInput("+/-"));

        button_equals.addActionListener((e) -> {
            calResult();
            operator = "";
            operatorPressed = false;
        });
    }

    private void numberInput(String number) {
        if (operatorPressed) {
            tf.setText("");
            operatorPressed = false;
        }

        if (tf.getText().equals("0"))
            tf.setText(number);
        else
            tf.setText(tf.getText() + number);
    }

    private void operatorInput(String operator) {
        if (!this.operator.isEmpty() && !operatorPressed) { // this.operate มี และ ปุ่ม operate ไม่ได้กดอยู่
            calResult();
        } else if (operatorPressed) { // กดปุ่ม operator อยู่ แต่มีการเปลี่ยน operator
            this.operator = operator;
        }

        result = Double.parseDouble(tf.getText());
        this.operator = operator;
        operatorPressed = true;
    }

    private void specialInput(String specialbt) {
        switch (specialbt) {
            case "C":
                result = 0;
                operator = "";
                tf.setText("0");
                break;
            case "CE":
                tf.setText("0");
                break;
            case "Del":
                String curr = tf.getText();
                if (curr.length() > 1)
                    tf.setText(tf.getText().substring(0, curr.length() - 1));
                else
                    tf.setText("0");
                break;
            case "+/-":
                double negate;
                negate = Double.parseDouble(tf.getText());
                negate *= -1;
                if (negate % 1 != 0) {
                    DecimalFormat df = new DecimalFormat("#.######");
                    tf.setText(df.format(negate));
                } else
                    tf.setText(String.valueOf((int) negate));
                break;
        }
    }

    private void calResult() {
        double num2 = Double.parseDouble(tf.getText());
        switch (operator) {
            case "+":
                result += num2;
                checkDecimal(result);
                break;
            case "-":
                result -= num2;
                checkDecimal(result);
                break;
            case "*":
                result *= num2;
                checkDecimal(result);
                break;
            case "/":
                result /= num2;
                checkDecimal(result);
                break;
        }
    }

    private void checkDecimal(double result) {
        if (result % 1 != 0) {
            DecimalFormat df = new DecimalFormat("#.######");
            tf.setText(df.format(result));
        } else
            tf.setText(String.valueOf((int) result));
    }

    public static void main(String[] args) {
        new Calculator("Calculator");
    }

}
