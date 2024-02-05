package exercise;

// BEGIN
class ReversedSequence implements CharSequence {
    private String str;

    public ReversedSequence(String inStr) {
        StringBuilder newStr = new StringBuilder(inStr);
        newStr.reverse();
        this.str = String.valueOf(newStr);
    }

    @Override
    public int length() {
        return this.length();
    }

    @Override
    public char charAt(int index) {
        return this.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return this.subSequence(start, end);
    }
}
// END
