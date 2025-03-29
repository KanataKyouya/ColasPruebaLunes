import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JOptionPane;


public class Metodos {

    public void Proceso() {

        boolean bandera = true;
        int opt = 0;

        do{

            opt = ValidarOpcionMenu1();

            switch (opt) {

                case 1:

                    LlenarColaPc();

                    break;

                case 2:

                    LlenarColaTablet();

                    break;

                case 3:

                    bandera = false;

                    break;  

            }

        }
        while (bandera);

        Mensaje("Programa finalizado");

    }

    public int ValidarOpcionMenu1(){

        try {

            String Mensaje = "Bienvenidos al sistema de prestamos del ITM\n"
                    + "Seleccione a que dispositivos desea acceder:\n"
                    + "1: Pc\n"
                    + "2: Tablet\n"
                    + "3: Salir del sistema";

            int opt = Integer.parseInt(JOptionPane.showInputDialog(Mensaje));

            if (opt >= 1 && opt <= 3) {

                return opt;
                
            }

            else {

                Mensaje("Opcion no valida, intente de nuevo");

                return ValidarOpcionMenu1();

            }
    
        } 
        
        catch (Exception e) {

            Mensaje("Error, tipo de dato no válido. Por favor, ingrese un número entero");
            return ValidarOpcionMenu1();

        }

    }
    
    public int ValidarOpcionMenuPc(){

        try {

            int opt = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1: Agregar // 2: Prestar // 3: Devolver // 4: Mostrar inventario // 5: Salir"));

            if (opt >= 1 && opt <= 5) {

                return opt;
                
            }

            else {

                Mensaje("Opcion no valida, intente de nuevo");

                return ValidarOpcionMenuPc();

            }
    
        } 
        
        catch (Exception e) {

            Mensaje("Error, tipo de dato no válido. Por favor, ingrese un número entero");
            return ValidarOpcionMenuPc();

        }

    }
    
    public String ValidarAgregarPc() {

        try {

            String agregar = JOptionPane.showInputDialog("¿Desea agregar más pc? (Si/No)");

            if (agregar.equalsIgnoreCase("si") || agregar.equalsIgnoreCase("no")) {

                return agregar;
                
            }

            else {

                Mensaje("Error, ingrese Si/No");

                return ValidarAgregarPc();

            }
    
        } 
        
        catch (Exception e) {

            Mensaje("Error, tipo de dato no válido. Por favor, ingrese Si/No");
            return ValidarAgregarPc();

        }

    }

    public String ValidarDisponibilidadPc() {

        try {

            String disponible = JOptionPane.showInputDialog("¿Disponible? (Si/No)");

            if (disponible.equalsIgnoreCase("si") || disponible.equalsIgnoreCase("no")) {

                return disponible;
                
            }

            else {

                Mensaje("Error, ingrese Si/No");

                return ValidarDisponibilidadPc();

            }
    
        } 
        
        catch (Exception e) {

            Mensaje("Error, tipo de dato no válido. Por favor, ingrese Si/No");

            return ValidarDisponibilidadPc();

        }

    }

