public class GridPath {
    private int[][] grid;
    public GridPath(int[][] values) {
        grid = values;
}
    public Location getNextLoc(int row, int col) {
        
        int below = Integer.MAX_VALUE;
        if(row<grid.length -1) below = grid[row+1][col]; 
        int right = Integer.MAX_VALUE;
        if(col<grid[0].length -1) right = grid[row][col+1]; 
        if (below<right) return new Location(row+1, col);
        else return new Location (row, col +1);
        

    }
    public int sumPath(int row, int col) {
        int sum = grid[row][col];
        while (row <grid.length-1 || col < grid[0].length-1) {
            Location loc = getNextLoc(row, col);
            row = loc.getRow();
            col = loc.getCol();
            sum += grid[row][col];
        }
        return sum;

    }
    public String toString()
    {
        String s = "";
        for (int row = 0; row < grid.length; row++) 
        {
            for (int col = 0; col < grid[0].length; col++)
            {
                s+= grid[row][col] + " ";
            }
            s += "\n";
        }
        return s;
    }
}