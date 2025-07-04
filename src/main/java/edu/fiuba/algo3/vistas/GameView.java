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
import edu.fiuba.algo3.repositorios.CustomFileReader;
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
import javafx.scene.layout.Priority;

import javax.print.attribute.standard.Media;

import javafx.animation.PauseTransition;
import javafx.util.Duration;

public class GameView extends BorderPane {

    Stage stage;
    private Game game;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Deck deck1;
    private Deck deck2;

    private PlayerStatusPanel playerStatusPanel;
    DiscardPileView discardPileView;

    private Label mensajeLabel;
    private List<String> roundHistory = new ArrayList<>();
    private Label roundLabel;
    private int currentRound = 1;

    public GameView(Stage stage) throws IOException, ParseException {
        super();

        this.stage = stage;
        initializee();
        this.currentRound = 1;
        GameView view = this;

        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/background/Board.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        player1.distributeCards(10);
        player2.distributeCards(10);
        currentPlayer = game.getCurrentPlayer();

        AddPlayers p2 = new AddPlayers(player2, () -> {
            this.getChildren().clear();
            this.discardPhase();
        });

        AddPlayers p1 = new AddPlayers(player1, () -> {
            this.getChildren().clear();
            this.setCenter(p2);
        });

        setCenter(p1);
    }

    private void discardPhase(){
        DiscardPhaseView discardPhaseView = new DiscardPhaseView(player1, player2, () -> {
            this.startGame();
        });
        this.getChildren().clear();
        this.setCenter(discardPhaseView);
    }

