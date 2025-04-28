import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;

        String menu = """
                1) Dolar >>> Peso argentino.
                2) Peso argentino >>> Dolar.
                3) Dolar >>> Real brasileño.
                4) Real brasileño >>> Dolar.
                5) Dolar >>> Peso colombiano.
                6) Peso colombiano >>> Dolar.
                7) Salir.
                """;
        Conversor conversor = new Conversor();
        Scanner teclado = new Scanner(System.in);

        System.out.println("Sea bienvenido/a al convertor de monedas =]");
        while (!salir){
            System.out.println(menu);

            switch (teclado.nextInt()){
                case 1:
                    //PASA DOLAR A PESOS ARGENTINOS
                    conversor.convertirMoneda("USD", "ARS");
                    break;
                case 2:
                    conversor.convertirMoneda("ARS", "USD");

                    break;
                case 3:
                    conversor.convertirMoneda("USD", "BRL");
                    break;
                case 4:
                    conversor.convertirMoneda("BRL", "USD");
                    break;
                case 5:
                    conversor.convertirMoneda("USD", "COP");
                    break;
                case 6:
                    conversor.convertirMoneda("COP", "USD");
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

}
