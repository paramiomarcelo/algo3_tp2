package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.ability.*;
import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.effect.ScorchedEarth;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.effect.Weather;
import edu.fiuba.algo3.modelo.effect.weatherEffects.ClearWeatherEffect;
import edu.fiuba.algo3.modelo.effect.weatherEffects.SnowEffect;
import edu.fiuba.algo3.modelo.effect.weatherEffects.StormEffect;
import edu.fiuba.algo3.modelo.effect.weatherEffects.TorrentialRainEffect;

import java.util.Map;

public class CardFactory {
    private static CardFactory instance;

    private CardFactory() {}

    public static CardFactory getInstance() {
        if (instance == null) {
            instance = new CardFactory();
        }
        return instance;
    }

    public AbstractCard createCard(String cardType, Map<String, Object> attributes) {
        switch (cardType) {
            case "UnitCard":
                return createUnitCard(attributes);
            case "SpecialCard":
                return createSpecialCard(attributes);
            default:
                throw new IllegalArgumentException("Tipo de carta no soportado: " + cardType);
        }
    }
    
    private UnitCard createUnitCard(Map<String, Object> attributes) {
        Ability ability = null;
        switch ((String) attributes.get("abilityType")) {
            case "Medico":
                ability = new Medic();
                break;
            case "Agil":
                ability = new Agile();
                break;
            case "Carta Unida":
                ability = new Bonded();
                break;
            case "Legendaria":
                ability = new Legendary();
                break;
            case "Espia":
                ability = new Spies();
                break;
            case "Morale Boost":
                ability = new SumBaseValue();
                break;
            default:
                throw new IllegalArgumentException("Tipo de habilidad no soportado: " + attributes.get("abilityType"));
        }
        Point points = new Point((Integer) attributes.get("points"));
        return new UnitCard(
                (String) attributes.get("name"),
                points,
                (String) attributes.get("section"),
                ability
        );
    }

    private SpecialCard createSpecialCard(Map<String, Object> attributes) {
        return new SpecialCard(
                (String) attributes.get("name"),
                (String) attributes.get("description"),
                createEffect((String) attributes.get("effectType"), attributes)
        );
    }

    private SpecialEffect createEffect(String effectType, Map<String, Object> attributes) {
        switch (effectType) {
            case "Tierra Arrasada":
                return new ScorchedEarth();
            case "Morale Boost":
                //return new MoraleBoost();
            case "Clima":
                //return new SpecialEffect.Engineer();
            // Add more cases for other effect types as needed
            default:
                throw new IllegalArgumentException("Tipo de efecto no soportado: " + effectType);
        }

    }

    private Weather createWeather(String weatherType) {
        switch (weatherType) {
            case "Tiempo despejado":
                //return new ClearWeatherEffect();
            case "Lluvia torrencial":
                return new TorrentialRainEffect();
            case "Escarcha mordaz":
                return new SnowEffect();
            case "Tormenta de Skellies":
                return new StormEffect();
            default:
                throw new IllegalArgumentException("Tipo de clima no soportado: " + weatherType);
        }
    }
}