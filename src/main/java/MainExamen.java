import prClubDeportivo.ClubDeportivo;
import prClubDeportivo.ClubDeportivoAltoRendimiento;

public class MainExamen {
    public static void main(String[] args) {
        // PRUEBA 1: crear club deportivo
        ClubDeportivo club = new ClubDeportivo("UMA", 3);
        club.anyadirActividad(new String[]{"456B", "Pilates", "8", "5", "50.0"});
        club.anyadirActividad(new String[]{"123A", "Danza", "10", "3", "50.0"});
        club.anyadirActividad(new String[]{"789C", "Pilates", "10", "7", "30.0"});
        System.out.println(club);

        // PRUEBA 2: calcular ingresos
        System.out.println("Ingresos del club: " + club.ingresos());

        // PRUEBA 3: crear club deportivo alto rendimiento
        ClubDeportivoAltoRendimiento clubAR = new ClubDeportivoAltoRendimiento("UMA", 2, 5, 0.1);
        clubAR.anyadirActividad(new String[]{"456B", "Pilates", "8", "5", "50.0"});
        clubAR.anyadirActividad(new String[]{"123A", "Danza", "10", "3", "50.0"});
        System.out.println(clubAR);

        // PRUEBA 4: calcular ingresos
        System.out.println("Ingresos del club de alto rendimiento: " + clubAR.ingresos());

        // PRUEBA 5: intentar aumentar las plazas del grupo de Pilates a 10
        clubAR.anyadirActividad(new String[]{"456B", "Pilates", "10", "5", "50.0"});
        System.out.println(clubAR);
    }
}