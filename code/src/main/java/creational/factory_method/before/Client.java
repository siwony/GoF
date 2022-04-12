package creational.factory_method.before;

class Client {

    public static void main(String[] args) {
        final Client client = new Client();

        Ship whiteship = ShipFactory.orderShip("Whiteship", "siwon103305@gmail.com");
        System.out.println(whiteship);

        Ship blackship = ShipFactory.orderShip("Blackship", "siwon103305@gmail.com");
        System.out.println(blackship);
    }
}
