package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

public class Models {
    public static final class CharacterModel {
        private Short CharacterID;
        private String CharacterName;
        private Short CharacterLevel;
        private Integer CharacterExperience;
        private RaceModel Race;
        private ClassModel Class;
        private AlignmentModel Alignment;
        private GenderModel Gender;
        private StatsModel Stats;
        private SecondaryStatsModel SecondaryStats;
        private ProficiencyModel Proficiency;

        public CharacterModel() {
            CharacterID = 0;
            CharacterName = "";
            CharacterLevel = 0;
            CharacterExperience = 0;
            Race = new RaceModel();
            Class = new ClassModel();
            Alignment = new AlignmentModel();
            Gender = new GenderModel();
            Stats = new StatsModel();
            SecondaryStats = new SecondaryStatsModel();
            Proficiency = new ProficiencyModel();
        }

        public void setCharacterID(Short CharacterID) {
            this.CharacterID = CharacterID;
        }

        public Short getCharacterID() {
            return CharacterID;
        }

        public void setCharacterName(String CharacterName) {
            this.CharacterName = CharacterName;
        }

        public String getCharacterName() {
            return CharacterName;
        }

        public void setCharacterExperience(Integer CharacterExperience) {
            this.CharacterExperience = CharacterExperience;
        }

        public Integer getCharacterExperience() {
            return CharacterExperience;
        }

        public void setCharacterLevel(Short CharacterLevel) {
            this.CharacterLevel = CharacterLevel;
        }

        public Short getCharacterLevel() {
            return CharacterLevel;
        }

        public void setRace(RaceModel Race) {
            this.Race = Race;
        }

        public RaceModel getRace() {
            return Race;
        }

        public void setCharacterClass(ClassModel Class) {
            this.Class = Class;
        }

        public ClassModel getCharacterClass() {
            return Class;
        }

        public void setAlignment(AlignmentModel Alignment) {
            this.Alignment = Alignment;
        }

        public AlignmentModel getAlignment() {
            return Alignment;
        }

        public void setGender(GenderModel Gender) {
            this.Gender = Gender;
        }

        public GenderModel getGender() {
            return Gender;
        }

        public void setStats(StatsModel Stats) {
            this.Stats = Stats;
        }

        public StatsModel getStats() {
            return Stats;
        }

        public void setSecondaryStats(SecondaryStatsModel SecondaryStats) {
            this.SecondaryStats = SecondaryStats;
        }

        public SecondaryStatsModel getSecondaryStats() {
            return SecondaryStats;
        }

        public void setProficiencies(ProficiencyModel Proficiency) {
            this.Proficiency = Proficiency;
        }

        public ProficiencyModel getProficiencies() {
            return Proficiency;
        }
    }

    public static final class StatsModel {
        private Short StatID;
        private Short Strength;
        private Short Dexterity;
        private Short Constitution;
        private Short Intelligence;
        private Short Wisdom;
        private Short Charisma;

        public void setStatID(Short StatID) {
            this.StatID = StatID;
        }

        public Short getStatID() {
            return StatID;
        }

        public void setStrength(Short Strength) {
            this.Strength = Strength;
        }

        public Short getStrength() {
            return Strength;
        }

        public void setDexterity(Short Dexterity) {
            this.Dexterity = Dexterity;
        }

        public Short getDexterity() {
            return Dexterity;
        }

        public void setConstitution(Short Constitution) {
            this.Constitution = Constitution;
        }

        public Short getConstitution() {
            return Constitution;
        }

        public void setIntelligence(Short Intelligence) {
            this.Intelligence = Intelligence;
        }

        public Short getIntelligence() {
            return Intelligence;
        }

        public void setWisdom(Short Wisdom) {
            this.Wisdom = Wisdom;
        }

        public Short getWisdom() {
            return Wisdom;
        }

        public void setCharisma(Short Charisma) {
            this.Charisma = Charisma;
        }

        public Short getCharisma() {
            return Charisma;
        }
    }

    public static final class SecondaryStatsModel {
        private Short SecondaryStatsID;
        private Short ArmorClass;
        private Short Initiative;
        private Short Speed;
        private Short MaxHP;
        private Short TempHP;

        public void setSecondaryStatsID(Short SecondaryStatsID) {
            this.SecondaryStatsID = SecondaryStatsID;
        }

        public Short getSecondaryStatsID() {
            return SecondaryStatsID;
        }

        public void setArmorClass(Short ArmorClass) {
            this.ArmorClass = ArmorClass;
        }

        public Short getArmorClass() {
            return ArmorClass;
        }

        public void setInitiative(Short Initiative) {
            this.Initiative = Initiative;
        }

        public Short getInitiative() {
            return Initiative;
        }

