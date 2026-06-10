package banco;
public class CuentaAhorro extends CuentaBancaria {

    private double montoLimite;

    public CuentaAhorro(String numeroCuenta,
                        double saldo,
                        double montoLimite) {
        super(numeroCuenta, saldo);
        this.montoLimite = montoLimite;
    }

    public double calcularIntereses() {
        double tasa = 0.05; // 5%
        return saldo * tasa;
    }

    @Override
    public String toString() {
        return "CuentaAhorro{" +
                "numeroCuenta='" + numeroCuenta + '\'' +
                ", saldo=" + saldo +
                ", montoLimite=" + montoLimite +
                '}';
    }
}
