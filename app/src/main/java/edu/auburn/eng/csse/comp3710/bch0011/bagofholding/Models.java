package edu.auburn.eng.csse.comp3710.bch0011.bagofholding;

public class Models {
    public final class CharacterModel {
        private Short CharacterID;
        private String CharacterName;
        private Short CharacterLevel;
        private RaceModel Race;
        private ClassModel Class;
        private AlignmentModel Alignment;
        private StatsModel Stats;
        private SecondaryStatsModel SecondaryStats;
        private ProficiencyModel Proficiency;
        //private EquipmentModel Equipment;

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

        /*public void setEquipment(EquipmentModel Equipment) {
            this.Equipment = Equipment;
        }

        public EquipmentModel getEquipment() {
            return Equipment;
        }*/
    }

    public final class StatsModel {
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

    public final class SecondaryStatsModel {
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

    public final class RaceModel {
        private Short RaceID;
        private String Race;

        public void setRaceID(Short RaceID) {
            this.RaceID = RaceID;
        }

        public Short getRaceID() {
            return RaceID;
        }

        public void setRace(String Race) {
            this.Race = Race;
        }

        public String getRace() {
            return Race;
        }
    }

    public final class ClassModel {
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

    public final class AlignmentModel {
        private Short AlignmentID;
        private String Alignment;

        public void setAlignment(Short AlignmentID) {
            this.AlignmentID = AlignmentID;
        }

        public Short getAlignmentID() {
            return AlignmentID;
        }

        public void setAlignment(String Alignment) {
            this.Alignment = Alignment;
        }

        public String getAlignment() {
            return Alignment;
        }
    }

    public final class ProficiencyModel {
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

    /*public final class EquipmentModel {
        private Short EquipmentID;
        private String Equipment;

        public void setEquipmentID(Short EquipmentID) {
            this.EquipmentID = EquipmentID;
        }

        public Short getEquipmentID() {
            return EquipmentID;
        }

        public void setEquipment(String Equipment) {
            this.Equipment = Equipment;
        }

        public String getEquipment() {
            return Equipment;
        }
    }*/
}