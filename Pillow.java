public class Pillow extends Thing implements UseableForSleep{
    public Pillow(Human owner, Integer price) {
        super(owner, price);
    }

    @Override
    public void useForSleep(Human human) {
        human.setState(Human.State.ASLEEP);
    }
}
