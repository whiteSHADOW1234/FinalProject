import java.util.Random;

public class TextAnimator implements Runnable {

    private String text;

    String[] names = new String[] { "Enkai Huang", "Cheng-De Lee", "Ming-yu Shieh", "Chia-Zung Kuo" };
    private int animationTime;
    private TextOutput textOutput;
    private Random random = new Random();
    private int id;

    public TextAnimator(int animationTime, TextOutput textField, int id) {
        this.animationTime = animationTime;
        this.textOutput = textField;
        this.id = id;
    }

    @Override
    public void run() {

        try {
            for (int j = 0; j < 4; j++) {
                text = names[j];
                for (int i = 0; i <= text.length(); i++) {
                    String textAtThisPoint = text.substring(0, i);

                    textOutput.writeText(textAtThisPoint, id);
                    Thread.sleep(animationTime + random.nextInt(150));
                }
                id++;
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}