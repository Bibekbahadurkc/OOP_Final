package multiplechoicequestions;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class module extends JFrame implements ActionListener{
    JLabel module1;
    JButton Web,ethics,Communication,Dstructure;
    
    public module(){
    	getContentPane().setBackground(Color.red);
    module1= new JLabel("Please choose particular module to start the Test");
    module1.setBounds(150,50,300,40);
    add(module1);
    
   Web = new JButton("JAVA");
   Web.setBounds(220, 120, 150, 40);
   add(Web);
   Web.addActionListener(this);
        
   ethics= new JButton("PYTHON");
   ethics.setBounds(220, 180, 150, 40);
   add(ethics);
   ethics.addActionListener(this);
   
   Communication= new JButton("HTML");
   Communication.setBounds(220, 240, 150, 40);
   add(Communication);
   Communication.addActionListener(this);
   
   Dstructure= new JButton("GIT");
   Dstructure.setBounds(220, 300, 150, 40);
   add(Dstructure);
   Dstructure.addActionListener(this);
   
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setSize(600,600);
 Container c=getContentPane();
 c.setLayout(null);
    }
    
  
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
            if(ae.getSource()==Web){
            new javaquestion().setVisible(true);}
            
            if(ae.getSource()==ethics){
            new python().setVisible(true);}
            
            if(ae.getSource()==Communication){
            new html().setVisible(true);}
            
            if(ae.getSource()==Dstructure){
            new html().setVisible(true);}



        }
    }

