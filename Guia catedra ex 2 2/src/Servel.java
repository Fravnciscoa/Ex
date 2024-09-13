import java.util.ArrayList;

public class Servel {
    private MiArrayList mesas;

//    Método agregaMesa: recibe un número de mesa y objeto
//    mesa y lo agrega de manera ordenada a su colección de
//    mesas, verificando que no se encuentre repetido. Retorna
//    true al agregarlo o false en caso contrario.

    public boolean agregaMesa(int nMesa, Mesa mesa){
        for (int i = 0; i < mesas.size(); i++){
            Mesa m = (Mesa)mesas.get(i);
            if(m.getNumeroMesa() == nMesa)
                return false;
            else if (m.getNumeroMesa()> nMesa){
                mesas.add(i, mesa);
                return true;
            }
            else if(m.getNumeroMesa()<nMesa){
                mesas.add(i, mesa);
                return true;
            }
        }
    }

//    Método eliminaElector: recibe el rut del elector, lo busca
//    en todas las mesas del Servel y lo elimina. Para ello utiliza
//    el método eliminaElector() de la clase Mesa. Retorna el
//    objeto eliminado o null si no lo encuentra.
    public Elector eliminaElector(String rut){
        for (int i = 0; i < mesas.size(); i++){
            Mesa m = (Mesa)mesas.get(i);
            MegaMapa mapaElectores = m.getElectores();
            if (mapaElectores.estaClave(rut)){
                Elector e = (Elector)mapaElectores.obtiene(rut);
                m.eliminaElector(rut);
                return e;
            }
        }
        return null;
    }

//    Método cuadrarMesas: Recorre todas las mesas
//    cuadrando cada una de ellas. Retorna un arreglo con 3
//    enteros; 1) cantidad de mesas en que efectivamente
//    cuadra la cantidad de votos y electores que asistieron a
//    votar, 2) cantidad de mesas en que la cantidad de votos
//    fue mayor que los electores que asistieron y 3) cantidad
//    de mesas en que la cantidad de electores que asistieron
//    fue mayor que los votos. Debe utilizar el método
//    cuadraMesa() de la Mesa.
    public int[] cuadrarMesas(){
        int cantVotosIguales = 0;
        int cantVotosMayores = 0;
        int cantVotosMenores = 0;
        int [] arrMesasCuadradas = new int[3];
        for(int i = 0; i < mesas.size(); i++){
            Mesa m = (Mesa)mesas.get(i);
            int n = m.cuadraMesa();
            if (n == 0)
                cantVotosIguales++;
            else if (n == 1)
                cantVotosMayores++;
            else if (n == -1)
                cantVotosMenores++;
        }
        arrMesasCuadradas[0] = cantVotosIguales;
        arrMesasCuadradas[1] = cantVotosMayores;
        arrMesasCuadradas[2] = cantVotosMenores;
        return arrMesasCuadradas;


    }

}
