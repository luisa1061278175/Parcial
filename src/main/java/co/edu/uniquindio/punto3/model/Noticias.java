package co.edu.uniquindio.punto3.model;

public class Noticias {
    private String fecha;
    private String titulo;
    private String descripcion;
    private String urlImagen;
    private String codInvestigador;

    public Noticias(String fecha, String titulo, String descripcion, String urlImagen, String codInvestigador) {
        this.fecha = fecha;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.urlImagen = urlImagen;
        this.codInvestigador = codInvestigador;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getCodInvestigador() {
        return codInvestigador;
    }

    public void setCodInvestigador(String codInvestigador) {
        this.codInvestigador = codInvestigador;
    }
}
