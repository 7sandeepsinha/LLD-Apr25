package advancedConcepts;

public class ReviewNodeValidator implements Validator{
    @Override
    public boolean validate() {
        System.out.println("Review Node Validator");
        return true;
    }
}
