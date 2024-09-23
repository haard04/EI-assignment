public class Main {
    public static void main(String[] args) {

        factory Factory = new factory();
        shop Shop =new shop();
        Factory.setState("State 1");
        Factory.setState("State 2");
        Shop.add(Factory.SaveStateToProduct());
        Factory.setState("State 3");
        Shop.add(Factory.SaveStateToProduct());
        Factory.setState("State 4");
        System.out.println("Current state:"+Factory.getState());
        Factory.getStateFromProduct(Shop.get(0));
        System.out.println("Fist saved state:"+Factory.getState());
        Factory.getStateFromProduct(Shop.get(1));
        System.out.println("2nd saved state:"+Factory.getState());



    }
}