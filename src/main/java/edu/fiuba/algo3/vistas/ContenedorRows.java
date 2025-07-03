package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.UnitCard;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

import java.util.List;

public class ContenedorRows extends StackPane {
    public ContenedorRows(List<UnitCard> cards, String tipoFila,String borderColor) {
        super();
        this.setPrefHeight(90);

        HBox fondo = new HBox();
        fondo.setPrefHeight(90);
        fondo.setAlignment(Pos.CENTER_RIGHT);
        fondo.setStyle(
                "-fx-background-color: rgba(160, 110, 60, 0.2);" +
                "-fx-border-color: #b8860b;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 8;" +
                "-fx-background-radius: 8;" +
                "-fx-effect: dropshadow(gaussian, black, 5, 0.5, 0, 2);" +
                "-fx-border-color: " + borderColor + ";"
        );

        String iconPath = "file:src/main/java/edu/fiuba/algo3/vistas/cards/" + tipoFila + ".png";
        ImageView icono = new ImageView(new Image(iconPath));
        icono.setFitWidth(32);
        icono.setFitHeight(32);
        fondo.getChildren().add(icono);

        HBox cartasBox = new HBox(5);
        cartasBox.setAlignment(Pos.CENTER);
        cartasBox.setPrefHeight(90);

        for (UnitCard card : cards) {
            ContainerCards cardContenedor = new ContainerCards(card);
            cardContenedor.setPrefSize(100,90);
            cartasBox.getChildren().add(cardContenedor);
        }

        this.getChildren().addAll(fondo, cartasBox);
    }
}
