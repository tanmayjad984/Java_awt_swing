import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    
    TextField input= new TextField();
    Button button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    Button addButton, subButton, mulButton, divButton, eqButton, clrButton;
    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        setLayout(null); 

        input.setBounds(30, 40, 240, 30);
        add(input);

        button0 = new Button("0");
        button0.setBounds(30, 260, 50, 50);
        button0.addActionListener(this);
        add(button0);

        button1 = new Button("1");
        button1.setBounds(30, 200, 50, 50);
        button1.addActionListener(this);
        add(button1);

        button2 = new Button("2");
        button2.setBounds(90, 200, 50, 50);
        button2.addActionListener(this);
        add(button2);

        button3 = new Button("3");
        button3.setBounds(150, 200, 50, 50);
        button3.addActionListener(this);
        add(button3);

        button4 = new Button("4");
        button4.setBounds(30, 140, 50, 50);
        button4.addActionListener(this);
        add(button4);

        button5 = new Button("5");
        button5.setBounds(90, 140, 50, 50);
        button5.addActionListener(this);
        add(button5);

        button6 = new Button("6");
        button6.setBounds(150, 140, 50, 50);
        button6.addActionListener(this);
        add(button6);

        button7 = new Button("7");
        button7.setBounds(30, 80, 50, 50);
        button7.addActionListener(this);
        add(button7);

        button8 = new Button("8");
        button8.setBounds(90, 80, 50, 50);
        button8.addActionListener(this);
        add(button8);

        button9 = new Button("9");
        button9.setBounds(150, 80, 50, 50);
        button9.addActionListener(this);
        add(button9);

        addButton = new Button("+");
        addButton.setBounds(210, 80, 50, 50);
        addButton.addActionListener(this);
        add(addButton);

        subButton = new Button("-");
        subButton.setBounds(210, 140, 50, 50);
        subButton.addActionListener(this);
        add(subButton);

        mulButton = new Button("*");
        mulButton.setBounds(210, 200, 50, 50);
        mulButton.addActionListener(this);
        add(mulButton);

        divButton = new Button("/");
        divButton.setBounds(210, 260, 50, 50);
        divButton.addActionListener(this);
        add(divButton);

        eqButton = new Button("=");
        eqButton.setBounds(150, 260, 50, 50);
        eqButton.addActionListener(this);
        add(eqButton);

        clrButton = new Button("C");
        clrButton.setBounds(90, 260, 50, 50);
        clrButton.addActionListener(this);
        add(clrButton);

        setSize(300, 350);
        setTitle("Calculator");
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') 
        {
            input.setText(input.getText() + command);
        }
        else if (command.charAt(0) == 'C') 
        {
            input.setText("");
        }
        
        else if (command.charAt(0) == '=') 
        {
            num2 = Double.parseDouble(input.getText());

            switch (operator) {
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            input.setText(String.valueOf(result));
            num1 = result;
        
        } 
        
        else 
        {
            if (!input.getText().isEmpty()) 
            {
                num1 = Double.parseDouble(input.getText());
                operator = command.charAt(0);
                input.setText("");
            }
        }
    }

    public static void main(String[] args) 
    {
        Calculator c= new Calculator();
    }
}
