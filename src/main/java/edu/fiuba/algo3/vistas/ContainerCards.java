package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ContainerCards extends HBox {

    public ContainerCards(AbstractCard card) {
        super();
        Image image;
//        Label name = new Label(card.getName());
//        Label description = new Label(card.getDescription());

        image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/cards/" + card.getName() + ".png");
        BackgroundImage bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );
        this.setPrefSize(200, 320);
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setBackground(new Background(bgImage));
//        this.getChildren().addAll(name, description );
    }

}
