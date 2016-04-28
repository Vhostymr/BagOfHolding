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
        public static final String COLUMN_NAME_RACE_ID = "RaceID";
        public static final String COLUMN_NAME_CLASS_ID = "ClassID";
        public static final String COLUMN_NAME_ALIGNMENT_ID = "AlignmentID";
        public static final String COLUMN_NAME_STATS_ID = "StatsID";
        public static final String COLUMN_NAME_PROFICIENCY_ID = "ProficiencyID";
        public static final String COLUMN_NAME_EQUIPMENT_ID = "EquipmentID";
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

    public static abstract class Attribute implements BaseColumns {
        public static final String TABLE_NAME = "Attribute";
        public static final String COLUMN_NAME_ARMOR_CLASS = "ArmorClass";
        public static final String COLUMN_NAME_INITIATIVE = "Initiative";
        public static final String COLUMN_NAME_SPEED = "Speed";
        public static final String COLUMN_NAME_MAX_HP = "MaxHP";
        public static final String COLUMN_NAME_TEMP_HP = "TempHP";
    }

    public static abstract class Proficiency implements BaseColumns {
        public static final String TABLE_NAME = "Proficiency";
        public static final String COLUMN_NAME_PROFICIENCY_NAME = "ProficiencyName";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Character.TABLE_NAME + " (" +
                    Character._ID + " INTEGER PRIMARY KEY," +
                    Character.COLUMN_NAME_CHARACTER_NAME + TEXT_TYPE + COMMA_SEP +
                    Character.COLUMN_NAME_RACE_ID + TEXT_TYPE + COMMA_SEP +
                    Character.COLUMN_NAME_CLASS_ID + TEXT_TYPE + COMMA_SEP +
                    Character.COLUMN_NAME_ALIGNMENT_ID + TEXT_TYPE + COMMA_SEP +
                    Character.COLUMN_NAME_STATS_ID + TEXT_TYPE + COMMA_SEP +
                    Character.COLUMN_NAME_PROFICIENCY_ID + TEXT_TYPE + COMMA_SEP +
                    Character.COLUMN_NAME_EQUIPMENT_ID + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Race.TABLE_NAME + " (" +
                    Race._ID + " INTEGER PRIMARY KEY," +
                    Race.COLUMN_NAME_RACE_NAME + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Class.TABLE_NAME + " (" +
                    Class._ID + " INTEGER PRIMARY KEY," +
                    Class.COLUMN_NAME_CLASS_NAME + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Alignment.TABLE_NAME + " (" +
                    Alignment._ID + " INTEGER PRIMARY KEY," +
                    Alignment.COLUMN_NAME_ALIGNMENT_NAME + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Gender.TABLE_NAME + " (" +
                    Gender._ID + " INTEGER PRIMARY KEY," +
                    Gender.COLUMN_NAME_GENDER_NAME + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Stat.TABLE_NAME + " (" +
                    Stat._ID + " INTEGER PRIMARY KEY," +
                    Stat.COLUMN_NAME_STRENGTH + TEXT_TYPE + COMMA_SEP +
                    Stat.COLUMN_NAME_DEXTERITY + TEXT_TYPE + COMMA_SEP +
                    Stat.COLUMN_NAME_CONSTITUTION + TEXT_TYPE + COMMA_SEP +
                    Stat.COLUMN_NAME_INTELLIGENCE + TEXT_TYPE + COMMA_SEP +
                    Stat.COLUMN_NAME_WISDOM + TEXT_TYPE + COMMA_SEP +
                    Stat.COLUMN_NAME_CHARISMA + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Attribute.TABLE_NAME + " (" +
                    Attribute._ID + " INTEGER PRIMARY KEY," +
                    Attribute.COLUMN_NAME_ARMOR_CLASS + TEXT_TYPE + COMMA_SEP +
                    Attribute.COLUMN_NAME_INITIATIVE + TEXT_TYPE + COMMA_SEP +
                    Attribute.COLUMN_NAME_SPEED + TEXT_TYPE + COMMA_SEP +
                    Attribute.COLUMN_NAME_MAX_HP + TEXT_TYPE + COMMA_SEP +
                    Attribute.COLUMN_NAME_TEMP_HP + TEXT_TYPE + COMMA_SEP +
            " );" +
            "CREATE TABLE " + Proficiency.TABLE_NAME + " (" +
                    Proficiency._ID + " INTEGER PRIMARY KEY," +
                    Proficiency.COLUMN_NAME_PROFICIENCY_NAME + TEXT_TYPE + COMMA_SEP +
            " );";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Character.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Race.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Class.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Alignment.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Gender.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Stat.TABLE_NAME + ";" +
            "DROP TABLE IF EXISTS " + Proficiency.TABLE_NAME + ";";

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
        DatabaseContract.CharacterSheetDbHelper mDbHelper = new DatabaseContract.CharacterSheetDbHelper(context);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(DatabaseContract.Character._ID, Statement.RETURN_GENERATED_KEYS);
        values.put(DatabaseContract.Character.COLUMN_NAME_CHARACTER_NAME, model.getCharacterName());
        values.put(DatabaseContract.Character.COLUMN_NAME_RACE_ID, model.getRace().getRaceID());
        values.put(DatabaseContract.Character.COLUMN_NAME_CLASS_ID, model.getCharacterClass().getClassID());
        values.put(DatabaseContract.Character.COLUMN_NAME_ALIGNMENT_ID, model.getAlignment().getAlignmentID());
        values.put(DatabaseContract.Character.COLUMN_NAME_STATS_ID, model.getStats().getStatID());
        values.put(DatabaseContract.Character.COLUMN_NAME_PROFICIENCY_ID, model.getProficiencies().getProficiencyID());
        values.put(DatabaseContract.Character.COLUMN_NAME_EQUIPMENT_ID, model.getEquipment().getEquipmentID());

        // Insert the new row, returning the primary key value of the new row
        //long newRowId;
        //newRowId = db.insert(DatabaseContract.Character.TABLE_NAME, null, values);
    }
}
