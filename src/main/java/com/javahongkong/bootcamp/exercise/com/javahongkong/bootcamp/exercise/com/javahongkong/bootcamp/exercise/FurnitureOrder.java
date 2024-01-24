package com.javahongkong.bootcamp.exercise.com.javahongkong.bootcamp.exercise.com.javahongkong.bootcamp.exercise;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    HashMap<Furniture, Integer> ordersOfFurnitures;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */
    public FurnitureOrder() {
        this.ordersOfFurnitures = new HashMap<>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        if (this.ordersOfFurnitures.containsKey(type))
            this.ordersOfFurnitures.put(type,
                    this.ordersOfFurnitures.get(type) + furnitureCount);
        else
            this.ordersOfFurnitures.put(type, furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return this.ordersOfFurnitures;
    }

    public float getTotalOrderCost() {
        Float sum = 0f;
        for (Map.Entry<Furniture, Integer> f : ordersOfFurnitures.entrySet())
            sum += f.getKey().cost() * f.getValue();
        return sum;
    }

    public int getTypeCount(Furniture type) {
        if (!this.ordersOfFurnitures.containsKey(type))
            this.ordersOfFurnitures.put(type, 0);

        return this.ordersOfFurnitures.get(type);
    }

    public float getTypeCost(Furniture type) {
        if (!this.ordersOfFurnitures.containsKey(type))
            this.ordersOfFurnitures.put(type, 0);

        return this.ordersOfFurnitures.get(type) * type.cost();
    }

    public int getTotalOrderQuantity() {
        int sum = 0;
        for (Map.Entry<Furniture, Integer> f : ordersOfFurnitures.entrySet())
            sum += f.getValue();
        return sum;
    }

    public static void main(String[] args) {
        FurnitureOrder f1 = new FurnitureOrder();
        f1.addToOrder(Furniture.CHAIR, 10);
        System.out.println(f1.getTotalOrderCost());
        System.out.println(f1.getTotalOrderQuantity());
        System.out.println(f1.getTypeCost(Furniture.CHAIR));
        System.out.println(f1.getTypeCost(Furniture.COUCH));
        System.out.println(f1.getTypeCount(Furniture.CHAIR));
        System.out.println(f1.getTypeCount(Furniture.COUCH));



    }
}
