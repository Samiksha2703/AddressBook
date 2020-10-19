package com.addressbook;

import java.util.ArrayList;
import java.util.Scanner;

public class AddressBook {

	public int number;
	public int serialnumber;
	public int id;
	public String name;
	public String city;
	public String address;
	public long phone;
	public int zipcode;

	public int startindex = 0;

	public ArrayList<Integer> id_arraylist = new ArrayList<>();
	public ArrayList<String> name_arraylist = new ArrayList<>();
	public ArrayList<String> city_arraylist = new ArrayList<>();
	public ArrayList<String> address_arraylist = new ArrayList<>();
	public ArrayList<Long> phone_arraylist = new ArrayList<>();
	public ArrayList<Integer> zipcode_arraylist = new ArrayList<>();

	public static final Scanner sc = new Scanner(System.in);

	public void add() {

		System.out.println("Enter the number of person you want to add");

		number = sc.nextInt() + startindex;

		for (int i = startindex; i < number; i++) {

			System.out.println("Enter the Id : ");

			id = sc.nextInt();

			id_arraylist.add(id);

			System.out.println("Enter the Name : ");

			name = sc.next();

			name_arraylist.add(name);

			System.out.println("Enter the City : ");

			city = sc.next();

			city_arraylist.add(city);

			System.out.println("Enter the Address : ");

			address = sc.next();

			address_arraylist.add(address);

			System.out.println("Enter the 10 Contact Number ");

			phone = sc.nextLong();

			phone_arraylist.add(phone);

			System.out.println("Enter the zip code (ex-123698) : ");

			zipcode = sc.nextInt();

			zipcode_arraylist.add(zipcode);
		}

		int input1 = 1, input3;

		while (input1 == 1) {

			check();

			System.out.println("To continue press 1 else press 0");

			input3 = sc.nextInt();

			input1 = input3;
		}

		System.out.println("Thank you!");

	}

	public void check() {

		System.out.println("Enter 1-Display, 2-Delete, 3-Update, 4-SortbyZipcode 5-continue adding");

		int choice = sc.nextInt();

		if (choice == 1) {

			display();

		} else if (choice == 2) {

			delete();

		} else if (choice == 3) {

			update();
		}

		else if (choice == 4) {

			sortbyZipcode();
		}

		else if (choice == 5) {

			startindex = number;

			add();
		}
	}

	public void display() {

		for (int i = 0; i < id_arraylist.size(); i++) {

			serialnumber = (i + 1);

			System.out.println(serialnumber + ".  " + id_arraylist.get(i) + "  " + name_arraylist.get(i) + "  "
					+ city_arraylist.get(i) + "  " + address_arraylist.get(i) + "  " + phone_arraylist.get(i) + "  "
					+ zipcode_arraylist.get(i));
		}
	}

	public void delete() {

		System.out.println("Enter the serial number of entry you want to delete");

		int delete_index = sc.nextInt();

		delete_index--;

		id_arraylist.remove(delete_index);

		name_arraylist.remove(delete_index);

		city_arraylist.remove(delete_index);

		address_arraylist.remove(delete_index);

		phone_arraylist.remove(delete_index);

		zipcode_arraylist.remove(delete_index);

	}

	public void update() {

		System.out.println("Enter the serial number of entry you want to update");

		int index = sc.nextInt();

		index--;

		System.out.println("Enter the Id : ");

		id = sc.nextInt();

		id_arraylist.set(index, id);

		System.out.println("Enter the Name : ");

		name = sc.next();

		name_arraylist.set(index, name);

		System.out.println("Enter the City : ");

		city = sc.next();

		city_arraylist.set(index, city);

		System.out.println("Enter the Address : ");

		address = sc.next();

		address_arraylist.set(index, address);

		System.out.println("Enter the Contact Number(Phone/Mobile) (ex-919830567480): ");

		phone = sc.nextLong();

		phone_arraylist.set(index, phone);

		System.out.println("Enter the zip code (ex-123698) : ");

		zipcode = sc.nextInt();

		zipcode_arraylist.set(index, zipcode);

	}

	public void sortbyZipcode() {

		int integer;
		String string;
		long phonenumber;

		int length = id_arraylist.size();

		for (int i = 0; i < (length - 1); i++) {

			int j = i + 1;

			if (zipcode_arraylist.get(i) > zipcode_arraylist.get(j)) {

				integer = zipcode_arraylist.get(i);
				zipcode_arraylist.set(i, zipcode_arraylist.get(j));
				zipcode_arraylist.set(j, integer);

				integer = id_arraylist.get(i);
				id_arraylist.set(i, id_arraylist.get(j));
				id_arraylist.set(j, integer);

				string = name_arraylist.get(i);
				name_arraylist.set(i, name_arraylist.get(j));
				name_arraylist.set(j, string);

				string = city_arraylist.get(i);
				city_arraylist.set(i, city_arraylist.get(j));
				city_arraylist.set(j, string);

				string = address_arraylist.get(i);
				address_arraylist.set(i, address_arraylist.get(j));
				address_arraylist.set(j, string);

				phonenumber = phone_arraylist.get(i);
				phone_arraylist.set(i, phone_arraylist.get(j));
				phone_arraylist.set(j, phonenumber);
			}
		}
	}

	public static void main(String[] args) {

		System.out.println("Welcome to Address Book");

		AddressBook customArrayList = new AddressBook();

		customArrayList.add();

	}

}
