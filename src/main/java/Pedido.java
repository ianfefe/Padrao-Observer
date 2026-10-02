import java.util.Observable;
import java.util.Observer;

public class Pedido implements Observer {

    public Pedido(String codigo){
        this.codigo = codigo;
        this.estado = "Pendente";
    }

    private String codigo;
    private String estado;

    public String getEstado() {
        return estado;
    }

    private void setEstado(String estado) {
        this.estado = estado;
    }

    public void pagar(Pix pix){
        pix.addObserver(this);
    }

    @Override
    public void update(Observable pix, Object arg) {
        setEstado("Confirmado");
    }

}
