package edu.fiuba.algo3.modelo.effect.weatherEffects;

import edu.fiuba.algo3.modelo.enums.SectionType;
import edu.fiuba.algo3.modelo.effect.Weather;
import java.util.List;

public class TorrentialRainEffect extends Weather {
    public TorrentialRainEffect() {
        this.affectedSections = List.of(SectionType.SIEGE);
    }
}