package exercise;

// BEGIN
public class InputTag implements TagInterface{
    private final String tagType;
    private final String tagValue;

    InputTag(String tagType, String tagValue) {
        this.tagType = tagType;
        this.tagValue = tagValue;
    }

    @Override
    public String render() {
        return "<input type=\"" +
                this.tagType +
                "\" value=\"" +
                this.tagValue +
                "\">";
    }
}
// END