    public void LlenarColaPc() {

        Queue<ObjPc> cola = new ArrayDeque<>();
        boolean continuar = true;
        String agregar = "";

        while (continuar) {

            ObjPc o = new ObjPc();
            o.setSerial(JOptionPane.showInputDialog("Ingrese el serial: "));
            o.setMarca(JOptionPane.showInputDialog("Ingrese la marca: "));
            o.setMemRam(Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad de memoria ram: ")));
            o.setDiscDuro(Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad de disco duro: ")));
            o.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio: ")));
            o.setNomEstudiante(JOptionPane.showInputDialog("Ingrese el nombre del estudiante(N/A si está disponible): "));
            o.setCarnet(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el carnet(0 si está disponible): ")));
            o.setDisponible(ValidarDisponibilidad());
            cola.offer(o);

            agregar = ValidarAgregarPc();

            if (agregar.equalsIgnoreCase("No")) {

                continuar = false;

            }

        }

        MostrarColaPc(cola);

        int opt;

        do {

            opt = ValidarOpcionMenuPc();
            
            if (opt != 5) {

                cola = AccionesRegistroPc(cola, opt);

                if (opt != 4) {

                    MostrarColaPc(cola);

                }
                
            }

        }
        
        while (opt != 5);

        System.out.println("Programa finalizado");

    }

    public void MostrarColaPc(Queue<ObjPc> cola) {

        String TextoCola = "Cola de ObjPc: ";

        for (ObjPc r : cola) {

            TextoCola += "\nSerial: " + r.getSerial() +
                        "\nMarca: " + r.getMarca() +
                        "\nMemoria Ram: " + r.getMemRam() +
                        "\nDisco Duro: " + r.getDiscDuro() +
                        "\nPrecio: " + r.getPrecio() +
                        "\nNombre del estudiante: " + r.getNomEstudiante() +
                        "\nCarnet del estudiante: " + r.getCarnet() +
                        "\nDisponible: " + r.getDisponible() + "\n";

        }

        Mensaje(TextoCola);

    }

    public Queue<ObjPc> AccionesRegistroPc(Queue<ObjPc> cola, int opt) {

        String dato = JOptionPane.showInputDialog("Ingrese el serial del pc: ");
        Queue<ObjPc> nuevaCola = new ArrayDeque<>();

        if (opt == 1) {

            ObjPc o = new ObjPc();
            o.setSerial(JOptionPane.showInputDialog("Ingrese el serial: "));
            o.setMarca(JOptionPane.showInputDialog("Ingrese la marca: "));
            o.setMemRam(Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad de memoria ram: ")));
            o.setDiscDuro(Float.parseFloat(JOptionPane.showInputDialog("Ingrese la cantidad de disco duro: ")));
            o.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio: ")));
            o.setNomEstudiante(JOptionPane.showInputDialog("Ingrese el nombre del estudiante(N/A si está disponible): "));
            o.setCarnet(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el carnet(0 si está disponible): ")));
            o.setDisponible(ValidarDisponibilidad());
            cola.offer(o);

            return cola;

        }

        else if (opt == 4) {

            MostrarColaPc(cola);

            return cola;

        }

        else {
            
            while (!cola.isEmpty()) {

                ObjPc pc = cola.poll();

                if (pc.getSerial().equalsIgnoreCase(dato)) {

                    switch (opt) {

                        case 2: 

                            pc.setNomEstudiante(JOptionPane.showInputDialog("Ingrese el nombre del estudiante(N/A si está disponible): "));
                            pc.setCarnet(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el carnet(0 si está disponible): ")));
                            pc.setDisponible(ValidarDisponibilidad());
                            
                            break;

                        case 3:

                            pc.setNomEstudiante(JOptionPane.showInputDialog("Ingrese el nombre del estudiante(N/A si está disponible): "));
                            pc.setCarnet(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el carnet(0 si está disponible): ")));
                            pc.setDisponible(ValidarDisponibilidad());

                            break;

                    }

                }

                nuevaCola.offer(pc);

            }

            return nuevaCola;
            
        }
    
    }

    public int ValidarOpcionMenuTablet() {

        try {
            
            int opt = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1: Agregar // 2: Prestar // 3: Devolver // 4: Mostrar inventario // 5: Salir"));
            
            if (opt >= 1 && opt <= 5) {

                return opt;

            }

            Mensaje("Opción no válida, intente de nuevo");

            return ValidarOpcionMenuTablet();

        } 
        
        catch (Exception e) {

            Mensaje("Error, tipo de dato no válido. Por favor, ingrese un número entero");

            return ValidarOpcionMenuTablet();

        }

    }

    public String ValidarAgregarTablet() {

        try {

            String agregar = JOptionPane.showInputDialog("¿Desea agregar más tablets? (Si/No)");

            if (agregar.equalsIgnoreCase("si") || agregar.equalsIgnoreCase("no")) {
                
                return agregar;
            
            }

            else {

                Mensaje("Error, ingrese Si/No");

                return ValidarAgregarTablet();

            }

            
        }
        
        catch (Exception e) {

            Mensaje("Error, tipo de dato no válido. Por favor, ingrese Si/No");

            return ValidarAgregarTablet();

        }

    }

    public String ValidarDisponibilidad() {
        
        try {

            String disponible = JOptionPane.showInputDialog("¿Disponible? (Si/No)");

            if (disponible.equalsIgnoreCase("si") || disponible.equalsIgnoreCase("no")) {

                return disponible;

            }

            else {

                Mensaje("Error, ingrese Si/No");

                return ValidarDisponibilidad();

            }
            
        }
        
        catch (Exception e) {

            Mensaje("Error, tipo de dato no válido. Por favor, ingrese Si/No");

            return ValidarDisponibilidad();

        }

    }

    public void LlenarColaTablet() {
        
        Queue<ObjTablet> cola = new ArrayDeque<>();
        boolean continuar = true;
        String agregar = "";

        while (continuar) {

            ObjTablet t = new ObjTablet();

            t.setSerial(JOptionPane.showInputDialog("Ingrese el serial: "));
            t.setMarca(JOptionPane.showInputDialog("Ingrese la marca: "));
            t.setTamaño(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el tamaño: ")));
            t.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio: ")));
            t.setNomEstudiante(JOptionPane.showInputDialog("Ingrese el nombre del estudiante (N/A si está disponible): "));
            t.setCarnet(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el carnet (0 si está disponible): ")));
            t.setDisponible(ValidarDisponibilidad());
            cola.offer(t);

            if (agregar.equalsIgnoreCase("No")) {

                continuar = false;

            }

        }

        MostrarColaTablet(cola);

        int opt;

        do {
            
            opt = ValidarOpcionMenuTablet();

            if (opt != 5) {

                cola = AccionesRegistroTablet(cola, opt);

                if (opt != 4) {

                    MostrarColaTablet(cola);

                }
                
            }

        }

        while (opt != 5);

        System.out.println("Programa finalizado");

    }

    public void MostrarColaTablet(Queue<ObjTablet> cola) {

        String TextoCola = "Cola de Tablets: ";

        for (ObjTablet t : cola) {

            TextoCola += "\nSerial: " + t.getSerial() +
                        "\nMarca: " + t.getMarca() +
                        "\nTamaño: " + t.getTamaño() +
                        "\nPrecio: " + t.getPrecio() +
                        "\nNombre del estudiante: " + t.getNomEstudiante() +
                        "\nCarnet del estudiante: " + t.getCarnet() +
                        "\nDisponible: " + t.getDisponible() + "\n";

        }

        Mensaje(TextoCola);
        
    }

    public Queue<ObjTablet> AccionesRegistroTablet(Queue<ObjTablet> cola, int opt) {

        String dato = JOptionPane.showInputDialog("Ingrese el serial de la tablet: ");
        Queue<ObjTablet> nuevaCola = new ArrayDeque<>();

        if (opt == 1) {

            ObjTablet t = new ObjTablet();

            t.setSerial(JOptionPane.showInputDialog("Ingrese el serial: "));
            t.setMarca(JOptionPane.showInputDialog("Ingrese la marca: "));
            t.setTamaño(Float.parseFloat(JOptionPane.showInputDialog("Ingrese el tamaño: ")));
            t.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio: ")));
            t.setNomEstudiante(JOptionPane.showInputDialog("Ingrese el nombre del estudiante (N/A si está disponible): "));
            t.setCarnet(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el carnet (0 si está disponible): ")));
            t.setDisponible(ValidarDisponibilidad());
            cola.offer(t);

            return cola;

        }

        if (opt == 4) {

            MostrarColaTablet(cola);

            return cola;

        }

        while (!cola.isEmpty()) {

            ObjTablet tablet = cola.poll();

            if (tablet.getSerial().equalsIgnoreCase(dato)) {

                tablet.setNomEstudiante(JOptionPane.showInputDialog("Ingrese el nombre del estudiante (N/A si está disponible): "));
                tablet.setCarnet(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el carnet (0 si está disponible): ")));
                tablet.setDisponible(ValidarDisponibilidad());

            }

            nuevaCola.offer(tablet);

        }

        return nuevaCola;

    }

    public void Mensaje(String Texto) {

        JOptionPane.showMessageDialog(null, Texto);

    }

}
