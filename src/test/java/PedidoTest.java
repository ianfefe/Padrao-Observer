import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PedidoTest {

    @Test
    public void deveConfirmarPedido() {
        Pix pix = new Pix("PIX.GOV123");
        Pedido pedido = new Pedido("Pedido 1");
        pedido.pagar(pix);
        pix.confirmarPagamento();
        assertEquals("Confirmado", pedido.getEstado());
    }

    @Test
    public void deveConfirmarPedidos() {
        Pix pix = new Pix("PIX.GOV123");
        Pedido pedido = new Pedido("Pedido 1");
        Pedido pedido2 = new Pedido("Pedido 2");
        pedido.pagar(pix);
        pedido2.pagar(pix);
        pix.confirmarPagamento();
        assertEquals("Confirmado", pedido.getEstado());
        assertEquals("Confirmado", pedido2.getEstado());
    }

    @Test
    public void naoDeveConfirmarPedido() {
        Pix pix = new Pix("PIX.GOV123");
        Pedido pedido = new Pedido("Pedido 1");
        assertEquals("Pendente", pedido.getEstado());
    }

    @Test
    public void deveConfirmarPedidoPixGov() {
        Pix pix = new Pix("PIX.GOV123");
        Pix pix2 = new Pix("PIX.BR");
        Pedido pedido = new Pedido("Pedido 1");
        Pedido pedido2 = new Pedido("Pedido 2");
        pedido.pagar(pix);
        pedido2.pagar(pix2);
        pix.confirmarPagamento();
        assertEquals("Confirmado", pedido.getEstado());
        assertEquals("Pendente", pedido2.getEstado());
    }
}