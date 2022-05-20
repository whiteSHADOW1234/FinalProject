import javafx.scene.shape.Rectangle;

import java.awt.*;
import java.awt.event.*;

public class MP_bar extends Rectangle{
    int id;
    MP_bar(int x, int y, int MP_WIDTH, int MP_HEIGHT, int id) {
		super(x, y, MP_WIDTH, MP_HEIGHT);
		this.id = id;
	}
}
