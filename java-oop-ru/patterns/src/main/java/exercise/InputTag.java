package exercise;

// BEGIN
class InputTag implements TagInterface {
    private String tag;

    @Override
    public String render() {
        return this.tag;
    }

    public InputTag(String type, String value) {
        this.tag = "<input type=\"" + type + "\" value=\"" + value + "\">";
    }
}
// END
