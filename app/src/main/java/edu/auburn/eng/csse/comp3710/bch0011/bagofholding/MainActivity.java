package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;



import android.content.ContentValues;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
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

    FragmentManager fm;

    //Edit Text Fields
    //Stats
    EditText strengthET;
    EditText dexterityET;
    EditText constitutionET;
    EditText intelligenceET;
    EditText wisdomET;
    EditText charismaET;

    //Check Boxes
    //Proficiencies
    CheckBox savingThrowsStrengthCB;
    CheckBox athleticsStrengthCB;

    CheckBox savingThrowsDexterityCB;
    CheckBox acrobaticsDexterityCB;
    CheckBox sleightOfHandDexterityCB;
    CheckBox stealthDexterityCB;

    CheckBox savingThrowsConstitutionCB;

    CheckBox savingThrowsIntelligenceCB;
    CheckBox arcanaIntelligenceCB;
    CheckBox historyIntelligenceCB;
    CheckBox investigationIntelligenceCB;
    CheckBox natureIntelligenceCB;
    CheckBox religionIntelligenceCB;

    CheckBox savingThrowsWisdomCB;
    CheckBox animalHandlingWisdomCB;
    CheckBox insightWisdomCB;
    CheckBox medicineWisdomCB;
    CheckBox perceptionWisdomCB;
    CheckBox survivalWisdomCB;

    CheckBox savingThrowsCharismaCB;
    CheckBox deceptionCharismaCB;
    CheckBox intimidationCharismaCB;
    CheckBox performanceCharismaCB;
    CheckBox persuasionCharismaCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_info);
        //final View view = inflater.inflate(R.layout.fragment_character_stats_edit, container, false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Models.CharacterModel cm = new Models.CharacterModel();

        Models.ProficiencyModel pm = new Models.ProficiencyModel();
        final Models.StatsModel sm = new Models.StatsModel();

        if (findViewById(R.id.character_fragment_container) != null) {
            // Create a new Fragment to be placed in the activity layout
            CharacterStatsEditFragment characterFragment = new CharacterStatsEditFragment();

            // In case this activity was started with special instructions from an
            // intent, pass the Intent's extras to the fragment as arguments
            characterFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            fm.beginTransaction()
                    .add(R.id.character_fragment_container, characterFragment).commit();
        }




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
