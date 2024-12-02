package exercise;

// BEGIN
public class LabelTag implements TagInterface {
    private final String text;
    private final TagInterface tag;

    LabelTag(String text, TagInterface tag) {
        this.text = text;
        this.tag = tag;
    }

    @Override
    public String render() {
        return "<label>" +
                text +
                tag.render() +
                "</label>";
    }
}
// END
