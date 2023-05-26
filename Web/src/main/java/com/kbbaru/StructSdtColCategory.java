package com.kbbaru ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "ColCategory", namespace ="KBBaru")
public final  class StructSdtColCategory implements Cloneable, java.io.Serializable
{
   public StructSdtColCategory( )
   {
      this( -1, new ModelContext( StructSdtColCategory.class ));
   }

   public StructSdtColCategory( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtColCategory( java.util.Vector<StructSdtCategory> value )
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

   @javax.xml.bind.annotation.XmlElement(name="Category",namespace="KBBaru")
   public java.util.Vector<StructSdtCategory> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtCategory> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtCategory> item = new java.util.Vector<>();
}

