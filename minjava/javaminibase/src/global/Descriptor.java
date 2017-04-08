package global;

import java.text.DecimalFormat;

/**
 * Task 1 of project phase 2
 * @author acheruvu
 *
 */


public class Descriptor {
	
	int value[];
	
	Descriptor()
	{
		value=new int[5];
		value[0]=0;
		value[1]=0;
		value[2]=0;
		value[3]=0;
		value[4]=0;
		
	}
	
	public void setValue(int value1,int value2,int value3, int value4, int value5)
	{
		this.value[0]=value1;
		this.value[1]=value2;
		this.value[2]=value3;
		this.value[3]=value4;
		this.value[4]=value5;
		
	}
	
	
	public int getValue(int index)
	{
		return this.value[index];
	}
	
	public void setValue(Descriptor obj)
	{
		this.value=obj.value;
	}
	
	public boolean equal(Descriptor desc)
	{
		boolean status=true;
		
		for(int i=0; i<5;i++)
		{
			if(this.value[i]!=desc.value[i])
			{
				status=false;
				return status;
			}
		}
		return status;
		
	}
	
	
	
	public double distance (Descriptor desc)
	{
		double dis=0;
		for (int i=0; i<5;i++)
		{
			dis=dis+Math.pow(this.value[i]-desc.value[i],2);
			
		}
		dis=Math.sqrt(dis);
		DecimalFormat df=new DecimalFormat("#.00");
		String decimalvalue=df.format(dis);
		return Double.parseDouble(decimalvalue);
		
	
		
		
	}
	
	
	public static void main(String[] args)
	{
		Descriptor obj=new Descriptor();
		obj.setValue(1,1,1,1,1);
		Descriptor obj2=new Descriptor();
		obj2.setValue(2,2,2,2,2);
		
		System.out.println(obj2.distance(obj));
		
	}
	
	
	

}
