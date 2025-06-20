package advancedConcepts;

public class StatusNodeValidator implements Validator{

    @Override
    public boolean validate() {
        System.out.println("validating status node");
        return true;
    }
}
