package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;
import java.util.ArrayList;

public class CardsDiscardPlay extends Button {
    AbstractCard card;
    ContenedorBoard contenedorBoard;
    private static List<CardsDiscardPlay> selectedCards = new ArrayList<>();
    private static int maxDiscards = 2;
    private boolean isSelected = false;
    private Runnable onSelectionChanged;

    public CardsDiscardPlay(AbstractCard card, Player player, ContenedorBoard board, HandPlayer hand, PlayerStatusPanel playerStatusPanel, Player player1, Player player2, Runnable onSelectionChanged) {
        this.card = card;
        this.setPrefSize(100, 90);
        this.contenedorBoard = contenedorBoard;
        this.onSelectionChanged = onSelectionChanged;
        this.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-border-color: transparent;" +
                        "-fx-padding: 0;" +
                        "-fx-focus-color: transparent;" +
                        "-fx-faint-focus-color: transparent;"
        );
        Image image = new Image("file:src/main/java/edu/fiuba/algo3/vistas/cards/" + card.getName() + ".png");
        ImageView imageView = new ImageView(image);
        this.setGraphic(imageView);

        this.setOnAction(e -> {
            System.out.println("Se seleccionó la carta: " + card.getName());
            
            if (isSelected) {
                deselectCard();
            } else if (selectedCards.size() < maxDiscards) {
                selectCard();
            }
        });
        
        this.setOnMouseEntered(e -> {
            if (!isSelected) {
                this.setStyle(
                        "-fx-background-color: transparent;" +
                                "-fx-border-color: gold;" +
                                "-fx-border-width: 1;" +
                                "-fx-padding: 0;" +
                                "-fx-focus-color: transparent;" +
                                "-fx-faint-focus-color: transparent;"
                );
            }
        });

        this.setOnMouseExited(e -> {
            if (!isSelected) {
                this.setStyle(
                        "-fx-background-color: transparent;" +
                                "-fx-border-color: transparent;" +
                                "-fx-padding: 0;" +
                                "-fx-focus-color: transparent;" +
                                "-fx-faint-focus-color: transparent;"
                );
            }
        });

        this.setAlignment(Pos.BOTTOM_CENTER);
    }
    
    private void selectCard() {
        isSelected = true;
        selectedCards.add(this);
        this.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: #ff6b6b;" +
                "-fx-border-width: 2;" +
                "-fx-padding: 0;" +
                "-fx-focus-color: transparent;" +
                "-fx-faint-focus-color: transparent;" +
                "-fx-opacity: 0.7;"
        );
        if (onSelectionChanged != null) onSelectionChanged.run();
        System.out.println("Carta seleccionada. Total: " + selectedCards.size() + "/" + maxDiscards);
    }
    
    private void deselectCard() {
        isSelected = false;
        selectedCards.remove(this);
        this.setStyle(
                "-fx-background-color: transparent;" +
                "-fx-border-color: transparent;" +
                "-fx-padding: 0;" +
                "-fx-focus-color: transparent;" +
                "-fx-faint-focus-color: transparent;" +
                "-fx-opacity: 1.0;"
        );
        if (onSelectionChanged != null) onSelectionChanged.run();
        System.out.println("Carta deseleccionada. Total: " + selectedCards.size() + "/" + maxDiscards);
    }
    
    public static List<CardsDiscardPlay> getSelectedCards() {
        return new ArrayList<>(selectedCards);
    }
    
    public static void clearSelectedCards() {
        selectedCards.clear();
    }
    
    public static int getSelectedCount() {
        return selectedCards.size();
    }
    
    public AbstractCard getCard() {
        return card;
    }
}

