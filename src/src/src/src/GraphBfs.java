package src.src;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
Question:
* You're given a 2D matrix/grid with:

A start and end cell.
Some blockers (cells you cannot pass through).
Some portals—each portal is defined in pairs (e.g., P1 has two positions; stepping on one lets you optionally teleport to the other).

You can:
Move in 4 directions (up/down/left/right), assuming they’re valid moves.
Choose to use a portal or ignore it.
You need to find the shortest path from start to end, taking teleportation and blockages into account.
* */

// 16:54 - 17:20 - 17:31 - 37min
public class GraphBfs
{
    private boolean visited[][];
    private record Node(Position position, int distance){}

    private record Position(int x, int y) {
        public boolean isValid(int[][] grid) {
            return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] != 1;
        }
    }

    public int shortestPath(int[][] grid, int[] start, int[] end, Map<int[],int[]> portals)
    {
        int n = grid.length;
        int m = grid[0].length;
        visited = new boolean[n][m];
        Position startPos = new Position(start[0], start[1]);
        Position endPos = new Position(end[0], end[1]);

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startPos, 0));
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            int x = curr.position().x();
            int y = curr.position().y();
            int distance = curr.distance();

            if(curr.position().equals(endPos)) return curr.distance();

            if(!curr.position().isValid(grid) || visited[x][y]) continue;

            int[] temp = {x, y};
            if(portals.containsKey(temp))
            {
                int ported[] = portals.get(temp);
                Position newPos = new Position(ported[0], ported[1]);
                if(newPos.isValid(grid) && !visited[ported[0]][ported[1]])
                {
                    visited[ported[0]][ported[1]] = true;
                    queue.offer(new Node(newPos, distance));
                }
            }
            // Explore all 4 directions
            int dx[] = {-1, 1, 0, 0};
            int dy[] = {0, 0, -1, 1};
            for(int i = 0; i < 4; i++)
            {
                int newX = x + dx[i];
                int newY = y + dy[i];
                Position newPos = new Position(newX, newY);
                if(newPos.isValid(grid) && !visited[newX][newY])
                {
                    visited[newX][newY] = true;
                    queue.offer(new Node(new Position(newX, newY), distance + 1));
                }
            }
        }
        return -1;
    }
}
