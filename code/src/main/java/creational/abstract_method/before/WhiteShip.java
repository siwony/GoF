package creational.abstract_method.before;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class WhiteShip extends Ship {

    public WhiteShip() {
        setName("whiteship");
        setLogo("\uD83D\uDEE5");
        setColor("white");
    }
}
