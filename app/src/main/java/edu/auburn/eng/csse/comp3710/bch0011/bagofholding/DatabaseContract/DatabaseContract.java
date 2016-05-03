package edu.auburn.eng.csse.comp3710.bch0011.bagofholding.DatabaseContract;
import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.Models.Models.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public final class DatabaseContract {
    // To prevent someone from accidentally instantiating the contract class, give it an empty constructor.
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class PlayerCharacter implements BaseColumns {
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
        public static final String COLUMN_NAME_RACE_NAME = "Name";
    }

    public static abstract class CharacterClass implements BaseColumns {
        public static final String TABLE_NAME = "Class";
        public static final String COLUMN_NAME_CLASS_NAME = "Name";
    }

    public static abstract class Alignment implements BaseColumns {
        public static final String TABLE_NAME = "Alignment";
        public static final String COLUMN_NAME_ALIGNMENT_NAME = "Name";
    }

    public static abstract class Gender implements BaseColumns {
        public static final String TABLE_NAME = "Gender";
        public static final String COLUMN_NAME_GENDER_NAME = "Name";
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
    private static final String PRIMARY_KEY = " PRIMARY KEY AUTOINCREMENT NOT NULL";
    private static final String FOREIGN_KEY = "FOREIGN KEY(";
    private static final String REFERENCES = ") REFERENCES ";
    private static final String COMMA_SEP = ", ";
    private static final String UNIQUE = " UNIQUE";

    private static final String SQL_CREATE_RACE_TABLE =
            "CREATE TABLE " + Race.TABLE_NAME + " (" +
                    Race._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Race.COLUMN_NAME_RACE_NAME + TEXT_TYPE + UNIQUE +
            " )";

    private static final String SQL_CREATE_CHARACTER_CLASS_TABLE =
            "CREATE TABLE " + CharacterClass.TABLE_NAME + " (" +
                    CharacterClass._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    CharacterClass.COLUMN_NAME_CLASS_NAME + TEXT_TYPE + UNIQUE +
            " )";

    private static final String SQL_CREATE_ALIGNMENT_TABLE =
            "CREATE TABLE " + Alignment.TABLE_NAME + " (" +
                    Alignment._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Alignment.COLUMN_NAME_ALIGNMENT_NAME + TEXT_TYPE + UNIQUE +
            " )";

    private static final String SQL_CREATE_GENDER_TABLE =
            "CREATE TABLE " + Gender.TABLE_NAME + " (" +
                    Gender._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Gender.COLUMN_NAME_GENDER_NAME + TEXT_TYPE + UNIQUE +
            " )";

    private static final String SQL_CREATE_STAT_TABLE =
            "CREATE TABLE " + Stat.TABLE_NAME + " (" +
                    Stat._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Stat.COLUMN_NAME_STRENGTH + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_DEXTERITY + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_CONSTITUTION + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_INTELLIGENCE + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_WISDOM + INTEGER + COMMA_SEP +
                    Stat.COLUMN_NAME_CHARISMA + INTEGER +
            " )";

    private static final String SQL_CREATE_SECONDARY_STAT_TABLE =
            "CREATE TABLE " + SecondaryStats.TABLE_NAME + " (" +
                    SecondaryStats._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    SecondaryStats.COLUMN_NAME_ARMOR_CLASS + INTEGER + COMMA_SEP +
                    SecondaryStats.COLUMN_NAME_INITIATIVE + INTEGER + COMMA_SEP +
                    SecondaryStats.COLUMN_NAME_SPEED + INTEGER +COMMA_SEP+
                    SecondaryStats.COLUMN_NAME_MAX_HP + INTEGER + COMMA_SEP +
                    SecondaryStats.COLUMN_NAME_TEMP_HP + INTEGER +
            " )";

    private static final String SQL_CREATE_PROFICIENCY_TABLE =
            "CREATE TABLE " + Proficiency.TABLE_NAME + " (" +
                    Proficiency._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +
                    Proficiency.COLUMN_NAME_STRENGTH_SAVING_THROW + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_ATHLETICS + INTEGER + COMMA_SEP +

                    Proficiency.COLUMN_NAME_DEXTERITY_SAVING_THROW + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_ACROBATICS + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_SLEIGHT_OF_HAND + INTEGER + COMMA_SEP +
                    Proficiency.COLUMN_NAME_STEALTH +INTEGER + COMMA_SEP +

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
                    Proficiency.COLUMN_NAME_PERSUASION + INTEGER +
            " )";

    private static final String SQL_CREATE_PLAYER_CHARACTER_TABLE =
            "CREATE TABLE " + PlayerCharacter.TABLE_NAME + " (" +
                    PlayerCharacter._ID + INTEGER + PRIMARY_KEY + COMMA_SEP +

                    PlayerCharacter.COLUMN_NAME_CHARACTER_NAME + TEXT_TYPE + COMMA_SEP +
                    PlayerCharacter.COLUMN_NAME_LEVEL + INTEGER + COMMA_SEP +
                    PlayerCharacter.COLUMN_NAME_EXPERIENCE + INTEGER + COMMA_SEP +
                    PlayerCharacter.COLUMN_NAME_RACE_ID + INTEGER + COMMA_SEP +
                    PlayerCharacter.COLUMN_NAME_CLASS_ID + INTEGER + COMMA_SEP +
                    PlayerCharacter.COLUMN_NAME_ALIGNMENT_ID + INTEGER + COMMA_SEP +
                    PlayerCharacter.COLUMN_NAME_GENDER_ID + INTEGER + COMMA_SEP +
                    PlayerCharacter.COLUMN_NAME_STATS_ID + INTEGER + COMMA_SEP +
                    PlayerCharacter.COLUMN_NAME_SECONDARY_STATS_ID + INTEGER + COMMA_SEP +
                    PlayerCharacter.COLUMN_NAME_PROFICIENCY_ID + INTEGER + COMMA_SEP +

                    FOREIGN_KEY + PlayerCharacter.COLUMN_NAME_RACE_ID + REFERENCES + "Race(_ID)" + COMMA_SEP +
                    FOREIGN_KEY + PlayerCharacter.COLUMN_NAME_CLASS_ID + REFERENCES + "Class(_ID)" + COMMA_SEP +
                    FOREIGN_KEY + PlayerCharacter.COLUMN_NAME_ALIGNMENT_ID + REFERENCES + "Alignment(_ID)" + COMMA_SEP +
                    FOREIGN_KEY + PlayerCharacter.COLUMN_NAME_GENDER_ID + REFERENCES + "Gender(_ID)" + COMMA_SEP +
                    FOREIGN_KEY + PlayerCharacter.COLUMN_NAME_STATS_ID + REFERENCES + "Stats(_ID)" + COMMA_SEP +
                    FOREIGN_KEY + PlayerCharacter.COLUMN_NAME_SECONDARY_STATS_ID + REFERENCES + "SecondaryStats(_ID)" + COMMA_SEP +
                    FOREIGN_KEY + PlayerCharacter.COLUMN_NAME_PROFICIENCY_ID + REFERENCES + "Proficiency(_ID)" +
            " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Race.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + CharacterClass.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Alignment.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Gender.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Stat.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + SecondaryStats.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Proficiency.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + PlayerCharacter.TABLE_NAME + ";";

    public static class CharacterSheetDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "CharacterSheet.db";

        public CharacterSheetDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_DELETE_ENTRIES); //For testing.
            db.execSQL(SQL_CREATE_RACE_TABLE);
            db.execSQL(SQL_CREATE_CHARACTER_CLASS_TABLE);
            db.execSQL(SQL_CREATE_ALIGNMENT_TABLE);
            db.execSQL(SQL_CREATE_GENDER_TABLE);
            db.execSQL(SQL_CREATE_STAT_TABLE);
            db.execSQL(SQL_CREATE_SECONDARY_STAT_TABLE);
            db.execSQL(SQL_CREATE_PROFICIENCY_TABLE);
            db.execSQL(SQL_CREATE_PLAYER_CHARACTER_TABLE);
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

        //This method is for testing only. This is not a part of the project, and was obtained online.
        //Its purpose is to help facilitate looking at the database and seeing the values entered.
        public ArrayList<Cursor> getData(String Query){
            //get writable database
            SQLiteDatabase sqlDB = this.getWritableDatabase();
            String[] columns = new String[] { "message" };
            //an array list of cursor to save two cursors one has results from the query
            //other cursor stores error message if any errors are triggered
            ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
            MatrixCursor Cursor2= new MatrixCursor(columns);
            alc.add(null);
            alc.add(null);

            try{
                String maxQuery = Query ;
                //execute the query results will be save in Cursor c
                Cursor c = sqlDB.rawQuery(maxQuery, null);

                //add value to cursor2
                Cursor2.addRow(new Object[] { "Success" });

                alc.set(1,Cursor2);
                if (null != c && c.getCount() > 0) {


                    alc.set(0,c);
                    c.moveToFirst();

                    return alc ;
                }
                return alc;
            } catch(SQLException sqlEx){
                Log.d("printing exception", sqlEx.getMessage());
                //if any exceptions are triggered save the error message to cursor an return the arraylist
                Cursor2.addRow(new Object[] { "" + sqlEx.getMessage() });
                alc.set(1,Cursor2);
                return alc;
            } catch(Exception ex){

                Log.d("printing exception", ex.getMessage());

                //if any exceptions are triggered save the error message to cursor an return the arraylist
                Cursor2.addRow(new Object[] { "" + ex.getMessage() });
                alc.set(1,Cursor2);
                return alc;
            }
        }
    }

    public static ContentValues setCharacterValues(CharacterModel model) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(PlayerCharacter.COLUMN_NAME_CHARACTER_NAME, model.getCharacterName());
        values.put(PlayerCharacter.COLUMN_NAME_LEVEL, model.getCharacterLevel());
        values.put(PlayerCharacter.COLUMN_NAME_EXPERIENCE, model.getCharacterExperience());
        values.put(PlayerCharacter.COLUMN_NAME_RACE_ID, model.getRace().getRaceID());
        values.put(PlayerCharacter.COLUMN_NAME_CLASS_ID, model.getCharacterClass().getClassID());
        values.put(PlayerCharacter.COLUMN_NAME_ALIGNMENT_ID, model.getAlignment().getAlignmentID());
        values.put(PlayerCharacter.COLUMN_NAME_GENDER_ID, model.getGender().getGenderID());
        values.put(PlayerCharacter.COLUMN_NAME_STATS_ID, model.getStats().getStatID());
        values.put(PlayerCharacter.COLUMN_NAME_SECONDARY_STATS_ID, model.getSecondaryStats().getSecondaryStatsID());
        values.put(PlayerCharacter.COLUMN_NAME_PROFICIENCY_ID, model.getProficiencies().getProficiencyID());

        return values;
    }

    public static ContentValues setRaceValues(RaceModel model) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(Race.COLUMN_NAME_RACE_NAME, model.getRaceName());

        return values;
    }

    public static ContentValues setClassValues(ClassModel model) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(CharacterClass.COLUMN_NAME_CLASS_NAME, model.getClassName());

        return values;
    }

    public static ContentValues setAlignmentValues(AlignmentModel model) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(Alignment.COLUMN_NAME_ALIGNMENT_NAME, model.getAlignmentName());

        return values;
    }

    public static ContentValues setStatValues(StatsModel model) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        values.put(Stat.COLUMN_NAME_STRENGTH, model.getStrength());
        values.put(Stat.COLUMN_NAME_DEXTERITY, model.getDexterity());
        values.put(Stat.COLUMN_NAME_CONSTITUTION, model.getConstitution());
        values.put(Stat.COLUMN_NAME_INTELLIGENCE, model.getIntelligence());
        values.put(Stat.COLUMN_NAME_WISDOM, model.getWisdom());
        values.put(Stat.COLUMN_NAME_CHARISMA, model.getCharisma());

        return values;
    }

    public static ContentValues setSecondaryStatValues(SecondaryStatsModel model) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(SecondaryStats.COLUMN_NAME_ARMOR_CLASS, model.getArmorClass());
        values.put(SecondaryStats.COLUMN_NAME_INITIATIVE, model.getInitiative());
        values.put(SecondaryStats.COLUMN_NAME_SPEED, model.getSpeed());
        values.put(SecondaryStats.COLUMN_NAME_MAX_HP, model.getMaxHP());
        values.put(SecondaryStats.COLUMN_NAME_TEMP_HP, model.getTempHP());

        return values;
    }

    public static ContentValues setGenderValues(GenderModel model) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(Gender.COLUMN_NAME_GENDER_NAME, model.getGenderName());

        return values;
    }

    public static ContentValues setProficiencyValues(ProficiencyModel model) {
        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();

        //Strength
        values.put(Proficiency.COLUMN_NAME_STRENGTH_SAVING_THROW, model.getStrengthSavingThrow());
        values.put(Proficiency.COLUMN_NAME_ATHLETICS, model.getAthletics());

        //Dexterity
        values.put(Proficiency.COLUMN_NAME_DEXTERITY_SAVING_THROW, model.getDexteritySavingThrow());
        values.put(Proficiency.COLUMN_NAME_ACROBATICS, model.getAcrobatics());
        values.put(Proficiency.COLUMN_NAME_SLEIGHT_OF_HAND, model.getSleightOfHand());
        values.put(Proficiency.COLUMN_NAME_STEALTH, model.getStealth());

        //Constitution
        values.put(Proficiency.COLUMN_NAME_CONSTITUTION_SAVING_THROW, model.getConstitutionSavingThrow());

        //Intelligence
        values.put(Proficiency.COLUMN_NAME_INTELLIGENCE_SAVING_THROW, model.getIntelligenceSavingThrow());
        values.put(Proficiency.COLUMN_NAME_ARCANA, model.getArcana());
        values.put(Proficiency.COLUMN_NAME_HISTORY, model.getHistory());
        values.put(Proficiency.COLUMN_NAME_INVESTIGATION, model.getInvestigation());
        values.put(Proficiency.COLUMN_NAME_NATURE, model.getNature());
        values.put(Proficiency.COLUMN_NAME_RELIGION, model.getReligion());

        //Wisdom
        values.put(Proficiency.COLUMN_NAME_WISDOM_SAVING_THROW, model.getWisdomSavingThrow());
        values.put(Proficiency.COLUMN_NAME_ANIMAL_HANDLING, model.getAnimalHandling());
        values.put(Proficiency.COLUMN_NAME_INSIGHT, model.getInsight());
        values.put(Proficiency.COLUMN_NAME_MEDICINE, model.getMedicine());
        values.put(Proficiency.COLUMN_NAME_PERCEPTION, model.getPerception());
        values.put(Proficiency.COLUMN_NAME_SURVIVAL, model.getSurvival());

        //Charisma
        values.put(Proficiency.COLUMN_NAME_CHARISMA_SAVING_THROW, model.getCharismaSavingThrows());
        values.put(Proficiency.COLUMN_NAME_DECEPTION, model.getDeception());
        values.put(Proficiency.COLUMN_NAME_INTIMIDATION, model.getIntimidation());
        values.put(Proficiency.COLUMN_NAME_PERFORMANCE, model.getPerformance());
        values.put(Proficiency.COLUMN_NAME_PERSUASION, model.getPersuasion());

        return values;
    }

    public static long create(String tableName, ContentValues values, SQLiteDatabase db) {
        return db.insert(tableName, null, values);
    }

    public static Cursor read(String tableName, int primaryKey, Object object, SQLiteDatabase db) {
        String[] projection = getProperties(object);

        String selection = "_ID LIKE ?";
        String[] selectionArgs = { String.valueOf(primaryKey) };

        return db.query(
                tableName,                                // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                ""                                        // The sort order
        );
    }

    public static int update(String tableName, int primaryKey, ContentValues values, SQLiteDatabase db) {
        String selection = "_ID LIKE ?";
        String[] selectionArgs = { String.valueOf(primaryKey) };

        return db.update(tableName, values, selection, selectionArgs);
    }

    public static void delete(String tableName, int primaryKey, SQLiteDatabase db) {
        String selection = "_ID LIKE ?";
        String[] selectionArgs = { String.valueOf(primaryKey) };

        db.delete(tableName, selection, selectionArgs);
    }

    public static SQLiteDatabase getOpenDB(Context context){
        CharacterSheetDbHelper mDbHelper = new CharacterSheetDbHelper(context);
        return mDbHelper.getWritableDatabase();
    }

    private static String[] getProperties(Object object) {
        List<String> list = new ArrayList<>();
        for (Field field : object.getClass().getDeclaredFields()) {
            list.add(field.getName());
        }

        return list.toArray(new String[list.size()]);
    }

    public static boolean existsInDB(String tableName, String value, SQLiteDatabase db) {
        Cursor c = null;
        try {
            String query = "SELECT 1 FROM " + tableName + " WHERE Name = ?";

            c = db.rawQuery(query, new String[] { value });

            if (c.moveToFirst()) {
                return true;
            }

            return false;
        }
        finally {
            if (c != null) {
                c.close();
            }
        }
    }

    public static long getPrimaryKey(String tableName, String value, SQLiteDatabase db) {
        Cursor c = null;
        try {
            String query = "SELECT _id FROM " + tableName + " WHERE Name = ?";
            c = db.rawQuery(query, new String[] { value });
            if (c.moveToFirst()) {
                return c.getLong(0);
            }
            return 0;
        }
        finally {
            if (c != null) {
                c.close();
            }
        }
    }
}
