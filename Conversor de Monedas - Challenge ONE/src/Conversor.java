import java.util.Scanner;

public class Conversor {

    public Float convertirMoneda(String monedaA, String monedaB) {
        ClienteHttp cliente = new ClienteHttp();
        Scanner teclado = new Scanner(System.in);
        Float valorMoneda = 0.0f;
        Float valorConvertir = 0.0f;

        valorMoneda = cliente.getValorMonedaAMonedaB(monedaA, monedaB);
        teclado = new Scanner(System.in);
        System.out.println("Ingrese el valor a convertir: ");
        valorConvertir = teclado.nextFloat();
        System.out.println("El valor de "+valorConvertir+ " " + monedaA+" corresponde al valor final de =>>>"+
                convertirAMoneda(valorConvertir, valorMoneda)+" "+ monedaB);
        return 3.0f;
    }

    private Float convertirAMoneda(Float valorConvertir, Float valorMoneda) {
        return valorConvertir * valorMoneda;
    }
}
