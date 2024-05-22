import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Santra_Calculator implements ActionListener
{
    //CLASS VARIABLE
    double number = 0.0;
    double memory = 0.0;
    String operator = " ";
    
    JLabel label = new JLabel("0.0");
    JButton[] buttons = new JButton[20];
    String[] buttonNames = {"←", "x^y", "√", "%",
                            "7", "8", "9", "/", 
                            "4", "5", "6", "*", 
                            "1", "2", "3", "-",
                            "0", "=", "Clr", "+"};

    public static void main(String[] args){
        new Santra_Calculator();
    }
    
    public Santra_Calculator(){
        //frame
        JFrame frame = new JFrame("Calculator");
        frame.setSize(250,200);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //displaypanel
        JPanel displayPanel = new JPanel();
        displayPanel.setLayout(new BorderLayout());
        frame.add(displayPanel, BorderLayout.NORTH);
        
        //displaylabel
        label.setHorizontalAlignment(JLabel.RIGHT);
        label.setBackground(Color.WHITE);
        label.setOpaque(true);
        Font f = new Font("serif", Font.PLAIN, 30);
        label.setFont(f);
        displayPanel.add(label,BorderLayout.CENTER);
        
        //buttonpanel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5,4));
        frame.add(buttonPanel, BorderLayout.CENTER);
        
        //JButtons
        for(int i = 0; i < buttons.length; i++){
            buttons[i] = new JButton();
            buttons[i].setFont(new Font("SansSerif", Font.PLAIN, 30));
            buttons[i].setText(buttonNames[i]);
            buttons[i].addActionListener(this);
            buttonPanel.add(buttons[i]);
        }
        
        frame.setVisible(true);
    }
    // INDEXES:  0  1  2  3  4  5  6  7  8  9  10 11 12 13 14 15 16 17 18 19
    // BUTTONS:  ←  ^ √  %   7  8  9  /  4  5   6  *  1  2  3  -  0  =  C  +
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == buttons[0]){ // <-
            number = (number - number%10)/10;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[1]){ // ^
            operator = "^";
            memory = number;
            number = 0.0;
        }
        if(e.getSource() == buttons[2]){ // √
            operator = "√";
            memory = number;
            number = 0.0;
            number = Math.sqrt(memory);
            label.setText("" + number);
        }
        if(e.getSource() == buttons[3]){ // %
            operator = "%";
            memory = number;
            number = 0.0;
        }
        if(e.getSource() == buttons[4]){ // 7
            number = number*10 + 7;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[5]){ // 8
            number = number*10 + 8;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[6]){ // 9
            number = number*10 + 9;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[7]){ // /
            operator = "/";
            memory = number;
            number = 0.0;
        }
        if(e.getSource() == buttons[8]){ // 4
            number = number*10 + 4;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[9]){ // 5
            number = number*10 + 5;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[10]){ // 6
            number = number*10 + 6;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[11]){ // *
            operator = "*";
            memory = number;
            number = 0.0;
        }
        if(e.getSource() == buttons[12]){ // 1
            number = number*10 + 1;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[13]){ // 2
            number = number*10 + 2;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[14]){ // 3
            number = number*10 + 3;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[15]){ // -
            operator = "-";
            memory = number;
            number = 0.0;
        }
        if(e.getSource() == buttons[16]){ // 0
            number = number*10 + 0;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[17]){ // =
            if(operator.equals("+")){
                number += memory;
            }
            if(operator.equals("^")){ 
                number = Math.pow(memory, number);
            }
            if(operator.equals("%")){
                number %= memory;
            }
            if(operator.equals("/")){
                number = memory/number;
            }
            if(operator.equals("*")){
                number *= memory;
            }
            if(operator.equals("-")){
                number = memory - number;
            }
            label.setText("" + number);
            
        }
        if(e.getSource() == buttons[18]) { // C
            operator = "";
            memory = 0.0;
            number = 0.0;
            label.setText("" + number);
        }
        if(e.getSource() == buttons[19]){ // +
            operator = "+";
            memory = number;
            number = 0.0;
        }
    }
}