import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
 public class myproject_backend
 {

     //show all users.........................................................................................................................................
    public void showAllUsers(){
        String sql = "SELECT * FROM user;";
        
        try (Connection conn = connectionWithDatabase();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            myproject.usersData.clear();
            
            while (rs.next()) {
                myproject.usersData.add(new user( String.valueOf(rs.getString("id")), rs.getString("first_name"), rs.getString("last_name"), rs.getString("pin_code"), rs.getString("adress"),rs.getString("phone_no"), rs.getString("email"),rs.getString("username")));
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
    
    //Database connection properties -----------------------------------------------------------------------------------------------------------------------            
    
    public static Connection connectionWithDatabase() { 
    
            Connection conn = null;
       try {
            Class.forName("com.mysql.jdbc.Driver");
            String db_url = "jdbc:mysql://localhost:3306/userlogin";
            String user = "root";
            String password = "";
            
            conn = DriverManager.getConnection(db_url, user, password);

        } catch (SQLException e) {
           System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    // making user id............................................................................................................................
    protected static String makingUserID() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 6) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
// user login .....................................................................................................................................
    public int userlogin()
    {int s = 0;
       if(myproject.user_passwordtf.getText().equals("")&&myproject.user_usernametf.getText().equals(""))
       {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Notification");
            alert.setHeaderText(null);
            alert.setContentText("please fill username and password fields");
            alert.showAndWait();
       return -3;
       }
        
        String sql = "SELECT * FROM user;";
        try{
    Connection conn = connectionWithDatabase(); 
    Statement stmt  = conn.createStatement();
         ResultSet  rs = stmt.executeQuery(sql);
         
        while(rs.next())
        {
            String usernamedata = rs.getString("username");
            String passworddata =rs.getString("passwd");
           if(passworddata.equals(myproject.user_passwordtf.getText())&&usernamedata.equals(myproject.user_usernametf.getText()))
            {
               
                s = rs.getInt("id");
            break;
            }
        }
        }
        catch(SQLException ex){System.out.println("sql exception");}
        catch(NullPointerException exx){System.out.println("null pointer exception \n"+exx.getMessage());}

    return s;
    }
    

// user sign up.....................................................................................................................................
    public void usersignup()
{
    String user_id = makingUserID();
    String sql = "INSERT INTO user (first_name,last_name,pin_code,phone_no,email,passwd,adress,username) VALUES('"+myproject.firstnameTF.getText()+"','"+myproject.lastnameTF.getText()+"','"+myproject.postalcodeTF.getText()+"','"+myproject.phone_numberTF.getText()+"','"+myproject.emailTF.getText()+"','"+myproject.enter_passwordTf.getText()+"','"+myproject.adressTF.getText()+"','"+user_id+"')";
    
   
    if( myproject.firstnameTF.getText().equals("") || myproject.lastnameTF.getText().equals("") || myproject.postalcodeTF.getText().equals("") || myproject.adressTF.getText().equals("") || myproject.phone_numberTF.getText().equals("") ||myproject.emailTF.getText().equals("") ||myproject.enter_passwordTf.getText().equals("")  ){
        Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Notification");
            alert.setHeaderText(null);
            alert.setContentText("You need to fill in all the fields with * ");

            alert.showAndWait();
        }
    else if(!(myproject.enter_passwordTf.getText().equals(myproject.reenter_passwordTf.getText())))
    {
        Alert alert = new Alert(AlertType.WARNING);
            alert.setTitle("Notification");
            alert.setHeaderText(null);
            alert.setContentText("password must be same in both coloumns");

            alert.showAndWait();
    }
    else
    {
         try{
                Connection conn = connectionWithDatabase();
                Statement stmt  = conn.createStatement();
                stmt.executeUpdate(sql);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("notificaticon");
                alert.setContentText("sussesfully registered and your username is "+ user_id);
                alert.showAndWait();
                myproject.firstnameTF.clear();
                myproject.lastnameTF.clear();
                myproject.postalcodeTF.clear();
                myproject.adressTF.clear();
                myproject.phone_numberTF.clear();
                myproject.emailTF.clear();
                myproject.enter_passwordTf.clear();
                myproject.reenter_passwordTf.clear();
                 
         }
            catch (SQLException e) {
                System.out.println(e.getMessage());

}
    }

}
//admin .add game()..................................................................................................................................
public void add_game()
{
    String sql = "INSERT INTO games ( title,generation,description,language,rating,available,rate ) VALUES ('" + myproject.game_titleTF.getText()+"','"+myproject.game_genereTF.getText()+"','"+myproject.game_descriptionTF.getText()+"','"+myproject.game_languageTF.getText()+"','"+myproject.game_ratingTF.getText()+"','"+myproject.game_availableTF.getText()+"','"+myproject.game_rateTF.getText()+"')";

    if(myproject.game_titleTF.getText().equals("")||myproject.game_genereTF.getText().equals("")||myproject.game_descriptionTF.getText().equals("")||myproject.game_languageTF.getText().equals("")||myproject.game_ratingTF.getText().equals("")||myproject.game_availableTF.getText().equals("")||myproject.game_rateTF.getText().equals(""))
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText("all fields are mandatory");

        alert.showAndWait();
    }
    else{
        try{
             Connection conn = connectionWithDatabase();
                Statement stmt  = conn.createStatement();
                stmt.executeUpdate(sql);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("notificaticon");
                alert.setContentText("game added successfully");
                alert.showAndWait();
                 myproject.game_languageTF.clear();
                 myproject.game_titleTF.clear();
                 myproject.game_genereTF.clear();
                 myproject.game_descriptionTF.clear();
                 myproject.game_availableTF.clear();
                 myproject.game_ratingTF.clear();
                 myproject.game_rateTF.clear();

}
catch(SQLException ex){
}
    }}


//admin login authanticator............................................................................................................................................

public boolean admin_login()
{
    boolean b = false;
   
    String sql = "select passwd from admin;";
   try{
              Connection conn = connectionWithDatabase();
              Statement stmt  = conn.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
              rs.next();
                if(rs.getString("passwd").equals(myproject.admin_passwordtf.getText()))
                 b = true;
             myproject.admin_passwordtf.clear();
          }
catch(SQLException e){}
return b;

        }
//admin.admin password update......................................................................................................................................
 public void update_admin_passwd()
 {
     String sql = "select passwd from admin;";
   try{
              Connection conn = connectionWithDatabase();
              Statement stmt  = conn.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
              rs.next();
                if(rs.getString("passwd").equals(myproject.admin_currentpassTF.getText()))
                {
                    conn.close();
                    if(myproject.admin_newpassTF.getText().equals(myproject.admin_repassTF.getText()))
                    {
                  String sqll = "update admin set passwd = '" +myproject.admin_newpassTF.getText()+"' where id = 1";
               try{
                 Connection connn = connectionWithDatabase();
                Statement stmts  = connn.createStatement();
                stmts.executeUpdate(sqll);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("notificaticon");
                alert.setContentText("password updated successfully");
                alert.showAndWait();
                myproject.admin_currentpassTF.clear();
                myproject.admin_newpassTF.clear();
                myproject.admin_repassTF.clear();

    }
    catch(SQLException e){}
}
else{
    Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("notificaticon");
                alert.setContentText("password should be same in both textfields");
                alert.showAndWait();
 }
                }
else
{
                Alert alert = new Alert(AlertType.WARNING);
                alert.setTitle("notificaticon");
                alert.setContentText("please enter a correct current password");
                alert.showAndWait();
}
          }
catch(SQLException e){}
    
}
//user.show games...........................................................................................................................................

public void showgames()
{
    String sql = "select * from games ;";
    try{
                Connection connn = connectionWithDatabase();
                Statement stmts  = connn.createStatement();
                ResultSet rs = stmts.executeQuery(sql);
                 myproject.gameData.clear();
                while(rs.next())
                {
                 myproject.gameData.add(new Game( String.valueOf(rs.getString("game_id")),rs.getString("title"),rs.getString("generation"),rs.getString("description"),rs.getString("language"),rs.getString("rating"),rs.getString("available"),rs.getString("rate")));
                
                }

}
catch(SQLException e){}
}


public void newgamepurchase()
{
       String sql1 = "select * from games ;";
       boolean b = false;
       try
       { 
          Connection connn = connectionWithDatabase();
          Statement stmts  = connn.createStatement();
          ResultSet rs = stmts.executeQuery(sql1);
          while(rs.next())
          {
            if(rs.getString("game_id").equals(myproject.purchase_idTF.getText()))
            {
                b=true;
             System.out.println(rs.getString("game_id"));
                String game_name = rs.getString("title");
                int game_available = Integer.parseInt(rs.getString("available")); 
                String sql = "INSERT INTO new_purchase (game , username,status,description) VALUES ('"+game_name+"','"+myproject.current_user_id+"','yet to approve','  ')";
                if(game_available > 0)
                    { try{ 
                     
                                 Connection conn = connectionWithDatabase();
                                 Statement stmt  = conn.createStatement();
                                 stmt.executeUpdate(sql);
                                  Alert alert = new Alert(AlertType.INFORMATION);
                                 alert.setTitle("notificaticon");
                                 alert.setContentText("purchase request sent  successfully");
                                 Image image = new Image("file:./payment.jpg");
                                  ImageView imageView = new ImageView(image);
                                  alert.setGraphic(imageView);
                                 alert.showAndWait();
                                 myproject.purchase_idTF.clear();
                                 updateavailable(game_name,-1);
                 
                     }
          
                     catch(SQLException e){System.out.println("sql error\n"+e.getMessage());}
                     break;
                 }
                 else
                 {
                     Alert alert = new Alert(AlertType.WARNING);
                                 alert.setTitle("notificaticon");
                                 alert.setContentText("game not available in stock . please try later ");
                                 alert.showAndWait();
                 }
       }
   
   } if(!b)
       {
                       Alert alert = new Alert(AlertType.WARNING);
                       alert.setTitle("notificaticon");
                       alert.setHeaderText(null);
                       alert.setContentText("Try with a valid id input");
                       alert.showAndWait();
       }}
catch(SQLException ex){}
}

public void updatepurchasetable()
{
    String sql = "select * from new_purchase where username = '"+myproject.current_user_id+"'";
    try{ 
    Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    ResultSet rs = stmts.executeQuery(sql); 
    myproject.purchased_game_data.clear();

    while(rs.next())
   myproject.purchased_game_data.add(new new_purchase(String.valueOf(rs.getString("id")),rs.getString("game"),rs.getString("status"),rs.getString("username"),rs.getString("description")));
   }
   catch(SQLException e){System.out.println(e.getMessage());}
}




 public void updatenewpurchasetablecontent()
    {
        String username;
        String sql = "select * from new_purchase where status = 'yet to approve'";
        try{ 
    Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    ResultSet rs = stmts.executeQuery(sql);
    myproject.purchased_game_data1.clear();

    while(rs.next()){
     username = getusernamebyid(rs.getString("username") ); 
   myproject.purchased_game_data1.add(new new_purchase(String.valueOf(rs.getString("id")),rs.getString("game"),rs.getString("status"),username,rs.getString("username")));
  

   }}
   catch(SQLException e){System.out.println(e.getMessage());}

    }




public void edituser()
{
    String sql = "select * from user where id = '"+myproject.current_user_id+"'";
    try{ 
    Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    ResultSet rs = stmts.executeQuery(sql); 

    rs.next();

   myproject.firstnameTF1.setText(rs.getString("first_name"));
   myproject.lastnameTF1.setText(rs.getString("last_name"));
   myproject.postalcodeTF1.setText(rs.getString("pin_code"));
   myproject.adressTF1.setText(rs.getString("adress"));
   myproject.phone_numberTF1.setText(rs.getString("phone_no"));
   myproject.emailTF1.setText(rs.getString("email"));
   myproject.usernameTF.setText(rs.getString("username"));
}
   catch(SQLException e){System.out.println(e.getMessage());}
}

public void finaluseredit()
{
     String sql = "update user set first_name  = '"+myproject.firstnameTF1.getText() +"', last_name = '"+myproject.lastnameTF1.getText()+"', pin_code = '" +myproject.postalcodeTF1.getText()+"', adress ='"+myproject.adressTF1.getText()+"',phone_no = '"+myproject.phone_numberTF1.getText()+"',email = '"+myproject.emailTF1.getText()+"' where id = "+myproject.current_user_id+";";
     try{
         Connection connn = connectionWithDatabase();
         Statement stmts  = connn.createStatement();
         stmts.executeUpdate(sql);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("notificaticon");
        alert.setContentText("updated successfully");
        alert.showAndWait(); 
    }
    catch(SQLException e){System.out.println(e.getMessage());
    }


}
public boolean editgame()
{
    boolean b = false;
    String sql = "select * from games";
    try{ 
    Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    ResultSet rs = stmts.executeQuery(sql); 
    while(rs.next())
    {
        if(rs.getString("game_id").equals(myproject.game_idTF.getText()))
            {
                b=true;
                break;
             }

    }
}
catch(SQLException e){System.out.println(e.getMessage());}
return b;
}
public void deletegame()
{
    String sql = "select* from games where game_id = '"+myproject.game_idTF.getText()+"'";
    try{ 
    Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    ResultSet rs = stmts.executeQuery(sql);
    if(rs.next())
    {
        String sql1 = "delete from games where game_id = '"+myproject.game_idTF.getText()+"'";
        Connection conn = connectionWithDatabase();
       Statement stmt  = conn.createStatement();
        stmt.executeUpdate(sql1);

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("notificaticon");
        alert.setContentText("updated successfully");
        alert.showAndWait(); 

    }
    else{
        Alert alert = new Alert(AlertType.WARNING);
                       alert.setTitle("notificaticon");
                       alert.setHeaderText(null);
                       alert.setContentText("game not found in database");
                       alert.showAndWait();
    }

}
catch(SQLException e){System.out.println(e.getMessage());}

}
public void entergameeditdetails()
{
    String sql = "select * from games where game_id = '"+myproject.game_idTF.getText()+"'";
    try{
        Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    ResultSet rs = stmts.executeQuery(sql);
    rs.next();
    myproject.game_titleTF1.setText(rs.getString("title"));
    myproject.game_genereTF1.setText(rs.getString("generation"));
    myproject.game_descriptionTF1.setText(rs.getString("description"));
    myproject.game_languageTF1.setText(rs.getString("language"));
    myproject.game_ratingTF1.setText(rs.getString("rating"));
    myproject.game_availableTF1.setText(rs.getString("available"));
    myproject.game_rateTF1.setText(rs.getString("rate"));
}
catch(SQLException e){System.out.println(e.getMessage());}

    }

    public void updategame()
    {
        String sql = "update games set title = '"+myproject.game_titleTF1.getText()+"',generation = '"+myproject.game_genereTF1.getText()+"', description = '"+myproject.game_descriptionTF1.getText()+"', language = '"+myproject.game_languageTF1.getText()+"', rating = '"+myproject.game_ratingTF1.getText()+"', available='"+myproject.game_availableTF1.getText()+"',rate = '"+myproject.game_rateTF1.getText()+"' where game_id = '"+myproject.game_idTF.getText()+"'";
       System.out.println(sql);
        if(myproject.game_titleTF1.getText().equals("")||myproject.game_genereTF1.getText().equals("")||myproject.game_descriptionTF1.getText().equals("")||myproject.game_languageTF1.getText().equals("")||myproject.game_ratingTF1.getText().equals("")||myproject.game_availableTF1.getText().equals("")||myproject.game_rateTF1.getText().equals(""))
    {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setHeaderText(null);
        alert.setContentText("all fields are mandatory");

        alert.showAndWait();
    }
    else{
        try{
             Connection conn = connectionWithDatabase();
                Statement stmt  = conn.createStatement();
                stmt.executeUpdate(sql);
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("notificaticon");
                alert.setContentText("game updated successfully");
                alert.showAndWait();
                entergameeditdetails();

}
catch(SQLException ex){System.out.println(ex.getMessage());}
    } 
    }

    //.......................................................................................................................................................
  public String getusernamebyid(String s)
  {
    String ret = "";
    String sql = "select username from user where id = "+s;
    try{
        Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    ResultSet rs = stmts.executeQuery(sql);
    rs.next();
    ret = rs.getString("username");
}
catch(SQLException e){System.out.println(e.getMessage());}

  return ret;
}

public String getidbyusername(String s)
{
    String ret = "";
    String sql = "select id from user where username = '"+s+"'";
    try{
        Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    ResultSet rs = stmts.executeQuery(sql);
    rs.next();
    ret = rs.getString("id");
}
catch(SQLException e){System.out.println("to confirm "+e.getMessage());}

  return ret;
}
//............................................................................................................................................................

public void updateinnewpuurchase(String sql)
{
    try{
        Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    stmts.executeUpdate(sql);
     Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("notificaticon");
                alert.setContentText("updated successfully");
                alert.showAndWait();
                myproject.descriptionTF.clear();
                myproject.usernameaprrovalTF.clear();
                 myproject.appgameTF.clear();
                 myproject.isaprrove.setSelected(false);
                 myproject.isdisaprrove.setSelected(false);
                 updatenewpurchasetablecontent();


    }
    catch(SQLException e){System.out.println(e.getMessage());}
}

public void responduserorder()
{
    String userid = getidbyusername(myproject.usernameaprrovalTF.getText());
    if(myproject.isaprrove.isSelected()==true)
    {
        String sql = "update new_purchase set status='approved', description='"+myproject.descriptionTF.getText()+"' where username ="+userid+" and game = '" + myproject.appgameTF.getText()+"'";
        updateinnewpuurchase(sql);

    }
    if(myproject.isdisaprrove.isSelected()==true)
    { 
      String sql = "update new_purchase set status='not approved', description ='"+myproject.descriptionTF.getText()+"' where username ="+userid+" and game = '" + myproject.appgameTF.getText()+"'";
        updateinnewpuurchase(sql);
        updateavailable(myproject.appgameTF.getText(),1);

    }

}

public void updateavailable(String game,int i)
{
    int availablegame = 0;
    String availablegame1="";
    String sql1 =" select available from games where title = '"+game+"'";
    try{
        Connection conn = connectionWithDatabase();
    Statement stmt  = conn.createStatement();
    ResultSet rs = stmt.executeQuery(sql1);
    rs.next();
     availablegame1 = rs.getString("available");
    } 
    catch(SQLException ex){System.out.println("verify"+ex.getMessage());}

   availablegame = Integer.parseInt(availablegame1);
   availablegame = availablegame+i;
   String sql = "update games set available = '"+availablegame+"' where title = '"+game+"'";
    try{
        Connection connn = connectionWithDatabase();
    Statement stmts  = connn.createStatement();
    stmts.executeUpdate(sql);
    System.out.println("game number updated "+availablegame);
    showgames();
    }
    catch(SQLException e){System.out.println(e.getMessage());}

}
}