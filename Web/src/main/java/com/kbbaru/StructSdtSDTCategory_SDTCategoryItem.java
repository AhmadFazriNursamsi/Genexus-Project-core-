package com.kbbaru ;
import com.genexus.*;

public final  class StructSdtSDTCategory_SDTCategoryItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTCategory_SDTCategoryItem( )
   {
      this( -1, new ModelContext( StructSdtSDTCategory_SDTCategoryItem.class ));
   }

   public StructSdtSDTCategory_SDTCategoryItem( int remoteHandle ,
                                                ModelContext context )
   {
      gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname = "" ;
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

   public short getSdtcategoryid( )
   {
      return gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid ;
   }

   public void setSdtcategoryid( short value )
   {
      gxTv_SdtSDTCategory_SDTCategoryItem_N = (byte)(0) ;
      gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid = value ;
   }

   public String getSdtcategoryname( )
   {
      return gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname ;
   }

   public void setSdtcategoryname( String value )
   {
      gxTv_SdtSDTCategory_SDTCategoryItem_N = (byte)(0) ;
      gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname = value ;
   }

   public boolean getIscheck( )
   {
      return gxTv_SdtSDTCategory_SDTCategoryItem_Ischeck ;
   }

   public void setIscheck( boolean value )
   {
      gxTv_SdtSDTCategory_SDTCategoryItem_N = (byte)(0) ;
      gxTv_SdtSDTCategory_SDTCategoryItem_Ischeck = value ;
   }

   protected byte gxTv_SdtSDTCategory_SDTCategoryItem_N ;
   protected short gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid ;
   protected boolean gxTv_SdtSDTCategory_SDTCategoryItem_Ischeck ;
   protected String gxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname ;
}