        public void setSpeed(Short Speed) {
            this.Speed = Speed;
        }

        public Short getSpeed() {
            return Speed;
        }

        public void setMaxHP(Short MaxHP) {
            this.MaxHP = MaxHP;
        }

        public Short getMaxHP() {
            return MaxHP;
        }

        public void setTempHP(Short TempHP) {
            this.TempHP = TempHP;
        }

        public Short getTempHP() {
            return TempHP;
        }
    }

    public static final class RaceModel {
        private Short RaceID;
        private String RaceName;

        public void setRaceID(Short RaceID) {
            this.RaceID = RaceID;
        }

        public Short getRaceID() {
            return RaceID;
        }

        public void setRaceName(String RaceName) {
            this.RaceName = RaceName;
        }

        public String getRaceName() {
            return RaceName;
        }
    }

    public static final class ClassModel {
        private Short ClassID;
        private String ClassName;

        public void setClassID(Short ClassID) {
            this.ClassID = ClassID;
        }

        public Short getClassID() {
            return ClassID;
        }

        public void setClassName(String ClassName) {
            this.ClassName = ClassName;
        }

        public String getClassName() {
            return ClassName;
        }
    }

    public static final class AlignmentModel {
        private Short AlignmentID;
        private String Alignment;

        public void setAlignment(Short AlignmentID) {
            this.AlignmentID = AlignmentID;
        }

        public Short getAlignmentID() {
            return AlignmentID;
        }

        public void setAlignmentName(String Alignment) {
            this.Alignment = Alignment;
        }

        public String getAlignmentName() {
            return Alignment;
        }
    }

    public static final class GenderModel {
        private Short GenderID;
        private String GenderName;

        public void setGenderID(Short GenderID) {
            this.GenderID = GenderID;
        }

        public Short getGenderID() {
            return GenderID;
        }

        public void setGenderName(String GenderName) {
            this.GenderName = GenderName;
        }

        public String getGenderName() {
            return GenderName;
        }
    }

    public static final class ProficiencyModel {
        private Short ProficiencyID;

        //Strength
        private Boolean StrengthSavingThrow;
        private Boolean Athletics;

        //Dexterity
        private Boolean DexteritySavingThrow;
        private Boolean Acrobatics;
        private Boolean SleightOfHand;
        private Boolean Stealth;

        //Constitution
        private Boolean ConstitutionSavingThrow;

        //Intelligence
        private Boolean IntelligenceSavingThrow;
        private Boolean Arcana;
        private Boolean History;
        private Boolean Investigation;
        private Boolean Nature;
        private Boolean Religion;

        //Wisdom
        private Boolean WisdomSavingThrow;
        private Boolean AnimalHandling;
        private Boolean Insight;
        private Boolean Medicine;
        private Boolean Perception;
        private Boolean Survival;

        //Charisma
        private Boolean CharismaSavingThrows;
        private Boolean Deception;
        private Boolean Intimidation;
        private Boolean Performance;
        private Boolean Persuasion;

        public void setProficiencyID(Short ProficiencyID) {
            this.ProficiencyID = ProficiencyID;
        }

        public Short getProficiencyID() {
            return ProficiencyID;
        }

        public void setStrengthSavingThrow(Boolean StrengthSavingThrow) {
            this.StrengthSavingThrow = StrengthSavingThrow;
        }

        public Boolean getStrengthSavingThrow() {
            return StrengthSavingThrow;
        }

        public void setAthletics(Boolean Athletics) {
            this.Athletics = Athletics;
        }

        public Boolean getAthletics() {
            return Athletics;
        }

        public void setDexteritySavingThrow(Boolean DexteritySavingThrow) {
            this.DexteritySavingThrow = DexteritySavingThrow;
        }

        public Boolean getDexteritySavingThrow() {
            return DexteritySavingThrow;
        }

        public void setAcrobatics(Boolean Acrobatics) {
            this.Acrobatics = Acrobatics;
        }

        public Boolean getAcrobatics() {
            return Acrobatics;
        }

        public void setSleightOfHand(Boolean SleightOfHand) {
            this.SleightOfHand = SleightOfHand;
        }

        public Boolean getSleightOfHand() {
            return SleightOfHand;
        }

        public void setStealth(Boolean Stealth) {
            this.Stealth = Stealth;
        }

        public Boolean getStealth() {
            return Stealth;
        }

        public void setConstitutionSavingThrow(Boolean ConstitutionSavingThrow) {
            this.ConstitutionSavingThrow = ConstitutionSavingThrow;
        }

        public Boolean getConstitutionSavingThrow() {
            return ConstitutionSavingThrow;
        }

        public void setIntelligenceSavingThrow(Boolean IntelligenceSavingThrow) {
            this.IntelligenceSavingThrow = IntelligenceSavingThrow;
        }

