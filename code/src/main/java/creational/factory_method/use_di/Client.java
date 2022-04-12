package creational.factory_method.use_di;

class Client {

    public static void main(String[] args) {
        final Client client = new Client();

        client.print(new WhiteshipFactory(), "whiteship", "siwon103305@gmail.com");
        client.print(new BlackShipFactory(), "blackship", "siwon103305@gmail.com");
    }

    // 일종의 DI
    private void print(ShipFactory shipFactory, String name, String email) {
        System.out.println(shipFactory.orderShip(name, email));
    }
}
