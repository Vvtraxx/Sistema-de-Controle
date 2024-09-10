import java.time.LocalDate;

public class Pagamento {
    private Despesa despesa;
    private double valorPago;
    private LocalDate dataPagamento;

    public Pagamento(Despesa despesa, double valorPago, LocalDate dataPagamento) {
        this.despesa = despesa;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    // Métodos getters e setters
    public Despesa getDespesa() {
        return despesa;
    }

    public void setDespesa(Despesa despesa) {
        this.despesa = despesa;
    }

    public double getValorPago() {
        return valorPago;
    }

    public void setValorPago(double valorPago) {
        this.valorPago = valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(LocalDate dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
}