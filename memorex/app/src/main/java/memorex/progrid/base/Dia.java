package memorex.progrid.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by progrid on 19/10/17.
 */
public class Dia implements Serializable {

    private int dia;

    private List<Item> itens;


    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public List<Item> getItens() {
        if (this.itens == null)
            this.itens = new ArrayList<Item>();
        return this.itens;
    }

    public void setItens(List<Item> itens) {
        this.itens = itens;
    }
}
