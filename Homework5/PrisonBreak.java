package Homework5;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/* Main Class */
public class PrisonBreak {

	/* Sub-class Scanner */
	static class Scanner  {
		
		// variables 
		final private int constraint = 1 << 20;
		private DataInputStream inStream;
		private byte[] buffer;
		private int bufferPointer;
		private int scanByte;

		/* Scanner Class Default-Constructor */
		public Scanner () {
			inStream = new DataInputStream(System.in);
			buffer = new byte[constraint];
			bufferPointer = scanByte = 0;
		}
		
		/* Scanner Class Custom-Constructor */
		public Scanner (File file) throws IOException {
			inStream = new DataInputStream(new FileInputStream(file));
			buffer = new byte[constraint];
			bufferPointer = scanByte = 0;
		}

		/* scanLine method that reads a line of code */
		public String scanLine() throws IOException {
			byte[] buffer = new byte[64]; // line length
			int counter = 0;
			int b;
			while ((b = read()) != -1) {
				if (b == '\n')
					break;
				buffer[counter++] = (byte) b;
			}
			return new String(buffer, 0, counter);
		}

		/* scanInt method to scan the integer values inputted */
		public int scanInt() throws IOException {
			int result = 0;
			byte b = read();
			while (b <= ' ')
				b = read();
			boolean neg = (b == '-');
			if (neg)
				b = read();
			do {
				result = result * 10 + b - '0';
			} while ((b = read()) >= '0' && b <= '9');

			if (neg)
				return -result;
			return result;
		}

		/* fillBuffer method */
		public void fillbufferer() throws IOException {
			scanByte = inStream.read(buffer, bufferPointer = 0, constraint);
			if (scanByte == -1)
				buffer[0] = -1;
		}

		/* read method */
		public byte read() throws IOException {
			if (bufferPointer == scanByte)
				fillbufferer();
			return buffer[bufferPointer++];
		}
	}
	
	/* Main Method */
	public static void main(String args[]) throws Exception {

		// take scanner input
		Scanner input = new Scanner(new File("C:\\Users\\tinov\\workspace\\CSE 214\\src\\Homework5\\in1.txt")); // make sure to edit the location of this file to wherever you placed it on your computer
		int in = input.scanInt(); // number of files tested

		// for-loop to take input
		for (int i = 0; i < in; i++) {
			int nums = input.scanInt();
			int[][] list = new int[nums + 1][nums + 1];
			boolean[][] list2 = new boolean[nums + 1][nums + 1];
			for (int j = 1; j <= nums; j++)
				for (int k = 1; k <= nums; k++) {
					list[j][k] = input.scanInt();
				}
			if (list[1][1] == 1 && list[nums][nums] == 1)
				System.out.println(0);
			else {
				int counter = takeCount(1, 1, list, list2);
				System.out.println(counter);
			}
		}
	}

	/* takeCount method to find the total number of possible paths */
	public static int takeCount(int a, int b, int[][] list, boolean[][] list2) {
		if (a < 1 || b < 1 || a > list2.length - 1 || b > list2.length - 1)
			return 0;
		if (a == list2.length - 1 && b == list2.length - 1)
			return 1;
		if (list2[a][b] == true || (list[a][b] == 1 && (a != 1 || b != 1)))
			return 0;

		list2[a][b] = true;
		int a1 = takeCount(a - 1, b, list, list2);
		int a2 = takeCount(a + 1, b, list, list2);
		int a3 = takeCount(a, b - 1, list, list2);
		int a4 = takeCount(a, b + 1, list, list2);
		list2[a][b] = false;
		return a1 + a2 + a3 + a4;
	}
}
