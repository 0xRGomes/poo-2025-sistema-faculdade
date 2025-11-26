public class CursoPosGraduacao extends Curso{
   
    private double cargaHorariaMax;
    private double taxaAddPos;

    //contrutor
    public CursoPosGraduacao(String codigo, String nome, String area, int numVagas, double cargaHorariaMax, double taxaAddPos){
        super(codigo, nome, area, numVagas);
        this.cargaHorariaMax = cargaHorariaMax;
        this.taxaAddPos = taxaAddPos;
    }

//getters
    public double getCargaHorariaMax() {
        return cargaHorariaMax;
    }

    public double getTaxaAddPos(){
        return taxaAddPos;
    }

//setters
    public void setCargaHorariaMax(double cargaHorariaMax) {
        this.cargaHorariaMax = cargaHorariaMax;
    }

    public void setTaxaAddPos(double taxaAddPos) {
        this.taxaAddPos = taxaAddPos;
    }


    @Override
    public double consultaPreco() {
        return this.taxaAddPos*0.95; //preço = valor da taxa menos o desconto de 5%
    }

    @Override
    public void consultaInformacoes() {
        System.out.println("Curso de Pós-Graduação:");
        System.out.println("Código: " + getCodigo());
        System.out.println("Nome: " + getNome());
        System.out.println("Área: " + getArea());
        System.out.println("Vagas: " + getNumVagas());
        System.out.println("Carga horária máxima: " + cargaHorariaMax);
        System.out.println("Taxa adicional: " + taxaAddPos);
    }
}
