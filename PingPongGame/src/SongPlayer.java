import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class SongPlayer extends Thread {
    public void run() {
        try {
            FileInputStream fileInputStream = new FileInputStream("PingPongSong.mp3");
            // here we find our sound file
            Player player = new Player(fileInputStream);
            System.out.println("Song is Playing");
            player.play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }
    }

}
