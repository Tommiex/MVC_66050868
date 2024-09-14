package Model;

import java.util.Random;

public class WhiteCow extends Cow{

    public WhiteCow(int id, String color, int age) {
        super(id, color, age);
        
        //TODO Auto-generated constructor stub
    }
    @Override
    public String getMilk(){
        Random random = new Random();
        
        double chance = random.nextDouble();
        double per =  0.005 *this.getAge();
        if(!isDrinkLemon){
            if(chance <= per){
                this.setColor("Blue");
                return "Soy milk";
                
            }else{
                return "Plain milk";
            }
        }
        return "Plain milk";
    }
}
