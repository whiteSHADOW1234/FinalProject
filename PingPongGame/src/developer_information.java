import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class developer_information implements Initializable {
    //
    TextAnimator textAnimator1;

    TextAnimator textAnimator2;
    TextAnimator textAnimator3;
    TextAnimator textAnimator4;
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

    }

    // void text_animation() {
    // // change text
    // try {
    // String text = "";
    // Huang.setText(text);
    // System.out.println("hello");
    // } catch (Exception e) {
    // System.out.println(e.getMessage());
    // }
    // }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // TODO Auto-generated method stub
        // try {
        // text_animation();
        // } catch (Exception e) {
        // System.out.println(e.getMessage());
        // }

        //
        TextOutput textOutput = new TextOutput() {
            @Override
            public void writeText(String textOut, int id) {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        if (id == 1)
                            Huang.setText(textOut);
                        else if (id == 2)
                            Lee.setText(textOut);
                        else if (id == 3)
                            Shieh.setText(textOut);
                        else if (id == 4)
                            Kuo.setText(textOut);
                    }
                });
            }
        };
        
        textAnimator1 = new TextAnimator("Enkai Huang", 100, textOutput, 1);
        textAnimator2 = new TextAnimator("Cheng-De Lee", 100, textOutput, 2);
        textAnimator3 = new TextAnimator("Ming-yu Shieh", 100, textOutput, 3);
        textAnimator4 = new TextAnimator("Chia-Zung Kuo", 100, textOutput, 4);

        Thread thread1 = new Thread(textAnimator1);
        Thread thread2 = new Thread(textAnimator2);
        Thread thread3 = new Thread(textAnimator3);
        Thread thread4 = new Thread(textAnimator4);

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

    }

}
