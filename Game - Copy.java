import javafx.beans.property.SimpleStringProperty;

public class Game
{

	private final SimpleStringProperty id;
	private final SimpleStringProperty title;
	 private final SimpleStringProperty genre;
    private final SimpleStringProperty description;
     private final SimpleStringProperty language;
    private final SimpleStringProperty rating;
    private final SimpleStringProperty availbale;
    private final SimpleStringProperty rate;

    public Game(String id, String title, String genre, String description, String language, String rating,String availbale, String rate) {


        this.id = new SimpleStringProperty(id);
    	this.title = new SimpleStringProperty(title);
        this.genre = new SimpleStringProperty(genre);
        this.description = new SimpleStringProperty(description);
        this.language = new SimpleStringProperty(language);
        this.rating = new SimpleStringProperty(rating);
        this.availbale = new SimpleStringProperty(availbale);
        this.rate = new SimpleStringProperty(rate);
        }

         public String getId() {
        return id.get();
    }

    public void setId(String fId) {
        id.set(fId);
    }
    
    public String getTitle() {
        return title.get();
    }

    public void setTitle(String fTitle) {
        title.set(fTitle);
    }

    public String getGenre() {
        return genre.get();
    }

    public void setGenre(String fGenre) {
        genre.set(fGenre);
    }

    public String getDescription() {
        return description.get();
    }

    public void setDescription(String fDescription) {
        description.set(fDescription);
    }
    
    public String getLanguage() {
        return language.get();
    }

    public void setLanguage(String fLanguage) {
    	language.set(fLanguage);
    }
    
    public String getRating() {
        return rating.get();
    }

    public void setrating(String frating) {
    	rating.set(frating);
    }
    
    public String getAvailbale() {
        return availbale.get();
    }

    public void setAvailbale(String fAvailbale) {
        availbale.set(fAvailbale);
    }
    
       public String getRate() {
        return  rate.get();
    }

    public void setRate(String fRate) {
    	 rate.set(fRate);
    }

}