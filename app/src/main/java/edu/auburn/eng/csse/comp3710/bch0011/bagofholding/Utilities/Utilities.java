package edu.auburn.eng.csse.comp3710.bch0011.bagofholding.Utilities;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
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

    public static short GetProficiencyBonus(short level) {
        //Get proficiency from db.
        return 1;
    }

    public static short CalculateProficiency(short level, short abilityModifier, boolean isProficient) {
        short result = abilityModifier;

        if (isProficient) {
            short proficiency = GetProficiencyBonus(level);
            result += proficiency;
        }

        return result;
    }

    public static boolean isWholeNumber(String string) {
        if (string != null && !string.trim().isEmpty()) {
            return string.matches("\\d*");
        }

        else {
            return false;
        }
    }

    public static String[] getProperties(Object object) {
        List<String> list = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            list.add(field.getName());
        }

        return list.toArray(new String[list.size()]);
    }

    public static void setField(Object object, String fieldName, Object fieldValue) {
        Class<?> objectClass = object.getClass();
        if (objectClass != null) {
            try {
                Field field = objectClass.getDeclaredField(fieldName);
                field.setAccessible(true);
                Type type = field.getGenericType();

                //This is bad, but dear God I can't figure out how to convert a runtime Type to its actual type through reflection. I know how in C#....
                if (type.toString().toLowerCase().contains("short")) {
                    fieldValue = Short.parseShort((String) fieldValue);
                }

                else if (type.toString().toLowerCase().contains("integer")) {
                    fieldValue = Integer.parseInt((String) fieldValue);
                }

                else if (type.toString().toLowerCase().contains("long")) {
                    fieldValue = Long.parseLong((String) fieldValue);
                }

                else if (type.toString().toLowerCase().contains("boolean")) {
                    fieldValue = Boolean.parseBoolean((String) fieldValue);
                }

                field.set(object, fieldValue);
            }

            catch (NoSuchFieldException e) {
                return;
            }

            catch (Exception e) {
                throw new IllegalStateException(e);
            }
        }
    }
}
