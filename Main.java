import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Curso> cursos = new ArrayList<>();

    public static void main(String[] args) {
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
                case "1": cadastrarGraduacao(); break;
                case "2": cadastrarPosGraduacao(); break;
                case "3": consultarPreco(); break;
                case "4": consultarInformacoes(); break;
                case "5": listarCursos(); break;
                case "6": running = false; break;
                default: System.out.println("Opção inválida.");
            }
        }
        System.out.println("Finalizando. Até mais!");
    }

    private static void cadastrarGraduacao() {
        System.out.println("\n-- Cadastrar Graduação --");
        System.out.print("Código: "); String codigo = scanner.nextLine().trim();
        if (buscarCursoPorCodigo(codigo) != null) { System.out.println("Código já existente."); return; }
        System.out.print("Nome: "); String nome = scanner.nextLine().trim();
        System.out.print("Área: "); String area = scanner.nextLine().trim();
        int vagas = readInt("Número de vagas: ");
        int obrig = readInt("Disciplinas obrigatórias: ");
        int opt = readInt("Disciplinas optativas: ");
        double taxa = readDouble("Taxa de matrícula: ");

        CursoGraduacao cg = new CursoGraduacao(codigo, nome, area, vagas, obrig, opt, taxa);
        cursos.add(cg);
        System.out.println("Graduação cadastrada.");
    }

    private static void cadastrarPosGraduacao() {
        System.out.println("\n-- Cadastrar Pós-Graduação --");
        System.out.print("Código: "); String codigo = scanner.nextLine().trim();
        if (buscarCursoPorCodigo(codigo) != null) { System.out.println("Código já existente."); return; }
        System.out.print("Nome: "); String nome = scanner.nextLine().trim();
        System.out.print("Área: "); String area = scanner.nextLine().trim();
        int vagas = readInt("Número de vagas: ");
        double carga = readDouble("Carga horária máxima: ");
        double taxaAdd = readDouble("Taxa adicional: ");

        CursoPosGraduacao cp = new CursoPosGraduacao(codigo, nome, area, vagas, carga, taxaAdd);
        cursos.add(cp);
        System.out.println("Pós-Graduação cadastrada.");
    }

    private static void consultarPreco() {
        System.out.print("\nCódigo do curso: "); String codigo = scanner.nextLine().trim();
        Curso c = buscarCursoPorCodigo(codigo);
        if (c == null) { System.out.println("Curso não encontrado."); return; }
        System.out.printf("Preço/Taxa: %.2f\n", c.consultaPreco());
    }

    private static void consultarInformacoes() {
        System.out.print("\nCódigo do curso: "); String codigo = scanner.nextLine().trim();
        Curso c = buscarCursoPorCodigo(codigo);
        if (c == null) { System.out.println("Curso não encontrado."); return; }
        c.consultaInformacoes();
    }

    private static void listarCursos() {
        System.out.println("\n-- Cursos cadastrados --");
        if (cursos.isEmpty()) { System.out.println("Nenhum curso."); return; }
        for (Curso c : cursos) {
            String tipo = (c instanceof CursoGraduacao) ? "Graduação" : "Pós";
            System.out.printf("%s - %s (%s)\n", c.getCodigo(), c.getNome(), tipo);
        }
    }

    private static Curso buscarCursoPorCodigo(String codigo) {
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
