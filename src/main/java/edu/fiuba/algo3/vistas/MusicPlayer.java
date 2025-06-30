package edu.fiuba.algo3.vistas;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Objects;

public class MusicPlayer {
    private static MediaPlayer mediaPlayer;

    public static void playMusic() {
        if (mediaPlayer == null) {
            String path = Objects.requireNonNull(MusicPlayer.class.getResource("/music/gwent-music1.mp3")).toExternalForm();
            Media media = new Media(path);
            mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Repetir indefinidamente
            mediaPlayer.setVolume(0.3); // Volumen (0.0 a 1.0)
            mediaPlayer.play();
        } else if (mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
            mediaPlayer.play();
        }
    }

    public static void stopMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }

    public static void pauseMusic() {
        if (mediaPlayer != null) {
            mediaPlayer.pause();
        }
    }
}