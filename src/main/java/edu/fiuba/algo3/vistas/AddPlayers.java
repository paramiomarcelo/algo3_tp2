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
        nameLabel.setStyle(
                "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-family: 'Georgia';" +
                        "-fx-effect: dropshadow(gaussian, black, 2, 0.5, 0, 1);"
        );
        nameLabel.setStyle("-fx-color-label-visible: white; -fx-text-fill: white;");
        TextField nameField = new TextField();
        nameField.setStyle(
                "-fx-background-color: #1a1a1a;" +
                        "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-border-color: #b8860b;" +
                        "-fx-border-radius: 4;" +
                        "-fx-background-radius: 4;" +
                        "-fx-border-width: 2;" +
                        "-fx-prompt-text-fill: #666;" +
                        "-fx-padding: 6 10 6 10;"
        );
        nameField.setPrefWidth(200);
        Button enviar = new Button("Aceptar");
        enviar.setStyle(
                "-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
                        "-fx-background-radius: 5;" +
                        "-fx-border-color: #b8860b;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 5;" +
                        "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8 15 8 15;" +
                        "-fx-cursor: hand;"
        );
        nameField.setOnAction(e -> enviar.fire());

        enviar.setOnAction(e -> {
            String name = nameField.getText().trim();
            if (!name.isEmpty()) {
                player.setName(name);
                onAccept.run();
                System.out.println("El nombre del Jugador es: " + name);
            }
        });

        enviar.setOnMouseEntered(e -> enviar.setStyle(
                "-fx-background-color: linear-gradient(#3a3a3a, #222);" +
                        "-fx-background-radius: 5;" +
                        "-fx-border-color: #d4af37;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 5;" +
                        "-fx-text-fill: #ffffff;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8 15 8 15;" +
                        "-fx-cursor: hand;"
        ));
        enviar.setOnMouseExited(e -> enviar.setStyle(
                "-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
                        "-fx-background-radius: 5;" +
                        "-fx-border-color: #b8860b;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 5;" +
                        "-fx-text-fill: #f0e6d2;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 8 15 8 15;" +
                        "-fx-cursor: hand;"
        ));




        contenido.getChildren().addAll(nameLabel, nameField, enviar);
        VBox.setVgrow(nameField, Priority.NEVER);
        nameField.setMaxWidth(200);

        this.getChildren().addAll(imagenView, contenido);
        StackPane.setAlignment(contenido, Pos.CENTER);
    }
}
