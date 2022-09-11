package Entidades;

public class Pedagogo extends Pessoa {
    private int totalDeAtendimentos = 0;

    public int getTotalDeAtendimentos() {
        return totalDeAtendimentos;
    }

    public void setTotalDeAtendimentos(int totalDeAtendimentos) {
        this.totalDeAtendimentos = totalDeAtendimentos;
    }
}
