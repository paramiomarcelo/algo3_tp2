package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.UnitCard;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

import java.util.List;

public class ContenedorRows extends HBox {
    public ContenedorRows(List<UnitCard> cards) {
        super();
        this.setPrefHeight(90);
        this.setAlignment(Pos.CENTER);
        this.setSpacing(5);
        this.setStyle("-fx-background-color: #735006; -fx-border-width:2 ;-fx-border-color: #E6A00C;");

        for (UnitCard card : cards) {
            ContainerCards cardContenedor = new ContainerCards(card);
            cardContenedor.setPrefSize(100,90);
            this.getChildren().add(cardContenedor);
        }
    }

}
