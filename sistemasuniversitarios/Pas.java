package sistemasuniversitarios;
import java.time.LocalDate;

public class Pas {

//ATRIBUTOS
    private Trabajador[] t = new Trabajador[3];
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

    // Constructor con área
    public Pas(String area) {

        this.area = area;
        this.nivel = 0;
        this.turno = "";

        t[0] = null;
        t[1] = null;
        t[2] = null;
    }

    // Constructor vacío
    public Pas() {

        this.area = "";
        this.nivel = -1;
        this.turno = "";
    }

    // Getters
    public String getArea() {
        return area;
    }

    public int getNivel() {
        return nivel;
    }

    public String getTurno() {
        return turno;
    }

    // Setters
    public void setArea(String area) {
        this.area = area;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

// Agregamos BUSQUEDA RECURSIVA
// Buscamos TRABAJADOR dentro del arreglo
//Usamos el metodo Equals
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


    // Método administrarRecursos
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

    // Método generarReporte
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

    @Override
    public String toString() {
        return "PAS" +
                "\nArea: " + area + 
                "\nNivel: " + nivel +
                "\nTurno: " + turno; 
            
    }
}
