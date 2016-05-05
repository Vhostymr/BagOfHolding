package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.DatabaseContract.DatabaseContract;
import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.Models.Models;
import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.Utilities.Utilities;


public class CharacterEditFragment extends Fragment {

    MainActivity parentActivity;
    Models.CharacterModel cm;

    ArrayList<String> alignmentList;
    ArrayList<String> raceList;
    ArrayList<String> classList;
    ArrayList<String> genderList;

    ArrayAdapter<String> stringDataAdapter;


    //Edit Text Fields

        //Character Info
        EditText nameET;
        EditText levelET;
        EditText experienceET;


        //Stats
        EditText strengthET;
        EditText dexterityET;
        EditText constitutionET;
        EditText intelligenceET;
        EditText wisdomET;
        EditText charismaET;

        //Secondary Stats
        EditText armorClassET;
        EditText initiativeET;
        EditText speedET;
        EditText maxHitPointsET;
        EditText temporaryHitPointsET;

        //New Spinner Item
        EditText alignmentET;
        EditText raceET;
        EditText classET;
        EditText genderET;

    //Spinners
        //CharacterInfo
        Spinner alignmentSP;
        Spinner raceSP;
        Spinner classSP;
        Spinner genderSP;



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

    public CharacterEditFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        parentActivity = (MainActivity) getActivity();
        final View view = inflater.inflate(R.layout.fragment_character_edit, container, false);



        //EditTextSetters
        strengthET = (EditText) view.findViewById(R.id.et_strength);
        dexterityET = (EditText) view.findViewById(R.id.et_dexterity);
        constitutionET = (EditText) view.findViewById(R.id.et_constitution);
        intelligenceET = (EditText) view.findViewById(R.id.et_intelligence);
        wisdomET = (EditText) view.findViewById(R.id.et_wisdom);
        charismaET = (EditText) view.findViewById(R.id.et_charisma);
        nameET = (EditText) view.findViewById(R.id.et_name);
        levelET = (EditText) view.findViewById(R.id.et_level);
        experienceET = (EditText) view.findViewById(R.id.et_experience_points);
        armorClassET = (EditText) view.findViewById(R.id.et_armor_class);
        initiativeET = (EditText) view.findViewById(R.id.et_initiative);
        speedET = (EditText) view.findViewById(R.id.et_speed);
        maxHitPointsET = (EditText) view.findViewById(R.id.et_max_hit_points);
        temporaryHitPointsET = (EditText) view.findViewById(R.id.et_temporary_hit_points);

        alignmentET = (EditText) view.findViewById(R.id.et_new_alignment);
        raceET = (EditText) view.findViewById(R.id.et_new_race);
        classET = (EditText) view.findViewById(R.id.et_new_class);
        genderET = (EditText) view.findViewById(R.id.et_new_gender);
        //SpinnerSetters
        alignmentSP = (Spinner) view.findViewById(R.id.sp_alignment);
        raceSP = (Spinner) view.findViewById(R.id.sp_race);
        classSP = (Spinner) view.findViewById(R.id.sp_class);
        genderSP = (Spinner) view.findViewById(R.id.sp_gender);


        //CheckBoxSetters
        savingThrowsStrengthCB = (CheckBox) view.findViewById(R.id.cb_saving_throws_strength);
        athleticsStrengthCB = (CheckBox) view.findViewById(R.id.cb_athletics_strength);

        savingThrowsDexterityCB = (CheckBox) view.findViewById(R.id.cb_saving_throws_dexterity);
        acrobaticsDexterityCB = (CheckBox) view.findViewById(R.id.cb_acrobatics_dexterity);
        sleightOfHandDexterityCB = (CheckBox) view.findViewById(R.id.cb_sleight_of_hand_dexterity);
        stealthDexterityCB = (CheckBox) view.findViewById(R.id.cb_stealth_dexterity);

        savingThrowsConstitutionCB = (CheckBox) view.findViewById(R.id.cb_saving_throws_constitution);

        savingThrowsIntelligenceCB = (CheckBox) view.findViewById(R.id.cb_saving_throws_intelligence);
        arcanaIntelligenceCB = (CheckBox) view.findViewById(R.id.cb_arcana_intelligence);
        historyIntelligenceCB = (CheckBox) view.findViewById(R.id.cb_history_intelligence);
        investigationIntelligenceCB = (CheckBox) view.findViewById(R.id.cb_investigation_intelligence);
        natureIntelligenceCB = (CheckBox) view.findViewById(R.id.cb_nature_intelligence);
        religionIntelligenceCB = (CheckBox) view.findViewById(R.id.cb_religion_intelligence);

        savingThrowsWisdomCB = (CheckBox) view.findViewById(R.id.cb_saving_throws_wisdom);
        animalHandlingWisdomCB = (CheckBox) view.findViewById(R.id.cb_animal_handling_wisdom);
        insightWisdomCB = (CheckBox) view.findViewById(R.id.cb_insight_wisdom);
        medicineWisdomCB = (CheckBox) view.findViewById(R.id.cb_medicine_wisdom);
        perceptionWisdomCB = (CheckBox) view.findViewById(R.id.cb_perception_wisdom);
        survivalWisdomCB = (CheckBox) view.findViewById(R.id.cb_survival_wisdom);

