package exercise;

// BEGIN
class Cottage implements Home {
    private double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return this.area;
    }

    @Override
    public int compareTo(Home another) {
        int result = 0;
        if (this.getArea() > another.getArea()) {
            result = 1;
        } else if (this.getArea() < another.getArea()) {
            result = -1;
        }
        return result;
    }

    @Override
    public String toString() {
        return floorCount +
                " этажный коттедж площадью " + area +
                " метров";
    }
}
// END
