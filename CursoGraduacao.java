public class CursoGraduacao extends Curso
{
    private int numDisciplinasObrigatorias;
    private int numDisciplinasOptativas;
    private double taxaMatricula;
    
    public CursoGraduacao(String codigo, String nome, String area, int numVagas, int numDisciplinasObrigatorias, int numDisciplinasOptativas, double taxaMatricula)
    {
        super(codigo, nome, area, numVagas);
        this.numDisciplinasObrigatorias = numDisciplinasObrigatorias;
        this.numDisciplinasOptativas = numDisciplinasOptativas;
        this.taxaMatricula = taxaMatricula;
    }
    
    @Override
    public double consultaPreco()
    {
        return Math.round((this.taxaMatricula * 0.9) * 100) / 100;
    }
    
    @Override
    public void consultaInformacoes()
    {
        System.out.println("Curso de Graduação:");
        System.out.println("Nome: " + super.getNome());
        System.out.println("Disciplinas a serem cursadas: " + (this.numDisciplinasObrigatorias + this.numDisciplinasOptativas));
    }
}