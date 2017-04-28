package br.com.ftec.cadastrousuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CASSIUS on 24/04/2017.
 */

class DAO {

    private static List<Usuario> usuarios = new ArrayList<Usuario>();

    public static void incluirUsuario(Usuario usuario) {
        usuario.setId((long) (usuarios.size() + 1));
        usuarios.add(usuario);
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void alterarUsuario(Usuario usuarioParam) {
        Usuario usuarioDaLista;
        for (int i = 0; i < usuarios.size(); i++) {

            usuarioDaLista = usuarios.get(i);

            if (usuarioDaLista.getId().equals(usuarioParam.getId())) {
                usuarios.set(i, usuarioParam);
            }
        }
    }
    public static void excluirUsuario(Usuario usuario) {
            Usuario usuarioDaLista;
            for (int i = 0; i < usuarios.size(); i++) {

                usuarioDaLista = usuarios.get(i);

                if (usuarioDaLista.getId().equals(usuario.getId())) {
                    usuarios.remove(usuarioDaLista);
                }
            }
        }
}
