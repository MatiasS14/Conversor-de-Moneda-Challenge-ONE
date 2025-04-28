import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        ClienteHttp cliente = new ClienteHttp();
        String menu = """
                1) Dolar >>> Peso argentino.
                2) Peso argentino >>> Dolar.
                3) Dolar >>> Real brasileño.
                4) Real brasileño >>> Dolar.
                5) Dolar >>> Peso colombiano.
                6) Peso colombiano >>> Dolar.
                7) Salir.
                """;

        Scanner teclado = new Scanner(System.in);
        int opcion = 0;
        Float valorMoneda = 0.0f;
        Float valorConvertir = 0.0f;

        System.out.println(cliente.getDolarConvert("USD"));

        System.out.println("Sea bienvenido/a al convertor de monedas =]");
        while (!salir){
            System.out.println(menu);
            opcion = teclado.nextInt();

            switch (opcion){
                case 1:
                    //PASA DOLAR A PESOS ARGENTINOS
                    valorMoneda = cliente.getValorMonedaAMonedaB("USD", "ARS");
                    teclado = new Scanner(System.in);
                    System.out.println("Ingrese el valor a convertir: ");
                    valorConvertir = teclado.nextFloat();
                    System.out.println("El valor de "+valorConvertir+" USD"+" corresponde al valor final de =>>>"+
                            convertirAMoneda(valorConvertir, valorMoneda)+" ARS");
                    break;
                case 2:
                    valorMoneda = cliente.getValorMonedaAMonedaB("ARS", "USD");
                    teclado = new Scanner(System.in);
                    System.out.println("Ingrese el valor a convertir: ");
                    valorConvertir = teclado.nextFloat();
                    System.out.println("El valor de "+valorConvertir+" ARS"+" corresponde al valor final de =>>>"+
                            convertirAMoneda(valorConvertir, valorMoneda)+" USD");
                    break;
                case 3:

                    valorMoneda = cliente.getValorMonedaAMonedaB("USD", "BRL");
                    teclado = new Scanner(System.in);
                    System.out.println("Ingrese el valor a convertir: ");
                    valorConvertir = teclado.nextFloat();
                    System.out.println("El valor de "+valorConvertir+" USD"+" corresponde al valor final de =>>>"+
                            convertirAMoneda(valorConvertir, valorMoneda)+" BRL");
                    break;
                case 4:
                    valorMoneda = cliente.getValorMonedaAMonedaB("BRL", "USD");
                    teclado = new Scanner(System.in);
                    System.out.println("Ingrese el valor a convertir: ");
                    valorConvertir = teclado.nextFloat();
                    System.out.println("El valor de "+valorConvertir+" BRL"+" corresponde al valor final de =>>>"+
                            convertirAMoneda(valorConvertir, valorMoneda)+" USD");
                    break;
                case 5:
                    valorMoneda = cliente.getValorMonedaAMonedaB("USD", "COP");
                    teclado = new Scanner(System.in);
                    System.out.println("Ingrese el valor a convertir: ");
                    valorConvertir = teclado.nextFloat();
                    System.out.println("El valor de "+valorConvertir+" USD"+" corresponde al valor final de =>>>"+
                            convertirAMoneda(valorConvertir, valorMoneda)+" COP");
                    break;
                case 6:
                    valorMoneda = cliente.getValorMonedaAMonedaB("COP", "USD");
                    teclado = new Scanner(System.in);
                    System.out.println("Ingrese el valor a convertir: ");
                    valorConvertir = teclado.nextFloat();
                    System.out.println("El valor de "+valorConvertir+" COP"+" corresponde al valor final de =>>>"+
                            convertirAMoneda(valorConvertir, valorMoneda)+" USD");
                    break;
                case 7:
                        salir= true;
                    break;
                default:
                    System.out.println("Eliga una opcion valida");
            }

        }
        System.out.println("Muchas gracias, hasta pronto!");

    }
    public static Float convertirAMoneda(Float valorConvertir, Float valorMoneda) {
        return valorConvertir * valorMoneda;
    }
}
