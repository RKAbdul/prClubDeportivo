import prClubDeportivo.ClubDeportivo;
import prClubDeportivo.ClubException;

public class ClubDeportivoMain {
    public static void main(String[] args) {
        // Crear un club
        ClubDeportivo club = new ClubDeportivo("UMA", 1);

        // Añadir dos grupos al club
        String[] grupo1 = {"123A", "Pilates", "10", "10", "50.0"};
        String[] grupo2 = {"789C", "Danza", "10", "10", "30.0"};
        club.anyadirActividad(grupo1);
        club.anyadirActividad(grupo2);
        System.out.println(club);

        // Añadir un tercer grupo al club
        String[] grupo3 = {"789C", "Danza", "20", "10", "30.0"};
        club.anyadirActividad(grupo3);
        System.out.println(club);

        // Mostrar los ingresos del club
        System.out.println("Ingresos del club: " + club.ingresos());

        // Intentar añadir un cuarto grupo con datos incorrectos al club
        String[] grupo4 = {"456B", "Pilates", "8Ax", "10", "50.0"};
        try {
            club.anyadirActividad(grupo4);
        } catch (ClubException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}