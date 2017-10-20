package memorex.progrid.base;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by progrid on 19/10/17.
 */
public class ManipuladorJson {

    public static Mes jsonMesToBase(String jsonText) throws JSONException{
        Mes mes = null;

        JSONObject json_load = new JSONObject(jsonText);

        if(json_load != null) {
            JSONObject json_mes = json_load.getJSONObject("mes");

            if (json_mes != null) {

                mes = new Mes();
                mes.setMes(json_mes.getInt("mes"));
                mes.setAno(json_mes.getInt("ano"));

                JSONArray json_dias = json_mes.getJSONArray("dias");

                for (int i = 0; i < json_dias.length(); i++) {
                    JSONObject json_dia = (JSONObject) json_dias.get(i);

                    Dia dia = new Dia();
                    dia.setDia(json_dia.getInt("dia"));

                    mes.getDias().add(dia);

                    JSONArray json_titulos = json_dia.getJSONArray("titulos");

                    for (int j = 0; j < json_titulos.length(); j++) {
                        JSONObject json_titulo = (JSONObject) json_dias.get(j);

                        Item item = new Item();
                        item.setId(json_titulo.getInt("id"));
                        item.setSinal(json_titulo.getInt("sinal"));
                        item.setGrupo(json_titulo.getInt("grupo"));
                        item.setNome(json_titulo.getString("nome"));
                        item.setValor(json_titulo.getString("valor"));

                        dia.getItens().add(item);

                    }
                }
            }
        }

        return mes;
    }

    public static Item jsonItemToBase(String json){
        Item item = null;



        return item;
    }

}
