package observer;

import java.util.Vector;

public class Channel implements Observable {
    private String name;
    private Vector<User> subscibers;

    public Channel(String name) {
        this.name = name;
        this.subscibers = new Vector<User>();
    }

    @Override
    public void addSubscriber(User user) {
        if (!subscibers.contains(user)) {
            subscibers.add(user);
        }
    }

    @Override
    public void removeSubscriber(User user) {
        subscibers.remove(user);
    }

    @Override
    public void notifyUser(String msg) {
        System.out.println(name + " posted a new video!");
        String constructedMessage = String.format("%s: %s", name, msg);
        for (User user : subscibers) {
            user.receiveNotification(constructedMessage);
        }
    }
}
