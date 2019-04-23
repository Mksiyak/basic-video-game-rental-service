
import java.util.*;
import javax.swing.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.Group;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import java.text.ParseException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;



public class myproject extends Application
{
	static int current_user_id = 0;

	 static boolean b;

	 static TextField appgameTF;

	 static TextField descriptionTF;
	
	static myproject_backend object_Back = new myproject_backend();

	 static TextField purchase_idTF;

	 //checkbox.............................................................

	 static CheckBox isaprrove;
	 static CheckBox isdisaprrove;

	 static TextField usernameaprrovalTF;

 //edit game..........................................................................................................................
	 static TextField game_idTF;


 // for the main nevigation............................................................................................................

	static Button usersButton; 
	static Button adminButton;

 // for admin login...................................................................................................................

	static Label admin_passwordlabel;
	static PasswordField admin_passwordtf;
	static Button admin_loginbutton;
	static Button admin_cancelbutton;

 //for user login....................................................................................................................

	static Label User_usernamelabel;
	static Label User_passwordlabel;
	static TextField user_usernametf;
	static PasswordField user_passwordtf;
	static Button user_loginbutton;
	static Button user_cancelbutton;
	static Button user_signupButton;

	//Navigation user signup..............................................................................................................
	static TextField firstnameTF;
	static TextField lastnameTF;
	static TextField postalcodeTF;
	static TextField adressTF;
	static TextField phone_numberTF;
	static TextField emailTF;
	static TextField enter_passwordTf;
	static TextField reenter_passwordTf;

	// user profile edit........................................................................................................

	static TextField firstnameTF1;
	static TextField lastnameTF1;
	static TextField postalcodeTF1;
	static TextField adressTF1;
	static TextField phone_numberTF1;
	static TextField emailTF1;
	static PasswordField enter_passwordTf1;
	static TextField usernameTF;
   

	//add game...................................................................................................................
	static TextField game_titleTF;
	static TextField game_genereTF;
	static TextField game_descriptionTF;
	static TextField game_languageTF;
	static TextField game_ratingTF;
	static TextField game_availableTF;
	static TextField game_rateTF;

	//edit game.......................................................................................................................
	static TextField game_titleTF1;
	static TextField game_genereTF1;
	static TextField game_descriptionTF1;
	static TextField game_languageTF1;
	static TextField game_ratingTF1;
	static TextField game_availableTF1;
	static TextField game_rateTF1;

	//change admin login password.................................................................................................
	static TextField admin_currentpassTF;
	static TextField admin_newpassTF;
	static TextField admin_repassTF;
   
	// table view of elements.............................................................................................................
	
	private final TableView<user> usersTable = new TableView<>();
	static ObservableList<user> usersData = FXCollections.observableArrayList();

	private final TableView<new_purchase> purchased_game_table = new TableView<>();
	static ObservableList<new_purchase> purchased_game_data = FXCollections.observableArrayList();

	private final TableView<Game> game_table = new TableView<>();
	static ObservableList<Game> gameData = FXCollections.observableArrayList();

	private final TableView<new_purchase> purchased_game_table1 = new TableView<>();
	static ObservableList<new_purchase> purchased_game_data1 = FXCollections.observableArrayList();


