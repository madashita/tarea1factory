package factoryDevices;

public class FactoryDevice {
    public enum DeviceType{
        ANDROID,
        IOS,
        WINDOW_PHONE
    }

    public static IDevices make(DeviceType type){
        IDevices device;

        switch (type){
            case ANDROID:
                device= new Android();
                break;
            case IOS:
                device= new IOS();
                break;
            case WINDOW_PHONE:
                device= new WindowsPhone();
                break;
            default:
                device= new Android();
                break;
        }
        return device;
    }

}
