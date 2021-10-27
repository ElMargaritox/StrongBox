package com.company;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;

public class Main {

    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
	    StrongBox caja = new StrongBox(); // instancia la caja
	    if(caja.getPassword() == "" || caja.getPassword() == null){ // Comprueba que la contraseña exísta,


	        // Generar Contraseñas o Escribirlas Manualmente
            System.out.println("No se ha detectado una contraseña...");
            if(usarGenerador()){
                caja.generatePassword("");
                System.out.println("La contraseña generada es: " + caja.getPassword());
            }else{
                System.out.println("Introduce la contraseña: ");
                caja.setPassword(scanner.next());
            }


            MenuCajaFuerte(caja);


        }
    }

    public static void MenuCajaFuerte(StrongBox caja){
        Boolean salirglobal = false;
        do{

        System.out.println("-=CAJA FUERTE=- ");
        System.out.println("1 - Agregar elemento");
        System.out.println("2 - Remover elemento");
        System.out.println("3 - Ver contenido de caja");
        System.out.println("4 - Cambiar Contraseña");
        System.out.println("5 - Salir");
        int opcion = scanner.nextInt();

        switch(opcion){
            case 1:
                Boolean salir = false;
                System.out.println("Ingresa El Nombre Del Elemento: ");
                String _name = scanner.next();
                int _cantidad = 0;
                do {
                    try{
                        System.out.println("Ingresa La Cantidad Del Elemento " + _name + ": ");_cantidad = scanner.nextInt();
                        salir = true;
                    }catch(java.util.InputMismatchException e){
                        System.out.println("Ingresa Nuevamente La Cantidad Del Elemento" );scanner.nextLine(); // Limpia el buffer
                    }
                    finally{
                        caja.addElement(_name, _cantidad);
                    }
                }while(!salir);
                break;
            case 2:
                System.out.println("Ingresa El Nombre Del Elemento a borrar (Respeta Mayusculas, Minusculas): ");caja.removeElement(scanner.next());
                break;
            case 3:
                caja.showElements();
                break;
            case 4:
                System.out.println("Ingresa la contraseña actual:");
                String _pdw = scanner.next();
                if(_pdw.equals(caja.getPassword())){
                    System.out.println("Contraseña Nueva: ");
                    caja.changePassword(scanner.next());
                }else{
                    System.out.println("Contraseña Incorrecta");
                }
                break;
            case 5:
                salirglobal = true;
                break;
        }
        }while(!salirglobal);

    }


    public static Boolean usarGenerador(){
        System.out.println("¿Desea Usar El Generador? (s/n)");
        // Pasa los caracteres a minusculas y obtiene la primera letra del texto para poder realizar la comprobacion
        char opcion = scanner.nextLine().toLowerCase().charAt(0);


        if(opcion == 's') { // Comprueba si la primera letra es una s, si es S manda true
            return true;
        }else if(opcion == 'n'){ // Comprueba si la primera letra es una n, si es N manda false
            return false;
        }else{ // Por Descarte, Utiliza la tecnica vista en clase y repite sin usar un while.
            usarGenerador();
        }
        return false;
    }
}
