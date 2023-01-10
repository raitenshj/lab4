public class Human {
    private Location location;
    enum State { ASLEEP, AWAKE}
    private State state = State.AWAKE;
    private final String name;

    public Human(Location location, String name) {
        this.location = location;
        this.name = name;
    }

    public void tryAction(String methodName, String parametr){
        switch (methodName) {
            case "shout":
                if (Math.random()>0.5){shout(parametr);}
                else {System.out.println("Чуть не закричал: " + parametr);}
                break;
        }
    }

    public void shout(String string){
        System.out.println(string.toUpperCase());
    }

    public void remember(Thing thing){System.out.println(this.name + " припомнил: " + thing.toString());}

    public String getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Human human)) return false;

        if (location != human.location) return false;
        if (state != human.state) return false;
        return name.equals(human.name);
    }

    @Override
    public int hashCode() {
        int result = location != null ? location.hashCode() : 0;
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + name.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Human{" +
                "location=" + location +
                ", state=" + state +
                ", name='" + name + '\'' +
                '}';
    }

}
