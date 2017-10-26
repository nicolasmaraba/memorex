package memorex.progrid.base;

import android.app.Application;

import java.util.Date;

/**
 * Created by progrid on 19/10/17.
 */
public class Common extends Application {

    public static Mes mes = null;
    public static Date diaCorrente;


    public Dia getDate(int intDia, int intMes, int intANo){
        Dia dia = null;

        for (int i = 0; i < mes.getDias().size(); i++) {
            Dia aux_dia = mes.getDias().get(i);
            if (aux_dia.getDia() == intDia && aux_dia.getMes() == intMes && aux_dia.getAno() == intANo)
                dia = aux_dia;
        }

        return dia;
    }

}
