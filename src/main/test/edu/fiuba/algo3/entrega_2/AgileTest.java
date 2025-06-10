package edu.fiuba.algo3.entrega_2;

import java.util.Arrays;
import java.util.List;

import edu.fiuba.algo3.modelo.ability.Agile;
import org.junit.Assert;
import org.junit.Test;


import edu.fiuba.algo3.modelo.card.UnitCard;

public class AgileTest {

    @Test
    public void testAgileAbility() {
    // Arrange
    List<String> allowedSections = Arrays.asList("melee", "ranged");
    Agile agileAbility = new Agile(allowedSections);
    UnitCard agileCard = new UnitCard("Hechicero", "Unidad ágil", 5, "melee", agileAbility);
    
    // Act & Assert

    Assert.assertTrue(agileAbility.canBePlayedIn("melee"));


    Assert.assertTrue(agileAbility.canBePlayedIn("ranged"));
}
}
