package exercise;

// BEGIN
class LabelTag implements TagInterface {
    private String tag;

    public LabelTag(String value, TagInterface childTag) {
        this.tag = "<label>" + value + childTag.render() + "</label>";
    }

    @Override
    public String render() {
        return this.tag;
    }
}
// END
