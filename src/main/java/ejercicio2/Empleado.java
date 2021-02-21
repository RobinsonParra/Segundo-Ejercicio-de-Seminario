package ejercicio2;

public class Empleado extends Persona {
    
    private int salario;

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Empleado other = (Empleado) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    public String toString() {
        return "Empleado{" + "id=" + getId() + ", nombre=" + getNombre() + ", apellido=" + getApellido() + ", salario=" + salario + '}';    
    }
}
