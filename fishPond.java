import java.util.*;
import java.io.*;


public class fishPond
{
  public static void main(String[] args) throws IOException, InterruptedException  
  {
    int n; //scanner value
    boolean exit; //exit value for internal loops
    boolean exitPrime = true; // primary exit for whole program
    Scanner scan = new Scanner(System.in);
    
    int countOne = 0; 
    int countTwo= 0;
    int growthOne =0;
    int growthTwo = 0;
    int rateOne =0;
    int rateTwo =0; 
    
    //active creatures
    ArrayList<consumerOne> consumers = new ArrayList<consumerOne>();
    ArrayList<predatorOne> predators = new ArrayList<predatorOne>();
    ArrayList<sPredator> sPredators = new ArrayList<sPredator>();
    
    //reproduction selection pool
    ArrayList<consumerOne> storageC = new ArrayList<consumerOne>();
    ArrayList<predatorOne> storageP = new ArrayList<predatorOne>();
    ArrayList<sPredator> storageS = new ArrayList<sPredator>();
    
     
    //boolean confirm = true; 
    while(exitPrime)
    {
      System.out.println("Welcome to Fish Pond");
      System.out.println("by Ryan Sherry\nCreated: 2017\nIntroduction to Bio-Informatics\nCIS400");
      
      System.out.println("\ntype any number to contiue");
      n= scan.nextInt(); 
      
      System.out.println("\n\nThis Simulator is Designed to Answer:");
      System.out.println("How does a population adapt towards one food source based on availability?");
      System.out.println("how does that species adapt to express a phenotype that promotes eating one food source over another?");
      
      System.out.println("\ntype any number to contiue");
      n= scan.nextInt();
      
      System.out.println("\n-------SIMULATOR START SETTINGS------");
      System.out.println("Two Modes:\nStandard: FIX ME\nCustom: FIX ME");
      System.out.println("Enter 1 for Standard enter 2 for Custom");
      n = scan.nextInt();
      
      exit = true;
      while(exit)
      {
        switch(n)
        {
            case 1:
                envStart(consumers,predators,sPredators); //function that creates all objects
                countOne=100;
                countTwo=100;
                growthOne=1;
                growthTwo=1;
                rateOne=1;
                rateTwo=1;
                exit = false; //exit loop command. 
                break;
                
            case 2: //customdd
                System.out.println("FIX ME");
                //envCustom(); // custom function to create objects

                exit =false;
                break;
                
            default:
                System.out.println("\nInvaild Entry\nPlease enter 1 for Standard or 2 for Custom");
                n = scan.nextInt();
                break;
      }   
    }
        producerOne foodOne = new producerOne(countOne,growthOne,rateOne);
        System.out.println("Creating: Producer One\nSoruce: 1 ");
        producerOne foodTwo = new producerOne(countTwo,growthTwo,rateTwo);
        System.out.println("Creating: Producer One\nSource: 2" );
        
        System.out.println("\n------------Enviroment Created");
        System.out.println("Procuders:2\nConsumers:"+consumers.size());
        System.out.println("predators:"+predators.size());
        System.out.println("Super Predators:"+sPredators.size());
        System.out.println("Food Source One:"+foodOne.getCount());
        System.out.println("Food Source Two:"+foodTwo.getCount());

        Global.turn=0;  //set globoal turn count to zero
        System.out.println("\nEnviroment Ready\nGlobal Turn set to: " +Global.turn);
      
        System.out.println("To Start Simulator enter a number");
        n = scan.nextInt();
      
        // EXAMPLE   int a = ((consumerOne) consumers.get(1)).id;
        //Test METHODS 
//        System.out.println(feed(selectionC(1,consumers)));
//        System.out.println("before death?:"+consumers.size());
//        deathC(consumers); 
//        System.out.println("after death?:"+consumers.size());
//        
//        System.out.println("before  p death?:"+predators.size());
//        deathP(predators); 
//        System.out.println("after  p death?:"+predators.size());
//        
//        System.out.println("before  s death?:"+sPredators.size());
//        deathS(sPredators); 
//        System.out.println("after  s death?:"+sPredators.size()); 
//        
//        int[] test = new int[2];
//        test[0]=1;
//        test[1]=2;
//        
//        
//        System.out.println("before reproduce?"+consumers.size());
//        reproduceC(test,consumers);
//        System.out.println("after reproduce?"+consumers.size());
//        System.out.println("8-1: "+consumers.get(8).getExpresionOne());
//        System.out.println("8-2: "+consumers.get(8).getExpresionTwo());
//        System.out.println("9-1: "+consumers.get(9).getExpresionOne());
//        System.out.println("9-2: "+consumers.get(9).getExpresionTwo());
//
//test of lifeC 
//        lifeC(consumers,storageC,foodOne,foodTwo);
//        lifeC(consumers,storageC,foodOne,foodTwo); 
//        lifeC(consumers,storageC,foodOne,foodTwo); 
//       
//        System.out.println("OHMAHA:");
//        System.out.println("Procuders:2\nConsumers:"+consumers.size());
//        System.out.println("predators:"+predators.size());
//        System.out.println("Super Predators:"+sPredators.size());
//        System.out.println("Food Source One:"+foodOne.getCount());
//        System.out.println("Food Source Two:"+foodTwo.getCount());
//        
//         int[] test; 
//         int[] test2;
//         test = selectionC(1,consumers);
//         test2 = selectionC(2,consumers);
//         
//         for(int i = 0; i< test.length; i++)
//         {
//             System.out.println("testof 1: "+test[i]+"\ttest of 2:"+test2[i]);
//         }

//--------TURN------

        while(Global.turn <20 )
        {
            System.out.println("Turn: "+Global.turn); 
            
            lifeC(consumers,storageC,foodOne,foodTwo); //consumer round
            lifeP(predators,storageP); //predator round 
            lifeS(sPredators,storageS); //super predator round

            printDataStore(consumers,predators,sPredators); 
            Global.turn++;
        }
            
        System.out.println("Procuders:2\nConsumers:"+consumers.size());
        System.out.println("predators:"+predators.size());
        System.out.println("Super Predators:"+sPredators.size());
        System.out.println("Food Source One:"+foodOne.getCount());
        System.out.println("Food Source Two:"+foodTwo.getCount());   
         


        
        exitPrime =false;
     
  }
}
  public static void envStart(ArrayList<consumerOne> one, ArrayList<predatorOne> two, ArrayList<sPredator> three) //create all creatures and food standard set up
  {
    for(int i = 0; i < 9; i++) 
    {
    one.add(new consumerOne());
    System.out.println("Creating: Consumer One\nCreature: "+i );
    }
    
    for(int i = 0; i < 5; i++) 
    {
    two.add(new predatorOne());
    System.out.println("Creating: Predator One\nCreature: "+i );
    }
    
    for(int i = 0; i < 3; i++) 
    {
    three.add(new sPredator());
    System.out.println("Creating: Super Predator\nCreature: "+i );
    }
    
  }
  public static void envCustom()
  {
      System.out.println("To be created later FIX ME");
  }
  
