package exercise;

import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.Map;

// BEGIN
abstract class Tag {
    private String name;
    private Map<String, String> attr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, String> getAttr() {
        return attr;
    }

    public String getAttrAsString() {
        StringBuilder attrString = new StringBuilder();
        attr.forEach((k, v) -> attrString.append(String.format("%s=\"%s\" ", k, v)));
        return attrString.toString().strip();
    }

    public void setAttr(Map<String, String> attr) {
        this.attr = attr;
    }

    public Tag(String name, Map<String, String> attr) {
        this.name = name;
        this.attr = attr;
    }

    @Override
    public String toString() {
        return getAttrAsString().isEmpty() ? "<" + getName() + ">" : "<" + getName() + " " + getAttrAsString() + ">";
    }
}
// END
