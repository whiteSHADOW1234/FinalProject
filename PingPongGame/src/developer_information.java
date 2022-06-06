import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class developer_information implements Initializable {
    //
    TextAnimator textAnimator1;
    //

    @FXML
    private Text Huang;

    @FXML
    private Text Kuo;

    @FXML
    private Text Lee;

    @FXML
    private Text Shieh;

    @FXML
    private Text gmail;

    @FXML
    private Label hint;

    @FXML
    private TextField input_command;

    @FXML
    private Text membergroup;

    @FXML
    private ImageView terminal;

    @FXML
    void command_action(ActionEvent event) {
        String command = input_command.getText();
        if (command.equals("")) {
            hint.setText("Please enter a command");
        } else if (command.equals("/betamode on")) {
            GamePanel.beta = true;
            GamePanel_PVE.beta = true;
            GamePanel_infinity.beta = true;
            hint.setText("Beta mode is on\nyou should not see this \nif u are not a developer");
        } else if (command.equals("/betamode off")) {
            GamePanel.beta = false;
            GamePanel_PVE.beta = false;
            hint.setText("Beta mode is off\nyou should not see this \nif u are not a developer");
        } else if (command.equals("command")) {
            hint.setText("你很幽默喔");
        } else if (command.equals("/back")) {
            Stage stage = (Stage) Huang.getScene().getWindow();
            PongGame.DJ.resume_music();
            PongGame.DJ.setVolume(PongGame.currentvolume * 0.01);
            stage.close();

            try {
                Stage stage_temp = new Stage();
                Parent root = FXMLLoader.load(getClass().getResource("final_project_startpage.fxml"));

                Scene background = new Scene(root);
                // change the background color
                //
                background.getStylesheets().add(getClass().getResource("final_project_CSS.css").toExternalForm());
                //
                stage_temp.setTitle("Pong Game");
                stage_temp.setScene(background);
                stage_temp.show();

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            hint.setText("try /betamode on \nor /betamode off\nor /back");
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {

        //
        PongGame.DJ.pause();
        PongGame.DJ.setVolume(PongGame.currentvolume * 0.01);
        TextOutput textOutput = new TextOutput() {
            @Override
            public void writeText(String textOut, int id) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (id == 1) {
                            Huang.setVisible(true);
                            Huang.setText(textOut);
                        } else if (id == 2) {
                            Lee.setVisible(true);
                            Lee.setText(textOut);
                        } else if (id == 3) {
                            Shieh.setVisible(true);
                            Shieh.setText(textOut);
                        } else if (id == 4) {
                            Kuo.setVisible(true);
                            Kuo.setText(textOut);
                        }
                    }
                });
            }
        };

        textAnimator1 = new TextAnimator(100, textOutput, 1);
        Thread thread1 = new Thread(textAnimator1);
        thread1.start();
    }
}
