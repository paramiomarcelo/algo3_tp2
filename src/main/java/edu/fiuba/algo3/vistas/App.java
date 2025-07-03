package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.SystemInfo;
import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.ability.Legendary;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException, ParseException {
        MusicPlayer.playMusic();
    stage.setTitle("FrulandiaCompany");

    GameView game = new GameView(stage);

    GeneralScreen pantallaGeneral = new GeneralScreen(null);

    Welcome contenedorBienvenidos = new Welcome(pantallaGeneral, game);

    pantallaGeneral.setContenido(contenedorBienvenidos);

    Scene scene = new Scene(pantallaGeneral);

    stage.setScene(scene);
    stage.setMaximized(true);
    stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}