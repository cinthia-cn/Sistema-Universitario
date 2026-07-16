package sistemasuniversitarios;

import java.time.LocalDate;
import java.time.Period;

public class Persona {

// ATRIBUTOS 
    private String nombre;
    private LocalDate fechaNacimiento;
    private String direccion;

//¿POR QUE PRIVATE?
//Pq private solo se puede usar dentro de la misma clase.
//Es como si una sola persona tuviera la llave de un candado
//El protected puede acceder a la misma clase, mismo paquete o subclase.  
//Acede a atributos y metodos lo que el privete no hace si no es su misma clase. 
//Es como si varias personas tuvieran una copia de la llave de ese candado. 

//CONSTRUCTOR CON PARAMETROS 
    public Persona(String nombre, LocalDate fechaNacimiento, String direccion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
    }

// CONSTRUCTOR VACIO 
    public Persona() {
        this.nombre = "";
        this.fechaNacimiento = LocalDate.now(); //LOCALDATE.NOW da la fecha de la computadora.  
        this.direccion = "";
    }

// GETTERS
// ¿QUE SON LOS GETTERS?
// Los setters y getters, son aquellos por los que podemos acceder y modificar los  atributos del private. 
// El GETTER sirve para obtener o leer el valor del atributo

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;  }

    public String getDireccion() {
        return direccion;
    }

// SETTERS
//Sirve para poder modificar el valor del atributo

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
//direccion devuelve el nuevo valor del atributo
//y this.direccion hace la referencia del atributo dela clase.  
   }


// Metodo de obtener edad. 
    public int obtenerEdad() {
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    	//EL PERIODO ENTRE			//Da la fecha del dia de hoy 
	// Calcula la diferiencia exacta  		//getYears devuele el valor del atributo 
	//entre dos fechas  				
}

    @Override
 	// Indica que le metodo esta sobreescrito
			// Si la calse padre lo tiene, hace referecia  a que  ya existe. Funciona sin, pero 
			// podria evitar errores de compilacion. 
  				//YA EXISTE PERO LE DARE OTRO COMPORTAMIENTO. 
    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + obtenerEdad() +
                "\nDireccion: " + direccion;
    } //El Metodo toString convierte  un objeto en una cadena de texto. 
}
