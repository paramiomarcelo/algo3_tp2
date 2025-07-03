package edu.fiuba.algo3.vistas;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class RoundEndView extends VBox {

    public RoundEndView(String winnerName, int score1, int score2, Runnable onContinue) {
        super(20);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #1a1a1a; -fx-padding: 30;");

        Label titleLabel = new Label("ROUND ENDED");
        titleLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold; -fx-text-fill: #f0e6d2; -fx-effect: dropshadow(gaussian, black, 3, 0.5, 0, 2);");

        Label winnerLabel = new Label(winnerName + " won the round!");
        winnerLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #FFD700; -fx-effect: dropshadow(gaussian, black, 2, 0.5, 0, 1);");

        Label scoreLabel = new Label("Score: " + score1 + " - " + score2);
        scoreLabel.setStyle("-fx-font-size: 16px; -fx-text-fill: #f0e6d2;");

        Button continueBtn = new Button("Continue");
        continueBtn.setStyle("-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
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

        continueBtn.setOnMouseEntered(e -> continueBtn.setStyle(
                "-fx-background-color: linear-gradient(#3a3a3a, #222);" +
                "-fx-background-radius: 8;" +
                "-fx-border-color: #d4af37;" +
                "-fx-border-width: 3;" +
                "-fx-border-radius: 8;" +
                "-fx-text-fill: #ffffff;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 12 25 12 25;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, black, 3, 0.5, 0, 2);"
        ));
        continueBtn.setOnMouseExited(e -> continueBtn.setStyle(
                "-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
                "-fx-background-radius: 8;" +
                "-fx-border-color: #b8860b;" +
                "-fx-border-width: 3;" +
                "-fx-border-radius: 8;" +
                "-fx-text-fill: #f0e6d2;" +
                "-fx-font-size: 16px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 12 25 12 25;" +
                "-fx-cursor: hand;" +
                "-fx-effect: dropshadow(gaussian, black, 3, 0.5, 0, 2);"
        ));

        continueBtn.setOnAction(e -> {
            ((Stage) this.getScene().getWindow()).close();
            onContinue.run();
        });

        this.getChildren().addAll(titleLabel, winnerLabel, scoreLabel, continueBtn);
    }

    public static void showRoundEnd(String winnerName, int score1, int score2, Runnable onContinue) {
        Platform.runLater(() -> {
            Stage roundEndStage = new Stage();
            roundEndStage.initModality(Modality.APPLICATION_MODAL);
            roundEndStage.setTitle("Round End");
            roundEndStage.setResizable(false);

            RoundEndView roundEndView = new RoundEndView(winnerName, score1, score2, () -> {
                roundEndStage.close();
                onContinue.run();
            });

            Scene scene = new Scene(roundEndView, 400, 300);
            roundEndStage.setScene(scene);
            roundEndStage.showAndWait();
        });
    }
} 