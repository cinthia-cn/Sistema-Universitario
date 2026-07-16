package sistemasuniversitarios;
import java.time.LocalDate;

public class EstudianteDoctorado extends Estudiante {

// ATRIBUTOS
    private String programa;
    private String temaTesis;
    private String directorTesis;

// CONSTRUCTOR 
    public EstudianteDoctorado(String programa,
                               String temaTesis,
                               String directorTesis,
                               String matricula,
                               double promedio,
                               LocalDate fechaIngreso,
                               String nombre,
                               LocalDate fechaNacimiento,
                               String direccion) {
//VIENE DE ESTUDIANTE Y PERSONA
        super(matricula, promedio, fechaIngreso,
              nombre, fechaNacimiento, direccion);

        this.programa = programa;
        this.temaTesis = temaTesis;
        this.directorTesis = directorTesis;
    }

//CONSTRUCTOR VACIO 

    public EstudianteDoctorado() {

        super();

        this.programa = "";
        this.temaTesis = "";
        this.directorTesis = "";
    }

// GETTERS
    public String getPrograma() {
        return programa;
    }

    public String getTemaTesis() {
        return temaTesis;
    }

    public String getDirectorTesis() {
        return directorTesis;
    }

// SETTERS
    public void setPrograma(String programa) {
        this.programa = programa;
    }

    public void setTemaTesis(String temaTesis) {
        this.temaTesis = temaTesis;
    }

    public void setDirectorTesis(String directorTesis) {
        this.directorTesis = directorTesis;
    }

// METODO  REALIZAR TESIS
    public void realizarTesis() {

        System.out.println(
            getNombre() +
            " continúa trabajando en su investigación doctoral."
        );

        System.out.println(
            "Tema de tesis: " + temaTesis
        );

        System.out.println(
            "Director de tesis: " + directorTesis
        );
    }

// METODO  PUBLICAR ARTICULO
    public void publicarArticulo() {

        System.out.println(
            getNombre() +
            " ha publicado un artículo científico."
        );

        System.out.println(
            "Programa: " + programa
        );

        System.out.println(
            "Tema de investigación: " + temaTesis
        );
    }

// METODO TO STRING
    @Override
    public String toString() {

        return super.toString() +
               "\nPrograma: " + programa +
               "\nTema de tesis: " + temaTesis +
               "\nDirector de tesis: " + directorTesis;
    }
}

