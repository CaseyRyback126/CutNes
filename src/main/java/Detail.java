public class Detail {
    private int width;
    private int height;
    private int x;
    private int y;
    private boolean placed;

    public Detail(int width, int height) {
        this.width = width;
        this.height = height;
        this.placed = false;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isPlaced() {
        return placed;
    }

    public void setCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
        this.placed = true;
    }
}
