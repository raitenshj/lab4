public class Cane extends Thing{
    public Cane(Human owner, Integer price) {
        super(owner, price);
    }

    public void kill(Human human) {
        class Blade {
            protected static Integer length = 15;
            protected static String material = "silver";
            public Blade(Integer length, String material) {}

        }
        if ((this.owner.getLocation() == human.getLocation()) && (this.state == State.NOT_FORGOTTEN)) {
            System.out.println(human.getName()+"мёртв");
            human = null;
        }
    }
}
