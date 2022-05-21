import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PongGame extends Application {
    static int temp;
    SongPlayer DJ = new SongPlayer();

    @FXML
    private Button start;

    @FXML
    private Button quit;

    @FXML
    private Button setting;

    @FXML
    private Button restart;

    @FXML
    private Label situation;

    @FXML
    void Setting(ActionEvent event) {

    }

    @FXML
    void Quit(ActionEvent event) {
        System.exit(0);
    }

    public void initialize() {
        try {
            if (PongGame.temp == 1) {
                System.out.println("blue");
                situation.setText("藍方獲勝");
            } else if (PongGame.temp == 2) {
                System.out.println("red");
                situation.setText("紅方獲勝");
            } else {
                situation.setText("Error " + PongGame.temp);
            }
        } catch (Exception e) {
        }
    }

    @FXML
    void restart(ActionEvent event) {
        playwindow();
    }

    public void win_display() {
        if (PongGame.temp == 1) {
            System.out.println("blue");
            situation.setText("藍方獲勝");
        } else if (PongGame.temp == 2) {
            System.out.println("red");
            situation.setText("紅方獲勝");
        } else {
            situation.setText("Error " + PongGame.temp);
        }
    }

    @FXML
    void startgame(ActionEvent event) {
        Stage stage = (Stage) start.getScene().getWindow();
        stage.close();
        GameFrame GF = new GameFrame();
        PongGame.temp = GF.check_if_GG();

        end_page_starter(stage);
    }

    public void end_page_starter(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_endpage.fxml"));

            Scene background = new Scene(root);
            stage.setTitle("Pong Game");
            stage.setScene(background);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void start(Stage stage) {
        DJ.start();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_startpage.fxml"));

            Scene background = new Scene(root);
            stage.setTitle("Pong Game");
            stage.setScene(background);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void playwindow() {
        Stage stage = (Stage) restart.getScene().getWindow();
        stage.close();
        GameFrame GF = new GameFrame();
        PongGame.temp = GF.check_if_GG();

        end_page_starter(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}
