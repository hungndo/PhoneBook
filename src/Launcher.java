import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
	}

	@Override
	public void start(Stage myStage) throws Exception {
		window = myStage;
		window.setTitle("Phone Book");
		buttonListAllEntries.setOnAction(event -> PhoneBook.listAllEntries());
		buttonFindEntry.setOnAction(event -> AlertBox.display("Alert", "anything"));
		buttonEnterEntry.setOnAction(event -> {
			closeProgram();
		});
		window.setOnCloseRequest(event ->{
			event.consume();
			closeProgram();
		});
		
		VBox layout = new VBox();
		layout.getChildren().addAll(buttonListAllEntries, buttonFindEntry, buttonEnterEntry);
		
		Scene scene = new Scene(layout, 300, 250);
		
		window.setScene(scene);
		window.show();
		
	}
	public void closeProgram() {
		boolean answer = InputBox.display("Input","Are you sure?");
		System.out.println("Closing");
		if(answer) {
			window.close();
		}
	}
}
