package errorhandler;

public class ErrorHandler {
    public static ErrorCodes handleError(ErrorCodes errorCode) {
        // Aquí puedes implementar lógica adicional, como registrar el error
        System.out.println("Código de error: " + errorCode + " - " + errorCode.getStatus());
        // Notificar al usuario
        return errorCode;
    }

    private static void notifyUser(ErrorCodes errorCodes) {
        // Lógica para notificar al usuario
        System.out.println("Notificación al usuario: " + errorCodes.getStatus());
    }
}
