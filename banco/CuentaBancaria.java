package banco;

public class CuentaBancaria implements Transaccionable {

    protected double saldo;
    protected String numeroCuenta;

    public CuentaBancaria(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public void depositar(double monto) {
        if (monto > 0) saldo += monto;
    }

    @Override
    public void retirar(double monto) {
        if (monto > 0 && monto <= saldo) saldo -= monto;
    }

    @Override
    public String toString() {
        return "CuentaBancaria" +
                "\nNumero de cuenta: " + numeroCuenta +
                "\nSaldo: " + saldo;
    }
}
