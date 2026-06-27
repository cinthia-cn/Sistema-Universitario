package banco;

public class GestorCuentas {

    public static CuentaBancaria buscarCuentaLineal(CuentaBancaria[] cuentas, String numero) {

        for (int i = 0; i < cuentas.length; i++) {
            if (cuentas[i] != null &&
                cuentas[i].getNumeroCuenta().equals(numero)) {
                return cuentas[i];
            }
        }

        return null;
    }
}
