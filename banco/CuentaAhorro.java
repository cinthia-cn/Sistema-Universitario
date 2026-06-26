package banco;
public class CuentaAhorro extends CuentaBancaria {

    private double montoLimite;

    public CuentaAhorro(String numeroCuenta,
                        double saldo,
                        double montoLimite) {
        super(numeroCuenta, saldo);
        this.montoLimite = montoLimite;
    }

// GETTERS
 public double getMontoLimite() {
        return montoLimite;
    }

// SETTER

    public void setMontoLimite(double montoLimite) {
        this.montoLimite = montoLimite;
    }

    public double calcularIntereses() {

        return saldo * 0.05;

    }

    @Override
    public String toString() {
        return "CuentaAhorro" + 
	"\n"+ super.toString() +
	"\nMonto limite: $" + montoLimite
    }
}
