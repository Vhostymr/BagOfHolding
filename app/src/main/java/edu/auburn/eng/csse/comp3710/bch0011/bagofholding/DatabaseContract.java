package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import java.sql.Statement;

public final class DatabaseContract {
    // To prevent someone from accidentally instantiating the contract class, give it an empty constructor.
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Character implements BaseColumns {
        public static final String TABLE_NAME = "Character";
        public static final String COLUMN_NAME_CHARACTER_NAME = "CharacterName";
        public static final String COLUMN_NAME_LEVEL = "Level";
        public static final String COLUMN_NAME_EXPERIENCE = "Experience";
        public static final String COLUMN_NAME_RACE_ID = "RaceID";
        public static final String COLUMN_NAME_CLASS_ID = "ClassID";
        public static final String COLUMN_NAME_ALIGNMENT_ID = "AlignmentID";
        public static final String COLUMN_NAME_GENDER_ID = "GenderID";
        public static final String COLUMN_NAME_STATS_ID = "StatsID";
        public static final String COLUMN_NAME_SECONDARY_STATS_ID = "SecondaryStatsID";
        public static final String COLUMN_NAME_PROFICIENCY_ID = "ProficiencyID";
    }

    public static abstract class Race implements BaseColumns {
        public static final String TABLE_NAME = "Race";
        public static final String COLUMN_NAME_RACE_NAME = "RaceName";
    }

    public static abstract class Class implements BaseColumns {
        public static final String TABLE_NAME = "Class";
        public static final String COLUMN_NAME_CLASS_NAME = "ClassName";
    }

    public static abstract class Alignment implements BaseColumns {
        public static final String TABLE_NAME = "Alignment";
        public static final String COLUMN_NAME_ALIGNMENT_NAME = "AlignmentName";
    }

    public static abstract class Gender implements BaseColumns {
        public static final String TABLE_NAME = "Gender";
        public static final String COLUMN_NAME_GENDER_NAME = "GenderName";
    }

    public static abstract class Stat implements BaseColumns {
        public static final String TABLE_NAME = "Stat";
        public static final String COLUMN_NAME_STRENGTH = "Strength";
        public static final String COLUMN_NAME_DEXTERITY = "Dexterity";
        public static final String COLUMN_NAME_CONSTITUTION = "Constitution";
        public static final String COLUMN_NAME_INTELLIGENCE = "Intelligence";
        public static final String COLUMN_NAME_WISDOM = "Wisdom";
        public static final String COLUMN_NAME_CHARISMA = "Charisma";
    }

    public static abstract class SecondaryStats implements BaseColumns {
        public static final String TABLE_NAME = "SecondaryStats";
        public static final String COLUMN_NAME_ARMOR_CLASS = "ArmorClass";
        public static final String COLUMN_NAME_INITIATIVE = "Initiative";
        public static final String COLUMN_NAME_SPEED = "Speed";
        public static final String COLUMN_NAME_MAX_HP = "MaxHP";
        public static final String COLUMN_NAME_TEMP_HP = "TempHP";
    }

    public static abstract class Proficiency implements BaseColumns {
        public static final String TABLE_NAME = "Proficiency";

        //Strength
        public static final String COLUMN_NAME_STRENGTH_SAVING_THROW = "StrengthSavingThrow";
        public static final String COLUMN_NAME_ATHLETICS = "Athletics";

        //Dexterity
        public static final String COLUMN_NAME_DEXTERITY_SAVING_THROW = "DexteritySavingThrow";
        public static final String COLUMN_NAME_ACROBATICS = "Acrobatics";
        public static final String COLUMN_NAME_SLEIGHT_OF_HAND = "SleightOfHand";
        public static final String COLUMN_NAME_STEALTH = "Stealth";

        //Constitution
        public static final String COLUMN_NAME_CONSTITUTION_SAVING_THROW = "ConstitutionSavingThrow";

