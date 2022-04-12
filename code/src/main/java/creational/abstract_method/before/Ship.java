package creational.abstract_method.before;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter
@ToString
class Ship {
    private String name;

    private String color;

    private String logo;

    private Anchor anchor;

    private Wheel wheel;
}
