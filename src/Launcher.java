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
	private static Stage window;
    
    public static void main(String[] args) throws Exception {
		PhoneBook.readPhoneBook();
		launch(args);
	}

	@Override
	public void start(Stage myStage) throws Exception {
		window = myStage;
		window.setTitle("Phone Book");
		window.setOnCloseRequest(event ->{
			event.consume();
			closeProgram();
		});
		LoginScene.display();
		
	}
	public static void navigator(Scene scene) {
		window.setScene(scene);
		window.show();
	}
	public void closeProgram() {
		AlertBox.display("Closing","Are you sure?");
		System.out.println("Closing");
		if(AlertBox.answer) {
			window.close();
		}
	}
}
