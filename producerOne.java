public class producerOne
{
  int count; //counter of how much food is aviable (lowest value is zero)
  int growth; //amount food regenerates (can be negative)
  int rate; //how often the gowth is incremented. 


public producerOne(int cnt,int grwth,int rte)
{
  count = cnt;
  growth = grwth;
  rate= rte;
}

public producerOne()
{
  count =100;
  growth=1;
  rate=1;
}

//getters
public int getCount() {return count;}

public int getGrowth() {return growth;}

public int getRate() {return rate;}
//setters
public void setCount(int a) 
{
  if(a <0) {count =0;} //found cant be less than zero
  else {count = a;}
}

public void setGrowth(int a) {growth =a;}

public void setRate(int a) {rate =a;}
//manipulators
public void decrementCount()  
{
  if(count<=0) {count =0;}
  else {count--;}
}

public void decrementCount(int a) //decrement by a set amount
{
  if(count<=0) //count less than zero return it to zero
  {count =0;}
  
  if(count -a >= 0) //prevents negative food count 
  {count=count-a;}
  
  else {count = count +0;} //do nothing case
  
  
}


                          
}
