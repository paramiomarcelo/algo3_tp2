package edu.fiuba.algo3.vistas;

import javafx.scene.Node;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class GeneralScreen extends VBox {
    private final MenuOptions menuOptions;
    private Node contenidoActual;

    public GeneralScreen(Node contenidoInicial) {
        super();
        this.menuOptions = new MenuOptions();
        this.getChildren().add(menuOptions);
        if (contenidoInicial != null) {
            setContenido(contenidoInicial);
        }
    }

    public void setContenido(Node nuevoContenido) {
        if (contenidoActual != null) {
            this.getChildren().remove(contenidoActual);
        }
        this.contenidoActual = nuevoContenido;
        this.getChildren().add(contenidoActual);
        VBox.setVgrow(contenidoActual, Priority.ALWAYS);
    }
} 