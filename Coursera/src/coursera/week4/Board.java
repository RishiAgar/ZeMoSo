
package coursera.week4;

import java.util.*;

public class Board
{
    public int dimension;
    public int[][] tiles;
    public int hamming = -1;
    public int manhattan = -1;
    public Board(int[][] blocks)
    {
        this.dimension = blocks.length;
        this.tiles = copyTiles(blocks, dimension);
    }
    public int dimension()
    {
        return dimension;
    }
    public int hamming()
    {
        if (hamming < 0)
        {
            for (int i = 0; i < dimension; i++)
                for (int j = 0; j < dimension; j++)
                    if (tiles[i][j] != 0 && !tileAtRightSpot(i, j))
                        hamming++;
            if (hamming < 0)
                hamming = 0;
            else
                hamming++;
        }
        return hamming;
    }
    public int manhattan()
    {
        if (manhattan < 0)
        {
            for (int i = 0; i < dimension; i++)
                for (int j = 0; j < dimension; j++)
                    if (tiles[i][j] != 0 && !tileAtRightSpot(i, j))
                    {
                        int neededRow = (tiles[i][j] - 1) / dimension;
                        manhattan += Math.abs(tiles[i][j] - neededRow * dimension - 1 - j) + Math.abs(neededRow - i);
                    }
            if (manhattan < 0)
                manhattan = 0;
            else
                manhattan++;
        }
        return manhattan;
    }
    public boolean isGoal()
    {
        for (int i = 0; i < dimension; i++)
            for (int j = 0; j < dimension; j++)
                if (!tileAtRightSpot(i, j))
                    return false;
        return true;
    }
    public Board twin()
    {
        for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
            {
                if (tiles[i][j] != 0 && j < (dimension - 1) && tiles[i][j + 1] != 0)
                {
                    int[][] newTiles = copyTiles(tiles, dimension);
                    int exchangeTile = newTiles[i][j];
                    newTiles[i][j] = newTiles[i][j + 1];
                    newTiles[i][j + 1] = exchangeTile;
                    return new Board(newTiles);
                }
            }
        }
        throw new IllegalStateException("Impossible to twin the Board " + toString());
    }
    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Board other = (Board) obj;
        if (dimension != other.dimension)
            return false;
        if (!Arrays.deepEquals(tiles, other.tiles))
            return false;
        return true;
    }
    public Iterable<Board> neighbors()
    {
        int i, j=0, exchangedTile;
        for (i = 0; i < dimension; i++)
        {
            boolean foundZero = false;
            for (j = 0; j < dimension; j++)
                if (tiles[i][j] == 0)
                {
                    foundZero = true;
                    break;
                }
            if (foundZero)
                break;
        }
        Set<Board> neighbors = new HashSet<Board>();
	int[][] newTiles = copyTiles(tiles, dimension);
	exchangedTile = -1;
        if (i > 0)
        {
            exchangedTile = newTiles[i - 1][j];
            newTiles[i][j] = exchangedTile;
            newTiles[i - 1][j] = 0;
            neighbors.add(new Board(newTiles));
            newTiles[i - 1][j] = exchangedTile;
            newTiles[i][j] = 0;
        }
        if (j > 0)
        {
            exchangedTile = newTiles[i][j - 1];
            newTiles[i][j] = exchangedTile;
            newTiles[i][j - 1] = 0;
            neighbors.add(new Board(newTiles));
            newTiles[i][j - 1] = exchangedTile;
            newTiles[i][j] = 0;
        }
        if (j < (dimension - 1))
        {
            exchangedTile = newTiles[i][j + 1];
            newTiles[i][j] = exchangedTile;
            newTiles[i][j + 1] = 0;
            neighbors.add(new Board(newTiles));
            newTiles[i][j + 1] = exchangedTile;
            newTiles[i][j] = 0;
        }
        if (i < (dimension - 1))
        {
            exchangedTile = newTiles[i + 1][j];
            newTiles[i][j] = exchangedTile;
            newTiles[i + 1][j] = 0;
            neighbors.add(new Board(newTiles));
            newTiles[i + 1][j] = exchangedTile;
            newTiles[i][j] = 0;
        }
        return neighbors;
    }
    @Override
    public String toString()
    {
        StringBuilder s = new StringBuilder();
	s.append(dimension + "\n");
	for (int i = 0; i < dimension; i++)
        {
            for (int j = 0; j < dimension; j++)
                s.append(String.format("%2d ", tiles[i][j]));
            s.append("\n");
        }
        return s.toString();
    }
    public boolean tileAtRightSpot(int row, int col)
    {
        int tileValue = tiles[row][col];
        if (tileValue == 0)
            return row == dimension - 1 && col == dimension - 1;
        else
            return tileValue == row * dimension + col + 1;
    }
    public static int[][] copyTiles(int[][] tilesOriginal, int dimension)
    {
        int[][] newTiles = new int[dimension][dimension];
	for (int i = 0; i < dimension; i++)
            newTiles[i] = Arrays.copyOf(tilesOriginal[i], dimension);
        return newTiles;
    }
}