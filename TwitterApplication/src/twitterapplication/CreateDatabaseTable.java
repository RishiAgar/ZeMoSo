
package twitterapplication;

import twitterapplication.database.*;

public class CreateDatabaseTable
{   
   public static void main(String[] args)
   {
       new DropExistingDatabase().drop();
       new CreateDatabase().create();
       new CreateTable().create();
   }
}