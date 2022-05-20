import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PongGame extends Application {

    @FXML
    private Button start;

    @FXML
    private Button quit;

    @FXML
    private Button restart;

    @FXML
    void Quit(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void restart(ActionEvent event) {

    }

    @FXML
    void startgame(ActionEvent event) {
        Stage stage = (Stage)start.getScene().getWindow();
        stage.close();
        GameFrame GF = new GameFrame();
        GF.check_if_GG();
        try 
        {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_endpage.fxml"));

            Scene background = new Scene(root);
            stage.setTitle("Greedy Snake");
            stage.setScene(background);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void start(Stage stage) {
        try 
        {
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
    }

}
