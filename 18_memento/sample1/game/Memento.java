package game;

import java.util.ArrayList;
import java.util.List;

public class Memento {
    int money;
    ArrayList<String> fruits;
    public int getMoney() {
        // narrow interface
        return money;
    }
    Memento(int money) {
        // wide interface
        this.money = money;
        this.fruits = new ArrayList<String>();
    }
    void addFruit(String fruit) {
        // wide interface
        fruits.add(fruit);
    }
    List<String> getFruits() {
        // wide interface
        return (List<String>)fruits.clone();
    }
}
