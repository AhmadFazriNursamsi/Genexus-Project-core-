package com.kbbaru ;
import com.genexus.*;

public final  class StructSdtSDTrip_TripAttractionsItem implements Cloneable, java.io.Serializable
{
   public StructSdtSDTrip_TripAttractionsItem( )
   {
      this( -1, new ModelContext( StructSdtSDTrip_TripAttractionsItem.class ));
   }

   public StructSdtSDTrip_TripAttractionsItem( int remoteHandle ,
                                               ModelContext context )
   {
      gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname = "" ;
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

   public short getAttractionsid( )
   {
      return gxTv_SdtSDTrip_TripAttractionsItem_Attractionsid ;
   }

   public void setAttractionsid( short value )
   {
      gxTv_SdtSDTrip_TripAttractionsItem_N = (byte)(0) ;
      gxTv_SdtSDTrip_TripAttractionsItem_Attractionsid = value ;
   }

   public String getAttractionsname( )
   {
      return gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname ;
   }

   public void setAttractionsname( String value )
   {
      gxTv_SdtSDTrip_TripAttractionsItem_N = (byte)(0) ;
      gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname = value ;
   }

   protected byte gxTv_SdtSDTrip_TripAttractionsItem_N ;
   protected short gxTv_SdtSDTrip_TripAttractionsItem_Attractionsid ;
   protected String gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname ;
}

