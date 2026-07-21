package banco;

public class CuentaBancaria implements Transaccionable, Comparable<CuentaBancaria> {
//IMPLEMENTS  ES DE INTERFAZ 
   
//ATRIBUTO
/**
AQUI USAMOS PROTECTED PQ  ES UN MODIFICADOR DE ACCESO 
LO QUE DICE ES QUE LO PUEDE UTILIZAR LA MISMA CLASE , DEL MISMO PAQUETE, CLASES HIJAS SI ESTAN OTRO PAQUETE
PODEMOS OBSERVAR QUE BANCO ES UNO  DE MIS PAQUETES Y QUE  SISTEMAUNIVERSITARIO ES OTRO
POR LO TANTO SI TRABAJARA CON PRIVATE, ME LANZARIA UN ERROS DE PAQUETES.
**/ 
    protected double saldo;
    protected String numeroCuenta;

// CONSTRUCTORES
    public CuentaBancaria(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

// GETTERS
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

// SETTERS
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }


    @Override  // LA CLASE PADRE YA TIENE UN METODO ASI, Y ESTE LE DA OTRO COMPORTAMIENTO 
    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }// COMPARA EL MONTO

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) saldo -= monto;
    }// AQUI COMPARA EL TENER EL MONTO MAYOR O IGUAL AL QUE SE DESEA RETIRAR.


/**
 * COMPARA DOS CUENTAS BANCARIAS MEDIANTE SU NUMERO DE CUENTA.
 * DEVUELVE:
 * NEGATIVO SI ESTA CUENTA VA ANTES.
 * CERO SI SON IGUALES.
 * POSITIVO SI ESTA CUENTA VA DESPUES.
 */
@Override
public int compareTo(CuentaBancaria otra) {
    return this.numeroCuenta.compareTo(otra.numeroCuenta);
}

/**
 * COMPARA SI DOS CUENTAS SON IGUALES.
 * DOS CUENTAS SON IGUALES SI TIENEN EL MISMO NUMERO DE CUENTA.
 */
@Override
public boolean equals(Object obj) {

    if (this == obj) {
        return true;
    }

    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }

    CuentaBancaria otra = (CuentaBancaria) obj;

    return this.numeroCuenta.equals(otra.numeroCuenta);
} 


// METODO TOSTRING
    @Override
    public String toString() {
        return "CuentaBancaria" +
                "\nNumero de cuenta: " + numeroCuenta +
                "\nSaldo: " + saldo;
    }
}
