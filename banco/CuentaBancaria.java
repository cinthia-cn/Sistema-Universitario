package banco;

public class CuentaBancaria implements Transaccionable {

// ATRIBUTOS
    protected double saldo;
    protected String numeroCuenta;

// CONSTRUCTOR 

    public CuentaBancaria(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }
// GETTERS 
puublic String getNumeroCuenta(){
	return numeroCuenta;
}

public double getSaldo(){
	return saldo;
}

//SETTERS
public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

// METODO

    @Override
    public void depositar(double monto) {
        if (monto > 0) {
            saldo += monto;
        }
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) {
            saldo -= monto;
        }
    }

    @Override
    public String toString() {
        return "CuentaBancaria" +
		"\nNumero de cuenta: "+ numeroCuenta+
		"\nSaldo: "+ saldo;
    }
}
