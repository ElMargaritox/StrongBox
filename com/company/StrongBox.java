package com.company;

import java.util.ArrayList;
import java.util.List;

public class StrongBox extends Password{
    private List<Storage> storageList = new ArrayList<>();



    public void addElement(String name, int amount){
        Boolean sobrescrito = false;
        for (Storage storage : storageList){
            if(name.equals(storage.getName())){
                storage.AddCantidad(amount);
                System.out.println("Se Ha Sobrescrito " + name + ", porque ya existia, pero se añadio la cantidad [" + amount + "]");
                sobrescrito = true;
            }
        }

        if(!sobrescrito){
            storageList.add(new Storage(name, amount));
        }

    }

    public void removeElement(String name){
        Boolean borrado = false;
        for (Storage storage : storageList){
            if(name.equals(storage.getName())){
                storageList.remove((storage));
                System.out.println("Se Ha Removido El Elemento Correctamente");
                borrado = true; break;
            }
        }

        if(!borrado){
            System.out.println("No Se Encontro Ningun Elemento. Revíse el nombre y vuelva a intentarlo");
        }
    }

    public void showElements(){

        if(storageList.size() <= 0){
            System.out.println("No Se Han Encontrado Elementos Dentro De La Caja Fuerte");
        }else{
            System.out.println("Dentro De La Caja Fuerte");
            System.out.println("----------------------");
            for(Storage storage : storageList){

                System.out.println("Nombre: " + storage.getName() + " Cantidad: " + storage.getAmount());

            }
            System.out.println("----------------------");
        }

    }


    @Override
    public void setPassword(String password) {


        super.setPassword(password);
    }

    @Override
    public void changePassword(String password) {
        super.changePassword(password);
    }

    @Override
    public void generatePassword(String psw) {
        super.generatePassword(psw);
    }

    @Override
    public String getPassword() {
        return super.getPassword();
    }
}
