package src;

import org.junit.jupiter.api.Test;
import src.Pessoa;

import static org.junit.jupiter.api.Assertions.*;

public class TesteEmail {

    @Test
    public static void testar_email_com_arroba(){
        assertTrue(Pessoa.emailValid("email_teste@dominio.com.br"));
    }

    @Test
    public static void testar_email_sem_arroba(){
        assertFalse(Pessoa.emailValid("email_testedominio.com.br"));

    }

    @Test
    public static void testar_email_mais_50_caracteres(){
        assertEquals(false, Pessoa.emailValid("email_teste_muito_longo_nao_deve_ser_valido@dominio.com.br"));
    }
}
