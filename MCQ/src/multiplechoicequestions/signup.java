package multiplechoicequestions;
import java.awt.*;
import javax.swing.*;
import multiplechoicequestions.signup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class signup extends JFrame implements ActionListener{
    
    JLabel JFname,JLname,JEmail,JGender,JBatch,JToken,JContact;
    JTextField Fname,Lname,Email,Token,contact;
    JComboBox batch;
    JButton Register,Generate;
    JRadioButton Rmale,Rfemale,Rothers;
    
public signup(){
	getContentPane().setBackground(Color.blue);
    JFname = new JLabel ("First Name");
    Fname = new JTextField();
    JFname.setBounds(100, 60, 100, 30);
    Fname.setBounds(210,60, 200, 30);
    add(JFname);
    add(Fname);
    
    JLname = new JLabel ("Last name");
    Lname = new JTextField();
    JLname.setBounds(100, 100, 100, 30);
    Lname.setBounds(210,100, 200, 30);
    add(JLname);
    add(Lname);
    
    JEmail = new JLabel ("E-mail");
    Email = new JTextField();
    JEmail.setBounds(100, 140, 100, 30);
    Email.setBounds(210,140,200,30);
    add(JEmail);
    add(Email);
     
    JGender = new JLabel ("Gender");
    JGender.setBounds(100,180,100,30);
    add(JGender);
    Rmale= new JRadioButton("Male");
    Rmale.setBounds(200, 180, 70, 30);
    add(Rmale);
    Rfemale= new JRadioButton("Female");
    Rfemale.setBounds(275, 180, 70, 30);
    add(Rfemale);
    Rothers = new JRadioButton("Others",true);
    Rothers.setBounds(350, 180, 70, 30);
    add(Rothers);
    ButtonGroup bg = new ButtonGroup();
    bg.add(Rmale);
    bg.add(Rfemale);
    bg.add(Rothers);
      
    JBatch = new JLabel ("Batch");
    JBatch.setBounds(100,230,100,30);
    add(JBatch);
    batch = new JComboBox();
    batch.addItem ("29(A)");
    batch.addItem ("29(B)");
    batch.addItem ("29(C)");
    batch.addItem ("29(D)");
    batch.setBounds(210, 230, 100, 30);
    add(batch);
  
    JToken = new JLabel ("Token No");
    JToken.setBounds(100, 285, 100, 30);
    add(JToken);
    
    Token = new JTextField();
    Token.setBounds(210, 285, 200, 30);
    add(Token);
    
    JContact = new JLabel ("Contact no");
    JContact.setBounds(100, 335, 100, 30);
    add(JContact);
    
    contact = new JTextField();
    contact.setBounds(210, 335, 200, 30);
    add(contact);
    
    Register = new JButton("Sign Up");
    Register.setBounds(250, 400, 80, 50);
    Register.addActionListener(this);
    add(Register);
    Generate = new JButton("Generate");
    Generate.setBounds(450, 285, 100, 30);
    add(Generate);
    Generate.addActionListener(this);
        
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setSize(600,600);
 Container c=getContentPane();
 c.setLayout(null);
       
}
public static void main(String[] args) {
         new signup().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if (ae.getSource()==Generate){
        new generate().setVisible(true);
    }  
       
    String Batch=batch.getSelectedItem().toString();
    String gender="";
    if(Rmale.isSelected()){
        gender=Rmale.getText();
        
    }
    else if(Rfemale.isSelected()){
        gender=Rfemale.getText();
        
    }
    else if(Rothers.isSelected()){
        gender=Rothers.getText();
    }
    if(ae.getSource()==Register){
         if (Fname.getText().isEmpty()||Lname.getText().isEmpty()||Email.getText().isEmpty()||Token.getText().isEmpty()||contact.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please make sure all fields are filled in");
                }
         else{
         try {
                database db=new database();
                int result=db.save(Fname.getText(),Lname.getText(),Email.getText(),Token.getText(),contact.getText(),Batch,gender);
                if(result>0)
                     {
                    JOptionPane.showMessageDialog(null,"Saved sucessfully");
                    new MCQ().setVisible(true);
                }
                else{
                     JOptionPane.showMessageDialog(null,"Not Saved");
                }            
            } catch (HeadlessException e) {
            }
         }
    }
    
    }    
}
