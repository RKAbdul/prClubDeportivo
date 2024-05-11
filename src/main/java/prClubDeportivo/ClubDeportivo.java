package prClubDeportivo;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class ClubDeportivo {
     private String nombre;
     private List<Grupo> listaGrupos;
     private int ngrupos;

     final private int TAM = 10;

     public ClubDeportivo(String nombre) {
         this.nombre = nombre;
         this.listaGrupos = new ArrayList<>(TAM);
         this.ngrupos = 0;
     }

    public ClubDeportivo(String nombre, int tamInicial) {
        this.nombre = nombre;
        this.listaGrupos = new ArrayList<>(tamInicial);
        this.ngrupos = 0;
    }

    public int buscar(Grupo g) {
         return listaGrupos.indexOf(g);
    }

    public void anyadirActividad(String[] datos) {
        try {
            anyadirActividad(new Grupo(datos[0], datos[1],
                    Integer.parseInt(datos[2]), Integer.parseInt(datos[3]),
                    Double.parseDouble(datos[4])));
        } catch (NumberFormatException e) {
            throw new ClubException("Formato INADECUADO: " + e.getMessage());
        } catch (IndexOutOfBoundsException e) {
            throw new ClubException("Faltan Datos");
        }
    }

    protected void anyadirActividad(Grupo g) {
         int pos = buscar(g);
         if (pos < 0) {
             listaGrupos.add(g);
         } else {
             listaGrupos.get(pos).actualizarPlazas(g.getPlazas());
         }
         ngrupos++;
    }

    public int plazasLibres(String actividad) {
         int plazaslibres = 0;
         for (Grupo g : listaGrupos) {
             if (g.getActividad().equalsIgnoreCase(actividad)) {
                 plazaslibres += g.plazasLibres();
             }
         }
         return plazaslibres;
    }

    public double ingresos() {
         double ingresosTotal = 0;
         for (Grupo g : listaGrupos) {
             ingresosTotal += g.getMatriculados() * g.getTarifa();
         }
         return ingresosTotal;
    }

    @Override
    public String toString() {
        StringJoiner str = new StringJoiner(", ", nombre + " --> [ ", " ]");
        for (Grupo g : listaGrupos) {
            str.add(g.toString());
        }
        return str.toString();
    }
}
