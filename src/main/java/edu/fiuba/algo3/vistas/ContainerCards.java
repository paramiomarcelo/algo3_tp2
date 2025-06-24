package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class ContainerCards extends HBox {

    public ContainerCards(UnitCard card) {
        super();
        Image image;
        image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/cards/" + card.getName() + ".png");
        BackgroundImage bgImage = new BackgroundImage(
                image,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                BackgroundSize.DEFAULT
        );
        Pane info = new Pane();
        info.setPrefSize(200,320);
        Label point = new Label("" + card.getPoints());
        point.setStyle("-fx-font-size: 15; text-fill: #534f4f;");
        point.setLayoutX(9);
        point.setLayoutY(-3);
        info.getChildren().addAll(point);
        this.setPrefSize(200, 320);
        this.setAlignment(Pos.BOTTOM_CENTER);
        this.setBackground(new Background(bgImage));
        getChildren().addAll(info);
    }

}
