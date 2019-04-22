import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Launcher extends Application{
    private static Button buttonListAllEntries = new Button("List");
    private static Button buttonFindEntry = new Button("Find");
    private static Button buttonEnterEntry = new Button("Create");
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage myStage) throws Exception {
		myStage.setTitle("Phone Book");
		buttonListAllEntries = new Button();
		buttonListAllEntries.setOnAction(event -> System.out.println("print"));
		
		StackPane layout = new StackPane();
		layout.getChildren().add(buttonListAllEntries);
		
		Scene scene = new Scene(layout, 300, 250);
		
		myStage.setScene(scene);
		myStage.show();
		
	}
}
