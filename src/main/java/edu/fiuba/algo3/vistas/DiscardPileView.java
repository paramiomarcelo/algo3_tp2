package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import java.util.function.Consumer;

public class DiscardPileView extends ScrollPane {
    private VBox content;
    private Player player;

    public DiscardPileView(Player player) {
        this.player = player;
        this.setPrefWidth(150);
        this.setStyle("-fx-background: transparent; -fx-background-color: rgba(20,20,20,0.7); -fx-border-color: #a48f5f;");
        this.setBackground(Background.EMPTY);
        content = new VBox(10);
        content.setAlignment(Pos.TOP_CENTER);
        content.setBackground(Background.EMPTY);
        this.setContent(content);
        this.setFitToWidth(true);
        update(player);
    }

    public void update(Player player) {
        this.player = player;
        content.getChildren().clear();
        for (AbstractCard card : player.getDiscardPile()) {
            Image image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/cards/" + card.getName() + ".png");
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(100);
            imageView.setPreserveRatio(true);
            content.getChildren().add(imageView);
        }
    }

    public void enableSelectionMode(Consumer<AbstractCard> onCardSelected) {
        content.getChildren().clear();
        for (AbstractCard card : player.getDiscardPile()) {
            Image image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/cards/" + card.getName() + ".png");
            javafx.scene.control.Button cardButton = new javafx.scene.control.Button();
            cardButton.setGraphic(new ImageView(image));
            cardButton.setStyle("-fx-background-color: transparent; -fx-border-color: #4caf50; -fx-border-width: 2; -fx-padding: 2; -fx-cursor: hand;");
            cardButton.setOnMouseEntered(e -> cardButton.setStyle("-fx-background-color: #222; -fx-border-color: gold; -fx-border-width: 2; -fx-padding: 2; -fx-cursor: hand;"));
            cardButton.setOnMouseExited(e -> cardButton.setStyle("-fx-background-color: transparent; -fx-border-color: #4caf50; -fx-border-width: 2; -fx-padding: 2; -fx-cursor: hand;"));
            cardButton.setOnAction(e -> onCardSelected.accept(card));
            content.getChildren().add(cardButton);
        }
    }

    public void disableSelectionMode() {
        System.out.println("disableSelectionMode ejecutado");
        update(player);
    }
} 