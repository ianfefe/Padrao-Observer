import java.util.Observable;

public class Pix extends Observable {

    private String chave;

    public Pix(String chave){
        this.chave = chave;
    }

    public void confirmarPagamento(){
        setChanged();
        notifyObservers();
    }
}
