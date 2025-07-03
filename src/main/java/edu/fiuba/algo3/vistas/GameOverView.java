package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.player.Player;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.List;

public class GameOverView extends VBox {

    public GameOverView(String winnerName, List<String> roundHistory, Runnable onPlayAgain, Runnable onExit) {
        super(20);
        this.setAlignment(Pos.CENTER);
        this.setStyle("-fx-background-color: #1a1a1a; -fx-padding: 30;");

        Label titleLabel = new Label("GAME OVER");
        titleLabel.setStyle("-fx-font-size: 36px; -fx-font-weight: bold; -fx-text-fill: #f0e6d2; -fx-effect: dropshadow(gaussian, black, 3, 0.5, 0, 2);");

        Label winnerLabel = new Label("Winner: " + winnerName);
        winnerLabel.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #FFD700; -fx-effect: dropshadow(gaussian, black, 2, 0.5, 0, 1);");

        Label historyLabel = new Label("Round History:");
        historyLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #f0e6d2;");

        VBox historyBox = new VBox(5);
        historyBox.setAlignment(Pos.CENTER_LEFT);
        historyBox.setStyle("-fx-background-color: rgba(40,40,40,0.7); -fx-padding: 10;");
        
        for (int i = 0; i < roundHistory.size(); i++) {
            Label roundLabel = new Label("Round " + (i + 1) + ": " + roundHistory.get(i));
            roundLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #f0e6d2; -fx-padding: 2 0 2 0;");
            historyBox.getChildren().add(roundLabel);
        }

        ScrollPane scrollPane = new ScrollPane(historyBox);
        scrollPane.setPrefHeight(200);
        scrollPane.setStyle("-fx-background-color: rgba(40,40,40,0.7); -fx-border-color: #b8860b; -fx-border-width: 2; -fx-background: rgba(40,40,40,0.7);");
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        Button playAgainBtn = new Button("Play Again");
        Button exitBtn = new Button("Exit");

        playAgainBtn.setStyle("-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
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

        exitBtn.setStyle("-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
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

        playAgainBtn.setOnMouseEntered(e -> playAgainBtn.setStyle(
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
        playAgainBtn.setOnMouseExited(e -> playAgainBtn.setStyle(
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

        exitBtn.setOnMouseEntered(e -> exitBtn.setStyle(
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
        exitBtn.setOnMouseExited(e -> exitBtn.setStyle(
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

        playAgainBtn.setOnAction(e -> onPlayAgain.run());
        exitBtn.setOnAction(e -> onExit.run());

        HBox buttonBox = new HBox(20, playAgainBtn, exitBtn);
        buttonBox.setAlignment(Pos.CENTER);

        this.getChildren().addAll(titleLabel, winnerLabel, historyLabel, scrollPane, buttonBox);
    }

    public static void showGameOver(String winnerName, List<String> roundHistory, Runnable onPlayAgain, Runnable onExit) {
        Platform.runLater(() -> {
            Stage gameOverStage = new Stage();
            gameOverStage.initModality(Modality.APPLICATION_MODAL);
            gameOverStage.setTitle("Game Over");
            gameOverStage.setResizable(false);

            GameOverView gameOverView = new GameOverView(winnerName, roundHistory, () -> {
                gameOverStage.close();
                onPlayAgain.run();
            }, () -> {
                gameOverStage.close();
                onExit.run();
            });

            Scene scene = new Scene(gameOverView, 500, 600);
            gameOverStage.setScene(scene);
            gameOverStage.showAndWait();
        });
    }
} 