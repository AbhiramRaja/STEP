public class AppConfigurator {
    public static void main(String[] args) {
        AppConfig.NetworkConfig net = new AppConfig.NetworkConfig("localhost", 8080);
        net.display();
    }
}