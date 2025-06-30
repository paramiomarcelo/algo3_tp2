package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ContenedorBoard extends VBox {

    Stage stage;
    List<List<UnitCard>> cards;
    Player jugadorActivo;
    Player player1;
    Player player2;
    final String player1Color = "#FFD700";
    final String player2Color = "#00BFFF";

    public ContenedorBoard(List<List<UnitCard>> cards, Player jugadorActivo, Player player1, Player player2) {
        super();
        this.stage = stage;
        this.cards = cards;
        this.jugadorActivo = jugadorActivo;
        this.player1 = player1;
        this.player2 = player2;
        setMaxSize(1000, 600);

        actualizar();
    }

    public void currentCards(List<List<UnitCard>> cards) {
        this.cards = cards;
    }

    public void setJugadorActivo(Player jugadorActivo) {
        this.jugadorActivo = jugadorActivo;
    }

    public void actualizar() {
        this.getChildren().clear();
        
        String colorJugadorActivo = (jugadorActivo == player1) ? player1Color : player2Color;
        String colorOponente = (jugadorActivo == player1) ? player2Color : player1Color;
        
        this.getChildren().add(new ContenedorRows(cards.get(0), "siege", colorOponente));
        this.getChildren().add(new ContenedorRows(cards.get(1), "ranged", colorOponente));
        this.getChildren().add(new ContenedorRows(cards.get(2), "melee", colorOponente));
        this.getChildren().add(new ContenedorRows(cards.get(3), "melee", colorJugadorActivo));
        this.getChildren().add(new ContenedorRows(cards.get(4), "ranged", colorJugadorActivo));
        this.getChildren().add(new ContenedorRows(cards.get(5), "siege", colorJugadorActivo));
    }
}
