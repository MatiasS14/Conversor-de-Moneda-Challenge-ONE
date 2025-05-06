import java.util.Date;

public class Movimiento {
    Float valorAConvertir;
    Float valorConversion;
    String monedaAConvertir;
    String monedaReferencia;
    Date fecha;

    public Movimiento(Float valor, Float valorConversion, String monedaAConvertir, String monedaReferencia) {
        this.valorAConvertir = valor;
        this.valorConversion = valorConversion;
        this.monedaAConvertir = monedaAConvertir;
        this.monedaReferencia = monedaReferencia;
        this.fecha = new Date();
    }

    @Override
    public String toString() {
        String ret ="################################################# \n" +
                "Conversion de " + this.monedaReferencia + " a " + this.monedaAConvertir + "\n" +
                "Valor a convertir : " + this.valorAConvertir +  "\n" +
                "Valor conversion : " + this.valorConversion + "\n" +
                "Fecha : " + this.fecha +
                "\n #################################################";
        return ret;
    }
}
