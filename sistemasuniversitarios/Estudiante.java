package sistemasuniversitarios;
import banco.CuentaAhorro;

import java.time.LocalDate;

public class Estudiante extends Persona {

// ATRIBUTOS

// AQUI APLICAMOS LO MISMO QUE EN TRABAJADOR
// DONDE UN ESTUDIANTE PUEDE TENER VARIAS CUENTAS DE AHORRO
// POR LO TANTO CORREGI DE ASOSIACION A AGREGACION
// Y AGREGAMOS ARREGLO A CUENTA DE AHORRO

	private static final int MAX_CUENTAS = 3;
	private CuentaAhorro[] cuentas;
	private int totalCuentas;

    private String matricula;
    private double promedio;
    private LocalDate fechaIngreso;

// CONSTRUCTOR

    public Estudiante(String matricula,
                      double promedio,
                      LocalDate fechaIngreso,
                      String nombre,
                      LocalDate fechaNacimiento,
                      String direccion) {

        super(nombre, fechaNacimiento, direccion);

        this.matricula = matricula;
        this.promedio = promedio;
        this.fechaIngreso = fechaIngreso;
	
	cuentas = new CuentaAhorro[MAX_CUENTAS];
	totalCuentas = 0;
    }

// CONSTRUCTOR VACIO
    public Estudiante() {

        super();

        this.matricula = "";
        this.promedio = 0;
        this.fechaIngreso = LocalDate.now();
	
	cuentas = new CuentaAhorro[MAX_CUENTAS];
	totalCuentas = 0;
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
    public  CuentaAhorro[] getCuentas(){
	return cuentas;
}

   public int getTotalCuentas(){
	return totalCuentas;
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
    
// METODO DE CUENTA AHORRO CUENTAS

 public boolean agregarCuenta(CuentaAhorro cuenta) {

        if (totalCuentas < MAX_CUENTAS) {

            cuentas[totalCuentas] = cuenta;
            totalCuentas++;

            return true;
        }

        return false;
    }
  public CuentaAhorro buscarCuenta(String numeroCuenta) {

        for (int i = 0; i < totalCuentas; i++) {

            if (cuentas[i].obtenerNumero().equals(numeroCuenta)) {
                return cuentas[i];
            }

        }

        return null;
    }

    public void mostrarCuentas() {

        if (totalCuentas == 0) {	
	System.out.println("No tiene cuentas registradas.");
            return;

        }

        for (int i = 0; i < totalCuentas; i++) {

            System.out.println(cuentas[i]);

        }

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
		"\nTotal de cuentas: " + totalcuentas;
    }
}
