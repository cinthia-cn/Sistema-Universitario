package sistemasuniversitarios;
public class Departamento {

// ATRIBUTOS
    private String nombre;
    private String codigo;
    private String ubicacion;

// Asociacion
    private Pdi[] profesores;

// Agregación
    private EstudianteGrado[] estudiantes;

// CONTRUCTOR
    public Departamento(String nombre,
                         String codigo,
                         String ubicacion) {

        this.nombre = nombre;
        this.codigo = codigo;
        this.ubicacion = ubicacion;

        profesores = new Pdi[10];
        estudiantes = new EstudianteGrado[30];
    }
 // CONSTRUCTOR VACIO

    public Departamento() {

        this("","","");
    }

// GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

// SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

// BUSQUEDA RECUERSIVA 
// Buscamos PROFESOR por trabajador (PDI)
public Pdi buscarProfesor(String nombre) {
    return buscarProfesor(identificador, 0);
}

private Pdi buscarProfesor(String identificador, int i) {

    if (i >= profesores.length) {
        return null;
    }

    if (profesores[i] != null &&
        profesores[i].buscarTrabajador(identificador) != null) {

        return profesores[i];
    }

    return buscarProfesor(identificador, i + 1);
}

// Buscamos ESTUDIANTE GRADO por matricula
// Usamos EQUALS
public EstudianteGrado buscarEstudiante(String matricula) {
    return buscarEstudiante(matricula, 0);
}

private EstudianteGrado buscarEstudiante(String matricula, int i) {

    if (i >= estudiantes.length) {
        return null;
    }

    if (estudiantes[i] != null &&
        estudiantes[i].getMatricula().equals(matricula)) {

        return estudiantes[i];
    }

    return buscarEstudiante(matricula, i + 1);
}



// METODO ASIGNAR PROFESOR
    public void asignarProfesor(Pdi profesor) {

        for (int i = 0; i < profesores.length; i++) {

            if (profesores[i] == null) {

                profesores[i] = profesor;

                System.out.println(
                    "Profesor asignado correctamente."
                );

                return;
            }
        }

        System.out.println(
            "No hay espacio disponible para profesores."
        );
    }

// METODO LISTAR PERSONAL
    public void listarPersonal() {

        System.out.println(
            "\nPERSONAL DEL DEPARTAMENTO"
        );

        for (int i = 0; i < profesores.length; i++) {

            if (profesores[i] != null) {

                System.out.println(
                    profesores[i]
                );
            }
        }
    }

// METODO DE AGREGACION PARA AGREGAR
    public void agregarEstudiante(EstudianteGrado estudiante) {

        for (int i = 0; i < estudiantes.length; i++) {

            if (estudiantes[i] == null) {

                estudiantes[i] = estudiante;

                System.out.println(
                    "Estudiante agregado correctamente."
                );

                return;
            }
        }

        System.out.println(
            "No hay espacio disponible para estudiantes."
        );
    }

// IGUAL METODO DE AGREGACION PARA LISTAR
    public void listarEstudiantes() {

        System.out.println(
            "\nESTUDIANTES DEL DEPARTAMENTO"
        );

        for (int i = 0; i < estudiantes.length; i++) {

            if (estudiantes[i] != null) {

                System.out.println(
                    estudiantes[i]
                );
            }
        }
    }

    @Override
    public String toString() {

        return "Departamento" +
               "\nNombre:" + nombre +
               "\nCodigo:" + codigo + 
               "\nUbicacion:" + ubicacion; 
            
    }
}
