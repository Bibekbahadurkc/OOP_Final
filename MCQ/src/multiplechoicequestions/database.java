package multiplechoicequestions;
import java.sql.*;
import java.util.ArrayList;
import multiplechoicequestions.database;

public class database {
 public Connection conn;
 PreparedStatement pstmt; 
 ResultSet sets=null;
 ResultSet rs;
 public database()
          {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project","root","");
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
 
  public int save(String firstname,String lastname,String email,String password,String contact,String batch,String gender)
    {
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into signin values(?,?,?,?,?,?,?)");
            pstmt.setString(1,firstname);
            pstmt.setString(2,lastname);
            pstmt.setString(3,email);
            pstmt.setString(4,password);
            pstmt.setString(5,contact);
            pstmt.setString(6,batch);
            pstmt.setString(7,gender);
            result=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return result;
        
    }
  //student login authenication
  public ResultSet loginStudent(String name,String token){
      
      try{
          pstmt=conn.prepareStatement("select email , Password from signin where email=? and Password=?");
          pstmt.setString(1, name);
          pstmt.setString(2, token);
          rs=pstmt.executeQuery();
      }
      catch(Exception ex){
          System.out.println(ex);
      }
      return rs;
  }
  
  //webquestion database
  public int webSave (String question ,String ans1,String ans2,String ans3,String ans4,String rightanswer)
    {
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into webquestion values(?,?,?,?,?,?,?)");
            pstmt.setInt(1,0);
            pstmt.setString(2,question);
            pstmt.setString(3,ans1);
            pstmt.setString(4,ans2);
            pstmt.setString(5,ans3);
            pstmt.setString(6,ans4);
            pstmt.setString(7,rightanswer);
            
            result=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return result;
    }
  //ethics database
  public int ethicsSave (String question ,String ans1,String ans2,String ans3,String ans4,String rightanswer)
    {
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into ethicsques values(?,?,?,?,?,?,?)");
            pstmt.setInt(1,0);
            pstmt.setString(2,question);
            pstmt.setString(3,ans1);
            pstmt.setString(4,ans2);
            pstmt.setString(5,ans3);
            pstmt.setString(6,ans4);
            pstmt.setString(7,rightanswer);
            
            result=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return result;
    }
    //communication database 
  public int htmlsave (String question ,String ans1,String ans2,String ans3,String ans4,String rightanswer)
    {
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into htmlques values(?,?,?,?,?,?,?)");
            pstmt.setInt(1,0);
            pstmt.setString(2,question);
            pstmt.setString(3,ans1);
            pstmt.setString(4,ans2);
            pstmt.setString(5,ans3);
            pstmt.setString(6,ans4);
            pstmt.setString(7,rightanswer);
            
            result=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return result;
        
    }
  
  //datastructure database
  public int DataSructureSave (String question ,String ans1,String ans2,String ans3,String ans4,String rightanswer)
    {
        int result=0;
        try {
            pstmt=conn.prepareStatement("insert into datastructureques values(?,?,?,?,?,?,?)");
            pstmt.setInt(1,0);
            pstmt.setString(2,question);
            pstmt.setString(3,ans1);
            pstmt.setString(4,ans2);
            pstmt.setString(5,ans3);
            pstmt.setString(6,ans4);
            pstmt.setString(7,rightanswer);
            
            result=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return result;
        
    }
  public ResultSet FetchData(String query){
         try{
         pstmt=conn.prepareStatement(query);
         sets=pstmt.executeQuery();
         }
         catch(Exception e)
         {
         }
         return sets;
    }
  //ethics student mcq
  public ArrayList<StudentQuestion> ethicsmcqset() throws SQLException{
        ArrayList<StudentQuestion> html = new ArrayList<StudentQuestion>();
        String query = "Select * from pythonques";
        
    database dbc = new database();
	ResultSet rs = dbc.FetchData(query);
	StudentQuestion qs;
	while (rs.next()) {
		qs = new StudentQuestion(rs.getInt("QID"),rs.getString("question"), rs.getString("ans1"), rs.getString("ans2"),rs.getString("ans3"), rs.getString("ans4"), rs.getString("rightasnswer"));
                html.add(qs);
	}
	return html;
     
     }
  
  //web student mcq
    public ArrayList<StudentQuestion> webmcqset() throws SQLException{
        ArrayList<StudentQuestion> html = new ArrayList<StudentQuestion>();
        String query = "Select * from javaquestion";
        
    database dbc = new database();
	ResultSet rs = dbc.FetchData(query);
	StudentQuestion qs;
	while (rs.next()) {
		qs = new StudentQuestion(rs.getInt("QID"),rs.getString("question"), rs.getString("ans1"), rs.getString("ans2"),rs.getString("ans3"), rs.getString("ans4"), rs.getString("rightanswer"));
                html.add(qs);
	}
	return html;
     
     }
    
     //web student mcq
       public ArrayList<StudentQuestion> Dstructuremcqset() throws SQLException{
        ArrayList<StudentQuestion> html = new ArrayList<StudentQuestion>();
        String query = "Select * from gitques";
        
    database dbc = new database();
	ResultSet rs = dbc.FetchData(query);
	StudentQuestion qs;
	while (rs.next()) {
		qs = new StudentQuestion(rs.getInt("QID"),rs.getString("Question"), rs.getString("Ans1"), rs.getString("Ans2"),rs.getString("Ans3"), rs.getString("ANs4"), rs.getString("Right answer"));
                html.add(qs);
	}
	return html;
     
     }
       
   // communication student mcq
         public ArrayList<StudentQuestion> htmlmcqset() throws SQLException{
        ArrayList<StudentQuestion> html = new ArrayList<StudentQuestion>();
        String query = "Select * from html";
        
    database dbc = new database();
	ResultSet rs = dbc.FetchData(query);
	StudentQuestion qs;
	while (rs.next()) {
		qs = new StudentQuestion(rs.getInt("QID"),rs.getString("Question"), rs.getString("Ans1"), rs.getString("Ans2"),rs.getString("Ans3"), rs.getString("Ans4"), rs.getString("Rightanswer"));
                html.add(qs);
	}
	return html;
     
     }
}