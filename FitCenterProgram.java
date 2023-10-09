import java.util.Scanner;
import java.util.Random;

public class FitCenterProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Variables para el usuario
        String nombre = "";
        int edad = 0;
        double peso = 0.0;
        double altura = 0.0;
        int puntos = 0;
        int desafiosCompletados = 0;
        int retosCompletados = 0;
        String categoria = "";

        // Rutinas de ejercicio disponibles
        String[] rutinas = {
            "Realiza 20 flexiones.",
            "Haz 30 segundos de plancha.",
            "Completa 15 sentadillas.",
            "Corre durante 10 minutos."
        };

        // Menú principal
        while (true) {
            System.out.println("=====================================");
            System.out.println("Pablo's Amazing Fit Center");
            System.out.println("=====================================");
            System.out.println("1. Registrarte");
            System.out.println("2. Empezar desafíos personalizados");
            System.out.println("3. Juegos");
            System.out.println("4. Retos");
            System.out.println("5. Avance");
            System.out.println("6. Eliminar usuario");
            System.out.println("0. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.println("Registro de usuario:");
                    scanner.nextLine(); // Limpia el buffer
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    edad = scanner.nextInt();
                    System.out.print("Peso (kg): ");
                    peso = scanner.nextDouble();
                    System.out.print("Altura (m): ");
                    altura = scanner.nextDouble();

                    // Calcular el IMC y asignar la categoría
                    double imc = peso / (altura * altura);
                    if (imc < 18.5) {
                        categoria = "Delgadez o bajo peso";
                    } else if (imc >= 18.5 && imc <= 24.9) {
                        categoria = "Peso saludable";
                    } else if (imc >= 25.0 && imc <= 29.9) {
                        categoria = "Sobrepeso";
                    } else {
                        categoria = "Obesidad";
                    }

                    // Inicializar atributos
                    puntos = 0;
                    desafiosCompletados = 0;
                    retosCompletados = 0;

                    System.out.println("Usuario registrado exitosamente.");
                    System.out.println("Categoría según IMC: " + categoria);
                    break;

                case 2:
                if (nombre.isEmpty()) {
                    System.out.println("Debes registrarte antes de empezar desafíos.");
                } else {
                    System.out.println("Desafíos personalizados:");
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Categoría según IMC: " + categoria);
                    
                    // Mostrar rutina según la categoría del IMC
                    if (categoria.equals("Delgadez o bajo peso")) {
                        System.out.println("Rutina para Delgadez o bajo peso:");
                        System.out.println("1. Realiza 20 minutos de cardio.");
                        System.out.println("2. Haz 3 series de 15 repeticiones de sentadillas.");
                    } else if (categoria.equals("Peso saludable")) {
                        System.out.println("Rutina para Peso saludable:");
                        System.out.println("1. Realiza 30 minutos de cardio.");
                        System.out.println("2. Haz 3 series de 12 repeticiones de abdominales.");
                    } else if (categoria.equals("Sobrepeso")) {
                        System.out.println("Rutina para Sobrepeso:");
                        System.out.println("1. Realiza 40 minutos de cardio.");
                        System.out.println("2. Haz 4 series de 10 repeticiones de flexiones.");
                    } else if (categoria.equals("Obesidad")) {
                        System.out.println("Rutina para Obesidad:");
                        System.out.println("1. Realiza 50 minutos de cardio.");
                        System.out.println("2. Haz 4 series de 12 repeticiones de plancha.");
                    }

                    // Actualizar desafíos completados
                    System.out.print("¿Has completado la rutina? (Presiona 1 para sí, 0 para no): ");
                    int completado = scanner.nextInt();
                    if (completado == 1) {
                        desafiosCompletados++;
                        puntos++; // Aumentar puntos por completar desafío
                        System.out.println("Desafío completado. ¡Buen trabajo!");
                    } else {
                        System.out.println("Desafío no completado. ¡Sigue esforzándote!");
                    }
                }
                    break;

                case 3:
                    if (nombre.isEmpty()) {
                        System.out.println("Debes registrarte antes de jugar.");
                    } else {
                        System.out.println("Juegos - Retos de Ejercicio:");

                        // Variables para controlar el juego
                        int retosCompletadosCategoria = 0;
                        int retosTotales = 4; // Cambia este valor si deseas más retos

                        // Implementación de retos de ejercicio aleatorios
                        while (retosCompletadosCategoria < retosTotales) {
                            System.out.println("Reto de ejercicio " + (retosCompletadosCategoria + 1) + ":");
                            String rutinaAleatoria = rutinas[random.nextInt(rutinas.length)];
                            System.out.println(rutinaAleatoria);
                            System.out.print("Presiona 1 para completar el reto o 2 para dejarlo a medias: ");
                            int eleccion = scanner.nextInt();

                            if (eleccion == 1) {
                                retosCompletadosCategoria++;
                                puntos++; // Aumentar puntos por completar el reto
                                System.out.println("Reto completado. ¡Excelente!");
                            } else if (eleccion == 2) {
                                System.out.println("Reto dejado a medias.");
                                break; // Salir del juego si se deja un reto a medias
                            } else {
                                System.out.println("Opción no válida. Presiona 1 para completar el reto o 2 para dejarlo a medias.");
                            }
                        }

                        System.out.println("Juego terminado. Has completado " + retosCompletadosCategoria + " retos.");
                    }
                    break;

                case 4:
                    if (nombre.isEmpty()) {
                        System.out.println("Debes registrarte antes de participar en retos.");
                    } else {
                        System.out.println("Reto de ejercicio:");
                        String rutinaAleatoria = rutinas[random.nextInt(rutinas.length)];
                        System.out.println(rutinaAleatoria);

                        // Implementación de un desafío de ejercicio
                        System.out.print("¿Has completado el reto? (Presiona 1 para sí, 0 para no): ");
                        int completado = scanner.nextInt();
                        if (completado == 1) {
                            retosCompletados++;
                            puntos++; // Aumentar puntos por completar el reto
                            System.out.println("Reto completado. ¡Excelente!");
                        } else {
                            System.out.println("Reto no completado. ¡Sigue intentándolo!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Avance:");
                    System.out.println("Puntos totales acumulados: " + puntos);
                    System.out.println("Desafíos completados: " + desafiosCompletados);
                    System.out.println("Retos completados: " + retosCompletados);
                    break;

                case 6:
                    System.out.println("Usuario eliminado.");
                    // Reiniciar datos del usuario
                    nombre = "";
                    edad = 0;
                    peso = 0.0;
                    altura = 0.0;
                    puntos = 0;
                    desafiosCompletados = 0;
                    retosCompletados = 0;
                    categoria = "";
                    break;

                case 0:
                    System.out.println("Gracias por usar Pablo's Amazing Fit Center. ¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no válida. Por favor, selecciona una opción válida.");
            }
        }
    }
}