        //Intelligence
        public static final String COLUMN_NAME_INTELLIGENCE_SAVING_THROW = "IntelligenceSavingThrow";
        public static final String COLUMN_NAME_ARCANA = "Arcana";
        public static final String COLUMN_NAME_HISTORY = "History";
        public static final String COLUMN_NAME_INVESTIGATION = "Investigation";
        public static final String COLUMN_NAME_NATURE = "Nature";
        public static final String COLUMN_NAME_RELIGION = "Religion";

        //Wisdom
        public static final String COLUMN_NAME_WISDOM_SAVING_THROW = "WisdomSavingThrow";
        public static final String COLUMN_NAME_ANIMAL_HANDLING = "AnimalHandling";
        public static final String COLUMN_NAME_INSIGHT = "Insight";
        public static final String COLUMN_NAME_MEDICINE = "Medicine";
        public static final String COLUMN_NAME_PERCEPTION = "Perception";
        public static final String COLUMN_NAME_SURVIVAL = "Survival";

        //Charisma
        public static final String COLUMN_NAME_CHARISMA_SAVING_THROW = "CharismaSavingThrows";
        public static final String COLUMN_NAME_DECEPTION = "Deception";
        public static final String COLUMN_NAME_INTIMIDATION = "Intimidation";
        public static final String COLUMN_NAME_PERFORMANCE = "Performance";
        public static final String COLUMN_NAME_PERSUASION = "Persuasion";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String INTEGER = " INTEGER";
    private static final String PRIMARY_KEY = " PRIMARY KEY AUTOINCREMENT";
    private static final String FOREIGN_KEY = "FOREIGN KEY(";
    private static final String REFERENCES = ") REFERENCES ";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Race.TABLE_NAME + " (" +
                    Race._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Race.COLUMN_NAME_RACE_NAME + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Class.TABLE_NAME + " (" +
                    Class._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Class.COLUMN_NAME_CLASS_NAME + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Alignment.TABLE_NAME + " (" +
                    Alignment._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Alignment.COLUMN_NAME_ALIGNMENT_NAME + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Gender.TABLE_NAME + " (" +
                    Gender._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Gender.COLUMN_NAME_GENDER_NAME + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Stat.TABLE_NAME + " (" +
                    Stat._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Stat.COLUMN_NAME_STRENGTH + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_DEXTERITY + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_CONSTITUTION + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_INTELLIGENCE + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_WISDOM + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_CHARISMA + INTEGER + COMMA_SEP +
            " );" +
            "CREATE TABLE " + SecondaryStats.TABLE_NAME + " (" +
                    SecondaryStats._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    SecondaryStats.COLUMN_NAME_ARMOR_CLASS + INTEGER + COMMA_SEP +
                    SecondaryStats.COLUMN_NAME_INITIATIVE + INTEGER + COMMA_SEP +
                    SecondaryStats.COLUMN_NAME_SPEED + INTEGER + COMMA_SEP +
                    SecondaryStats.COLUMN_NAME_MAX_HP + INTEGER + COMMA_SEP +
                    SecondaryStats.COLUMN_NAME_TEMP_HP + INTEGER + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Proficiency.TABLE_NAME + " (" +
                    Proficiency._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Proficiency.COLUMN_NAME_STRENGTH_SAVING_THROW + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_ATHLETICS + INTEGER + COMMA_SEP +

                    Proficiency.COLUMN_NAME_DEXTERITY_SAVING_THROW + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_ACROBATICS + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_SLEIGHT_OF_HAND + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_STEALTH + INTEGER + COMMA_SEP +

                    Proficiency.COLUMN_NAME_CONSTITUTION_SAVING_THROW + INTEGER + COMMA_SEP +

                    Proficiency.COLUMN_NAME_INTELLIGENCE_SAVING_THROW + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_ARCANA + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_HISTORY + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_INVESTIGATION + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_NATURE + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_RELIGION + INTEGER + COMMA_SEP +

