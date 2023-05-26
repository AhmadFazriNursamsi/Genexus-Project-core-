package com.kbbaru ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTrip.TripAttractionsItem", namespace ="KBBaru")
public final  class StructSdtColSDTrip_TripAttractionsItem implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTrip_TripAttractionsItem( )
   {
      this( -1, new ModelContext( StructSdtColSDTrip_TripAttractionsItem.class ));
   }

   public StructSdtColSDTrip_TripAttractionsItem( int remoteHandle ,
                                                  ModelContext context )
   {
   }

   public  StructSdtColSDTrip_TripAttractionsItem( java.util.Vector<StructSdtSDTrip_TripAttractionsItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTrip.TripAttractionsItem",namespace="KBBaru")
   public java.util.Vector<StructSdtSDTrip_TripAttractionsItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTrip_TripAttractionsItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTrip_TripAttractionsItem> item = new java.util.Vector<>();
}

