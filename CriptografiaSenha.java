public class CriptografiaSenha {
    public static String criptografar(String senha) {
        StringBuilder criptografada = new StringBuilder();
        for (char c : senha.toCharArray()) {
            criptografada.append((int) c).append(" ");
        }
        return criptografada.toString().trim();
    }

    public static String descriptografar(String senhaCriptografada) {
        StringBuilder senha = new StringBuilder();
        String[] partes = senhaCriptografada.split(" ");
        for (String parte : partes) {
            int valor = Integer.parseInt(parte);
            senha.append((char) valor);
        }
        return senha.toString();
    }
}