	public void start(Stage stage)
	{
		//change admin login password.................................................................................................
		  Label current_passL = new Label("currnt password : ");
		  Label admin_newpassL = new Label("new password : ");
		  Label admin_repassL = new Label("Re-enter new password : ");
		  current_passL.setStyle("-fx-font-size : 21; -fx-text-fill : black");
		  admin_newpassL.setStyle("-fx-font-size : 21; -fx-text-fill : black");
		  admin_repassL.setStyle("-fx-font-size : 21; -fx-text-fill : black");
		  admin_currentpassTF = new TextField();
		  admin_newpassTF = new TextField();
		  admin_repassTF = new TextField();
		  admin_currentpassTF.setMinSize(200,35);
		  admin_newpassTF.setMinSize(200,35);
		  admin_repassTF.setMinSize(200,35);

		  Button change_password_button = new Button("change");
		  change_password_button.setMinSize(100,35);

		  Group admin_passupdate_container = new Group();
		  admin_passupdate_container.getChildren().add(current_passL);
		  admin_passupdate_container.getChildren().add(admin_newpassL);
		  admin_passupdate_container.getChildren().add(admin_repassL);

		  admin_passupdate_container.getChildren().add(admin_currentpassTF);
		  admin_passupdate_container.getChildren().add(admin_newpassTF);
		  admin_passupdate_container.getChildren().add(admin_repassTF);

		  admin_passupdate_container.getChildren().add(change_password_button);

		  current_passL.setLayoutX(400);
		  current_passL.setLayoutY(100);
		  admin_newpassL.setLayoutX(400);
		  admin_newpassL.setLayoutY(150);
		  admin_repassL.setLayoutX(400);
		  admin_repassL.setLayoutY(200);

		  admin_currentpassTF.setLayoutX(700);
		  admin_currentpassTF.setLayoutY(100);
		  admin_newpassTF.setLayoutX(700);
		  admin_newpassTF.setLayoutY(150);
		  admin_repassTF.setLayoutX(700);
		  admin_repassTF.setLayoutY(200);
		  
		  change_password_button.setLayoutX(400);
		  change_password_button.setLayoutY(400);

		  //user.contact us...........................................................................................................

		  Label aboutL = new Label("ABOUT PROGRAM");
		  aboutL.setStyle("-fx-font-size:31;-fx-text-fill:red");
		  TextArea about_programTA = new TextArea();
		  about_programTA.setText("This is a video game rental \nmanagement system.\n\n"+
             "In this program new user can sign up and alredy \nregistered user can sign-in directly \n\n"+
             "they can see the deyails of games provided by admin\n"+
             "If any one wish to buy a video game they had to just\n send the purchase request to amin \n\n"+
             "it will show a pop-up window to provide payment details .\n\n"+
             "payment will be further checked by admin and he can approve or\n Disapprrove your purchase request with a brief note about responce\n\n"+
             "If you found any vulnerblity in program or any Suggestion to improve \n"+
             "then contact us on given details.. \n\n"+
             "PHONE----->1234567890 \n\n\n"+
             "GMAIL --------> abcd1234@gamil.com"
             );
            about_programTA.setMinSize(710, 400);
	        about_programTA.setEditable(false);

	         VBox about_programContainer = new VBox();
	        about_programContainer.getChildren().addAll(aboutL,about_programTA);
	        about_programContainer.setSpacing(8);

		  //user.edit profile .........................................................................................................
		   

			Label editUserL = new Label("EDIT USER PROFILE");
			editUserL.setStyle("-fx-font-size:21;-fx-text-fill: red");

		   
			
			Label firstnameL1 = new Label("First name");
			firstnameTF1 = new TextField();
			firstnameTF1.setMinSize(800,35);
			firstnameL1.setStyle("-fx-text-fill: black");
			
			Label lastnameL1 = new Label("Last name");
			lastnameL1.setStyle("-fx-text-fill: black");
			lastnameTF1 = new TextField();
			lastnameTF1.setMinSize(800,35);

			Label postalcodeL1 = new Label("pin code");
			postalcodeL1.setStyle("-fx-text-fill: black");
			postalcodeTF1 = new TextField();
			postalcodeTF1.setMinSize(800,35);

			Label adressL1 = new Label("adress");
			adressL1.setStyle("-fx-text-fill: black");
			adressTF1 = new TextField();
			adressTF1.setMinSize(800,35);

			Label phone_numberL1 = new Label("Phone number");
			phone_numberL1.setStyle("-fx-text-fill: black");
			phone_numberTF1 = new TextField();
			phone_numberTF1.setMinSize(800,35);

			Label emailL1 = new Label("Email");
			emailL1.setStyle("-fx-text-fill: black");
			emailTF1 = new TextField();
			emailTF1.setMinSize(800,35);

			Label enter_passwordL1 = new Label("password");
			enter_passwordL1.setStyle("-fx-text-fill: black");
			enter_passwordTf1 = new PasswordField();
			enter_passwordTf1.setMinSize(800,35);

			Label usernameL1 = new Label("username");
			usernameL1.setStyle("-fx-text-fill : black");
			usernameTF = new TextField();
			usernameTF.setMinSize(800,35);
			usernameTF.setDisable(true);
						
						
						Button editButton = new Button("EDIT");
			

			GridPane edit_userContainer = new GridPane();
			edit_userContainer.add(editUserL, 0, 0,2,1);
			edit_userContainer.add(firstnameL1, 0, 1);
			edit_userContainer.add(firstnameTF1, 1, 1);
			edit_userContainer.add(lastnameL1, 0, 2);
			edit_userContainer.add(lastnameTF1, 1, 2);
			edit_userContainer.add(postalcodeL1, 0, 3);
			edit_userContainer.add(postalcodeTF1, 1, 3);
			edit_userContainer.add(adressL1, 0, 4);
			edit_userContainer.add(adressTF1, 1, 4);
			edit_userContainer.add(phone_numberL1, 0, 5);
			edit_userContainer.add(phone_numberTF1, 1, 5);
			edit_userContainer.add(emailL1, 0, 6);
			edit_userContainer.add(emailTF1, 1, 6);
			edit_userContainer.add(enter_passwordL1,0,7);
			edit_userContainer.add(enter_passwordTf1,1,7);
			edit_userContainer.add(usernameL1,0,8);
			edit_userContainer.add(usernameTF,1,8);
			
			edit_userContainer.add(editButton, 0, 10);
			
			edit_userContainer.setHgap(5);
			edit_userContainer.setVgap(8);
			

		   //add game....................................................................................................................

		   Label add_gameL = new Label("add game");
		   add_gameL.setStyle("-fx-font-size:30;-fx-text-fill : RED");
		   
		   Label game_titleL = new Label("Title");
		   game_titleTF = new TextField();
		   game_titleTF.setMinSize(500,35);
		   game_titleL.setStyle("-fx-text-fill : black");

		   Label game_genereL = new Label("Generation");
		   game_genereTF = new TextField();
		   game_genereTF.setMinSize(500,35);
		   game_genereL.setStyle("-fx-text-fill : black");

		   Label game_descriptionL = new Label("Description");
		   game_descriptionTF = new TextField();
		   game_descriptionTF.setMinSize(500,35);
		   game_descriptionL.setStyle("-fx-text-fill : black");

		   Label game_languageL = new Label("language");
		   game_languageTF = new TextField();
		   game_languageTF.setMinSize(500,35);
		   game_languageL.setStyle("-fx-text-fill : black");

		   Label game_ratingL = new Label("Rating");
		   game_ratingTF = new TextField();
		   game_ratingTF.setMinSize(500,35);
		   game_ratingL.setStyle("-fx-text-fill : black");

		   Label game_availableL = new Label("Availbale");
		   game_availableTF = new TextField();
		   game_availableTF.setMinSize(500,35);
		   game_availableL.setStyle("-fx-text-fill : black");

		   Label game_rateL = new Label("Rate");
		   game_rateTF = new TextField();
		   game_rateTF.setMinSize(500,35);
		   game_rateL.setStyle("-fx-text-fill : black");

		   Button add_gamebutton = new Button("add");

		   GridPane add_game_container = new GridPane();
		   add_game_container.add(add_gameL,0,0,2,1);          
		   add_game_container.add(game_titleL,0,1);
		   add_game_container.add(game_titleTF,1,1);
		   add_game_container.add(game_genereL,0,2);
		   add_game_container.add(game_genereTF,1,2);
		   add_game_container.add(game_descriptionL,0,3);
		   add_game_container.add(game_descriptionTF,1,3);
		   add_game_container.add(game_languageL,0,4);
		   add_game_container.add(game_languageTF,1,4);
		   add_game_container.add(game_ratingL,0,5);
		   add_game_container.add(game_ratingTF,1,5);
		   add_game_container.add(game_availableL,0,6);
		   add_game_container.add(game_availableTF,1,6);
		   add_game_container.add(game_rateL,0,7);
		   add_game_container.add(game_rateTF,1,7);
		   add_game_container.add(add_gamebutton,1,9);
		   add_game_container.setHgap(5);
		   add_game_container.setVgap(10);

		   //admin. edit game information..........................................................................................................
		   Label edit_gameL = new Label("EDIT GAME");
		   edit_gameL.setStyle("-fx-font-size:30;-fx-text-fill: red");

		   Label game_chooseL = new Label("Enter id of game which you want to edit");
		   game_chooseL.setStyle("-fx-font-size:21;-fx-text-fill: black");

		   game_idTF = new TextField();
		   game_idTF.setMinSize(200,35);

		   Button edit_gameB = new Button("EDIT");
		   edit_gameB.setMinSize(135,20);

		   Button delete_gameB = new Button("DELETE");
		   delete_gameB.setMinSize(135,20);

		   GridPane admin_editgame_container0 = new GridPane();
		   admin_editgame_container0.add(edit_gameL,0,0,2,1);
		   admin_editgame_container0.add(game_chooseL,0,1);
		   admin_editgame_container0.add(game_idTF,0,2);
		   admin_editgame_container0.add(edit_gameB,0,3);
		   admin_editgame_container0.add(delete_gameB,1,3);
		   admin_editgame_container0.setHgap(10);
			admin_editgame_container0.setVgap(20);

			//admin.final edit game container........................................................................................................

		   Label edit_gameL1 = new Label("EDIT GAME");
		   edit_gameL1.setStyle("-fx-font-size:30;-fx-text-fill: red");

			Label game_titleL1 = new Label("Title");
		   game_titleTF1 = new TextField();
		   game_titleTF1.setMinSize(500,35);
		   game_titleL1.setStyle("-fx-text-fill : black");

		   Label game_genereL1 = new Label("Generation");
		   game_genereTF1 = new TextField();
		   game_genereTF1.setMinSize(500,35);
		   game_genereL1.setStyle("-fx-text-fill : black");

		   Label game_descriptionL1 = new Label("Description");
		   game_descriptionTF1 = new TextField();
		   game_descriptionTF1.setMinSize(500,35);
		   game_descriptionL1.setStyle("-fx-text-fill : black");

		   Label game_languageL1 = new Label("language");
		   game_languageTF1 = new TextField();
		   game_languageTF1.setMinSize(500,35);
		   game_languageL1.setStyle("-fx-text-fill : black");

		   Label game_ratingL1 = new Label("Rating");
		   game_ratingTF1 = new TextField();
		   game_ratingTF1.setMinSize(500,35);
		   game_ratingL1.setStyle("-fx-text-fill : black");

		   Label game_availableL1 = new Label("Availbale");
		   game_availableTF1 = new TextField();
		   game_availableTF1.setMinSize(500,35);
		   game_availableL1.setStyle("-fx-text-fill : black");

		   Label game_rateL1 = new Label("Rate");
		   game_rateTF1 = new TextField();
		   game_rateTF1.setMinSize(500,35);
		   game_rateL1.setStyle("-fx-text-fill : black");

		   Button edit_gamebutton = new Button("EDIT");

		   GridPane admin_editgame_container1 = new GridPane();
		   admin_editgame_container1.add(edit_gameL1,0,0,2,1);          
		   admin_editgame_container1.add(game_titleL1,0,1);
		   admin_editgame_container1.add(game_titleTF1,1,1);
		   admin_editgame_container1.add(game_genereL1,0,2);
		   admin_editgame_container1.add(game_genereTF1,1,2);
		   admin_editgame_container1.add(game_descriptionL1,0,3);
		   admin_editgame_container1.add(game_descriptionTF1,1,3);
		   admin_editgame_container1.add(game_languageL1,0,4);
		   admin_editgame_container1.add(game_languageTF1,1,4);
		   admin_editgame_container1.add(game_ratingL1,0,5);
		   admin_editgame_container1.add(game_ratingTF1,1,5);
		   admin_editgame_container1.add(game_availableL1,0,6);
		   admin_editgame_container1.add(game_availableTF1,1,6);
		   admin_editgame_container1.add(game_rateL1,0,7);
		   admin_editgame_container1.add(game_rateTF1,1,7);
		   admin_editgame_container1.add(edit_gamebutton,1,9);
		   admin_editgame_container1.setHgap(5);
		   admin_editgame_container1.setVgap(10);




		   // new user signup............................................................................
		  
			Label addUserL = new Label("New user");
			addUserL.setStyle("-fx-font-size:21;-fx-text-fill: black");
			
			Label firstnameL = new Label("First name*");
			firstnameTF = new TextField();
			firstnameTF.setMinSize(800,35);
			firstnameL.setStyle("-fx-text-fill: black");
			
			Label lastnameL = new Label("Last name*");
			lastnameL.setStyle("-fx-text-fill: black");
			lastnameTF = new TextField();
			lastnameTF.setMinSize(800,35);

			Label postalcodeL = new Label("pin code*");
			postalcodeL.setStyle("-fx-text-fill: black");
			postalcodeTF = new TextField();
			postalcodeTF.setMinSize(800,35);

			Label adressL = new Label("adress*");
			adressL.setStyle("-fx-text-fill: black");
			adressTF = new TextField();
			adressTF.setMinSize(800,35);

			Label phone_numberL = new Label("Phone number*");
			phone_numberL.setStyle("-fx-text-fill: black");
			phone_numberTF = new TextField();
			phone_numberTF.setMinSize(800,35);

			Label emailL = new Label("Email*");
			emailL.setStyle("-fx-text-fill: black");
			emailTF = new TextField();
			emailTF.setMinSize(800,35);

			Label enter_passwordL = new Label("password*");
			enter_passwordL.setStyle("-fx-text-fill: black");
			enter_passwordTf = new TextField();
			enter_passwordTf .setMinSize(800,35);

			Label reenter_passwordL = new Label("Re-enter password*");
			reenter_passwordL.setStyle("-fx-text-fill: black");
			reenter_passwordTf = new TextField();
			reenter_passwordTf .setMinSize(800,35);
						
						
						Button addButton = new Button("signup");
						Button signup_cancelbutton = new Button("cancel");
			
			GridPane new_userContainer = new GridPane();
			new_userContainer.add(addUserL, 0, 0,2,1);
			new_userContainer.add(firstnameL, 0, 1);
			new_userContainer.add(firstnameTF, 1, 1);
			new_userContainer.add(lastnameL, 0, 2);
			new_userContainer.add(lastnameTF, 1, 2);
			new_userContainer.add(postalcodeL, 0, 3);
			new_userContainer.add(postalcodeTF, 1, 3);
			new_userContainer.add(adressL, 0, 4);
			new_userContainer.add(adressTF, 1, 4);
			new_userContainer.add(phone_numberL, 0, 5);
			new_userContainer.add(phone_numberTF, 1, 5);
			new_userContainer.add(emailL, 0, 6);
			new_userContainer.add(emailTF, 1, 6);
			new_userContainer.add(enter_passwordL,0,7);
			new_userContainer.add(enter_passwordTf,1,7);
			new_userContainer.add(reenter_passwordL,0,8);
			new_userContainer.add(reenter_passwordTf,1,8);
			new_userContainer.add(addButton, 0, 10);
			new_userContainer.add(signup_cancelbutton,1,10);
			new_userContainer.setHgap(5);
			new_userContainer.setVgap(8);
			Scene user_signup = new Scene(new_userContainer,1200,800);
		
		  
		   

	   // user .homebutton........................................................................................................

		  
		  Label homeText = new Label("Welcome in  video Game Rental System!Select the desired function.");
		  homeText.setStyle("-fx-font-size:30;-fx-text-fill: blue");
		  StackPane homeTextContainer = new StackPane(homeText);

	   // admin welcome container.................................................................................................
		  Label welcomeadminL = new Label("WELCOME ADMIN");
		  welcomeadminL.setStyle("-fx-font-size:70;-fx-text-fill : blue");
		  StackPane admin_welcome_container = new StackPane(welcomeadminL);
		  

		//admin.show all users..........................................................................................................  
		
			Label show_all_usersL = new Label("Show all users");
			show_all_usersL.setStyle("-fx-font-size:21;-fx-text-fill: red");
			
			TableColumn idColumn = new TableColumn("User ID");
			idColumn.setMinWidth(38);
			idColumn.setCellValueFactory(
					new PropertyValueFactory<>("id"));
			
			TableColumn first_nameColumn = new TableColumn("First name");
			first_nameColumn.setMinWidth(80);
			first_nameColumn.setCellValueFactory(
					new PropertyValueFactory<>("first_name"));
					   
			TableColumn last_nameColumn = new TableColumn("Last name");
			last_nameColumn.setMinWidth(90);
			last_nameColumn.setCellValueFactory(
					new PropertyValueFactory<>("last_name"));
	 
			TableColumn pin_codeColumn = new TableColumn("Pin code");
			pin_codeColumn.setMinWidth(40);
			pin_codeColumn.setCellValueFactory(
					new PropertyValueFactory<>("pin_code"));
			
			TableColumn adressColumn = new TableColumn("adress");
			adressColumn.setMinWidth(80);
			adressColumn.setCellValueFactory(
					new PropertyValueFactory<>("adress"));
			
			TableColumn phone_numberColumn = new TableColumn("Phone number");
			phone_numberColumn.setMinWidth(120);
			phone_numberColumn.setCellValueFactory(
					new PropertyValueFactory<>("phone_number"));
			
			TableColumn emailColumn = new TableColumn("Email");
			emailColumn.setMinWidth(80);
			emailColumn.setCellValueFactory(
					new PropertyValueFactory<>("email"));

			TableColumn usernamecoloumn = new TableColumn("Username");
			usernamecoloumn.setMinWidth(30);
			usernamecoloumn.setCellValueFactory(
				new PropertyValueFactory<>("username"));

			usersTable.setItems(usersData);
			usersTable.getColumns().addAll(idColumn, first_nameColumn, last_nameColumn, pin_codeColumn, adressColumn, phone_numberColumn, emailColumn,usernamecoloumn);
			usersTable.setMinWidth(920);

			VBox show_all_usersContainer = new VBox();
			show_all_usersContainer.getChildren().addAll(show_all_usersL,usersTable);
			show_all_usersContainer.setSpacing(10);
		 //admin.purchse requests.................................................................................................................
			Label new_purchaseL = new Label("NEW PURCHASE");
			new_purchaseL.setStyle("-fx-font-size:30;-fx-text-fill : red");
			  
			TableColumn gameid_coloumn1 = new TableColumn("Game");
			gameid_coloumn1.setMinWidth(350);
			gameid_coloumn1.setCellValueFactory(
				new PropertyValueFactory<>("game_id"));

			TableColumn username_coloumn = new TableColumn("username");
			username_coloumn.setMinWidth(650);
			username_coloumn.setCellValueFactory(
			new PropertyValueFactory<>("username")); 

			purchased_game_table1.setItems(purchased_game_data1);
			purchased_game_table1.getColumns().addAll(gameid_coloumn1,username_coloumn);
			purchased_game_table.setMinWidth(1000);
			  
			
			Label usernameL = new Label("USERNAME");
			usernameL.setStyle("-fx-font-size:21;-fx-text-fill : black");


			usernameaprrovalTF = new TextField();
			usernameaprrovalTF.setMinSize(200,35);

			isaprrove = new CheckBox("Aprrove");
			isdisaprrove = new CheckBox("Disapprrove");
			HBox checkboxcontainer = new HBox();
			checkboxcontainer.getChildren().addAll(isaprrove,isdisaprrove);
			checkboxcontainer.setSpacing(20);

			Label descriptionL = new Label("DESCRIPTION");
			descriptionL.setStyle("-fx-font-size:21;-fx-text-fill : black");

			descriptionTF = new TextField();
			descriptionTF.setMinSize(500,35);

			Label appgameL = new Label("GAME NAME");
			appgameL.setStyle("-fx-font-size:21;-fx-text-fill : black");

			appgameTF = new TextField();
			appgameTF.setMinSize(500,35);

			Button doneB = new Button("OK");


			 VBox new_purchase__container = new VBox();
			 new_purchase__container.getChildren().addAll(new_purchaseL,purchased_game_table1,usernameL,usernameaprrovalTF,appgameL,appgameTF,checkboxcontainer,descriptionL,descriptionTF,doneB);
			 new_purchase__container.setSpacing(5);


		 //user.purchase status.................................................................................................
			Label cartL = new Label("YOUR CART");
			cartL.setStyle("-fx-font-size:30;-fx-text-fill : red");

			TableColumn gameid_coloumn = new TableColumn("Game ");
			gameid_coloumn.setMinWidth(250);
			gameid_coloumn.setCellValueFactory(
				new PropertyValueFactory<>("game_id"));

			TableColumn status_coloumn = new TableColumn("Purchase status");
			status_coloumn.setMinWidth(250);
			status_coloumn.setCellValueFactory(
			new PropertyValueFactory<>("status")); 
 

			TableColumn description_coloumn = new TableColumn("descreption");
			description_coloumn.setMinWidth(300);
			description_coloumn.setCellValueFactory(
			new PropertyValueFactory<>("description")); 



			purchased_game_table.setItems(purchased_game_data);
			purchased_game_table.getColumns().addAll(gameid_coloumn,status_coloumn,description_coloumn);
			purchased_game_table.setMinWidth(800);         
			 
			 VBox purchase_status_container = new VBox();
			 purchase_status_container.getChildren().addAll(cartL,purchased_game_table);
			 purchase_status_container.setSpacing(10);          
		 //user.show games.........................................................................................................
			 

		 Label show_all_gamesL = new Label("Show all games");
			show_all_gamesL.setStyle("-fx-font-size:21;-fx-text-fill: red");
			
			TableColumn idColumn3 = new TableColumn("ID");
			idColumn3.setMinWidth(38);
			idColumn3.setCellValueFactory(
					new PropertyValueFactory<>("id"));
			
			TableColumn titleColumn3 = new TableColumn("Title");
			titleColumn3.setMinWidth(180);
			titleColumn3.setCellValueFactory(
					new PropertyValueFactory<>("title"));
	 
			TableColumn genreColumn3 = new TableColumn("Genre");
			genreColumn3.setMinWidth(80);
			genreColumn3.setCellValueFactory(
					new PropertyValueFactory<>("genre"));
	 
			TableColumn descriptionColumn3 = new TableColumn("Description");
			descriptionColumn3.setMinWidth(300);
			descriptionColumn3.setCellValueFactory(
					new PropertyValueFactory<>("description"));
			
			TableColumn languageColumn3 = new TableColumn("language");
			languageColumn3.setMinWidth(60);
			languageColumn3.setCellValueFactory(
					new PropertyValueFactory<>("language"));
			
			TableColumn ratingColumn3 = new TableColumn("Rating");
			ratingColumn3.setMinWidth(80);
			ratingColumn3.setCellValueFactory(
					new PropertyValueFactory<>("rating"));
				  
			
			TableColumn availbaleColumn3 = new TableColumn("Availbale");
			availbaleColumn3.setMinWidth(60);
			availbaleColumn3.setCellValueFactory(
					new PropertyValueFactory<>("availbale"));
			
			
			TableColumn rate_coloumn3 = new TableColumn("Rate");
			rate_coloumn3.setMinWidth(80);
			rate_coloumn3.setCellValueFactory(
					new PropertyValueFactory<>("rate"));
	 
			game_table.setItems(gameData);
			game_table.getColumns().addAll(idColumn3, titleColumn3, genreColumn3, descriptionColumn3, languageColumn3, ratingColumn3 , availbaleColumn3 , rate_coloumn3);
			game_table.setMinWidth(1000);


		   Label purchase_gameL = new Label("purchase game(enter id of game which you want to purchase)");

		   purchase_idTF = new TextField();
		   purchase_idTF.setMinSize(120,35);

		   Button purchase_button = new Button("purchase");

			VBox show_all_gamesContainer = new VBox();
			show_all_gamesContainer.getChildren().addAll(show_all_gamesL,game_table,purchase_gameL,purchase_idTF,purchase_button);
			show_all_gamesContainer.setSpacing(5);


		//user navigation............................................................................................................
		 
		
		Button home_button = new Button("home");
		home_button.setMinSize(120,35);
		Button show_games = new Button("show game");
		show_games.setMinSize(120,35);
		Button purchase_status = new Button("purchase status");
		purchase_status.setMinSize(120,35);
		Button edit_profile = new Button("edit profile");
		edit_profile.setMinSize(120,35);
		Button contact_us = new Button("about");
		contact_us.setMinSize(120,35);
		Button user_logout = new Button("logout");
		user_logout.setMinSize(120,35);
		VBox user_container = new VBox();
		user_container.getChildren().addAll(home_button,show_games,purchase_status,edit_profile,contact_us,user_logout);
		user_container.setSpacing(5);
		HBox user_container_all = new HBox();
		Scene user_navigation = new Scene(user_container_all,1200,800);

		//admin navigation .........................................................................................................
		 
		Button show_user = new Button("show user");
		show_user.setMinSize(150,35);
		Button add_game = new Button("add game");
		add_game.setMinSize(150,35);
		Button edit_game= new Button("edit game");
		edit_game.setMinSize(150,35);
		Button purchase_request = new Button("purchase request");
		purchase_request.setMinSize(150,35);
		Button change_password= new Button("change password");
		change_password.setMinSize(150,35);
		Button admin_logout= new Button("logout");
		admin_logout.setMinSize(150,35);
		  
		  VBox admin_container = new VBox();
		  admin_container.getChildren().addAll(show_user,add_game,edit_game,purchase_request,change_password,admin_logout);
		  admin_container.setSpacing(5);
		  HBox admin_container_all = new HBox();
		  Scene admin_navigation = new Scene(admin_container_all,1200,800);

		  //user login screen......................................................................................................... 
		  
		  User_usernamelabel = new Label("username : ");
		  User_passwordlabel = new Label("password : ");
		  user_usernametf = new TextField();
		  user_passwordtf = new PasswordField();
		  user_loginbutton = new Button("login");
		  user_cancelbutton = new Button("cancel");
		  user_signupButton = new Button("not registerd ? signup here");
		  Group user_login_container = new Group();
		 user_login_container.getChildren().add(User_usernamelabel);
		 user_login_container.getChildren().add(User_passwordlabel);
		 user_login_container.getChildren().add(user_usernametf);
		 user_login_container.getChildren().add(user_passwordtf);
		 user_login_container.getChildren().add(user_loginbutton);
		 user_login_container.getChildren().add(user_cancelbutton);
		 user_login_container.getChildren().add(user_signupButton);
		  User_usernamelabel.setLayoutX(400);
		  User_usernamelabel.setLayoutY(300);
		  User_passwordlabel.setLayoutX(400);
		  User_passwordlabel.setLayoutY(350);
		  user_usernametf.setLayoutX(500);
		  user_usernametf.setLayoutY(300);
		  user_passwordtf.setLayoutX(500);
		  user_passwordtf.setLayoutY(350);
		  user_loginbutton.setLayoutX(400);
		  user_loginbutton.setLayoutY(400);
		  user_cancelbutton.setLayoutX(530);
		  user_cancelbutton.setLayoutY(400);
		  user_signupButton.setLayoutX(400);
		  user_signupButton.setLayoutY(450);

		//admin login screen.............................................................

		  admin_passwordlabel = new Label("enter admin password");
		  admin_passwordtf = new PasswordField();
		  admin_loginbutton = new Button("login");
		  admin_cancelbutton = new Button("cancel");
		  Group admin_login_container = new Group();
		  admin_login_container.getChildren().add(admin_passwordlabel);
		  admin_login_container.getChildren().add(admin_passwordtf);
		  admin_login_container.getChildren().add(admin_loginbutton);
		  admin_login_container.getChildren().add(admin_cancelbutton);
		  admin_passwordlabel.setLayoutX(400);
		  admin_passwordlabel.setLayoutY(350);
		  admin_passwordtf.setLayoutX(550);
		  admin_passwordtf.setLayoutY(350);
		  admin_loginbutton.setLayoutX(400);
		  admin_loginbutton.setLayoutY(400);
		  admin_cancelbutton.setLayoutX(550);
		  admin_cancelbutton.setLayoutY(400);
		  Scene login_user = new Scene(user_login_container,1200,800);
		  Scene login_admin = new Scene(admin_login_container,1200,800);



		 
		  // login choose screen .....................................................................................................

		usersButton = new Button("User",new ImageView(new Image("file:./admin-icon.png")));
		usersButton.setMinSize(200,200);
		adminButton = new Button("admin",new ImageView(new Image("file:./admin-icon.png")));
		adminButton.setMinSize(200,200);

		Group login_choose_container = new Group();
		login_choose_container.getChildren().add(usersButton);
		login_choose_container.getChildren().add(adminButton);
		//login_choose_container.setSpacing(5);
		usersButton.setLayoutX(350);
		usersButton.setLayoutY(200);
		adminButton.setLayoutX(650);
		adminButton.setLayoutY(200);
		stage.setTitle("my project");
		Scene login_choose_scene = new Scene(login_choose_container,1200,800);
		stage.setScene(login_choose_scene);
		stage.centerOnScreen();
		stage.setResizable(false);
		stage.getIcons().add(new Image("file:./icon.png"));
		stage.show();


		// action handling...............................................................................................................................
		

		usersButton.setOnAction( e -> {
		stage.setScene(login_user);
		});
		adminButton.setOnAction( e -> {
			stage.setScene(login_admin);
		});
		admin_loginbutton.setOnAction(e ->
		{

		 if(myproject.admin_passwordtf.getText().equals(""))
		{
		 Alert alert = new Alert(AlertType.WARNING);
		 alert.setHeaderText(null);
		 alert.setContentText("password field cann't be empty");
		
		 alert.showAndWait();

		 }
		 else{
			boolean b = object_Back.admin_login();
			if(b){
			try{
			admin_container_all.getChildren().remove(1);
			admin_container_all.getChildren().remove(0);
			
		}
		catch(Exception f){}
			admin_container_all.getChildren().add(0,admin_container);
			admin_container_all.getChildren().add(1,admin_welcome_container);
			stage.setScene(admin_navigation);
		}
		else
		{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setHeaderText(null);
			alert.setContentText("you have enterd wrong password");
			alert.showAndWait();
		}}
		
		});
		user_loginbutton.setOnAction(e ->
		{  
			int s = object_Back.userlogin();
			
			if(s>0){try{
				
			user_container_all.getChildren().remove(1);
			user_container_all.getChildren().remove(0);
				
			  }
			  
		catch(Exception f)
		{}
				current_user_id = s;
			user_container_all.getChildren().addAll(user_container,homeTextContainer);
			stage.setScene(user_navigation);
			   user_usernametf.clear();
			user_passwordtf.clear();
			}
			if(s==0){
				Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Notification");
			alert.setHeaderText(null);
			alert.setContentText("The username and password you entered doesn't belong to any account");
			alert.showAndWait();
			user_usernametf.clear();
			user_passwordtf.clear();
			}
		});
		user_logout.setOnAction( e->
		{
			stage.setScene(login_choose_scene);
		});
		admin_logout.setOnAction(e ->
		{
			stage.setScene(login_choose_scene);
		});
		admin_cancelbutton.setOnAction(e ->
		{
		   stage.setScene(login_choose_scene);
		});
		user_cancelbutton.setOnAction(e ->
		{
		stage.setScene(login_choose_scene);
		});
		show_user.setOnAction(e->
		{
			object_Back.showAllUsers();
			try{
				admin_container_all.getChildren().remove(1);
			}
			catch(Exception f){}
			admin_container_all.getChildren().add(1,show_all_usersContainer);

		});
		home_button.setOnAction( e ->
		{
			try{
			user_container_all.getChildren().remove(1);
		}
		catch(Exception f ){

		}
		user_container_all.getChildren().add(1,homeTextContainer);
		});
		user_signupButton.setOnAction(e ->
		{
		 stage.setScene(user_signup);
		 
		});
		signup_cancelbutton.setOnAction(e->
		{
			stage.setScene(login_choose_scene);

		});
		show_games.setOnAction(e->
		{
			try{user_container_all.getChildren().remove(1);}
			catch(Exception f){}
			object_Back.showgames();
			user_container_all.getChildren().add(1,show_all_gamesContainer);
			
		});
		addButton.setOnAction(e->
		{
			object_Back.usersignup();
		});
		add_game.setOnAction(e->
		{
			try{
				admin_container_all.getChildren().remove(1);
			}
			catch(Exception f){}
			 admin_container_all.getChildren().add(1,add_game_container);

		});
		add_gamebutton.setOnAction(e->
		{
			object_Back.add_game();
		});
		change_password.setOnAction(e->
		{
			try{
				admin_container_all.getChildren().remove(1);
			}
			catch(Exception f){}
			admin_container_all.getChildren().add(1,admin_passupdate_container);

			});
		change_password_button.setOnAction(e->
		{
			if(admin_currentpassTF.getText().equals("")||admin_newpassTF.getText().equals("")||admin_repassTF.getText().equals(""))
			{
				 Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Notification");
			alert.setHeaderText(null);
			alert.setContentText("All TextField must be filled");
			alert.showAndWait();
		}
		else
		{
			object_Back.update_admin_passwd();
		}
	});
		purchase_status.setOnAction(e->
		{   object_Back.updatepurchasetable();     	
			try{user_container_all.getChildren().remove(1);}
					 catch(Exception f){}

			   user_container_all.getChildren().add(1,purchase_status_container);      

		});
		purchase_button.setOnAction(e->
		{
		  object_Back.newgamepurchase();

		});
		edit_profile.setOnAction(e->
		{
		  try{user_container_all.getChildren().remove(1);}
					 catch(Exception f){}
		  user_container_all.getChildren().add(1,edit_userContainer);
		  object_Back.edituser();

		});
		editButton.setOnAction(e->
		
		{ if(firstnameTF1.getText().equals("") || lastnameTF1.getText().equals("") || postalcodeTF1.getText().equals("") || adressTF1.getText().equals("") || phone_numberTF1.getText().equals("") || emailTF1.getText().equals("") || enter_passwordTf1.getText().equals(""))
		 {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("please fill all TextFields");
				alert.showAndWait();
		 }
		 else{ 
		 object_Back.finaluseredit();
		 object_Back.edituser();
		 enter_passwordTf1.clear();
		 }
		});
		edit_game.setOnAction(e->
		{
			try{
				admin_container_all.getChildren().remove(1);
			}
			catch(Exception f){}
			admin_container_all.getChildren().add(1,admin_editgame_container0);

		});

		edit_gameB.setOnAction(e->
		{
		   if(game_idTF.getText().equals(""))
		   {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("please enter game id");
				alert.showAndWait();
		   }
		   else {
					  b = object_Back.editgame();
					  if(b==true)
					  {
						 try{
				admin_container_all.getChildren().remove(1);
			}
			catch(Exception f){}
			admin_container_all.getChildren().add(1,admin_editgame_container1);
			object_Back.entergameeditdetails();
					  }
					  else
					  {
						Alert alert = new Alert(AlertType.WARNING);
					   alert.setTitle("notificaticon");
					   alert.setHeaderText(null);
					   alert.setContentText("game not found in database");
					   alert.showAndWait();
					  }
			}       
		  
		});
		delete_gameB.setOnAction(e->
		{
			  if(game_idTF.getText().equals(""))
		   {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText(null);
				alert.setContentText("please enter game id");
				alert.showAndWait();
		   }
		   else
			object_Back.deletegame();

		});
		edit_gamebutton.setOnAction(e->
		{
		  object_Back.updategame();


		});

		purchase_request.setOnAction(e->
		{
			object_Back.updatenewpurchasetablecontent(); 
			try{
				admin_container_all.getChildren().remove(1);
			}
			catch(Exception f){}
			admin_container_all.getChildren().add(1,new_purchase__container);
			

		});

		doneB.setOnAction(e->
		{
         object_Back.responduserorder();
        
		});
		contact_us.setOnAction(e->
		{
			 try{user_container_all.getChildren().remove(1);}
			catch(Exception f){}
		  user_container_all.getChildren().add(1,about_programContainer);

		});

		
		}


	public static void main(String[] args)
	{
		launch(args);
	}
}

