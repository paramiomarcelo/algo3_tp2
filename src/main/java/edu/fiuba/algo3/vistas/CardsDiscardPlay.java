package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class CardsDiscardPlay extends Button {
    AbstractCard card;
    ContenedorBoard contenedorBoard;

    public CardsDiscardPlay(AbstractCard card, Player player, ContenedorBoard board, HandPlayer hand, PlayerStatusPanel playerStatusPanel, Player player1, Player player2) {
        this.card = card;
        this.setPrefSize(100, 90);
        this.contenedorBoard = contenedorBoard;
        this.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent;" +
                        "-fx-padding: 0;" +
                        "-fx-focus-color: transparent;" +
                        "-fx-faint-focus-color: transparent;"
        );
        Image image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/cards/" + card.getName() + ".png");
        ImageView imageView = new ImageView(image);
        this.setGraphic(imageView);

        this.setOnAction(e -> {
            System.out.println("Se seleccionó la carta: " + card.getName());
            player.discardCard((UnitCard) card);
            player.removeCardFromHand(card);
            player.addUnitCard();

        });
        this.setOnMouseEntered(e -> {
            this.setStyle(
                    "-fx-background-color: transparent;" +
                            "-fx-border-color: gold;" +
                            "-fx-border-width: 1;" +
                            "-fx-padding: 0;" +
                            "-fx-focus-color: transparent;" +
                            "-fx-faint-focus-color: transparent;"
            );
        });

        this.setOnMouseExited(e -> {
            this.setStyle(
                    "-fx-background-color: transparent;" +
                            "-fx-border-color: transparent;" +
                            "-fx-padding: 0;" +
                            "-fx-focus-color: transparent;" +
                            "-fx-faint-focus-color: transparent;"
            );
        });

        this.setAlignment(Pos.BOTTOM_CENTER);
    }
}

