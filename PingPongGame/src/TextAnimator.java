import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Vector;

public class TextAnimator implements Runnable {

    private String text;

    // initialize vector with {"Enkai Huang", "Cheng-De Lee", "Ming-yu Shieh", "Chia-Zung Kuo"}
    // private Vector<String> texts = new Vector<String>(Vector.asList("Enkai Huang", "Cheng-De Lee", "Ming-yu Shieh", "Chia-Zung Kuo"));
    // ArrayList<String> list = new ArrayList(Arrays.asList("Ryan", "Julie", "Bob"));
    String[] names = new String[] { "Enkai Huang", "Cheng-De Lee", "Ming-yu Shieh", "Chia-Zung Kuo" };
    private int animationTime;
    private TextOutput textOutput;
    private Random random = new Random();
    private int id;

    public TextAnimator(int animationTime, TextOutput textField, int id) {
        // this.text = text;
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