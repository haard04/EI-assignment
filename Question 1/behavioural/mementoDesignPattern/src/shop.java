import java.util.ArrayList;
import java.util.List;

public class shop {
    private List<product> productList =new ArrayList<product>();

    public void add(product state){
        productList.add(state);
    }
    public product get(int index){
        return productList.get(index);
    }
}
