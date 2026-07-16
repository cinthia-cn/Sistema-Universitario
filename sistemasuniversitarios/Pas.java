package sistemasuniversitarios;
import java.time.LocalDate;

public class Pas {

//ATRIBUTOS
    private Trabajador[] t = new Trabajador[3];// creamos un objeto de un arreglo de 3
    private String area;
    private int nivel;
    private String turno;

//CONSTRUCTO
    public Pas(String area, int nivel, String turno,
               LocalDate fechaIngreso,
               double salario,
               String identificador,
               String puesto,
               String nombre,
               LocalDate fechaNacimiento,
               String direccion) {

        t[0] = new Trabajador(fechaIngreso, salario,identificador, puesto,
                      nombre, fechaNacimiento, direccion);

	t[1] = new Trabajador(fechaIngreso, salario,identificador, puesto,
                      nombre, fechaNacimiento, direccion);

	t[2] = new Trabajador(fechaIngreso, salario,identificador, puesto,
                      nombre, fechaNacimiento, direccion);


        this.area = area;
        this.nivel = nivel;
        this.turno = turno;
    }

//CONSTRUCTOR DE AREA
public Pas(String area, int nivel, String turno) {
    this.area = area;
    this.nivel = nivel;
    this.turno = turno; 
}

// CONSTRUCTOR VACIO
    public Pas() {

        this.area = "";
        this.nivel = -1;
        this.turno = "";
    }

// GETTERS
    public String getArea() {
        return area;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTurno() {
        return turno;
    }

// SETTERS
    public void setArea(String area) {
        this.area = area;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

/**
AQUI TENEMOS UNA BUSQUEDA RECURSIVA PARA BUSCAR TRABAJADOR
LO QUE HACE ES RECORRER EL ARREGLO  DESDE LA POSICION 0, UNO POR  UNO
EN CASO DE NO ENCUENTRE SE VULVE A LLAMAR EL METODO HASTA LLEGAR AL CASO BASE.
**/
public Trabajador buscarTrabajador(String identificador) {
    return buscarTrabajador(identificador, 0);
}

private Trabajador buscarTrabajador(String identificador, int i) {

    if (i >= t.length) {
        return null;
    }

    if (t[i] != null && // CASO BASE
        t[i].getIdentificador().equals(identificador)) {

        return t[i];
    }
// RECURSION
    return buscarTrabajador(identificador, i + 1);
}


// METODO ADMINISTRAR RECURSOS
    public void administrarRecursos() {

        for (int i = 0; i < t.length; i++) {

            if (t[i] != null) {

                System.out.println(
                    "Trabajador " +
                    t[i].getNombre() +
                    " pertenece al area: " +
                    area
                );
            }
        }
    }

// METODO GENERAR REPORTE
    public void generarReporte() {

        for (int i = 0; i < t.length; i++) {

            if (t[i] != null) {

                System.out.println(
                    "Nombre: " + t[i].getNombre() +
                    " | Area: " + area +
                    " | Nivel: " + nivel +
                    " | Turno: " + turno
                );
            }
        }
    }

// METODO TOSTRING
    @Override
    public String toString() {
        return "PAS" +
                "\nArea: " + area + 
                "\nNivel: " + nivel +
                "\nTurno: " + turno; 
            
    }
}
