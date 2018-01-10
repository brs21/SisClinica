
package Datos;





public class vexpediente  extends vcliente {
  
  private String motivo_consulta;
  private String antecedentes;
  private String alergico;
  private String diagnostico;
  private String tratamiento;

    public vexpediente() {
    }

    public vexpediente(String motivo_consulta, String antecedentes, String alergico, String diagnostico, String tratamiento) {
        this.motivo_consulta = motivo_consulta;
        this.antecedentes = antecedentes;
        this.alergico = alergico;
        this.diagnostico = diagnostico;
        this.tratamiento = tratamiento;
    }

    public String getMotivo_consulta() {
        return motivo_consulta;
    }

    public void setMotivo_consulta(String motivo_consulta) {
        this.motivo_consulta = motivo_consulta;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getAlergico() {
        return alergico;
    }

    public void setAlergico(String alergico) {
        this.alergico = alergico;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String tratamiento) {
        this.tratamiento = tratamiento;
    }
    
  
    

}
