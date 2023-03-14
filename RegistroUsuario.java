import java.util.Arrays;
import java.util.Scanner;

public class RegistroUsuario {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        // Pedimos al usuario que introduzca su nombre
        System.out.print("Introduce tu nombre: ");
        String nombre = scanner.nextLine();
        
        // Pedimos al usuario que introduzca su correo electrónico
        System.out.print("Introduce tu correo electrónico: ");
        String email = scanner.nextLine();
        
        // Pedimos al usuario que introduzca su contraseña
        System.out.print("Introduce tu contraseña: ");
        String password = scanner.nextLine();
        
        // Pedimos al usuario que introduzca el código de seguridad
        System.out.print("Introduce el código de seguridad: ");
        String codigo = scanner.nextLine();
        
        scanner.close();
        
        // Creamos una instancia de la clase ValidarCampos
        ValidarCampos validador = new ValidarCampos();
        
        // Validamos los campos introducidos por el usuario
        boolean nombreValido = validador.compruebaNombre(nombre);
        boolean emailValido = validador.compruebaEmail(email);
        boolean passwordValido = validador.compruebaPassword(password);
        boolean codigoValido = validador.compruebaCodigoSeguridad(codigo);
        
        // Comprobamos si todos los campos son válidos
        if (nombreValido && emailValido && passwordValido && codigoValido) {
            // Si todos los campos son válidos, imprimimos el mensaje de éxito
            System.out.println("El registro se ha realizado con éxito");
        } else {
            // Si algún campo no es válido, imprimimos un mensaje de error
            System.out.println("Error en el registro. Por favor, revisa los campos introducidos.");
        }
    }
}

class ValidarCampos {
    
    // Array con 10 nombres para comprobar si el nombre introducido ya existe
    private String[] nombresExistentes = {"Juan", "Pedro", "Ana", "Luisa", "Miguel", "Carla", "Sofía", "José", "María", "David"};
    
    // Comprueba que el nombre de usuario cumple con las restricciones

public static boolean compruebaNombre(String nombre) {
    // Comprobamos que el nombre cumple con las restricciones
    String regex = "^[A-Z][a-z]+[_-]\\d{3}$"; // Expresión regular para el formato del nombre
    if (!nombre.matches(regex)) {
        return false;
    }

    // Comprobamos que el nombre no existe en la base de datos
    String[] nombres = {"Juan-123", "Ana_456", "Pedro-789", "Sara_012", "Luisa-345", "Miguel_678", "Sofia-901", "Pablo_234", "Elena-567", "Ramon_890"};
    for (String n : nombres) {
        if (nombre.equals(n)) {
            return false;
        }
    }
    return true;
    }
public class CompruebaPassword {
    public static boolean validarPassword(String password) {
        boolean esValido = false;
        String patron = "^(?=.*[A-Z])(?=.*[@\\-_#])(?=.*[0-9]{2}).{8}$";
        esValido = password.matches(patron);
        return esValido;
    }
}
}