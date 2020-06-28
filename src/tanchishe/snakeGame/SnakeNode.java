package snakeGame;
/*
 * 定义一个类，用来描述贪吃蛇游戏中的蛇，蛇身上的每一个点，通过建立snakeNode的对象，指定不同的X轴和Y轴的值，就能组成一个蛇身。
 * 同时可以获得蛇身上的x和y点坐标，和颜色
 */
import java.awt.Color;

public class SnakeNode {    //定义蛇身集合中的各个元素点，x，y。以及颜色三个蛇的关键组成
    private int x;
    private int y;
    private Color color;
	 
	public int setX=20;
	public int setY=20;
	 
    public SnakeNode() {
        super();

    }
    public SnakeNode(int x, int y, Color color) {
        super();
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}