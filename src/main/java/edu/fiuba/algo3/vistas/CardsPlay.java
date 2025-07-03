package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.ability.Agile;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.ability.Medic;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class CardsPlay extends Button {

    AbstractCard card;
    ContenedorBoard contenedorBoard;
    GameView gameView;

    public CardsPlay(AbstractCard card, Player player, ContenedorBoard board, HandPlayer hand, PlayerStatusPanel playerStatusPanel, Player player1, Player player2, GameView gameView) {
        this.card = card;
        this.setPrefSize(100, 90);
        this.contenedorBoard = contenedorBoard;
        this.gameView = gameView;
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
            if (card instanceof UnitCard && ((UnitCard) card).getAbility() instanceof Medic) {
                gameView.playMedicCard((UnitCard) card, player, board, hand, playerStatusPanel, player1, player2);
            } else if (card instanceof UnitCard && ((UnitCard) card).getAbility() instanceof Agile) {
                hand.setDisable(true);
                gameView.playAgileCard((UnitCard) card, player, board, hand, playerStatusPanel, player1, player2);
            } 
            else {
                player.playCard(card);
                board.actualizar();
                hand.mostrar(player.getHand(), player, board, playerStatusPanel, player1, player2, gameView);
                playerStatusPanel.update(player1, player2);
            }
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

    public AbstractCard getCard() {
        return card;
    }

    public CardsPlay(AbstractCard card, Player player) {

        this.setPrefSize(100, 90);
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
            player.playCard(card);
            OptionPlayer.getInstance().getChildren().clear();
            getChildren().clear();
            contenedorBoard.actualizar();
        });

    }
}
