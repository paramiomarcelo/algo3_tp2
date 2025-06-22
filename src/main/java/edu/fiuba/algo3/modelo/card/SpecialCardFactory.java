package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.effect.MoraleBoost;
import edu.fiuba.algo3.modelo.effect.ScorchedEarth;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;

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
                createEffect((String) attributes.get("effectType"), attributes)
        );
    }

    private SpecialEffect createEffect(String effectType, Map<String, Object> attributes) {
        switch (effectType) {
            case "Tierra arrasada":
                return new ScorchedEarth(createSection((String) attributes.get("section")));
            case "Morale boost":
                return new MoraleBoost(createSection((String) attributes.get("section")));
            case "Clima":
                // TODO: Implementar efectos de clima
                return new MoraleBoost(createSection((String) attributes.get("section")));
                //throw new UnsupportedOperationException("Efectos de clima no implementados aún");
            default:
                throw new IllegalArgumentException("Tipo de efecto no soportado: " + effectType);
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
