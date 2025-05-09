import java.util.Date;

public class Movimiento {
    Float valorAConvertir;
    Float valorMoneda;
    Float valorConvertido;
    String monedaAConvertir;
    String monedaReferencia;
    Date fecha;

    public Movimiento(Float valor, Float valorConvertido, Float valorMoneda,String monedaAConvertir, String monedaReferencia) {
        this.valorAConvertir = valor;
        this.valorMoneda = valorMoneda;
        this.valorConvertido = valorConvertido;
        this.monedaAConvertir = monedaAConvertir;
        this.monedaReferencia = monedaReferencia;
        this.fecha = new Date();
    }

    @Override
    public String toString() { return
        "################################################# \n" +
                "Conversion de " + this.monedaReferencia + " a " + this.monedaAConvertir + "\n" +
                "Valor a convertir : " + this.valorAConvertir +  "\n" +
                "Valor moneda : " + this.valorMoneda + "\n" +
                "Valor conversion : " + this.valorConvertido + "\n" +
                "Fecha : " + this.fecha +
                "\n #################################################";
    }
}