  public static int feed(int[] a) //performs a weighted random selection for who gets to eat
  {
      int sum =0; 
      int rNum;
      int selection = -1; //negative one is outside range and would break stuff
      Random generator = new Random();
     
      for(int i =0; i< a.length ; i++) { sum+=a[i];} //sum the array together
      
      rNum = generator.nextInt(sum);  // pick random number between 0 and sum
      
      for(int i=0; i<a.length; i++)
      {
          rNum-=a[i];  // iterate over weights decrementing value by current selection
          if(rNum <= 0)  
          {
              selection =i;
              i=a.length;
          } //if <= 0 then break and return value. 
      }
      
      return selection;
  }
  
  public static int[] selectionC(int gene, ArrayList<consumerOne> a)
  {
      int data[] = new int[a.size()];
      
      if(gene == 1)
      {
          for(int i=0; i < a.size(); i++)
          { data[i]= ((consumerOne) a.get(i)).expresionOne;}
      }
      else
      {
          for(int i=0; i < a.size(); i++)
          { data[i]= ((consumerOne) a.get(i)).expresionTwo;}
      }
      
      return data;
  }
  public static int[] selectionP(int gene, ArrayList<predatorOne> a)
  {
      int data[] = new int[a.size()];
      
      if(gene == 1)
      {
          for(int i=0; i < a.size(); i++)
          { data[i]= ((predatorOne) a.get(i)).expresionOne;}
      }
      else if(gene == 2)
      {
          for(int i=0; i < a.size(); i++)
          { data[i]= ((predatorOne) a.get(i)).expresionTwo;}
      }
      else  //gene ==3
      {
          for(int i=0; i < a.size(); i++)
          { data[i]= ((predatorOne) a.get(i)).expresionThree;} 
      }
      
      return data;
  }
  
