package Characters;

import Enums.Gender;
import Exceptions.FlightBanWitch;
import Interfaces.FlyWindowable;
import Worlds.FairyTaleWorld;

import java.util.Objects;

public class Witch extends AbstractCharacter implements FlyWindowable {
    private String name;
    private int flyheight;
    public Witch(String name, Gender gender, double weight, double height){
        super(name, gender, weight, height);
    }
    public Witch(String name, Gender gender, double weight, double height, int flyheight){
        super(name, gender, weight, height);
        this.flyheight = flyheight;
    }
    public void flyPastTheWindow(FairyTaleWorld fairyTaleWorld, Witch witch) throws FlightBanWitch {
        if(getWeight()<=101) {
            fairyTaleWorld.moveCharacterInSky(witch, 0, 0);
            flyheight += 2;
            System.out.println("Мимо окна пролетает ведьма.");
        }
        else {
            throw new FlightBanWitch();
        }
    }
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public boolean equals(Object object){
        if (this == object){
            return true;
        }
        if (this.getClass()!=object.getClass()){
            return false;
        }
        Witch witch = (Witch) object;
        return Objects.equals(name, witch.name) && Objects.equals(getWeight(), witch.getWeight()) && Objects.equals(getHeight(), witch.getHeight());
    }

    @Override
    public String toString() {
        return name;
    }
    public int getFlyheight(){
        return flyheight;
    }
    public static class Broom {
        private float MaxSpeed = 20;
        public float getMaxSpeed(){
            return this.MaxSpeed;
        }
        public void setMaxSpeed(float MaxSpeed){
            this.MaxSpeed = MaxSpeed;
        }
        public void isFlyable(float MaxSpeed){
            if(MaxSpeed>=60){
                System.out.println("Метла готова к полету.");
            }
            else{
                System.out.println("Метла сломана, нужен ремонт.");
                class Repairman {
                    Broom broom = new Broom();
                    public void repairBroom(){
                        broom.setMaxSpeed(90);
                        System.out.println("Метла восстановилась, готова к полету.");
                    }
                }
                Repairman repairman = new Repairman();
                repairman.repairBroom();
            }
        }
    }
}
