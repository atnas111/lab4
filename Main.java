import Characters.*;
import Enums.*;
import Exceptions.FailMarriage;
import Exceptions.FlightBanWitch;
import Interfaces.MarriagePredicate;
import Worlds.FairyTaleWorld;


public class Main {
    public static void main(String[] args) {
        Uncle uncle = new Uncle("Дядя Юлиус", Gender.MALE, 70, 185, HappinessLevels.DEFAULT.getHappinessLevel(), Marriagestatus.SINGLE);
        PropellerMan carlson = new PropellerMan("Карлсон", Gender.MALE, 50, 140, 0);
        Witch witch = new Witch("Ведьма", Gender.FEMALE, 108, 167, 0);
        Princess princess = new Princess("Принцесса", Gender.FEMALE, 57, 160, Marriagestatus.SINGLE);
        String[][] ground = new String[10][10];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                ground[i][j]="";
            }
        }
        String[][] sky = new String[10][10];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                sky[i][j]="";
            }
        }
        FairyTaleWorld fairyTaleWorld = new FairyTaleWorld(ground, sky);
        uncle.beHappy(Day.YESTERDAY);

        //ведьма пытается взлететь
        try {
            witch.flyPastTheWindow(fairyTaleWorld, witch);
        }
        catch (FlightBanWitch e){
            System.out.println(e.getMessage());
        }


        princess.beConquered(uncle, princess);
        //пробуют пожениться
        try {
            princess.beMarriaged(uncle);
        }
        catch (FailMarriage e){
            System.out.println(e.getMessage());
        }

        //анонимный класс, проверяющий, состоялась ли свадьба
        MarriagePredicate MarriageTest = new MarriagePredicate() {

            @Override
            public boolean test(Princess princess) {
                if(princess.getMarriagestatus()==Marriagestatus.MARRIED){
                    return true;
                }
                else {
                    return false;
                }
            }
        };
        if(MarriageTest.test(princess)){
            System.out.println("Свадьба прошла успешно.");
        }
        else{
            System.out.println("Свадьба не состоялась.");
        }
    }
}