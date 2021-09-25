package multiplechoicequestions;
import java.awt.*;
import javax.swing.*;
import multiplechoicequestions.studentmodule;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class studentmodule extends JFrame implements ActionListener{
    
   JLabel studentmodule;
    JButton SWeb,Sethics,SCommunication,SDstructure;

    
        public studentmodule(){
            getContentPane().setBackground(Color.red);
            studentmodule= new JLabel("Please choose particular module to start the Test");
    studentmodule.setBounds(150,50,300,40);
    add(studentmodule);
    
   SWeb = new JButton("JAVA");
   SWeb.setBounds(220, 120, 150, 40);
   add(SWeb);
   SWeb.addActionListener(this);
        
   Sethics= new JButton("PYTHON");
   Sethics.setBounds(220, 180, 150, 40);
   add(Sethics);
   Sethics.addActionListener(this);
   
   SCommunication= new JButton("HTML");
   SCommunication.setBounds(220, 240, 150, 40);
   add(SCommunication);
   SCommunication.addActionListener(this);
   
   SDstructure= new JButton("GIT");
   SDstructure.setBounds(220, 300, 150, 40);
   add(SDstructure);
   SDstructure.addActionListener(this);
        
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setSize(600,600);
 Container c=getContentPane();
 c.setLayout(null);
        }
        
         public static void main(String[] args) {
         new studentmodule().setVisible(true);
    
}
             
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==Sethics){
            try {
                new pythonmcq().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(studentmodule.class.getName()).log(Level.SEVERE, null, ex);
            }
}
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    if(ae.getSource()==SWeb){
            try {
                new javamcq().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(studentmodule.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    if(ae.getSource()==SDstructure){
            try {
                new gitmcq().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(studentmodule.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    if(ae.getSource()==SCommunication){
            try {
                new htmlmcq().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(studentmodule.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    }      
}
