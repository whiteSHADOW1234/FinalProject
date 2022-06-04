import java.util.Random;

public class TextAnimator implements Runnable {

    private String text;
    private int animationTime;
    private TextOutput textOutput;
    private Random random = new Random();
    private int id;

    public TextAnimator(String text, int animationTime, TextOutput textField, int id) {
        this.text = text;
        this.animationTime = animationTime;
        this.textOutput = textField;
        this.id = id;
    }

    @Override
    public void run() {

        try {

            for (int i = 0; i <= text.length(); i++) {
                String textAtThisPoint = text.substring(0, i);

                textOutput.writeText(textAtThisPoint, id);
                Thread.sleep(animationTime + random.nextInt(150));
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}