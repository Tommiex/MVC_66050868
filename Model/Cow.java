package Model;

public class Cow{
    private int id;
    private String color;
    private int age;
    public boolean isShown;
    public int numberOfMilk;
    public boolean isDrinkLemon;
    public String realColor; 
    public Cow(int id,String color,int age){
        this.id = id;
        this.color = color;
        this.age = age;
        isShown = false;
        numberOfMilk = 0;
        isDrinkLemon = false;
    }
    public String getMilk(){
        return "S";
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
