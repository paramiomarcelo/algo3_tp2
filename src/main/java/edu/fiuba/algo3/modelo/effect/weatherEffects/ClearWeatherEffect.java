package edu.fiuba.algo3.modelo.effect.weatherEffects;

import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.effect.GlobalEffect;
import edu.fiuba.algo3.modelo.effect.SpecialEffect;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

public class ClearWeatherEffect extends SpecialEffect {
    public ClearWeatherEffect(Section section, Player player) {
        super(section, player);
    }
}