public class Main {
    public static void main(String[] args) {

        Oligarch scooperfield = new Oligarch(Location.FOREST, "Скуперфильд", 1000000);
        Oligarch seller = new Oligarch(Location.TOWN, "Продавец", 1000000);

        Cane blackCane = new  Cane(scooperfield, 100000);
        Cane redCane = new Cane(seller, 150000);
        Pillow pillow = new Pillow(scooperfield, 10000);
        TrainTicket start = new TrainTicket(scooperfield, 1000);
        TrainTicket[] ticketStock = new TrainTicket[10];

        Car car = new Car(scooperfield, 500);
        int count = 0;


        System.out.println(blackCane.toString());
        blackCane.state = Thing.State.FORGOTTEN;
        System.out.println(blackCane.toString());
        do {
            ticketStock[count]= new TrainTicket(seller, 1000);

            if(count == 0){
                start.useForTravel(scooperfield, Location.TOWN);
                System.out.println(scooperfield.toString());
            }
            else {
                ticketStock[count].buy(scooperfield, seller);
                ticketStock[count].useForTravel(scooperfield, Location.TOWN);
                System.out.println(scooperfield.toString());
            }
            scooperfield.tryAction("shout", "Я забыл трость!");
            count += 1;
            ticketStock[count]= new TrainTicket(seller, 1000);

            if (scooperfield.profitCalculation(ticketStock[count], redCane)) {
                ticketStock[count].useForTravel(scooperfield, blackCane.location);
                System.out.println(scooperfield.toString());
                blackCane.take(scooperfield);
                System.out.println(blackCane.toString());
                count += 1;
                ticketStock[count]= new TrainTicket(seller, 1000);
                ticketStock[count].useForTravel(scooperfield, Location.TOWN);
                System.out.println(scooperfield.toString());
                count += 1;
                ticketStock[count]= new TrainTicket(seller, 1000);
            }
            else{
                redCane.buy(scooperfield, seller);
                System.out.println(redCane.toString());
            }

        }while(blackCane.state != Thing.State.NOT_FORGOTTEN && redCane.owner != scooperfield);
        scooperfield.shout("У меня снова есть трость!");
        pillow.useForSleep(scooperfield);
        System.out.println(scooperfield.toString());

        blackCane.state = Thing.State.FORGOTTEN;
        scooperfield.setLocation(Location.TOWN);
        blackCane.take(scooperfield);
        System.out.println(car.toString());
    }
}