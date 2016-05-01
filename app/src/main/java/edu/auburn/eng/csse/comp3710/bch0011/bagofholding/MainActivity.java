package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

import android.content.ContentValues;
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
        setContentView(R.layout.fragment_character_stats_details);
        //final View view = inflater.inflate(R.layout.fragment_character_stats_edit, container, false);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Models.CharacterModel cm = new Models.CharacterModel();

        Models.ProficiencyModel pm = new Models.ProficiencyModel();
        final Models.StatsModel sm = new Models.StatsModel();

        //EditTextSetters
//        strengthET = (EditText) findViewById(R.id.et_strength);
//        dexterityET = (EditText) findViewById(R.id.et_dexterity);
//        constitutionET = (EditText) findViewById(R.id.et_constitution);
//        intelligenceET = (EditText) findViewById(R.id.et_intelligence);
//        wisdomET = (EditText) findViewById(R.id.et_wisdom);
//        charismaET = (EditText) findViewById(R.id.et_charisma);




//        strengthET.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//                String textIn = String.valueOf(strengthET.getText());
//                sm.setStrength(Short.parseShort(textIn));
//                sm.setCharisma((short) 0);
//                sm.setConstitution((short) 0);
//                sm.setDexterity((short) 0);
//                sm.setIntelligence((short) 0);
//                sm.setWisdom((short) 0);
//
//                cm.setStats(sm);
//
//                ContentValues values = DatabaseContract.setStatValues(cm);
//                DatabaseContract.create("Character", values, getApplicationContext());
//            }
//        });




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
