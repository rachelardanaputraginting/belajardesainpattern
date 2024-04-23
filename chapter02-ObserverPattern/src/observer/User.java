package observer;

public class User implements Observer {
    private final String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void receiveNotification(String msg) {
        System.out.println(name + " received: " + msg);
    }

    public void subscribe(Channel channel) {
        channel.addSubscriber(this);
    }

    public void unsubscribe(Channel channel) {
        channel.removeSubscriber(this);
    }

    public String getName() {
        return name;
    }
}