  public static int[] selectionS(int gene, ArrayList<sPredator> a)
  {
      int data[] = new int[a.size()];
      
      if(gene == 1)
      {
          for(int i=0; i < a.size(); i++)
          { data[i]= ((sPredator) a.get(i)).expresionOne;}
      }
      else //2 
      {
          for(int i=0; i < a.size(); i++)
          { data[i]= ((sPredator) a.get(i)).expresionTwo;}
      }
      return data;
  }
  public static void deathC(ArrayList<consumerOne> a)
  {
      int data[] = new int[a.size()];
      int high=0;
      int spot=0;
      Random generator = new Random();
      
      for(int i=0; i < a.size(); i++)
      { data[i]= ((consumerOne) a.get(i)).hunger;}
      
      for(int i=0; i<data.length; i++ )
      { 
          if(data[i] > high) 
          {
              high =data[i];
              spot =i; 
          }
      }
      //incase everone left is starving
      if( high ==0 && spot ==0 ) {spot = generator.nextInt(data.length);}
      
      a.remove(spot); //kill creature Muhawawaw
  }
  public static void deathP(ArrayList<predatorOne> a)
  {
      int data[] = new int[a.size()];
      int high=0;
      int spot=0;
      Random generator = new Random();
      
      for(int i=0; i < a.size(); i++)
      { data[i]= ((predatorOne) a.get(i)).hunger;}
      
      for(int i=0; i<data.length; i++ )
      { 
          if(data[i] > high) 
          {
              high =data[i];
              spot =i; 
          }
      }
      //incase everone left is starving
      if( high ==0 && spot ==0 ) {spot = generator.nextInt(data.length);}
      
      a.remove(spot); //kill creature Muhawawaw
  }         
  public static void deathS(ArrayList<sPredator> a)
  {
      int data[] = new int[a.size()];
      int high=0;
      int spot=0;
      Random generator = new Random();
      
      for(int i=0; i < a.size(); i++)
      { data[i]= ((sPredator) a.get(i)).hunger;}
      
      for(int i=0; i<data.length; i++ )
      { 
          if(data[i] > high) 
          {
              high =data[i];
              spot =i; 
          }
      }
      //incase everone left is starving
      if( high ==0 && spot ==0 ) {spot = generator.nextInt(data.length);}
      
      a.remove(spot); //kill creature Muhawawaw
  }          
  
