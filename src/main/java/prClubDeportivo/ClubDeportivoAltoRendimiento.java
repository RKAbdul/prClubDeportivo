package prClubDeportivo;

public class ClubDeportivoAltoRendimiento extends ClubDeportivo {
    private int numeroMaxDePlazasPermitidas;
    private double porcentajeDeIncremento;

    public ClubDeportivoAltoRendimiento(String nombre, int tamInicial, int numeroMaxDePlazasPermitidas, double porcentajeDeIncremento) {
        super(nombre, tamInicial);
        this.numeroMaxDePlazasPermitidas = numeroMaxDePlazasPermitidas;
        this.porcentajeDeIncremento = porcentajeDeIncremento;
    }

    public ClubDeportivoAltoRendimiento(String nombre, int numeroMaxDePlazasPermitidas, double porcentajeDeIncremento) {
        super(nombre);
        this.numeroMaxDePlazasPermitidas = numeroMaxDePlazasPermitidas;
        this.porcentajeDeIncremento = porcentajeDeIncremento;
    }

    @Override
    public void anyadirActividad(String[] datos) {
        try {
            int plazasTotal = Math.min(Integer.parseInt(datos[2]), numeroMaxDePlazasPermitidas);
            super.anyadirActividad(new Grupo(datos[0], datos[1],
                    plazasTotal, Integer.parseInt(datos[3]),
                    Double.parseDouble(datos[4])));
        } catch (NumberFormatException e) {
            throw new ClubException("Formato INADECUADO: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            throw new ClubException("Faltan Datos");
        }
    }

    @Override
    public double ingresos() {
        return super.ingresos() * (1 + porcentajeDeIncremento);
    }
}
