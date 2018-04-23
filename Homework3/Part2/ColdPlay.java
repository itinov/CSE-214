package Homework3.Part2;

import java.util.Scanner;

/* Main Class */
public class ColdPlay {
		
	// variables
	private static final int maxRow = 1000;
	private static final int maxFan = 1000;
	private static final int maxSeat = 1000;

	/* Main Method */
	public static void main(String[] args) {
		/* variables for M and N */
		int M = 0; // number of seating rows in the stadium
		int N = 0; // number of ColdPlay fans waiting in line to get a ticket
		int[] freeSeats = null; // create array of the free seats
		Scanner input = new Scanner(System.in); // scanner
		boolean valid = false;
		while (!valid) {
			valid = true;
			System.out.println("Enter values for M and N: ");
			String line = input.nextLine();
			String[] tickets = line.split("\\s+");
			M = Integer.parseInt(tickets[0]);
			N = Integer.parseInt(tickets[1]);
			if (!(M >= 1 && M <= maxRow) || !(N >= 1 && N <= maxFan)) {
				System.out.println("M should be between 1 and " + maxRow);
				System.out.println("N should be between 1 and " + maxFan);
				valid = false;
				continue;
			}
			freeSeats = new int[M];
			System.out.println("Enter number of seats for " + M + " rows");
			line = input.nextLine();
			tickets = line.split("\\s+");
			if (tickets.length < M) {
				System.out.println("Enter free seats for " + M + " rows");
				continue;
			}
			int maxSeats = 0;
			for (int i = 0; i < M; i++) {
				freeSeats[i] = Integer.parseInt(tickets[i]);
				maxSeats += freeSeats[i];
				if (freeSeats[i] > maxSeat) {
					System.out.println("Max available seat per row is " + maxSeat);
					valid = false;
					continue;
				}
			}
			if (maxSeats <= N) {
				System.out.println("Maximum available seats should be a value bigger than N");
				valid = false;
				continue;
			}
		}
		/* Create a Max Priority queue to store the available seats. */
		PriorityQueue queue = new PriorityQueue();
		for (Integer i : freeSeats) {
			queue.enqueue(i); // enqueue the items
		}
			
		/*
		 * The max amount of each iteration is represented by the highest available seat that is
		 * left at the head of the queue.
		 * Delete this available seat and add it to totalAmount...
		 * Then Available seat of said row is decremented by one and then inserted again into queue.
		 */
		int totalAmount = 0;
		int next;
		for (int i = 0; i < N; i++) {
			next = queue.dequeue();
			totalAmount += next;
			queue.enqueue(next - 1);
		}
		/* Print the result. */
		System.out.println("Max amount = " + totalAmount);
	}
}
