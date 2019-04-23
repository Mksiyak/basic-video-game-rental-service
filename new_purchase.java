import javafx.beans.property.SimpleStringProperty;

     public class new_purchase{
     private final SimpleStringProperty id;
	private final SimpleStringProperty game_id;
	 private final SimpleStringProperty status;
    private final SimpleStringProperty username;
    private final SimpleStringProperty description;
  

     public new_purchase(String id,String game_id, String status, String username ,String description)
     {
     	this.id =  new SimpleStringProperty(id);
     	this.game_id = new SimpleStringProperty(game_id);
     	this.status = new SimpleStringProperty(status);
     	this.username = new SimpleStringProperty(username);
      this.description = new SimpleStringProperty(description);
     }
   
      public String getId()
      {
      	return id.get();
      }
      public void setId(String fId)
      {
      	id.set(fId);
       }
       public String getGame_id()
       {
       	return game_id.get();
       }
       public void setGame_id(String fgame_id)
       {
       	game_id.set(fgame_id);
       }
       public String getStatus()
      {
      	return status.get();
      }
      public void setStatus(String fstatus)
      {
      	status.set(fstatus);
       }
       public String getUsername()
      {
      	return username.get();
      }
      public void setUsername(String fusername)
      {
      	username.set(fusername);
       }
     public void setDescription(String fdescription)
     {
      description.set(fdescription);
     }
    public String getDescription()
    {
      return description.get();
    }
   }