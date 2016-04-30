package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

import java.util.Random;

public final class Utilities {

    public static int RollD4() {
        return GetRandomRoll(1, 4);
    }

    public static int RollD6() {
        return GetRandomRoll(1, 6);
    }

    public static int RollD8() {
        return GetRandomRoll(1, 8);
    }

    public static int RollD10() {
        return GetRandomRoll(1, 10);
    }

    public static int RollD20() {
        return GetRandomRoll(1, 20);
    }

    public static int RollD100() {
        return GetRandomRoll(1, 100);
    }

    public static int GetRandomRoll(int min, int max){
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }

    public static short GetAbilityModifier(short abilityScore) {
        double BASE = 10;

        double calculatedValue = (abilityScore - BASE)/2;

        //Force round down is necessary for negative numbers.
        return (short) Math.floor(calculatedValue);
    }

    public static short GetProficiencyBonus() {
        return 1;
    }

    public static short CalculateProficiency() {
        return 1;
    }
}
