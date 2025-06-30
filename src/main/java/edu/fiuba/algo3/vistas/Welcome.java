package edu.fiuba.algo3.vistas;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Welcome extends VBox {

    Stage stage;

    public Welcome(GeneralScreen root, GameView game) {
        super();
        this.stage = stage;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(10);

        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/background/imagenPrincipal.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));


        WelcomeOptions opcionesBienvenida = new WelcomeOptions(()->
        {
            root.setContenido(game);
        });

        opcionesBienvenida.setAlignment(Pos.CENTER);
        opcionesBienvenida.setSpacing(10);

        this.getChildren().add(opcionesBienvenida);
    }
}
