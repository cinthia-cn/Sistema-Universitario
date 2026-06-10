package sistemasuniversitarios;
import banco.CuentaAhorro;

import java.time.LocalDate;

public class Estudiante extends persona {

// ATRIBUTOS

    private CuentaAhorro cuenta; //Asociamos cuenta ahorro a Estudiante
    private String matricula;
    private double promedio;
    private LocalDate fechaIngreso;

// CONSTRUCTOR
    public Estudiante(String matricula,
                      double promedio,
                      LocalDate fechaIngreso,
                      String nombre,
                      LocalDate fechaNacimiento,
                      String direccion, CuentaAhorro cuenta) {//

        super(nombre, fechaNacimiento, direccion);

        this.matricula = matricula;
        this.promedio = promedio;
        this.fechaIngreso = fechaIngreso;
	this.cuenta = cuenta; //
    }

    public Estudiante() {

        super("", LocalDate.now(), "");

        this.matricula = "";
        this.promedio = 0;
        this.fechaIngreso = LocalDate.now();
	this.cuenta = null;
    }

// GETTERS
    public String getMatricula() {
        return matricula;
    }

    public double getPromedio() {
        return promedio;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }
    public  CuentaAhorro getCuenta(){
	return cuenta;                             //Agregamos getter de cuenta ahorro asociada a estudiante
}
// SETTERS
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
    public void setCuenta(CuentaAhorro cuenta){
	this.cuenta = cuenta;                               //Agregamos setter de cuenta ahorro asociada a estudiante
}
// METODO INSCRIBIR MATERIAS
    public void inscribirMateria(String materia) {

        System.out.println(
            getNombre() +
            " se ha inscrito correctamente a la materia: " +
            materia
        );
    }

// METODO CALCULAR BECA
    public double calcularBeca() {

        if (promedio >= 9.0) {
            return 3000;
        }
        else if (promedio >= 8.0) {
            return 2000;
        }
        else {
            return 1000;
        }
    }

// METODO TO STRING
    @Override
    public String toString() {

        return super.toString() + // Invoca a la version del metodo de persona. 
				//sin el se pierde la informacion de persona
                "\nMatricula: " + matricula +
                "\nPromedio: " + promedio +
                "\nFecha de ingreso: " + fechaIngreso + 
		"\nCuenta: " + cuenta;
    }
}
