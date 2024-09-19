import java.time.LocalDate;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class Despesa {
    private String descricao;
    private double valor;
    private LocalDate dataVencimento;
    private String categoria;

    public Despesa(String descricao, double valor, LocalDate dataVencimento, String categoria) {
        this.descricao = descricao;
        this.valor = valor;
        this.dataVencimento = dataVencimento;
        this.categoria = categoria;
    }

    // Métodos getters e setters
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(LocalDate dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Método para salvar despesa no arquivo "despesas.txt"
    public static void adicionarDespesa(Despesa despesa) {
        try (FileWriter writer = new FileWriter("despesas.txt", true)) {
            writer.write(despesa.getDescricao() + ";" + despesa.getValor() + ";" + despesa.getDataVencimento() + ";"
                    + despesa.getCategoria() + "\n");
            System.out.println("Despesa adicionada com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar despesa: " + e.getMessage());
        }
    }

    // Método para listar todas as despesas do arquivo "despesas.txt"
    public static List<Despesa> listarDespesas() {
        List<Despesa> despesas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("despesas.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 4) {
                    String descricao = partes[0];
                    double valor = Double.parseDouble(partes[1]);
                    LocalDate dataVencimento = LocalDate.parse(partes[2]);
                    String categoria = partes[3];
                    despesas.add(new Despesa(descricao, valor, dataVencimento, categoria));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar despesas: " + e.getMessage());
        }
        return despesas;
    }

    // Verifica se a despesa foi paga
    public static boolean isPago(String descricao) {
        List<Pagamento> pagamentos = Pagamento.listarPagamentos();
        for (Pagamento pagamento : pagamentos) {
            if (pagamento.getDescricaoDespesa().equalsIgnoreCase(descricao)) {
                return true;
            }
        }
        return false;
    }
}
