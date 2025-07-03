package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;
import java.util.function.Consumer;

public class OptionPlayer extends VBox {

    private static OptionPlayer optionPlayer;

    OptionPlayer() {
        setStyle("-fx-background-color: rgba(40, 40, 40, 0.4);" + "-fx-border-color: #a48f5f;");
        setPrefSize(150, 700);
    }
    public static OptionPlayer getInstance() {
        if (optionPlayer == null) {
            optionPlayer = new OptionPlayer();
        }
        return optionPlayer;
    }
    public void modifierMedic(List<UnitCard> cards, Player player) {
        this.getChildren().clear();
        for (UnitCard card : cards) {
            CardsPlay cardContenedor = new CardsPlay(card, player);
            cardContenedor.setPrefSize(100,90);
            this.getChildren().add(cardContenedor);
        }
    }
    public void modifierAgil(UnitCard card, Runnable onMelee, Runnable onRanged) {
        Stage popup = new Stage();
        popup.initModality(Modality.APPLICATION_MODAL);
        popup.setTitle("Agile card options");
        
        Label label = new Label("Choose a row to play the card");
        Button meleeBtn = new Button("Melee");
        Button rangedBtn = new Button("Ranged");
        label.setStyle("-fx-text-fill: #f0e6d2; -fx-effect: dropshadow(gaussian, black, 2, 0.5, 0, 1); -fx-font-size: 20px; -fx-font-weight: bold;");

        meleeBtn.setStyle("-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
                "-fx-background-radius: 8;" +
                "-fx-border-color: #b8860b;" +
                "-fx-border-width: 3;" +
                "-fx-border-radius: 8;" +
                "-fx-text-fill: #f0e6d2;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 12 25 12 25;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, black, 3, 0.5, 0, 2);");
        
        rangedBtn.setStyle("-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
                "-fx-background-radius: 8;" +
                "-fx-border-color: #b8860b;" +
                "-fx-border-width: 3;" +
                "-fx-border-radius: 8;" +
                "-fx-text-fill: #f0e6d2;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 12 25 12 25;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, black, 3, 0.5, 0, 2);");
                
        meleeBtn.setOnAction(e -> {
            card.chooseSection(0); // melee
            popup.close();
            if (onMelee != null) onMelee.run();
        });
        rangedBtn.setOnAction(e -> {
            card.chooseSection(1); // ranged
            popup.close();
            if (onRanged != null) onRanged.run();
        });

        HBox botones = new HBox(20, meleeBtn, rangedBtn);
        VBox root = new VBox(20, label, botones);
        root.setStyle("-fx-padding: 30; -fx-alignment: center; -fx-background-color: #222;");

        popup.setScene(new Scene(root));
        popup.setResizable(false);
        popup.showAndWait();
    }
}
