package structural;

// Existing class
class AudioPlayer {
    public void playMp3(String file) { System.out.println("Playing mp3 file: " + file); }
    //plays MP3 files only.
}

// Target interface
interface MediaPlayer { void play(String audioType, String file); }//general audio player interface.

// Adapter class
class MediaAdapter implements MediaPlayer {
    AudioPlayer audioPlayer = new AudioPlayer();
    public void play(String audioType, String file) {
        if(audioType.equalsIgnoreCase("mp3")) audioPlayer.playMp3(file);
        else System.out.println("Unsupported format: " + audioType);
    }
}

public class AdapterPatternDemo {
    public static void runDemo() {//Demonstrates playing supported and unsupported audio formats.
        MediaPlayer player = new MediaAdapter();
        player.play("mp3", "song.mp3");
        player.play("wav", "song.wav");
        System.out.println();
    }
}
