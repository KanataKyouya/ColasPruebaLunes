public class ObjTablet {

    private String Serial;
    private String Marca;
    private float Tamaño;
    private Double Precio;
    private String NomEstudiante;
    private int Carnet;
    private String Disponible;

    public ObjTablet(){

    }

    public ObjTablet(String serial, String marca, float tamaño, Double precio, String nomEstudiante, int carnet, String disponible){

        Serial = serial;
        Marca = marca;
        Tamaño = tamaño;
        Precio = precio;
        NomEstudiante = nomEstudiante;
        Carnet = carnet;
        Disponible = disponible;

    }

    public ObjTablet(ObjTablet o){

        Serial = o.Serial;
        Marca = o.Marca;
        Tamaño = o.Tamaño;
        Precio = o.Precio;
        NomEstudiante = o.NomEstudiante;
        Carnet = o.Carnet;
        Disponible = o.Disponible;

    }

    public String getSerial() {
        return Serial;
    }

    public void setSerial(String serial) {
        Serial = serial;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }
 
    public float getTamaño() {
        return Tamaño;
    }

    public void setTamaño(float tamaño) {
        Tamaño = tamaño;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double precio) {
        Precio = precio;
    }

    public String getNomEstudiante() {
        return NomEstudiante;
    }

    public void setNomEstudiante(String nomEstudiante) {
        NomEstudiante = nomEstudiante;
    }

    public int getCarnet() {
        return Carnet;
    }

    public void setCarnet(int carnet) {
        Carnet = carnet;
    }

    public String getDisponible() {
        return Disponible;
    }

    public void setDisponible(String disponible) {
        Disponible = disponible;
    }

}
