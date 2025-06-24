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
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GameView extends BorderPane {

    Stage stage;
    private Game game;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Deck deck1;
    private Deck deck2;
    private UnitCard unitCard;

    private UnitCard card1;
    private UnitCard card2;
    private UnitCard card3;
    private UnitCard card5;
    private UnitCard card6;
    private UnitCard card7;
    private UnitCard card8;
    private SpecialCard card4;
    private List<Section> sectionMelee = new ArrayList<>();
    {
        sectionMelee.add(new Melee());
    }
    private MoraleBoost moraleBoost = new MoraleBoost(sectionMelee);


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


        ContenedorBoard board = new ContenedorBoard(Board.getInstance().getsRows(currentPlayer));

        HandPlayer hand = new HandPlayer(currentPlayer.getHand(), currentPlayer, board);


        Button pass = new Button("Passar");
        pass.setOnAction(e -> {
            if(!Board.getInstance().otherPlayer(currentPlayer).isPass()){
                currentPlayer = game.switchTurn(currentPlayer);
                board.currentCards(Board.getInstance().getsRows(currentPlayer));
                board.actualizar();
                hand.mostrar(currentPlayer.getHand(), currentPlayer,board);
                System.out.println("turno de jugador: " + currentPlayer.getName());
            }

        });
        Button finishTurn = new Button("Finalizar Turn");
        finishTurn.setOnAction(e -> {
            if(currentPlayer.getLife() <= 0 || Board.getInstance().otherPlayer(currentPlayer).getLife() <= 0){
                System.out.println("partida terminada");
                stage.close();
            }
            else if(Board.getInstance().otherPlayer(currentPlayer).isPass()){
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
                board.actualizar();
                hand.mostrar(currentPlayer.getHand(), currentPlayer,board);

            }else {
                currentPlayer.passTurn();
                currentPlayer = game.switchTurn(currentPlayer);
                board.currentCards(Board.getInstance().getsRows(currentPlayer));
                board.actualizar();
                hand.mostrar(currentPlayer.getHand(), currentPlayer,board);
            }
        });

        AddPlayers p2 = new AddPlayers(player2, () -> {
            this.getChildren().clear();
            setBottom(hand);
            setCenter(board);
            setRight(pass);
            setLeft(finishTurn);
        });

        AddPlayers p1 = new AddPlayers(player1, () -> {
            this.getChildren().clear();
            this.setCenter(p2);
        });

        setCenter(p1);

    }
    public void initializee() throws IOException, ParseException {
        List<Section> sectionMelee = new ArrayList<>();
        sectionMelee.add(new Melee());

        List<Section> sectionSiege = new ArrayList<>();
        sectionSiege.add(new Siege());

        List<Section> sectionRanged = new ArrayList<>();
        sectionRanged.add(new Ranged());

        Ability legendary = new Legendary();

        unitCard = new UnitCard("Katakan", "Unidad a distancia", new Point(5), sectionRanged);
        card1 = new UnitCard("Catapulta", "unidad de asedio", new Point(4), sectionSiege);
        card2 = new UnitCard("Berserker", "unidad cuerpo a cuerpo",new Point(6), sectionMelee);
        card3 = new UnitCard("Ballesta", "unidad a distancia",new Point(3), sectionSiege);
        card5 = new UnitCard("geralt", "barrabrava de Boca", new Point(15), sectionMelee, legendary);

        card4 = new SpecialCard("ejemplo", "ej", moraleBoost);
        card6 = new UnitCard("Barclay", "unidad cuerpo a cuerpo",new Point(6), sectionRanged);
        card7 = new UnitCard("Cerys", "unidad a distancia",new Point(3), sectionRanged);
        card8 = new UnitCard("Birna Bran", "barrabrava de Boca", new Point(15), sectionRanged);

        CustomFileReader fileReader = new CustomFileReader();
        List<Deck> decks = fileReader.read("src/test/resources/json/gwent.json");


        player1 = new Player("Jugador1", decks.get(0));
        player2 = new Player("Jugador2", decks.get(1));

        game = new Game();
        game.setPlayers(player1, player2);


        player1.addCard(unitCard);
        player1.addCard(card1);
        player1.addCard(card2);
        player1.addCard(card3);


        player1.playCard(card1);
        player1.playCard(card2);
        player1.playCard(card3);
        player2.playCard(card4);
        player2.playCard(card1);
        player2.playCard(card4);
        player1.playCard(card5);
        player1.playCard(card6);
        player1.playCard(card7);
        player1.playCard(card8);
        player2.playCard(card6);
        player2.playCard(card7);
        player2.playCard(card8);

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




