package es.uniovi.asw;

/**
 * Created by Carla on 08/02/2017.
 */
public class User {
    String nombre;
    String apellidos;
    String email;
    String nacimiento;
    String direccion;
    String nacionalidad;
    String dni;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public void setDNI(String dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "; Apellidos: " + apellidos + "; " +
                "Email: " + email + "; Nacimiento: " + nacimiento + "10/10/1985; " +
                "Dirección: " + direccion + "; Nacionalidad: " +
                nacionalidad + "; DNI: " + dni;
    }
}
