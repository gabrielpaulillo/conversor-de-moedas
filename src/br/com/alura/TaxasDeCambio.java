package br.com.alura;

public class TaxasDeCambio {
//    Atributos que remetem aos campos do arquivo .json.
//    São utilizados para acessarem os dados contidos no arquivo .json.
    private String result;
    private String documentation;
    private String terms_of_use;
    private long time_last_update_unix;
    private String time_last_update_utc;
    private long time_next_update_unix;
    private String time_next_update_utc;
    private String base_code;
    private TaxasDeConversao conversion_rates;

    public TaxasDeConversao getConversion_rates() {
        return conversion_rates;
    }
}