        public Boolean getIntelligenceSavingThrow() {
            return IntelligenceSavingThrow;
        }

        public void setArcana(Boolean Arcana) {
            this.Arcana = Arcana;
        }

        public Boolean getArcana() {
            return Arcana;
        }

        public void setHistory(Boolean History) {
            this.History = History;
        }

        public Boolean getHistory() {
            return History;
        }

        public void setInvestigation(Boolean Investigation) {
            this.Investigation = Investigation;
        }

        public Boolean getInvestigation() {
            return Investigation;
        }

        public void setNature(Boolean Nature) {
            this.Nature = Nature;
        }

        public Boolean getNature() {
            return Nature;
        }

        public void setReligion(Boolean Religion) {
            this.Religion = Religion;
        }

        public Boolean getReligion() {
            return Religion;
        }

        public void setWisdomSavingThrow(Boolean WisdomSavingThrow) {
            this.WisdomSavingThrow = WisdomSavingThrow;
        }

        public Boolean getWisdomSavingThrow() {
            return WisdomSavingThrow;
        }

        public void setAnimalHandling(Boolean AnimalHandling) {
            this.AnimalHandling = AnimalHandling;
        }

        public Boolean getAnimalHandling() {
            return AnimalHandling;
        }

        public void setInsight(Boolean Insight) {
            this.Insight = Insight;
        }

        public Boolean getInsight() {
            return Insight;
        }

        public void setMedicine(Boolean Medicine) {
            this.Medicine = Medicine;
        }

        public Boolean getMedicine() {
            return Medicine;
        }

        public void setPerception(Boolean Perception) {
            this.Perception = Perception;
        }

        public Boolean getPerception() {
            return Perception;
        }

        public void setSurvival(Boolean Survival) {
            this.Survival = Survival;
        }

        public Boolean getSurvival() {
            return Survival;
        }

        public void setCharismaSavingThrows(Boolean CharismaSavingThrows) {
            this.CharismaSavingThrows = CharismaSavingThrows;
        }

        public Boolean getCharismaSavingThrows() {
            return CharismaSavingThrows;
        }

        public void setDeception(Boolean Deception) {
            this.Deception = Deception;
        }

        public Boolean getDeception() {
            return Deception;
        }

        public void setIntimidation(Boolean Intimidation) {
            this.Intimidation = Intimidation;
        }

        public Boolean getIntimidation() {
            return Intimidation;
        }

        public void setPerformance(Boolean Performance) {
            this.Performance = Performance;
        }

        public Boolean getPerformance() {
            return Performance;
        }

        public void setPersuasion(Boolean Persuasion) {
            this.Persuasion = Persuasion;
        }

        public Boolean getPersuasion() {
            return Persuasion;
        }
    }

    public static Models.StatsModel setStatsModel(String strength, String dexterity, String constitution, String intelligence, String wisdom, String charisma) {
        Models.StatsModel statsModel = new Models.StatsModel();

        strength = Utilities.isWholeNumber(strength) ? strength : "0";
        dexterity = Utilities.isWholeNumber(dexterity) ? dexterity : "0";
        constitution = Utilities.isWholeNumber(constitution) ? constitution : "0";
        intelligence = Utilities.isWholeNumber(intelligence) ? intelligence : "0";
        wisdom = Utilities.isWholeNumber(wisdom) ? wisdom : "0";
        charisma = Utilities.isWholeNumber(charisma) ? charisma : "0";

        statsModel.setStrength(Short.parseShort(strength));
        statsModel.setDexterity(Short.parseShort(charisma));
        statsModel.setConstitution(Short.parseShort(constitution));
        statsModel.setIntelligence(Short.parseShort(dexterity));
        statsModel.setWisdom(Short.parseShort(intelligence));
        statsModel.setCharisma(Short.parseShort(wisdom));

        return statsModel;
    }

    public static Models.ClassModel setClassModel(String className) {
        Models.ClassModel classModel = new Models.ClassModel();

        classModel.setClassName(className);

        return classModel;
    }

    public static Models.RaceModel setRaceModel(String raceName) {
        Models.RaceModel raceModel = new Models.RaceModel();

        raceModel.setRaceName(raceName);

        return raceModel;
    }

    public static Models.GenderModel setGenderModel(String genderName) {
        Models.GenderModel genderModel = new Models.GenderModel();

        genderModel.setGenderName(genderName);

        return genderModel;
    }

    public static Models.AlignmentModel setAlignmentModel(String alignmentName) {
        Models.AlignmentModel alignmentModel = new Models.AlignmentModel();

        alignmentModel.setAlignmentName(alignmentName);

        return alignmentModel;
    }

