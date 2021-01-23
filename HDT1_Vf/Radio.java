/**
 * Clase radio con los metodos acordados con el salon para cumplir con los requisitos de la asignacion y que instancia el Driver del radio
 *
 */

import java.util.Scanner;
public class Radio implements RadioGeneral{

    boolean On_Off = false;
    boolean frequency = false;
    int posicion = 0;
    Scanner scan = new Scanner(System.in);

    int[] frecuencias_AM = {530,540,550,560,570,600,610,620,640,660,680,690};
    double[] frecuencias_FM = {87.9,88.3,88.7,89.1,89.5,89.9,90.3,90.7,91.1,91.5,91.9,93.3};


    /***
     *
     * @return regresa la propiedad del radio On_Off
     */
    @Override
    public boolean isON() {
        return On_Off;
    }

    /**
     * cambia el valor de la propiedad On_Off a true
     */
    @Override
    public void encender() {
        On_Off = true;
    }

    /***
     * cambiar el valor de la propiedad On_Off a false
     */
    @Override
    public void apagar() {
        On_Off = false;
    }

    /**
     * incrementa la estacion
     */

    @Override
    public void incrementar() {
        posicion++;
        if (posicion>11){
            posicion=0;
        }

        if (frequency==false){
            System.out.println(frecuencias_AM[posicion]);
        }else {
            System.out.println(frecuencias_FM[posicion]);
        }

    }

    /**
     *
     * @param num emisora que se guardara en uno de los espacios (AM o FM)
     * @return
     */

    @Override
    public boolean asignar(int num) {
        System.out.println("    Ingresa la emisora que deseas guardar\n");
        System.out.println("    Se mostraran la lista actual\n");
        if(frequency==false){
            System.out.println("    Estas en AM");
            try{
                for (int i=0;i<12;i++){
                    System.out.println(frecuencias_AM[i]);
                }
                System.out.println("\n");
                int emi = Integer.parseInt(scan.nextLine());
                if(emi>530&&emi<1610){
                    frecuencias_AM[num-1]=emi;
                }else {
                    System.out.println("Tiene que estar entre 531 y 1609");
                }

            }catch (Exception e){
                System.out.println("    Ingresa un numero entero, estas en AM");
            }

        }else if(frequency==true){
            System.out.println("    Estas en FM");
            try{
                for (int i=0;i<12;i++){
                    System.out.println(frecuencias_FM[i]);
                }
                System.out.println("\n");
                double emi = Double.parseDouble(scan.nextLine());
                if(emi>87.9&&emi<107.9){
                    frecuencias_FM[num-1]=emi;
                }else {
                    System.out.println("Tiene que estar entre 87.9 y 107.9");
                }
            }catch (Exception e){
                System.out.println("    Ingresa un numero double, estas en FM");
            }
        }

        return frequency;
    }

    @Override
    public boolean emisora(int num) {

        if(frequency==false){
            for (int i=0;i<12;i++){
                System.out.println(frecuencias_AM[i]);
            }
            System.out.println("\n");
            System.out.println("    Estas en AM, la frecuencia seleccionada es:");
            System.out.println(frecuencias_AM[num-1]);
        }else {
            for (int i=0;i<12;i++){
                System.out.println(frecuencias_FM[i]);
            }
            System.out.println("\n");
            System.out.println("    Estas en FM, la frecuencia seleccionada es:");
            System.out.println(frecuencias_FM[num-1]);
        }
        return false;
    }

    @Override
    public void frecuencia() {
        if(frequency==false){
            frequency=true;
        }else if(frequency==true){
            frequency=false;
        }
    }
}

