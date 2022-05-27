import java.io.File;
import java.util.ArrayList;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

// import java.io.FileInputStream;
// import java.io.FileNotFoundException;

// import javazoom.jl.decoder.JavaLayerException;
// import javazoom.jl.player.Player;

public class SongPlayer extends Thread {
    ArrayList<File> songs;
    File directory;
    File[] files;
    int songNumber;
    Media media;
    static MediaPlayer mediaPlayer;
    
    public void run() {
        // try {
        //     FileInputStream fileInputStream = new FileInputStream("PingPongSong.mp3");
        //     // here we find our sound file
        //     Player player = new Player(fileInputStream);
        //     System.out.println("Song is Playing");
        //     player.play();
        // } catch (FileNotFoundException e) {
        //     e.printStackTrace();
        // } catch (JavaLayerException e) {
        //     e.printStackTrace();
        // }
        songs = new ArrayList<File>();
		
		directory = new File("music");
		
		files = directory.listFiles();
		
		if(files != null) {
			
			for(File file : files) {
				
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
