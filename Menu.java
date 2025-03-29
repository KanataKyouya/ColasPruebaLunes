public class Menu {

    static Metodos met = new Metodos();

    public static void main(String[] args) {
        
        boolean bandera = true;
        int opt = 0;

        do{

            opt = met.ValidarOpcionMenu1();

            switch (opt) {

                case 1:

                    met.LlenarColaPc();

                    break;

                case 2:

                    met.LlenarColaTablet();

                    break;

                case 3:

                    met.Mensaje("3 po fin");

                    bandera = false;

                    break;  

            }

        }
        while (bandera);

        met.Mensaje("Programa finalizado");

    }
}
