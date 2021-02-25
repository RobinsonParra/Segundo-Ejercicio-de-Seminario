package ejercicio2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class AdministradorEmpleados {
    
    private final List<Empleado> empleados = new LinkedList<>();
    
    public void agregarEmpleado() throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        
        Empleado nuevoEmpleado = new Empleado();
        
        System.out.println();
        System.out.println("Agregar Empleado");
        System.out.println();
        
        System.out.println("Id: ");
        String strId = reader.readLine();
        int id;
        try{
            id = Integer.parseInt(strId);
        }catch(NumberFormatException e){
            System.out.println("ERROR: Id debe ser un numero entero");
            System.out.println();
            return;
        }
        
        nuevoEmpleado.setId(id);
        if (empleados.contains(nuevoEmpleado)){
            System.out.println("ERROR: Ya existe un empleado con Id = " + id);
            System.out.println();
            return;
        }
        
        System.out.println("Nombre: ");
        String nombre = reader.readLine();
        nuevoEmpleado.setNombre(nombre);
        
        System.out.println("Apellido: ");
        String apellido = reader.readLine();
        nuevoEmpleado.setApellido(apellido);
        
        System.out.println("Salario: ");
        String strSalario = reader.readLine();
        int salario;
        
        try{
            salario = Integer.parseInt(strSalario);
        }catch(NumberFormatException e){
            System.out.println("ERROR: Salario debe ser un numero entero");
            System.out.println();
            return;
        }
        nuevoEmpleado.setSalario(salario);
        
        empleados.add(nuevoEmpleado);
        
        System.out.println("Se agregó el empleado: " + nuevoEmpleado);
        System.out.println();
    }
    
    public void eliminarEmpleado() throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        
        System.out.println();
        System.out.println("Eliminar Empleado");
        System.out.println();
        
        System.out.println("Id: ");
        String strId = reader.readLine();
        int id;
        try{
            id = Integer.parseInt(strId);
        }catch(NumberFormatException e){
            System.out.println("ERROR: Id debe ser un numero entero");
            System.out.println();
            return;
        }
        
        Empleado empleadoAEliminar = new Empleado();
        empleadoAEliminar.setId(id);
        
        int index = empleados.indexOf(empleadoAEliminar);
        if (index == -1){
            System.out.println("ERROR: No existe un empleado con Id = " + id);
            System.out.println();
            return;
        }
        Empleado empleadoEliminado = empleados.remove(index);
        
        System.out.println("Se elimino el empleado: " + empleadoEliminado);
        System.out.println();
    }
    
    public void actualizarEmpleado() throws IOException{
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
               
        System.out.println();
        System.out.println("Actualizar Empleado");
        System.out.println();
        
        System.out.println("Id: ");
        String strId = reader.readLine();
        int id;
        try{
            id = Integer.parseInt(strId);
        }catch(NumberFormatException e){
            System.out.println("ERROR: Id debe ser un numero entero");
            System.out.println();
            return;
        }
        
        Empleado empleadoABuscar = new Empleado();
        empleadoABuscar.setId(id);
        
        int index = empleados.indexOf(empleadoABuscar);
        if (index == -1){
            System.out.println("ERROR: No existe un empleado con Id = " + id);
            System.out.println();
            return;
        }
        Empleado empleadoModificando = empleados.get(index);
        
        System.out.println("Se encontro el empleado: " + empleadoModificando);
        
        System.out.println();
        System.out.println("1. Actualizar nombre");
        System.out.println("2. Actualizar apellido");
        System.out.println("3. Actualizar salario");
        System.out.println();
        System.out.println("Indique la opción que desea: ");

        String strOpcion = reader.readLine();
        int opcion;
        try{
            opcion = Integer.parseInt(strOpcion);
        }catch(NumberFormatException e){
            opcion = 0;
        }
        
        switch(opcion){
            case 1:
                System.out.println("Nombre: ");
                String nombre = reader.readLine();
                empleadoModificando.setNombre(nombre);
                break;
            case 2:
                System.out.println("Apellido: ");
                String apellido = reader.readLine();
                empleadoModificando.setApellido(apellido);
                break;
            case 3:
                System.out.println("Salario: ");
                String strSalario = reader.readLine();
                int salario;

                try{
                    salario = Integer.parseInt(strSalario);
                }catch(NumberFormatException e){
                    System.out.println("ERROR: Salario debe ser un numero entero");
                    System.out.println();
                    return;
                }
                empleadoModificando.setSalario(salario);
                break;
            default:
                System.out.println("La opción indicada no es valida");
                System.out.println();
                break;
        }
                
        System.out.println("Se actualizo el empleado: " + empleadoModificando);
        System.out.println();
    }
    
    public void mostrarTodosLosEmpleados(){
        System.out.println();
        System.out.println("Mostrar todos los empleados");
        System.out.println();
        
        if (empleados.isEmpty()){
            System.out.println("No se han registrado Empleados");
            System.out.println();
        }
        else {
            for(Empleado empleado : empleados){
                System.out.println(empleado);
            }
            System.out.println();
        }
    }
    
    public void mostrarEmpleadoMayorSalario(){
        System.out.println();
        System.out.println("Mostrar empleado con mayor salario");
        System.out.println();
        
        if (empleados.isEmpty()){
            System.out.println("No se han registrado Empleados");
            System.out.println();
        }
        else {
            Empleado empleadoMayorSalario;
            empleadoMayorSalario = empleados.stream().max((e1, e2) -> e1.getSalario() - e2.getSalario()).get();
            System.out.println(empleadoMayorSalario);
            System.out.println();
        }
    }
    
    public void mostrarEmpleadoMenorSalario(){
        System.out.println();
        System.out.println("Mostrar empleado con menor salario");
        System.out.println();
        
        if (empleados.isEmpty()){
            System.out.println("No se han registrado Empleados");
            System.out.println();
        }
        else {
            Empleado empleadoMenorSalario;
            empleadoMenorSalario = empleados.stream().min((e1, e2) -> e1.getSalario() - e2.getSalario()).get();
            System.out.println(empleadoMenorSalario);
            System.out.println();
        }
    }
    
    public void mostrarEmpleadosPorNombre(){
        System.out.println();
        System.out.println("Mostrar empleados en orden alfabetico");
        System.out.println();
        
        if (empleados.isEmpty()){
            System.out.println("No se han registrado Empleados");
            System.out.println();
        }
        else {
            empleados.stream().sorted((e1, e2) -> e1.getNombre().compareTo(e2.getNombre()))
                    .forEach(e -> System.out.println(e));
            System.out.println();
        }
    }
    
    public void mostrarSumaSalariosMayoresA(int salarioLimiteInf){
        int suma = empleados.stream()
                .filter(e -> e.getSalario() > salarioLimiteInf)
                .map(e -> e.getSalario())
                .reduce((sum, s) -> sum + s)
                .get();
        System.out.println();
        System.out.println("La suma de los salarios mayores a " + salarioLimiteInf + " es " + suma);
        System.out.println();
    }
    
    public void contarEmpleadosConApellidoPor(String inicialApellido){
        long conteo = empleados.stream()
                .filter(e -> e.getApellido().toUpperCase().startsWith(inicialApellido.toUpperCase()))
                .count();
        
        System.out.println();
        System.out.println("El número de empleados cuyo apellido empieza por " + inicialApellido + " es " + conteo);
        System.out.println();
    }
    
    public void mostrarEmpleadosConMayorSalario(long maxEmpleados){
        System.out.println();
        System.out.println("Mostrar los " + maxEmpleados + " empleados con mayor salario");
        System.out.println();
        
        if (empleados.isEmpty()){
            System.out.println("No se han registrado Empleados");
            System.out.println();
        }
        else {
            empleados.stream().sorted((e1, e2) -> e2.getSalario() - e1.getSalario())
                    .limit(maxEmpleados)
                    .forEach(e -> System.out.println(e));
            System.out.println();
        }
    }
}
