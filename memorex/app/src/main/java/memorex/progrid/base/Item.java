package memorex.progrid.base;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by progrid on 19/10/17.
 */
public class Item implements Serializable {

    private int id;
    private String nome;

    private String emissor;
    private String valor;
    private Date data_agendamento;
    private String codigo_barra;

    private int sinal;
    private int grupo;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmissor() {
        return emissor;
    }

    public void setEmissor(String emissor) {
        this.emissor = emissor;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public Date getData_agendamento() {
        if (data_agendamento== null)
            data_agendamento = new Date(1900,01,01);
        return data_agendamento;
    }

    public void setData_agendamento(Date data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public String getCodigo_barra() {
        return codigo_barra;
    }

    public void setCodigo_barra(String codigo_barra) {
        this.codigo_barra = codigo_barra;
    }

    public int getSinal() {
        return sinal;
    }

    public void setSinal(int sinal) {
        this.sinal = sinal;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }
}
