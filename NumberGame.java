package numbergame;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;

public class NumberGame extends JFrame{
    JFrame frame;
    JPanel panel;
    JTextField guessNum;
    JLabel lbl1,lbl2,lbl3,lbl4,lbl5,lbl6,lbl7,lbl8,lbl9,lbl10;
    JButton btn,btnAgain;
    int num,guessnum,diff,attempts=0;
    
    public NumberGame(){
        frame=new JFrame("Number Game");       //defining frame
        frame.setSize(500,450);
        frame.getContentPane().setBackground(Color.black);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
    
        panel=new JPanel();          //defining panel
        panel.setBackground(Color.black);
        frame.add(panel);

        lbl1=new JLabel("NUMBER GAME ",SwingConstants.CENTER);       //assigning labels
        lbl1.setFont(new Font("Verdena",Font.BOLD,30));
        lbl1.setForeground(Color.yellow);
        frame.add(lbl1,BorderLayout.NORTH);
        
        lbl2=new JLabel("HINT: The System will genarate a number b/w 1-100 you need to guess the number",SwingConstants.CENTER);
        lbl2.setFont(new Font("Verdena",Font.BOLD,11));
        lbl2.setForeground(Color.red);
        panel.add(lbl2,BorderLayout.CENTER);
        
        lbl3=new JLabel("                                                                                                                                ",SwingConstants.CENTER);
        panel.add(lbl3,BorderLayout.CENTER);        //to give gap between lines
        
        lbl4=new JLabel("                                                                                                                                ",SwingConstants.CENTER);
        lbl4.setFont(new Font("Verdena",Font.BOLD,14));
        lbl4.setForeground(Color.yellow);
        panel.add(lbl4,BorderLayout.CENTER);
        
        lbl5=new JLabel("The number generated by system:       XXX",SwingConstants.CENTER);
        lbl5.setFont(new Font("Verdena",Font.BOLD,17));
        lbl5.setForeground(Color.yellow);
        panel.add(lbl5,BorderLayout.CENTER);
        
        lbl6=new JLabel("                                                                                                                                ",SwingConstants.CENTER);
        panel.add(lbl6,BorderLayout.CENTER);
        
        lbl7=new JLabel("Guess the number:",SwingConstants.CENTER);
        lbl7.setFont(new Font("Verdena",Font.BOLD,17));
        lbl7.setForeground(Color.yellow);
        panel.add(lbl7,BorderLayout.CENTER);
        
        guessNum=new JTextField("                           ",SwingConstants.CENTER);
        guessNum.setFont(new Font("Verdena",Font.BOLD,14));
        guessNum.setBounds(400, 70, 150, 30);
        panel.add(guessNum,BorderLayout.CENTER);
        
        btn=new JButton("GUESS");
        btn.setBackground(Color.yellow);
        btn.setForeground(Color.black);
        panel.add(btn,BorderLayout.CENTER);
        btn.addActionListener(e ->guess());
        
        lbl8=new JLabel("                                                                                                                                ",SwingConstants.CENTER);
        panel.add(lbl8,BorderLayout.CENTER);
        
        lbl9=new JLabel("      ",SwingConstants.CENTER);
        lbl9.setFont(new Font("Verdena",Font.BOLD,14));
        lbl9.setForeground(Color.white);
        panel.add(lbl9,BorderLayout.CENTER);
        
        lbl10=new JLabel("                                                                                                                                ",SwingConstants.CENTER);
        panel.add(lbl10,BorderLayout.CENTER);
        
        btnAgain=new JButton("Play Again");
        btnAgain.setBackground(Color.yellow);
        btnAgain.setForeground(Color.black);
        panel.add(btnAgain,BorderLayout.CENTER);
        btnAgain.addActionListener(e ->number());
           
        frame.setVisible(true);
        number();    //calling of function number()
}
    
    private void number(){                      //function for generating random number
        num=(int)(Math.random()*100)+1;
        attempts=0;
        guessNum.setEditable(true);
        guessNum.setText("                           ");
        lbl9.setText("");
        lbl4.setText("New round started !! Guess the number");
        lbl4.setForeground(Color.white);
    }
    
    private void guess(){                       //function applied on the "Guess" button
        if(attempts>=5){
            lbl9.setText("No more attempts left!!!");
            guessNum.setEditable(false);
            return;
        }
       try{
            guessnum=Integer.parseInt(guessNum.getText().trim());
            diff=Math.abs(guessnum-num);
            if(attempts==0){
                lbl4.setText("");
            }
            attempts++;
            lbl9.setForeground(Color.white);
            
            if(guessnum==num){
                lbl9.setText("Your Guess is correct!!!!");
                guessNum.setEditable(false);
                lbl9.setForeground(Color.green);               
            }
            else if(diff<=5){
                lbl9.setText("You are too close to the number!!!!   Attempts left:"+(5-attempts));
            }
            else if(diff<=10) {
               lbl9.setText("You are close to the number!!!!   Attempts left:"+(5-attempts));
            }
            else if(diff<=20){
                lbl9.setText("You are far from the number!!!!   Attempts left:"+(5-attempts));
            }
            else{
                lbl9.setText("You are way too far from the number!!!!   Attempts left:"+(5-attempts));
            }

            if(attempts==5 && guessnum != num){
                lbl9.setText("            Game Over !!!!     The correct number was:   "+num);
                guessNum.setEditable(false);
            }
       }
       catch(NumberFormatException e){
           lbl9.setText("Invalid input...Enter a number!!!");
           lbl9.setForeground(Color.red);
       }
    }
    
    public static void main(String[] args) {              
        SwingUtilities.invokeLater(NumberGame::new);              //invoking of the frame 
    }
}
