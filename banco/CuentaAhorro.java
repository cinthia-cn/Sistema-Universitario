package banco;

public class CuentaAhorro extends CuentaBancaria {

    private double montoLimite;

//CONSTRUCTOR
    public CuentaAhorro(String numeroCuenta, double saldo, double montoLimite) {
        super(numeroCuenta, saldo);
        this.montoLimite = montoLimite;
    }
// GETTERS

    public double getMontoLimite() {
        return montoLimite;
    }

//SETTER
    public void setMontoLimite(double montoLimite) {
        this.montoLimite = montoLimite;
    }

//METODO CALCULAR INTERESES
    public double calcularIntereses() {
        return saldo * 0.05;
    }

// METODO TOSTRING
    @Override
    public String toString() {
        return "CuentaAhorro\n" + super.toString() +
                "\nMonto limite: " + montoLimite;
    }
}
