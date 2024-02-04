package exercise;

import lombok.Getter;

// BEGIN
@Getter
class Point{
    private int X;
    private int y;

    public Point(int x, int y) {
        this.X = x;
        this.y = y;
    }
}
// END
