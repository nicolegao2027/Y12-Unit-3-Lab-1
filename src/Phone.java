public class Phone extends ElectronicItem{
    private String networkType;
    private int screenSize;

    public Phone(String name, String location, int price, String description, int storageCapacity, String model, String maker, String operatingSystem, String networkType, int screenSize) {
        super(name, location, price, description, storageCapacity, model, maker, operatingSystem);
        this.networkType = networkType;
        this.screenSize = screenSize;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }
}
