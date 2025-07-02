package designPatterns.Builder.productionised;

public class Student {
    private int id;
    private String name;
    private double psp;
    private int age;
    private String batch;
    private String universityName;
    private int gradYear;
    private String phoneNumber;

    public Student(int id, String name, double psp, int age, String batch, String universityName, int gradYear, String phoneNumber) {
        this(id, name, psp);
        this.age = age;
        this.batch = batch;
        this.universityName = universityName;
        this.gradYear = gradYear;
        this.phoneNumber = phoneNumber;
    }

    public Student(int id, String name, double psp) {
        this.id = id;
        this.name = name;
        this.psp = psp;
    }

    public static Builder builder(){
        return new Builder();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", psp=" + psp +
                ", age=" + age +
                ", batch='" + batch + '\'' +
                ", universityName='" + universityName + '\'' +
                ", gradYear=" + gradYear +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static class Builder {
        private int id;
        private String name;
        private double psp;
        private int age;
        private String batch;
        private String universityName;
        private int gradYear;
        private String phoneNumber;

        public Builder() {}

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder psp(double psp) {
            this.psp = psp;
            return this;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder batch(String batch) {
            this.batch = batch;
            return this;
        }

        public Builder universityName(String universityName) {
            this.universityName = universityName;
            return this;
        }

        public Builder gradYear(int gradYear) {
            this.gradYear = gradYear;
            return this;
        }

        public Builder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        private void validate(){
            if(this.age < 18)
                throw new InvalidAgeException("Age must be at least 18");
            if(this.gradYear > 2025){
                throw new InvalidGradYearException("Grad year must be 2025 or earlier");
            }
            if(this.name == null || this.name.isBlank() || this.name.isEmpty()){
                throw new InvalidNameException("Name cannot be empty");
            }
        }

        public Student build(){
            validate(); // first it validates -> if anything goes wrong, it throws exception
            return new Student(this.id, this.name, this.psp, this.age, this.batch, this.universityName, this.gradYear, this.phoneNumber);
        }
    }

}
