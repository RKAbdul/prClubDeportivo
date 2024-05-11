package prClubDeportivo;

import java.util.Objects;
import java.util.StringJoiner;

public class Grupo {
    private String codigo;
    private String actividad;
    private int nplazas;
    private int nmatriculados;
    private double tarifa;

    public Grupo(String codigoGrupo, String actividadGrupo, int plazasTotal, int numeroDeMatriculados, double tarifa)
    {
        if (plazasTotal <= 0 || numeroDeMatriculados <= 0 || tarifa <= 0 || numeroDeMatriculados > plazasTotal) {
            throw new ClubException("Datos Erroneos!");
        }
        this.codigo = codigoGrupo;
        this.actividad = actividadGrupo;
        this.nplazas = plazasTotal;
        this.nmatriculados = numeroDeMatriculados;
        this.tarifa = tarifa;
    }

    public int plazasLibres() {
        return nplazas - nmatriculados;
    }

    public void actualizarPlazas(int n) {
        if (n <= 0 || n < nmatriculados) {
            throw new ClubException("Numero De Plazas Nuevas No Son Validas!");
        }
        nplazas = n;
    }

    public void matricular(int n) {
        if (n <= 0 || n > plazasLibres()) {
            throw new ClubException("Numero De Matriculaciones No Son Validas!");
        }
        nmatriculados++;
    }

    @Override
    public String toString() {
        StringJoiner str = new StringJoiner(" - ", "(", ")");
        str.add(codigo);
        str.add(actividad);
        str.add(String.valueOf(tarifa));
        str.add("P:" + nplazas);
        str.add("M:" + nmatriculados);
        return str.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Grupo c && hashCode() == c.hashCode();
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo.toUpperCase(), actividad.toUpperCase());
    }

    public String getCodigo() {
        return codigo;
    }

    public String getActividad() {
        return actividad;
    }

    public int getPlazas() {
        return nplazas;
    }

    public int getMatriculados() {
        return nmatriculados;
    }

    public double getTarifa() {
        return tarifa;
    }
}
