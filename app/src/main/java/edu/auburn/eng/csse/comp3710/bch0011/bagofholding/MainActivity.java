package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

import android.content.ContentValues;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText strengthET;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_character_stats_details);
        //final View view = inflater.inflate(R.layout.fragment_character_stats_edit, container, false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Context context = getApplicationContext();

        Models.ClassModel classModel = Models.setClassModel("");
        long classPrimaryKey = DatabaseContract.create("CharacterClass", DatabaseContract.setClassValues(classModel), context);
        classModel.setClassID((short) classPrimaryKey);

        Models.RaceModel raceModel = Models.setRaceModel("");
        long racePrimaryKey = DatabaseContract.create("Race", DatabaseContract.setRaceValues(raceModel), context);
        raceModel.setRaceID((short) racePrimaryKey);

        Models.GenderModel genderModel = Models.setGenderModel("");
        long genderPrimaryKey = DatabaseContract.create("Gender", DatabaseContract.setGenderValues(genderModel), context);
        genderModel.setGenderID((short) genderPrimaryKey);

        Models.AlignmentModel alignmentModel = Models.setAlignmentModel("");
        long alignmentPrimaryKey = DatabaseContract.create("Alignment", DatabaseContract.setAlignmentValues(alignmentModel), context);
        alignmentModel.setAlignment((short) alignmentPrimaryKey);

        Models.StatsModel statsModel = Models.setStatsModel("", "", "", "", "", "");
        long statsPrimaryKey = DatabaseContract.create("Stat", DatabaseContract.setStatValues(statsModel), context);
        statsModel.setStatID((short) statsPrimaryKey);
        
        Models.SecondaryStatsModel secondaryStatsModel = Models.setSecondaryStatsModel("", "", "", "", "");
        long secondaryStatsPrimaryKey = DatabaseContract.create("SecondaryStat", DatabaseContract.setSecondaryStatValues(secondaryStatsModel), context);
        secondaryStatsModel.setSecondaryStatsID((short) secondaryStatsPrimaryKey);

        Models.ProficiencyModel proficiencyModel = Models.setProficiencyModel(true, true, true, true, true, true, true, true,
                                                                              true, true, true, true, true, true, true, true,
                                                                              true, true, true, true, true, true, true, true);
        long newPrimaryKey = DatabaseContract.create("Proficiency", DatabaseContract.setProficiencyValues(proficiencyModel), getApplicationContext());
        proficiencyModel.setProficiencyID((short) newPrimaryKey);

        Models.CharacterModel characterModel = Models.setCharacterModel("", "", "", classModel,
                                                                        raceModel, alignmentModel, genderModel,
                                                                        statsModel, secondaryStatsModel, proficiencyModel);
        DatabaseContract.create("PlayerCharacter", DatabaseContract.setCharacterValues(characterModel), getApplicationContext());

        strengthET.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}
