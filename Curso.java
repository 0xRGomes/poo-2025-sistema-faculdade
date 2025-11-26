public abstract class Curso {
    private String codigo;
    private String nome;
    private String area;
    private int numVagas;

// Construtor
public Curso(String codigo, String nome, String area, int numVagas){
    this.codigo = codigo;
    this.nome = nome;
    this.area = area;
    this.numVagas = numVagas;
}

//Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getArea() {
        return area;
    }

    public int getNumVagas() {
        return numVagas;
    }
//Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setNumVagas(int numVagas) {
        this.numVagas = numVagas;
    }
//toString
    @Override
    public String toString() {
        return "Curso{" +
                "codigo='" + codigo + '\'' +
                ", nome='" + nome + '\'' +
                ", area='" + area + '\'' +
                ", numVagas=" + numVagas +
                '}';
    }

//Metodo abstrato para consultar preço
    public abstract double consultaPreco();

//Metodo abstrato para consultar informaçoes
    public abstract void consultaInformacoes();
}


