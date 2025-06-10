package edu.fiuba.algo3.modelo.effect.weatherEffects;
import edu.fiuba.algo3.modelo.effect.Weather;
import java.util.List;


public class StormEffect extends Weather {
    @Override
    protected List<String> affectedSections() {
        return List.of("siege", "ranged");
    }
}