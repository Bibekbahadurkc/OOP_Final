package multiplechoicequestions;
import java.awt.*;
import java.sql.ResultSet;
import javax.swing.*;
import multiplechoicequestions.MCQ;
import multiplechoicequestions.signup;
import multiplechoicequestions.admin;
import multiplechoicequestions.database;
import multiplechoicequestions.studentmodule;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MCQ extends JFrame implements ActionListener{
    JLabel Lblone,Lbltwo;
    JTextField Name,Password;
    JButton Button1,Button2,Button3;
    
    public MCQ(){
 getContentPane().setBackground(Color.yellow);
 Lblone= new JLabel("EMAIL ID");
 Lbltwo= new JLabel("PASSWORD");
 Name= new JTextField();
 Password= new JTextField();
 Lblone.setBounds(130,100,120,40);
 Lbltwo.setBounds(130,150,160,40);
 Name.setBounds(250,110,150,30);
 Password.setBounds(250,155,150,30);
 Button1 = new JButton("Log In");
 Button1.setBounds(170, 250,70, 30);
 Button2 = new JButton ("Sign Up");
 Button2.setBounds(300, 250, 90, 30);
 Button3= new JButton("Swith to Admin");
 Button3.setBounds(200,320,150,30);
 add(Lblone);
 add(Lbltwo);
 add(Name);
 add(Password);
 add(Button1);
 add(Button2);
 add(Button3);
 Button1.addActionListener(this);
 Button2.addActionListener(this);
 Button3.addActionListener(this);
 
	/*
	 * setDefaultCloseOperation(EXIT_ON_CLOSE);
	 */ setSize(600,600);
 Container c=getContentPane();
 c.setLayout(null);
       
    }
       
    public static void main(String[] args) {
        new MCQ().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==Button1){

 if(Name.getText().equals(null)||Password.getText().equals(null))
                {
                 JOptionPane.showMessageDialog(null,"Insert values.");

                }
 try {
     
                database db=new database();
                ResultSet result=db.loginStudent(Name.getText(),Password.getText());
               
                if(result.next())
                {
                
                    JOptionPane.showMessageDialog(null,"Logged in successfully");
                    new studentmodule().setVisible(true);
                
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Unable to login");
                }
            } catch (Exception e) {
            }
         
    }
    if(ae.getSource()==Button2){
    new signup().setVisible(true);
    }
    if(ae.getSource()==Button3){
    new admin().setVisible(true);
    }
    }    
}