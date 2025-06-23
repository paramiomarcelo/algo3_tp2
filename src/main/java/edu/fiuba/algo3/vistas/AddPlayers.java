package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.image.Image;

import java.awt.*;

public class AddPlayers extends StackPane {

    public AddPlayers(Player player, Runnable onAccept) {
        super();
        this.setPrefSize(400, 200);

        ImageView imagenView = new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/vistas/background/boxText.png"));
        imagenView.setFitWidth(400);
        imagenView.setFitHeight(200);

        VBox contenido = new VBox(10);
        contenido.setAlignment(Pos.CENTER);

        Label nameLabel = new Label("Nombre del Jugador:");
        nameLabel.setStyle("-fx-color-label-visible: white; -fx-text-fill: white;");
        TextField nameField = new TextField();
        nameField.setPrefWidth(200);
        Button enviar = new Button("Aceptar");

        enviar.setOnAction(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                player.setName(name);
                onAccept.run();
                System.out.println("El nombre del Jugador es: " + name);
            }
        });

        contenido.getChildren().addAll(nameLabel, nameField, enviar);
        VBox.setVgrow(nameField, Priority.NEVER);
        nameField.setMaxWidth(200);

        this.getChildren().addAll(imagenView, contenido);
        StackPane.setAlignment(contenido, Pos.CENTER);
    }
}
