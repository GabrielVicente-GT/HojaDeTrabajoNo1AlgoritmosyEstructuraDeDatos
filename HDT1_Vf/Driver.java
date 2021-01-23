/***
 * @author Gabriel Alejandro Vicente Lorenzo
 * @author Jose Diaz
 */

import java.lang.invoke.SwitchPoint;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args){

        /**
         * instancias de radio y scanner para interactuar con el usuario y usar los metodos de radio entre otros
         */

        Radio sonora = new Radio();
        Scanner scan = new Scanner(System.in);
        boolean ciclo_main = true;

        /**
         * Prints para la interfaz con el usuario
         */

        System.out.println("\n______________________-----------------------------------______________________");
        System.out.println("______________________---------------Radio------" +
                "" +
                "---------______________________");
        System.out.println("______________________-----------------------------------______________________\n\n");

        /**+
         * ciclo principal que controla la radio
         */

        while ( ciclo_main == true) {
            try {
            System.out.println("    1. Prende el radio");
            System.out.println("    2. Cambiar frecuencia (A.M. - F.M.)");
            System.out.println("    3. Avanzar una emisora");
            System.out.println("    4. Guardar emisora (12 espacios)");
            System.out.println("    5. Seleccionar emisora en un boton");
            System.out.println("    6. Apagar radio");

            int option = Integer.parseInt(scan.nextLine());


            switch (option){

                /**
                 * Opcion 1 que enciende la radio
                 */

                case 1: System.out.println("opcion 1\n");

                if(sonora.isON()==false){
                    sonora.encender();
                    System.out.println("    Se ha encendido la radio\n");
                }else if(sonora.isON()==true){
                    System.out.println("    La radio ya se encuentra encendida\n");
                }
                break;

                /**
                 * Opcion 2 que cambia la frecuencia
                 */

                case 2: System.out.println("opcion 2\n");

                if(sonora.isON()==false){

                    System.out.println("    La radio esta apagada, enciendela antes de hacer cualquier accion.\n");
                }else if(sonora.isON()==true){
                    sonora.frecuencia();
                    System.out.println("    Se ha cambiado la frecuencia de la radio\n");
                }
                break;

                /**
                 * Opcion 3 Avanza en la posicion de las emisoras
                 */

                case 3: System.out.println("opcion 3\n");

                if(sonora.isON()==false){

                    System.out.println("    La radio esta apagada, enciendela antes de hacer cualquier accion.\n");
                }else if(sonora.isON()==true){
                    System.out.println("    Haz avanzado en el dial de emisoras. Frecuencia actual:\n");
                    sonora.incrementar();
                }

                break;

                /***
                 * Opcion 4 Pide al usuario la posicion y la emisora a guardar
                 */

                case 4: System.out.println("opcion 4\n");

                if(sonora.isON()==false){

                    System.out.println("    La radio esta apagada, enciendela antes de hacer cualquier accion.\n");
                }else if(sonora.isON()==true){
                    System.out.println("    Ingresa en que posicion la deseas guardar (Recuerda en que frecuencia estas)");
                    int posicion_e = 0;
                    try{
                        posicion_e = Integer.parseInt(scan.nextLine());
                    }catch (Exception e){
                        System.out.println("    Ingresa un numero entero\n");
                    }

                    if(posicion_e<13&&posicion_e>0){

                        sonora.asignar(posicion_e);
                        System.out.println("    Se ha finalizdo la accion\n");
                    }else{
                        System.out.println("    Solo cuentas con 12 espacios\n");
                    }
                }



                break;

                /**
                 * Opcion 5 Permite seleccionar la emisora que se desea escuchar
                 */

                case 5: System.out.println("opcion 5\n");

                if(sonora.isON()==false){

                    System.out.println("    La radio esta apagada, enciendela antes de hacer cualquier accion.\n");
                }else if(sonora.isON()==true){
                    System.out.println("    Seleeciona la emisora de uno de los 12 botones, recuerda en que frecuencia estas\n");
                    try{
                        int seleccionar = Integer.parseInt(scan.nextLine());
                        if (seleccionar>0&&seleccionar<13){
                            System.out.println("    Lista de emisoras:");
                            sonora.emisora(seleccionar);
                        }else {
                            System.out.println("    Solo cuentas con 12 espacio");
                        }

                    }catch (Exception e){
                        System.out.println("    ingresa un numero entero");
                    }
                }

                break;

                case 6: System.out.println("opcion 6\n");

                if(sonora.isON()==true){
                    sonora.apagar();
                    System.out.println("    Se ha apagado la radio\n");
                }else if(sonora.isON()==false){
                    System.out.println("    La radio ya se encuentra apagada\n");
                }
                break;

                default:System.out.println("opcion no encontrada\n");
                break;

                }

            }catch (Exception e){
                System.out.println("opcion no encontrada\n");
            }

        }


    }
}
