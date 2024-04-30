import observer.Channel;
import observer.User;

public class Main {
    public static void main(String[] args) {
        Channel ch = new Channel("RAJARTAN Programming Channel");
        User user1 = new User("WPU Unpas");
        User user2 = new User("Programmer Zaman Now");
        User user3 = new User("Parsinta");

        ch.addSubscriber(user1);
        ch.addSubscriber(user3);
        ch.addSubscriber(user2);
        ch.notifyUser("Ada video baru buat anda! Jangan lupa di subscribe ya!");

        user2.subscribe(ch);
        ch.notifyUser("Video baru!");
    }
}