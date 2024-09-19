import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TipoDespesa {
    private static final String ARQUIVO = "tipos_despesa.txt";

    // Adicionar um novo tipo de despesa
    public static void adicionarTipoDespesa(String tipo) {
        try (FileWriter writer = new FileWriter(ARQUIVO, true)) {
            writer.write(tipo + "\n");
            System.out.println("Tipo de despesa adicionado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar tipo de despesa: " + e.getMessage());
        }
    }

    // Editar um tipo de despesa existente
    public static void editarTipoDespesa(String tipoAntigo, String tipoNovo) {
        List<String> tipos = listarTiposDespesa();
        boolean encontrado = false;
        try (FileWriter writer = new FileWriter(ARQUIVO, false)) {
            for (String tipo : tipos) {
                if (tipo.equalsIgnoreCase(tipoAntigo)) {
                    writer.write(tipoNovo + "\n");
                    encontrado = true;
                } else {
                    writer.write(tipo + "\n");
                }
            }
            if (encontrado) {
                System.out.println("Tipo de despesa editado com sucesso.");
            } else {
                System.out.println("Tipo de despesa não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao editar tipo de despesa: " + e.getMessage());
        }
    }

    // Listar todos os tipos de despesa
    public static List<String> listarTiposDespesa() {
        List<String> tipos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(ARQUIVO))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                tipos.add(linha);
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar tipos de despesa: " + e.getMessage());
        }
        return tipos;
    }

    // Excluir um tipo de despesa
    public static void excluirTipoDespesa(String tipo) {
        List<String> tipos = listarTiposDespesa();
        boolean encontrado = false;
        try (FileWriter writer = new FileWriter(ARQUIVO, false)) {
            for (String t : tipos) {
                if (!t.equalsIgnoreCase(tipo)) {
                    writer.write(t + "\n");
                } else {
                    encontrado = true;
                }
            }
            if (encontrado) {
                System.out.println("Tipo de despesa excluído com sucesso.");
            } else {
                System.out.println("Tipo de despesa não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir tipo de despesa: " + e.getMessage());
        }
    }
}
