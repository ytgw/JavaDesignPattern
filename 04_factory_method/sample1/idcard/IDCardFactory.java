package idcard;
import framework.Factory;
import framework.Product;
import java.util.List;
import java.util.ArrayList;

public class IDCardFactory extends Factory {
    private List<String> owners = new ArrayList<String>();
    protected Product createProduct(String owner) {
        return new IDCard(owner);
    }
    protected void registerProduct(Product product) {
        owners.add(((IDCard)product).getOwner());
    }
    public List<String> getOwners() {
        return owners;
    }
}
