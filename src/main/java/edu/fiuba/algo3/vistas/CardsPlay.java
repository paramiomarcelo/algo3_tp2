package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class CardsPlay extends Button {

    AbstractCard card;

    public CardsPlay(AbstractCard card, Player player, ContenedorBoard board, HandPlayer hand, PlayerStatusPanel playerStatusPanel, Player player1, Player player2) {
        this.card = card;
        this.setPrefSize(100, 90);
        this.setStyle("-fx-background-color: transparent; -fx-border-color: black;");
        Image image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/cards/" + card.getName() + ".png");
        ImageView imageView = new ImageView(image);
        this.setGraphic(imageView);

        this.setOnAction(e -> {
            System.out.println("Se seleccionó la carta: " + card.getName());
            player.playCard(card);
            board.actualizar();
            hand.mostrar(player.getHand(), player, board, playerStatusPanel, player1, player2);
            playerStatusPanel.update(player1, player2);
        });

        this.setAlignment(Pos.BOTTOM_CENTER);
    }

    public AbstractCard getCard() {
        return card;
    }
}
