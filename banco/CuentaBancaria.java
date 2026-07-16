package banco;

public class CuentaBancaria implements Transaccionable {
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

// METODO TOSTRING
    @Override
    public String toString() {
        return "CuentaBancaria" +
                "\nNumero de cuenta: " + numeroCuenta +
                "\nSaldo: " + saldo;
    }
}
