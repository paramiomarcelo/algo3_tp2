package edu.fiuba.algo3.modelo.card;

import java.util.Map;

public abstract class BaseCardFactory {
    public abstract AbstractCard createCard(Map<String, Object> attributes);
}
