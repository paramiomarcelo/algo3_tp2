package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.ability.*;
import edu.fiuba.algo3.modelo.effect.Weather;


import java.util.List;
import java.util.Map;

public class CardFactory {
    private Map<String, BaseCardFactory> cardFactory;
    private static CardFactory instance;

    public CardFactory() {
        this.cardFactory = Map.of(
                "UnitCard", new UnitCardFactory(),
                "SpecialCard", new SpecialCardFactory()
        );

    }

    public static CardFactory getInstance() {
        if (instance == null) {
            instance = new CardFactory();
        }
        return instance;
    }


    public AbstractCard createCard(String cardType, Map<String, Object> attributes) {
        BaseCardFactory factory = cardFactory.get(cardType);
        if (factory == null) {
            throw new IllegalArgumentException("Tipo de carta no soportado: " + cardType);
        }
        return factory.createCard(attributes);
    }



}