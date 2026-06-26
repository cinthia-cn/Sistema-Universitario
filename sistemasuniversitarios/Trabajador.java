package sistemasuniversitarios;

import banco.CuentaCorriente;
import java.time.LocalDate;
import java.time.Period;

public class Trabajador extends Persona {


//ATRIBUTOS
private CuentaCorriente[] cuentas; 
//SE VOLVIO A MODIFICAR A UN ARREGLO 
// PQ UN TRABAJADOR PUEDE EXISTIR SI TIENE 0, 1 O MAS CUENTAS
// POR LO TANTO ES UNA AGREGACION, Y SE PUSIMOS UN ARREGLO DE CUENTAS
private static final int MAX_CUENTAS = 3;
private int totalCuentas;
//AQUI LE AGREGAMOS ESTOS ATRIBUTOS PQ
//EN MI ARREGLO YO PUSE 3 CUENTAS, SOLO POR TRABAJAR CON UN  NUMERO
// SI EL TRABAJADOR QUIERE TENER MAS DE 3 CUENTAS, SOLO SE CAMBIA EN NUMERO
// DECLARE UN TOTAL DE CUENTAS ESTE AYUDARA  A SABER EL NUMERO DE CUENTAS QUE SE TIENE Y SABER SI SE TIENE O QUIERE O NECESITA AGREGAR MAS CUENTAS
// SI ES QUE ASI LO DESEARA EL TRABAJADOR. 

private String identificador; // Agregamos atributo faltante para mejorar la presentacion de busqueda recursiva
private LocalDate fechaIngreso;
private double salario;
private String puesto;

//CONSTRUCTORES
public Trabajador (LocalDate fechaIngreso, 
		double salario, 
		String identificador,
		String puesto, 
		String nombre, 
		LocalDate fechaNacimiento, 
		String direccion,
		){
//INVOCAMOS CONSTRUCTORES DE PERSONA
        super(nombre, fechaNacimiento, direccion);
	this.identificador = identificador;        
	this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salario = salario;

	cuentas = new CuentaCorriente[MAX_CUENTAS];
	totalCuentas = 0;
    }

// CONTRUCTOR VACIO

public Trabajador() {

    super();

    this.fechaIngreso = LocalDate.now();
    this.salario = 0;
    this.puesto = "";
    this.identificador = "";
   
    cuentas = new CuentaCorriente[MAX_CUENTAS];
    totalCuentas = 0;
}


//GETTERS de CUENTA CORRIENTE
// EN ESTE CASO NO TIENE SETTER PQ YA NO APLICA POR SER VARIAS CUENTAS
public CuentaCorriente[] getCuentas(){
	return cuentas;
}

public int getTotalCuentas(){
	retutn totalCuentas;
}


//Setter y getter de IDENTIFICADOR
public String getIdentificador(){
	return identificador;
}
public void setIdentificador(String identificador){
	this.identificador = identificador;
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

// METODO DE CUENTA CORRIENTE CUENTAS
public boolean agregarCuenta(CuentaCorriente cuenta) {

        if (totalCuentas < MAX_CUENTAS) {

            cuentas[totalCuentas] = cuenta;
            totalCuentas++;

            return true;
        }
	return false;
    }


//AGREGAMOS ESTE METODO PARA LA BUSQUEDA LINEAL

    public CuentaCorriente buscarCuenta(String numeroCuenta) {

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
	"\nTotal de Cuentas: " + totalCuentas +
	"\nIdentificador:" +identificador;
}

}

