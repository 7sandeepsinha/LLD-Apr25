package designPatterns.Builder.preInnnerClasses;

public class StudentValidator {

    public static boolean validate(StudentHelper studentHelper){
        return validateAge(studentHelper.getAge())
                && validateName(studentHelper.getName())
                && validateGradYear(studentHelper.getGradYear())
                && validatePhoneNumber(studentHelper.getPhoneNumber());
    }

    private static boolean validateAge(int age){
        return age >= 18;
    }

    private static boolean validateGradYear(int gradYear){
        return gradYear <= 2025;
    }

    private static boolean validateName(String name){
        return name != null && !name.isEmpty();
    }

    private static boolean validatePhoneNumber(String phoneNumber){
        return !phoneNumber.isEmpty() && phoneNumber.length() == 10;
    }
}
