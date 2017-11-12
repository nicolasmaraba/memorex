package memorex.progrid.http;

import android.os.StrictMode;
import android.util.Log;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class AcessoRest {
    private int  TIMEOUT_MILLISEC = 3000;
    //Usar o método chamadaGet para solicitar o REST para o WebService
    public String chamadaGet(String url)
    {
        HttpClient httpclient = new DefaultHttpClient();
        HttpGet chamadaget = new HttpGet(url);
        String retorno = "";
        // Inicia a GET HTTP method
        try {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            ResponseHandler<String> responseHandler = new BasicResponseHandler();
            String responseBody = httpclient.execute(chamadaget,
                    responseHandler);
            retorno = responseBody;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Throwable t) {
            Log.i("erro", t.toString());
        }
        return retorno;
    }
}
