package memorex.progrid.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by progrid on 19/10/17.
 */
public class Mes {

    private int mes;
    private int ano;

    private List<Dia> dias;


    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Dia> getDias() {
        if (this.dias == null)
            this.dias = new ArrayList<Dia>();
        return dias;
    }

    public void setDias(List<Dia> dias) {
        this.dias = dias;
    }
}
