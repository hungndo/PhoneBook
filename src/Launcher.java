import javafx.application.Application;
import javafx.scene.Scene;
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
			try {
				PhoneBook.storePhoneBook();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			window.close();
		}
	}
}
