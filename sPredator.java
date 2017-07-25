public class sPredator
{
  int id; //identification number
  int expresionOne; //expresion towards predator 1
  int expresionTwo; // expression towards predator 2
  int hunger; //turns since eating


public sPredator(int ident, int exp1, int exp2, int hangry) //full entry
{  
  id =ident;
  expresionOne = exp1;
  expresionTwo = exp2;
  hunger = hangry;
}

public sPredator(int exp1, int exp2, int hangry) //id updated rest manual
{
  
  id = Global.s1id;
  Global.s1id++;
  expresionOne = exp1;
  expresionTwo = exp2;
  hunger = hangry;
}

public sPredator() //new predatorOne obj 
{
  
  id = Global.s1id;
  Global.s1id++;
  expresionOne = 4;
  expresionTwo = 4;
  hunger = 0; 
}

   public int getId() {return id;}
   
   public int getExpresionOne() {return expresionOne;}
   
   public int getExpresionTwo() {return expresionTwo;}
   
   public int getHunger() {return hunger;}
   
   //set methods
   public void setId(int a) {id =a;}
   
   public void setExpresionOne(int a) {expresionOne =a ;}
   
   public void setExpresionTwo(int a) {expresionTwo =a ;}
   
   public void setHunger(int a) {hunger  =a;}
   
   //other
   public void incrementHunger() {hunger++;}
   
   public void incrementExp(int gene, int amount) // alows for negative and positive incrementing
   {
       switch(gene)
       {
           case 1:
               if(expresionOne >0 && expresionOne <8)
               {expresionOne= expresionOne + amount;}
               break;
           case 2:
               if(expresionTwo >0 && expresionTwo <8)
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