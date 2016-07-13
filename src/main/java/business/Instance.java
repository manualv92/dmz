package business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

/**
 * Created by manua on 30/6/2016.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Instance {
    private  long id;
    private  String description;
    private  long total;
    //private final String banks;
    private List<Bank> banks;
/*
    public Instance(long id, String description, long total, List<Bank> banks) {
        this.id = id;
        this.description = description;
        this.total = total;
        this.banks = banks;
    }
*/
    public List<Bank> getBanks() {
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
