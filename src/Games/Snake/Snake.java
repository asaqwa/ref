package Games.Snake;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private List<SnakeSection> sections;
    private boolean isAlive;
    private SnakeDirection direction;

    public Snake(int x, int y) {
        sections = new ArrayList<>();
        sections.add(new SnakeSection(x, y));
        isAlive = true;
    }

    void checkBorders(SnakeSection head) {
        if (head.getX() < 0 || head.getX() >= Room.game.getWidth()) isAlive = false;
        else if (head.getY() < 0 || head.getY() >= Room.game.getHeight()) isAlive = false;
    }

    void checkBody(SnakeSection head) {
        for (SnakeSection section: sections) {
            if (head.equals(section)) {
                isAlive = false;
                break;
            }
        }
    }

    public void move() {
        if (isAlive) {
            switch (direction) {
                case UP: move(0, -1);
                break;
                case RIGHT: move (1, 0);
                break;
                case DOWN: move(0, 1);
                break;
                case LEFT: move(-1, 0);
                break;
            }
        }
    }

    void move(int x, int y) {
        SnakeSection head = new SnakeSection(sections.get(0).getX() + x, sections.get(0).getY() + y);
        checkBody(head);
        checkBorders(head);
        if (!isAlive) return;
        sections.add(0, head);
        Mouse mouse = Room.game.getMouse();
        if (mouse.getX() == head.getX() && mouse.getY() == head.getY()) {
            Room.game.eatMouse();
        }
        else sections.remove(sections.size() - 1);
    }

    public int getX() {
        return sections.get(0).getX();
    }
    public int getY() {
        return sections.get(0).getY();

    }

    public List<SnakeSection> getSections() {
        return sections;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public SnakeDirection getDirection() {
        return direction;
    }

    public void setDirection(SnakeDirection direction) {
        this.direction = direction;
    }
}
