package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

import java.util.function.Consumer;
import java.util.List;

public class DiscardPhaseView extends BorderPane {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Label counterLabel;
    private HBox cardsPanel;
    private int currentPlayerIndex = 0;

    public DiscardPhaseView(Player player1, Player player2, Runnable onDiscardComplete) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
        
        CardsDiscardPlay.clearSelectedCards();
        
        createDiscardInterface(onDiscardComplete);
    }
    
    private void createDiscardInterface(Runnable onDiscardComplete) {
        this.getChildren().clear();

        VBox mainPanel = new VBox(20);
        mainPanel.setAlignment(Pos.CENTER);
        mainPanel.setStyle(
                "-fx-background-color: rgba(40, 40, 40, 0.9);" +
                "-fx-border-color: #b8860b;" +
                "-fx-border-width: 3;" +
                "-fx-border-radius: 10;" +
                "-fx-background-radius: 10;" +
                "-fx-padding: 30;" +
                "-fx-effect: dropshadow(gaussian, black, 10, 0.5, 0, 5);"
        );
        mainPanel.setMaxWidth(1000);
        mainPanel.setMaxHeight(700);

        Label title = new Label("Discard Phase Player - " + currentPlayer.getName());
        title.setFont(Font.font(28));
        title.setStyle("-fx-text-fill: #f0e6d2; -fx-font-weight: bold; -fx-effect: dropshadow(gaussian, black, 3, 0.5, 0, 2);");
        title.setAlignment(Pos.CENTER);

        Label instructions = new Label("Select 0, 1 or 2 cards to discard. Click a selected card to unselect it.");
        instructions.setFont(Font.font(18));
        instructions.setStyle("-fx-text-fill: #f0e6d2; -fx-effect: dropshadow(gaussian, black, 2, 0.5, 0, 1);");
        instructions.setWrapText(true);
        instructions.setMaxWidth(800);
        instructions.setAlignment(Pos.CENTER);

        counterLabel = new Label("Selected cards: 0/2");
        counterLabel.setFont(Font.font(16));
        counterLabel.setStyle("-fx-text-fill: #f0e6d2; -fx-font-weight: bold; -fx-effect: dropshadow(gaussian, black, 2, 0.5, 0, 1);");
        counterLabel.setAlignment(Pos.CENTER);

        Label handLabel = new Label("Your hand:");
        handLabel.setFont(Font.font(16));
        handLabel.setStyle("-fx-text-fill: #f0e6d2; -fx-font-weight: bold;");
        handLabel.setAlignment(Pos.CENTER);
        
        cardsPanel = new HBox(15);
        cardsPanel.setAlignment(Pos.CENTER);
        cardsPanel.setStyle("-fx-padding: 20;");

        for (var card : currentPlayer.getHand()) {
            CardsDiscardPlay cardButton = new CardsDiscardPlay(card, currentPlayer, null, null, null, player1, player2, this::updateCounter);
            cardsPanel.getChildren().add(cardButton);
        }
        
        Button continueButton = new Button("Continue");
        continueButton.setStyle("-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
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
        
        continueButton.setOnMouseEntered(e -> continueButton.setStyle(
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
        
        continueButton.setOnMouseExited(e -> continueButton.setStyle(
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
        
        continueButton.setOnAction(e -> {
            processSelectedCards();
            
            if (currentPlayerIndex == 0) {
                currentPlayerIndex = 1;
                currentPlayer = player2;
                CardsDiscardPlay.clearSelectedCards();
                createDiscardInterface(onDiscardComplete);
            } else {
                if (onDiscardComplete != null) {
                    onDiscardComplete.run();
                }
            }
        });
        
        mainPanel.getChildren().addAll(title, instructions, counterLabel, handLabel, cardsPanel, continueButton);
        this.setCenter(mainPanel);
    }
    
    private void updateCounter() {
        int count = CardsDiscardPlay.getSelectedCount();
        counterLabel.setText("Selected cards: " + count + "/2");
    }

    private void processSelectedCards() {
        List<CardsDiscardPlay> selectedCards = CardsDiscardPlay.getSelectedCards();
        
        for (CardsDiscardPlay cardButton : selectedCards) {
            AbstractCard card = cardButton.getCard();
            currentPlayer.discardCard(card);
        }
        
        CardsDiscardPlay.clearSelectedCards();
    }
} 