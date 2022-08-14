package devmultitask;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TesteCollections {

    static class Seriado {
        int    ano;
        String nome;
        String categoria;

        public int getAno() {
            return ano;
        }

        public String getNome() {
            return nome;
        }

        public String getCategoria() {
            return categoria;
        }

        Seriado() {
        }

        Seriado(int ano, String nome, String categoria) {
            this.ano = ano;
            this.nome = nome;
            this.categoria = categoria;
        }

        @Override
        public String toString() {
            return nome + " (" + ano + ") - " + categoria;
        }
    }

    public static void main(String[] args) {

        List<String> listaImutavel = List.of("zé", "abel", "certo");
        System.out.println("Lista 0: " + listaImutavel);

        // em runtime: java.lang.UnsupportedOperationException
        // Collections.sort(listaImutavel);

        // lista com String
        List<String> list = new ArrayList<>();
        list.add("zé");
        list.add("carlos");
        list.add("fernando");
        list.add("ana");
        System.out.println("Lista 1: " + list);

        list.sort(String::compareTo);

        System.out.println("Ordenada 1: " + list);

        list.add("aninha");
        System.out.println("Lista 2: " + list);

        Collections.sort(list);
        System.out.println("Ordenada 1: " + list);

        list.add("paulo");
        list.sort((s1, s2) -> (s1.compareTo(s2)));
        System.out.println("Ordenada 2: " + list);

        // lista com Seriado
        Seriado s1 = new Seriado(1992, "X-Files", "Sci-Fi");
        Seriado s2 = new Seriado(2015, "Stranger Things", "Sci-Fi");
        Seriado s3 = new Seriado(2001, "The Office", "Comédia");

        List<Seriado> listSeriado = new ArrayList<>();
        listSeriado.add(s1);
        listSeriado.add(s2);
        listSeriado.add(s3);
        System.out.println("Lista seriado 1: " + listSeriado);

        listSeriado.sort(Comparator.comparing(Seriado::getNome));
        System.out.println("Ordenada seriado 1: " + listSeriado);

        Collections.sort(listSeriado, Comparator.comparing(Seriado::getCategoria));
        System.out.println("Ordenada seriado 2: " + listSeriado);

    }
}
