package creational.abstract_method.after;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class Whiteship extends Ship {

    private Anchor anchor;

    private Wheel wheel;

    public Whiteship() {
        setName("whiteship");
        setLogo("\uD83D\uDEE5");
        setColor("white");
    }
}