  public static void reproduceC(int[] source, ArrayList<consumerOne> a)  //reproduces and replicates inside storage array
  {
      int mutate; //mutation result yes or no
      int sign; //mutation up or down
      int k=0; //extra interator
      int[] data = new int[4]; 
      
      int mutateTwo; //mutation result yes or no
      int signTwo; //mutation up or down      
      Random generator = new Random();
      

      mutate = generator.nextInt(10); //0-2 chance of mutation 3-9 normal
      sign = generator.nextInt(2); //0 negative 1 postive mutation 
      
      mutateTwo = generator.nextInt(10); //0-2 chance of mutation 3-9 normal
      signTwo = generator.nextInt(2); //0 negative 1 postive mutation 
      
      data[0]=mutate;
      data[1]=sign; 
      data[2]=mutateTwo;
      data[3]=signTwo;
      
      
      for(int i=0; i<2; i++)
      {
          if(source[i] == 1)
          {
              if (data[i+k] < 4) //gene 1
              {
                  if(data[i+k+1] ==0) //lower expression
                  {
                    a.add(new consumerOne(a.get(i).getExpresionOne() -1,a.get(i).getExpresionTwo(),0));
                  }
                  else //higher expresion
                  {
                    a.add(new consumerOne(a.get(i).getExpresionOne() +1,a.get(i).getExpresionTwo(),0));
                  }
              }
              else //no mutation
              {
                  a.add(new consumerOne(a.get(i).getExpresionOne(),a.get(i).getExpresionTwo(),0));
              }
          }
          else //gene 2
              {   
                  if (data[i+k] < 4)
                  {
                      if(data[i+k+1] ==0) //lower expression
                      {
                        a.add(new consumerOne(a.get(i).getExpresionOne() ,a.get(i).getExpresionTwo()-1,0));
                      }
                      else //higher expresion
                      {
                        a.add(new consumerOne(a.get(i).getExpresionOne() ,a.get(i).getExpresionTwo()+1,0));
                      }
                  }
                  else //no mutation
                  {
                      a.add(new consumerOne(a.get(i).getExpresionOne(),a.get(i).getExpresionTwo(),0));
                  }
              }
          k++; //iterator for data[]
      }
  }
  public static void reproduceP(int[] source, ArrayList<predatorOne> a)  //reproduces and replicates inside storage array
  {
      int mutate; //mutation result yes or no
      int sign; //mutation up or down
      int k=0; //extra interator
      int[] data = new int[4]; 
      
      int mutateTwo; //mutation result yes or no
      int signTwo; //mutation up or down      
      Random generator = new Random();
      

      mutate = generator.nextInt(10); //0-2 chance of mutation 3-9 normal
      sign = generator.nextInt(2); //0 negative 1 postive mutation 
      
      mutateTwo = generator.nextInt(10); //0-2 chance of mutation 3-9 normal
      signTwo = generator.nextInt(2); //0 negative 1 postive mutation 
      
      data[0]=mutate;
      data[1]=sign; 
      data[2]=mutateTwo;
      data[3]=signTwo;
      
      
      for(int i=0; i<1; i++)
      {
          if(source[i] == 1)
          {
              if (data[i+k] < 4) //gene 1
              {
                  if(data[i+k+1] ==0) //lower expression
                  {
                    a.add(new predatorOne(a.get(i).getExpresionOne() -1,a.get(i).getExpresionTwo(),a.get(i).getExpresionThree(),0));
                  }
                  else //higher expresion
                  {
                    a.add(new predatorOne(a.get(i).getExpresionOne() +1,a.get(i).getExpresionTwo(),a.get(i).getExpresionThree(),0));
                  }
              }
              else //no mutation
              {
                  a.add(new predatorOne(a.get(i).getExpresionOne(),a.get(i).getExpresionTwo(),a.get(i).getExpresionThree(),0));
              }
          }
          else if(source[i] == 2) //gene 2
              {   
                  if (data[i+k] < 4)
                  {
                      if(data[i+k+1] ==0) //lower expression
                      {
                        a.add(new predatorOne(a.get(i).getExpresionOne() ,a.get(i).getExpresionTwo()-1,a.get(i).getExpresionThree(),0));
                      }
                      else //higher expresion
                      {
                        a.add(new predatorOne(a.get(i).getExpresionOne() ,a.get(i).getExpresionTwo()+1,a.get(i).getExpresionThree(),0));
                      }
                  }
                  else //no mutation
                  {
                      a.add(new predatorOne(a.get(i).getExpresionOne(),a.get(i).getExpresionTwo(),a.get(i).getExpresionThree(),0));
                  }
              }
         else //gene 3
              {   
                  if (data[i+k] < 4)
                  {
                      if(data[i+k+1] ==0) //lower expression
                      {
                        a.add(new predatorOne(a.get(i).getExpresionOne() ,a.get(i).getExpresionTwo(),a.get(i).getExpresionThree()-1,0));
                      }
                      else //higher expresion
                      {
                        a.add(new predatorOne(a.get(i).getExpresionOne() ,a.get(i).getExpresionTwo(),a.get(i).getExpresionThree()+1,0));
                      }
                  }
                  else //no mutation
                  {
                      a.add(new predatorOne(a.get(i).getExpresionOne(),a.get(i).getExpresionTwo(),a.get(i).getExpresionThree(),0));
                  }
              }
          k++; //iterator for data[]
      }
  }
  public static void reproduceS(int[] source, ArrayList<sPredator> a)  //reproduces and replicates inside storage array
  {
      int mutate; //mutation result yes or no
      int sign; //mutation up or down
      int k=0; //extra interator
      int[] data = new int[4]; 
      
      int mutateTwo; //mutation result yes or no
      int signTwo; //mutation up or down      
      Random generator = new Random();
      

      mutate = generator.nextInt(10); //0-2 chance of mutation 3-9 normal
      sign = generator.nextInt(2); //0 negative 1 postive mutation 
      
      mutateTwo = generator.nextInt(10); //0-2 chance of mutation 3-9 normal
      signTwo = generator.nextInt(2); //0 negative 1 postive mutation 
      
      data[0]=mutate;
      data[1]=sign; 
      data[2]=mutateTwo;
      data[3]=signTwo;
      
      
      for(int i=0; i<1; i++)
      {
          if(source[i] == 1)
          {
              if (data[i+k] < 4) //gene 1
              {
                  if(data[i+k+1] ==0) //lower expression
                  {
                    a.add(new sPredator(a.get(i).getExpresionOne() -1,a.get(i).getExpresionTwo(),0));
                  }
                  else //higher expresion
                  {
                    a.add(new sPredator(a.get(i).getExpresionOne() +1,a.get(i).getExpresionTwo(),0));
                  }
              }
              else //no mutation
              {
                  a.add(new sPredator(a.get(i).getExpresionOne(),a.get(i).getExpresionTwo(),0));
              }
          }
          else //gene 2
              {   
                  if (data[i+k] < 4)
                  {
                      if(data[i+k+1] ==0) //lower expression
                      {
                        a.add(new sPredator(a.get(i).getExpresionOne() ,a.get(i).getExpresionTwo()-1,0));
                      }
                      else //higher expresion
                      {
                        a.add(new sPredator(a.get(i).getExpresionOne() ,a.get(i).getExpresionTwo()+1,0));
                      }
                  }
                  else //no mutation
                  {
                      a.add(new sPredator(a.get(i).getExpresionOne(),a.get(i).getExpresionTwo(),0));
                  }
              }
          k++; //iterator for data[]
      }
  }
  public static void starveC(ArrayList<consumerOne> a)
  {
      for(int i  =0; i < a.size(); i++)
      {
          //System.out.println("before:"+a.get(i).getHunger());
          //System.out.println(a.get(i).hunger);
          a.get(i).incrementHunger();
          //System.out.println("after"+a.get(i).getHunger());
      }
  }
  
