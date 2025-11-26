import java.util.ArrayList;
import java.util.List;

public class AplicaçãoFaculdade {
    private List<Curso> cursos;

    public AplicaçãoFaculdade() {
        this.cursos = new ArrayList<>();
    }

    public CursoGraduacao criaCursoGraduacao(String codigo, String nome, String area, int numVagas, 
                                             int numDisciplinasObrigatorias, int numDisciplinasOptativas, 
                                             double taxaMatricula) {
        CursoGraduacao curso = new CursoGraduacao(codigo, nome, area, numVagas, 
                                                   numDisciplinasObrigatorias, numDisciplinasOptativas, 
                                                   taxaMatricula);
        cursos.add(curso);
        return curso;
    }

    public CursoPosGraduacao criaCursoPosGraduacao(String codigo, String nome, String area, int numVagas, 
                                                   double cargaHorariaMax, double taxaAddPos) {
        CursoPosGraduacao curso = new CursoPosGraduacao(codigo, nome, area, numVagas, 
                                                         cargaHorariaMax, taxaAddPos);
        cursos.add(curso);
        return curso;
    }

    public void consultaCurso(Curso curso) {
        curso.consultaInformacoes();
        System.out.println("Preço: R$ " + curso.consultaPreco());
    }

    // Getter para a lista de cursos
    public List<Curso> getCursos() {
        return cursos;
    }

    public static void main(String[] args) {
        AplicaçãoFaculdade app = new AplicaçãoFaculdade();

        CursoGraduacao cursoGrad = app.criaCursoGraduacao("GRAD001", "Ciência da Computação", 
                                                          "Tecnologia", 50, 40, 10, 1500.00);

        CursoPosGraduacao cursoPos = app.criaCursoPosGraduacao("POS001", "Mestrado em IA", 
                                                               "Tecnologia", 20, 360.0, 2500.00);

        System.out.println("=== Consulta Curso de Graduação ===");
        app.consultaCurso(cursoGrad);

        System.out.println("\n=== Consulta Curso de Pós-Graduação ===");
        app.consultaCurso(cursoPos);

        System.out.println("\n=== Total de cursos cadastrados: " + app.getCursos().size() + " ===");
    }
}