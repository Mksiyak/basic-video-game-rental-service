import javafx.beans.property.SimpleStringProperty;

public class user {
	
	private final SimpleStringProperty id;
    private final SimpleStringProperty first_name;
    private final SimpleStringProperty last_name;
    private final SimpleStringProperty pin_code;
    private final SimpleStringProperty adress;
    private final SimpleStringProperty phone_number;
    private final SimpleStringProperty email;
    private final SimpleStringProperty username ;

    public user(String id, String first_name, String last_name, String pin_code, String adress, String phone_number, String email, String username) {
    	this.id = new SimpleStringProperty(id);
        this.first_name = new SimpleStringProperty(first_name);
        this.last_name = new SimpleStringProperty(last_name);
        this.pin_code = new SimpleStringProperty(pin_code);
        this.adress = new SimpleStringProperty(adress);
        this.phone_number = new SimpleStringProperty(phone_number);
        this.email = new SimpleStringProperty(email);
        this.username = new SimpleStringProperty(username);

    }
    
    public String getId() {
        return id.get();
    }

    public void setId(String fId) {
        id.set(fId);
    }

    public String getFirst_name() {
        return first_name.get();
    }

    public void setFirst_name(String fFirst_name) {
    	first_name.set(fFirst_name);
    }

    public String getLast_name() {
        return last_name.get();
    }

    public void setLast_name(String fLast_name) {
    	last_name.set(fLast_name);
    }
    
    public String getPin_code() {
        return pin_code.get();
    }

    public void setpin_code(String fpin_code) {
        pin_code.set(fpin_code);
    }
    
    public String getAdress() {
        return adress.get();
    }

    public void setAdress(String fAdress) {
        adress.set(fAdress);
    }
    
    public String getPhone_number() {
        return phone_number.get();
    }

    public void setPhone_number(String fPhone_number) {
    	phone_number.set(fPhone_number);
    }
    
    public String getEmail() {
        return email.get();
    }

    public void setEmail(String fEmail) {
        email.set(fEmail);
    }
    public String getUsername()
    {
        return username.get();
    }
    public void setUsername(String fUsername)
    {
        username.set(fUsername);
    }
}