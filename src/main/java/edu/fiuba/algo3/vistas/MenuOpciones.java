package edu.fiuba.algo3.vistas;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.CheckMenuItem;

public class MenuOpciones extends MenuBar {
    public MenuOpciones() {
        Menu menuSonido = new Menu("Sonido");

        CheckMenuItem musica = new CheckMenuItem("Música");
        
        musica.setSelected(true);
        musica.setOnAction(e -> {
            if (musica.isSelected()) {
                MusicPlayer.playMusic();
            } else {
                MusicPlayer.pauseMusic();
            }
        });

        menuSonido.getItems().add(musica);

        this.getMenus().add(menuSonido);
    }
}