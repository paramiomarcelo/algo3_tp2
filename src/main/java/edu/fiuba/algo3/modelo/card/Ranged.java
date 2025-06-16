package edu.fiuba.algo3.modelo.card;

import edu.fiuba.algo3.modelo.ability.Ability;
import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.player.Player;


public class Ranged extends UnitCard {

    public Ranged(String name, String description, Integer points, String rowType) {
        super(name, description,points,rowType);
    }

    public Ranged(String name, String description, Integer points, String rowType, Ability abilities) {
        super(name, description, points, rowType, abilities);
    }

    @Override
    public void play(Player p, Board b) {
        b.getSide(p).getRanged().getCards().add(this);
    }

    public void setPoints(Integer points) {super.setPoints(points);}

    public Integer getPoints() {return super.getPoints();}

    public Integer getBasePoints() {return super.getBasePoints();}

    public Player apply(Player player) { return super.apply(player);}

    public void addAbility(Ability ability) {super.addAbility(ability);}

    public Ability getAbility() {return super.getAbility();}

}
