package entities.minesweeper;

/**
 *
 * @author Federico MANCA
 */
public class Position implements Comparable<Position> {
    private int x;
    private int y;
    
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Position{");
        sb.append("x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Position other = (Position) obj;
        if (this.x != other.x) {
            return false;
        }
        return this.y == other.y;
    }

    @Override
    public int compareTo(Position other) {
        // Compare y values first
        int yComparison = Integer.compare(this.y, other.y);
        if (yComparison != 0) {
            // If y values are not equal, return the result
            return yComparison;
        }
        // If y values are equal, compare x values
        return Integer.compare(this.x, other.x);
    }
    
}
