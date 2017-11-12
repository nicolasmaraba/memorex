package memorex.progrid.http;

import android.util.Log;

public class URLsolicita {

    public String jsonToObject(){
        /**Cria Objetos para Converter de JSON para objetos*/
        AcessoRest ar = new AcessoRest();
        //Cliente c = new Cliente();
        //Para chamar os dados depois
        //String obtemAgencia = c.getAge();
        //String obtemConta = c.getCc();
        //String obtemData = c.getData();
        String obtemAgencia = "11";
        String obtemConta = "22";
        String obtemData = "03112017";
        String chamadaWs = "http://192.168.70.2:8084/MemorexWs/webresources/memorex/memorex/dadositemBusca/" +
                obtemAgencia + "/" + obtemConta + "/" + obtemData;

        String resultado = ar.chamadaGet(chamadaWs);//recebendo o resultado da chamada
        Log.i("JSON", resultado);//Para ver a chamada no Log

        return resultado;
    }
}
