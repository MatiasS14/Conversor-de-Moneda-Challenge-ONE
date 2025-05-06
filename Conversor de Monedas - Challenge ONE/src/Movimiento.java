import java.util.Date;

public class Movimiento {
    Float valorAConvertir;
    Float valorMoneda;
    Float valorConvertido;
    String monedaAConvertir;
    String monedaReferencia;
    Date fecha;

    public Movimiento(Float valor, Float valorConvertido, Float valorMoneda,String monedaAConvertir, String monedaReferencia) {
        System.out.println("Creacion de movimiento");
        System.out.println("Valor a convertir : " + valor);
        System.out.println("Valor moneda : " + valorMoneda);
        System.out.println("Valor de conversion: " + valorConvertido);
        this.valorAConvertir = valor;
        this.valorMoneda = valorMoneda;
        this.valorConvertido = valorConvertido;
        this.monedaAConvertir = monedaAConvertir;
        this.monedaReferencia = monedaReferencia;
        this.fecha = new Date();
    }

    @Override
    public String toString() {
        String ret ="################################################# \n" +
                "Conversion de " + this.monedaReferencia + " a " + this.monedaAConvertir + "\n" +
                "Valor a convertir : " + this.valorAConvertir +  "\n" +
                "Valor moneda : " + this.valorMoneda + "\n" +
                "Valor conversion : " + this.valorConvertido + "\n" +
                "Fecha : " + this.fecha +
                "\n #################################################";
        return ret;
    }
}
