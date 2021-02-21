package ejercicio2;

import java.io.*;

public class Main {
    
    public static void main (String[] args) throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        
        AdministradorEmpleados adminEmpleados = new AdministradorEmpleados();
        
        boolean ejecutando = true;
        while (ejecutando){
            System.out.println("Menu principal");
            System.out.println();
            System.out.println("1. Agregar empleado");
            System.out.println("2. Eliminar empleado");
            System.out.println("3. Actualizar empleado");
            System.out.println("4. Mostrar todos los empleados");
            System.out.println("5. Salir");
            System.out.println();
            System.out.println("Indique la opción que desea ejecutar: ");

            String strOpcion = reader.readLine();
            int opcion;
            try{
                opcion = Integer.parseInt(strOpcion);
            }catch(NumberFormatException e){
                opcion = 0;
            }

            switch (opcion){
                case 1:
                    adminEmpleados.agregarEmpleado();
                    break;
                case 2:
                    adminEmpleados.eliminarEmpleado();
                    break;
                case 3:
                    adminEmpleados.actualizarEmpleado();
                    break;
                case 4:
                    adminEmpleados.mostrarTodosLosEmpleados();
                    break;
                case 5:
                    System.out.println("Fin del programa");
                    ejecutando = false;
                    break;
                default:
                    System.out.println("La opción indicada no es valida, intente nuevamente");
                    System.out.println();
                    break;    
            }            
        }
    }
    
    
}
