package com.kbbaru ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColCountry", namespace ="KBBaru")
public final  class StructSdtColCountry implements Cloneable, java.io.Serializable
{
   public StructSdtColCountry( )
   {
      this( -1, new ModelContext( StructSdtColCountry.class ));
   }

   public StructSdtColCountry( int remoteHandle ,
                               ModelContext context )
   {
   }

   public  StructSdtColCountry( java.util.Vector<StructSdtCountry> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Country",namespace="KBBaru")
   public java.util.Vector<StructSdtCountry> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCountry> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCountry> item = new java.util.Vector<>();
}