  public static void starveP(ArrayList<predatorOne> a)
  {
      for(int i  =0; i < a.size(); i++)
      {
          //System.out.println("before:"+a.get(i).getHunger());
          //System.out.println(a.get(i).hunger);
          a.get(i).incrementHunger();
          //System.out.println("after"+a.get(i).getHunger());
      }
  }
  public static void starveS(ArrayList<sPredator> a)
  {
      for(int i  =0; i < a.size(); i++)
      {
          //System.out.println("before:"+a.get(i).getHunger());
          //System.out.println(a.get(i).hunger);
          a.get(i).incrementHunger();
         // System.out.println("after"+a.get(i).getHunger());
      }
  }
  

  public static void lifeC(ArrayList<consumerOne> c, ArrayList<consumerOne> s,producerOne f1,producerOne f2)
  {
      Random generator = new Random(); 
      int first; //first food source to go
      int second; //second food source to go
      int value; //intial store for random
      
      int selectOne; //first creature to eat
      int selectTwo; //second creature to eat
      
      int[] selects = new int[2];
      
      //determine which food source is up for grabs
      value = generator.nextInt(1)+1;
      if(value ==2) {first=2;second=1;}
      else {first = 1; second =2;}
      
      //----------------------- round 1
      selectOne = feed(selectionC(first,c)); //decideds what creature eats first round 1

      if(first == 1) {f1.decrementCount();}
      else {f2.decrementCount();}
      
      c.get(selectOne).setHunger(0); //sets hunger of succesful hunter to zero
      s.add(c.get(selectOne));  //takes the item at selectOne and puts it into storage
      c.remove(selectOne); //removes it from active array into storage
      
     // ------------------------ round 2
      selectTwo = feed(selectionC(second,c)); //decides what creature eats next round 2
      
      if(second == 1) {f1.decrementCount();}
      else {f2.decrementCount();}
      
      c.get(selectTwo).setHunger(0); //sets hunger of succesful hunter to zero
      s.add(c.get(selectTwo));  //takes the item at selectOne and puts it into storage
      c.remove(selectTwo); //remove it from active array into storage
      
     //------------------------ clean Up
     
   
      deathC(c); //kill weakest creature that hasnt eaten in the longest
      deathC(c); //Kill Weakest creature round 2 //remove to increase pop
     
      starveC(c); //increase hunger on unfed creatures++
      
      selects[0]=selectOne;
      selects[1]=selectTwo;
      
      reproduceC(selects,s); //send genes that where used and storage array so succesful can reproduce
      
      //add creatures from storage
      c.add(s.get(0));
      c.add(s.get(1));
      c.add(s.get(2));
      c.add(s.get(3));

  }
  public static void lifeP(ArrayList<predatorOne> c, ArrayList<predatorOne> s)
  {
      Random generator = new Random(); 
      int first; //first food source to go
      int second; //second food source to go
      int three;
      int value; //intial store for random
      
      int selectOne; //first creature to eat
      int selectTwo; //second creature to eat
      int selectThree; //third creature to eat;
      
      int[] selects = new int[3];
      
      //determine which food source is up for grabs
      value = 1;  //generator.nextInt(2)+1;
      first = value;
      
      //----------------------- round 1
      selectOne = feed(selectionP(first,c)); //decideds what creature eats first round 1

      
      c.get(selectOne).setHunger(0); //sets hunger of succesful hunter to zero
      s.add(c.get(selectOne));  //takes the item at selectOne and puts it into storage
      c.remove(selectOne); //removes it from active array into storage
      
      //must implement a round three to use with ohter creatures also fix the roud 1 and 2 
     //------------------------ clean Up
     
      deathP(c); //kill weakest creature that hasnt eaten in the longest
     
      starveP(c); //increase hunger on unfed creatures++
      
      selects[0]=selectOne;
      //selects[1]=selectTwo;
      
      reproduceP(selects,s); //send genes that where used and storage array so succesful can reproduce
      
      //add creatures from storage
      c.add(s.get(0));
      c.add(s.get(1));
      //c.add(s.get(2));
      //c.add(s.get(3));

  }
  public static void lifeS(ArrayList<sPredator> c, ArrayList<sPredator> s)
  {
      Random generator = new Random(); 
      int first; //first food source to go
      int second; //second food source to go
      int three;
      int value; //intial store for random
      
      int selectOne; //first creature to eat
      int selectTwo; //second creature to eat
      int selectThree; //third creature to eat;
      
      int[] selects = new int[3];
      
      //determine which food source is up for grabs
      value = 1;  //generator.nextInt(2)+1;
      first = value;
      
      //----------------------- round 1
      selectOne = feed(selectionS(first,c)); //decideds what creature eats first round 1

      
      c.get(selectOne).setHunger(0); //sets hunger of succesful hunter to zero
      s.add(c.get(selectOne));  //takes the item at selectOne and puts it into storage
      c.remove(selectOne); //removes it from active array into storage
      
      //must implement a round three to use with ohter creatures also fix the roud 1 and 2 
     //------------------------ clean Up
     
      deathS(c); //kill weakest creature that hasnt eaten in the longest
     
      starveS(c); //increase hunger on unfed creatures++
      
      selects[0]=selectOne;
      //selects[1]=selectTwo;
      
      reproduceS(selects,s); //send genes that where used and storage array so succesful can reproduce
      
      //add creatures from storage
      c.add(s.get(0));
      c.add(s.get(1));
      //c.add(s.get(2));
      //c.add(s.get(3));

  }
  public static void printDataStore(ArrayList<consumerOne> c, ArrayList<predatorOne> p, ArrayList<sPredator> s) throws IOException
  {
    PrintWriter writer = null;
    try {
        writer = new PrintWriter(new BufferedWriter(new FileWriter("output.txt", true)));
    } catch (IOException e) {
        e.printStackTrace();
    }

    writer.println("\n\nROUND"+Global.turn+"\n");
    
    writer.println("Consumers");
    writer.println("id\texp1\texp2\thunger");
    for(int i = 0; i < c.size(); i++) 
    {   
      writer.println(c.get(i));
    } 
    
    writer.println("Predators");
    writer.println( "id\texp1\texp2\texp3\thunger");
    for(int i = 0; i < p.size(); i++) 
    {   
      writer.println(p.get(i));
    } 
    
    writer.println("Super Predators");
    writer.println("id\texp1\texp2\thunger");
    for(int i = 0; i < s.size(); i++) 
    {   
      writer.println(s.get(i));
    } 
    
    writer.close();
  }


  
  }
     