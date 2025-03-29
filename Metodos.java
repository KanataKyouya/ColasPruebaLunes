import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Queue;

import javax.swing.JOptionPane;


public class Metodos {

    public int ValidarOpcionMenu1(){

        try {

            String Mensaje = "Bienvenidos al sistema de prestamos del ITM\n"
                    + "Seleccione a que dispositivos desea acceder:\n"
                    + "1: Pc\n"
                    + "2: Tablet\n"
                    + "3: Salir del sistema";

            int opt = Integer.parseInt(JOptionPane.showInputDialog(Mensaje));

            if (opt == 1){

                return 1;

            } 
            
            else if (opt == 2){

                return 2;

            } 
            
            else if (opt == 3) {

                return 3;

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

    public void Mensaje(String Texto) {

        JOptionPane.showMessageDialog(null, Texto);

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
            o.setNomEstudiante(JOptionPane.showInputDialog("Ingrese el nombre: "));
            o.setCarnet(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el carnet: ")));
            o.setDisponible(Boolean.parseBoolean(JOptionPane.showInputDialog("Ingrese si el computador esta disponible: ")));
            cola.offer(o);

            agregar = JOptionPane.showInputDialog("¿Desea agregar más pc? (S/N)");

            if (agregar.equalsIgnoreCase("N")) {

                continuar = false;

            }

        }

        MostrarCola(cola);

        int opt;

        do {

            opt = Integer.parseInt(JOptionPane.showInputDialog("Ingrese 1: Agregar // 2: Prestar // 3: Devolver // 4: Mostrar inventario // 5: Salir"));
            
            if (opt != 5) {

                cola = AccionesRegistro(cola, opt);
                MostrarCola(cola);

            }

        }
        
        while (opt != 5);

        System.out.println("Programa finalizado");

    }

    public void MostrarCola(Queue<ObjPc> cola) {

        String TextoCola = "Cola de ObjPc: ";

        for (ObjPc r : cola) {

            TextoCola += "\nSerial: " + r.getSerial() +
                        "\nMarca: " + r.getMarca() +
                        "\nMemoria Ram: " + r.getMemRam() +
                        "\nDisco Duro: " + r.getDiscDuro() +
                        "\nPrecio: " + r.getPrecio() +
                        "\nNombre del estudiante: " + r.getNomEstudiante() +
                        "\nCarnet del estudiante: " + r.getCarnet() +
                        "\nDisponible: " + r.getDisponible();

        }

        Mensaje(TextoCola);

    }

    public Queue<ObjPc> AccionesRegistro(Queue<ObjPc> cola, int opt) {

        String dato = JOptionPane.showInputDialog("Ingrese el serial del pc: ");
        Queue<ObjPc> nuevaCola = new ArrayDeque<>();

        while (!cola.isEmpty()) {

            ObjPc pc = cola.poll();  // Saca el primer elemento

            if (pc.getSerial().equalsIgnoreCase(dato)) {

                switch (opt) {

                    case 1: // Consultar

                        System.out.println("Registro encontrado: " + pc.getMarca() + " - $" + pc.getPrecio());
                        break;

                    case 2: // Eliminar

                        System.out.println("Repuesto eliminado: " + pc.getMarca());
                        continue;  // No lo agregamos a la nueva cola

                    case 3: // Modificar

                        pc.setMarca(JOptionPane.showInputDialog("Ingrese la nueva marca"));
                        pc.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la nueva cantidad")));
                        pc.setPrecio(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el nuevo precio")));
                        break;

                    case 4: // Vender

                        int cantidadV = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad a vender"));
                        if (cantidadV <= pc.getCantidad()) {

                            pc.setCantidad(pc.getCantidad() - cantidadV);
                            System.out.println("Venta realizada: " + cantidadV + " unidades vendidas");

                        } 
                        else {

                            System.out.println("Error: No hay suficiente stock");

                        }

                        break;

                }

            }

            nuevaCola.offer(pc);

        }

        return nuevaCola;
        
    }
    

}
