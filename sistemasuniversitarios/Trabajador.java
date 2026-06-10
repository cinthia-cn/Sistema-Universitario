package sistemasuniversitarios;
import banco.CuentaCorriente;

import java.time.LocalDate;
import java.time.Period;

public class Trabajador extends persona {


//ATRIBUTOS
private CuentaCorriente cuenta; //Atributo de la nueva practica

private LocalDate fechaIngreso;
private double salario;
private String puesto;

//CONSTRUCTORES
public Trabajador (LocalDate fechaIngreso, 
		double salario, 
		String puesto, 
		String nombre, 
		LocalDate fechaNacimiento, 
		String direccion,CuentaCorriente cuenta){
        super(nombre, fechaNacimiento, direccion);
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salario = salario;
	this.cuenta= cuenta;
    }

public Trabajador() {

    super();

    this.fechaIngreso = LocalDate.now();
    this.salario = 0;
    this.puesto = "";
}

//Setter y getter de CUENTA CORRIENTE
public CuentaCorriente getCuenta(){
	return cuenta;
}

public void setCuenta(CuentaCorriente cuenta){
	this.cuenta=cuenta;
}

//Setter y getter de FECHA  DE INGRESO
public void setFechaIngreso(LocalDate fechaIngreso){
        this.fechaIngreso = fechaIngreso;
    }
    public LocalDate getFechaIngreso(){
        return fechaIngreso;
    }
 
//setter y getter de SAlARIO
 public void setSalario(double salario){
 	this.salario = salario; 
}
    public double getSalario(){
        return salario;
    }

// setters y getters de PUESTO
public void setPuesto(String puesto){
        this.puesto = puesto;
    }

    public String getPuesto(){
        return puesto;
    }

//Metodo  CALCULAR ANTIGUEDAD
public int calcularAntiguedad(){
	return Period.between(fechaIngreso,
	LocalDate.now()).getYears();
}

//Metodo SOLICITAR VACACIONES
public void solicitarVacaciones(){
	System.out.println(getNombre() +
	"pidio vacaciones");
}

//To String
@Override
public String toString(){
	return super.toString()+
	"\nFecha de ingreso: " + fechaIngreso +
	"\nSalario: " +salario +
	"\nPuesto: " + puesto +
	"\nCuenta: " + cuenta;
}

}

