package edu.fiuba.algo3.vistas;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.MenuItem;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class MenuOptions extends MenuBar {
    private MenuItem playPauseItem;
    private Timeline updateTimer;

    public MenuOptions() {
        Menu menuSonido = new Menu("Sound");

        Menu musicSubmenu = new Menu("Music");

        playPauseItem = new MenuItem("Pause");
        playPauseItem.setOnAction(e -> {
            MusicPlayer.togglePlayPause();
            updatePlayPauseText();
        });


        MenuItem nextTrackItem = new MenuItem("Next Track");
        nextTrackItem.setOnAction(e -> {
            MusicPlayer.nextTrack();
        });

        MenuItem increment = new MenuItem("Increment volume");
        increment.setOnAction(e -> {
            MusicPlayer.incrementVolume();
        });
        MenuItem decrement = new MenuItem("Decrement volume");
        decrement.setOnAction(e -> {
            MusicPlayer.decrementVolume();
        });

        musicSubmenu.getItems().addAll(playPauseItem, nextTrackItem, increment, decrement);

        menuSonido.getItems().addAll(musicSubmenu);

        this.getMenus().add(menuSonido);

        setupUpdateTimer();
        
        updatePlayPauseText();
    }

    private void setupUpdateTimer() {
        updateTimer = new Timeline(new KeyFrame(Duration.seconds(1), e -> updatePlayPauseText()));
        updateTimer.setCycleCount(Timeline.INDEFINITE);
        updateTimer.play();
    }

    private void updatePlayPauseText() {
        if (MusicPlayer.isPlaying()) {
            playPauseItem.setText("Pause");
        } else {
            playPauseItem.setText("Resume");
        }
    }

    public void stop() {
        if (updateTimer != null) {
            updateTimer.stop();
        }
    }
}