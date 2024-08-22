package candidatura;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    //Método auxiliar
    static boolean Atender() {
        return new Random().nextInt(3)==1;
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = Atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            }
            else {
                System.out.println("Contato realizado com sucesso!");
            }
        }while(continuarTentando && tentativasRealizadas < 3);

        if(atendeu) {
            System.out.println("Conseguimos contato com o candidato " + candidato + " na " + tentativasRealizadas + " tentativa!");
        }
        else {
            System.out.println("Não conseguimos contato com o candidato " + candidato + ". Número máximo de tentativas realizadas!");
        }
    }

    static void imprimirSelecionados() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
        System.out.println("Imprimindo a lista de candidatos informando o indice do elemento: ");
        for (int i = 0; i < candidatos.length; i++) {
            System.out.println("O candidato de índice " + (i + 1) + " é " + candidatos[i]);
        }

        System.out.println("Forma abreviada: ");

        for (String candidato: candidatos ) {
            System.out.println("O candidato selecionado foi: " + candidato);
        }
    }

    static void selecaoCandidatos() {
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA", "JORGE" };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga!");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return  ThreadLocalRandom.current().nextDouble(1800.0, 2000.0);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para o candidato!");
        }
        else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra-proposta!");
        }
        else {
            System.out.println("Aguardando resultados dos demais candidatos!");
        }
    } 
}
