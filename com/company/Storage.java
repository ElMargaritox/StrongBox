package com.company;

public class Storage{
    private String name;
    private int amount;

    public Storage(String name, int cantidad){
        this.name = name;
        this.amount = cantidad;
        System.out.println("Se Ha Guardado: " + name + " [" + getAmount() + "]");
    }

    public void AddCantidad(int cantidad){
        this.amount = this.getAmount() + cantidad;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }
}
