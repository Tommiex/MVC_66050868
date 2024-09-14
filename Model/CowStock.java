package Model;

import java.util.ArrayList;
import java.util.Random;

public class CowStock {

    private static ArrayList<Cow> stock = new ArrayList<>();
    private static int size = 0;
    private static int MINSIZE = 10;

    static {
        // Add Cow to stock
        Random rand = new Random();
        ArrayList<String> color = colorGen();
        for (int i = 0; i < MINSIZE; i++) {
            int age = rand.nextInt(11) ;
            if(color.get(i) == "white"){
                WhiteCow cow = new WhiteCow(idGen(), color.get(i), age);
                stock.add(cow);
            }else{
                BrownCow cow = new BrownCow(idGen(), color.get(i), age);
                stock.add(cow);
            }
        }

        size = stock.size();
    }

    static int idGen() {
        Random rand = new Random();

        int firstDigit = rand.nextInt(9) + 1;
        int remainingDigits = rand.nextInt(10000000);
        int id = firstDigit * 10000000 + remainingDigits;

        return id;
    }

    static ArrayList<String> colorGen() {
        Random rand = new Random();
        ArrayList<String> colorArr = new ArrayList<>();
        int b = 0;
        int w = 0;
        for (int i = 0; i < MINSIZE; i++) {
            int chance = rand.nextInt(9);
            if (i >= 6) {
                if (b < 3) {
                    colorArr.add("brown");
                    b+=1;
                    continue;

                } else if (w < 3) {
                    colorArr.add("white");
                    w += 1;
                    continue;
                }
            }
            if (chance % 2 == 0) {
                colorArr.add("brown");
                b += 1;
            } else {
                colorArr.add("white");
                w += 1;
            }

        }
        return colorArr;

    }

    public static int getSize() {
        return size;
    }

    public static void setStock(ArrayList<Cow> stock) {
        CowStock.stock = stock;
        size = stock.size();
    }

    public static ArrayList<Cow> getStock() {
        return stock;
    }

}
