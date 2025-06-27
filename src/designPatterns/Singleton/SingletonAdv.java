package designPatterns.Singleton;

public class SingletonAdv {
    private static SingletonAdv instance = null;

    private SingletonAdv() {}

    public static SingletonAdv getInstance() {
        if(instance == null) { // Double-checked locking
            synchronized (SingletonAdv.class) {
                if (instance == null) {
                    instance = new SingletonAdv();
                }
            }
        }
        return instance;
    }
}
// Write a basic singleton class,
//  write multi-threaded code to create multiple singleton object
// Write a double check locked singleton class, then see if the solution works
