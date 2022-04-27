package com.agentred.lessons.lesson11;

import com.agentred.lessons.lesson11.fruit.Fruit;

import java.util.LinkedList;
import java.util.List;

public class Box<T extends Fruit> {

    private final List<T> listOfProduct = new LinkedList<>();

    public void setProduct(T fruit) {
        listOfProduct.add(fruit);
    }

    public List<T> getListOfProduct() {
        return listOfProduct;
    }

    public float getWeight() {
        if (!listOfProduct.isEmpty()) {
            T fruit = listOfProduct.get(0);
            return listOfProduct.size() * fruit.getWeight();
        } else return 0;
    }

    public boolean compare(Box<? extends Fruit> o) {
        return Math.abs(this.getWeight() - o.getWeight()) < 0.1f;
    }


}
