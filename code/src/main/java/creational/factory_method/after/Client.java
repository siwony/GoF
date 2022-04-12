package creational.factory_method.after;

class Client {

    public static void main(String[] args) {
        final Client client = new Client();

        Ship whiteship = new WhiteshipFactory().orderShip("Whiteship", "siwon103305@gmail.com");
        System.out.println(whiteship);

        Ship blackship = new BlackShipFactory().orderShip("Blackship", "siwon103305@gmail.com");
        System.out.println(blackship);
    }
}
