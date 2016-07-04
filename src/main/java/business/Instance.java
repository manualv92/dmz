package business;

/**
 * Created by manua on 30/6/2016.
 */
public class Instance {
    private final long id;
    private final String description;
    private final long total;
    //private final String banks;
    private Bank[] banks;

    public Instance(long id, String description, long total, String banks) {
        this.id = id;
        this.description = description;
        this.total = total;
        //this.banks = banks;
    }

    public Bank[] getBanks() {
        return banks;
    }

    public long getTotal() {
        return total;
    }

    public String getDescription() {
        return description;
    }

    public long getId() {
        return id;
    }
}
