package com.kurshit.graphs.codencode.cp3book.section42;

import java.util.Scanner;

public class MutantFlatworldExplorers {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			int T = sc.nextInt();

			int M = sc.nextInt();
			int N = sc.nextInt();
			int[][] grid = new int[M+1][N+1];
			while(T-- > 0) {

				int X = sc.nextInt();
				int Y = sc.nextInt();
				char D = sc.next().charAt(0);
				String ins = sc.next();
				solve(grid, M, N, X, Y, D, ins);


			}

		} catch(Exception e ) {
			e.printStackTrace();
		} finally {
			sc.close();
		}		

	}

	public static void solve(int[][] grid, int M, int N, int X, int Y, char D, String ins) {
		boolean isLost = false;
		
		for(int i=0; i < ins.length(); i++) {

			char curr = ins.charAt(i);

			if(curr != 'F') {
				
				switch(D) {

				case 'N':

					if(curr == 'L') {
						D = 'W';						
					} else {
						D = 'E';
					}

					break;

				case 'E' :

					if(curr == 'L') {
						D = 'N';						
					} else {
						D = 'S';
					}

					break;

				case 'S' :

					if(curr == 'L') {
						D = 'E';						
					} else {
						D = 'W';
					}
					break;

				case 'W' :

					if(curr == 'L') {
						D = 'S';						
					} else {
						D = 'N';
					}
					break;					
				}

			} else {
				
				if(grid[X][Y] == 1) {
					
					if(D == 'N') {
						Y = Y+1;
					} else if(D == 'E') {
						X = X + 1;
					} else if(D == 'S') {
						Y = Y - 1;
					} else if(D == 'W') {
						X = X - 1;
					}
					
					if(isSafe(X, Y, M , N)) {
						continue;
					} else {
						if(D == 'N') {
							Y = Y-1;
						} else if(D == 'E') {
							X = X - 1;
						} else if(D == 'S') {
							Y = Y + 1;
						} else if(D == 'W') {
							X = X + 1;
						}
					}
					
				} else {
					
					if(D == 'N') {
						Y = Y+1;
					} else if(D == 'E') {
						X = X + 1;
					} else if(D == 'S') {
						Y = Y - 1;
					} else if(D == 'W') {
						X = X - 1;
					}
					
					if(!isSafe(X, Y, M , N)) {
						
						if(D == 'N') {
							Y = Y-1;
						} else if(D == 'E') {
							X = X - 1;
						} else if(D == 'S') {
							Y = Y + 1;
						} else if(D == 'W') {
							X = X + 1;
						}
						isLost = true;
						grid[X][Y] = 1;
						break;
					}
				}
				
				
				
			}		

		}
		
		System.out.println(X + " " + Y + " " + D + " " + (isLost ? "LOST" : ""));

	}

	private static boolean isSafe(int X, int Y, int M, int N ) {
		
		if(X < 0 || Y < 0 || X > M || Y > N) {
			return false;
		}
		
		return true;
		
	}

}
