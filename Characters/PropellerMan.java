package Characters;

import Enums.Gender;
import Interfaces.Flyable;

public class PropellerMan extends AbstractCharacter implements Flyable {
    private int flyheight;

    public PropellerMan(String name, Gender gender, double weight, double height) {
        super(name, gender, weight, height);
    }

    public PropellerMan(String name, Gender gender, double weight, double height, int flyheight) {
        super(name, gender, weight, height);
        this.flyheight = flyheight;
    }

    @Override
    public void fly(int flyheight) {
        this.flyheight = 10;
        System.out.println("Карлсон запустил пропеллер");
    }
}
