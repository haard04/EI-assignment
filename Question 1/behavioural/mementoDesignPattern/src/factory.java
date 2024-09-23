public class factory {
    private String state;
    public void setState(String state){
        this.state=state;

    }

    public String getState() {
        return state;
    }
    public product SaveStateToProduct(){
        return new product(state);

    }
    public void getStateFromProduct(product pr){
        state=pr.getState();
    }
}
