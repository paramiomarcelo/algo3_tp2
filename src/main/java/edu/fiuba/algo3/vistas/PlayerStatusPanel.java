package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.board.Board;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.geometry.Insets;

public class PlayerStatusPanel extends VBox {
    private final Label player1Label;
    private final Label player2Label;
    private final VBox player1Box;
    private final VBox player2Box;
    private final Label title1;
    private final Label title2;
    private Player player1;
    private Player player2;

    public PlayerStatusPanel(Player player1, Player player2) {
        super(30);
        setAlignment(Pos.CENTER_LEFT);
        setPrefWidth(260);
        setStyle("-fx-background-color: transparent; -fx-padding: 20;");

        this.player1 = player1;
        this.player2 = player2;

        title1 = new Label(player1.getName());
        title1.setStyle("-fx-text-fill: #FFD700; -fx-font-size: 18; -fx-font-weight: bold;");
        player1Label = new Label();
        player1Label.setStyle("-fx-text-fill: white; -fx-font-size: 16;");
        player1Box = new VBox(8, title1, player1Label);
        player1Box.setAlignment(Pos.CENTER);
        player1Box.setPadding(new Insets(15));
        player1Box.setStyle("-fx-background-color: #3a3a3a; -fx-border-color: #FFD700; -fx-border-width: 2; -fx-background-radius: 10; -fx-border-radius: 10;");
        player1Box.setPrefWidth(220);

        title2 = new Label(player2.getName());
        title2.setStyle("-fx-text-fill: #00BFFF; -fx-font-size: 18; -fx-font-weight: bold;");
        player2Label = new Label();
        player2Label.setStyle("-fx-text-fill: white; -fx-font-size: 16;");
        player2Box = new VBox(8, title2, player2Label);
        player2Box.setAlignment(Pos.CENTER);
        player2Box.setPadding(new Insets(15));
        player2Box.setStyle("-fx-background-color: #3a3a3a; -fx-border-color: #00BFFF; -fx-border-width: 2; -fx-background-radius: 10; -fx-border-radius: 10;");
        player2Box.setPrefWidth(220);

        getChildren().addAll(player1Box, player2Box);

        update(player1, player2);
    }

    public void update(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        title1.setText(player1.getName());
        title2.setText(player2.getName());
        Board.getInstance().actualScore(player1);
        Board.getInstance().actualScore(player2);
        player1Label.setText("❤ Life: " + player1.getLife() + "    🏆 Points: " + player1.getScore().getScoreTotal());
        player2Label.setText("❤ Life: " + player2.getLife() + "    🏆 Points: " + player2.getScore().getScoreTotal());
    }
} 