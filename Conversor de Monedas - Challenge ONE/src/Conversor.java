import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Conversor {

    int limiteMovimientos= 3;
    List<Movimiento> movimientos = new ArrayList<>(this.limiteMovimientos);
    int cantidadMovimientos= 0;
    String monedasRelevantes = """
            ##############################################
            ######### USD - Dolar Estados Unidos #########
            ######### EUR - Euro                 #########
            ######### RUB - Rublo Rusia          #########
            ######### CNY - Renminbi Chino(Yuan) #########
            ######### ARS - Peso Argentina       #########
            ######### UYU - Peso Uruguay         #########
            ######### COP - Peso Colombia        #########
            ######### BRL - Real Brasil          #########
            ######### PEN - Sol Peru             #########
            ######### MXN - Peso Mexico          #########
            ######### CLP - Peso Chile           #########
            ##############################################
            """;


    public Float convertirMoneda(String monedaA, String monedaB) {
        ClienteHttp cliente = new ClienteHttp();
        Scanner teclado = new Scanner(System.in);
        Float valorMoneda = 0.0f;
        Float valorConvertir = 0.0f;
        Float valorConvertido = 0.0f;

        valorMoneda = cliente.getValorMonedaAMonedaB(monedaA, monedaB);
        System.out.println("Ingrese el valor a convertir: ");
        valorConvertir = teclado.nextFloat();
        valorConvertido = convertirAMoneda(valorConvertir, valorMoneda);
        System.out.println("El valor de "+valorConvertir+ " " + monedaA+" corresponde al valor final de =>>>"+
                valorConvertido+" "+ monedaB);

        agregarMovimiento(valorConvertir, valorConvertido, valorMoneda, monedaB, monedaA);
        return valorConvertido;
    }

    private Float convertirAMoneda(Float valorConvertir, Float valorMoneda) {
        return valorConvertir * valorMoneda;
    }

    public void mostrarUltimasConversiones() {
        for (int i = 0; i<this.movimientos.size(); i++){
            System.out.println(movimientos.get(i).toString());
        }
    }

    public void conbertirMonedasCustom(){
        Scanner teclado = new Scanner(System.in);
        String moneda;
        String monedaFinal;
        System.out.println("Ingrese el tipo de moneda que quiere convertir:");
        System.out.println(monedasRelevantes);
        System.out.println("Para conocer mas codigos de monedas disponibles vea el listado completo");
        moneda = teclado.nextLine();
        System.out.println("Ingrese el tipo de moneda a la que quiere convetir:");
        monedaFinal = teclado.nextLine();
        convertirMoneda(moneda, monedaFinal);

    };

    private void agregarMovimiento(Float valor, Float valorConversion, Float valorAConvetir, String monedaA, String monedaB){
        if (this.cantidadMovimientos < this.limiteMovimientos){
            agregarOReemplazar(new Movimiento(valor, valorConversion, valorAConvetir, monedaA, monedaB));
            this.cantidadMovimientos++;
        }else {
            this.movimientos.removeFirst();
            this.movimientos.addFirst(new Movimiento(valor, valorConversion, valorAConvetir, monedaA, monedaB));
            this.cantidadMovimientos=1;
        }
    }
    private void agregarOReemplazar(Movimiento movimiento){

        if (this.movimientos.size() == this.limiteMovimientos){
            this.movimientos.remove(this.cantidadMovimientos);
            this.movimientos.add(this.cantidadMovimientos ,movimiento);
        }else{
            this.movimientos.add(this.cantidadMovimientos,movimiento);
        }
    }
}
