public class orgMaker {

    private Org buyerorg;
    private Org sellerorg;
    private Org wholeSallerorg;

    public orgMaker(){
        buyerorg = new Buyer();
        sellerorg = new seller();
        wholeSallerorg =new wholesaller();

    }

    public void showBuyer(){
        buyerorg.showName();

    }

    public void showSeller(){
        sellerorg.showName();

    }
    public void showWholesaller(){
        wholeSallerorg.showName();

    }

}
