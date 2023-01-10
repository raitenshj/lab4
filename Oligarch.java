public class Oligarch extends Human{
    private Integer money;

    public Oligarch(Location location, String name, Integer money) {
        super(location, name);
        this.money = money;
    }

    public Boolean profitCalculation(Thing thing1, Thing thing2){
        return thing1.getPrice() < thing2.getPrice();
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
