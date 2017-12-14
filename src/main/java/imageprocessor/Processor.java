package imageprocessor;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

@Service
class Processor {
    String process(String encodedImage, Emotion emotion) throws IOException {
        BufferedImage image = decode(encodedImage);
        applyEmotion(image, emotion);
        String encodedTransformedImage = encode(image);

        return getBase64Part(encodedTransformedImage);
    }

    private BufferedImage decode(String encodedImage) throws IOException {
        String base64Part = getBase64Part(encodedImage);
        byte[] imageBytes = Base64.getDecoder().decode(base64Part);
        ByteArrayInputStream imageByteStream = new ByteArrayInputStream(imageBytes);

        return ImageIO.read(imageByteStream);
    }

    private void applyEmotion(BufferedImage image, Emotion emotion) {
        Graphics graphics = image.getGraphics();

        graphics.setFont(graphics.getFont().deriveFont(60f));
        graphics.drawString(emotion.getTextRepresentation(), 100, 100);
        graphics.dispose();
    }

    private String encode(BufferedImage image) throws IOException {
        ByteArrayOutputStream imageOutputByteStream = new ByteArrayOutputStream();
        ImageIO.write(image, "jpeg", imageOutputByteStream);

        return Base64.getEncoder().encodeToString(imageOutputByteStream.toByteArray());
    }

    private static String getBase64Part(String string) {
        return string.substring(string.indexOf(",") + 1);
    }
}
