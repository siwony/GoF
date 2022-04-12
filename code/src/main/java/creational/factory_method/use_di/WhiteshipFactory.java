package creational.factory_method.use_di;

class WhiteshipFactory implements ShipFactory {

    @Override
    public Ship createShip() {
        return new WhiteShip();
    }
}
