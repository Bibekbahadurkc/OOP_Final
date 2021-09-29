package multiplechoicequestions;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import multiplechoicequestions.generate;

public class generate extends JFrame implements ActionListener{
   
    JLabel tokenn;
    
    static char[] createtoken(int length){
            System.out.println("Your one time token is :");
            String numbers="0123456789abcdefghijklmnopqrstuvwxyz";
            Random r = new Random();
            char[] token=new char[length];
            for(int i=0;i<length;i++){
                token[i]=numbers.charAt(r.nextInt(numbers.length()));
            }
            return token;
        }
        public static void main(String[] args){
            System.out.println("Creating token........");
            System.out.println(createtoken(5));
            new generate().setVisible(true);
        }
    public generate(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setSize(400,200);
    Container c=getContentPane();
    c.setLayout(null);
    
    tokenn = new JLabel("Your token is : ");
    tokenn.setBounds(160,65,100,40);
    String token = new String(createtoken(5));
    tokenn.setText(token);
    
    add(tokenn);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
    }
 }
