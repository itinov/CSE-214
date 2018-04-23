package ExtraCredit;


import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.HashSet;

/* Main Class */
public class AdjacentShortestPath {
	
	// instance variables
	public static int[][] adjacentMatrix;
	public static int[] list;
	public static int[] parentNodes; // parent of each distant list
	
	/* Main Method */
	public static void main(String[] args) {
		/* source location of in1.txt, make sure to change the location of the file to where it is located on your computer */
		File file = new File("C:\\Users\\tinov\\workspace\\CSE 214\\src\\ExtraCredit\\in1.txt");
		try {
			Scanner input = new Scanner(file);
			int testCases = Integer.parseInt(input.nextLine()); 	      // number of test cases desired
			for (int i = 0; i < testCases; i++) {
				int numVertices = Integer.parseInt(input.nextLine());     // number of vertices
				int sourceIndex = input.nextInt();                        // starting index
				int endIndex = Integer.parseInt(input.nextLine().trim()); // ending index

				initializeVariables(numVertices); 					      // function call to initialize variables
				for (int j = 0; j < numVertices; j++) {
					String[] unStr = input.nextLine().split(" ");
					for (int k = 0; k < unStr.length; k++) {              // convert String to Int
						adjacentMatrix[j][k] = Integer.parseInt(unStr[k]);
					}
				}

				/* Running Dijkstra's Algorithm */
				findShortestRouteFromRoot(sourceIndex);
				System.out.println(list[endIndex]); // print the shortest distance to end node

			
				LinkedList<Integer> route = new LinkedList<Integer>();
				// using the distance parent array to find the path traveled
				route.add(endIndex);
				int currentNodeIndex = endIndex;
				int currentParentNodeIndex = parentNodes[currentNodeIndex];
				while (currentParentNodeIndex != sourceIndex) {
					route.addFirst(currentParentNodeIndex);
					currentNodeIndex = currentParentNodeIndex;
					currentParentNodeIndex = parentNodes[currentNodeIndex];
				}
				
				/* Using an interator to print the route desired */
				ListIterator<Integer> printRoute = route.listIterator();
				String str = sourceIndex + " -> ";
				while (printRoute.hasNext()) {
					str += printRoute.next() + " -> ";
				}
				System.out.println(str.substring(0, str.length() - 4)); // print the route in console
			}
		}
		// catch exception if file not found
		catch (Exception e) {
			System.out.println("Sorry, the given file is not found.");
		}
	}

	/* method for initializing the variables of the algorithm*/
	public static void initializeVariables(int num) {
		adjacentMatrix = new int[num][num];
		list = new int[num];
		for (int i = 0; i < num; i++) {
			list[i] = Integer.MAX_VALUE;
		}
		parentNodes = new int[num];
	}

	/* findShortestRouteFromRoot method using the Dijkstra's Algorithm */
	public static void findShortestRouteFromRoot(int root) {
		HashSet<Integer> node = new HashSet<Integer>();
		list[root] = 0;
		for (int i = 1; i < list.length; i++) {
			int link = findMinUnvisitedNodes(node);
			node.add(link);
			LinkedList<Integer> neighborNodes = findNeighborNodes(link);
			ListIterator<Integer> iterator = neighborNodes.listIterator(0);
			while (iterator.hasNext()) {
				int nodeIndex = iterator.next();
				if (!node.contains(nodeIndex)) {
					int oldList = list[nodeIndex];
					int newList = list[link] + adjacentMatrix[link][nodeIndex];
					if (newList < oldList) {
						list[nodeIndex] = newList; 			// replace old list with the new list in distance list
						parentNodes[nodeIndex] = link;      // replace the parent node
					}
				}
			}
		}
		return;
	}
	
	/* findNeighborNodes helper method to find the number of nodes that are around the current node */
	public static LinkedList<Integer> findNeighborNodes(int root) {
		LinkedList<Integer> neighborNodes = new LinkedList<Integer>();
		for (int i = 0; i < adjacentMatrix[0].length; i++) {
			if (adjacentMatrix[root][i] > 0)
				neighborNodes.add(i);
		}
		return neighborNodes;
	}
	/* findMinUnvisitedNodes helper method to obtain the number of nodes that have not yet been visted */
	public static int findMinUnvisitedNodes(HashSet<Integer> node) {
		int minIndex = -1; 
		int min = Integer.MAX_VALUE; // set min to max val initially
		for (int i = 0; i < list.length; i++) {
			if (list[i] < min && !node.contains(i)) {
				min = list[i];
				minIndex = i;
			}
		}
		return minIndex;
	}
}
