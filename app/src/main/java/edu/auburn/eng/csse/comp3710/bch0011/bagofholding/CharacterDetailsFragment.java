package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.MainActivity;
import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.R;

public class CharacterDetailsFragment extends Fragment {

    MainActivity parentActivity;

    //Text View Fields

    //Character Info
    TextView nameTV;
    TextView levelTV;
    TextView experienceTV;


    //Stats
    TextView strengthModifierTV;
    TextView dexterityModifierTV;
    TextView constitutionModifierTV;
    TextView intelligenceModifierTV;
    TextView wisdomModifierTV;
    TextView charismaModifierTV;

    TextView strengthTV;
    TextView dexterityTV;
    TextView constitutionTV;
    TextView intelligenceTV;
    TextView wisdomTV;
    TextView charismaTV;

    //Secondary Stats
    TextView armorClassTV;
    TextView initiativeTV;
    TextView speedTV;
    TextView maxHitPointsTV;
    TextView temporaryHitPointsTV;


    //CharacterInfo
    TextView alignmentTV;
    TextView raceTV;
    TextView classTV;


    //Proficiencies
    TextView savingThrowsStrengthTV;
    TextView athleticsStrengthTV;

    TextView savingThrowsDexterityTV;
    TextView acrobaticsDexterityTV;
    TextView sleightOfHandDexterityTV;
    TextView stealthDexterityTV;

    TextView savingThrowsConstitutionTV;

    TextView savingThrowsIntelligenceTV;
    TextView arcanaIntelligenceTV;
    TextView historyIntelligenceTV;
    TextView investigationIntelligenceTV;
    TextView natureIntelligenceTV;
    TextView religionIntelligenceTV;

    TextView savingThrowsWisdomTV;
    TextView animalHandlingWisdomTV;
    TextView insightWisdomTV;
    TextView medicineWisdomTV;
    TextView perceptionWisdomTV;
    TextView survivalWisdomTV;

    TextView savingThrowsCharismaTV;
    TextView deceptionCharismaTV;
    TextView intimidationCharismaTV;
    TextView performanceCharismaTV;
    TextView persuasionCharismaTV;

    TextView passivePerceptionTV;
    TextView passiveInsight;


    public CharacterDetailsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        parentActivity = (MainActivity) getActivity();
        final View view = inflater.inflate(R.layout.fragment_character_stats_details, container, false);



        //TextViewSetters
        strengthTV = (TextView) view.findViewById(R.id.tv_strength);
        dexterityTV = (TextView) view.findViewById(R.id.tv_dexterity);
        constitutionTV = (TextView) view.findViewById(R.id.tv_constitution);
        intelligenceTV = (TextView) view.findViewById(R.id.tv_intelligence);
        wisdomTV = (TextView) view.findViewById(R.id.tv_wisdom);
        charismaTV = (TextView) view.findViewById(R.id.tv_charisma);
        strengthModifierTV = (TextView) view.findViewById(R.id.tv_strength_modifier);
        dexterityModifierTV = (TextView) view.findViewById(R.id.tv_strength_modifier);
        constitutionModifierTV = (TextView) view.findViewById(R.id.tv_constitution_modifier);
        intelligenceModifierTV = (TextView) view.findViewById(R.id.tv_intelligence_modifier);
        wisdomModifierTV = (TextView) view.findViewById(R.id.tv_wisdom_modifier);
        charismaModifierTV = (TextView) view.findViewById(R.id.tv_charisma_modifier);
        nameTV = (TextView) view.findViewById(R.id.tv_name);
        levelTV = (TextView) view.findViewById(R.id.tv_level);
        experienceTV = (TextView) view.findViewById(R.id.tv_experience_points);
        armorClassTV = (TextView) view.findViewById(R.id.tv_armor_class);
        initiativeTV = (TextView) view.findViewById(R.id.tv_initiative);
        speedTV = (TextView) view.findViewById(R.id.tv_speed);
        maxHitPointsTV = (TextView) view.findViewById(R.id.tv_max_hit_points);
        temporaryHitPointsTV = (TextView) view.findViewById(R.id.tv_temporary_hit_points);
        alignmentTV = (TextView) view.findViewById(R.id.tv_alignment);
        raceTV = (TextView) view.findViewById(R.id.tv_race);
        classTV = (TextView) view.findViewById(R.id.tv_class);


