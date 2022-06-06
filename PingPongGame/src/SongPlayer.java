import java.io.File;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

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

        while (true) {
            double current = mediaPlayer.getCurrentTime().toSeconds();
            double end = media.getDuration().toSeconds();

            if (current / end >= 1) {
                mediaPlayer.seek(Duration.seconds(0));
            }
        }
    }

    public void setVolume(double volume) {
        mediaPlayer.setVolume(volume);
    }

    public void pause() {
        mediaPlayer.pause();
        media = new Media(songs.get(1).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

    public void resume_music() {
        mediaPlayer.pause();
        media = new Media(songs.get(0).toURI().toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();
    }

}
