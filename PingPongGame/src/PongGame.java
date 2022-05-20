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

    @FXML
    void restart(ActionEvent event) {
        if (event.getSource() == restart)
        {
            playwindow();
        }
    }

    @FXML
    void startgame(ActionEvent event) {
        Stage stage = (Stage)start.getScene().getWindow();
        stage.close();
        GameFrame GF = new GameFrame();
        GF.check_if_GG();
        // win_display(temp);
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

    public void playwindow()
    {
        Stage stage = (Stage)restart.getScene().getWindow();
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
    public void win_display(int temp)
    {
        if (temp == 1)
        {
            System.out.println("blue");
            situation.setText("藍方獲勝");
        }
        else if(temp == 2)
        {
            System.out.println("red");
            situation.setText("紅方獲勝");
        }
    }

    
    public static void main(String[] args) {
        // GameFrame frame = new GameFrame();
        // new GameFrame();
        // start the game function

        launch();
    }

}
