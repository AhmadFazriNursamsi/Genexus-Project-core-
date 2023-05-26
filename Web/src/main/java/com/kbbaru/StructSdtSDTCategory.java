package com.kbbaru ;
import com.genexus.*;

@javax.xml.bind.annotation.XmlType(name = "SDTCategory", namespace ="KBBaru")
public final  class StructSdtSDTCategory implements Cloneable, java.io.Serializable
{
   public StructSdtSDTCategory( )
   {
      this( -1, new ModelContext( StructSdtSDTCategory.class ));
   }

   public StructSdtSDTCategory( int remoteHandle ,
                                ModelContext context )
   {
   }

   public  StructSdtSDTCategory( java.util.Vector<StructSdtSDTCategory_SDTCategoryItem> value )
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

   @javax.xml.bind.annotation.XmlElement(name="SDTCategoryItem",namespace="KBBaru")
   public java.util.Vector<StructSdtSDTCategory_SDTCategoryItem> getItem( )
   {
      return item;
   }

   public void setItem( java.util.Vector<StructSdtSDTCategory_SDTCategoryItem> value )
   {
      item = value;
   }

   protected  java.util.Vector<StructSdtSDTCategory_SDTCategoryItem> item = new java.util.Vector<>();
}

