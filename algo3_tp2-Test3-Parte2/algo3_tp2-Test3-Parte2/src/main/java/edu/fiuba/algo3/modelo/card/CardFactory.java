//package edu.fiuba.algo3.modelo.card;
//
//import edu.fiuba.algo3.modelo.ability.*;
//import edu.fiuba.algo3.modelo.effect.Weather;
//
//
//import java.util.List;
//import java.util.Map;
//
//public class CardFactory {
//    private static CardFactory instance;
//
//    private CardFactory() {}
//
//    public static CardFactory getInstance() {
//        if (instance == null) {
//            instance = new CardFactory();
//        }
//        return instance;
//    }
//
//    public AbstractCard createCard(String cardType, Map<String, Object> attributes) {
//        switch (cardType) {
//            case "UnitCard":
//                return createUnitCard(attributes);
//            case "SpecialCard":
//                return createSpecialCard(attributes);
//            default:
//                throw new IllegalArgumentException("Tipo de carta no soportado: " + cardType);
//        }
//    }
//
//    private UnitCard createUnitCard(Map<String, Object> attributes) {
//        Ability ability = null;
//        List<String> abilityTypes = (List<String>) attributes.get("abilityType");
//        for( String abilityType : abilityTypes) {
//            ability = this.createAbility(abilityType);
//        }
//
//        Point points = new Point((Long) attributes.get("points"));
//        return new UnitCard(
//                (String) attributes.get("name"),
//                points,
//                (String) attributes.get("section"),
//                ability
//        );
//    }
//
//    private Ability createAbility(String ability) {
//        switch (ability ) {
//            case "Medico":
//                return new Medic();
//
//            case "Agil":
//                return new Agile();
//
//            case "Carta Unida":
//                return new Bonded();
//
//            case "Legendaria":
//                return new Legendary();
//
//            case "Espia":
//                return new Spies();
//
//            case "Morale Boost":
//                return new SumBaseValue();
//            case "Quemar":
//                return new SumBaseValue();
//            default:
//                throw new IllegalArgumentException("Tipo de habilidad no soportado");
//        }
//    }
//
////    private SpecialCard createSpecialCard(Map<String, Object> attributes) {
////        return new SpecialCard(
////                (String) attributes.get("name"),
////                (String) attributes.get("description"),
////                createEffect((String) attributes.get("effectType"), attributes)
////        );
////    }
////
////    private SpecialEffect createEffect(String effectType, Map<String, Object> attributes) {
////        switch (effectType) {
////            case "Tierra Arrasada":
////                //return new ScorchedEarth();
////            case "Morale Boost":
////                //return new MoraleBoost();
////            case "Clima":
////                //return new SpecialEffect.Engineer();
////            // Add more cases for other effect types as needed
////            default:
////                throw new IllegalArgumentException("Tipo de efecto no soportado: " + effectType);
////        }
////
////    }
//
//    private Weather createWeather(String weatherType) {
//        switch (weatherType) {
//            case "Tiempo despejado":
//                //return new ClearWeatherEffect();
//            case "Lluvia torrencial":
//                //return new TorrentialRainEffect();
//            case "Escarcha mordaz":
//                //return new SnowEffect();
//            case "Tormeta de Skellige":
//                //return new StormEffect();
//            default:
//                throw new IllegalArgumentException("Tipo de clima no soportado: " + weatherType);
//        }
//    }
//}