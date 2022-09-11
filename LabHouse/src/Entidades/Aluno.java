package Entidades;

public class Aluno extends Pessoa {
    private String status;
    private int totalDeAtendimentos = 0;
    private float notaDoProcesso;


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public float getNotaDoProcesso() {
        return notaDoProcesso;
    }

    public void setNotaDoProcesso(float notaDoProcesso) {
        this.notaDoProcesso = notaDoProcesso;
    }

    public int getTotalDeAtendimentos() {
        return totalDeAtendimentos;
    }

    public void setTotalDeAtendimentos(int totalDeAtendimentos) {
        this.totalDeAtendimentos = totalDeAtendimentos;
    }
}
