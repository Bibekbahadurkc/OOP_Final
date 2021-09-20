package multiplechoicequestions;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import multiplechoicequestions.database;
import multiplechoicequestions.module;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class git extends JFrame implements ActionListener{
      JLabel Dquestion,PointA,PointB,PointC,PointD,Ranswer;
     JTextField Dquestionbox,Ans1,Ans2,Ans3,Ans4,RAnswerbox; 
     JButton DBack,DSave;

     public git(){
         Dquestion= new JLabel("Question");
  Dquestion.setBounds(50,50,120,40);
  add(Dquestion);
  
 Dquestionbox = new JTextField();
 Dquestionbox.setBounds(115,50,350,45);
 add(Dquestionbox);
 
 PointA = new JLabel ("1.");
 PointA.setBounds(60,150,20,20);
 add(PointA);
 Ans1 = new JTextField();
 Ans1.setBounds(120, 140  ,150  , 30);
 add(Ans1);
 
 PointB = new JLabel ("2.");
 PointB.setBounds(60,200,20,20);
 add(PointB);
 Ans2 = new JTextField();
 Ans2.setBounds(120, 190  ,150  , 30);
 add(Ans2);
 
 PointC = new JLabel ("3.");
 PointC.setBounds(60,250,20,20);
 add(PointC);
 Ans3 = new JTextField();
 Ans3.setBounds(120, 240  ,150  , 30);
 add(Ans3);
 
 PointD = new JLabel ("4.");
 PointD.setBounds(60,300,20,20);
 add(PointD);
 Ans4 = new JTextField();
 Ans4.setBounds(120, 290  ,150  , 30);
 add(Ans4);
 
 Ranswer = new JLabel ("Right answer");
 Ranswer.setBounds(270, 350, 150, 40);
 add(Ranswer);
 RAnswerbox = new JTextField();
 RAnswerbox.setBounds(370, 350, 150, 30);
 add(RAnswerbox);
 
 DBack = new JButton("Back");
 DBack.setBounds(50, 450, 150, 35);
 add(DBack);
 DBack.addActionListener(this);
 
 DSave = new JButton("Save");
 DSave.setBounds(400,450,150,35);
 add(DSave);
 DSave.addActionListener(this);
 
 setDefaultCloseOperation(EXIT_ON_CLOSE);
 setSize(600,600);
 Container c=getContentPane();
 c.setLayout(null);
}
     public static void main(String[] args) {
        new git().setVisible(true);
    }
    
         
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
         if(ae.getSource()==DBack){
            new module().setVisible(true);}
        
        if(ae.getSource()==DSave){
         try {
                database db=new database();
                int result=db.DataSructureSave(Dquestionbox.getText(),Ans1.getText(),Ans2.getText(),Ans3.getText(),Ans4.getText(),RAnswerbox.getText());
                if(result>0)
                    
                {
                    JOptionPane.showMessageDialog(null,"Saved sucessfully");
                    
                }
                else{
                     JOptionPane.showMessageDialog(null,"Not Saved");
                }
                    
                }
               
         catch (Exception e) 
                    {
            }             
            }  
    }      
    }