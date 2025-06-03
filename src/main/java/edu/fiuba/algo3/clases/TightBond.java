package edu.fiuba.algo3.clases;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TightBond implements Effect{
    @Override
    public void effect(Board board, Player player, Unit self) {
        Map<Section, Row> rows = board.getRows(player);
        Row row =  rows.get(self.getSection());
        List<Unit> pairs = new ArrayList<>();

        for (Unit card : row.getCards()) {
            if (card.getName().equals(self.getName())) {
                    pairs.add(card);
                }
            }
        if (pairs.size() > 1) {
            for (Unit card : pairs) {
                card.setPoints(card.getOriginalPoints() * 2);
            }
        }else {
            self.setPoints(self.getOriginalPoints());
        }

    }
}
