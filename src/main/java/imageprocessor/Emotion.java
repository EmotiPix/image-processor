package imageprocessor;

public enum Emotion {
    NEUTRAL("(ʘ_ʘ)"),
    ANGER("(⋋▂⋌)"),
    DISGUST("(⊙﹏⊙)"),
    HAPPY("(◔ ω ◔)"),
    SADNESS("(ಠ╭╮ಠ)"),
    SURPRISE("(⊙▃⊙)");

    private final String textRepresentation;

    Emotion(String textRepresentation) {
        this.textRepresentation = textRepresentation;
    }

    public String getTextRepresentation() {
        return textRepresentation;
    }
}
