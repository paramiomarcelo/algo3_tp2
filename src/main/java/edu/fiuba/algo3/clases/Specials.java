package edu.fiuba.algo3.clases;

public abstract class Specials extends Cards implements Effect {

    public Specials(String name, String description) {

        super(name, description, true);

    }
    public void effect(Board board, Player player, Unit Self) {

    }
    public void play(Board board, Player player) {

    }
}
