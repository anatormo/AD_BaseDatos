package classes;

public class Departamento {
    //Atributos
    private Integer numDept;
    private String nombreDept;
    private String localidadDept;

    public Departamento(){ //constructor vacio

    }

    //Constructor completo
    public Departamento(Integer numDept, String nombreDept, String localidadDept) {
        this.numDept = numDept;
        this.nombreDept = nombreDept;
        this.localidadDept = localidadDept;
    }

    //Getter y Setter
    public Integer getNumDept() {
        return numDept;
    }

    public void setNumDept(Integer numDept) {
        this.numDept = numDept;
    }

    public String getNombreDept() {
        return nombreDept;
    }

    public void setNombreDept(String nombreDept) {
        this.nombreDept = nombreDept;
    }

    public String getLocalidadDept() {
        return localidadDept;
    }

    public void setLocalidadDept(String localidadDept) {
        this.localidadDept = localidadDept;
    }
}
