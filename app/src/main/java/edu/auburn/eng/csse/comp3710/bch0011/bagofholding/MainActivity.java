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

import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.Models.Models;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    Button saveButton;
    Button editButton;
    Button dbButton;
    CharacterDetailsFragment characterFragment1;
    CharacterEditFragment characterFragment;
    CharacterModel characterModel;
    String currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_info);
        //final View view = inflater.inflate(R.layout.fragment_character_edit, container, false);

        fm = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();
        SQLiteDatabase db = getOpenDB(context);

        //generateCharacterModel();

        saveButton = (Button) findViewById(R.id.saveButton);
        editButton = (Button) findViewById(R.id.editButton);
        dbButton = (Button) findViewById(R.id.dbButton);

        dbButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
                startActivity(dbmanager);
            }
        });


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

                Context context = v.getContext();
                //context.deleteDatabase(CharacterSheetDbHelper.DATABASE_NAME); //For Testing
                SQLiteDatabase db = getOpenDB(context);

                boolean exists = existsInDB(CharacterClass.TABLE_NAME, "Wizard", db);
                ClassModel classModel = setClassModel("Wizard");
                long primaryKey;

                if (exists) {
                    primaryKey = getPrimaryKey(CharacterClass.TABLE_NAME, "Wizard", db);
                }
                else {
                    primaryKey = create(CharacterClass.TABLE_NAME, setClassValues(classModel), db);
                }

                classModel.setClassID(primaryKey);

                exists = existsInDB(Race.TABLE_NAME, "Drow", db);
                RaceModel raceModel = setRaceModel("Drow");

                if (exists) {
                    primaryKey = getPrimaryKey(Race.TABLE_NAME, "Drow", db);
                }
                else {
                    primaryKey = create(Race.TABLE_NAME, setRaceValues(raceModel), db);
                }

                raceModel.setRaceID(primaryKey);

                exists = existsInDB(Gender.TABLE_NAME, "Male", db);
                GenderModel genderModel = setGenderModel("Male");

                if (exists) {
                    primaryKey = getPrimaryKey(Gender.TABLE_NAME, "Male", db);
                }
                else {
                    primaryKey = create(Gender.TABLE_NAME, setGenderValues(genderModel), db);
                }

                genderModel.setGenderID(primaryKey);

                exists = existsInDB(Alignment.TABLE_NAME, "Lawful Evil", db);
                AlignmentModel alignmentModel = setAlignmentModel("Lawful Evil");

                if (exists) {
                    primaryKey = getPrimaryKey(Alignment.TABLE_NAME, "Alignment", db);
                }
                else {
                    primaryKey = create(Alignment.TABLE_NAME, setAlignmentValues(alignmentModel), db);
                }

                alignmentModel.setAlignmentID(primaryKey);

                StatsModel statsModel = characterFragment.getStatsModel();
                primaryKey = create(Stat.TABLE_NAME, setStatValues(statsModel), db);
                statsModel.setStatID(primaryKey);

                SecondaryStatsModel secondaryStatsModel = setSecondaryStatsModel("18", "15", "13", "11", "10");
                primaryKey = create(SecondaryStats.TABLE_NAME, setSecondaryStatValues(secondaryStatsModel), db);
                secondaryStatsModel.setSecondaryStatsID(primaryKey);

                ProficiencyModel proficiencyModel = setProficiencyModel(true, false, true, true, false, true, true, false,
                        true, true, false, true, true, false, false, false,
                        true, false, true, true, false, true, true, true);
                primaryKey = create(Proficiency.TABLE_NAME, setProficiencyValues(proficiencyModel), db);
                proficiencyModel.setProficiencyID(primaryKey);

                characterModel = setCharacterModel("Gromph Baenre", "50", "45000", classModel,
                        raceModel, alignmentModel, genderModel,
                        statsModel, secondaryStatsModel, proficiencyModel);


                create(PlayerCharacter.TABLE_NAME, setCharacterValues(characterModel), db);

                db.close();

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





//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });



    }

    public CharacterModel getCharacterModel()
    {
        return characterModel;
    }

    public void generateCharacterModel()
    {

        Context context = getApplicationContext();
        //context.deleteDatabase(CharacterSheetDbHelper.DATABASE_NAME); //For Testing
        SQLiteDatabase db = getOpenDB(context);

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

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);
//    }
}
