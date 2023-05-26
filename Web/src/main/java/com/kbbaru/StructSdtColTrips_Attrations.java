package com.kbbaru ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColTrips.Attrations", namespace ="KBBaru")
public final  class StructSdtColTrips_Attrations implements Cloneable, java.io.Serializable
{
   public StructSdtColTrips_Attrations( )
   {
      this( -1, new ModelContext( StructSdtColTrips_Attrations.class ));
   }

   public StructSdtColTrips_Attrations( int remoteHandle ,
                                        ModelContext context )
   {
   }

   public  StructSdtColTrips_Attrations( java.util.Vector<StructSdtTrips_Attrations> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Trips.Attrations",namespace="KBBaru")
   public java.util.Vector<StructSdtTrips_Attrations> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtTrips_Attrations> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtTrips_Attrations> item = new java.util.Vector<>();
}

