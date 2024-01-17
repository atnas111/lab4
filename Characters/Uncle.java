package Characters;

import Enums.*;
import Interfaces.Impressionable;
import Worlds.FairyTaleWorld;

import java.util.Objects;

public class Uncle extends AbstractCharacter implements Impressionable {
    private int happinessLevel;
    private Marriagestatus marriagestatus;
    public Uncle(String name, Gender gender, double weight, double height, int happinessLevel, Marriagestatus marriagestatus) {
        super(name, gender, weight, height);

        this.happinessLevel = HappinessLevels.HIGH.getHappinessLevel();
        this.marriagestatus = marriagestatus;
    }

    @Override
    public void beHappy(Day day){
        if(day == Day.YESTERDAY){
            String happy = "Дядя Юлиус был очень весел и счастлив.";
            happinessLevel+=1;
            System.out.println(happy);
        }
        if(day == Day.TODAY){
            String happy = "Дядя Юлиус повторял, что счастлив очень-очень сильно.";
            happinessLevel+=2;
            System.out.println(happy);
        }
    }

    public void setHappinessLevel(int happinessLevel) {
        this.happinessLevel = happinessLevel;
    }

    public int getHappinessLevel(){
        return happinessLevel;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (this.getClass()!=object.getClass()){
            return false;
        }
        Uncle uncle = (Uncle) object;
        return Objects.equals(getName(), uncle.getName()) && Objects.equals(getWeight(), uncle.getWeight()) && Objects.equals(getHeight(), uncle.getHeight());
    }

    @Override
    public String toString() {
        return getName();
    }

    public void beStubborn() {
        happinessLevel-=1;
        System.out.print("Дядя Юлиус был упрям. ");
    }


    public void thankTo(PropellerMan propellerMan, Uncle uncle){
        if (propellerMan.getName()=="Карлсон") {
            uncle.setWeight(getWeight()-1);
            happinessLevel += 1;
            System.out.println("Дядя Юлиус поблагодарил Карлсона.");
        }
    }
    public void beAfraid(Witch witch){
        if (witch.getFlyheight()==0){
            happinessLevel-=1;
            System.out.println("Он испугался летающей ведьмы.");
        }
    }
    public void goToWorld(Time time, FairyTaleWorld fairyTaleWorld, Uncle uncle){

        if (time == Time.NOW){
            fairyTaleWorld.addCharacter(uncle);
            System.out.println("Ему открылся замечательный мир сказок.");
        }
        if (time == Time.FUTURE){
            fairyTaleWorld.ComeBackToWorld(uncle);
            System.out.println("Он снова окунулся в мир пердков.");
        }
    }
    public Marriagestatus getMarriagestatus(){
        return marriagestatus;
    }
    public void setMarriagestatus(Marriagestatus marriagestatus){
        this.marriagestatus = marriagestatus;
    }
    public class BrainHealth {
        private int HealthPoints = 67;

        public void setHealthPoints(int HealthPonts){
            this.HealthPoints = HealthPonts;
        }
        public int getHealthPoints(){
            return HealthPoints;
        }
        public void isIll(int HealthPoints){
            if(HealthPoints<70) {
                System.out.println("С дядей что-то не так. Нужен доктор.");
                this.HealthPoints+=10;
            }
            else {
                System.out.println("Дядя полностью в порядке");
            }
        }
    }
}
