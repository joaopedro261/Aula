

public class Main {
    public static void main (String[]args) {
        //String [] alunos = {"Miranata","Savalo"};

        //alunos[0] = "Mariazinha";
        //System.out.println("Qtde de Alunos:" + alunos.length);

        //for(String estudante : alunos){
            //System.out.println(estudante);
        //}

        // Crie uma lista com 5 produtos
        //String[] produtos = {"Refrigerante", "Queijo", "Pão", "Presunto", "Maionese"};

        // Exiba cada produto utilizando foreach
        //for (String produto : produtos) {
        //    System.out.println(produto);
        //}

        // Exiba cada produto utilizando for
        //for (int i = 0; i < produtos.length; i++) {
        //    System.out.println(produtos[i]);
        //}

        //Crie um array contendo 5 números
        //Use foreach para exibir se cada número é positivo , negativo ou igual a zero

        int[] numeros = {10, -8, 0, 7, -2};

        for(int numero : numeros) {
            if(numero > 0 ){
                System.out.println(numero + "e positivo");
            } else if (numero < 0) {
                System.out.println(numero + "e negativo");
            } else {
                System.out.println(numero + "e igual a zero");
            }
        }
    } 
}
