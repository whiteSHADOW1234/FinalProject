import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PongGame extends Application{

	@FXML
    private Button start;

    @FXML
    void startgame(ActionEvent event) {
		GameFrame frame = new GameFrame();
    }
	
	public void start(Stage stage) {
		try {

            Parent root = FXMLLoader.load(getClass().getResource("final_project_startpage.fxml"));

            Scene background = new Scene(root);
            stage.setTitle("Greedy Snake");
            stage.setScene(background);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	public static void main(String[] args) {
		// GameFrame frame = new GameFrame();
		// new GameFrame();
		// start the game function

		launch();
        // FUCK
	}

}
