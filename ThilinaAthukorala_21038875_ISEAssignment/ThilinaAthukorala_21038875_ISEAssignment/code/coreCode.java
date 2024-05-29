/*
Title:      ISAD1000_Final_Assessment
Author:     A.T.P Athukorala
Created:    20/05/2022
Modified:   30/05/2022
Desc:       Final Assessment(ISAD1000)
*/
import java.util.*;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import java.io.File;  
import java.io.FileNotFoundException;  // To handle errors.
import java.io.IOException;//For Exceptions.
import java.util.Scanner; //To read text files.
import java.io.FileWriter;   // Import the FileWriter class


public class coreCode
{
         public static void main(String[] args) throws IOException
         {
         Scanner sc = new Scanner(System.in);
         //Initiating variable to obtain choice of user.
         int selection = 0;
   
         System.out.println(">1. Converting a string to upper case or lower case.\n");
         System.out.println(">2. Identify whether numeric values are in a given string.\n");
         System.out.println(">3. Identify whether a given string is a valid number or not.\n");
         System.out.println(">4. Remove numeric values in a given string and convert the string to upper case or lower Case.\n");
         System.out.println(">5. Convert a value in kilograms to pounds and vice versa, and mass given in milligram to ounce and vice versa.\n");
         System.out.println(" Please enter the Number corresponding to the required function : \n");
         //obtain the required function from user.
         selection = sc.nextInt();
         
         //Initialize the method according to user choice.
                      switch(selection)
                           {
                              case 1:
                              stringCase("Thilina");
                              //Calls method which converts String to uppercase or Lower case.
                              break;
                      
                              case 2:
                              numScan();
                              // Calls method to Scan and check wether any numerical values are available/embedded in the String.
                              break;
                      
                              case 3:
                              valNum();
                              //Calls method to check wether a entered string is a valid number(Integer).
                              break;
                      
                              case 4:
                              remDigit();
                              //Calls method to remove the identified numbers from a String.
                              break;
                      
                              case 5:
                              massConversion();
                              //Calls method to convert values in different mass units.
                              break;

                              default:
                              //Error to display if user input is not between 1 and 5. 
                              System.out.println("Error! Invalid Selection in main menu\n Available choices : 1/2/3/4/5");
                              break;

                           }
//Close the Scanner since it's not in use.
sc.close();

}

           public static String stringCase(String Inp)//Method which converts String to uppercase or Lower case.
            {
                 



                              //Initialize the variable to obtain the String input for operations.
                              
                              String result ="";
                     
                              result =("value Converted to uppercase : " + Inp.toUpperCase() + "\nvalue Converted to Lowercase : " + Inp.toLowerCase());                              
                              System.out.println(result);
                          return result;
               

            }


           public static String numScan()  //Method to Scan and check whether any numerical values are available/embedded in the String.

            {
                   Scanner sc = new Scanner(System.in);
                   int digitCount = 0;
                   String result ="";
                   //initialize a variable to take the digit count in each word to decide whether the String contains any digits.
            
            
                    String userInp2="";
                    //user input to be checked for numerical values.
                   // System.out.println(">Enter the String to be checked : ");
                    userInp2 = sc.next();
    
                       
                    
                      
                      //Split the String into a Array of characters to identify each of the characters separately.
                       char[] chArray=userInp2.toCharArray();
    
                               for(int i=0; i<chArray.length; i++)
                               //until the lenght of the array is equal to the number of characters in the String
                                       {

                                                //Scan whether the character is a digit.
                                                if(Character.isDigit(chArray[i]))
                                                       {
                                                          digitCount +=1;
                                                      
                                                        }

                                                         //Entered a negative number with it's sign
                                                else if(chArray[i] == '-')
                                                         
                                                        {

                                                           System.out.print("-");
                                                        }

                                                              //Entered a positive number with it's sign
                                                      else if(chArray[i] == '+')

                                                            {
                                                               System.out.print("+");
                                                            }
                                         }
        
                                              
                                         if(digitCount == 0)//A zero digit count explains that there are no digits in it.

                                                  {

                                                   //   System.out.println("\nThe entered string does not contain any numerical values" + userInp2);
                                                      result = "\nThe entered string do not contain numerical values";
                                                      System.out.println(result);

                                                      
                                                  }

                                               else 
                                                      {//if the digit count is anything other than zero it contains digits
                                                         result = "\nThe entered string contain numerical values";
                                                         System.out.println(result);
            
                                                     

                                                      }
                                                      return result;
           
                                                   
             }


