package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    Button saveButton;
    Button dbButton;
    CharacterStatsEditFragment characterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_info);
        //final View view = inflater.inflate(R.layout.fragment_character_edit, container, false);

        fm = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        saveButton = (Button) findViewById(R.id.saveButton);
        dbButton = (Button) findViewById(R.id.dbButton);

        dbButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                Intent dbmanager = new Intent(getApplicationContext(), AndroidDatabaseManager.class);
                startActivity(dbmanager);
            }
        });

        if (findViewById(R.id.character_fragment_container) != null) {
            // Create a new Fragment to be placed in the activity layout
            characterFragment = new CharacterStatsEditFragment();

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
                //context.deleteDatabase(DatabaseContract.CharacterSheetDbHelper.DATABASE_NAME); //For Testing
                SQLiteDatabase db = DatabaseContract.getOpenDB(context);

                boolean exists = DatabaseContract.existsInDB(DatabaseContract.CharacterClass.TABLE_NAME, "Paladin", db);
                Models.ClassModel classModel = Models.setClassModel("Paladin");
                long primaryKey;

                if (exists) {
                    primaryKey = DatabaseContract.getPrimaryKey(DatabaseContract.CharacterClass.TABLE_NAME, "Paladin", db);
                }
                else {
                    primaryKey = DatabaseContract.create(DatabaseContract.CharacterClass.TABLE_NAME, DatabaseContract.setClassValues(classModel), db);
                }

                classModel.setClassID((short) primaryKey);

                exists = DatabaseContract.existsInDB(DatabaseContract.Race.TABLE_NAME, "Human", db);
                Models.RaceModel raceModel = Models.setRaceModel("Human");

                if (exists) {
                    primaryKey = DatabaseContract.getPrimaryKey(DatabaseContract.Race.TABLE_NAME, "Human", db);
                }
                else {
                    primaryKey = DatabaseContract.create(DatabaseContract.Race.TABLE_NAME, DatabaseContract.setRaceValues(raceModel), db);
                }

                raceModel.setRaceID((short) primaryKey);

                exists = DatabaseContract.existsInDB(DatabaseContract.Gender.TABLE_NAME, "Male", db);
                Models.GenderModel genderModel = Models.setGenderModel("Male");

                if (exists) {
                    primaryKey = DatabaseContract.getPrimaryKey(DatabaseContract.Gender.TABLE_NAME, "Male", db);
                }
                else {
                    primaryKey = DatabaseContract.create(DatabaseContract.Gender.TABLE_NAME, DatabaseContract.setGenderValues(genderModel), db);
                }

                genderModel.setGenderID((short) primaryKey);

                exists = DatabaseContract.existsInDB(DatabaseContract.Alignment.TABLE_NAME, "Lawful Good", db);
                Models.AlignmentModel alignmentModel = Models.setAlignmentModel("Lawful Good");

                if (exists) {
                    primaryKey = DatabaseContract.getPrimaryKey(DatabaseContract.Alignment.TABLE_NAME, "Alignment", db);
                }
                else {
                    primaryKey = DatabaseContract.create(DatabaseContract.Alignment.TABLE_NAME, DatabaseContract.setAlignmentValues(alignmentModel), db);
                }

                alignmentModel.setAlignment((short) primaryKey);

                Models.StatsModel statsModel = characterFragment.getStatsModel();
                primaryKey = DatabaseContract.create(DatabaseContract.Stat.TABLE_NAME, DatabaseContract.setStatValues(statsModel), db);
                statsModel.setStatID((short) primaryKey);

                Models.SecondaryStatsModel secondaryStatsModel = Models.setSecondaryStatsModel("10", "10", "10", "10", "10");
                primaryKey = DatabaseContract.create(DatabaseContract.SecondaryStats.TABLE_NAME, DatabaseContract.setSecondaryStatValues(secondaryStatsModel), db);
                secondaryStatsModel.setSecondaryStatsID((short) primaryKey);

                Models.ProficiencyModel proficiencyModel = Models.setProficiencyModel(true, true, true, true, true, true, true, true,
                        true, true, true, true, true, true, true, true,
                        true, true, true, true, true, true, true, true);
                primaryKey = DatabaseContract.create(DatabaseContract.Proficiency.TABLE_NAME, DatabaseContract.setProficiencyValues(proficiencyModel), db);
                proficiencyModel.setProficiencyID((short) primaryKey);

                Models.CharacterModel characterModel = Models.setCharacterModel("Aaron Scherer", "43", "3", classModel,
                        raceModel, alignmentModel, genderModel,
                        statsModel, secondaryStatsModel, proficiencyModel);
                DatabaseContract.create(DatabaseContract.PlayerCharacter.TABLE_NAME, DatabaseContract.setCharacterValues(characterModel), db);

                db.close();
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
