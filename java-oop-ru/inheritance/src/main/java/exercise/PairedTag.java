package exercise;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
class PairedTag extends Tag {
    String body;
    List<Tag> singleTags;

    public PairedTag(String name, Map<String, String> attr, String body, List<Tag> singleTags) {
        super(name, attr);
        this.body = body;
        this.singleTags = singleTags;
    }

    @Override
    public String toString() {
        return super.toString() + listSingleTagsAsString() + body + "</" + getName() + ">";
    }

    private String listSingleTagsAsString() {
        if (singleTags.isEmpty()) {
            return "";
        }
        return singleTags.stream()
                .map(Tag::toString)
                .collect(Collectors.joining());
    }
}
// END