            //Method to check wether a entered string is a valid number(Integer).
            public static String valNum() 
             {

               Scanner sc = new Scanner(System.in);
               String result="";
                     
                         

                             
                                          
                                          int deciCount = 0; //declared as zero in each loop since the count should be saved in the memory when taking the next string input.
                                          int digiCount = 0;//Declared as zero in each loop since the ccount should be detected as 1 in wach word if a decimal is present and would be an error if they are saved.
                                          
                                          //Extracted the data to 'data' variable.
                                           String data = sc.nextLine();
  
                                          //Split the String into a Array of characters to identify each of the characters separately.
                                          char[] chArray2=data.toCharArray();
  
                                               //unitl the lenght of the array is equal to the number of characters in the String
                                               for(int i=0; i<chArray2.length; i++)
                                                      {
               
                                                           //Scan if the character is a digit.
                                                           if(Character.isDigit(chArray2[i]))
                                                                  {
                                                                       //Increases the count by one for every digit found
                                                                       digiCount +=1;
   
                                                                  }

                                                                      //Assumed that a decimal number is entered as a string.
                                                                  if(chArray2[i] == '.')
                                                                         {

                                                                            deciCount +=1;
   
                                                                         }       

                                                      
                                                        //To detect whether it's a number digit count being more than one is not enough
                                                        // the whole string should be equal to the digit count
                                                        if(digiCount == chArray2.length )
                                                      
                                                                  {
                                                                       //Display the input to user with the result since it's accessed directly from the file.
                                                                       result = "It is a valid number";
                                                                       System.out.println(result);
                                                                        
                                                                  }
                                                                     //Since we are checking whether the entered string is a decimal number as a whole there can be errors like entering '..'.
                                                                     //(two dots) therefore it should be checked wether the dot count is 1.
                                                                   else if(deciCount == 1 && (digiCount == chArray2.length -1))
                                                                           {
                                                                              result = "It is a decimal number";
                                                                              System.out.println(result);
                                                                           }
                                                                        else
                                                                               {
                                                                                   //If the total digit count is not equal to the lenght string and more than one dot is present it will not be a valid number.
                                                                                   result = "It is a not a valid number";
                                                                                   System.out.println(result);
                                                                                   System.out.println("Number of digits in the String : " + digiCount);
                                                                                   
                                                                                  
                                                      
                                                      
                                                                               }
                                                      
                                                             
                                    }
                                    sc.close();
                                    return result;
                         
                  }
                   

                  public static String remDigit() //Method to remove the identified numbers from a String.
                  {

                     Scanner sc = new Scanner(System.in);

                          String removedDig = "";
                          int selection2 =0;
                           String result = "";
                     
                          String userInp3 = sc.nextLine();;
                          System.out.print("String to be modified : " + userInp3);

                             //Split the String into a Array of characters to identify each of the characters separately.
                            char[] chArray3=userInp3.toCharArray();

                                 //unitl the lenght of the array is equal to the number of characters in the String
                                 for(int i=0; i<chArray3.length; i++)

                                           {
                                              //Scan if the character is a digit.
                                              if(Character.isDigit(chArray3[i]))

                                                    {
                                                        //Replace the the digits with a empty character when identified as a digit.
                                                        chArray3[i] = '\0';

                                                    }
                                                else
                                                     {
                                                        //Extract the non-digit characters from the array and collect them to form a String.
                                                        removedDig += chArray3[i];
                                                     }
  
                
                                           }
                                          System.out.print(removedDig);

                                          System.out.println("\n>String to be converted : " + removedDig);

                                                    
                                             result = ("value Converted to uppercase : " + removedDig.toUpperCase() + "\nvalue Converted to Lowercase : " + removedDig.toLowerCase());
                                             System.out.println(result);
                                          
                                          
                   

                                         
                            
                                                      sc.close();
                                                      return result;
                  }

