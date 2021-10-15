package co.edu.unbosque.multipartservlet.multiparservlet;

public class metaData {

    private String petName;
    private String hora;
    private String correo;
    private String imagen;

    public metaData(String petName, String hora, String correo, String imagen){
        this.petName=petName;
        this.hora=hora;
        this.correo=correo;
        this.imagen=imagen;

    }
    public String toSrting(){
        return "petName:"+this.petName + "hora:"+this.hora+ "correo:"+this.correo+"imagen:"+this.imagen;

    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
