import java.util.*;
import java.io.*;
public class Employee
{
	
	public static void main(String[] args)
	{
		System.out.println("how many employess : ");
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		employees[] emp = new employees[n];
		for(int i=0;i<n;i++)
			{   String name;
				int salary,id;
				System.out.print(" name : ");
				name = scan.nextLine();
                name = scan.nextLine();
                System.out.print("salary : ");
                salary = scan.nextInt();
                System.out.print("id : ");
                id = scan.nextInt();
              emp[i] = new employees(name,salary,id);
			}
			for(int i=0;i<n;i++)
			emp[i].show();

        
}
	}
	class employees
	{   private int employeesalary,employeeid;
		private String employeename;
		public employees(String name,int salary,int id)
		{
			employeename=name;
			employeesalary=salary;
			employeeid = id;
		}
		public void show(){
			System.out.println("employee name is "+ employeename);
			System.out.println("employee salary is "+ employeesalary);
			System.out.println(" employee id is "+ employeesalary);
		} 


	}