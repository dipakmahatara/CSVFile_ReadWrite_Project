package mini_project;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;

class Contact
{
	private String name;
	private String email;
	private String phone;
	
	public Contact(String name,String email,String phone)
	{
		this.name=name;
		this.email=email;
		this.phone=phone;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public String getEmail()
	{
		return this.email;
	}
	
	public String getPhone()
	{
		return this.phone;
	}
	
}

public class Csv {
	
	private static void writeToCsv(ArrayList<Contact> list,String filename)
	{
		try {
			
			FileOutputStream fos= new FileOutputStream(filename);
			OutputStreamWriter osw= new OutputStreamWriter(fos, "UTF-8");
			BufferedWriter bw= new BufferedWriter(osw);
			
			for(Contact contact: list)
			{
				StringBuffer oneLine= new StringBuffer();
				String name= contact.getName();
				String email= contact.getEmail();
				String phone= contact.getPhone();
				
				oneLine.append(name);
				oneLine.append(",");
				oneLine.append(email);
				oneLine.append(",");
				oneLine.append(phone);
				bw.write(oneLine.toString());
				bw.newLine();
			}
			
			bw.flush();
			bw.close();
			
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		ArrayList<Contact> contactList= new ArrayList<Contact>();
		
		/*
		 Contact ct1= new Contact("Ram","syys","1223");
		 contactList.add(ct1)
		 Yesai gari 5 ota gareni hunx
		 * */
		contactList.add(new Contact("ram","ram@gmail.com","9847870251"));
		contactList.add(new Contact("syam","syam@gmail.com","9847870252"));
		contactList.add(new Contact("gita","gita@gmail.com","9847870253"));
		contactList.add(new Contact("sita","sita@gmail.com","9847870254"));
		contactList.add(new Contact("prerana","prerana@gmail.com","9847870255"));
		
		writeToCsv(contactList,"C:\\Users\\DELL\\Desktop\\Deep.csv");

	}

}
