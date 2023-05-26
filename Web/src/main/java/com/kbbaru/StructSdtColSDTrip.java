package com.kbbaru ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColSDTrip", namespace ="KBBaru")
public final  class StructSdtColSDTrip implements Cloneable, java.io.Serializable
{
   public StructSdtColSDTrip( )
   {
      this( -1, new ModelContext( StructSdtColSDTrip.class ));
   }

   public StructSdtColSDTrip( int remoteHandle ,
                              ModelContext context )
   {
   }

   public  StructSdtColSDTrip( java.util.Vector<StructSdtSDTrip> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTrip",namespace="KBBaru")
   public java.util.Vector<StructSdtSDTrip> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTrip> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTrip> item = new java.util.Vector<>();
}

