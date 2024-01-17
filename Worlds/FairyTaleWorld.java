package Worlds;

import java.util.Random;
import Characters.AbstractCharacter;
public class FairyTaleWorld {
    private String[][] ground;
    private String[][] sky;

    public FairyTaleWorld (String[][] ground, String[][] sky){
        this.ground = ground;
        this.sky = sky;
    }

    public void addCharacter(AbstractCharacter character){
        Random random = new Random();
        int i= random.nextInt(10);
        int j= random.nextInt(10);
        ground[i][j]=character.getName();
    }

    public void moveCharacterInSky(AbstractCharacter character, int i, int j){
        Random random = new Random();
        int i1= random.nextInt(10);
        int j1= random.nextInt(10);
        sky[i+i1][j+j1]=character.getName();
        ground[i][j]="";
    }
    public void ComeBackToWorld(AbstractCharacter character){
        Random random = new Random();
        int i= random.nextInt(10);
        int j= random.nextInt(10);
        ground[i][j]=character.getName();
    }
}
