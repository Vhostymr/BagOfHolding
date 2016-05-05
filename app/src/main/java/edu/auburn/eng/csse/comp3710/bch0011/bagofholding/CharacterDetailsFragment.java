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
import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.Models.Models;
import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.R;
import edu.auburn.eng.csse.comp3710.bch0011.bagofholding.Utilities.Utilities;

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
    TextView passiveInsightTV;


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
        dexterityModifierTV = (TextView) view.findViewById(R.id.tv_dexterity_modifier);
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

        passiveInsightTV = (TextView) view.findViewById(R.id.tv_passive_insight);
        passivePerceptionTV = (TextView) view.findViewById(R.id.tv_passive_perception);


        Models.CharacterModel cm = parentActivity.getCharacterModel();
        if (cm != null) {
            //Setup
            nameTV.setText(cm.getCharacterName());
            levelTV.setText(String.valueOf(cm.getCharacterLevel()));
            experienceTV.setText(String.valueOf(cm.getCharacterExperience()));
            alignmentTV.setText(String.valueOf(cm.getAlignment().getAlignmentName()));
            raceTV.setText(String.valueOf(cm.getRace().getRaceName()));
            classTV.setText(String.valueOf(cm.getCharacterClass().getClassName()));

            strengthModifierTV.setText(String.valueOf(Utilities.getAbilityModifier(cm.getStats().getStrength())));
            strengthTV.setText(String.valueOf(cm.getStats().getStrength()));
            savingThrowsStrengthTV.setText(String.valueOf(cm.getProficiencies().getStrengthSavingThrow()));
            athleticsStrengthTV.setText(String.valueOf(cm.getProficiencies().getAthletics()));

            intelligenceModifierTV.setText(String.valueOf(Utilities.getAbilityModifier(cm.getStats().getIntelligence())));
            intelligenceTV.setText(String.valueOf(cm.getStats().getIntelligence()));
            savingThrowsIntelligenceTV.setText(String.valueOf(cm.getProficiencies().getIntelligenceSavingThrow()));
            arcanaIntelligenceTV.setText(String.valueOf(cm.getProficiencies().getArcana()));
            historyIntelligenceTV.setText(String.valueOf(cm.getProficiencies().getHistory()));
            investigationIntelligenceTV.setText(String.valueOf(cm.getProficiencies().getInvestigation()));
            natureIntelligenceTV.setText(String.valueOf(cm.getProficiencies().getNature()));
            religionIntelligenceTV.setText(String.valueOf(cm.getProficiencies().getReligion()));

            dexterityModifierTV.setText(String.valueOf(Utilities.getAbilityModifier(cm.getStats().getDexterity())));
            dexterityTV.setText(String.valueOf(cm.getStats().getDexterity()));
            savingThrowsDexterityTV.setText(String.valueOf(cm.getProficiencies().getDexteritySavingThrow()));
            acrobaticsDexterityTV.setText(String.valueOf(cm.getProficiencies().getAcrobatics()));
            sleightOfHandDexterityTV.setText(String.valueOf(cm.getProficiencies().getSleightOfHand()));
            stealthDexterityTV.setText(String.valueOf(cm.getProficiencies().getDexteritySavingThrow()));

            wisdomModifierTV.setText(String.valueOf(Utilities.getAbilityModifier(cm.getStats().getWisdom())));
            wisdomTV.setText(String.valueOf(cm.getStats().getWisdom()));
            savingThrowsWisdomTV.setText(String.valueOf(cm.getProficiencies().getWisdomSavingThrow()));
            animalHandlingWisdomTV.setText(String.valueOf(cm.getProficiencies().getAnimalHandling()));
            insightWisdomTV.setText(String.valueOf(cm.getProficiencies().getInsight()));
            medicineWisdomTV.setText(String.valueOf(cm.getProficiencies().getMedicine()));
            perceptionWisdomTV.setText(String.valueOf(cm.getProficiencies().getPerception()));
            survivalWisdomTV.setText(String.valueOf(cm.getProficiencies().getSurvival()));

            constitutionModifierTV.setText(String.valueOf(Utilities.getAbilityModifier(cm.getStats().getConstitution())));
            constitutionTV.setText(String.valueOf(cm.getStats().getConstitution()));
            savingThrowsConstitutionTV.setText(String.valueOf(cm.getProficiencies().getConstitutionSavingThrow()));

            charismaModifierTV.setText(String.valueOf(Utilities.getAbilityModifier(cm.getStats().getCharisma())));
            charismaTV.setText(String.valueOf(cm.getStats().getCharisma()));
            savingThrowsCharismaTV.setText(String.valueOf(cm.getProficiencies().getCharismaSavingThrows()));
            deceptionCharismaTV.setText(String.valueOf(cm.getProficiencies().getDeception()));
            intimidationCharismaTV.setText(String.valueOf(cm.getProficiencies().getIntimidation()));
            performanceCharismaTV.setText(String.valueOf(cm.getProficiencies().getPerformance()));
            persuasionCharismaTV.setText(String.valueOf(cm.getProficiencies().getPersuasion()));

            passiveInsightTV.setText(String.valueOf(Utilities.getPassiveBonus(cm.getCharacterLevel(), cm.getStats().getWisdom(), cm.getProficiencies().getInsight())));
            passivePerceptionTV.setText(String.valueOf(Utilities.getPassiveBonus(cm.getCharacterLevel(), cm.getStats().getWisdom(), cm.getProficiencies().getPerception())));
            armorClassTV.setText(String.valueOf(cm.getSecondaryStats().getArmorClass()));
            initiativeTV.setText(String.valueOf(cm.getSecondaryStats().getInitiative()));
            speedTV.setText(String.valueOf(cm.getSecondaryStats().getSpeed()));
            maxHitPointsTV.setText(String.valueOf(cm.getSecondaryStats().getMaxHP()));
            temporaryHitPointsTV.setText(String.valueOf(cm.getSecondaryStats().getTempHP()));
        }
        return view;
    }
}
