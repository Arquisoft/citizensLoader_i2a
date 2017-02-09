package es.uniovi.asw;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Carla on 08/02/2017.
 */
public class User {
    String nombre;
    String apellidos;
    String email;
    Date nacimiento;
    String direccion;
    String nacionalidad;
    String dni;
    String password;

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNacimiento(Date nacimiento) {
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
        String fechaFormateada = new SimpleDateFormat("dd/MM/yyyy").format(nacimiento);
        return "Nombre: " + nombre + "; Apellidos: " + apellidos + "; " +
                "Email: " + email + "; Nacimiento: " + fechaFormateada + "; " +
                "Dirección: " + direccion + "; Nacionalidad: " +
                nacionalidad + "; DNI: " + dni;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
