package sistemasuniversitarios;

import java.time.LocalDate;
import java.time.Period;

//ATRIBUTOS

public class Persona {
private String nombre;
private LocalDate fechaNacimiento;
private String direccion;


//CONSTRUCTOR 
public Persona(String nombre, LocalDate fechaNacimiento, String direccion){
this.nombre= nombre;
this.fechaNacimiento= fechaNacimiento;
this.direccion= direccion;
}

//CONSTRUCTOR VACIO

public Persona() {

    this.nombre = "";
    this.fechaNacimiento = LocalDate.now();
    this.direccion = "";
}
 
//setter y getter de NOMBRE
 public void setNombre(String nombre) {
        this.nombre = nombre;
}
 public String getNombre() {
        return this.nombre;
    }


//setter y gettes de FECHA DE NACIMIENTO 
public  void setFechaNacimiento(LocalDate fechaNacimiento){
	this.fechaNacimiento= fechaNacimiento;
}
public  LocalDate getFechaNacimiento(){
	return this.fechaNacimiento;
}


//Setter y getter de DIRECCION
public void setDireccion(String direccion){
	this.direccion= direccion;
}
public String getDireccion(){
	return this.direccion;
}

//Metodo OBTENER EDAD
public int obtenerEdad(){
	return Period.between(
		fechaNacimiento,
		LocalDate.now()
		).getYears();
}

//Metodo ES ADULTO  MAYOR
public boolean esAdultoMayor(){
	return obtenerEdad()>=60;
}

// TO STRING

@Override
public String toString(){
return "Nombre: "+ nombre +
"\nEdad: " + obtenerEdad() +
"\nDireccion: " + direccion;
 }


}
