import java.util.Map;

public class Moneda {
    private String base_code;
    private Map<String, Double> conversion_rates;

    // Getter para base_code
    public String getBase_code() {
        return base_code;
    }

    // Getter para conversion_rates
    public Map<String, Double> getConversion_rates() {
        return conversion_rates;
    }

    // Método alternativo para acceder a las tasas de conversión
    public Double getConversionRate(String currency) {
        return conversion_rates.get(currency);
    }
}