    public static Models.SecondaryStatsModel setSecondaryStatsModel(String armorClass, String initiative, String speed, String maxHP, String tempHP) {
        Models.SecondaryStatsModel secondaryStatsModel = new Models.SecondaryStatsModel();

        armorClass = Utilities.isWholeNumber(armorClass) ? armorClass : "0";
        initiative = Utilities.isWholeNumber(initiative) ? initiative : "0";
        speed = Utilities.isWholeNumber(speed) ? speed : "0";
        maxHP = Utilities.isWholeNumber(maxHP) ? maxHP : "0";
        tempHP = Utilities.isWholeNumber(tempHP) ? tempHP : "0";

        secondaryStatsModel.setArmorClass(Short.parseShort(armorClass));
        secondaryStatsModel.setInitiative(Short.parseShort(initiative));
        secondaryStatsModel.setSpeed(Short.parseShort(speed));
        secondaryStatsModel.setMaxHP(Short.parseShort(maxHP));
        secondaryStatsModel.setTempHP(Short.parseShort(tempHP));

        return secondaryStatsModel;
    }

    public static Models.ProficiencyModel setProficiencyModel(boolean hasStrengthSavingThrow, boolean hasAthletics, boolean hasDexteritySavingThrow,
                                                       boolean hasAcrobatics, boolean hasSleightOfHand, boolean hasStealth, boolean hasConstitutionSavingThrow,
                                                       boolean hasIntelligenceSavingThrow, boolean hasArcana, boolean hasHistory, boolean hasInvestigation,
                                                       boolean hasNature, boolean hasReligion, boolean hasWisdomSavingThrow, boolean hasAnimalHandling,
                                                       boolean hasInsight, boolean hasMedicine, boolean hasPerception, boolean hasSurvival, boolean hasCharismaSavingThrow,
                                                       boolean hasDeception, boolean hasIntimidation, boolean hasPerformance, boolean hasPersuasion) {

        Models.ProficiencyModel proficiencyModel = new Models.ProficiencyModel();

        proficiencyModel.setStrengthSavingThrow(hasStrengthSavingThrow);
        proficiencyModel.setAthletics(hasAthletics);

        proficiencyModel.setDexteritySavingThrow(hasDexteritySavingThrow);
        proficiencyModel.setAcrobatics(hasAcrobatics);
        proficiencyModel.setSleightOfHand(hasSleightOfHand);
        proficiencyModel.setStealth(hasStealth);

        proficiencyModel.setConstitutionSavingThrow(hasConstitutionSavingThrow);

        proficiencyModel.setIntelligenceSavingThrow(hasIntelligenceSavingThrow);
        proficiencyModel.setArcana(hasArcana);
        proficiencyModel.setHistory(hasHistory);
        proficiencyModel.setInvestigation(hasInvestigation);
        proficiencyModel.setNature(hasNature);
        proficiencyModel.setReligion(hasReligion);

        proficiencyModel.setWisdomSavingThrow(hasWisdomSavingThrow);
        proficiencyModel.setAnimalHandling(hasAnimalHandling);
        proficiencyModel.setInsight(hasInsight);
        proficiencyModel.setMedicine(hasMedicine);
        proficiencyModel.setPerception(hasPerception);
        proficiencyModel.setSurvival(hasSurvival);

        proficiencyModel.setCharismaSavingThrows(hasCharismaSavingThrow);
        proficiencyModel.setDeception(hasDeception);
        proficiencyModel.setIntimidation(hasIntimidation);
        proficiencyModel.setPerformance(hasPerformance);
        proficiencyModel.setPersuasion(hasPersuasion);

        return proficiencyModel;
    }

    public static Models.CharacterModel setCharacterModel(String characterName, String characterLevel, String characterClass,
                                                   Models.ClassModel classModel, Models.RaceModel raceModel,
                                                   Models.AlignmentModel alignmentModel, Models.GenderModel genderModel,
                                                   Models.StatsModel statsModel, Models.SecondaryStatsModel secondaryStatsModel,
                                                   Models.ProficiencyModel proficiencyModel) {

        Models.CharacterModel characterModel = new Models.CharacterModel();
        characterModel.setCharacterName(characterName);
        characterModel.setCharacterLevel(Short.parseShort(characterLevel));
        characterModel.setCharacterExperience(Integer.parseInt(characterClass));
        characterModel.setCharacterClass(classModel);
        characterModel.setRace(raceModel);
        characterModel.setAlignment(alignmentModel);
        characterModel.setGender(genderModel);
        characterModel.setStats(statsModel);
        characterModel.setSecondaryStats(secondaryStatsModel);
        characterModel.setProficiencies(proficiencyModel);

        return characterModel;
    }
}