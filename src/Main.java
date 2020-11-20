import java.util.Scanner;

abstract class Shape {
    abstract double area();
}

class Rectangle extends Shape {
    private int height;
    private int width;

    Rectangle(int a, int b) {
        height=a;
        width=b;
    }

    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }

    void setHeight(int a) {height=a;}
    void setWidth(int a) {width=a;}
    double area() {return height*width;}
}

interface Movable {
    void move(int a, int b);
    boolean checkSpeed();
}

class MovablePoint implements Movable{
    int x, y,x1,y1;

    public void move(int a, int b) {
        x=x1;
        y=y1;
        x1=x+a;
        y1=y+b;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getX1() {
        return x1;
    }

    public int getY1() {
        return y1;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean checkSpeed() {
        return false;
    }
}

class MovableRectangle extends Rectangle implements Movable{
    private MovablePoint leftH=new MovablePoint();
    private MovablePoint rightB=new MovablePoint();

    MovableRectangle(int a, int b) {
        super(a, b);
    }

    public void setLeftH(int x, int y) {
        this.leftH.setX(x);
        this.leftH.setY(y);
        this.setRightB(x, y);
    }

    public void setRightB(int x, int y) {
        this.rightB.setX(x + getWidth());
        this.rightB.setY(y + getHeight());
    }

    public void getRightB() {
        System.out.println("Крайняя правая нижняя точка:\nx = " + this.rightB.getX() + " y = " + this.rightB.getY());
    }

    public void getLeftH() {
        System.out.println("Крайняя правая нижняя точка:\nx = " + this.leftH.getX() + " y = " + this.leftH.getY());
    }

    @Override
    public void move(int a, int b) {
        leftH.move(a,b);
        rightB.move(a,b);
    }

    @Override
    public boolean checkSpeed() {
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        int point1,point2;
        Scanner scanner=new Scanner(System.in);

        System.out.print( "Высота: ");
        point1=scanner.nextInt();
        System.out.print("Длина:");
        point2=scanner.nextInt();
        MovableRectangle movableRectangle=new MovableRectangle(point1,point2);

        System.out.print("Начальный x:");
        point1=scanner.nextInt();
        System.out.print("Начальный y:");
        point2=scanner.nextInt();
        movableRectangle.setLeftH(point1,point2);
        System.out.println("----");
        movableRectangle.getLeftH();movableRectangle.getRightB();
        System.out.println("----");

        System.out.print("Конечный x:");
        point1=scanner.nextInt();
        System.out.print("Конечный y:");
        point2=scanner.nextInt();
        movableRectangle.move(point1,point2);

        System.out.println("----");
        movableRectangle.getLeftH();movableRectangle.getRightB();
        System.out.println("----");
    }
}
