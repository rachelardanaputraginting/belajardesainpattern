import java.util.ArrayList;
import java.util.List;

public class SistemLowongan implements Observable {
    private List<Observer> observers;
    private String lowonganTerbaru;

    public SistemLowongan() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String lowonganTerbaru) {
        this.lowonganTerbaru = lowonganTerbaru;
        for (Observer observer : observers) {
            observer.updateLowongan(lowonganTerbaru);
        }
    }

    public void tambahLowonganBaru(String lowonganTerbaru) {
        notifyObservers(lowonganTerbaru);
    }
}