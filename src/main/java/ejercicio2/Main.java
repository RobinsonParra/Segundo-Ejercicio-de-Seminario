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
            System.out.println("5. Mostrar empleado con mayor salario");
            System.out.println("6. Mostrar empleado con menor salario");
            System.out.println("7. Mostrar empleados ordenados por nombre");
            System.out.println("8. Suma de salarios mayores a 700000");
            System.out.println("9. Numero de empleados cuyo apellido empieza por A");
            System.out.println("10. Top 5 empleados con mayor salario");
            System.out.println();
            System.out.println("11. Salir");
            System.out.println();
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
                case 1 -> adminEmpleados.agregarEmpleado();
                case 2 -> adminEmpleados.eliminarEmpleado();
                case 3 -> adminEmpleados.actualizarEmpleado();
                case 4 -> adminEmpleados.mostrarTodosLosEmpleados();
                case 5 -> adminEmpleados.mostrarEmpleadoMayorSalario();
                case 6 -> adminEmpleados.mostrarEmpleadoMenorSalario();
                case 7 -> adminEmpleados.mostrarEmpleadosPorNombre();
                case 8 -> adminEmpleados.mostrarSumaSalariosMayoresA(700000);
                case 9 -> adminEmpleados.contarEmpleadosConApellidoPor("A");
                case 10 -> adminEmpleados.mostrarEmpleadosConMayorSalario(5);
                case 11 -> {
                    System.out.println("Fin del programa");
                    ejecutando = false;
                }
                default -> {
                    System.out.println("La opción indicada no es valida, intente nuevamente");
                    System.out.println();
                }    
            }            
        }
    }
}
