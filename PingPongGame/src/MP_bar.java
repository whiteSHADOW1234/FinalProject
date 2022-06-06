import java.awt.*;

public class MP_bar extends Rectangle {
    int id;

    MP_bar(int x, int y, int MP_WIDTH, int MP_HEIGHT, int id) {
        super(x, y, MP_WIDTH, MP_HEIGHT);
        this.id = id;
    }

    public void increase(boolean hit_white_bar) {
        if (hit_white_bar) {
            super.width += 200;
        } else {
            super.width += 50;
        }
        if (super.width >= 500) {
            super.width = 500;
        }
    }
    public void move(int screee){
        x=screee-width;
    }

    public void draw(Graphics g) {
        if (id == 1)
            g.setColor(Color.blue);
        else
            g.setColor(Color.red);
        g.fillRect(x, y, width, height);
    }
}
