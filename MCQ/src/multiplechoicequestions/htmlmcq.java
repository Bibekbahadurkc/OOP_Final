package multiplechoicequestions;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.*;
import multiplechoicequestions.StudentQuestion;
import multiplechoicequestions.database;
import java.util.ArrayList;
import java.util.Collections;

public class htmlmcq extends JFrame implements ActionListener{
     JLabel Question[] = new JLabel[10];
    JRadioButton[] opt1 = new JRadioButton[10];
    JRadioButton[] opt2 = new JRadioButton[10];
    JRadioButton[] opt3 = new JRadioButton[10];
    JRadioButton[] opt4 = new JRadioButton[10];
    JPanel RootQuestionPane;
    ButtonGroup[] group= new ButtonGroup[10];
    String[] userAns = new String[10];
    int marks = 0;
     ArrayList<StudentQuestion> qna = new ArrayList<StudentQuestion>();
        database dc = new database();
    
    JButton Next;
    JButton Previous;
    JButton Finish;
    int counter=-1;
    private JPanel[] QuestionPane;
    private JLabel[] Questions;
    private ButtonGroup[] BtnGrp;
    private JRadioButton[] option1;
    private JRadioButton[] option2;
    private JRadioButton[] option3;
    private JRadioButton[] option4;
    private JPanel btnPane;
    private final JPanel questionPane;
    
    public htmlmcq() throws SQLException{
        
    setSize(700,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container J = getContentPane();
        J.setLayout(null);
        
        RootQuestionPane = new JPanel();
        RootQuestionPane.setBounds(0,0,700,700);
        RootQuestionPane.setLayout(null);
        add(RootQuestionPane);
        
         questionPane = new JPanel();
        questionPane.setBounds(0,0,700,400);
        questionPane.setLayout(null);
        RootQuestionPane.add(questionPane);
        
        Next= new JButton("Next");
        Next.setBounds(500,200,70,30);
        Next.setBackground(Color.green);
        Next.addActionListener(this);
        
         btnPane = new JPanel();
        btnPane.setBounds(0,350,600,250);
   
        btnPane.setLayout(null);
        btnPane.add(Next);
        
        RootQuestionPane.add(btnPane);
        
        Previous= new JButton("Previous");
        Previous.setBounds(200,200,100,30);
       Previous.setBackground(Color.gray);
      Previous.addActionListener(this);
      btnPane.add(Previous);
      
      Finish= new JButton("Finish");
        Finish.setBounds(500,200,70,30);
        Finish.setVisible(false);
        Finish.addActionListener(this);
        btnPane.add(Finish);
        
        qna =dc.ethicsmcqset();
          Collections.shuffle(qna);
        dynamicQpanels(qna);
    }
    
    public static void main(String[] args) throws SQLException {
        new htmlmcq().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Next) {
            counter=counter+1;
            if (option1[counter].isSelected() || option2[counter].isSelected() || option3[counter].isSelected()|| option4[counter].isSelected()) {
                // group[counter].getSelection().getActionCommand();
                userAns[counter] = BtnGrp[counter].getSelection().getActionCommand();
                 if (userAns[counter].equals(qna.get(counter).correctAnswer())) {
                     
                marks = marks + 1;
            }
                
            }
            else{
                userAns[counter] = null;
            }
           
            
            if (counter==8) {
                Next.setVisible(false);
                Finish.setVisible(true);
            }
            panelSwitch(counter);
        }
        if (e.getSource() == Previous) {
            counter=counter-1;
            panelSwitch(counter);
            if (option1[counter].isSelected() || option2[counter].isSelected() || option3[counter].isSelected()|| option4[counter].isSelected()) {
                // group[counter].getSelection().getActionCommand();
                userAns[counter] = BtnGrp[counter].getSelection().getActionCommand();
                
            }
            else{
                userAns[counter] = null;
            }
            
            if (counter==7) {
                Next.setVisible(true);
                Finish.setVisible(false);
            }
        }
        if (e.getSource().equals(Finish)) {
            if (option1[counter].isSelected() || option2[counter].isSelected() || option3[counter].isSelected()|| option4[counter].isSelected()) {
                // group[counter].getSelection().getActionCommand();
                userAns[counter] = BtnGrp[counter].getSelection().getActionCommand();
                 if (userAns[counter].equals(qna.get(counter).correctAnswer())) {
                     
                marks = marks + 1;
            }
                
            }
            JOptionPane.showMessageDialog(null, "You scored " + marks);
        }
        }
    public void dynamicQpanels(ArrayList<StudentQuestion> listOfQuestion) {
	
	QuestionPane = new JPanel[10];
	Questions = new JLabel[10];
	BtnGrp = new ButtonGroup[10];
	option1 = new JRadioButton[10];
	option2 = new JRadioButton[10];
	option3 = new JRadioButton[10];
	option4 = new JRadioButton[10];
	
	
	for (int i = 0; i < 10; i++) {
		QuestionPane[i] = new JPanel();
		QuestionPane[i].setBounds(0, 0, 700, 400);
		QuestionPane[i].setLayout(null);
                
		questionPane.add(QuestionPane[0]);
		
		Questions[i] = new JLabel("<html>Q"+(i+1)+".   "+listOfQuestion.get(i).getQuestion()+"</html>");
		Questions[i].setFont(new Font("SansSerif", Font.PLAIN, 17));
		Questions[i].setBounds(20, 80, 700, 50);
		QuestionPane[i].add(Questions[i]);
		
		BtnGrp[i]= new ButtonGroup();
		
		option1[i] = new JRadioButton("<html>"+qna.get(i).getOption1()+"</html>");
		option1[i].setBounds(20, 167, 670, 35);
		option1[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option1[i].setActionCommand(qna.get(i).getOption1());
		BtnGrp[i].add(option1[i]);
		QuestionPane[i].add(option1[i]);
		
		option2[i] = new JRadioButton("<html>"+qna.get(i).getOption2()+"</html>");
		option2[i].setBounds(20, 206, 670, 35);
		option2[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option2[i].setActionCommand(listOfQuestion.get(i).getOption2());
		BtnGrp[i].add(option2[i]);
		QuestionPane[i].add(option2[i]);
		
		option3[i] = new JRadioButton("<html>"+qna.get(i).getOption3()+"</html>");
		option3[i].setBounds(20, 245, 670, 35);
		option3[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option3[i].setActionCommand(listOfQuestion.get(i).getOption3());
		BtnGrp[i].add(option3[i]);
		QuestionPane[i].add(option3[i]);
		
		option4[i] = new JRadioButton("<html>"+qna.get(i).getOption4()+"</html>");
		option4[i].setBounds(20, 284, 670, 35);
		option4[i].setFont(new Font("SansSerif", Font.PLAIN, 13));
		option4[i].setActionCommand(qna.get(i).getOption4());
		BtnGrp[i].add(option4[i]);
		QuestionPane[i].add(option4[i]);
		
	}

	
}
    public void panelSwitch(int counter){
       questionPane.removeAll();
       questionPane.add(QuestionPane[counter+1]);
       questionPane.repaint();
       questionPane.revalidate();
}
}
