class Point {

  private int x;

  private int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public int[] getXYPair() {
    return new int[]{x, y};
  }

  public double distance(int x, int y) {
    return Math.sqrt((y - this.y) * (y - this.y) + (x - this.x) * (x - this.x));
  }

  public double distance(Point point) {

    int a = point.getXYPair()[0];
    int b = point.getXYPair()[1];

    return Math.sqrt((b - y) * (b - y) + (a - x) * (a - x));
  }

  public double distance() {
    return Math.sqrt((0 - y) * (0 - y) + (0 - x) * (0 - x));
  }
}
