import javax.swing.JOptionPane;

public class Player {
    
    private int row;
    private int col;
    
    public int health;
    public int maxHealth;
    
    public Player(int row, int col) {
        this.row = row;
        this.col = col;
        
        this.maxHealth = 100;
        this.health = 100;
    }
    
    public int getRow() {
        return row;
    }
    public int getCol() {
        return col;
    }
    
    public void setRow(int row) {
        this.row = row;
    }
    public void setCol(int col) {
        this.col = col;
    }
    
    public void removeHealth(int health) {
        this.health -= health;
        if (this.health <= 0 && !ComprehensiveExercise.invisible) {
            JOptionPane.showMessageDialog(null, "Game Over", "You Died", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public void attack(Enemy e) {
        e.removeHealth(10);
    }
}