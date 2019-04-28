import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Launcher extends Application{
    private static Button buttonListAllEntries = new Button("List");
    private static Button buttonFindEntry = new Button("Find");
    private static Button buttonEnterEntry = new Button("Create");
	Stage window;
    
    public static void main(String[] args) throws Exception {
		PhoneBook.readPhoneBook();
		launch(args);
		String a = "abc";
		System.out.println(a.charAt(3));
	}

	@Override
	public void start(Stage myStage) throws Exception {
		window = myStage;
		window.setTitle("Phone Book");
		window.setOnCloseRequest(event ->{
			event.consume();
			closeProgram();
		});
		
		
		showLoginScene();
		window.show();
		
	}
	public void closeProgram() {
		boolean answer = AlertBox.display("Input","Are you sure?");
		System.out.println("Closing");
		if(answer) {
			window.close();
		}
	}
	public void showLoginScene() {
		GridPane grid = new GridPane();
		grid.setPadding( new Insets(10,10,100,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label nameLabel = new Label("Username:");
		GridPane.setConstraints(nameLabel, 0,0);
		
		TextField nameInput = new TextField();
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label passLabel = new Label("Pass:");
		GridPane.setConstraints(passLabel, 0,1);
		
		TextField passInput = new TextField();
		passInput.setPromptText("password");
		GridPane.setConstraints(passInput, 1, 1);
		
		Button loginButton = new Button("log in");
		loginButton.setOnAction(e -> InputBox.display());
		GridPane.setConstraints(loginButton, 1, 2);
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
		
		Scene scene = new Scene(grid, 300, 250);
		window.setScene(scene);
	}
}
