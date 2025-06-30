package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.ability.*;
import edu.fiuba.algo3.modelo.section.Melee;
import edu.fiuba.algo3.modelo.section.Ranged;
import edu.fiuba.algo3.modelo.section.Section;
import edu.fiuba.algo3.modelo.section.Siege;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class UnitCardFactory extends BaseCardFactory {

    @Override
    public AbstractCard createCard(Map<String, Object> attributes) {
        return createUnitCard(attributes);
    }

    private UnitCard createUnitCard(Map<String, Object> attributes) {
        Ability ability = new NullObjectAbility();
        List<String> abilityTypes = (List<String>) attributes.get("abilityType");
        if (abilityTypes != null && !abilityTypes.isEmpty()) {
            for (String abilityType : abilityTypes) {
                ability = this.createAbility(abilityType);
            }
        }

        Point points = new Point((Integer) attributes.get("points"));
        List<Section> sections = createSections((String) attributes.get("section"));
        
        return new UnitCard(
                (String) attributes.get("name"),
                "Descripción por defecto", // El JSON no tiene descripción para cartas unitarias
                points,
                sections,
                ability
        );
    }

    private List<Section> createSections(String sectionString) {
        List<Section> sections = new ArrayList<>();
        String[] sectionNames = sectionString.split(", ");
        
        for (String sectionName : sectionNames) {
            switch (sectionName.trim()) {
                case "Cuerpo a Cuerpo":
                case "Combate Cuerpo a Cuerpo":
                    sections.add(new Melee());
                    break;
                case "Rango":
                case "Combate a Distancia":
                    sections.add(new Ranged());
                    break;
                case "Asedio":
                    sections.add(new Siege());
                    break;
                default:
                    throw new IllegalArgumentException("Tipo de sección no soportado: " + sectionName);
            }
        }
        return sections;
    }

    private Ability createAbility(String ability) {
        switch (ability) {
            case "Medico":
                return new Medic();
            case "Agil":
                return new Agile();
            case "Carta Unida":
                return new Bonded();
            case "Legendaria":
                return new NullObjectAbility(); // Temporalmente
            case "Espia":
                return new Spies();
            case "Morale Boost":
                return new NullObjectAbility(); // Temporalmente
            case "Quemar":
                return new NullObjectAbility(); // Temporalmente
            default:
                throw new IllegalArgumentException("Tipo de habilidad no soportado: " + ability);
        }
    }
}
