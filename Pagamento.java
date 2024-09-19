import java.time.LocalDate;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Pagamento {
    private String descricaoDespesa;
    private double valorPago;
    private LocalDate dataPagamento;

    public Pagamento(String descricaoDespesa, double valorPago, LocalDate dataPagamento) {
        this.descricaoDespesa = descricaoDespesa;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
    }

    // Métodos getters e setters
    public String getDescricaoDespesa() {
        return descricaoDespesa;
    }

    public void setDescricaoDespesa(String descricaoDespesa) {
        this.descricaoDespesa = descricaoDespesa;
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

    // Método para salvar pagamento no arquivo "pagamentos.txt"
    public static void adicionarPagamento(Pagamento pagamento) {
        try (FileWriter writer = new FileWriter("pagamentos.txt", true)) {
            writer.write(pagamento.getDescricaoDespesa() + ";" + pagamento.getValorPago() + ";"
                    + pagamento.getDataPagamento() + "\n");
            System.out.println("Pagamento anotado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao anotar pagamento: " + e.getMessage());
        }
    }

    // Método para listar todos os pagamentos do arquivo "pagamentos.txt"
    public static List<Pagamento> listarPagamentos() {
        List<Pagamento> pagamentos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("pagamentos.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String descricao = partes[0];
                    double valorPago = Double.parseDouble(partes[1]);
                    LocalDate dataPagamento = LocalDate.parse(partes[2]);
                    pagamentos.add(new Pagamento(descricao, valorPago, dataPagamento));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        }
        return pagamentos;
    }
}
