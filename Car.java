public class Car implements UseableForTravel{
    private Human owner;
    private Location location;

    private Engine engine;
    private  Integer speed;
    public Car(Human owner, Integer horsePowers) {
        this.engine = new Engine(horsePowers);
        this.owner = owner;
        this.location = this.owner.getLocation();
        this.speed = horsePowers/3;
    }

    @Override
    public void useForTravel(Human human, Location destination) {

        Thread main = new Thread(new Runnable() {


            @Override
            public void run() {
                if(human.getLocation() == location ){
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    human.setLocation(destination);
                    location = destination;
                }
            }
        });
        main.run();

    }


    @Override
    public String toString() {
        return "Car{" +
                "location=" + location +
                ", speed=" + speed +
                '}';
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    private class Engine{
        private Integer horsePowers;
        private final Integer limitHorsePowers=50000;
        public Engine(Integer horsePowers) {
            if(horsePowers > limitHorsePowers) throw new PhysicalException();
            this.horsePowers = horsePowers;
        }
    }

    public static class Battery{
        private static Integer power = 1000;
    }
}
