package sistemasuniversitarios;

import banco.CuentaAhorro;
import java.time.LocalDate;

public class Estudiante extends Persona implements Comparable<Estudiante> {//EXTENDS ES HERENCIA
//La implementacion de comparable es que los objetos Estudiante puedan compararse entre si.

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
EL METODO DE BUSCAR CUENTAS  ***ESTE METODO ES DE BUSQUEDA LINEAL***
ESTE LO QUE HACE ES BUSCAR UNA CUENTA, EN CASO DE QUE NO ESTE LA CUENTA O NO SE HAYA ENCONTRADO
REGREAS UN NULL, PARA ESTO RECORRE TODO  EL ARREGLO UNO POR UNO, COMPARANDO DATO POR DATO
QUE ES LO AUE HACE EL GETNUMERO .EQUALS, ES CASO DE QUE SEA LA CUENTA QUE BUSCAMOS
REGRESA LA POSICION DE LA CUENTA, EN CASO CONTRARIO, TERMINA LA BUSQUEDA Y REGRESA UN NULL.

**NO USAMOS EL COMPARABLE, PQ ESTE TIPO DE BUSQUEDA SOLO NECESITA VERIFICAR SI EL 
NUMERO DE CUENTA COINCIDE CON EL QUE SE BUSCA, POR ELLO EL EQUALS
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


/**
METODO COMPARETO() SE IMPLEMENTA PARAAA COMPARAR OBJETOS ENTRE SI 
 Y PARA ESTABLECER UN ORDEN ENTRE LOS OBJETOS
AQUI COMPARAMOS 2 ESTUDIANTES POR MEDIO DE SU MATRICULA EL CUAL REGRESA:
NEGATIVO SI ESTA MATRICULA VA ANTES (-1)
0 SI SON IGUALES
POSITIVO SE VA DESPUES (1)
**/

@Override
public int compareTo(Estudiante otro){
	return this.matricula.compareTo(otro.matricula);
}

/**
ESTE METODO COMPARA DOS OBJETOS DE TIPO ESTUDIANTE USANDO LA MATRICULA
SI SON IGUALES REGRESA UN 0 
SI EL PRIMERO VA DESPUES REGRESA UN  -1
Y SI EL PRIMERO VA PRIMERO REGRESA UN 1
**/

/**
METODO DE EQUALS   ESTE RESPONDE TRUE O FALSE
COMPARA SI DOS ESTUDIANTES SON IGUALES
SON IGUALES SI TIENEN LA MISMA MATRICULA
**/
@Override
public boolean equals (Object  obj){ //RECIBE UN OBJECT POR EL METODO ORIGINAL DE JAVA
	if(this==obj){ //AQUI COMPARA SI THIS Y OBJ APUNTAN AL MISMO OBJETO EN MEMORIA
	   return true;//DEVUELVE TRUE SI ES QUE APUNTAN AL MISMO OBJETO
	}
	if (obj==null || getClass() != obj.getClass()){ 
//AQUI LO QUE DICE ES. SE COMPARA CON NADA?
//REGRESA FALSE   O (||) SON CLASES DIFERENTES? SI SON CLASES DIFERENTES, REGRESA FALSE
//!= DICE LAS CLASES SON DISTINTAS?
	  return false;
	}
	Estudiante otro = (Estudiante) obj; 
//AQUI HACEMOS QUE OBJ SE HAGA OBJETO DE ESTUDIANTE PQ YA VIMOS 
//SI SON DE LA MISA CLASE, ENTONCES LO CONVIERTE Y LO GUARDA EN OTRO
	return this.matricula.equals(otro.matricula);//AQUI FINALMENTE COMPARA, REGRESANDO UN TRUE SI SON IGUALES 


}//USAMOS LA MATRICULA PQ HAY CASOS EN QUE LOS ESTUDIANTES SE LLAMAN IGUAL, PEROO NO PUEDEN COMPARTIR LA 
//MISMA MATRICULA 



    @Override
    public String toString() {
        return super.toString() + //INVOCA EL STRING DE PERSONA
                "\nMatricula: " + matricula +
                "\nPromedio: " + promedio +
                "\nFecha ingreso: " + fechaIngreso;
    }
}


