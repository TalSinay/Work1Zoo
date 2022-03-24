package mobility;

public class Point {
    private int x,y;
    static final int minx=0;
    static final int maxx=800;
    static final int miny=0;
    static final int maxy=600;
    public Point(int x,int y) {
        this.x=x;
        this.y=y;
    }
    public void setx(int x) {
        this.x=x;
    }
    public void sety(int y) {
        this.y=y;
    }
    public int getx() {
        return this.x;
    }
    public int gety() {
        return this.y;
    }
    public int getmaxX() {
        return this.maxx;
    }
    public int getminx() {
        return this.minx;
    }
    public int getmaxy() {
        return this.maxy;
    }
    public int getminy() {
        return this.miny;
    }

}
