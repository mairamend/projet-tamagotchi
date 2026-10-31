import java.util.Random;
public class Tamagotchi{
    private String nom;
    private  int age;
    private int dureeDeVie ;
    private int maxEnergie;
    private int energie;
    Random rand = new Random();
    public Tamagotchi(String nom){
       
        this.nom = nom;
        this.age = 0;
        this.dureeDeVie = rand.nextInt(9,15); 
        this.maxEnergie = rand.nextInt(5,10);
        this.energie = rand.nextInt(3,maxEnergie + 1);
    }
    public void parler(){
        String etat = this.energie > 5 ? "heureux" : "affamé";
        System.out.printf("%s : je suis %s%n",this.nom,etat);
    }
    public void manger(){
        
        if(this.energie >= this.maxEnergie){
            System.out.printf("%s : je n'ai pas faim !!%n",this.nom);
        }else{
            this.energie += rand.nextInt(1,4);
            if(this.energie > this.maxEnergie)
                this.energie = this.maxEnergie;
            System.out.printf("%s : Merci !%n",this.nom);
        }
    }
    public static void main(String[] args) {
        Tamagotchi t = new Tamagotchi("Zal");
        Tamagotchi t1 = new Tamagotchi("Quenn");
        t.parler();
        t1.parler();
    }
}