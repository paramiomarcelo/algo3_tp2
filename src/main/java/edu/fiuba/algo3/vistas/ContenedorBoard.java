package edu.fiuba.algo3.vistas;

import edu.fiuba.algo3.modelo.card.UnitCard;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ContenedorBoard extends VBox {

    Stage stage;
    public ContenedorBoard(List<List<UnitCard>> cards) {
        super();
        this.stage = stage;

        for(List<UnitCard> l : cards){
            ContenedorRows fila = new ContenedorRows(l);
            getChildren().add(fila);
        }
    }
}
