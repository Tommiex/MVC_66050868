package Model;

import java.util.Random;

public class BrownCow extends Cow{

    public BrownCow(int id, String color, int age) {
        super(id, color, age);
        //TODO Auto-generated constructor stub
    }
    @Override
    public String getMilk(){
        Random random = new Random();
        
        double chance = random.nextDouble();
        double per =  0.01 *this.getAge();
        if(chance <= per){
            this.setColor("Blue");
            return "Almond milk";
        }else{
            return "Chocolate milk";
        }
    }
}
