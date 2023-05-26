package com.kbbaru ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColCountry.City", namespace ="KBBaru")
public final  class StructSdtColCountry_City implements Cloneable, java.io.Serializable
{
   public StructSdtColCountry_City( )
   {
      this( -1, new ModelContext( StructSdtColCountry_City.class ));
   }

   public StructSdtColCountry_City( int remoteHandle ,
                                    ModelContext context )
   {
   }

   public  StructSdtColCountry_City( java.util.Vector<StructSdtCountry_City> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Country.City",namespace="KBBaru")
   public java.util.Vector<StructSdtCountry_City> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCountry_City> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCountry_City> item = new java.util.Vector<>();
}

