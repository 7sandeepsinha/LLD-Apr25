package designPatterns.Factory;

public class Flutter {
    private SupportedPlatforms platform;

    public Flutter(SupportedPlatforms platform) {
        this.platform = platform;
    }

    public void setTheme(){

    }

    public void setSounds(){

    }

    public UIFactory uiFactory(){
        if(platform.equals(SupportedPlatforms.IOS)){
            return new IosFactory();
        } else if(platform.equals(SupportedPlatforms.ANDROID)) {
            return new AndroidFactory();
        } else {
            return new WindowsFactory();
        }
    }
}
