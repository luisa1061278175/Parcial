package co.edu.uniquindio.punto3.model;

public class Investigador {
    private String cedula;
    private String nombre;
    private String tituloProfesional;
    private String grupoInvestigacion;
    private String areaInvestigacion;

    public Investigador(String cedula, String nombre, String tituloProfesional, String grupoInvestigacion, String areaInvestigacion) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tituloProfesional = tituloProfesional;
        this.grupoInvestigacion = grupoInvestigacion;
        this.areaInvestigacion = areaInvestigacion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    public String getGrupoInvestigacion() {
        return grupoInvestigacion;
    }

    public void setGrupoInvestigacion(String grupoInvestigacion) {
        this.grupoInvestigacion = grupoInvestigacion;
    }

    public String getAreaInvestigacion() {
        return areaInvestigacion;
    }

    public void setAreaInvestigacion(String areaInvestigacion) {
        this.areaInvestigacion = areaInvestigacion;
    }
}


