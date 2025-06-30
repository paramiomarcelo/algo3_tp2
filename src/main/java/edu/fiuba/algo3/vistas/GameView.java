package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.Game;
import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.ability.Legendary;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.AbstractCard;
import edu.fiuba.algo3.modelo.card.Point;
import edu.fiuba.algo3.modelo.card.SpecialCard;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.deck.Deck;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.fileReader.CustomFileReader;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;


import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Pos;

import javax.print.attribute.standard.Media;

public class GameView extends BorderPane {

    Stage stage;
    private Game game;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Deck deck1;
    private Deck deck2;

    private PlayerStatusPanel playerStatusPanel;
    OptionPlayer optionPlayer = OptionPlayer.getInstance();


    public GameView(Stage stage) throws IOException, ParseException {
        super();

        this.stage = stage;
        initializee();
        GameView view = this;


        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/background/Board.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        player1.distributeCards(10);
        player2.distributeCards(10);
        currentPlayer = game.getCurrentPlayer();


        playerStatusPanel = new PlayerStatusPanel(player1, player2);
        ContenedorBoard board = new ContenedorBoard(Board.getInstance().getsRows(currentPlayer), currentPlayer, player1, player2);
        HandPlayer hand = new HandPlayer(currentPlayer.getHand(), currentPlayer, board, playerStatusPanel, player1, player2);

        Button pass = new Button("Pass");
        pass.setStyle("-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
                "-fx-background-radius: 5;" +
                "-fx-border-color: #b8860b;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-text-fill: #f0e6d2;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 8 15 8 15;" +
                "-fx-cursor: hand;");

        pass.setOnMouseEntered(e -> pass.setStyle(
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
        pass.setOnMouseExited(e -> pass.setStyle(
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
        Button finishTurn = new Button("End turn");
        finishTurn.setStyle("-fx-background-color: linear-gradient(#2a2a2a, #1a1a1a);" +
                "-fx-background-radius: 5;" +
                "-fx-border-color: #b8860b;" +
                "-fx-border-width: 2;" +
                "-fx-border-radius: 5;" +
                "-fx-text-fill: #f0e6d2;" +
                "-fx-font-size: 14px;" +
                "-fx-font-weight: bold;" +
                "-fx-padding: 8 15 8 15;" +
                "-fx-cursor: hand;");

        finishTurn.setOnMouseEntered(e -> finishTurn.setStyle(
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
        finishTurn.setOnMouseExited(e -> finishTurn.setStyle(
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
        HBox botones = new HBox(15, pass, finishTurn);
        botones.setAlignment(Pos.CENTER_RIGHT);
        botones.setStyle("-fx-padding: 20 40 0 0;");

        pass.setOnAction(e -> {
            if(!Board.getInstance().otherPlayer(currentPlayer).isPass()){
                currentPlayer = game.switchTurn(currentPlayer);
                board.currentCards(Board.getInstance().getsRows(currentPlayer));
                board.setJugadorActivo(currentPlayer);
                board.actualizar();
                hand.mostrar(currentPlayer.getHand(), currentPlayer, board, playerStatusPanel, player1, player2);
                System.out.println("turno de jugador: " + currentPlayer.getName());
            }
        });
        finishTurn.setOnAction(e -> {
            if(currentPlayer.getLife() <= 0 || Board.getInstance().otherPlayer(currentPlayer).getLife() <= 0){
                System.out.println("partida terminada");
                System.out.println("Ganador: " + currentPlayer.getName());
                Label ganador = new Label("Ganador: " + currentPlayer.getName());
                getChildren().add(ganador);
                stage.close();
            }else if (Board.getInstance().otherPlayer(currentPlayer).getLife() <= 0) {
                System.out.println("partida terminada");
                System.out.println("Ganador: " + Board.getInstance().otherPlayer(currentPlayer).getName());
                Label ganador = new Label("Ganador: " + Board.getInstance().otherPlayer(currentPlayer).getName());
                ganador.setStyle(
                        "-fx-font-weight: bold;"
                        + "-fx-text-fill: white;"
                        + "-fx-background-color: #fff;"
                );
                getChildren().add(ganador);
                stage.close();

            } else if(Board.getInstance().otherPlayer(currentPlayer).isPass()){
                Board.getInstance().actualScore(currentPlayer);
                Board.getInstance().actualScore(Board.getInstance().otherPlayer(currentPlayer));
                System.out.println("puntos j1:" + currentPlayer.getScore().getScoreTotal());
                System.out.println("puntos j2:" + Board.getInstance().otherPlayer(currentPlayer).getScore().getScoreTotal());
                if(currentPlayer.getScore().getScoreTotal() < Board.getInstance().otherPlayer(currentPlayer).getScore().getScoreTotal()){
                    currentPlayer.substractLife();
                }else{
                    Board.getInstance().otherPlayer(currentPlayer).substractLife();
                }
                game.roundCompleted();
                board.currentCards(Board.getInstance().getsRows(currentPlayer));
                board.setJugadorActivo(currentPlayer);
                board.actualizar();
                hand.mostrar(currentPlayer.getHand(), currentPlayer, board, playerStatusPanel, player1, player2);
                playerStatusPanel.update(player1, player2);
            }else {
                currentPlayer.passTurn();
                currentPlayer = game.switchTurn(currentPlayer);
                board.currentCards(Board.getInstance().getsRows(currentPlayer));
                board.setJugadorActivo(currentPlayer);
                board.actualizar();
                hand.mostrar(currentPlayer.getHand(), currentPlayer, board, playerStatusPanel, player1, player2);
                playerStatusPanel.update(player1, player2);
            }
        });


        AddPlayers p2 = new AddPlayers(player2, () -> {
            this.getChildren().clear();
            setBottom(hand);
            setCenter(board);
            setTop(botones);
            setLeft(playerStatusPanel);
            setRight(optionPlayer);
            playerStatusPanel.update(player1, player2);
        });

        AddPlayers p1 = new AddPlayers(player1, () -> {
            this.getChildren().clear();
            this.setCenter(p2);
        });

        setCenter(p1);

    }

    public void initializee() throws IOException, ParseException {

        CustomFileReader fileReader = new CustomFileReader();
        List<Deck> decks = fileReader.read("src/test/resources/json/gwent.json");


        player1 = new Player("Jugador 1", decks.get(0));
        player2 = new Player("Jugador 2", decks.get(1));

        game = new Game();
        game.setPlayers(player1, player2);

    }
    public List<List<UnitCard>> getCArdsss(){
        List<List<UnitCard>> unitCards = new ArrayList<>();
        unitCards.add(Board.getInstance().getPlayerSection(player2).getCardsSiege()) ;
        unitCards.add(Board.getInstance().getPlayerSection(player2).getCardsRanged()) ;
        unitCards.add(Board.getInstance().getPlayerSection(player1).getCardsMelee()) ;
        unitCards.add(Board.getInstance().getPlayerSection(player2).getCardsMelee()) ;
        unitCards.add(Board.getInstance().getPlayerSection(player1).getCardsRanged()) ;
        unitCards.add(Board.getInstance().getPlayerSection(player2).getCardsSiege()) ;
        return unitCards;
    }
}




