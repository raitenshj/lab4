import java.util.Objects;

public abstract class Thing implements Manipulatable{
    enum State{FORGOTTEN, NOT_FORGOTTEN}
    protected State state = State.NOT_FORGOTTEN;
    protected Human owner;
    protected Integer price;
    protected Location location;

    public Thing(Human owner, Integer price) {
        this.owner = owner;
        this.price = price;
        this.location = owner.getLocation();
    }

    @Override
    public void buy(Oligarch buyer, Oligarch seller){
        buyer.setMoney(buyer.getMoney()-this.price);
        seller.setMoney(seller.getMoney()+this.price);
        this.owner=buyer;
    }

    @Override
    public void forget(){
        this.state=state.FORGOTTEN;
        this.location = this.owner.getLocation();
    }

    @Override
    public void take(Human human)  {
        //if (this.location == human.getLocation()){
        try {
            if (this.location != human.getLocation()) {
                throw new DifLocationsException();
            } else {
                this.state = state.NOT_FORGOTTEN;
            }
        } catch (DifLocationsException d) {System.out.println(d);}
    }
    //}

    public Integer getPrice() {
        return price;
    }

    public Location getLocation() {
        if (this.state == state.FORGOTTEN){return location;}
        else{return this.owner.getLocation();}
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thing thing)) return false;

        if (state != thing.state) return false;
        if (!owner.equals(thing.owner)) return false;
        if (!Objects.equals(price, thing.price)) return false;
        return location == thing.location;
    }

    @Override
    public int hashCode() {
        int result = state != null ? state.hashCode() : 0;
        result = 31 * result + owner.hashCode();
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Thing{" +
                "state=" + state +
                ", owner=" + owner +
                ", price=" + price +
                ", location=" + location +
                '}';
    }
}
