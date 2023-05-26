package com.kbbaru.general ;
import com.kbbaru.*;
import com.genexus.*;

public final  class gxdomainpage
{
   private static java.util.TreeMap<Short, String> domain = new java.util.TreeMap<>();
   static
   {
      domain.put((short)10, "Rows");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        short key )
   {
      if (domain.containsKey( key ))
      {
         return domain.get( key );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<Short> getValues( )
   {
      GXSimpleCollection<Short> value = new GXSimpleCollection<Short>(Short.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((Short) itr.next());
      }
      return value;
   }

}

