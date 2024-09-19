import java.util.Scanner;
import java.time.LocalDate;
import java.util.List;

public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("\n=== Sistema de Controle de Despesas ===");
            System.out.println("1. Entrar Despesa");
            System.out.println("2. Anotar Pagamento");
            System.out.println("3. Listar Despesas em Aberto no período");
            System.out.println("4. Listar Despesas Pagas no período");
            System.out.println("5. Gerenciar Tipos de Despesa");
            System.out.println("6. Gerenciar Usuários");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    submenuEntrarDespesa();
                    break;
                case 2:
                    submenuAnotarPagamento();
                    break;
                case 3:
                    submenuListarDespesasEmAberto();
                    break;
                case 4:
                    submenuListarDespesasPagas();
                    break;
                case 5:
                    submenuGerenciarTiposDeDespesa();
                    break;
                case 6:
                    submenuGerenciarUsuarios();
                    break;
                case 7:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 7);

        scanner.close();
    }

    private void submenuEntrarDespesa() {
        System.out.println("\n=== Entrar Despesa ===");
        System.out.print("Digite a descrição da despesa: ");
        String descricao = scanner.nextLine();

        double valor = 0;
        while (true) {
            System.out.print("Digite o valor da despesa: ");
            if (scanner.hasNextDouble()) {
                valor = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                break;
            } else {
                System.out.println("Valor inválido. Por favor, insira um número.");
                scanner.next();
            }
        }

        LocalDate dataVencimento = null;
        while (true) {
            System.out.print("Digite a data de vencimento (YYYY-MM-DD): ");
            String dataStr = scanner.nextLine();
            try {
                dataVencimento = LocalDate.parse(dataStr);
                break;
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        System.out.print("Digite a categoria da despesa: ");
        String categoria = scanner.nextLine();

        Despesa despesa = new Despesa(descricao, valor, dataVencimento, categoria);
        Despesa.adicionarDespesa(despesa);
    }

    private void submenuAnotarPagamento() {
        System.out.println("\n=== Anotar Pagamento ===");
        System.out.print("Digite a descrição da despesa para pagamento: ");
        String descricao = scanner.nextLine();

        double valorPago = 0;
        while (true) {
            System.out.print("Digite o valor pago: ");
            if (scanner.hasNextDouble()) {
                valorPago = scanner.nextDouble();
                scanner.nextLine(); // Limpar buffer
                break;
            } else {
                System.out.println("Valor inválido. Por favor, insira um número.");
                scanner.next();
            }
        }

        LocalDate dataPagamento = null;
        while (true) {
            System.out.print("Digite a data do pagamento (YYYY-MM-DD): ");
            String dataStr = scanner.nextLine();
            try {
                dataPagamento = LocalDate.parse(dataStr);
                break;
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        Pagamento pagamento = new Pagamento(descricao, valorPago, dataPagamento);
        Pagamento.adicionarPagamento(pagamento);
    }

    private void submenuListarDespesasEmAberto() {
        System.out.println("\n=== Listar Despesas em Aberto ===");
        List<Despesa> despesas = Despesa.listarDespesas();
        LocalDate inicio, fim;

        while (true) {
            System.out.print("Digite a data de início (YYYY-MM-DD): ");
            String inicioStr = scanner.nextLine();
            try {
                inicio = LocalDate.parse(inicioStr);
                break;
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        while (true) {
            System.out.print("Digite a data de fim (YYYY-MM-DD): ");
            String fimStr = scanner.nextLine();
            try {
                fim = LocalDate.parse(fimStr);
                break;
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        boolean encontrou = false;
        for (Despesa despesa : despesas) {
            if (!Despesa.isPago(despesa.getDescricao()) &&
                    (despesa.getDataVencimento().isEqual(inicio) || despesa.getDataVencimento().isAfter(inicio)) &&
                    (despesa.getDataVencimento().isEqual(fim) || despesa.getDataVencimento().isBefore(fim))) {
                System.out.println("Descrição: " + despesa.getDescricao() + ", Valor: " + despesa.getValor() +
                        ", Vencimento: " + despesa.getDataVencimento() + ", Categoria: " + despesa.getCategoria());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhuma despesa em aberto encontrada no período.");
        }
    }

    private void submenuListarDespesasPagas() {
        System.out.println("\n=== Listar Despesas Pagas ===");
        List<Pagamento> pagamentos = Pagamento.listarPagamentos();
        LocalDate inicio, fim;

        while (true) {
            System.out.print("Digite a data de início (YYYY-MM-DD): ");
            String inicioStr = scanner.nextLine();
            try {
                inicio = LocalDate.parse(inicioStr);
                break;
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        while (true) {
            System.out.print("Digite a data de fim (YYYY-MM-DD): ");
            String fimStr = scanner.nextLine();
            try {
                fim = LocalDate.parse(fimStr);
                break;
            } catch (Exception e) {
                System.out.println("Data inválida. Tente novamente.");
            }
        }

        boolean encontrou = false;
        for (Pagamento pagamento : pagamentos) {
            if ((pagamento.getDataPagamento().isEqual(inicio) || pagamento.getDataPagamento().isAfter(inicio)) &&
                    (pagamento.getDataPagamento().isEqual(fim) || pagamento.getDataPagamento().isBefore(fim))) {
                System.out.println("Descrição da Despesa: " + pagamento.getDescricaoDespesa() + ", Valor Pago: "
                        + pagamento.getValorPago() +
                        ", Data de Pagamento: " + pagamento.getDataPagamento());
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum pagamento encontrado no período.");
        }
    }

    private void submenuGerenciarTiposDeDespesa() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciar Tipos de Despesa ===");
            System.out.println("1. Adicionar Tipo de Despesa");
            System.out.println("2. Editar Tipo de Despesa");
            System.out.println("3. Listar Tipos de Despesa");
            System.out.println("4. Excluir Tipo de Despesa");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    adicionarTipoDespesa();
                    break;
                case 2:
                    editarTipoDespesa();
                    break;
                case 3:
                    listarTiposDespesa();
                    break;
                case 4:
                    excluirTipoDespesa();
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    private void adicionarTipoDespesa() {
        System.out.print("Digite o novo tipo de despesa: ");
        String tipo = scanner.nextLine();
        TipoDespesa.adicionarTipoDespesa(tipo);
    }

    private void editarTipoDespesa() {
        System.out.print("Digite o tipo de despesa a ser editado: ");
        String tipoAntigo = scanner.nextLine();
        System.out.print("Digite o novo tipo de despesa: ");
        String tipoNovo = scanner.nextLine();
        TipoDespesa.editarTipoDespesa(tipoAntigo, tipoNovo);
    }

    private void listarTiposDespesa() {
        System.out.println("\nTipos de despesas listados:");
        List<String> tipos = TipoDespesa.listarTiposDespesa();
        if (tipos.isEmpty()) {
            System.out.println("Nenhum tipo de despesa cadastrado.");
        } else {
            for (String tipo : tipos) {
                System.out.println("- " + tipo);
            }
        }
    }

    private void excluirTipoDespesa() {
        System.out.print("Digite o tipo de despesa a ser excluído: ");
        String tipo = scanner.nextLine();
        TipoDespesa.excluirTipoDespesa(tipo);
    }

    private void submenuGerenciarUsuarios() {
        int opcao;
        do {
            System.out.println("\n=== Gerenciar Usuários ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Editar Usuário");
            System.out.println("3. Listar Usuários");
            System.out.println("4. Excluir Usuário");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    editarUsuario();
                    break;
                case 3:
                    listarUsuarios();
                    break;
                case 4:
                    excluirUsuario();
                    break;
                case 5:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        } while (opcao != 5);
    }

    private void cadastrarUsuario() {
        System.out.print("Digite o nome do novo usuário: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o login do novo usuário: ");
        String login = scanner.nextLine();
        System.out.print("Digite a senha do novo usuário: ");
        String senha = scanner.nextLine();

        Usuario usuario = new Usuario(nome, login, senha);
        Usuario.adicionarUsuario(usuario);
    }

    private void editarUsuario() {
        System.out.print("Digite o login do usuário a ser editado: ");
        String login = scanner.nextLine();
        System.out.print("Digite o novo nome do usuário: ");
        String novoNome = scanner.nextLine();
        Usuario.editarUsuario(login, novoNome);
    }

    private void listarUsuarios() {
        System.out.println("\nUsuários cadastrados:");
        List<Usuario> usuarios = Usuario.listarUsuarios();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
        } else {
            for (Usuario usuario : usuarios) {
                System.out.println("Nome: " + usuario.getNome() + ", Login: " + usuario.getLogin());
            }
        }
    }

    private void excluirUsuario() {
        System.out.print("Digite o login do usuário a ser excluído: ");
        String login = scanner.nextLine();
        Usuario.excluirUsuario(login);
    }
}
