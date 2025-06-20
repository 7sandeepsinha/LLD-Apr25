package advancedConcepts;

public class SingleLineValidator implements Validator{
    @Override
    public boolean validate() {
        return StaticValidation.validate();
    }
}
