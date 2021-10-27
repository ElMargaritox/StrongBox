package com.company;

public abstract class Password {
    private String password;
    public void setPassword(String password){
        // Escríbe la contraseña.
        this.password = password;
        System.out.println("La contraseña se guardo correctamente");
    }

    public void changePassword(String password){
        this.password = password;
    }

    public void generatePassword(String psw){

        if(psw.length() >= 16){
            this.password = psw;
        }else{
            int numero = (int)(Math. random()*10+1);
            psw += numero;
            generatePassword(psw);
        }
    }

    public String getPassword() {return this.password;} // Obtíene la contraseña
}
