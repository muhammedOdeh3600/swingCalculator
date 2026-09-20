import javax.swing.*;
import java.awt.*;

public class CalculatorUI extends JFrame {

    JTextField display = new JTextField();
    String expression = "";

    public CalculatorUI() {
        setTitle("آلة حاسبة");
        setSize(250, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        display.setFont(new Font("Arial", Font.BOLD, 22));
        display.setEditable(false);
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton btn = new JButton(text);
            btn.setFont(new Font("Arial", Font.BOLD, 18));
            btn.addActionListener(e -> press(text));
            panel.add(btn);
        }
        add(panel, BorderLayout.CENTER);
    }

    private void press(String text) {
        if (text.equals("C")) {
            expression = "";
            display.setText("");
        } else if (text.equals("=")) {
            try {
                display.setText(String.valueOf(eval(expression)));
                expression = display.getText();
            } catch (Exception ex) {
                display.setText("خطأ");
                expression = "";
            }
        } else {
            expression += text;
            display.setText(expression);
        }
    }

    private double eval(String e) {
        if (e.contains("+")) {
            String[] p = e.split("\\+");
            return Double.parseDouble(p[0]) + Double.parseDouble(p[1]);
        } else if (e.contains("-")) {
            String[] p = e.split("-");
            return Double.parseDouble(p[0]) - Double.parseDouble(p[1]);
        } else if (e.contains("*")) {
            String[] p = e.split("\\*");
            return Double.parseDouble(p[0]) * Double.parseDouble(p[1]);
        } else if (e.contains("/")) {
            String[] p = e.split("/");
            return Double.parseDouble(p[0]) / Double.parseDouble(p[1]);
        } else {
            return Double.parseDouble(e);
        }
    }

    public static void main(String[] args) {
        new CalculatorUI().setVisible(true);
    }
}
