package multiplechoicequestions;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class StudentQuestion extends JFrame implements ActionListener{
        String Question,optionA,optionB,optionC,optionD,correctAnswer;
    int id;
    public StudentQuestion(int id,String Question, String optionA,String optionB,String optionC,String optionD,String correctAnswer){
        this.Question = Question;
        this.id = id;
        this.optionA = optionA;
        this.optionB = optionB;
        this.optionC = optionC;
        this.optionD = optionD;
        this.correctAnswer = correctAnswer;
}
     public int getId(){
    return id;
    }
    public String getQuestion(){
    return Question;
    }
       public String getOption1(){
    return optionA;
    }
          public String getOption2(){
    return optionB;
    }
             public String getOption3(){
    return optionC;
    }
                public String getOption4(){
    return optionD;
    }
                 public String correctAnswer(){
    return correctAnswer;
    }
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
