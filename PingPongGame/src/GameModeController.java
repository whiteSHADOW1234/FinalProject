import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameModeController {
    static int AI_speed = 10;

    PongGame start_play = new PongGame();

    @FXML
    private Button gamemode_back;

    @FXML
    private Button normal_mode;

    @FXML
    private Button pve;

    @FXML
    private Button Infinity_ball;

    @FXML
    void to_normal_game(ActionEvent event) {
        Stage stage = (Stage) normal_mode.getScene().getWindow();
        stage.close();
        GameFrame GF = new GameFrame();
        // GameFrame_PVE GF = new GameFrame_PVE();
        PongGame.winner = GF.check_if_GG();

        start_play.end_page_starter(stage);
    }

    @FXML
    void to_pve_game(ActionEvent event) {
        Stage stage = (Stage) normal_mode.getScene().getWindow();
        stage.close();
        // GameFrame GF = new GameFrame();
        GameFrame_PVE GF = new GameFrame_PVE();
        Paddle.machine_speed = AI_speed;
        PongGame.winner = GF.check_if_GG();

        start_play.end_page_starter(stage);
    }

    @FXML
    void to_infinity_game(ActionEvent event) {
        Stage stage = (Stage) normal_mode.getScene().getWindow();
        stage.close();
        // GameFrame GF = new GameFrame();
        GameFrame_infinity GF = new GameFrame_infinity();
        Paddle.machine_speed = AI_speed;
        PongGame.winner = -1 * GF.check_if_GG();

        start_play.end_page_starter(stage);
    }

    @FXML
    void gamemodeBack(ActionEvent event) {
        Stage gamemodeback = (Stage) gamemode_back.getScene().getWindow();
        gamemodeback.close();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_startpage.fxml"));

            Scene background = new Scene(root);
            // change the background color
            //
            background.getStylesheets().add(getClass().getResource("final_project_CSS.css").toExternalForm());
            //
            gamemodeback.setTitle("Pong Game");
            gamemodeback.setScene(background);
            gamemodeback.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}