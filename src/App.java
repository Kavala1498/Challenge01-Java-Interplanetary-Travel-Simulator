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
    
}