                   //Method to convert values in different mass units.
                  private static void massConversion()throws IOException
                  {
                        try
                            {
                                String fileData = "";
                                Scanner inp = new Scanner(System.in);
                                //variable to get user input.
                                int selection3 =0;

                                     System.out.println(">1. Convert values in Kilograms to pounds\n");
                                     System.out.println(">2. Convert values in pounds to Kilograms\n");
                                     System.out.println(">3. Convert values in milligrams to ounces\n");
                                     System.out.println(">4. Convert values in ounces to milligrams\n");
                                     System.out.println(" Please enter the Number corresponding to the required function : \n");
                                     selection3 = inp.nextInt();
                                     //Gets user choice.
          
                                         //data input file.
                                         File newFile = new File("calcData.txt");
                                         Scanner sc = new Scanner(newFile);  


                                             while (sc.hasNextLine())
       
                                                      {
             
         
                                                               String data = sc.nextLine();
                                                               Double data1 = Double.parseDouble(data); 
        
                                                               String fileInp = "";
                                                               //variable to Store results obtained after the calculation.
                                                               double result;
                                                                //variable to Store the rounded value.
                                                               double roundVal;

                                                               switch(selection3)
                                                                       {
                                                                           case 1:
                                     
                                                                                   System.out.println(">Value in Kilograms to be converted : " + data1 + "Kg ");
                                                                                    //convert the value in kilograms to pounds by multiplying with 2.205.
                              
                                                                                    result = (data1*2.205);
                                                                                    //Round off the obtained value.

                                                                                    roundVal = (double)Math.round(result* 100000d)/100000d;
                                                                                    fileInp = ("\nValue of " +data1+ "Kg in pounds : " + roundVal + "lb\n\n");

                                                                                      //Collect the set of strings to print the final collection of results.
                                                                                    fileData += fileInp;
                           
                                                                           break;
          
                                                                           case 2:

                                                                                     System.out.println(">Value in Pounds to be converted :  " + data1 + "lb ");

                                                                                     //convert the value in Pounds to Kilograms ,dividing by 2.205.                             
                                                                                     result = (data1/2.205);

                                                                                     //Round off the obtained value.
                                                                                     roundVal = (double)Math.round(result* 100000d)/100000d;
                                                                                     fileInp = ("\nValue of " +data1+ "lb in Kilograms : "+ roundVal + "Kg\n\n");

                                                                                     //Collect the set of strings to print the final collection of results.
                                                                                     fileData += fileInp;
                              
                             
                                                                            break;
          
                                                                            case 3:

                                                                                      System.out.println(">Value in milligrams to be converted : " + data1 + "mg ");
 
                                                                                      //convert the value in milligrams to ounces ,multiplying by 3.5274 and dividing by 100000.                            
                                                                                      result = (3.5274*data1/100000);

                                                                                     //Round off the obtained value.                        
                                                                                     roundVal = (double)Math.round(result* 100000d)/100000d;
                                                                                     fileInp = ("\nValue of " +data1+ "mg in ounces : "+  roundVal + "OZ\n\n");

                                                                                     //Collect the set of strings to print the final collection of results.
                                                                                     fileData += fileInp;
                          
                              
                                                                            break;
          
                                                                            case 4:
                                                                                       System.out.println(">Value in ounces to be converted : " + data1 + "OZ ");

                                                                                       //convert the value in ounces to milligrams ,dividing by 3.5274 and multiplying by 100000.                                                     
                                                                                       result = (data1*100000/3.5274);

                                                                                       roundVal = (double)Math.round(result* 100000d)/100000d;
                                                                                       fileInp = ("\nValue of " +data1+ "OZ in milligrams : "+  roundVal + "mg\n\n");
                                                                                       fileData += fileInp;
                             
                                                                            break;
          
                                                                           default:
          
                                                                                  System.out.println("\nError! Invalid Selection \n Available choices : 1/2/3/4");
                                                                        }

                                                       }
                                                            //Initialize the filePrint method to print the collected data from the loop.
                                                            filePrint(fileData);
                                                                           
                                                                       
                                                                       
                           }
                             catch (FileNotFoundException e) 
                                 {
                                     System.out.println("Error! File not found.");
                                     e.printStackTrace();
                                 }
                   }

                  //Method to print the collected string in the massConversion method.
                  private static void filePrint(String fileData)throws IOException
  
                   {//obtain the parameter value of 'filedata' to print.
  
                        try
                              {
                                 //creates new file named calculated to store the calculated data
                                 FileWriter fWriter = new FileWriter("calculated.txt");

                                 fWriter.write(fileData);
                                 fWriter.close();

                                 //Close Filewriter since it is not being used after the print is over.
                                 System.out.println("Converted answers will be available in the text file named 'calculated.txt' in the same folder");
                                 //Let user know that the results of the calculations are present in the new text file named 'calculated.txt'

                              }
                        catch (IOException e)

                              {
                                    //error with the input file
                                     System.out.println("An error occurred.");
                                     e.printStackTrace();
                              }
   
                  }
}                                                              


                   
                
             


             


