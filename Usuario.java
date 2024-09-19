import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String login;
    private String senha; // Senha criptografada

    public Usuario(String nome, String login, String senha) {
        this.nome = nome;
        this.login = login;
        this.senha = CriptografiaSenha.criptografar(senha);
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    // Adiciona um novo usuário ao arquivo "usuarios.txt"
    public static void adicionarUsuario(Usuario usuario) {
        try (FileWriter writer = new FileWriter("usuarios.txt", true)) {
            writer.write(usuario.getLogin() + ";" + usuario.getSenha() + ";" + usuario.getNome() + "\n");
            System.out.println("Usuário adicionado com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }

    // Lista todos os usuários do arquivo "usuarios.txt"
    public static List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    String nome = partes[2];
                    String login = partes[0];
                    String senhaCriptografada = partes[1];
                    String senhaDescriptografada = CriptografiaSenha.descriptografar(senhaCriptografada);
                    usuarios.add(new Usuario(nome, login, senhaDescriptografada));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }

    // Edita o nome de um usuário existente
    public static void editarUsuario(String login, String novoNome) {
        List<Usuario> usuarios = listarUsuarios();
        boolean encontrado = false;
        try (FileWriter writer = new FileWriter("usuarios.txt", false)) {
            for (Usuario usuario : usuarios) {
                if (usuario.getLogin().equals(login)) {
                    writer.write(usuario.getLogin() + ";" + usuario.getSenha() + ";" + novoNome + "\n");
                    encontrado = true;
                } else {
                    writer.write(usuario.getLogin() + ";" + usuario.getSenha() + ";" + usuario.getNome() + "\n");
                }
            }
            if (encontrado) {
                System.out.println("Usuário editado com sucesso.");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao editar usuário: " + e.getMessage());
        }
    }

    // Exclui um usuário existente
    public static void excluirUsuario(String login) {
        List<Usuario> usuarios = listarUsuarios();
        boolean encontrado = false;
        try (FileWriter writer = new FileWriter("usuarios.txt", false)) {
            for (Usuario usuario : usuarios) {
                if (!usuario.getLogin().equals(login)) {
                    writer.write(usuario.getLogin() + ";" + usuario.getSenha() + ";" + usuario.getNome() + "\n");
                } else {
                    encontrado = true;
                }
            }
            if (encontrado) {
                System.out.println("Usuário excluído com sucesso.");
            } else {
                System.out.println("Usuário não encontrado.");
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        }
    }
}
