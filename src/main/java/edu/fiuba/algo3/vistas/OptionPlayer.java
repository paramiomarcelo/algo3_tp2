package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

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
    public void modifierAgil(UnitCard card) {
        Button opt1 = new Button("melee");
        Button opt2 = new Button("ranged");
        getChildren().clear();

        opt1.setOnAction(e-> {
            card.chooseSection(1);
            getChildren().clear();
        });

        opt2.setOnAction(e-> {
            card.chooseSection(2);
            getChildren().clear();
        });

        getChildren().addAll(opt1, opt2);
    }
}
