import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        AplicaçãoFaculdade facul = new AplicaçãoFaculdade();
        boolean running = true;
        while (running) {
            System.out.println("\n=== Menu Principal ===");
            System.out.println("1 - Cadastrar Curso Graduação");
            System.out.println("2 - Cadastrar Curso Pós-Graduação");
            System.out.println("3 - Consultar preço por código");
            System.out.println("4 - Consultar informações por código");
            System.out.println("5 - Listar cursos");
            System.out.println("6 - Sair");
            System.out.print("Escolha: ");
            String opc = scanner.nextLine().trim();

            switch (opc) {
                case "1": cadastrarGraduacao(facul); break;
                case "2": cadastrarPosGraduacao(facul); break;
                case "3": consultarPreco(facul); break;
                case "4": consultarInformacoes(facul); break;
                case "5": listarCursos(facul); break;
                case "6": running = false; break;
                default: System.out.println("Opção inválida.");
            }
        }
        System.out.println("Finalizando. Até mais!");
    }

    private static void cadastrarGraduacao(AplicaçãoFaculdade facul) {
        System.out.println("\n-- Cadastrar Graduação --");
        System.out.print("Código: "); String codigo = scanner.nextLine().trim();
        if (buscarCursoPorCodigo(codigo, facul) != null) { System.out.println("Código já existente."); return; }
        System.out.print("Nome: "); String nome = scanner.nextLine().trim();
        System.out.print("Área: "); String area = scanner.nextLine().trim();
        int vagas = readInt("Número de vagas: ");
        int obrig = readInt("Disciplinas obrigatórias: ");
        int opt = readInt("Disciplinas optativas: ");
        double taxa = readDouble("Taxa de matrícula: ");

        facul.criaCursoGraduacao(codigo, nome, area, vagas, obrig, opt, taxa);
        System.out.println("Graduação cadastrada.");
    }

    private static void cadastrarPosGraduacao(AplicaçãoFaculdade facul) {
        System.out.println("\n-- Cadastrar Pós-Graduação --");
        System.out.print("Código: "); String codigo = scanner.nextLine().trim();
        if (buscarCursoPorCodigo(codigo, facul) != null) { System.out.println("Código já existente."); return; }
        System.out.print("Nome: "); String nome = scanner.nextLine().trim();
        System.out.print("Área: "); String area = scanner.nextLine().trim();
        int vagas = readInt("Número de vagas: ");
        double carga = readDouble("Carga horária máxima: ");
        double taxaMatriculaPos = readDouble("Taxa de Matrícula: ");

        facul.criaCursoPosGraduacao(codigo, nome, area, vagas, carga, taxaMatriculaPos);
        System.out.println("Pós-Graduação cadastrada.");
    }

    private static void consultarPreco(AplicaçãoFaculdade facul) {
        System.out.print("\nCódigo do curso: "); String codigo = scanner.nextLine().trim();
        Curso c = buscarCursoPorCodigo(codigo, facul);
        if (c == null) { System.out.println("Curso não encontrado."); return; }
        System.out.printf("Preço/Taxa: %.2f\n", c.consultaPreco());
    }

    private static void consultarInformacoes(AplicaçãoFaculdade facul) {
        System.out.print("\nCódigo do curso: "); String codigo = scanner.nextLine().trim();
        Curso c = buscarCursoPorCodigo(codigo, facul);
        if (c == null) { System.out.println("Curso não encontrado."); return; }
        facul.consultaCurso(c);
    }

    private static void listarCursos(AplicaçãoFaculdade facul) {
        System.out.println("\n-- Cursos cadastrados --");
        ArrayList<Curso> cursos = facul.getCursos();
        if (cursos.isEmpty()) { System.out.println("Nenhum curso."); return; }
        for (Curso c : cursos) {
            String tipo = (c instanceof CursoGraduacao) ? "Graduação" : "Pós";
            System.out.printf("%s - %s (%s)\n", c.getCodigo(), c.getNome(), tipo);
        }
    }

    private static Curso buscarCursoPorCodigo(String codigo, AplicaçãoFaculdade facul) {
        ArrayList<Curso> cursos = facul.getCursos();
        for (Curso c : cursos) if (c.getCodigo().equalsIgnoreCase(codigo)) return c;
        return null;
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim();
            try { return Integer.parseInt(s); } catch (NumberFormatException e) { System.out.println("Digite um inteiro válido."); }
        }
    }

    private static double readDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String s = scanner.nextLine().trim().replace(',','.');
            try { return Double.parseDouble(s); } catch (NumberFormatException e) { System.out.println("Digite um número válido."); }
        }
    }
}
