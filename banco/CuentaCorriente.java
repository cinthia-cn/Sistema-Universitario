package banco;
import banco.CuentaCorriente;
import banco.CuentaAhorro;

public class CuentaCorriente extends CuentaBancaria { //HERENCIA

    public CuentaCorriente(String numeroCuenta, double saldo) {
        super(numeroCuenta, saldo);
    }

// METODO GIRAR CHEQUE
    public void girarCheque(double monto) {
        retirar(monto);
        System.out.println("Cheque girado por $" + monto);
    }

// METODO COBRAR COMISION
    public void cobrarComision() {
        double comision = 50.0;
        saldo -= comision;
        System.out.println("Comisión cobrada: $" + comision);
    }

// METODO TOSTRING
    @Override
    public String toString() {
        return "CuentaCorriente" +
                "\n" + super.toString();
    }
}
