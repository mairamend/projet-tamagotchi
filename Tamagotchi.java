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
    public boolean ageLimite(){
        return this.age == this.dureeDeVie;
    }
    public boolean vivre(){
        if (this.age == this.dureeDeVie)
            return true;
        if (this.energie <= 0 ){
            System.out.printf("%s : je meurs !%n",this.nom);
             return  false;
        }else{
            this.age += 1;
            this.energie -= 1;
            if(this.ageLimite())
                System.out.printf("%s : c'est gagné pour moi%n",this.nom);
            else
                this.parler();
            return  true;
        }
           
    }

}