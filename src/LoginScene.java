import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class LoginScene {
	private static String username = "EECS";
	private static String password = "123456";
	public static void display() {
		GridPane grid = new GridPane();
		grid.setPadding( new Insets(10,10,10,10));
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
		GridPane.setConstraints(loginButton, 1, 2);
		loginButton.setOnAction(e -> {
		if(authenticate(nameInput.getText(), passInput.getText())) {
			MainScene.display();
		}
		else {
			Label warning = new Label("Wrong username or password");
			GridPane.setConstraints(warning, 1, 3);
			grid.getChildren().add(warning);
		}
		});
		
		grid.getChildren().addAll(nameLabel, nameInput, passLabel, passInput, loginButton);
		
		Scene scene = new Scene(grid, 300, 250);
		Launcher.navigator(scene);
	}
	public static boolean authenticate(String enteredName,String enteredPass) {
		if(enteredName.equals(username)&&enteredPass.equals(password)) {
			return true;
		}
		else {
			return false;
		}
	}
}
