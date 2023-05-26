package com.kbbaru ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColTrips", namespace ="KBBaru")
public final  class StructSdtColTrips implements Cloneable, java.io.Serializable
{
   public StructSdtColTrips( )
   {
      this( -1, new ModelContext( StructSdtColTrips.class ));
   }

   public StructSdtColTrips( int remoteHandle ,
                             ModelContext context )
   {
   }

   public  StructSdtColTrips( java.util.Vector<StructSdtTrips> value )
   {
      item = value;
   }

   public Object clone()
   {
      Object cloned = null;
      try
      {
         cloned = super.clone();
      }catch (CloneNotSupportedException e){ ; }
      return cloned;
   }

   @javax.xml.bind.annotation.XmlElement(name="Trips",namespace="KBBaru")
   public java.util.Vector<StructSdtTrips> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTrips> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTrips> item = new java.util.Vector<>();
}

