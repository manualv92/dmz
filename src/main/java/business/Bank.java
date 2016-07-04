package business;

/**
 * Created by manua on 4/7/2016.
 */
public class Bank {
    private  String name;
    private  long money;

    public Bank(String name, long money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public long getMoney() {
        return money;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMoney(long money) {
        this.money = money;
    }
}
