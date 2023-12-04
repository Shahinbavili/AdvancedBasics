import calculator.Calculator;

import javax.swing.*;

public class CalculatorUI {

    private static JTextField jTextField;
    private static String adadAval;

    public static void main(String[] args) {
        JFrame mashinHessab = new JFrame("Mashin Hessab");

        jTextField = new JTextField();
        jTextField.setBounds(0, 0, 150, 50);
        jTextField.setEditable(false);

        JButton cancel = new JButton("C");
        cancel.setBounds(150, 0, 50, 50);
        cancel.addActionListener(e -> jTextField.setText(""));

        JButton one = getButton("1", 0, 50);

        JButton two = getButton("2", 50, 50);

        JButton three = getButton("3", 100, 50);

        JButton addition = new JButton("+");
        addition.setBounds(150, 50, 50, 50);
        addition.addActionListener(e -> {
            adadAval = jTextField.getText();
            jTextField.setText("");
        });

        JButton four = getButton("4", 0, 100);

        JButton five = getButton("5", 50, 100);

        JButton six = getButton("6", 100, 100);

        JButton subtraction = new JButton("-");
        subtraction.setBounds(150, 100, 50, 50);

        JButton seven = getButton("7", 0, 150);

        JButton eight = getButton("8", 50, 150);

        JButton nine = getButton("9", 100, 150);

        JButton multiplication = new JButton("*");
        multiplication.setBounds(150, 150, 50, 50);

        JButton point = new JButton(".");
        point.setBounds(0, 200, 50, 50);
        point.addActionListener(e -> {
            String currentText = jTextField.getText();
            if (!currentText.contains(".")) {
                jTextField.setText(currentText + point.getText());
            }
        });


        JButton zero = getButton("0", 50, 200);

        JButton equal = new JButton("=");
        equal.setBounds(100, 200, 50, 50);
        equal.addActionListener(e -> {
            Calculator calculator = new Calculator();
            String addResulat = calculator.add(adadAval, jTextField.getText());
            jTextField.setText(addResulat);
        });

        JButton division = new JButton("/");
        division.setBounds(150, 200, 50, 50);

        mashinHessab.add(jTextField);
        mashinHessab.add(cancel);
        mashinHessab.add(one);
        mashinHessab.add(two);
        mashinHessab.add(three);
        mashinHessab.add(four);
        mashinHessab.add(five);
        mashinHessab.add(six);
        mashinHessab.add(seven);
        mashinHessab.add(eight);
        mashinHessab.add(nine);
        mashinHessab.add(equal);
        mashinHessab.add(addition);
        mashinHessab.add(subtraction);
        mashinHessab.add(multiplication);
        mashinHessab.add(point);
        mashinHessab.add(zero);
        mashinHessab.add(division);


        mashinHessab.setSize(400, 550);
        mashinHessab.setLayout(null);
        mashinHessab.setVisible(true);
    }

    private static JButton getButton(String label, int xPosition, int yPosition) {
        JButton button = new JButton(label);
        button.setBounds(xPosition, yPosition, 50, 50);
        button.addActionListener(e -> jTextField.setText(jTextField.getText() + button.getText()));
        return button;
    }
}
