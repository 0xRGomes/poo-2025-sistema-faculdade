import java.util.ArrayList;

public class AplicaçãoFaculdade {
    private ArrayList<Curso> cursos;

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
    public ArrayList<Curso> getCursos() {
        return cursos;
    }
}