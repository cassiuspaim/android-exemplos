package br.com.ftec.exemplolistview;

/**
 * Created by CASSIUS on 18/04/2017.
 */

public enum EstadoAtual {

    FAZENDO{
        @Override
        public String toString() {
            return "Fazendo";
        }
    }, FINALIZADO{
        @Override
        public String toString() {
            return "finalizado";
        }
    };
}
