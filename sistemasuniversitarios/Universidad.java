package sistemasuniversitarios;

public class Universidad {

// ATRIBUTO
    private String nombre;
    private String ciudad;
    private int fundacion;

// Asociaciones
    private Estudiante[] estudiantes;
    private Trabajador[] trabajadores;

// Composicion
    private Departamento[] departamentos;

// CONSTRUCTOR 
    public Universidad(String nombre,
                        String ciudad,
                        int fundacion) {

        this.nombre = nombre;
        this.ciudad = ciudad;
        this.fundacion = fundacion;

        estudiantes = new Estudiante[100];
        trabajadores = new Trabajador[50];
        departamentos = new Departamento[20];
    }


    public Universidad() {

        this.nombre = "";
        this.ciudad = "";
        this.fundacion = 0;

        estudiantes = new Estudiante[100];
        trabajadores = new Trabajador[50];
        departamentos = new Departamento[20];
    }

// GETTERS
    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public int getFundacion() {
        return fundacion;
    }

// SETTERS
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setFundacion(int fundacion) {
        this.fundacion = fundacion;
    }

//METODO DE BUSQUEDA RECURSIVA 
// Buscamos ESTUDIANTE  sobre matriculo, como se pidio en clase 
// USAMOS EQUALS PQ ESTAMOS COMPARANDO CADENAS 
public Estudiante buscarEstudiante(String matricula) {
    return buscarEstudiante(matricula, 0);
}

private Estudiante buscarEstudiante(String matricula, int i) {

    if (i >= estudiantes.length) {
        return null;
    }

    if (estudiantes[i] != null &&
        estudiantes[i].getMatricula().equals(matricula)) {

        return estudiantes[i];
    }

    return buscarEstudiante(matricula, i + 1);
}

// Buscamos TRABAJADOR sobre identificador  
public Trabajador buscarTrabajador(String identificador) {
    return buscarTrabajador(identificador, 0);
}

private Trabajador buscarTrabajador(String identificador, int i) {

    if (i >= trabajadores.length) {
        return null;
    }

    if (trabajadores[i] != null &&
        trabajadores[i].getIdentificador().equals(identificador)) {

        return trabajadores[i];
    }

    return buscarTrabajador(identificador, i + 1);
}

// BUscamos DEPARTAMENTO sobre nombre 
public Departamento buscarDepartamento(String dato) {
    return buscarDepartamento(dato, 0);
}

private Departamento buscarDepartamento(String dato, int i) {

    if (i >= departamentos.length) {
        return null;
    }

    if (departamentos[i] != null &&
       (departamentos[i].getNombre().equals(dato)
        ||
        departamentos[i].getCodigo().equals(dato))) {

        return departamentos[i];
    }

    return buscarDepartamento(dato, i + 1);
}

// METODO REGISTRAR ESTUDIANTE
    public void registrarEstudiante(Estudiante estudiante) {

        for (int i = 0; i < estudiantes.length; i++) {

            if (estudiantes[i] == null) {

                estudiantes[i] = estudiante;

                System.out.println(
                    "Estudiante registrado correctamente."
                );

                return;
            }
        }

        System.out.println(
            "No hay espacio disponible para estudiantes."
        );
    }

// METODO CONTRATAR TRABAJADOR 
    public void contratarTrabajador(Trabajador trabajador) {

        for (int i = 0; i < trabajadores.length; i++) {

            if (trabajadores[i] == null) {

                trabajadores[i] = trabajador;

                System.out.println(
                    "Trabajador contratado correctamente."
                );

                return;
            }
        }

        System.out.println(
            "No hay espacio disponible para trabajadores."
        );
    }

// COMPOSICION CON DEPARTAMENTO 
    public void agregarDepartamento(Departamento departamento) {

        for (int i = 0; i < departamentos.length; i++) {

            if (departamentos[i] == null) {

                departamentos[i] = departamento;

                System.out.println(
                    "Departamento agregado correctamente."
                );

                return;
            }
        }

        System.out.println(
            "No hay espacio disponible para departamentos."
        );
    }

// METODO DE LA COMPOSICION
    public void listarDepartamentos() {

        System.out.println(
            "\nDEPARTAMENTOS DE LA UNIVERSIDAD"
        );

        for (int i = 0; i < departamentos.length; i++) {

            if (departamentos[i] != null) {

                System.out.println(
                    departamentos[i]
                );
            }
        }
    }

    @Override
    public String toString() {

        return "Universidad{" +
               "\nNombre: " + nombre + 
               "\nCiudad: " + ciudad + 
               "\nFundacion: " + fundacion;
               
    }
}
