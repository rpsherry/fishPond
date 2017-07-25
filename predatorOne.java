public class predatorOne
{
  int id; //identification number
  int expresionOne; //expresion towards cosumer 1
  int expresionTwo; // expression towards consumer 2
  int expresionThree; //expresion towards consumer 3
  int hunger; //turns since eating


public predatorOne(int ident, int exp1, int exp2, int exp3, int hangry) //full entry
{  
  id =ident;
  expresionOne = exp1;
  expresionTwo = exp2;
  expresionThree = exp3;
  hunger = hangry;
}

public predatorOne(int exp1, int exp2, int exp3, int hangry) //id updated rest manual
{
  
  id = Global.p1id;
  Global.p1id++;
  expresionOne = exp1;
  expresionTwo = exp2;
  expresionThree = exp3;
  hunger = hangry;
}

public predatorOne() //new predatorOne obj 
{
  
  id = Global.p1id;
  Global.p1id++;
  expresionOne = 4;
  expresionTwo = 4;
  expresionThree = 4;
  hunger = 0; 
}

   public int getId() {return id;}
   
   public int getExpresionOne() {return expresionOne;}
   
   public int getExpresionTwo() {return expresionTwo;}
   
   public int getExpresionThree() {return expresionThree;}
   
   public int getHunger() {return hunger;}
   
   //set methods
   public void setId(int a) {id =a;}
   
   public void setExpresionOne(int a) {expresionOne =a ;}
   
   public void setExpresionTwo(int a) {expresionTwo =a ;}
   
   public void setExpresionThree(int a) {expresionThree =a ;}
   
   public void setHunger(int a) {hunger  =a;}
   
   //other methods
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
           case 3:
               if(expresionThree >0 && expresionThree < 8)
               {expresionThree= expresionThree + amount;}
               break;   
           default: 
               break;
        }
   }
   
  public String toString()
  {
    String result;
    
    result = id + "\t" + expresionOne + "\t" + expresionTwo + "\t" + expresionThree + "\t"+ hunger; 

    return result;
  }

}