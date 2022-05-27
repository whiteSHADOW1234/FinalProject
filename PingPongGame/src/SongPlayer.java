import java.io.File;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SongPlayer extends Thread {
    ArrayList<File> songs;
    File directory;
    File[] files;
    int songNumber;
    Media media;
    static MediaPlayer mediaPlayer;

    public void run() {

        songs = new ArrayList<File>();

        directory = new File("music");

        files = directory.listFiles();

        if (files != null) {

            for (File file : files) {

                songs.add(file);
            }
        }

        media = new Media(songs.get(songNumber).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }

}
