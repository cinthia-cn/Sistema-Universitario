package banco;
public class CuentaCorriente extends CuentaBancaria {

    public CuentaCorriente(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
    }

    public void girarCheque(double monto) {
        retirar(monto);
        System.out.println("Cheque girado por $" + monto);
    }

    public void cobrarComision() {
        double comision = 50.0;
        saldo -= comision;
        System.out.println("Comisión cobrada: $" + comision);
    }

    @Override
    public String toString() {
        return "CuentaCorriente" +
		"\n" + super.toString();
    }
}
