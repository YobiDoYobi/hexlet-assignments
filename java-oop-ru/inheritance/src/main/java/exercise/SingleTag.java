package exercise;

import java.util.Map;

// BEGIN
class SingleTag extends Tag {

    public SingleTag(String name, Map<String, String> attr) {
        super(name, attr);
    }

    /*@Override
    public String toString() {
        return getAttrAsString().isEmpty() ? "<" + getName() + ">" : "<" + getName() + " " + getAttrAsString() + ">";
    }*/
}
// END
