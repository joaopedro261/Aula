public class Main {
    public static void main(String[]args){
        Veiculo carro_1 = new Veiculo ("Fiat","Uno");
        Veiculo carro_2 = new Veiculo ("BYD","Compact 2026");
        Veiculo carro_3 = new Veiculo ("HONDA","Civic");

        Veiculo [] estacionamento = {carro_1,carro_2,carro_3};

        System.out.println(estacionamento[1].marca);
    }
}