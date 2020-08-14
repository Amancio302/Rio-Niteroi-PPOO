import java.util.Scanner;

public class Main {

    public static Scanner scan;
    public static Simulador simulador;
    public static Plot plot;

    public static void main(String[] args) {
        scan = new Scanner(System.in);
        simulador = new Simulador();
        plot = new Plot();
        Porto p1 = new Porto();
        Porto p2 = new Porto();
        p1.setDestino(p2);
        p2.setDestino(p1);
        simulador.setPorto1(p1);
        simulador.setPorto2(p2);
        run();
    }

    public static void run() {
        String op = "";
        while(!op.equals("j")) {
            exibirMenu();
            op = scan.nextLine();
            op = op.toLowerCase();
            executarComando(op);
        }
    }

    private static void exibirMenu() {
        System.out.println("a- Incluir passageiro Comum");
        System.out.println("b- Incluir passageiro Preferencial");
        System.out.println("c- Incluir passageiro VIP");
        System.out.println("d- Cadastrar nova balsa comum");
        System.out.println("e- Cadastrar nova balsa express");
        System.out.println("f- Iniciar simulacao");
        System.out.println("g- Salvar dados");
        System.out.println("h- Carregar dados");
        System.out.println("i- Gerar relatório");
        System.out.println("j- Sair");
    }

    private static void executarComando(String op) {
        if (op.equals("a")) {
            incluirPassageiroComum();
        } else if (op.equals("b")) {
            incluirPassageiroPreferencial();
        } else if (op.equals("c")) {
            incluirPassageiroVIP();
        } else if (op.equals("d")) {
            incluirBalsaComum();
        } else if (op.equals("e")) {
            incluirBalsaExpress();
        } else if (op.equals("f")) {
            iniciarSimulacao();
            plot.runPlot(simulador);
        } else if (op.equals("g")) {
            salvarDados();
        } else if (op.equals("h")) {
            carregarDados();
        } else if (op.equals("i")) {
            gerarRelatorio();
        } else if (!op.equals("j")) {
            System.out.println("Opção inválida");
        }
    }

    private static void incluirPassageiroComum(){
        PassageiroComum passageiro = (PassageiroComum) criarPassageiro(0);
        String fila = selectBalsa();
        String porto = selectPorto();
        if (porto.equals("p1")) {
            simulador.getPorto1().addPassageiro(fila, passageiro);
        } else if (porto.equals("p2")) {
            simulador.getPorto2().addPassageiro(fila, passageiro);
        }
    }

    private static void incluirPassageiroPreferencial(){
        PassageiroPreferencial passageiro = (PassageiroPreferencial) criarPassageiro(1);
        String fila = selectBalsa();
        String porto = selectPorto();
        if (porto.equals("p1")) {
            simulador.getPorto1().addPassageiro(fila, passageiro);
        } else if (porto.equals("p2")) {
            simulador.getPorto2().addPassageiro(fila, passageiro);
        }
    }

    private static void incluirPassageiroVIP(){
        PassageiroVIP passageiro = (PassageiroVIP) criarPassageiro(2);
        String porto = selectPorto();
        if (porto.equals("p1")) {
            simulador.getPorto1().addPassageiro("express", passageiro);
        } else if (porto.equals("p2")) {
            simulador.getPorto2().addPassageiro("express", passageiro);
        }
    }
    
    private static void incluirBalsaComum(){
        String porto = selectPorto();
        if (porto.equals("p1")) {
            simulador.getPorto1().addBalsa("comum", new BalsaComum());
        } else if (porto.equals("p2")) {
            simulador.getPorto2().addBalsa("comum", new BalsaComum());
        }
        
    }

    private static void incluirBalsaExpress(){
        String porto = selectPorto();
        if (porto.equals("p1")) {
            simulador.getPorto1().addBalsa("express", new BalsaExpress());
        } else if (porto.equals("p2")) {
            simulador.getPorto2().addBalsa("express", new BalsaExpress());
        }
    }

    private static void iniciarSimulacao(){
        simulador.iniciarSimulacao();
    }

    private static void salvarDados(){
        ManipuladorDeArquivo.salvarSimulacaoEmArquivo(simulador, "Simulacao.sim");
    }

    private static void carregarDados(){
        simulador = ManipuladorDeArquivo.lerSimulacaoDeArquivo("Simulacao.sim");
    }

    private static void gerarRelatorio(){
    	simulador.gerarRelatorioEmArquivo();
    }

	private static Passageiro criarPassageiro(int op) {
        System.out.print("CPF: ");
        String cpf = scan.nextLine();
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("Idade: ");
        int idade = scan.nextInt();
        scan.nextLine();
        System.out.print("Sexo: ");
        String sexo = scan.nextLine();
        if (op == 0) {
            return new PassageiroComum(cpf, nome, idade, sexo);
        } else if (op == 1){
            System.out.println("Tipo de Preferencia: ");
            String tipoPreferencia = scan.nextLine();
            return new PassageiroPreferencial(cpf, nome, idade, sexo, tipoPreferencia);
        } else {
            System.out.println("Comprovante VIP: ");
            String comprovanteVIP = scan.nextLine();
            return new PassageiroVIP(cpf, nome, idade, sexo, comprovanteVIP);
        }

    }

    private static String selectPorto() {
        System.out.println("Digite o porto escolhido (p1 ou p2): ");
        String nome = scan.nextLine();
        nome = nome.toLowerCase();
        if (!nome.equals("p1") && !nome.equals("p2")) {
            System.out.println("Porto inválido");
            return null;
        }
        return nome;
    }

    private static String selectBalsa() {
        System.out.println("Selecione:");
        System.out.println("Balsa Comum - R$20,00 (digite comum)");
        System.out.println("Express - R$70,00 (digite express)");
        String nome = scan.nextLine();
        return nome.toLowerCase();
    }
}