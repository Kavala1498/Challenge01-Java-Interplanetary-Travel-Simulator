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