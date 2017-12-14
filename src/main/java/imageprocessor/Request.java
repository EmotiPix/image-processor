package imageprocessor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class Request {
    @Pattern(regexp = "^data:image/jpeg;base64,.+$")
    private String image;
    @NotNull
    private Emotion emotion;

    public Request() {
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Emotion getEmotion() {
        return emotion;
    }

    public void setEmotion(Emotion emotion) {
        this.emotion = emotion;
    }
}
