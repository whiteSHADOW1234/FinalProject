import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
// import javafx.application.Platform;
// import javafx.beans.InvalidationListener;
// import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PongGame extends Application implements Initializable {
    static int winner;
    static int currentvolume = 50;
    SongPlayer DJ = new SongPlayer();
    String input_ball_speed;
    int input_ball_speed_int;

    @FXML
    private Button confirm;

    @FXML
    private TextField speedsetting;

    @FXML
    private CheckBox customize_speed;

    @FXML
    private Button mute;

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
    private Button setting_back;

    @FXML
    private Label volume;

    @FXML
    private Slider volumecontroller;

    // 路徑問題
    @FXML
    void Confirm_Speed(ActionEvent event) {
        if (speedsetting.getText() == "") {
            // change paddle machine_speed
            // GF.panel.paddle2.machine_speed = 10;
            GameModeController.AI_speed = 10;
            // speedsetting.setText("10");
            System.out.println("NULL");
        } else {
            System.out.println("NOT NULL");
            input_ball_speed = speedsetting.getText();
            input_ball_speed_int = Integer.parseInt(input_ball_speed);
            GameModeController.AI_speed = input_ball_speed_int;
        }
    }

    @FXML
    void customize_ball_speed(ActionEvent event) {
        if (customize_speed.isSelected()) {
            speedsetting.setVisible(true);
            confirm.setVisible(true);
        } else {
            speedsetting.setVisible(false);
            confirm.setVisible(false);
        }
    }

    @FXML
    void MUTE(ActionEvent event) {
        // close music
        volumecontroller.setValue(0);
    }

    @FXML
    void Setting_Back(ActionEvent event) {
        Stage SETTING = (Stage) setting_back.getScene().getWindow();
        SETTING.close();
    }

    @FXML
    void adjust_volume(MouseEvent event) {

        // convert volumecontroller.getValue() to int
        // temp = (int) (volumecontroller.getValue());
        // volume.setText(Integer.toString(temp));
    }

    @FXML
    void Setting(ActionEvent event) {

        Stage SETTING = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_settingpage.fxml"));

            Scene background = new Scene(root);
            SETTING.setTitle("Pong Game Setting");
            SETTING.setScene(background);
            SETTING.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Quit(ActionEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        try {
            if (PongGame.winner == 1) {
                System.out.println("blue");
                situation.setText("藍方獲勝");
            } else if (PongGame.winner == 2) {
                System.out.println("red");
                situation.setText("紅方獲勝");
            } else {
                situation.setText("Error " + PongGame.winner);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(volumecontroller.getValue());

            volumecontroller.valueProperty().addListener(new ChangeListener<Number>() {

                @Override
                public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
                    currentvolume = (int) (volumecontroller.getValue());
                    volume.setText(Integer.toString(currentvolume));
                    DJ.setVolume(volumecontroller.getValue() * 0.01);

                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            volume.setText(Integer.toString(currentvolume));
            volumecontroller.setValue(currentvolume);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try{
            GameModeController.AI_speed = 10;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // 重開遊戲聲音變小
    @FXML
    void restart(ActionEvent event) {
        Stage stage = (Stage) restart.getScene().getWindow();
        stage.close();
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

    public void win_display() {
        if (PongGame.currentvolume == 1) {
            System.out.println("blue");
            situation.setText("藍方獲勝");
        } else if (PongGame.currentvolume == 2) {
            System.out.println("red");
            situation.setText("紅方獲勝");
        } else {
            situation.setText("Error " + PongGame.currentvolume);
        }
    }

    @FXML
    void startgame(ActionEvent event) {
        Stage gamemode_stage = (Stage) start.getScene().getWindow();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_GameModepage.fxml"));

            Scene background = new Scene(root);
            gamemode_stage.setTitle("Pong Game");
            gamemode_stage.setScene(background);
            gamemode_stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Stage stage = (Stage) start.getScene().getWindow();
        // stage.close();
        // GameFrame GF = new GameFrame();
        // // GameFrame_PVE GF = new GameFrame_PVE();
        // PongGame.currentvolume = GF.check_if_GG();

        // end_page_starter(stage);
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
        PongGame.currentvolume = GF.check_if_GG();

        end_page_starter(stage);
    }

    public static void main(String[] args) {
        launch();
    }

}
