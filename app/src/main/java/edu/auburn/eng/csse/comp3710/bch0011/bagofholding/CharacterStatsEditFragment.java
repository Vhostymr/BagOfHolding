package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;


public class CharacterStatsEditFragment extends Fragment {

    MainActivity parentActivity;

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

    public CharacterStatsEditFragment() {
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



        return view;
    }

    public Models.StatsModel getStatsModel(){
        return Models.setStatsModel(strengthET.getText().toString(), charismaET.getText().toString(),
                                                            constitutionET.getText().toString(), dexterityET.getText().toString(),
                                                            intelligenceET.getText().toString(), wisdomET.getText().toString());
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

}
