package edu.fiuba.algo3.vistas;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MusicPlayer {
    private static MediaPlayer mediaPlayer;
    private static List<String> musicFiles;
    private static int currentTrackIndex = 0;
    private static double volume = 0.1;
    static {
        initializeMusicFiles();
    }

    private static void initializeMusicFiles() {
        musicFiles = new ArrayList<>();
        musicFiles.add("/music/gwent-music1.mp3");
        musicFiles.add("/music/gwent-music2.mp3");
        musicFiles.add("/music/gwent-music3.mp3");
        musicFiles.add("/music/gwent-music4.mp3");
    }

    public static void playMusic() {
        if (mediaPlayer == null) {
            loadAndPlayCurrentTrack();
        } else if (mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
            mediaPlayer.play();
        }
    }

    private static void loadAndPlayCurrentTrack() {
        if (currentTrackIndex >= musicFiles.size()) {
            currentTrackIndex = 0;
        }

        String path = Objects.requireNonNull(MusicPlayer.class.getResource(musicFiles.get(currentTrackIndex))).toExternalForm();
        Media media = new Media(path);
        
        if (mediaPlayer != null) {
            mediaPlayer.dispose();
        }
        
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setVolume(volume);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }

    public static void togglePlayPause() {
        if (mediaPlayer != null) {
            if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
                mediaPlayer.pause();
            } else {
                mediaPlayer.play();
            }
        }
    }

    public static boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING;
    }

    public static void nextTrack() {
        currentTrackIndex = (currentTrackIndex + 1) % musicFiles.size();
        loadAndPlayCurrentTrack();
    }

    public static void incrementVolume() {
        if (mediaPlayer != null) {
            volume = Math.min(volume + 0.1, 1.0);
            mediaPlayer.setVolume(volume);
        }
    }

    public static void decrementVolume() {
        if (mediaPlayer != null) {
            volume = Math.max(volume - 0.1, 0.0);
            mediaPlayer.setVolume(volume);
        }
    }
}