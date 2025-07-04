package designPatterns.Factory;

//factory for UIFactory
public class UIFactoryFactory {
    public static UIFactory getUIFactory(SupportedPlatforms platform) {
        return switch (platform) {
            case WINDOWS -> new WindowsFactory();
            case IOS -> new IosFactory();
            case ANDROID -> new AndroidFactory();
        };
    }
}
