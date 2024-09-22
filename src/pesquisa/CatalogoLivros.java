package pesquisa;

import java.util.ArrayList;
import java.util.List;

public class CatalogoLivros {
    //atributo
    private List<Livro> livroList;

    public CatalogoLivros() { this.livroList = new ArrayList<>(); }

    public void adicionarLivro(String titulo, String autor, int anoPublicacao) {
        livroList.add(new Livro(titulo, autor, anoPublicacao));
    }

    public List<Livro> pesquisarPorAutor(String autor) {
        List<Livro> livrosPorAutor = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for (Livro l : livroList) {
             if(l.getAutor().equalsIgnoreCase(autor)) {
                 livrosPorAutor.add(l);
             }
            }
        }
        return livrosPorAutor;
    }

    public List<Livro> pesquisarPorIntervaloAnos(int anoInicial, int anoFinal) {
        List<Livro> livrosPorIntervaloAnos = new ArrayList<>();
        if(!livroList.isEmpty()) {
            for(Livro l : livroList) {
                if(l.getAnoPublicacao() >= anoInicial && l.getAnoPublicacao() <= anoFinal) {
                    livrosPorIntervaloAnos.add(l);
                }
            }
        }
        return livrosPorIntervaloAnos;
    }

    public Livro pesquisarPorTitulo(String titulo) {
        Livro livroPorTitulo = null;
        if(!livroList.isEmpty()) {
            for(Livro l : livroList) {
                if(l.getTitulo().equalsIgnoreCase(titulo)) {
                    livroPorTitulo = l;
                    break;
                }
            }
        }
        return livroPorTitulo;
    }

    public static void main(String[] args) {
        CatalogoLivros catalogoLivros = new CatalogoLivros();
        catalogoLivros.adicionarLivro("LIVRO 1", "AUTOR 1", 2000);
        catalogoLivros.adicionarLivro("LIVRO 1", "AUTOR 2", 2001);
        catalogoLivros.adicionarLivro("LIVRO 2", "AUTOR 2", 2002);
        catalogoLivros.adicionarLivro("LIVRO 3", "AUTOR 3", 2003);
        catalogoLivros.adicionarLivro("LIVRO 4", "AUTOR 4", 2004);

    System.out.println(catalogoLivros.pesquisarPorAutor("AUTOR 4"));
    System.out.println(catalogoLivros.pesquisarPorIntervaloAnos(2000, 2003));
    System.out.println(catalogoLivros.pesquisarPorTitulo("LIVRO 1"));

    }
}
