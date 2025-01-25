package scintificCalculator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScintificCalculator extends JFrame implements ActionListener {
    private JTextField display;
    private String operator;
    private double firstNumber;
    

    public ScintificCalculator() {
        setTitle("Scientific Calculator");
        setSize(600, 500);//w l
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        display = new JTextField(50);
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN,50)); //textfeild size
        add(display, BorderLayout.NORTH);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 4));

        String[] buttons = {
            "1","2","3","B",
            "4","5","6","C",
            "7","8","9","+/-",
            ".","0","||","=",
            "+","-","*","/",
            "sin","cos","tan","log",
            "sinh","cosh","tanh","√",
            "exp","X^2","X^Y","3^√",
            
            
            
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial",Font.BOLD,24));
            button.addActionListener(this);
            panel.add(button);
        }

        add(panel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if ("0123456789.".contains(command)) {
            display.setText(display.getText() + command);
        } 
        else if(command.equals("+/-")){
        String currentText=display.getText();
        
        if(!currentText.isEmpty())
        {
        double currentValue=Double.parseDouble(currentText);
        
        currentValue = -currentValue;
        
        display.setText(String.valueOf(currentValue));
        }
        }
        
        else if (command.equals("=")) {
            double secondNumber = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    display.setText(String.valueOf(firstNumber + secondNumber));
                    break;
                case "-":
                    display.setText(String.valueOf(firstNumber - secondNumber));
                    break;
                case "*":
                    display.setText(String.valueOf(firstNumber * secondNumber));
                    break;
                case "/":
                    if (secondNumber != 0) {
                        display.setText(String.valueOf(firstNumber / secondNumber));
                    } else {
                        display.setText("Error");
                    }
                    break;
                case "sin":
                    display.setText(String.valueOf(Math.sin(Math.toRadians(secondNumber))));
                    break;
                case "cos":
                    display.setText(String.valueOf(Math.cos(Math.toRadians(secondNumber))));
                    break;
                case "tan":
                    display.setText(String.valueOf(Math.tan(Math.toRadians(secondNumber))));
                    break;
                case "log":
                    if (secondNumber > 0) {
                        display.setText(String.valueOf(Math.log(secondNumber)));
                    } else {
                        display.setText("Error");
                    }
                    break;
                case "C":
                    System.exit(0);
                    break;
                case "sinh":
                    display.setText(String.valueOf(Math.sinh(secondNumber)));
                    break;
                case "cosh":
                    display.setText(String.valueOf(Math.cosh(secondNumber)));
                    break;
                case "tanh":
                 display.setText(String.valueOf(Math.tanh(secondNumber)));
                    break;
                case "X^Y":
                    display.setText(String.valueOf(Math.pow(firstNumber, secondNumber)));
                    break;
                    
            }
            }
            else if(command.equals("B")){
                    String currentText=display.getText();
                    if(!currentText.isEmpty()){
                    display.setText(currentText.substring(0,currentText.length()-1));
                    }
                    }
            else if(command.equals("X^2")){
            double number=Double.parseDouble(display.getText());
            display.setText(String.valueOf(number*number));
            }
            else if(command.equals("√")){
            double number = Double.parseDouble(display.getText());
            if(number>=0) //cant be -ve
            {
            display.setText(String.valueOf(Math.sqrt(number)));
            }
            }
            else if(command.equals("exp")){
            double number = Double.parseDouble(display.getText());
               display.setText(String.valueOf(Math.exp(number)));
            }
            else if(command.equals("||")){
            double number = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.abs(number)));
            }
            else if(command.equals("3^√")){
            double number = Double.parseDouble(display.getText());
            display.setText(String.valueOf(Math.cbrt(number)));
            }
            else {
            operator = command;
            firstNumber = Double.parseDouble(display.getText());
            display.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ScintificCalculator calculator = new ScintificCalculator();
            calculator.setVisible(true);
        });
    }
}

  