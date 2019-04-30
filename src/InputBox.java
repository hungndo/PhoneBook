import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class InputBox {
	public static void display() {
		Stage window = new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle("Checkbox");
		window.setMinWidth(250);
		
		CheckBox box1 = new CheckBox("Male");
		CheckBox box2 = new CheckBox("Female");
		
		Button button = new Button("Choose");
		
		VBox layout = new VBox(10);
		layout.setAlignment(Pos.CENTER);
		layout.getChildren().addAll(box1,box2, button);
		
		Scene scene = new Scene(layout);
		window.setScene(scene);
		window.show();
	}
}
