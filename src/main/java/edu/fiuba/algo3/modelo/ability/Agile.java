package edu.fiuba.algo3.modelo.ability;


import edu.fiuba.algo3.modelo.board.Board;
import edu.fiuba.algo3.modelo.card.UnitCard;
import edu.fiuba.algo3.modelo.player.Player;
import edu.fiuba.algo3.modelo.section.Section;

import java.util.Scanner;

public class Agile implements Ability {

    @Override
    public Player effect(Player player, UnitCard card, Board board) {
        System.out.println("Choose section: (only numbers, 1 or 2)");
        for (Section section : card.getSection()) {
            System.out.println(section.getType());
        }

        Scanner scan = new Scanner(System.in);

        int index = (scan.nextInt()) - 1;

        card.chooseSection(index);

        return player;
    }
}