import java.util.Scanner;

public class MenuPrincipal {
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        int opcao;

        do {
            System.out.println("=== Sistema de Controle de Despesas ===");
            System.out.println("1. Entrar Despesa");
            System.out.println("2. Anotar Pagamento");
            System.out.println("3. Listar Despesas em Aberto no período");
            System.out.println("4. Listar Despesas Pagas no período");
            System.out.println("5. Gerenciar Tipos de Despesa");
            System.out.println("6. Gerenciar Usuários");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

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
        System.out.println("=== Entrar Despesa ===");
        // Implementar funcionalidades para adicionar despesa
        System.out.println("Digite a descrição da despesa:");
        String descricao = scanner.next();
        System.out.println("Digite o valor da despesa:");
        double valor = scanner.nextDouble();
        System.out.println("Digite a data de vencimento (YYYY-MM-DD):");
        String data = scanner.next();
        System.out.println("Digite a categoria da despesa:");
        String categoria = scanner.next();

        // Criar e salvar a despesa
        System.out.println("Despesa adicionada com sucesso.");
    }

    private void submenuAnotarPagamento() {
        System.out.println("=== Anotar Pagamento ===");
        // Implementar funcionalidades para anotar pagamento
        System.out.println("Digite a descrição da despesa para pagamento:");
        String descricao = scanner.next();
        System.out.println("Digite o valor pago:");
        double valorPago = scanner.nextDouble();
        System.out.println("Digite a data do pagamento (YYYY-MM-DD):");
        String dataPagamento = scanner.next();

        // Criar e salvar o pagamento
        System.out.println("Pagamento anotado com sucesso.");
    }

    private void submenuListarDespesasEmAberto() {
        System.out.println("=== Listar Despesas em Aberto ===");
        // Implementar funcionalidades para listar despesas em aberto
        System.out.println("Despesas em aberto listadas com sucesso.");
    }

    private void submenuListarDespesasPagas() {
        System.out.println("=== Listar Despesas Pagas ===");
        // Implementar funcionalidades para listar despesas pagas
        System.out.println("Despesas pagas listadas com sucesso.");
    }

    private void submenuGerenciarTiposDeDespesa() {
        int opcao;
        do {
            System.out.println("=== Gerenciar Tipos de Despesa ===");
            System.out.println("1. Adicionar Tipo de Despesa");
            System.out.println("2. Editar Tipo de Despesa");
            System.out.println("3. Listar Tipos de Despesa");
            System.out.println("4. Excluir Tipo de Despesa");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

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
        System.out.println("Digite o novo tipo de despesa:");
        String tipo = scanner.next();
        // Adicionar tipo ao armazenamento
        System.out.println("Tipo de despesa adicionado com sucesso.");
    }

    private void editarTipoDespesa() {
        System.out.println("Digite o tipo de despesa a ser editado:");
        String tipoAntigo = scanner.next();
        System.out.println("Digite o novo tipo de despesa:");
        String tipoNovo = scanner.next();
        // Editar tipo no armazenamento
        System.out.println("Tipo de despesa editado com sucesso.");
    }

    private void listarTiposDespesa() {
        System.out.println("Tipos de despesas listados:");
        // Listar tipos de despesa
    }

    private void excluirTipoDespesa() {
        System.out.println("Digite o tipo de despesa a ser excluído:");
        String tipo = scanner.next();
        // Excluir tipo do armazenamento
        System.out.println("Tipo de despesa excluído com sucesso.");
    }

    private void submenuGerenciarUsuarios() {
        int opcao;
        do {
            System.out.println("=== Gerenciar Usuários ===");
            System.out.println("1. Cadastrar Usuário");
            System.out.println("2. Editar Usuário");
            System.out.println("3. Listar Usuários");
            System.out.println("4. Excluir Usuário");
            System.out.println("5. Voltar ao Menu Principal");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

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
        System.out.println("Digite o nome do novo usuário:");
        String nome = scanner.next();
        System.out.println("Digite o login do novo usuário:");
        String login = scanner.next();
        System.out.println("Digite a senha do novo usuário:");
        String senha = scanner.next();
        // Criptografar senha em ASCII e armazenar o usuário
        System.out.println("Usuário cadastrado com sucesso.");
    }

    private void editarUsuario() {
        System.out.println("Digite o login do usuário a ser editado:");
        String login = scanner.next();
        System.out.println("Digite o novo nome do usuário:");
        String novoNome = scanner.next();
        // Editar usuário no armazenamento
        System.out.println("Usuário editado com sucesso.");
    }

    private void listarUsuarios() {
        System.out.println("Usuários cadastrados:");
        // Listar usuários
    }

    private void excluirUsuario() {
        System.out.println("Digite o login do usuário a ser excluído:");
        String login = scanner.next();
        // Excluir usuário do armazenamento
        System.out.println("Usuário excluído com sucesso.");
    }
}