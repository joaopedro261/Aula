//Crie um script para exibir se a luz está acessa ou apagada


public class Main {
    public Main() {
    }
 
    public static void main(String[] args){

        boolean luzAcesa = true;

            if(luzAcesa) {
                System.out.println("A luz esta acessa");
            } else {
                System.out.println("A luz esta apagada");
            }


        
        String luz = (luzAcesa) ? "Esta Acessa" : "Está Apagada";
        System.out.println(luz);

    }
}