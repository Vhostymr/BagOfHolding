package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

import android.provider.BaseColumns;

public final class DatabaseContract {
    // To prevent someone from accidentally instantiating the contract class, give it an empty constructor.
    public DatabaseContract() {}

    /* Inner class that defines the table contents */
    public static abstract class Character implements BaseColumns {
        public static final String TABLE_NAME = "Character";
        public static final String COLUMN_NAME_CHARACTER_NAME = "CharacterName";
        public static final String COLUMN_NAME_CHARACTER_ID = "CharacterID";
        public static final String COLUMN_NAME_RACE_ID = "RaceID";
        public static final String COLUMN_NAME_CLASS_ID = "ClassID";
        public static final String COLUMN_NAME_ALIGNMENT_ID = "AlignmentID";
        public static final String COLUMN_NAME_STATS_ID = "StatsID";
        public static final String COLUMN_NAME_EQUIPMENT_ID = "EquipmentID";
    }

    public static abstract class Race implements BaseColumns {
        public static final String TABLE_NAME = "Race";
        public static final String COLUMN_NAME_RACE_ID = "RaceID";
        public static final String COLUMN_NAME_RACE_NAME = "RaceName";
    }

    public static abstract class Class implements BaseColumns {
        public static final String TABLE_NAME = "Class";
        public static final String COLUMN_NAME_CLASS_ID = "Class_ID";
        public static final String COLUMN_NAME_CLASS_NAME = "ClassName";
    }

    public static abstract class Alignment implements BaseColumns {
        public static final String TABLE_NAME = "Alignment";
        public static final String COLUMN_NAME_ALIGNMENT_ID = "AlignmentID";
        public static final String COLUMN_NAME_ALIGNMENT_NAME = "AlignmentName";
    }

    public static abstract class Gender implements BaseColumns {
        public static final String TABLE_NAME = "Gender";
        public static final String COLUMN_NAME_GENDER_ID = "GenderID";
        public static final String COLUMN_NAME_GENDER_NAME = "GenderName";
    }

    public static abstract class Stat implements BaseColumns {
        public static final String TABLE_NAME = "Stat";
        public static final String COLUMN_NAME_STATS_ID = "StatID";
        public static final String COLUMN_NAME_STATS_NAME = "StatName";
    }

    public static abstract class Proficiency implements BaseColumns {
        public static final String TABLE_NAME = "Proficiency";
        public static final String COLUMN_NAME_PROFICIENCY_ID = "ProficiencyID";
        public static final String COLUMN_NAME_PROFICIENCY_NAME = "ProficiencyName";
    }
}