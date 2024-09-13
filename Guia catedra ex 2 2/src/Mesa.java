import java.util.List;

public class Mesa {
    private String circunscripcion;
    private int numeroMesa;
    private MegaMapa electores;
    private ListaElementos votos;

//    Método eliminaElector: que recibe el rut del elector y lo
//    elimina de su colección de electores. Retorna el objeto
//    eliminado o bien null si el elector no existía en la
//    colección.

    public Elector eliminaElector(String rut){
        //Codigo para eliminar
        ListaElementos objetos = electores.obtieneLista();
        if(objetos == null)
            return null;
        for (int i = 0; i < objetos.largo(); i++){
            Elector e = (Elector)objetos.elementoActual();
            if(e.getRut().equals(rut)){
                electores.elimina(rut);
                return e;
            }
        }
        return null;
    }

//    Método cuadraMesa: verifica que la cantidad de votos
//    coincide con la cantidad de electores que asistió a votar.
//    Para ello verifica los electores que votaron y lo compara
//    con la cantidad de votos. En caso de coincidir retorna
//    cero, si la cantidad de votos es mayor que la cantidad de
//    electores que asistieron retorna 1 y -1 si es menor.

    public int cuadraMesa(){
        int cantVotos = votos.largo();
        ListaElementos objetos = electores.obtieneLista();
        int cantElectores = objetos.largo();

        if(cantVotos == cantElectores){
            return 0;
        }
        else if(cantVotos < cantElectores){
            return -1;
        }
        else if(cantVotos > cantElectores){
            return 1;
        }
    }

    public String getCircunscripcion() {
        return circunscripcion;
    }

    public void setCircunscripcion(String circunscripcion) {
        this.circunscripcion = circunscripcion;
    }

    public int getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(int numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public MegaMapa getElectores() {
        return electores;
    }

    public void setElectores(MegaMapa electores) {
        this.electores = electores;
    }

    public ListaElementos getVotos() {
        return votos;
    }

    public void setVotos(ListaElementos votos) {
        this.votos = votos;
    }
}
