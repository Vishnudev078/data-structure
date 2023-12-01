import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculators implements ActionListener
{   JFrame jf;
    JLabel display;
    JButton ninebutton;
    JButton eightbutton;
    JButton sevenbutton;
    JButton fourbutton;
    JButton fivebutton;
    JButton sixbutton;
    JButton threebutton;
    JButton twobutton;
    JButton onebutton;
    JButton zerobutton;
    JButton dotbutton;
    JButton sharpbutton;
    JButton plusbutton;
    JButton minusbutton;
    JButton multibutton;
    JButton divbutton;
    JButton enterbutton;
    JButton deletebutton;
    boolean onClicking=false;
    String firstvariable;
    String secondvariable;
    char operation;
    float result;
    public Calculators()
    {
        jf=new JFrame();
        ninebutton =new JButton();
        eightbutton=new JButton();
        sevenbutton=new JButton();
        fourbutton=new JButton();
        fivebutton=new JButton();
        sixbutton=new JButton();
        threebutton=new JButton();
        twobutton=new JButton();
        onebutton=new JButton();
        zerobutton=new JButton();
        dotbutton=new JButton();
        sharpbutton=new JButton();
        plusbutton=new JButton();
        minusbutton=new JButton();
        multibutton=new JButton();
        divbutton= new JButton();
        enterbutton=new JButton();
        deletebutton= new JButton();
      jf= new JFrame();
      jf.setTitle("Calculator");
      jf.setSize(400,470);
      jf.setVisible(true);
      jf.setLayout(null);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jf.setLocation(50,50);

      display=new JLabel();
      display.setFont(new Font("Times of Romans", Font.BOLD, 30));
      display.setBounds(20, 30, 345, 80);
      display.setBackground(Color.LIGHT_GRAY);
      display.setOpaque(true);
      display.setVisible(true);
      display.setHorizontalAlignment(SwingConstants.RIGHT);
      jf.add(display);
    
      ninebutton=new JButton("9");
      ninebutton.setBounds(30, 130, 50, 50);
      ninebutton.setText("9");
      ninebutton.addActionListener(this);
      ninebutton.setFont(new Font("Arial", Font.PLAIN, 25));
      ninebutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(ninebutton);

      eightbutton=new JButton();
      eightbutton.setBounds(100, 130, 50, 50);
      eightbutton.setText("8");
      eightbutton.addActionListener(this);
      eightbutton.setFont(new Font("Arial", Font.PLAIN, 25));
      eightbutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(eightbutton);

      sevenbutton=new JButton();
      sevenbutton.setBounds(170, 130, 50, 50);
      sevenbutton.setText("7");
      sevenbutton.addActionListener(this);
      sevenbutton.setFont(new Font("Arial", Font.PLAIN, 25));
      sevenbutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(sevenbutton);

      fourbutton=new JButton();
      fourbutton.setBounds(30, 200, 50, 50);
      fourbutton.setText("4");
      fourbutton.addActionListener(this);
      fourbutton.setFont(new Font("Arial", Font.PLAIN, 25));
      fourbutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(fourbutton);

      fivebutton=new JButton();
      fivebutton.setBounds(100, 200, 50, 50);
      fivebutton.setText("5");
      fivebutton.addActionListener(this);
      fivebutton.setFont(new Font("Arial", Font.PLAIN, 25));
      fivebutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(fivebutton);

      sixbutton=new JButton();
      sixbutton.setBounds(170, 200, 50, 50);
      sixbutton.setText("6");
      sixbutton.addActionListener(this);
      sixbutton.setFont(new Font("Arial", Font.PLAIN, 25));
      sixbutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(sixbutton);

      threebutton=new JButton("3");
      threebutton.setBounds(30, 270, 50, 50);
      threebutton.setText("3");
      threebutton.addActionListener(this);
      threebutton.setFont(new Font("Arial", Font.PLAIN, 25));
      threebutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(threebutton);

      twobutton=new JButton("2");
      twobutton.setBounds(100, 270, 50, 50);
      twobutton.setText("2");
      twobutton.addActionListener(this);
      twobutton.setFont(new Font("Arial", Font.PLAIN, 25));
      twobutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(twobutton);

      onebutton=new JButton("1");
      onebutton.setBounds(170, 270, 50, 50);
      onebutton.setText("1");
      onebutton.addActionListener(this);
      onebutton.setFont(new Font("Arial", Font.PLAIN, 25));
      onebutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(onebutton);

      dotbutton=new JButton(".");
      dotbutton.setBounds(30, 340, 50, 50);
      dotbutton.setText(".");
      dotbutton.addActionListener(this);
      dotbutton.setFont(new Font("Arial", Font.PLAIN, 25));
      dotbutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(dotbutton);

      zerobutton=new JButton("0");
      zerobutton.setBounds(100, 340, 50, 50);
      zerobutton.setText("0");
      zerobutton.addActionListener(this);
      zerobutton.setFont(new Font("Arial", Font.PLAIN, 25));
      zerobutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(zerobutton);

      sharpbutton=new JButton("#");
      sharpbutton.setBounds(170, 340, 50, 50);
      sharpbutton.setText("#");
      sharpbutton.addActionListener(this);
      sharpbutton.setFont(new Font("Arial", Font.PLAIN, 25));
      sharpbutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(sharpbutton);

      plusbutton=new JButton("+");
      plusbutton.setBounds(235, 160, 60, 60);
      plusbutton.setText("+");
      plusbutton.addActionListener(this);
      plusbutton.setFont(new Font("Arial", Font.PLAIN, 25));
      plusbutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(plusbutton);

      minusbutton=new JButton("-");
      minusbutton.setBounds(300, 160, 60, 60);
      minusbutton.setText("-");
      minusbutton.addActionListener(this);
      minusbutton.setFont(new Font("Arial", Font.PLAIN, 25));
      minusbutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(minusbutton);

      multibutton=new JButton("*");
      multibutton.setBounds(235, 230, 60, 60);
      multibutton.setText("*");
      multibutton.addActionListener(this);
      multibutton.setFont(new Font("Arial", Font.PLAIN, 25));
      multibutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(multibutton);

       divbutton=new JButton("/");
      divbutton.setBounds(300, 230, 60, 60);
      divbutton.setText("/");
      divbutton.addActionListener(this);
      divbutton.setFont(new Font("Arial", Font.PLAIN, 25));
      divbutton.setMargin(new Insets(0, 0, 0, 0));
      jf.add(divbutton);

       enterbutton=new JButton("Enter");
       enterbutton.setBounds(235, 300, 125, 60);
       enterbutton.setText("Enter");
       enterbutton.addActionListener(this);
       enterbutton.setFont(new Font("Arial", Font.PLAIN, 25));
       enterbutton.setMargin(new Insets(0, 0, 0, 0));
       jf.add(enterbutton);

            deletebutton=new JButton("Enter");
       deletebutton.setBounds(235, 130, 50, 20);
       deletebutton.setText("delete");
       deletebutton.setMargin(new Insets(0, 0, 0, 0));
       deletebutton.addActionListener(this);
       jf.add(deletebutton);







      
    }

    public static void main(String[] args) {
        new Calculators();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    
        if(e.getSource()==onebutton)
        { 
            if(onClicking)
            {
                display.setText("1");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"1");
            }
          
        }
        else if(e.getSource()==twobutton)
        {
            if(onClicking)
            {
                display.setText("2");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"2");
            }
        }
         else if(e.getSource()==threebutton)
        {
             if(onClicking)
            {
                display.setText("3");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"3");
            }
        }
         else if(e.getSource()==fourbutton)
        {
             if(onClicking)
            {
                display.setText("4");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"4");
            }
        }
         else if(e.getSource()==fivebutton)
        {
             if(onClicking)
            {
                display.setText("5");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"5");
            }
        }
         else if(e.getSource()==sixbutton)
        {
             if(onClicking)
            {
                display.setText("6");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"6");
            }
        }
         else if(e.getSource()==sevenbutton)
        {
            if(onClicking)
            {
                display.setText("7");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"7");
            }
        }
         else if(e.getSource()==eightbutton)
        {
             if(onClicking)
            {
                display.setText("8");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"8");
            }
        }
         else if(e.getSource()==ninebutton)
        {
            if(onClicking)
            {
                display.setText("9");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"9");
            }
        }
         else if(e.getSource()==zerobutton)
        {
            if(onClicking)
            {
                display.setText("0");
                onClicking=false;
            }
            else{
                display.setText(display.getText()+"0");
            }
        }
         else if(e.getSource()==dotbutton)
        {
           
        }
         else if(e.getSource()==sharpbutton)
        {
        
        }
        else if(e.getSource()==deletebutton){
          display.setText("");
        }
         else if(e.getSource()==enterbutton)
        {  
            secondvariable=display.getText();
             float firstvalue= Float.parseFloat(firstvariable);
             float secondvalue=Float.parseFloat(secondvariable);
        
              switch(operation)
              {
                case '+':result= firstvalue+secondvalue;
                         break;
                case'-':result= firstvalue-secondvalue;
                        break;
                case'*':result= firstvalue*secondvalue;
                        break; 
                case'/':result= firstvalue/secondvalue;
                        break;               
            }
               display.setText(result+"");
               firstvalue=result;
               
            
        }
        else if(e.getSource()==plusbutton)
        {         
               onClicking=true;
               firstvariable=display.getText();
               operation='+'; 
               display.setText("");  
        }
        else if(e.getSource()==minusbutton)
        {       
               onClicking=true;
               firstvariable=display.getText();
                operation='-';
                display.setText("");
        }
        else if(e.getSource()==multibutton)
        {
             onClicking=true;
               firstvariable=display.getText();
                operation='*';
                display.setText("");
        }
        else if(e.getSource()==divbutton)
        {
             onClicking=true;
               firstvariable=display.getText();
                operation='/';
                display.setText("");
        }

    }

}


