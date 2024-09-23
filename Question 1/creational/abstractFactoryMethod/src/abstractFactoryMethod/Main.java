package abstractFactoryMethod;
interface Organisation {
    void createOrg();
}
interface Broker {
    void createBroker();
}
class Buyer implements Organisation {
    @Override
    public void createOrg() {
        System.out.println("Buyer is being created.");
    }
}
class Seller implements Organisation {
    @Override
    public void createOrg() {
        System.out.println("Seller is being created.");
    }
}
class BuyerBroker implements Broker {
    @Override
    public void createBroker() {
        System.out.println("Buyer Broker is being created");
    }
}
class SellerBroker implements Broker {
    @Override
    public void createBroker() {
        System.out.println("Seller Broker is being created");
    }
}
interface AbsFactory{
    Organisation createOrg(String type);
    Broker createBroker(String type);
}
class Buyerfac implements AbsFactory{

    @Override
    public Buyer createOrg(String type) {
        if(type.equalsIgnoreCase("buyer")){
            return new Buyer();
        }
        return null;
    }

    @Override
    public BuyerBroker createBroker(String type) {
        if(type.equalsIgnoreCase("BrokerBuyer")){
            return new BuyerBroker();
        }
        return null;
    }
}
class sellerfac implements AbsFactory{

    @Override
    public Seller createOrg(String type) {
        if(type.equalsIgnoreCase("Seller")){
            return new Seller();
        }
        return null;
    }

    @Override
    public SellerBroker createBroker(String type) {
        if(type.equalsIgnoreCase("BrokerSeller")){
            return new SellerBroker();
        }
        return null;
    }
}
public class Main {
    public static void main(String[] args) {
        Buyerfac of1 = new Buyerfac();
        Buyer c1 =  of1.createOrg("Buyer");
        c1.createOrg();
        sellerfac of2 = new sellerfac();
        Seller oc1 = of2.createOrg("Seller");
        oc1.createOrg();
    }
}