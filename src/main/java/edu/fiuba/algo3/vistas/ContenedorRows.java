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
        this.setStyle(
                "-fx-background-color: rgba(160, 110, 60, 0.2);" +
                        "-fx-border-color: #b8860b;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 8;" +
                        "-fx-background-radius: 8;" +
                        "-fx-effect: dropshadow(gaussian, black, 5, 0.5, 0, 2);"
        );

        for (UnitCard card : cards) {
            ContainerCards cardContenedor = new ContainerCards(card);
            cardContenedor.setPrefSize(100,90);
            this.getChildren().add(cardContenedor);
        }
    }

}
