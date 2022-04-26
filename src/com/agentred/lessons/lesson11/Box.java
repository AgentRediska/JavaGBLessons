package com.agentred.lessons.lesson11;

import com.agentred.lessons.lesson11.fruit.Fruit;

import java.util.LinkedList;
import java.util.List;

public class Box<T extends Fruit> implements Comparable<Box> {

    private final List<T> listOfProduct = new LinkedList<>();

    public void setProduct(T fruit) {
        listOfProduct.add(fruit);
    }

    public List<T> getListOfProduct() {
        return listOfProduct;
    }

    public float getWeight() {
        if(!listOfProduct.isEmpty()){
            T fruit = listOfProduct.get(0);
            return listOfProduct.size() * fruit.getWeight();
        } else return 0;
    }

    @Override
    public int compareTo(Box o) {
       return  (this.getWeight() == o.getWeight()) ? 1 : 0;
    }
}
