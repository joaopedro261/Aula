

public class Main {
    public static void main (String[]args) {
        String [] alunos = {"Miranata","Savalo"};

        alunos[0] = "Mariazinha";
        System.out.println("Qtde de Alunos:" + alunos.length);

        for(String estudante : alunos){
            System.out.println(estudante);
        }
    } 
}
