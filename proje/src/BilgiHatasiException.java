public class BilgiHatasiException extends Exception{
    String message;

    public BilgiHatasiException(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }
}
