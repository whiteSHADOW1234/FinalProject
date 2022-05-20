import java.awt.*;

public class MP_bar extends Rectangle{
    int id;
    MP_bar(int x, int y, int MP_WIDTH, int MP_HEIGHT, int id) {
		super(x, y, MP_WIDTH, MP_HEIGHT);
		this.id = id;
	}

    public void increase(){

    }

    public void draw(Graphics g){
        if (id == 1)
			g.setColor(Color.blue);
		else
			g.setColor(Color.red);
		g.fillRect(x, y, width, height);
		// white
		// g.setColor(Color.white);
		// g.fillRect(x, y + 40, width, height - 80);
    }
}
