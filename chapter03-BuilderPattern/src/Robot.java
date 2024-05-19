public class Robot {
    private String shield, sword, gun, brainchip;

    public Robot(){}

    public String getShield(){
        return shield;
    }

    public void setShield(String shield){
        this.shield = shield;
    }

    public String getSword() {
        return sword;
    }

    public void setSword(String sword) {
        this.sword = sword;
    }

    public String getGun() {
        return gun;
    }

    public void setGun(String gun) {
        this.gun = gun;
    }

    public String getBrainchip() {
        return brainchip;
    }

    public void setBrainchip(String brainchip) {
        this.brainchip = brainchip;
    }

    @Override
    public String toString() {
        return "Robot Properties"
                + "\n-----------"
                + "\nShield: " + getShield()
                + "\nGun: " + getGun()
                + "\nSword: " + getSword()
                + "\nBrain chip: " + getBrainchip();
    }
}

class RobotBuilder {
    private Robot robot;

    public RobotBuilder() {
        this.robot = new Robot();
    }

    public RobotBuilder(Robot robot) {
        this.robot = robot;
    }

    public RobotBuilder shield(String shield) {
        robot.setShield(shield);
        return this;
    }

    public RobotBuilder gun(String gun) {
        robot.setGun(gun);
        return this;
    }

    public RobotBuilder sword(String sword) {
        robot.setSword(sword);
        return this;
    }

    public RobotBuilder brainchip(String brainchip){
        robot.setBrainchip(brainchip);
        return this;
    }

    public Robot getResult(){
        return robot;
    }
}

class RobotDirector {
    private static RobotDirector director = null;

    private RobotDirector() {}

    public static synchronized RobotDirector getInstance() {
        if(director == null) {
            director = new RobotDirector();
        }

        return director;
    }

    public Robot CasualRobot() {
        RobotBuilder builder = new RobotBuilder();
        builder.brainchip("Kasula Brain");
        builder.sword("Taito Ward");
        builder.gun("P30");

        return builder.getResult();
    }

    public Robot IntelligentRobot() {
        RobotBuilder builder = new RobotBuilder();
        builder.brainchip("AI-Powered Brain");
        builder.sword("SAAS Shield");
        builder.gun("M1A4 with Smartscope");
        builder.gun("Wielded Blade Arm");

        return builder.getResult();
    }

    public Robot RereRobot() {
        RobotBuilder robotBuilder = new RobotBuilder();
        Robot bot = robotBuilder.brainchip("i3").gun("Desert Eagle").getResult();
        return bot;
    }
}

class BuildRobot {
    public static void main(String[] args) throws Exception {
        RobotDirector director = RobotDirector.getInstance();
        Robot casualRobot = director.CasualRobot();
        System.out.println(casualRobot);

        Robot intelligentRobot = director.IntelligentRobot();
        System.out.println(intelligentRobot);

        Robot rereRobot = director.RereRobot();
        System.out.println(rereRobot);
    }
}

