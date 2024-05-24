package Backtracking;

import java.util.ArrayList;

public class MazeProblem {
    static ArrayList <String> al = new ArrayList<>();
    static int ratInMaze(int[][] maze) {
        return ratInMaze(maze, 0, 0, "");
    }
    static int ratInMaze(int[][] maze, int r, int c, String path){
        if(maze[r][c] == 1) return 0;
        if(r == maze.length - 1 && c == maze[0].length - 1){
            al.add(path);
//            System.out.println(path);
            return 1;
        }
        int right = 0, down = 0;
        if(c < maze[0].length - 1) right = ratInMaze(maze, r, c + 1, path + "R");
        if(r < maze.length - 1) down = ratInMaze(maze, r + 1, c, path + "D");
        return right + down;
    }
    public static void main(String[] args) {
        int [][] maze= {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int ans = ratInMaze(maze);
        System.out.println("total possible ways are: " + ans);
//        System.out.println(al);
    }
}
