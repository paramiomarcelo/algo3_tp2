package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.UnitCard;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ContenedorBoard extends VBox {

    Stage stage;
    List<List<UnitCard>> cards;

    public ContenedorBoard(List<List<UnitCard>> cards) {
        super();
        this.stage = stage;

        this.cards = cards;
        setMaxSize(1000, 600);

        actualizar();
    }
    public void currentCards(List<List<UnitCard>> cards) {
        this.cards = cards;
    }
    public void actualizar() {
        this.getChildren().clear();
        for (List<UnitCard> fila : cards) {
            ContenedorRows nuevaFila = new ContenedorRows(fila);
            this.getChildren().add(nuevaFila);
        }
    }
}
