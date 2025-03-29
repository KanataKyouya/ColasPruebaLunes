public class ObjPc {

    private String Serial;
    private String Marca;
    private float MemRam;
    private float DiscDuro;
    private Double Precio;
    private String NomEstudiante;
    private int Carnet;
    private String Disponible;

    public ObjPc(){

    }

    public ObjPc(String serial, String marca, float memRam, float discDuro, Double precio, String nomEstudiante, int carnet, String disponible){

        Serial = serial;
        Marca = marca;
        MemRam = memRam;
        DiscDuro = discDuro;
        Precio = precio;
        NomEstudiante = nomEstudiante;
        Carnet = carnet;
        Disponible = disponible;

    }

    public ObjPc(ObjPc o){

        Serial = o.Serial;
        Marca = o.Marca;
        MemRam = o.MemRam;
        DiscDuro = o.DiscDuro;
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

    public float getMemRam() {
        return MemRam;
    }

    public void setMemRam(float memRam) {
        MemRam = memRam;
    }

    public float getDiscDuro() {
        return DiscDuro;
    }

    public void setDiscDuro(float discDuro) {
        DiscDuro = discDuro;
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
