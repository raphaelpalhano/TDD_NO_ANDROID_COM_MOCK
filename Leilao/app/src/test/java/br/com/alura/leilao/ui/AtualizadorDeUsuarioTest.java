package br.com.alura.leilao.ui;

import android.support.v7.widget.RecyclerView;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.alura.leilao.database.dao.UsuarioDAO;
import br.com.alura.leilao.model.Usuario;
import br.com.alura.leilao.ui.recyclerview.adapter.ListaUsuarioAdapter;

import static org.junit.Assert.*;


@RunWith(MockitoJUnitRunner.class)
public class AtualizadorDeUsuarioTest {
    @Mock
    private UsuarioDAO dao;
    @Mock
    private ListaUsuarioAdapter adapter;

    @Mock
    private RecyclerView recykerView;


    @Test
    public void deveAtualizarListaDeUsuarioQuandoSalvarUsuario(){
        AtualizadorDeUsuario atualizadorDeUsuario = new AtualizadorDeUsuario(dao, adapter, recykerView);

        Usuario joao = new Usuario("Joao");
        Mockito.when(dao.salva(joao)).thenReturn(new Usuario(1, "Joao"));
        Mockito.when(adapter.getItemCount()).thenReturn(1);


        atualizadorDeUsuario.salva(joao);

        Mockito.verify(dao).salva(new Usuario("Joao"));

        Mockito.verify(adapter).adiciona(new Usuario(1, "Joao"));

        Mockito.verify(recykerView).smoothScrollToPosition(0);
    }

}