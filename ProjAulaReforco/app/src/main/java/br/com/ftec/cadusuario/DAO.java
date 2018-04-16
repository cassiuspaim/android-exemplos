package br.com.ftec.cadusuario;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CASSIUS on 06/05/2017.
 */

class DAO {

    /**
     * Propriedade da classe que contem os usuarios do sistema
     */
    private static List<Usuario> listaDeUsuarios = new ArrayList<Usuario>();

    /**
     * Método que inclui usuário
     * @param usuario
     */
    public static void incluirUsuario(Usuario usuario) {
        usuario.setId((long) (listaDeUsuarios.size() + 1));
        listaDeUsuarios.add(usuario);
    }

    public static List<Usuario> getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public static void excluirUsuario(Usuario usuarioParam) {

        Usuario usuarioDaLista;
        for (int i = 0; i < listaDeUsuarios.size(); i++) {

            usuarioDaLista = listaDeUsuarios.get(i);

            if (usuarioDaLista.getId().equals( usuarioParam.getId() ) ) {
                listaDeUsuarios.remove(usuarioDaLista);
            }

        }
    }

    public static void alterarUsuario(Usuario usuarioParam) {

        Usuario usuarioDaLista;
        for (int i = 0; i < listaDeUsuarios.size(); i++) {

            usuarioDaLista = listaDeUsuarios.get(i);

            if (usuarioDaLista.getId().equals( usuarioParam.getId() ) ) {
                listaDeUsuarios.set(i, usuarioParam);
            }

        }
    }
}
