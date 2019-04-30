import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class MainScene {
	public static void display() {
		GridPane grid = new GridPane();
		grid.setPadding( new Insets(10,10,10,10));
		grid.setVgap(8);
		grid.setHgap(10);
		
		Label[] nameLabel = new Label[PhoneBook.entryIndexList.length];
		for(int i = 0; i< PhoneBook.entryIndex;i++) {
			String temp = PhoneBook.entryList[PhoneBook.entryIndexList[i]].name;
			temp += " "+PhoneBook.entryList[PhoneBook.entryIndexList[i]].number;
			temp += " "+PhoneBook.entryList[PhoneBook.entryIndexList[i]].notes;
			nameLabel[i]=new Label(temp);
			GridPane.setConstraints(nameLabel[i], 0, i);
		}
		for(int i = 0; i< PhoneBook.entryIndex;i++) {
			grid.getChildren().addAll(nameLabel[i]);
		}
		Scene scene = new Scene(grid, 300, 250);
		Launcher.navigator(scene);
	}
}
