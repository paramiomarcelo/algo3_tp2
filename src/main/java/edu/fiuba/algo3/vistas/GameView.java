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
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;

import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class GameView extends BorderPane {

    Stage stage;
    private Game game;
    private Player player1;
    private Player player2;
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
    private MoraleBoost moraleBoost = new MoraleBoost(new Melee());


    public GameView(Stage stage) {
        super();

        this.stage = stage;
        initializee();

        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/vistas/background/Board.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        ContenedorBoard board = new ContenedorBoard(getCArdsss());

        VBox contenedor = new VBox();
        Board a = Board.getInstance();
        setCenter(board);
    }
    public void initializee() {
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
        card6 = new UnitCard("Berserker", "unidad cuerpo a cuerpo",new Point(6), sectionRanged);
        card7 = new UnitCard("Ballesta", "unidad a distancia",new Point(3), sectionRanged);
        card8 = new UnitCard("geralt", "barrabrava de Boca", new Point(15), sectionRanged);

        List<AbstractCard> cards1 = new ArrayList<>();
        cards1.add(unitCard);
        cards1.add(card1);
        cards1.add(card2);
        cards1.add(card3);
        cards1.add(card5);
        cards1.add(card4);
        deck1 = new Deck(cards1);

        deck2 = new Deck(new ArrayList<>());

        player1 = new Player("Jugador1", deck1);
        player2 = new Player("Jugador2", deck2);

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




