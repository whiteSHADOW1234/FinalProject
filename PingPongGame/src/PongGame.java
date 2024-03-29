import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.util.Duration;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class PongGame extends Application implements Initializable {
    static int winner;
    static int currentvolume = 50; //too loud
    static SongPlayer DJ = new SongPlayer();
    //
    developer_information dev = new developer_information();
    //
    String input_ball_speed;
    int input_ball_speed_int;

    @FXML
    private Button developer_information;

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

    @FXML
    void Developer_Information(ActionEvent event) {
        Stage start_stage = (Stage) start.getScene().getWindow();
        start_stage.close();

        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_developer_information.fxml"));

            Scene background = new Scene(root);
            //
            // background.getStylesheets().add(getClass().getResource("final_project_CSS.css").toExternalForm());
            //
            stage.setTitle("Developers Information");
            stage.setScene(background);
            stage.setOnCloseRequest(e -> {
                DJ.resume_music();
                DJ.setVolume(currentvolume * 0.01);
                PongGame.DJ.resume_music();
                PongGame.DJ.setVolume(PongGame.currentvolume * 0.01);

                try {
                    Stage stage_temp = new Stage();
                    Parent root_temp = FXMLLoader.load(getClass().getResource("final_project_startpage.fxml"));

                    Scene background_temp = new Scene(root_temp);
                    // change the background color
                    //
                    background_temp.getStylesheets()
                            .add(getClass().getResource("final_project_CSS.css").toExternalForm());
                    //
                    stage_temp.setTitle("Pong Game");
                    stage_temp.setScene(background_temp);
                    stage_temp.show();

                } catch (Exception e_temp) {
                    e_temp.printStackTrace();
                }
            });
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Confirm_Speed(ActionEvent event) {
        try {
            if (speedsetting.getText() == "") {
                // change paddle machine_speed
                GameModeController.AI_speed = 10;
            } else {
                input_ball_speed = speedsetting.getText();
                input_ball_speed_int = Integer.parseInt(input_ball_speed);
                GameModeController.AI_speed = input_ball_speed_int;
            }
        } catch (NumberFormatException e) {
            customize_speed.setText("快滾�???��??");
            System.out.println("快滾�???��??");
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
        Stage stage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_startpage.fxml"));

            Scene background = new Scene(root);
            // change the background color
            //
            background.getStylesheets().add(getClass().getResource("final_project_CSS.css").toExternalForm());
            //
            stage.setTitle("Pong Game");
            stage.setScene(background);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void adjust_volume(MouseEvent event) {

    }

    @FXML
    void Setting(ActionEvent event) {
        Stage start_stage = (Stage) start.getScene().getWindow();
        start_stage.close();
        Stage SETTING = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_settingpage.fxml"));

            Scene background = new Scene(root);
            //
            background.getStylesheets().add(getClass().getResource("final_project_CSS.css").toExternalForm());
            //
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
                situation.setText("?????��?��??");
            } else if (PongGame.winner == 2) {
                System.out.println("red");
                situation.setText("�???��?��??");
            } else if (PongGame.winner < 0) {
                if (PongGame.winner == -426)
                    situation.setText("You sucks");
                else
                    situation.setText("??????????????? " + -1 * PongGame.winner);
            } else {
                situation.setText("ERROR s" + PongGame.winner);
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

        try {
            GameModeController.AI_speed = 10;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // button animation
        FadeTransition fade2 = new FadeTransition();
        fade2.setNode(setting);
        fade2.setDuration(Duration.seconds(1));
        fade2.setCycleCount(1);
        fade2.setInterpolator(Interpolator.LINEAR);
        fade2.setFromValue(0);
        fade2.setToValue(1);
        fade2.play();

        FadeTransition fade = new FadeTransition();
        fade.setNode(start);
        fade.setDuration(Duration.seconds(1));
        fade.setCycleCount(1);
        fade.setInterpolator(Interpolator.LINEAR);
        fade.setFromValue(0);
        fade.setToValue(1);
        fade.play();

        FadeTransition fade3 = new FadeTransition();
        fade3.setNode(developer_information);
        fade3.setDuration(Duration.seconds(1));
        fade3.setCycleCount(1);
        fade3.setInterpolator(Interpolator.LINEAR);
        fade3.setFromValue(0);
        fade3.setToValue(1);
        fade3.play();
    }

    // ???????????��?��?��??�?
    @FXML
    void restart(ActionEvent event) {
        Stage stage = (Stage) restart.getScene().getWindow();
        stage.close();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_startpage.fxml"));

            Scene background = new Scene(root);
            background.getStylesheets().add(getClass().getResource("final_project_CSS.css").toExternalForm());
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
            situation.setText("?????��?��??");
        } else if (PongGame.currentvolume == 2) {
            System.out.println("red");
            situation.setText("�???��?��??");
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
            //
            background.getStylesheets().add(getClass().getResource("final_project_CSS.css").toExternalForm());
            //
            gamemode_stage.setTitle("Pong Game");
            gamemode_stage.setScene(background);
            gamemode_stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void end_page_starter(Stage stage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("final_project_endpage.fxml"));

            Scene background = new Scene(root);
            background.getStylesheets().add(getClass().getResource("final_project_CSS.css").toExternalForm());
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
            // change the background color
            //
            background.getStylesheets().add(getClass().getResource("final_project_CSS.css").toExternalForm());
            //
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
