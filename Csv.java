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
	
	Contact()
	{
		
	}
	
	
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

	private static ArrayList<Contact> readCSV(String filename)
	{
		ArrayList<Contact> contacts=new ArrayList<Contact>();
		
		int count=0;
		
		int max=0;
		int min=0;
		
		Contact max_ct= new Contact();
		Contact min_ct= new Contact();
		
		
		FileReader fr;
		try {
		fr= new FileReader(filename);
		BufferedReader br= new BufferedReader(fr);
		
		String line="";
		System.out.println("The Data in the File are");
		System.out.println("------------------------------");
		while((line=br.readLine())!=null)
			{

				System.out.println(line);
				
				String[] items= line.split(",");
				Contact ct= new Contact(items[0], items[1], items[2]);
				String phone= ct.getPhone();
				String[] numbers=phone.split("");
				int sum=0;
				
				for(String number:numbers)
				{
					int n=Integer.parseInt(number);
					sum+=n;
				}
				
				
				if(count==0)
				{
					max=sum;
					min=sum;
					min_ct=ct;
					max_ct=ct;
					
				}
				else {
					if(sum>max)
					{
						max=sum;
						max_ct=ct;
					}
					if(sum<min)
					{
						min=sum;
						min_ct=ct;
					}
				}
				++count;
				
			}
		System.out.println();
		System.out.println("------------------------------");
		System.out.printf("Max number %s is with %s and Email is %s\n",max_ct.getPhone(),max_ct.getName(),max_ct.getEmail());
		System.out.printf("Min number %s is with %s and Email is %s",min_ct.getPhone(),min_ct.getName(),min_ct.getEmail());
		
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
		return contacts;
		
	}
	public static void main(String[] args) {

		ArrayList<Contact> contactList= new ArrayList<Contact>();
		contactList.add(new Contact("ram","ram@gmail.com","9847870251"));
		contactList.add(new Contact("syam","syam@gmail.com","9847870252"));
		contactList.add(new Contact("gita","gita@gmail.com","9847870253"));
		contactList.add(new Contact("sita","sita@gmail.com","9847870254"));
		contactList.add(new Contact("prerana","prerana@gmail.com","9847870255"));
		
		writeToCsv(contactList,"Deep.csv");

		readCSV("Deep.csv");
	}

}
