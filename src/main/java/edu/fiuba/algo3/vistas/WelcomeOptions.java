package edu.fiuba.algo3.vistas;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WelcomeOptions extends VBox {

    Stage stage;
    public WelcomeOptions(Runnable onStart) {
        super();
        this.stage = stage;


        Image startApagado = new Image("file:src/main/java/edu/fiuba/algo3/vistas/background/startDeactivate.png", true);
        Image startEncendido = new Image("file:src/main/java/edu/fiuba/algo3/vistas/background/startActivate.png", true);
        Image exitDeactivate = new Image("file:src/main/java/edu/fiuba/algo3/vistas/background/exitDeactivate.png", true);
        Image exitActivate = new Image("file:src/main/java/edu/fiuba/algo3/vistas/background/exitActivate.png", true);

        ImageView startImageView = new ImageView(startApagado);
        startImageView.setFitWidth(150);
        startImageView.setFitHeight(50);
        startImageView.setPreserveRatio(true);

        ImageView exitImageView = new ImageView(exitDeactivate);
        exitImageView.setFitWidth(150);
        exitImageView.setFitHeight(50);
        exitImageView.setPreserveRatio(true);

        Button startButton = new Button();
        Button exitButton = new Button();

        startButton.setGraphic(startImageView);
        exitButton.setGraphic(exitImageView);

        startButton.setStyle("-fx-background-color: transparent; -fx-padding: 10;");
        exitButton.setStyle("-fx-background-color: transparent; -fx-padding: 10;");

        startButton.setOnMouseEntered(e -> startImageView.setImage(startEncendido));
        startButton.setOnMouseExited(e -> startImageView.setImage(startApagado));

        exitButton.setOnMouseEntered(e -> exitImageView.setImage(exitActivate));
        exitButton.setOnMouseExited(e -> exitImageView.setImage(exitDeactivate));

        startButton.setOnAction(e ->
        {
            onStart.run();
        });
        exitButton.setOnAction(e -> System.exit(0));

        this.getChildren().addAll(startButton, exitButton);
    }






//    Stage stage;
//    public WelcomeOptions(Runnable onStart) {
//        super();
//        this.stage = stage;
//
//
//        Image startApagado = new Image("file:src/vistas/background/startDeactivate.png", true);
//        Image startEncendido = new Image("file:src/vistas/background/startActivate.png", true);
//        Image exitDeactivate = new Image("file:src/vistas/background/exitDeactivate.png", true);
//        Image exitActivate = new Image("file:src/vistas/background/exitActivate.png", true);
//
//        ImageView startImageView = new ImageView(startApagado);
//        startImageView.setFitWidth(150);
//        startImageView.setFitHeight(50);
//        startImageView.setPreserveRatio(true);
//
//        ImageView exitImageView = new ImageView(exitDeactivate);
//        exitImageView.setFitWidth(150);
//        exitImageView.setFitHeight(50);
//        exitImageView.setPreserveRatio(true);
//
//        Button startButton = new Button();
//        Button exitButton = new Button();
//
//        startButton.setGraphic(startImageView);
//        exitButton.setGraphic(exitImageView);
//
//        startButton.setStyle("-fx-background-color: transparent; -fx-padding: 10;");
//        exitButton.setStyle("-fx-background-color: transparent; -fx-padding: 10;");
//
//        startButton.setOnMouseEntered(e -> startImageView.setImage(startEncendido));
//        startButton.setOnMouseExited(e -> startImageView.setImage(startApagado));
//
//        exitButton.setOnMouseEntered(e -> exitImageView.setImage(exitActivate));
//        exitButton.setOnMouseExited(e -> exitImageView.setImage(exitDeactivate));
//
//        startButton.setOnAction(e ->
//        {
//            onStart.run();
////                    stage.setFullScreen(true);
////                    stage.setResizable(false);
////                    stage.centerOnScreen();
//        });
//        exitButton.setOnAction(e -> System.exit(0));
//
//        this.getChildren().addAll(startButton, exitButton);
//
//    }
}
