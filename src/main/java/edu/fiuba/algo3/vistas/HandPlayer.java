package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

import java.util.List;

public class HandPlayer extends HBox {

    public HandPlayer(List<AbstractCard> cards, Player player, ContenedorBoard board) {
        super();

        this.setPrefHeight(90);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        this.setStyle("-fx-background-color: #735006; -fx-border-width:2 ;-fx-border-color: #E6300C;");

        for (AbstractCard card : cards) {
            CardsPlay cardContenedor = new CardsPlay(card, player, board, this);
            cardContenedor.setPrefSize(100,90);
            this.getChildren().add(cardContenedor);
        }

    }
    public void mostrar(List<AbstractCard> cards, Player player, ContenedorBoard board) {
        getChildren().clear();
        for (AbstractCard card : cards) {
            CardsPlay cardContenedor = new CardsPlay(card, player, board, this);
            cardContenedor.setPrefSize(100,90);
            this.getChildren().add(cardContenedor);
        }
    }
}