                    Proficiency.COLUMN_NAME_WISDOM_SAVING_THROW + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_ANIMAL_HANDLING + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_INSIGHT + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_MEDICINE + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_PERCEPTION + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_SURVIVAL + INTEGER + COMMA_SEP +

                    Proficiency.COLUMN_NAME_CHARISMA_SAVING_THROW + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_DECEPTION + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_INTIMIDATION + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_PERFORMANCE + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_PERSUASION + INTEGER + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Character.TABLE_NAME + " (" +
                    Character._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +

                    Character.COLUMN_NAME_CHARACTER_NAME + TEXT_TYPE + COMMA_SEP +
                    Character.COLUMN_NAME_LEVEL + INTEGER + COMMA_SEP +
                    Character.COLUMN_NAME_EXPERIENCE + INTEGER + COMMA_SEP +
                    Character.COLUMN_NAME_RACE_ID + INTEGER + COMMA_SEP +
                    Character.COLUMN_NAME_CLASS_ID + INTEGER + COMMA_SEP +
                    Character.COLUMN_NAME_ALIGNMENT_ID + INTEGER + COMMA_SEP +
                    Character.COLUMN_NAME_GENDER_ID + INTEGER + COMMA_SEP +
                    Character.COLUMN_NAME_STATS_ID + INTEGER + COMMA_SEP +
                    Character.COLUMN_NAME_SECONDARY_STATS_ID + INTEGER + COMMA_SEP +
                    Character.COLUMN_NAME_PROFICIENCY_ID + INTEGER + COMMA_SEP +

                    FOREIGN_KEY + Character.COLUMN_NAME_RACE_ID + REFERENCES + "Race(_ID)" +
                    FOREIGN_KEY + Character.COLUMN_NAME_CLASS_ID + REFERENCES + "Class(_ID)" +
                    FOREIGN_KEY + Character.COLUMN_NAME_ALIGNMENT_ID + REFERENCES + "Alignment(_ID)" +
                    FOREIGN_KEY + Character.COLUMN_NAME_GENDER_ID + REFERENCES + "Gender(_ID)" +
                    FOREIGN_KEY + Character.COLUMN_NAME_STATS_ID + REFERENCES + "Stats(_ID)" +
                    FOREIGN_KEY + Character.COLUMN_NAME_SECONDARY_STATS_ID + REFERENCES + "SecondaryStats(_ID)" +
                    FOREIGN_KEY + Character.COLUMN_NAME_PROFICIENCY_ID + REFERENCES + "Proficiency(_ID)" +
            " );";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Race.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Class.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Alignment.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Gender.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Stat.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + SecondaryStats.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Proficiency.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Character.TABLE_NAME + ";";

    public static class CharacterSheetDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "CharacterSheet.db";

