package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.effect.ScorchedEarth;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.effect.WeatherEffect.ClearWeatherEffect;
import edu.fiuba.algo3.modelo.effect.WeatherEffect.SnowEffect;
import edu.fiuba.algo3.modelo.effect.WeatherEffect.StormEffect;
import edu.fiuba.algo3.modelo.effect.WeatherEffect.TorrentialRainEffect;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SpecialCardFactory extends BaseCardFactory {

    @Override
    public AbstractCard createCard(Map<String, Object> attributes) {
        return createSpecialCard(attributes);
    }

    private SpecialCard createSpecialCard(Map<String, Object> attributes) {
        return new SpecialCard(
                (String) attributes.get("name"),
                (String) attributes.get("description"),
                createEffect((String) attributes.get("name"),(String) attributes.get("effectType"), attributes)
        );
    }

    private SpecialEffect createEffect(String name,String effectType, Map<String, Object> attributes) {

        List<Section> sections = new ArrayList<>();

        switch (effectType) {
            case "Tierra arrasada":
                sections.add(new Melee());
                sections.add(new Ranged());
                sections.add(new Siege());
                return new ScorchedEarth(sections);
            case "Morale boost":
                return new MoraleBoost(sections);
            case "Clima":
                return this.createWeather(name,attributes);
            default:
                throw new IllegalArgumentException("Tipo de efecto no soportado: " + effectType);
        }
    }
    private SpecialEffect createWeather(String name, Map<String, Object> attributes) {
        Object afectadoObj = attributes.get("section");
        List<Section> sections = new ArrayList<>();
        switch (name) {
            case "Tiempo despejado":
                if (afectadoObj instanceof List) {
                    List<String> afectadoList = (List<String>) afectadoObj;
                    for (String seccionStr : afectadoList) {
                        sections.add(createSection(seccionStr));
                    }
                }
                return new ClearWeatherEffect(sections);
            case "Escarcha mordaz":
                if (afectadoObj instanceof List) {
                    List<String> afectadoList = (List<String>) afectadoObj;
                    for (String seccionStr : afectadoList) {
                        sections.add(createSection(seccionStr));
                    }
                }
                return new SnowEffect(sections);
            case "Lluvia torrencial":
                if (afectadoObj instanceof List) {
                    List<String> afectadoList = (List<String>) afectadoObj;
                    for (String seccionStr : afectadoList) {
                        sections.add(createSection(seccionStr));
                    }
                }
                return new TorrentialRainEffect(sections);
            case "Tormeta de Skellige":
                if (afectadoObj instanceof List) {
                    List<String> afectadoList = (List<String>) afectadoObj;
                    for (String seccionStr : afectadoList) {
                        sections.add(createSection(seccionStr));
                    }
                }
                return new StormEffect(sections);
            default:
                throw new IllegalArgumentException("Tipo de efecto no soportado: " + name);
        }
    }

    private Section createSection(String sectionType) {
        switch (sectionType) {
            case "Cuerpo a Cuerpo":
            case "Combate Cuerpo a Cuerpo":
                return new Melee();
            case "Rango":
            case "Combate a Distancia":
                return new Ranged();
            case "Asedio":
                return new Siege();
            default:
                throw new IllegalArgumentException("Tipo de sección no soportado: " + sectionType);
        }
    }
}
