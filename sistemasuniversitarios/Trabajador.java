package sistemasuniversitarios;

import banco.CuentaCorriente;
import java.time.LocalDate;
import java.time.Period;

public class Trabajador extends Persona {

//ATRIBUTOS
/**
Aqui usamos un arreglo de cuenta corriente pq
la intencion es que un solo trabajador pueda tener mas de una cuenta
si no agregagamos este arreglo, el trabajor solo tendria una cuenta.
Aqui puse un maximo de cuestas, pero al cambiar ese numero se puede
incrementar el numero de cuentas que tenga. Y agregue un totalcuentas, 
para saber si dispone de espacio de cuentas o solo saber cuantas 
cuentas tiene en el trabajador. 
**/
    private CuentaCorriente[] cuentas;
    private static final int MAX_CUENTAS = 3;
    private int totalCuentas;

//Atributos de trabajador
    private String identificador;
    private LocalDate fechaIngreso;
    private double salario;
    private String puesto;
 
//CONSTRUCTOR CON PARAMETROS
    public Trabajador(LocalDate fechaIngreso,
                      double salario,
                      String identificador,
                      String puesto,
                      String nombre,
                      LocalDate fechaNacimiento,
                      String direccion) {

/**
¿QUE ES EL SUPER?
El super lo que hace es que invoca a los atributos de otra clase
en este calo invoco a los atributos de  PERSONA para que tambien el TRABAJADOR
puede disponer de estas caracteristicas. 
**/
        super(nombre, fechaNacimiento, direccion);

        this.identificador = identificador;
        this.fechaIngreso = fechaIngreso;
        this.puesto = puesto;
        this.salario = salario;

//AQUI se creo un objeto de cuenta
        cuentas = new CuentaCorriente[MAX_CUENTAS];
    }

//CONSTRUCTOR VACIO

    public Trabajador() {
        super(); //Aqui invoca al constructor de la clase padre. 
        this.identificador = "";
        this.fechaIngreso = LocalDate.now();
        this.salario = 0;
        this.puesto = "";

        cuentas = new CuentaCorriente[MAX_CUENTAS];
    }

//GETTERS
    public CuentaCorriente[] getCuentas() {
        return cuentas;
    }

    public int getTotalCuentas() {
        return totalCuentas;
    }

    public String getIdentificador() {
        return identificador;
    }

// SETTERS
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public LocalDate getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(LocalDate fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }


//METODO PARA CUENTACORRIENTE
/**
AQUI lo que hace es agregar cuentas
en caso de que el numero de cuentas que ya hay sea mayor al maximo
regresa un false.Que seria en caso donde no se pudo agregar la cuenta 
En caso de que sea igual a 0, regresa
que no hay cuentas registradas
En caso de que si se pueda meter, lo agrega al arreglo. Y regresa un true 
**/
    public boolean agregarCuenta(CuentaCorriente cuenta) {
        if (totalCuentas < MAX_CUENTAS) {
            cuentas[totalCuentas++] = cuenta;
// Aqui si se sumo al arreglo se suma esa posicion de que si se uso, y devuelve el true
            return true;
        }
        return false;
    }

public void mostrarCuentas() {
    if (totalCuentas == 0) {
        System.out.println("No tiene cuentas registradas.");
        return;
    }

    for (int i = 0; i < totalCuentas; i++) {
        System.out.println(cuentas[i]);
    } //Aqui mete el nuevo numero de cuentas. o la posicion del arreglo
}

//METODO DE BUSCAR CUENTA
    public CuentaCorriente buscarCuenta(String numeroCuenta) {
        for (int i = 0; i < totalCuentas; i++) {
            if (cuentas[i] != null &&
                cuentas[i].getNumeroCuenta().equals(numeroCuenta)) {
                return cuentas[i];
            }
        }
        return null;
    }

// METODO TOSTRING
    @Override
    public String toString() {
        return super.toString() +
                "\nIdentificador: " + identificador +
                "\nFecha ingreso: " + fechaIngreso +
                "\nSalario: " + salario +
                "\nPuesto: " + puesto +
                "\nTotal cuentas: " + totalCuentas;
    }
}
