import prClubDeportivo.Grupo;

public class GrupoMain {
    public static void main(String[] args) {
        // Crear el primer grupo
        Grupo grupo1 = new Grupo("456B", "Pilates", 8, 5, 50.0);
        System.out.println(grupo1);

        // Crear el segundo grupo
        Grupo grupo2 = new Grupo("123A", "Aerobic", 15, 10, 30.0);
        System.out.println(grupo2);

        // Comparar los dos grupos
        boolean sonIguales = grupo1.equals(grupo2);
        System.out.println("Los grupos son iguales: " + sonIguales);

        // Matricular a 10 alumnos en el grupo 123A
        for (int i = 0; i < 10; i++) {
            grupo2.matricular(1);
        }
        System.out.println(grupo2);
    }
}