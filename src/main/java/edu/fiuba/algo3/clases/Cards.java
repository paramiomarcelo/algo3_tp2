package edu.fiuba.algo3.clases;


public abstract class Cards {

    private String name;
    private String description;

    protected Cards(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void playUnit(Board board, Player player, Unit card) {
        board.addCard(player, card);
    }
    public void playSpecial(Board board, Cards card) {

    }

}
