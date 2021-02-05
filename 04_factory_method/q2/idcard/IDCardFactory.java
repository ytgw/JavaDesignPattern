package idcard;
import framework.Factory;
import framework.Product;
import java.util.List;
import java.util.ArrayList;

public class IDCardFactory extends Factory {
    private List<String> owners = new ArrayList<String>();
    private List<Integer> serials = new ArrayList<Integer>();
    private int serial = 0;
    protected Product createProduct(String owner) {
        return new IDCard(owner, serial++);
    }
    protected void registerProduct(Product product) {
        serials.add(((IDCard)product).getSerial());
        owners.add(((IDCard)product).getOwner());
    }
    public List<String> getOwners() {
        return owners;
    }
    public List<Integer> getSerials() {
        return serials;
    }
}