        savingThrowsCharismaCB = (CheckBox) view.findViewById(R.id.cb_saving_throws_charisma);
        deceptionCharismaCB = (CheckBox) view.findViewById(R.id.cb_deception_charisma);
        intimidationCharismaCB = (CheckBox) view.findViewById(R.id.cb_intimidation_charisma);
        performanceCharismaCB = (CheckBox) view.findViewById(R.id.cb_performance_charisma);
        persuasionCharismaCB = (CheckBox) view.findViewById(R.id.cb_persuasion_charisma);




        cm = parentActivity.getCharacterModel();
        if (cm != null) {
            nameET.setText(cm.getCharacterName());
            levelET.setText(String.valueOf(cm.getCharacterLevel()));
            experienceET.setText(String.valueOf(cm.getCharacterExperience()));

            //Spinners
            alignmentList = new ArrayList<>();
            raceList = new ArrayList<>();
            classList = new ArrayList<>();
            genderList = new ArrayList<>();

            alignmentList.addAll(parentActivity.getAlignmentDatabaseItems());
            raceList.addAll(parentActivity.getRaceDatabaseItems());
            classList.addAll(parentActivity.getClassDatabaseItems());
            genderList.addAll(parentActivity.getGenderDatabaseItems());



            alignmentList.add(getString(R.string.create_alignment));
            raceList.add(getString(R.string.create_race));
            classList.add(getString(R.string.create_class));
            genderList.add(getString(R.string.create_gender));

            stringDataAdapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_spinner_dropdown_item, alignmentList);
            stringDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            alignmentSP.setAdapter(stringDataAdapter);

            stringDataAdapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_spinner_dropdown_item, raceList);
            stringDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            raceSP.setAdapter(stringDataAdapter);

            stringDataAdapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_spinner_dropdown_item, classList);
            stringDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            classSP.setAdapter(stringDataAdapter);

            stringDataAdapter = new ArrayAdapter(getActivity().getBaseContext(), android.R.layout.simple_spinner_dropdown_item, genderList);
            stringDataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            genderSP.setAdapter(stringDataAdapter);


            //alignmentSP.setText();
            //raceSP.setText();
            //classTV.setText();
            strengthET.setText(String.valueOf(cm.getStats().getStrength()));
            savingThrowsStrengthCB.setChecked(cm.getProficiencies().getStrengthSavingThrow());
            athleticsStrengthCB.setChecked(cm.getProficiencies().getAthletics());

            intelligenceET.setText(String.valueOf(cm.getStats().getIntelligence()));
            savingThrowsIntelligenceCB.setChecked(cm.getProficiencies().getIntelligenceSavingThrow());
            arcanaIntelligenceCB.setChecked(cm.getProficiencies().getArcana());
            historyIntelligenceCB.setChecked(cm.getProficiencies().getHistory());
            investigationIntelligenceCB.setChecked(cm.getProficiencies().getInvestigation());
            natureIntelligenceCB.setChecked(cm.getProficiencies().getNature());
            religionIntelligenceCB.setChecked(cm.getProficiencies().getReligion());

            dexterityET.setText(String.valueOf(cm.getStats().getDexterity()));
            savingThrowsDexterityCB.setChecked(cm.getProficiencies().getDexteritySavingThrow());
            acrobaticsDexterityCB.setChecked(cm.getProficiencies().getAcrobatics());
            sleightOfHandDexterityCB.setChecked(cm.getProficiencies().getSleightOfHand());
            stealthDexterityCB.setChecked(cm.getProficiencies().getStealth());

            wisdomET.setText(String.valueOf(cm.getStats().getWisdom()));
            savingThrowsWisdomCB.setChecked(cm.getProficiencies().getWisdomSavingThrow());
            animalHandlingWisdomCB.setChecked(cm.getProficiencies().getAnimalHandling());
            insightWisdomCB.setChecked(cm.getProficiencies().getInsight());
            medicineWisdomCB.setChecked(cm.getProficiencies().getMedicine());
            perceptionWisdomCB.setChecked(cm.getProficiencies().getPerception());
            survivalWisdomCB.setChecked(cm.getProficiencies().getSurvival());

            constitutionET.setText(String.valueOf(cm.getStats().getConstitution()));
            savingThrowsConstitutionCB.setChecked(cm.getProficiencies().getConstitutionSavingThrow());

            charismaET.setText(String.valueOf(cm.getStats().getCharisma()));
            savingThrowsCharismaCB.setChecked(cm.getProficiencies().getCharismaSavingThrows());
            deceptionCharismaCB.setChecked(cm.getProficiencies().getDeception());
            intimidationCharismaCB.setChecked(cm.getProficiencies().getIntimidation());
            performanceCharismaCB.setChecked(cm.getProficiencies().getPerformance());
            persuasionCharismaCB.setChecked(cm.getProficiencies().getPersuasion());

            armorClassET.setText(String.valueOf(cm.getSecondaryStats().getArmorClass()));
            initiativeET.setText(String.valueOf(cm.getSecondaryStats().getInitiative()));
            speedET.setText(String.valueOf(cm.getSecondaryStats().getSpeed()));
            maxHitPointsET.setText(String.valueOf(cm.getSecondaryStats().getMaxHP()));
            temporaryHitPointsET.setText(String.valueOf(cm.getSecondaryStats().getTempHP()));

        }


        genderSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int postion, long id) {
                if (genderSP.getSelectedItem().toString().equals(getString(R.string.create_gender))){
                    genderET.setVisibility(View.VISIBLE);
                }
                else {
                    genderET.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        alignmentSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int postion, long id) {
                if (alignmentSP.getSelectedItem().toString().equals(getString(R.string.create_alignment))){
                    alignmentET.setVisibility(View.VISIBLE);
                }
                else {
                    alignmentET.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        raceSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int postion, long id) {
                if (raceSP.getSelectedItem().toString().equals(getString(R.string.create_race))){
                    raceET.setVisibility(View.VISIBLE);
                }
                else {
                    raceET.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
        classSP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int postion, long id) {
                if (classSP.getSelectedItem().toString().equals(getString(R.string.create_class))){
                    classET.setVisibility(View.VISIBLE);

//                    Models.CharacterModel cm1 = populateModelFromView();
//                    int i = 2;
//                    int l = i + 1;
                }
                else {
                    classET.setVisibility(View.GONE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });


        return view;
    }

    public String[] getBasicCharacterInfo(){
        String[] basicInfo = new String[3];
        basicInfo[0] = nameET.getText().toString();
        basicInfo[1] = levelET.getText().toString();
        basicInfo[2] = experienceET.getText().toString();
        return basicInfo;
    }

    public Models.StatsModel getStatsModel(){

        String test = strengthET.getText().toString();

        return Models.setStatsModel(strengthET.getText().toString(), dexterityET.getText().toString(),
                constitutionET.getText().toString(), intelligenceET.getText().toString(),
                wisdomET.getText().toString(), charismaET.getText().toString());
    }
    public Models.ProficiencyModel getProficiencyModel(){
        return Models.setProficiencyModel(savingThrowsStrengthCB.isChecked(), athleticsStrengthCB.isChecked(),
                savingThrowsDexterityCB.isChecked(), acrobaticsDexterityCB.isChecked(),
                sleightOfHandDexterityCB.isChecked(), stealthDexterityCB.isChecked(),
                savingThrowsConstitutionCB.isChecked(), savingThrowsIntelligenceCB.isChecked(),
                arcanaIntelligenceCB.isChecked(), historyIntelligenceCB.isChecked(),
                investigationIntelligenceCB.isChecked(), natureIntelligenceCB.isChecked(),
                religionIntelligenceCB.isChecked(), savingThrowsWisdomCB.isChecked(),
                animalHandlingWisdomCB.isChecked(), insightWisdomCB.isChecked(),
                medicineWisdomCB.isChecked(), perceptionWisdomCB.isChecked(),
                survivalWisdomCB.isChecked(), savingThrowsCharismaCB.isChecked(),
                deceptionCharismaCB.isChecked(), intimidationCharismaCB.isChecked(),
                performanceCharismaCB.isChecked(), persuasionCharismaCB.isChecked());
    }
    public Models.SecondaryStatsModel getSecondaryStatsModel(){
        return Models.setSecondaryStatsModel(armorClassET.getText().toString(), initiativeET.getText().toString(),
                speedET.getText().toString(), maxHitPointsET.getText().toString(),
                temporaryHitPointsET.getText().toString());
    }
    public Models.GenderModel getGenderModel(){
        if (genderSP.getSelectedItem().toString().equals(getString(R.string.create_gender)))
        {
            return Models.setGenderModel(genderET.getText().toString());
        }
        return Models.setGenderModel(genderSP.getSelectedItem().toString());
    }
    public Models.ClassModel getClassModel(){
        if (classSP.getSelectedItem().toString().equals(getString(R.string.create_class)))
        {
            return Models.setClassModel(classET.getText().toString());
        }
        return Models.setClassModel(classSP.getSelectedItem().toString());
    }
    public Models.RaceModel getRaceModel(){
        if (raceSP.getSelectedItem().toString().equals(getString(R.string.create_race)))
        {
            return Models.setRaceModel(raceET.getText().toString());
        }
        return Models.setRaceModel(raceSP.getSelectedItem().toString());
    }
    public Models.AlignmentModel getAlignmentModel(){
        if (alignmentSP.getSelectedItem().toString().equals(getString(R.string.create_alignment)))
        {
            return Models.setAlignmentModel(alignmentET.getText().toString());
        }
        return Models.setAlignmentModel(alignmentSP.getSelectedItem().toString());
    }

    public Models.CharacterModel populateModelFromView(){
        return Models.setCharacterModel(cm.getCharacterID(), nameET.getText().toString(), levelET.getText().toString(),
                                        experienceET.getText().toString(), getClassModel(),
                                        getRaceModel(), getAlignmentModel(), getGenderModel(),
                                        getStatsModel(), getSecondaryStatsModel(), getProficiencyModel());
    }

}
