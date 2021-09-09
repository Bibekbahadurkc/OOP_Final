package multiplechoicequestions;
import java.awt.*;
import javax.swing.*;
import multiplechoicequestions.admin;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class admin extends JFrame implements ActionListener{
    JLabel Admin1,Admin2;
     JTextField Aname;
     JPasswordField Apassword;
     JButton AButton1,AButton2;
     
     public admin(){
 getContentPane().setBackground(Color.blue);
 Admin1= new JLabel("USERNAME");
 Admin2= new JLabel("PASSWORD");
 Aname= new JTextField();
 Apassword= new JPasswordField();
 Admin1.setBounds(130,100,120,40);
 Admin2.setBounds(130,150,160,40);
 Aname.setBounds(250,110,150,30);
 Apassword.setBounds(250,155,150,30);
 AButton1 = new JButton("Log In");
 AButton1.setBounds(180, 250,70, 30);
 AButton2 = new JButton ("Switch to user");
 AButton2.setBounds(300, 250, 118, 30);
 add(Admin1);
 add(Admin2);
 add(Aname);
 add(Apassword);
 add(AButton1);
 add(AButton2);
 AButton1.addActionListener(this);
 AButton2.addActionListener(this);
 
	/* setDefaultCloseOperation(EXIT_ON_CLOSE); */
 setSize(600,600);
 Container c=getContentPane();
 c.setLayout(null);
     }
     
     public static void main(String[] args) {
         new admin().setVisible(true);
    }
     
     @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      if  (ae.getSource()==AButton2){
            new MCQ().setVisible(true);}
        
        if(ae.getSource()==AButton1){
        database d= new database();
        String username=Aname.getText();
        String password=Apassword.getText();
        if(username.equals("admin"))
        {
            if(password.equals("admin")){
                new module().setVisible(true);
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Invalid user");
        
        }     
        }
    }
}