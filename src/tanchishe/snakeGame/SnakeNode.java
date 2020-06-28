package snakeGame;
/*
 * ����һ���࣬��������̰������Ϸ�е��ߣ������ϵ�ÿһ���㣬ͨ������snakeNode�Ķ���ָ����ͬ��X���Y���ֵ���������һ������
 * ͬʱ���Ի�������ϵ�x��y�����꣬����ɫ
 */
import java.awt.Color;

public class SnakeNode {    //�����������еĸ���Ԫ�ص㣬x��y���Լ���ɫ�����ߵĹؼ����
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