        savingThrowsStrengthTV = (TextView) view.findViewById(R.id.tv_saving_throws_strength);
        athleticsStrengthTV = (TextView) view.findViewById(R.id.tv_athletics_strength);

        savingThrowsDexterityTV = (TextView) view.findViewById(R.id.tv_saving_throws_dexterity);
        acrobaticsDexterityTV = (TextView) view.findViewById(R.id.tv_acrobatics_dexterity);
        sleightOfHandDexterityTV = (TextView) view.findViewById(R.id.tv_sleight_of_hand_dexterity);
        stealthDexterityTV = (TextView) view.findViewById(R.id.tv_stealth_dexterity);

        savingThrowsConstitutionTV = (TextView) view.findViewById(R.id.tv_saving_throws_constitution);

        savingThrowsIntelligenceTV = (TextView) view.findViewById(R.id.tv_saving_throws_intelligence);
        arcanaIntelligenceTV = (TextView) view.findViewById(R.id.tv_arcana_intelligence);
        historyIntelligenceTV = (TextView) view.findViewById(R.id.tv_history_intelligence);
        investigationIntelligenceTV = (TextView) view.findViewById(R.id.tv_investigation_intelligence);
        natureIntelligenceTV = (TextView) view.findViewById(R.id.tv_nature_intelligence);
        religionIntelligenceTV = (TextView) view.findViewById(R.id.tv_religion_intelligence);

        savingThrowsWisdomTV = (TextView) view.findViewById(R.id.tv_saving_throws_wisdom);
        animalHandlingWisdomTV = (TextView) view.findViewById(R.id.tv_animal_handling_wisdom);
        insightWisdomTV = (TextView) view.findViewById(R.id.tv_insight_wisdom);
        medicineWisdomTV = (TextView) view.findViewById(R.id.tv_medicine_wisdom);
        perceptionWisdomTV = (TextView) view.findViewById(R.id.tv_perception_wisdom);
        survivalWisdomTV = (TextView) view.findViewById(R.id.tv_survival_wisdom);

        savingThrowsCharismaTV = (TextView) view.findViewById(R.id.tv_saving_throws_charisma);
        deceptionCharismaTV = (TextView) view.findViewById(R.id.tv_deception_charisma);
        intimidationCharismaTV = (TextView) view.findViewById(R.id.tv_intimidation_charisma);
        performanceCharismaTV = (TextView) view.findViewById(R.id.tv_performance_charisma);
        persuasionCharismaTV = (TextView) view.findViewById(R.id.tv_persuasion_charisma);

        passiveInsight = (TextView) view.findViewById(R.id.tv_passive_insight);
        passiveInsight = (TextView) view.findViewById(R.id.tv_passive_perception);

        //Setup
//        nameTV.setText();
//        levelTV.setText();
//        experienceTV.setText();
//        alignmentTV.setText();
//        raceTV.setText();
//        classTV.setText();
//        strengthModifierTV.setText();
//        strengthTV.setText();
//        savingThrowsStrengthTV.setText();
//        athleticsStrengthTV.setText();
//        intelligenceModifierTV.setText();
//        intelligenceTV.setText();
//        savingThrowsIntelligenceTV.setText();
//        arcanaIntelligenceTV.setText();
//        historyIntelligenceTV.setText();
//        investigationIntelligenceTV.setText();
//        natureIntelligenceTV.setText();
//        religionIntelligenceTV.setText();
//        constitutionModifierTV.setText();
//        constitutionTV.setText();
//        savingThrowsConstitutionTV.setText();
//        charismaModifierTV.setText();
//        charismaTV.setText();
//        savingThrowsCharismaTV.setText();
//        deceptionCharismaTV.setText();
//        intimidationCharismaTV.setText();
//        performanceCharismaTV.setText();
//        persuasionCharismaTV.setText();
//        passiveInsight.setText();
//        passivePerceptionTV.setText();
//        armorClassTV.setText();
//        initiativeTV.setText();
//        speedTV.setText();
//        maxHitPointsTV.setText();
//        temporaryHitPointsTV.setText();

        return view;
    }
}