    private void startGame() {
        playerStatusPanel = new PlayerStatusPanel(player1, player2);
        ContenedorBoard board = new ContenedorBoard(Board.getInstance().getsRows(currentPlayer), currentPlayer, player1, player2);
        HandPlayer hand = new HandPlayer(currentPlayer.getHand(), currentPlayer, board, playerStatusPanel, player1, player2, this);

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

        discardPileView = new DiscardPileView(currentPlayer);

        pass.setOnAction(e -> {
            if(!Board.getInstance().otherPlayer(currentPlayer).isPass()){
                currentPlayer = game.switchTurn(currentPlayer);
                board.currentCards(Board.getInstance().getsRows(currentPlayer));
                board.setJugadorActivo(currentPlayer);
                board.actualizar();
                hand.mostrar(currentPlayer.getHand(), currentPlayer, board, playerStatusPanel, player1, player2, this);
                discardPileView.update(currentPlayer);
                System.out.println("turno de jugador: " + currentPlayer.getName());
                showTemporaryMessage("It's " + currentPlayer.getName() + "'s turn!", 2);
            } else {
                showTemporaryMessage(Board.getInstance().otherPlayer(currentPlayer).getName() + " has passed the turn", 2);
            }
        });
        finishTurn.setOnAction(e -> {
            if(currentPlayer.getLife() <= 0 || Board.getInstance().otherPlayer(currentPlayer).getLife() <= 0){
                System.out.println("partida terminada");
                System.out.println("Ganador: " + currentPlayer.getName());

                if(currentPlayer.getLife() > 0) {
                    currentPlayer.substractLife();
                } else if(Board.getInstance().otherPlayer(currentPlayer).getLife() > 0) {
                    Board.getInstance().otherPlayer(currentPlayer).substractLife();
                }
                
                GameOverView.showGameOver(
                    currentPlayer.getName(), 
                    roundHistory, 
                    () -> {
                        stage.close();
                        try {
                            game.reset();
                            new App().start(new Stage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }, 
                    () -> {
                        stage.close();
                        System.exit(0);
                    }
                );
            }else if (Board.getInstance().otherPlayer(currentPlayer).getLife() <= 0) {
                System.out.println("partida terminada");
                System.out.println("Ganador: " + Board.getInstance().otherPlayer(currentPlayer).getName());

                if(currentPlayer.getLife() > 0) {
                    currentPlayer.substractLife();
                } else if(Board.getInstance().otherPlayer(currentPlayer).getLife() > 0) {
                    Board.getInstance().otherPlayer(currentPlayer).substractLife();
                }
                
                GameOverView.showGameOver(
                    Board.getInstance().otherPlayer(currentPlayer).getName(), 
                    roundHistory, 
                    () -> {
                        stage.close();
                        try {
                            game.reset();
                            new App().start(new Stage());
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }, 
                    () -> {
                        stage.close();
                        System.exit(0);
                    }
                );
            } else if(Board.getInstance().otherPlayer(currentPlayer).isPass()){
                Board.getInstance().actualScore(currentPlayer);
                Board.getInstance().actualScore(Board.getInstance().otherPlayer(currentPlayer));
                int score1 = currentPlayer.getScore().getScoreTotal();
                int score2 = Board.getInstance().otherPlayer(currentPlayer).getScore().getScoreTotal();
                String winnerName = (score1 < score2) ? Board.getInstance().otherPlayer(currentPlayer).getName() : currentPlayer.getName();
                
                hand.setDisable(true);
                
                roundHistory.add(winnerName + " won. Score: " + score1 + " - " + score2);
                
                RoundEndView.showRoundEnd(winnerName, score1, score2, () -> {
                    if(currentPlayer.getScore().getScoreTotal() < Board.getInstance().otherPlayer(currentPlayer).getScore().getScoreTotal()){
                        currentPlayer.substractLife();
                    }else{
                        Board.getInstance().otherPlayer(currentPlayer).substractLife();
                    }
                    
                    if(currentPlayer.getLife() <= 0 || Board.getInstance().otherPlayer(currentPlayer).getLife() <= 0){
                        String gameWinnerName = (currentPlayer.getLife() <= 0) ? Board.getInstance().otherPlayer(currentPlayer).getName() : currentPlayer.getName();
                        
                        GameOverView.showGameOver(
                            gameWinnerName, 
                            roundHistory, 
                            () -> {
                                stage.close();
                                try {
                                    game.reset();
                                    new App().start(new Stage());
                                } catch (Exception ex) {
                                    ex.printStackTrace();
                                }
                            }, 
                            () -> {
                                stage.close();
                                System.exit(0);
                            }
                        );
                        return;
                    }
                    
                    game.roundCompleted();
                    board.currentCards(Board.getInstance().getsRows(currentPlayer));
                    board.setJugadorActivo(currentPlayer);
                    board.actualizar();
                    hand.mostrar(currentPlayer.getHand(), currentPlayer, board, playerStatusPanel, player1, player2, this);
                    playerStatusPanel.update(player1, player2);
                    discardPileView.update(currentPlayer);
                    
                    hand.setDisable(false);
                    
                    
                    currentRound++;
                    roundLabel.setText("Round " + currentRound + "/3");
                    
                    showTemporaryMessage("It's " + currentPlayer.getName() + "'s turn!", 2);
                });
            }else {
                currentPlayer.passTurn();
                currentPlayer = game.switchTurn(currentPlayer);
                board.currentCards(Board.getInstance().getsRows(currentPlayer));
                board.setJugadorActivo(currentPlayer);
                board.actualizar();
                hand.mostrar(currentPlayer.getHand(), currentPlayer, board, playerStatusPanel, player1, player2, this);
                playerStatusPanel.update(player1, player2);
                discardPileView.update(currentPlayer);
                showTemporaryMessage("It's " + currentPlayer.getName() + "'s turn!", 2);
            }
        });

        this.getChildren().clear();
        setBottom(hand);    
        setCenter(board);

        mensajeLabel = new Label();
        mensajeLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #f0e6d2; -fx-background-color: rgba(40,40,40,0.7); -fx-padding: 8 20 8 20; -fx-background-radius: 10;");
        mensajeLabel.setVisible(false);


        roundLabel = new Label("Round 1/3");
        roundLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: #f0e6d2; -fx-background-color: rgba(40,40,40,0.8); -fx-padding: 5 10 5 10; -fx-background-radius: 5; -fx-border-color: #b8860b; -fx-border-width: 2; -fx-border-radius: 5;");

        VBox topBox = new VBox();
        topBox.getChildren().addAll(mensajeLabel, botones);
        topBox.setAlignment(Pos.CENTER);
        
        
        HBox topLayout = new HBox();
        topLayout.setAlignment(Pos.CENTER);
        topLayout.getChildren().addAll(roundLabel, topBox);
        HBox.setHgrow(topBox, Priority.ALWAYS); 
        
        setTop(topLayout);

        setLeft(playerStatusPanel);
        setRight(discardPileView);
        playerStatusPanel.update(player1, player2);

        showTemporaryMessage("It's " + currentPlayer.getName() + "'s turn!", 2);
    }

    public void initializee() throws IOException, ParseException {

        CustomFileReader fileReader = new CustomFileReader();
        List<Deck> decks = fileReader.read("src/test/resources/json/gwent.json");


        player1 = new Player("Player 1", decks.get(0));
        player2 = new Player("Player 2", decks.get(1));

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

    public void playMedicCard(UnitCard medicCard, Player player, ContenedorBoard board, HandPlayer hand, PlayerStatusPanel playerStatusPanel, Player player1, Player player2) {
        hand.setDisable(true);
        showTemporaryMessage("Choose a card from the discard pile", 3);
        final boolean[] alreadyExecuted = {false};
        discardPileView.enableSelectionMode(cardSeleccionada -> {
            if (alreadyExecuted[0]) return;
            alreadyExecuted[0] = true;
            int index = player.getDiscardPile().indexOf(cardSeleccionada);
            if (index >= 0) {
                discardPileView.disableSelectionMode();
                player.playCard(medicCard,index);
                board.actualizar();
                hand.mostrar(player.getHand(), player, board, playerStatusPanel, player1, player2, this);
                playerStatusPanel.update(player1, player2);
                discardPileView.update(player);
                hand.setDisable(false);
            }
        });
    }

    public void playAgileCard(UnitCard agileCard, Player player, ContenedorBoard board, HandPlayer hand, PlayerStatusPanel playerStatusPanel, Player player1, Player player2) {
        showTemporaryMessage("Choose a row to play the Agile card", 3);
        OptionPlayer.getInstance().modifierAgil(
            agileCard,
            () -> {
                player.playCard(agileCard);
                board.actualizar();
                hand.mostrar(player.getHand(), player, board, playerStatusPanel, player1, player2, this);
                playerStatusPanel.update(player1, player2);
                hand.setDisable(false);
            },
            () -> {
                player.playCard(agileCard);
                board.actualizar();
                hand.mostrar(player.getHand(), player, board, playerStatusPanel, player1, player2, this);
                playerStatusPanel.update(player1, player2);
                hand.setDisable(false);
            }
        );
    }

    public void showTemporaryMessage(String message, int seconds) {
        mensajeLabel.setText(message);
        mensajeLabel.setVisible(true);
        PauseTransition pause = new PauseTransition(Duration.seconds(seconds));
        pause.setOnFinished(e -> mensajeLabel.setVisible(false));
        pause.play();
    }
}




