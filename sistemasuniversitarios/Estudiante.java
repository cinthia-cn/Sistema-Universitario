package sistemasuniversitarios;

import banco.CuentaAhorro;
import java.time.LocalDate;

public class Estudiante extends Persona {//EXTENDS ES HERENCIA

/** ATRIBUTOS DE CUENTA AHORRO
AQUI LO QUE HICE FUE AGREGAR UN MAXIMO DE CUENTAS, EN CASO DE QUE SE QUIERAN MAS POR ESTUDIANTE
SE CAMBIA EL MAXXIMO DE CUENTAS. PQ? Pq lo que hacemos en una asociacion es que cadda estudiante puede tener
mas de una cueta de ahorro**/
    private static final int MAX_CUENTAS = 3;
    private CuentaAhorro[] cuentas;
    private int totalCuentas;

//Atributos de Estudiante
    private String matricula;
    private double promedio;
    private LocalDate fechaIngreso;

// CONSTRUCTOR CON PARAMETROS
    public Estudiante(String matricula,
                      double promedio,
                      LocalDate fechaIngreso,
                      String nombre,
                      LocalDate fechaNacimiento,
                      String direccion) {

        super(nombre, fechaNacimiento, direccion); // HERENCIA DE PERSONA

        this.matricula = matricula;
        this.promedio = promedio;
        this.fechaIngreso = fechaIngreso;

        cuentas = new CuentaAhorro[MAX_CUENTAS];
    }

// COSNTRUCTOR VACIO
    public Estudiante() {
        super();
        this.matricula = "";
        this.promedio = 0;
        this.fechaIngreso = LocalDate.now();

        cuentas = new CuentaAhorro[MAX_CUENTAS];
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

    public CuentaAhorro[] getCuentas() {
        return cuentas;
    }

    public int getTotalCuentas() {
        return totalCuentas;
    }

//SETTERS
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

/**
METODO MOSTRAR CUENTA
ESTE PRIMER METODO LO QUE HACE ES UNA COMPARACION SIMPLE DE == PARA VER SI EL NUMERO ES CUENTAS
ES IGUAL A CERO EN CASO DE QUE SEA ASI, MUESTEA QUE NO HAY CUENTAS REGISTRADAS
**/
public void mostrarCuentas() {
    if (totalCuentas == 0) {
        System.out.println("No tiene cuentas registradas.");
        return;
    }

/**
EN CASO DE QUE SI HAYA CUENTAS, DEVUELVE EL CUANTAS
PARA VER SI NUESTRO MAXIMO DE 3 ESTA LLENO O VACIO, PARA ESTO RECORRE EL ARREGLO UNO POR UNO
**/

    for (int i = 0; i < totalCuentas; i++) {
        System.out.println(cuentas[i]);
    }
}

/**
CUANDO YA VERIFICO QUE SI NAY ESPACIOS, ESTE AGREGARA UNA CUENTA DE AHORRO NUEVA
COMPARA  EL TOTAL. EN CASO DE ESPACIO, INCREMENTA SIN PASAR EL MAXIMO, CUANDO SE AGREGO LA CUENTA
REGRESA UN TRUE, EN CASO CONTRARIO REGRESA UN FALSE, DE QUE NO SE PUEDO REGISTRAR LA CUENTA.
**/

    public boolean agregarCuenta(CuentaAhorro cuenta) {
        if (totalCuentas < MAX_CUENTAS) {
            cuentas[totalCuentas++] = cuenta;
            return true;
        }
        return false;
    }

/**
EL METODO DE BUSCAR CUENTAS 
ESTE LO QUE HACE ES BUSCAR UNA CUENTA, EN CASO DE QUE NO ESTE LA CUENTA O NO SE HAYA ENCONTRADO
REGREAS UN NULL, PARA ESTO RECORRE TODO  EL ARREGLO UNO POR UNO, COMPARANDO DATO POR DATO
QUE ES LO AUE HACE EL GETNUMERO .EQUALS, ES CASO DE QUE SEA LA CUENTA QUE BUSCAMOS
REGRESA LA POSICION DE LA CUENTA, EN CASO CONTRARIO, TERMINA LA BUSQUEDA Y REGRESA UN NULL.
**/
    public CuentaAhorro buscarCuenta(String numeroCuenta) {
        for (int i = 0; i < totalCuentas; i++) {
            if (cuentas[i] != null && // CASO BASE
                cuentas[i].getNumeroCuenta().equals(numeroCuenta)) {
                return cuentas[i];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString() + //INVOCA EL STRING DE PERSONA
                "\nMatricula: " + matricula +
                "\nPromedio: " + promedio +
                "\nFecha ingreso: " + fechaIngreso;
    }
}
