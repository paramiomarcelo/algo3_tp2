package edu.fiuba.algo3.modelo.effect.weatherEffects;

import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.effect.Weather;
import java.util.List;

public class FogEffect extends Weather {
    public FogEffect() {
        this.affectedSections = List.of(SectionType.RANGED);
    }
}