        public CharacterSheetDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }
    }

    public void setCharacterValues(Models.CharacterModel model, Context context){
        // Gets the data repository in write mode
        CharacterSheetDbHelper mDbHelper = new CharacterSheetDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Character._ID, Statement.RETURN_GENERATED_KEYS);
        values.put(Character.COLUMN_NAME_CHARACTER_NAME, model.getCharacterName());
        values.put(Character.COLUMN_NAME_LEVEL, model.getCharacterLevel());
        values.put(Character.COLUMN_NAME_EXPERIENCE, model.getCharacterExperience());
        values.put(Character.COLUMN_NAME_RACE_ID, model.getRace().getRaceID());
        values.put(Character.COLUMN_NAME_CLASS_ID, model.getCharacterClass().getClassID());
        values.put(Character.COLUMN_NAME_ALIGNMENT_ID, model.getAlignment().getAlignmentID());
        values.put(Character.COLUMN_NAME_GENDER_ID, model.getGender().getGenderID());
        values.put(Character.COLUMN_NAME_STATS_ID, model.getStats().getStatID());
        values.put(Character.COLUMN_NAME_SECONDARY_STATS_ID, model.getSecondaryStats().getSecondaryStatsID());
        values.put(Character.COLUMN_NAME_PROFICIENCY_ID, model.getProficiencies().getProficiencyID());

        // Insert the new row, returning the primary key value of the new row
        //long newRowId;
        //newRowId = db.insert(DatabaseContract.Character.TABLE_NAME, null, values);
    }

    public void setRaceValues(Models.CharacterModel model, Context context){
        // Gets the data repository in write mode
        CharacterSheetDbHelper mDbHelper = new CharacterSheetDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Race._ID, Statement.RETURN_GENERATED_KEYS);
        values.put(Race.COLUMN_NAME_RACE_NAME, model.getRace().getRaceName());

        // Insert the new row, returning the primary key value of the new row
        //long newRowId;
        //newRowId = db.insert(DatabaseContract.Character.TABLE_NAME, null, values);
    }

    public void setClassValues(Models.CharacterModel model, Context context){
        // Gets the data repository in write mode
        CharacterSheetDbHelper mDbHelper = new CharacterSheetDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Class._ID, Statement.RETURN_GENERATED_KEYS);
        values.put(Class.COLUMN_NAME_CLASS_NAME, model.getCharacterClass().getClassName());

        // Insert the new row, returning the primary key value of the new row
        //long newRowId;
        //newRowId = db.insert(DatabaseContract.Character.TABLE_NAME, null, values);
    }

    public void setAlignmentValues(Models.CharacterModel model, Context context){
        // Gets the data repository in write mode
        CharacterSheetDbHelper mDbHelper = new CharacterSheetDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Alignment._ID, Statement.RETURN_GENERATED_KEYS);
        values.put(Alignment.COLUMN_NAME_ALIGNMENT_NAME, model.getAlignment().getAlignmentName());

        // Insert the new row, returning the primary key value of the new row
        //long newRowId;
        //newRowId = db.insert(DatabaseContract.Character.TABLE_NAME, null, values);
    }

    public void setStatValues(Models.CharacterModel model, Context context){
        // Gets the data repository in write mode
        CharacterSheetDbHelper mDbHelper = new CharacterSheetDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Stat._ID, Statement.RETURN_GENERATED_KEYS);
        values.put(Stat.COLUMN_NAME_STRENGTH, model.getStats().getStrength());
        values.put(Stat.COLUMN_NAME_DEXTERITY, model.getStats().getDexterity());
        values.put(Stat.COLUMN_NAME_CONSTITUTION, model.getStats().getConstitution());
        values.put(Stat.COLUMN_NAME_INTELLIGENCE, model.getStats().getIntelligence());
        values.put(Stat.COLUMN_NAME_WISDOM, model.getStats().getWisdom());
        values.put(Stat.COLUMN_NAME_CHARISMA, model.getStats().getCharisma());

        // Insert the new row, returning the primary key value of the new row
        //long newRowId;
        //newRowId = db.insert(DatabaseContract.Character.TABLE_NAME, null, values);
    }

    public void setSecondaryStatValues(Models.CharacterModel model, Context context){
        // Gets the data repository in write mode
        CharacterSheetDbHelper mDbHelper = new CharacterSheetDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SecondaryStats._ID, Statement.RETURN_GENERATED_KEYS);
        values.put(SecondaryStats.COLUMN_NAME_ARMOR_CLASS, model.getSecondaryStats().getArmorClass());
        values.put(SecondaryStats.COLUMN_NAME_INITIATIVE, model.getSecondaryStats().getInitiative());
        values.put(SecondaryStats.COLUMN_NAME_SPEED, model.getSecondaryStats().getSpeed());
        values.put(SecondaryStats.COLUMN_NAME_MAX_HP, model.getSecondaryStats().getMaxHP());
        values.put(SecondaryStats.COLUMN_NAME_TEMP_HP, model.getSecondaryStats().getTempHP());

        // Insert the new row, returning the primary key value of the new row
        //long newRowId;
        //newRowId = db.insert(DatabaseContract.Character.TABLE_NAME, null, values);
    }

    public void setGenderValues(Models.CharacterModel model, Context context){
        // Gets the data repository in write mode
        CharacterSheetDbHelper mDbHelper = new CharacterSheetDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Gender._ID, Statement.RETURN_GENERATED_KEYS);
        values.put(Gender.COLUMN_NAME_GENDER_NAME, model.getGender().getGenderName());

        // Insert the new row, returning the primary key value of the new row
        //long newRowId;
        //newRowId = db.insert(DatabaseContract.Character.TABLE_NAME, null, values);
    }

    public void setProficiencyValues(Models.CharacterModel model, Context context){
        // Gets the data repository in write mode
        CharacterSheetDbHelper mDbHelper = new CharacterSheetDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Proficiency._ID, Statement.RETURN_GENERATED_KEYS);

        //Strength
        values.put(Proficiency.COLUMN_NAME_STRENGTH_SAVING_THROW, model.getProficiencies().getStrengthSavingThrow());
        values.put(Proficiency.COLUMN_NAME_ATHLETICS, model.getProficiencies().getAthletics());

        //Dexterity
        values.put(Proficiency.COLUMN_NAME_DEXTERITY_SAVING_THROW, model.getProficiencies().getDexteritySavingThrow());
        values.put(Proficiency.COLUMN_NAME_ACROBATICS, model.getProficiencies().getAcrobatics());
        values.put(Proficiency.COLUMN_NAME_SLEIGHT_OF_HAND, model.getProficiencies().getSleightOfHand());
        values.put(Proficiency.COLUMN_NAME_STEALTH, model.getProficiencies().getStealth());

        //Constitution
        values.put(Proficiency.COLUMN_NAME_CONSTITUTION_SAVING_THROW, model.getProficiencies().getConstitutionSavingThrow());

        //Intelligence
        values.put(Proficiency.COLUMN_NAME_INTELLIGENCE_SAVING_THROW, model.getProficiencies().getIntelligenceSavingThrow());
        values.put(Proficiency.COLUMN_NAME_ARCANA, model.getProficiencies().getArcana());
        values.put(Proficiency.COLUMN_NAME_HISTORY, model.getProficiencies().getHistory());
        values.put(Proficiency.COLUMN_NAME_INVESTIGATION, model.getProficiencies().getInvestigation());
        values.put(Proficiency.COLUMN_NAME_NATURE, model.getProficiencies().getNature());
        values.put(Proficiency.COLUMN_NAME_RELIGION, model.getProficiencies().getReligion());

        //Wisdom
        values.put(Proficiency.COLUMN_NAME_WISDOM_SAVING_THROW, model.getProficiencies().getWisdomSavingThrow());
        values.put(Proficiency.COLUMN_NAME_ANIMAL_HANDLING, model.getProficiencies().getAnimalHandling());
        values.put(Proficiency.COLUMN_NAME_INSIGHT, model.getProficiencies().getInsight());
        values.put(Proficiency.COLUMN_NAME_MEDICINE, model.getProficiencies().getMedicine());
        values.put(Proficiency.COLUMN_NAME_PERCEPTION, model.getProficiencies().getPerception());
        values.put(Proficiency.COLUMN_NAME_SURVIVAL, model.getProficiencies().getSurvival());

        //Charisma
        values.put(Proficiency.COLUMN_NAME_CHARISMA_SAVING_THROW, model.getProficiencies().getCharismaSavingThrows());
        values.put(Proficiency.COLUMN_NAME_DECEPTION, model.getProficiencies().getDeception());
        values.put(Proficiency.COLUMN_NAME_INTIMIDATION, model.getProficiencies().getIntimidation());
        values.put(Proficiency.COLUMN_NAME_PERFORMANCE, model.getProficiencies().getPerformance());
        values.put(Proficiency.COLUMN_NAME_PERSUASION, model.getProficiencies().getPersuasion());

        // Insert the new row, returning the primary key value of the new row
        //long newRowId;
        //newRowId = db.insert(DatabaseContract.Character.TABLE_NAME, null, values);
    }
}
