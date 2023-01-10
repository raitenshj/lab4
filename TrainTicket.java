public class TrainTicket extends Thing implements UseableForTravel{
    enum Usable { USED, NOT_USED}
    Usable usable = Usable.NOT_USED;
    public TrainTicket(Human owner, Integer price) {
        super(owner, price);
    }


    @Override
    public void useForTravel(Human human, Location destination) {

                Thread main = new Thread(new Runnable() {


                    @Override
                    public void run() {
                        if( (usable == Usable.NOT_USED) && (state == State.NOT_FORGOTTEN) ){
                            human.setLocation(Location.TRAIN);
                            try {
                                Thread.sleep(5000);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                            human.setLocation(destination);
                            usable = Usable.USED;
                        }
                    }
                });
                main.run();

    }

}
