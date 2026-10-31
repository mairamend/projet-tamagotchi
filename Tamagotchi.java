import java.util.Random;
public class Tamagotchi{
    private String nom;
    private  int age;
    private int dureeDeVie ;
    private int maxEnergie;
    private int energie;
    public Tamagotchi(String nom){
        Random rand = new Random();
        this.nom = nom;
        this.age = 0;
        this.dureeDeVie = rand.nextInt(9,15); 
        this.maxEnergie = rand.nextInt(5,10);
        this.energie = rand.nextInt(3,maxEnergie + 1);
    }
}