package kr.ac.sejong.kmooc.data_engineering.arraylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

import kr.ac.sejong.kmooc.data_engineering.motivation.Email;

public class ArrayListExample21 {

	public static ArrayList<Email> getData() throws IOException {
		ArrayList<Email> data = new ArrayList<Email>();
		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Sejong\\DE\\email.txt"));
		while (true) {
			String line = br.readLine();
			if (line == null)
				break;
			if (line.startsWith("#"))
				continue;

			String[] array = line.split("\t");
			int from = Integer.parseInt(array[0]);
			int to = Integer.parseInt(array[1]);
			data.add(new Email(from, to));
		}
		br.close();
		return data;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<Email> data = getData();

		data.sort(new Comparator<Email>() {
			@Override
			public int compare(Email o1, Email o2) {
				if (o1.getTo() < o2.getTo())
					return +2;
				else if (o1.getTo() == o2.getTo())
					return 0;
				else
					return -2;
			}
		});

		ListIterator<Email> listIterator = data.listIterator(data.size());
		while (listIterator.hasPrevious()) {
			System.out.println(listIterator.previous());
		}
	}
}
