import java.lang.*; 
public class consumerOne
{
  int id; //id number of animal
  int expresionOne; //expresion towards food source 1
  int expresionTwo; //expresion towards food source 2
  int hunger; //turns since eating last
      
    
  public consumerOne(int ident, int expOne, int expTwo, int hangry) //full entry
  {
    id = ident;
    expresionOne=expOne;
    expresionTwo=expTwo;
    hunger=hangry;
    
  }
  
  public consumerOne(int expOne, int expTwo, int hangry) //standard id, manual entry for rest
  {
    id = Global.c1id;
    Global.c1id++;
    expresionOne=expOne;
    expresionTwo=expTwo;
    hunger=hangry;
    
  }
  
   public consumerOne() //brand new consumerOne obj
  {
    id = Global.c1id;
    Global.c1id++;
    expresionOne=4;
    expresionTwo=4;
    hunger=0;
    
  }
//   public consumerOne()
//   {
//       this(Global.c1id +1, 0,0,0);
//   }           
   //get methods
   public int getId() {return id;}
   
   public int getExpresionOne() {return expresionOne;}
   
   public int getExpresionTwo() {return expresionTwo;}
   
   public int getHunger() {return hunger;}
   
   //set methods
   public void setId(int a) {id =a;}
   
   public void setExpresionOne(int a) {expresionOne =a ;}
   
   public void setExpresionTwo(int a) {expresionTwo =a ;}
   
   public void setHunger(int a) {hunger  =a;}
   
   //Other methods
   
   public void incrementHunger() {hunger++;}
   
   public void incrementExp(int gene, int amount) // alows for negative and positive incrementing
   {
       switch(gene)
       {
           case 1:
               if(expresionOne > 0 && expresionOne < 8)
               {expresionOne= expresionOne + amount;}
               break;
           case 2:
               if(expresionTwo > 0  && expresionTwo < 8)
               {expresionTwo= expresionTwo + amount;}
               break;
           default: 
               break;
        }
   }
  public String toString()
  {
    String result;
    
    result = id + "\t" + expresionOne + "\t" + expresionTwo + "\t" + hunger; 

    return result;
  }
       

   }
           
   