package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.List;

public class HandPlayer extends HBox {

    public HandPlayer(List<AbstractCard> cards, Player player, ContenedorBoard board, PlayerStatusPanel playerStatusPanel, Player player1, Player player2) {
        super();

        this.setPrefHeight(90);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        this.setStyle("-fx-background-color: rgba(40, 40, 40, 0.4);" + "-fx-border-color: #a48f5f;");

        for (AbstractCard card : cards) {
            CardsDiscardPlay cardContenedor = new CardsDiscardPlay(card, player, board, this, playerStatusPanel, player1, player2);
            cardContenedor.setPrefSize(100,90);
            this.getChildren().add(cardContenedor);
        }
    }
    public void mostrar(List<AbstractCard> cards, Player player, ContenedorBoard board, PlayerStatusPanel playerStatusPanel, Player player1, Player player2) {
        getChildren().clear();
        for (AbstractCard card : cards) {
            CardsPlay cardContenedor = new CardsPlay(card, player, board, this, playerStatusPanel, player1, player2);
            cardContenedor.setPrefSize(100,90);
            this.getChildren().add(cardContenedor);
        }
    }

    public void mostrarDiscardHand(List<AbstractCard> cards, Player player, ContenedorBoard board, PlayerStatusPanel playerStatusPanel, Player player1, Player player2) {
        getChildren().clear();
        for (AbstractCard card : cards) {
            CardsDiscardPlay cardContenedor = new CardsDiscardPlay(card, player, board, this, playerStatusPanel, player1, player2);
            cardContenedor.setPrefSize(100,90);
            this.getChildren().add(cardContenedor);
        }

    }
}
