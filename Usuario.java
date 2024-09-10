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
        this.senha = criptografarSenha(senha);
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

    public static void adicionarUsuario(Usuario usuario) {
        try (FileWriter writer = new FileWriter("usuarios.txt", true)) {
            writer.write(usuario.getLogin() + ";" + usuario.getSenha() + ";" + usuario.getNome() + "\n");
        } catch (IOException e) {
            System.out.println("Erro ao adicionar usuário: " + e.getMessage());
        }
    }

    public static List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("usuarios.txt"))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(";");
                if (partes.length == 3) {
                    usuarios.add(new Usuario(partes[2], partes[0], partes[1]));
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao listar usuários: " + e.getMessage());
        }
        return usuarios;
    }

    public static void editarUsuario(String login, String novoNome) {
        List<Usuario> usuarios = listarUsuarios();
        try (FileWriter writer = new FileWriter("usuarios.txt", false)) {
            for (Usuario usuario : usuarios) {
                if (usuario.getLogin().equals(login)) {
                    writer.write(usuario.getLogin() + ";" + usuario.getSenha() + ";" + novoNome + "\n");
                } else {
                    writer.write(usuario.getLogin() + ";" + usuario.getSenha() + ";" + usuario.getNome() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao editar usuário: " + e.getMessage());
        }
    }

    public static void excluirUsuario(String login) {
        List<Usuario> usuarios = listarUsuarios();
        try (FileWriter writer = new FileWriter("usuarios.txt", false)) {
            for (Usuario usuario : usuarios) {
                if (!usuario.getLogin().equals(login)) {
                    writer.write(usuario.getLogin() + ";" + usuario.getSenha() + ";" + usuario.getNome() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao excluir usuário: " + e.getMessage());
        }
    }

    private static String criptografarSenha(String senha) {
        StringBuilder criptografada = new StringBuilder();
        for (char c : senha.toCharArray()) {
            criptografada.append((int) c).append(" ");
        }
        return criptografada.toString().trim();
    }
}