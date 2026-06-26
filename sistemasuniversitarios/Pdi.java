package sistemasuniversitarios;
import java.time.LocalDate;

public class Pdi {

//ATRIBUTOS
 
    private Trabajador[] t = new Trabajador[3];
    private String categoria;
    private String especialidad;
    private int horasDocencia;

//CONSTRUCTOR

public Pdi(String categoria,
           String especialidad,
           int horasDocencia,
           LocalDate fechaIngreso,
           double salario,
	  String identificador;
           String puesto,
           String nombre,
           LocalDate fechaNacimiento,
           String direccion) {

    t[0] = new Trabajador(fechaIngreso, salario,identificador, puesto,
                          nombre, fechaNacimiento, direccion);

    t[1] = new Trabajador(fechaIngreso, salario,identificador, puesto,
                          nombre, fechaNacimiento, direccion);

    t[2] = new Trabajador(fechaIngreso, salario,identificador,puesto,
                          nombre, fechaNacimiento, direccion);

    this.categoria = categoria;
    this.especialidad = especialidad;
    this.horasDocencia = horasDocencia;
}

// CONSTRUCTOR VACIO

public Pdi() {

    this.categoria = "";
    this.especialidad = "";
    this.horasDocencia = 0;
}

// SETTERS
public void setCategoria(String categoria) {
    this.categoria = categoria;
}

public void setEspecialidad(String especialidad) {
    this.especialidad = especialidad;
}

public void setHorasDocencia(int horasDocencia) {
    this.horasDocencia = horasDocencia;
}

//GETTERS
public String getCategoria() {
    return categoria;
}

public String getEspecialidad() {
    return especialidad;
}

public int getHorasDocencia() {
    return horasDocencia;
}

// AGREGAMOS BUSQUEDA RECURSIVA 
// Buscando al trabajador dentro del arreglo 
// Usamos el EQUALS
public Trabajador buscarTrabajador(String identificador) {
    return buscarTrabajador(identificador, 0);
}

private Trabajador buscarTrabajador(String identificador, int i) {

    if (i >= t.length) {
        return null;
    }

    if (t[i] != null &&
        t[i].getIdentificador().equals(identificador)) {

        return t[i];
    }

    return buscarTrabajador(identificador, i + 1);
}



//METODO INVESTIGAR 
public void investigar(String tema) {

    for(int i = 0; i < t.length; i++) {

        if(t[i] != null) {

            System.out.println(
                t[i].getNombre() +
                "Esta investigando sobre: " +
                tema
            );
        }
    }
}

//METODO IMPARTIR CLASE
public void impartirClase() {

    for(int i = 0; i < t.length; i++) {

        if(t[i] != null) {

            System.out.println(
                t[i].getNombre() +
                "Impartió una clase de " +
                horasDocencia +
                " horas."
            );
        }
    }
}

// METODO TO STRING
@Override
public String toString() {

    return "PDI" +
            "\nCategoria: " + categoria + '\'' +
            "\nEspecialidad: " + especialidad + '\'' +
            "\nHoras de docencia: " + horasDocencia;
}



}
