package Characters;

import Enums.Gender;
import Enums.Marriagestatus;
import Exceptions.FailMarriage;

import java.util.Objects;

public class Princess extends AbstractCharacter {
    private String name;
    private Marriagestatus marriagestatus;
    public Princess(String name, Gender gender, double weight, double height){
        super(name, gender, weight, height);
    }
    public Princess(String name, Gender gender, double weight, double height, Marriagestatus marriagestatus){
        super(name, gender, weight, height);
        this.marriagestatus = marriagestatus;
    }

    public void beMarriaged(Uncle uncle) throws FailMarriage {
        if (uncle.getHappinessLevel()>=6){
            System.out.println("Принцесса вышла замуж за Дядю Юлиуса.");
            marriagestatus = Marriagestatus.MARRIED;
            uncle.setMarriagestatus(Marriagestatus.MARRIED);
        }
        else {
            throw new FailMarriage();
        }
    }

    public void beConquered(Uncle uncle, Princess princess){
        if (uncle.getHeight()>=0){
            System.out.println("Дядя Юлиус завоевал сердце сказочной принцессы.");
            princess.setWeight(getWeight()+5);
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
        Princess princess = (Princess) object;
        return Objects.equals(name, princess.name) && Objects.equals(getWeight(), princess.getWeight()) && Objects.equals(getHeight(), princess.getHeight());
    }

    @Override
    public String toString() {
        return name;
    }
    public Marriagestatus getMarriagestatus(){
        return marriagestatus;
    }
}