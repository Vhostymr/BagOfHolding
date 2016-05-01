package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;



import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    FragmentManager fm;
    Button saveme;
    CharacterStatsEditFragment characterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_info);
        //final View view = inflater.inflate(R.layout.fragment_character_stats_edit, container, false);

        fm = getSupportFragmentManager();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        saveme = (Button) findViewById(R.id.saveButton);


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

        saveme.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {


                Context context = getApplicationContext();

                Models.ClassModel classModel = Models.setClassModel("Paladin");
                long classPrimaryKey = DatabaseContract.create("CharacterClass", DatabaseContract.setClassValues(classModel), context);
                classModel.setClassID((short) classPrimaryKey);

                Models.RaceModel raceModel = Models.setRaceModel("Human");
                long racePrimaryKey = DatabaseContract.create("Race", DatabaseContract.setRaceValues(raceModel), context);
                raceModel.setRaceID((short) racePrimaryKey);

                Models.GenderModel genderModel = Models.setGenderModel("Male");
                long genderPrimaryKey = DatabaseContract.create("Gender", DatabaseContract.setGenderValues(genderModel), context);
                genderModel.setGenderID((short) genderPrimaryKey);

                Models.AlignmentModel alignmentModel = Models.setAlignmentModel("Lawful Good");
                long alignmentPrimaryKey = DatabaseContract.create("Alignment", DatabaseContract.setAlignmentValues(alignmentModel), context);
                alignmentModel.setAlignment((short) alignmentPrimaryKey);

                Models.StatsModel statsModel = characterFragment.getStatsModel();
                long statsPrimaryKey = DatabaseContract.create("Stat", DatabaseContract.setStatValues(statsModel), context);
                statsModel.setStatID((short) statsPrimaryKey);

                Models.SecondaryStatsModel secondaryStatsModel = Models.setSecondaryStatsModel("10", "10", "10", "10", "10");
                long secondaryStatsPrimaryKey = DatabaseContract.create("SecondaryStat", DatabaseContract.setSecondaryStatValues(secondaryStatsModel), context);
                secondaryStatsModel.setSecondaryStatsID((short) secondaryStatsPrimaryKey);

                Models.ProficiencyModel proficiencyModel = Models.setProficiencyModel(true, true, true, true, true, true, true, true,
                        true, true, true, true, true, true, true, true,
                        true, true, true, true, true, true, true, true);
                long newPrimaryKey = DatabaseContract.create("Proficiency", DatabaseContract.setProficiencyValues(proficiencyModel), getApplicationContext());
                proficiencyModel.setProficiencyID((short) newPrimaryKey);

                Models.CharacterModel characterModel = Models.setCharacterModel("Aaron Scherer", "43", "3", classModel,
                        raceModel, alignmentModel, genderModel,
                        statsModel, secondaryStatsModel, proficiencyModel);
                DatabaseContract.create("PlayerCharacter", DatabaseContract.setCharacterValues(characterModel), getApplicationContext());

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
