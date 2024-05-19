public class ComputerSet {
    private ComputerSet computer;
    private String keyboard, mouse, speaker, monitor;

    public ComputerSet getComputer() {
        return computer;
    }

    public void setComputer(ComputerSet computer) {
        this.computer = computer;
    }

    public String getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(String keyboard) {
        this.keyboard = keyboard;
    }

    public String getMouse() {
        return mouse;
    }

    public void setMouse(String mouse) {
        this.mouse = mouse;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getMonitor() {
        return monitor;
    }

    public void setMonitor(String monitor) {
        this.monitor = monitor;
    }
}

class ComputerSetBuilder {
    private ComputerSet computerSet;

    public ComputerSetBuilder() {
        this.computerSet = new ComputerSet();
    }

    public ComputerSetBuilder(ComputerSet computerSet) {
        this.computerSet = computerSet;
    }

    public void computer(ComputerSet computer) {
        computerSet.setComputer(computer);
    }

    public void keyboard(String keyboard) {
        computerSet.setKeyboard(keyboard);
    }

    public void mouse(String mouse) {
        computerSet.setMouse(mouse);
    }

    public void speaker(String speaker) {
        computerSet.setSpeaker(speaker);
    }

    public void monitor(String monitor) {
        computerSet.setMonitor(monitor);
    }

    public ComputerSet getResult() {
        return computerSet;
    }

    public void resetBuilder() {
        computerSet = new ComputerSet();
    }
}

class Computer {
    public static void main(String[] args) {
        ComputerSetBuilder builder = new ComputerSetBuilder();

        builder.keyboard("Mechanical RGB Keyboard");
        builder.mouse("Gaming Mouse");
        builder.speaker("2.1 Channel Speaker System");
        builder.monitor("27-inch 4K Monitor");

        ComputerSet ghostComputer = builder.getResult();

        System.out.println("Computer Set Configuration:");
        System.out.println("Keyboard: " + ghostComputer.getKeyboard());
        System.out.println("Mouse: " + ghostComputer.getMouse());
        System.out.println("Speaker: " + ghostComputer.getSpeaker());
        System.out.println("Monitor: " + ghostComputer.getMonitor());

        builder.resetBuilder();

        builder.keyboard("Compact Wireless Keyboard");
        builder.mouse("Wireless Mouse");
        builder.speaker("Portable Bluetooth Speaker");
        builder.monitor("24-inch HD Monitor");

        ComputerSet coolComputer = builder.getResult();

        System.out.println("\nSecond Computer Set Configuration:");
        System.out.println("Keyboard: " + coolComputer.getKeyboard());
        System.out.println("Mouse: " + coolComputer.getMouse());
        System.out.println("Speaker: " + coolComputer.getSpeaker());
        System.out.println("Monitor: " + coolComputer.getMonitor());
    }
}



