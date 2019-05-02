import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class MainScene {
	private static 	GridPane grid = new GridPane();
	public static void display() {
		grid.setPadding( new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		// titles
		Label[] title = new Label[3];
		title[0] = new Label("Name");
		title[1] = new Label("Number");
		title[2] = new Label("Notes");
		GridPane.setConstraints(title[0], 0, 0);
		GridPane.setConstraints(title[1], 1, 0);
		GridPane.setConstraints(title[2], 2, 0);
		grid.getChildren().addAll(title[0],title[1],title[2]);
		
		//list entries
		listAllEntries();
		
		// text fields for entering new entries
		TextField entryName = new TextField();
		GridPane.setConstraints(entryName, 0, 1);
		TextField entryNumber = new TextField();
		GridPane.setConstraints(entryNumber, 1, 1);
		TextField entryNotes = new TextField();
		GridPane.setConstraints(entryNotes, 2, 1);
		
		Button addButton = new Button("Add Contact");
		GridPane.setConstraints(addButton, 3, 1);
		addButton.setOnAction(e -> {			
			PhoneBook.addEntry(entryName.getText(),entryNumber.getText(),entryNotes.getText());
			display();
		});
		grid.getChildren().addAll(addButton,entryName,entryNumber,entryNotes);
		//
		Scene scene = new Scene(grid, 630, 250);
		Launcher.navigator(scene);
	}
	public static void listAllEntries() {
		Label[] nameLabel = new Label[PhoneBook.entryIndexList.length];
		Label[] numberLabel = new Label[PhoneBook.entryIndexList.length];
		Label[] notesLabel = new Label[PhoneBook.entryIndexList.length];
		for(int i = 0; i< PhoneBook.entryIndex;i++) {
			nameLabel[i]= new Label(PhoneBook.entryList[PhoneBook.entryIndexList[i]].name);
			numberLabel[i]=new Label(PhoneBook.entryList[PhoneBook.entryIndexList[i]].number);
			notesLabel[i]=new Label(PhoneBook.entryList[PhoneBook.entryIndexList[i]].notes);
			GridPane.setConstraints(nameLabel[i], 0, i+2);
			GridPane.setConstraints(numberLabel[i], 1, i+2);
			GridPane.setConstraints(notesLabel[i], 2, i+2);
		}
		for(int i = 0; i< PhoneBook.entryIndex;i++) {
			grid.getChildren().addAll(nameLabel[i],numberLabel[i],notesLabel[i]);
		}
	}
}
