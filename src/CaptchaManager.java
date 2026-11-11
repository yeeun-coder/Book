import nl.captcha.Captcha;
import nl.captcha.backgrounds.GradiatedBackgroundProducer;
import java.awt.image.BufferedImage;

public class CaptchaManager {

    private Captcha currentCaptcha;
    private final int width;
    private final int height;

    public CaptchaManager(int width, int height) {
        this.width = width;
        this.height = height;
    }


    public BufferedImage refreshCaptcha() {
        this.currentCaptcha = new Captcha.Builder(width, height)
                .addText()
                .addBackground(new GradiatedBackgroundProducer())
                .addBorder().addNoise()
                .build();

        return currentCaptcha.getImage();
    }


    public boolean checkAnswer(String userAnswer) {
        if (currentCaptcha == null) {
            return false; // 캡챠가 생성X
        }
        // 대소문자를 구분
        String realAnswer = currentCaptcha.getAnswer();
        System.out.println(realAnswer);
        return currentCaptcha.isCorrect(userAnswer);
    }
    
    
    public String getDebugAnswer() {
        return (currentCaptcha != null) ? currentCaptcha.getAnswer() : "null";
    }
}