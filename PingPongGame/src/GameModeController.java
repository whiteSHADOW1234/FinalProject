import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameModeController {

    PongGame start_play = new PongGame();

    @FXML
    private Button normal_mode;

    @FXML
    private Button pve;

    @FXML
    void to_normal_game(ActionEvent event) {
        Stage stage = (Stage) normal_mode.getScene().getWindow();
        stage.close();
        GameFrame GF = new GameFrame();
        // GameFrame_PVE GF = new GameFrame_PVE();
        PongGame.currentvolume = GF.check_if_GG();

        start_play.end_page_starter(stage);
    }

    @FXML
    void to_pve_game(ActionEvent event) {
        Stage stage = (Stage) normal_mode.getScene().getWindow();
        stage.close();
        // GameFrame GF = new GameFrame();
        GameFrame_PVE GF = new GameFrame_PVE();
        PongGame.currentvolume = GF.check_if_GG();

        start_play.end_page_starter(stage);
    }

}