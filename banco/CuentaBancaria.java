package banco;
public class CuentaBancaria implements Transaccionable {

    protected double saldo;
    protected String numeroCuenta;

    public CuentaBancaria(String numeroCuenta, double saldo) {
        this.numeroCuenta = numeroCuenta;
        this.saldo = saldo;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public String obtenerNumero() {
        return numeroCuenta;
    }

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
        return "CuentaBancaria{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                '}';
    }
}
