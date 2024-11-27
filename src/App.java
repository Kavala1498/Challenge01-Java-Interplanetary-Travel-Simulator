import java.util.Scanner;
import java.util.InputMismatchException;

public class App {
    static Scanner scanner = new Scanner(System.in);
    static String[] planetas = {
        "Mercurio", "Venus", "Marte", "Júpiter", 
        "Saturno", "Urano", "Neptuno", "Plutón", "Ceres", 
        "Eris", "Haumea", "Makemake"
    };

    static String[] descripcionPlaneta = {
        "Cocinándose a temperaturas extremas.", "Densa la atmósfera.", 
        "De aquí vienen los comunistas (el planeta rojo).", 
        "Tormentas, gases y vientos de más de 500 Km/h.", 
        "El señor de los anillos y lunas.", "Un gigante de hielo.",
        "Con los vientos más veloces del sistema solar.", 
        "Enano, de órbita única y elíptica", "El pequeñito del cinturón.",
        "Enano al borde del sistema.", "Rotación rápida, elíptico y enano.", 
        "El último enano de hielo."
    };


    static double[] distancias = {
        77.0, 41.0, 628.0, 1275.0, 2723.0, 4351.0, 5906.0, 5910.0, 413.0, 
        10100.0, 13000.0, 6700.0
    };
    
    static String[] naves = {
        "Prometheus Ark", "Astra Nova", "Cosmos Seeker",
        "Luminous Horizon", "Galactic Dawn"
    };

    static String[] capacidadNave = { 
        "1111 pasajeros", "300 pasajeros + 1000 embriones + 30 tripulantes + 3 deidades",
        "1518 pasajeros, 12 tripulantes y 25 científicos", 
        "200 pasajeros + 150 embriones + 25 científicos + 25 granjeros + 20 connoisseurs",
        "40 pasajeros + 20 aprendices + 9 tripulantes"

    };
    
    public static void main(String[] args) {
        int opción;
        System.out.println("\n*****Bienvenido al Menú Principal***** \n****escoge una opción para empezar****");
        do {
            mostrarMenu();
            try {
                opción = scanner.nextInt();
                switch (opción) {
                    case 1:
                        seleccionarPlaneta();
                        break;
                    case 2:
                        seleccionarNave();
                        break;
                    case 3:
                        calcularRecursos();
                        break;
                    case 4:
                        simularViaje();
                        break;
                    case 5:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                scanner.next(); // Limpiar el buffer
                opción = -1;
            }
        } while (opción != 5);
    }




    // Mostrar menú principal
    public static void mostrarMenu() {
        System.out.println("\n----- Menú Principal -----");
        System.out.println("1. Selecciona un planeta");
        System.out.println("2. Selecciona una nave");
        System.out.println("3. Calcular recursos necesarios");
        System.out.println("4. Simular viaje");
        System.out.println("5. Salir");
        System.out.print("Opción seleccionada: ");
    }

    // Seleccionar un planeta
    public static void seleccionarPlaneta() {
        System.out.println("\nSelecciona un planeta:");
        for (int i = 0; i < planetas.length; i++) {
            // Imprime el planeta junto con su distancia
            System.out.println((i + 1) + ". " + planetas[i] + " (Distancia: " + distancias[i] + " millones de km.)");            
        }
        System.out.print("Selecciona el número del planeta: ");
        planetaSeleccionado = scanner.nextInt() - 1;
        if (planetaSeleccionado >= 0 && planetaSeleccionado < planetas.length) {
            System.out.println("Has seleccionado: " + planetas[planetaSeleccionado]);
            System.out.println(descripcionPlaneta[planetaSeleccionado]);
        } else {
            System.out.println("Selección no válida.");
        }
    }

    // Seleccionar una nave
    public static void seleccionarNave() {
        System.out.println("\nSelecciona una nave:");
        for (int i = 0; i < naves.length; i++) {
            System.out.println((i + 1) + ". " + naves[i] + " (Velocidad: " + velocidades[i] + " km/h)");
            System.out.println(capacidadNave[i]);
        }
        System.out.print("Selecciona el número de la nave: ");
        naveSeleccionada = scanner.nextInt() - 1;
        if (naveSeleccionada >= 0 && naveSeleccionada < naves.length) {
            System.out.println("Has seleccionado: " + naves[naveSeleccionada]);
        } else {
            System.out.println("Selección no válida.");
        }
    }

    // Calcular recursos necesarios
    public static void calcularRecursos() {
        if (planetaSeleccionado == -1 || naveSeleccionada == -1) {
            System.out.println("\nDebes seleccionar primero un planeta y una nave.");
            return;
        }

        double distancia = distancias[planetaSeleccionado] * 1000000; // Conversión a km
        double velocidad = velocidades[naveSeleccionada];

        System.out.print("Introduce la cantidad de pasajeros: ");
        int pasajeros = scanner.nextInt();

        double tiempoViaje = calcularTiempoViaje(distancia, velocidad);
        double combustibleRequerido = distancia * consumoCombustiblePorKm;
        double oxigenoRequerido = distancia * consumoOxigenoPorPasajero * pasajeros;

        System.out.println("\nRecursos necesarios:");
        System.out.println("Combustible: " + combustibleRequerido + " litros");
        System.out.println("Oxígeno: " + oxigenoRequerido + " unidades");
        System.out.println("Tiempo estimado de viaje: " + tiempoViaje / 24 + " dias (o " + (tiempoViaje / 8766) + " años)");
    }

    // Calcular tiempo de viaje
    public static double calcularTiempoViaje(double distancia, double velocidad) {
        return distancia / velocidad;
    }

    // Simular eventos aleatorios
    public static void simularEventos() {
        String[] eventos = {
            "Falla en el sistema de navegación",
            "Impacto con un asteroide",
            "Pérdida de oxígeno",
            "Retraso por una tormenta solar"
        };
        int evento = (int) (Math.random() * eventos.length);

        System.out.println("\n¡Evento inesperado! " + eventos[evento]);
        switch (evento) {
            case 0:
                System.out.println("Reparando el sistema...");
                break;
            case 1:
                System.out.println("Desviando la nave para evitar daños mayores...");
                break;
            case 2:
                System.out.println("Redistribuyendo los suministros de oxígeno...");
                break;
            case 3:
                System.out.println("Ajustando el curso para minimizar el impacto...");
                break;
            
        }
    }

    // Simular viaje
    public static void simularViaje() {
        if (planetaSeleccionado == -1 || naveSeleccionada == -1) {
            System.out.println("\nDebes seleccionar primero un planeta y una nave.");
            return;
        }

        double distancia = distancias[planetaSeleccionado] * 1000000;
        double velocidad = velocidades[naveSeleccionada];
        double tiempoTotal = calcularTiempoViaje(distancia, velocidad);

        System.out.println("\nSimulando viaje a " + planetas[planetaSeleccionado] + "...");
        for (int i = 0; i <= 100; i += 10) {
            if (i == 0) System.out.print("Empieza una nueva aventura ");
            else if (i == 50) System.out.print("Medio camino ");
            else if (i == 90) System.out.print("¿¡Ya merito llegamos!? ");        
            System.out.println("Progreso: " + i + "%");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if (i == 50) simularEventos(); // Aquí simula un evento aleatorio
        }
        System.out.println("\n¡Bienvenides todes a " + planetas[planetaSeleccionado] + "! \nllegamos en " + tiempoTotal / 24 + " dias \n(o " + (tiempoTotal / 8766) + " años)");
    }
}