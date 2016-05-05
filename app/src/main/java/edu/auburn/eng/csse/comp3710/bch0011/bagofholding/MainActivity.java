package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;
import static edu.auburn.eng.csse.comp3710.bch0011.bagofholding.DatabaseContract.DatabaseContract.*;
import static edu.auburn.eng.csse.comp3710.bch0011.bagofholding.Models.Models.*;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.List;

import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.DatabaseContract.DatabaseContract;
import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.Models.Models;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    Button saveButton;
    Button editButton;
//    Button dbButton;
    CharacterDetailsFragment characterFragment1;
    CharacterEditFragment characterFragment;
    CharacterModel characterModel;
    String currentFragment;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_info);
        //final View view = inflater.inflate(R.layout.fragment_character_edit, container, false);

        fm = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();
        context.deleteDatabase(CharacterSheetDbHelper.DATABASE_NAME);
        db = getOpenDB(context);

        generateCharacterModel();

        if (characterModel.getCharacterID() == 0) {
            characterModel = null;
        }

        saveButton = (Button) findViewById(R.id.saveButton);
        editButton = (Button) findViewById(R.id.editButton);
//        dbButton = (Button) findViewById(R.id.dbButton);

//        dbButton.setOnClickListener(new Button.OnClickListener() {
//            public void onClick(View v) {
//
//                Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
//                startActivity(dbmanager);
//            }
//        });


        Fragment fragment = fm.findFragmentById(R.id.character_fragment_container);

        if (fragment instanceof CharacterDetailsFragment)
        {
            saveButton.setVisibility(View.GONE);
            editButton.setVisibility(View.VISIBLE);
        }

        if (findViewById(R.id.character_fragment_container) != null && savedInstanceState == null && fragment == null) {
            // Create a new Fragment to be placed in the activity layout
            characterFragment = new CharacterEditFragment();

            // In case this activity was started with special instructions from an
            // intent, pass the Intent's extras to the fragment as arguments
            characterFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            fm.beginTransaction()
                    .add(R.id.character_fragment_container, characterFragment).commit();
        }

        saveButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                if (characterModel == null) {
                    createCharacter();
                }

                else {
                    updateCharacter(characterModel.getCharacterID());
                }

                displayDetailsFragment();
                saveButton.setVisibility(View.GONE);
                editButton.setVisibility(View.VISIBLE);
            }
        });

        editButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                displayEditFragment();
                editButton.setVisibility(View.GONE);
                saveButton.setVisibility(View.VISIBLE);
            }

        });
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        db.close();
    }


    public void createCharacter() {
        long primaryKey;

        characterModel = characterFragment.populateModelFromView();

        boolean exists = existsInDB(CharacterClass.TABLE_NAME, characterModel.getCharacterClass().getClassName(), db);
        ClassModel classModel = setClassModel(characterModel.getCharacterClass().getClassName());

        if (exists) {
            primaryKey = getPrimaryKey(CharacterClass.TABLE_NAME, characterModel.getCharacterClass().getClassName(), db);
        }
        else {
            primaryKey = create(CharacterClass.TABLE_NAME, setClassValues(classModel), db);
        }

        classModel.setClassID(primaryKey);

        exists = existsInDB(Race.TABLE_NAME, characterModel.getRace().getRaceName(), db);
        RaceModel raceModel = setRaceModel(characterModel.getRace().getRaceName());

        if (exists) {
            primaryKey = getPrimaryKey(Race.TABLE_NAME, characterModel.getRace().getRaceName(), db);
        }
        else {
            primaryKey = create(Race.TABLE_NAME, setRaceValues(raceModel), db);
        }

        raceModel.setRaceID(primaryKey);

        exists = existsInDB(Gender.TABLE_NAME, characterModel.getGender().getGenderName(), db);
        GenderModel genderModel = setGenderModel(characterModel.getGender().getGenderName());

        if (exists) {
            primaryKey = getPrimaryKey(Gender.TABLE_NAME, characterModel.getGender().getGenderName(), db);
        }
        else {
            primaryKey = create(Gender.TABLE_NAME, setGenderValues(genderModel), db);
        }

        genderModel.setGenderID(primaryKey);

        exists = existsInDB(Alignment.TABLE_NAME, characterModel.getAlignment().getAlignmentName(), db);
        AlignmentModel alignmentModel = setAlignmentModel(characterModel.getAlignment().getAlignmentName());

        if (exists) {
            primaryKey = getPrimaryKey(Alignment.TABLE_NAME, characterModel.getAlignment().getAlignmentName(), db);
        }
        else {
            primaryKey = create(Alignment.TABLE_NAME, setAlignmentValues(alignmentModel), db);
        }

        alignmentModel.setAlignmentID(primaryKey);

        StatsModel statsModel = characterModel.getStats();
        primaryKey = create(Stat.TABLE_NAME, setStatValues(statsModel), db);
        statsModel.setStatID(primaryKey);

        SecondaryStatsModel secondaryStatsModel = characterModel.getSecondaryStats();
        primaryKey = create(SecondaryStats.TABLE_NAME, setSecondaryStatValues(secondaryStatsModel), db);
        secondaryStatsModel.setSecondaryStatsID(primaryKey);

        ProficiencyModel proficiencyModel = characterModel.getProficiencies();
        primaryKey = create(Proficiency.TABLE_NAME, setProficiencyValues(proficiencyModel), db);
        proficiencyModel.setProficiencyID(primaryKey);

        characterModel = setCharacterModel(0, characterModel.getCharacterName(),
                String.valueOf(characterModel.getCharacterLevel()),
                String.valueOf(characterModel.getCharacterExperience()), classModel,
                raceModel, alignmentModel, genderModel,
                statsModel, secondaryStatsModel, proficiencyModel);
        primaryKey = create(PlayerCharacter.TABLE_NAME, setCharacterValues(characterModel), db);
        characterModel.setCharacterID(primaryKey);
    }

    public void updateCharacter(long primaryKey) {
        characterModel = characterFragment.populateModelFromView();

        boolean exists = existsInDB(CharacterClass.TABLE_NAME, characterModel.getCharacterClass().getClassName(), db);
        ClassModel classModel = setClassModel(characterModel.getCharacterClass().getClassName());

        if (exists) {
            primaryKey = getPrimaryKey(CharacterClass.TABLE_NAME, characterModel.getCharacterClass().getClassName(), db);
        }
        else {
            primaryKey = create(CharacterClass.TABLE_NAME, setClassValues(classModel), db);
        }

        classModel.setClassID(primaryKey);

        exists = existsInDB(Race.TABLE_NAME, characterModel.getRace().getRaceName(), db);
        RaceModel raceModel = setRaceModel(characterModel.getRace().getRaceName());

        if (exists) {
            primaryKey = getPrimaryKey(Race.TABLE_NAME, characterModel.getRace().getRaceName(), db);
        }
        else {
            primaryKey = create(Race.TABLE_NAME, setRaceValues(raceModel), db);
        }

        raceModel.setRaceID(primaryKey);

        exists = existsInDB(Gender.TABLE_NAME, characterModel.getGender().getGenderName(), db);
        GenderModel genderModel = setGenderModel(characterModel.getGender().getGenderName());

        if (exists) {
            primaryKey = getPrimaryKey(Gender.TABLE_NAME, characterModel.getGender().getGenderName(), db);
        }
        else {
            primaryKey = create(Gender.TABLE_NAME, setGenderValues(genderModel), db);
        }

        genderModel.setGenderID(primaryKey);

        exists = existsInDB(Alignment.TABLE_NAME, characterModel.getAlignment().getAlignmentName(), db);
        AlignmentModel alignmentModel = setAlignmentModel(characterModel.getAlignment().getAlignmentName());

        if (exists) {
            primaryKey = getPrimaryKey(Alignment.TABLE_NAME, characterModel.getAlignment().getAlignmentName(), db);
        }
        else {
            primaryKey = create(Alignment.TABLE_NAME, setAlignmentValues(alignmentModel), db);
        }

        alignmentModel.setAlignmentID(primaryKey);

        update(Stat.TABLE_NAME, characterModel.getStats().getStatID(), setStatValues(characterModel.getStats()), db);
        update(SecondaryStats.TABLE_NAME, characterModel.getSecondaryStats().getSecondaryStatsID(), setSecondaryStatValues(characterModel.getSecondaryStats()), db);
        update(Proficiency.TABLE_NAME, characterModel.getProficiencies().getProficiencyID(), setProficiencyValues(characterModel.getProficiencies()), db);

        characterModel = setCharacterModel(characterModel.getCharacterID(), characterModel.getCharacterName(),
                String.valueOf(characterModel.getCharacterLevel()),
                String.valueOf(characterModel.getCharacterExperience()), classModel,
                raceModel, alignmentModel, genderModel,
                characterModel.getStats(), characterModel.getSecondaryStats(), characterModel.getProficiencies());

        update(PlayerCharacter.TABLE_NAME, characterModel.getCharacterID(), setCharacterValues(characterModel), db);
    }

    public CharacterModel getCharacterModel()
    {
        return characterModel;
    }

    public List<String> getAlignmentDatabaseItems() {
        return Models.getNameListFromDB(DatabaseContract.Alignment.TABLE_NAME, new AlignmentModel(), db);
    }
    public List<String> getClassDatabaseItems() {
        return Models.getNameListFromDB(DatabaseContract.CharacterClass.TABLE_NAME, new ClassModel(), db);
    }
    public List<String> getRaceDatabaseItems() {
        return Models.getNameListFromDB(DatabaseContract.Race.TABLE_NAME, new RaceModel(), db);
    }
    public List<String> getGenderDatabaseItems() {
        return Models.getNameListFromDB(DatabaseContract.Gender.TABLE_NAME, new GenderModel(), db);
    }


    public void generateCharacterModel()
    {
        RaceModel raceModel = new RaceModel();
        ClassModel classModel = new ClassModel();
        AlignmentModel alignmentModel = new AlignmentModel();
        GenderModel genderModel = new GenderModel();
        StatsModel statsModel = new StatsModel();
        SecondaryStatsModel secondaryStatsModel = new SecondaryStatsModel();
        ProficiencyModel proficiencyModel = new ProficiencyModel();
        CharacterDBModel characterDBModel = new CharacterDBModel();

        getModelFromDB(PlayerCharacter.TABLE_NAME, characterDBModel, 1, db);
        getModelFromDB(Race.TABLE_NAME, raceModel, characterDBModel.getRaceID(), db);
        getModelFromDB(CharacterClass.TABLE_NAME, classModel, characterDBModel.getClassID(), db);
        getModelFromDB(Alignment.TABLE_NAME, alignmentModel, characterDBModel.getAlignmentID(), db);
        getModelFromDB(Gender.TABLE_NAME, genderModel, characterDBModel.getGenderID(), db);
        getModelFromDB(Stat.TABLE_NAME, statsModel, characterDBModel.getStatID(), db);
        getModelFromDB(SecondaryStats.TABLE_NAME, secondaryStatsModel, characterDBModel.getSecondaryStatsID(), db);
        getModelFromDB(Proficiency.TABLE_NAME, proficiencyModel, characterDBModel.getProficiencyID(), db);

        characterModel = new CharacterModel();
        characterModel.setCharacterID(characterDBModel.getCharacterID());
        characterModel.setCharacterName(characterDBModel.getCharacterName());
        characterModel.setCharacterLevel(characterDBModel.getCharacterLevel());
        characterModel.setCharacterExperience(characterDBModel.getCharacterExperience());
        characterModel.setRace(raceModel);
        characterModel.setCharacterClass(classModel);
        characterModel.setAlignment(alignmentModel);
        characterModel.setGender(genderModel);
        characterModel.setStats(statsModel);
        characterModel.setSecondaryStats(secondaryStatsModel);
        characterModel.setProficiencies(proficiencyModel);
    }

    public boolean displayDetailsFragment() {
        Fragment fragment = fm.findFragmentById(R.id.character_fragment_container);
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        CharacterDetailsFragment characterDetailsFragment = new CharacterDetailsFragment();

        if (findViewById(R.id.character_fragment_container) != null && fragment == null) {
            // In case this activity was started with special instructions from an
            // intent, pass the Intent's extras to the fragment as arguments
            characterDetailsFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            transaction.add(R.id.character_fragment_container, characterDetailsFragment).commit();
        }
        else if (fragment != null) {
            Bundle args = new Bundle();
            transaction.replace(R.id.character_fragment_container, characterDetailsFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        return true;
    }

    public boolean displayEditFragment() {
        Fragment fragment = fm.findFragmentById(R.id.character_fragment_container);
        FragmentTransaction transaction= getSupportFragmentManager().beginTransaction();
        CharacterEditFragment characterEditFragment = new CharacterEditFragment();

        if (findViewById(R.id.character_fragment_container) != null && fragment == null) {
            // In case this activity was started with special instructions from an
            // intent, pass the Intent's extras to the fragment as arguments
            characterEditFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            transaction.add(R.id.character_fragment_container, characterEditFragment).commit();
        }
        else if (fragment != null) {
            transaction.replace(R.id.character_fragment_container, characterEditFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }
        return true;
    }
}
