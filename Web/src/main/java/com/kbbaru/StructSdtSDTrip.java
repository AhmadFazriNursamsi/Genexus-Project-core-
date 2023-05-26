package com.kbbaru ;
import com.genexus.*;

public final  class StructSdtSDTrip implements Cloneable, java.io.Serializable
{
   public StructSdtSDTrip( )
   {
      this( -1, new ModelContext( StructSdtSDTrip.class ));
   }

   public StructSdtSDTrip( int remoteHandle ,
                           ModelContext context )
   {
      java.util.Calendar cal = java.util.Calendar.getInstance();
      cal.set(1, 0, 1, 0, 0, 0);
      cal.set(java.util.Calendar.MILLISECOND, 0);
      gxTv_SdtSDTrip_Tripdate = cal.getTime() ;
      gxTv_SdtSDTrip_Tripdescription = "" ;
      gxTv_SdtSDTrip_Tripdate_N = (byte)(1) ;
      gxTv_SdtSDTrip_Tripattractions_N = (byte)(1) ;
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

   public short getTripid( )
   {
      return gxTv_SdtSDTrip_Tripid ;
   }

   public void setTripid( short value )
   {
      gxTv_SdtSDTrip_N = (byte)(0) ;
      gxTv_SdtSDTrip_Tripid = value ;
   }

   public java.util.Date getTripdate( )
   {
      return gxTv_SdtSDTrip_Tripdate ;
   }

   public void setTripdate( java.util.Date value )
   {
      gxTv_SdtSDTrip_Tripdate_N = (byte)(0) ;
      gxTv_SdtSDTrip_N = (byte)(0) ;
      gxTv_SdtSDTrip_Tripdate = value ;
   }

   public String getTripdescription( )
   {
      return gxTv_SdtSDTrip_Tripdescription ;
   }

   public void setTripdescription( String value )
   {
      gxTv_SdtSDTrip_N = (byte)(0) ;
      gxTv_SdtSDTrip_Tripdescription = value ;
   }

   public java.util.Vector<com.kbbaru.StructSdtSDTrip_TripAttractionsItem> getTripattractions( )
   {
      return gxTv_SdtSDTrip_Tripattractions ;
   }

   public void setTripattractions( java.util.Vector<com.kbbaru.StructSdtSDTrip_TripAttractionsItem> value )
   {
      gxTv_SdtSDTrip_Tripattractions_N = (byte)(0) ;
      gxTv_SdtSDTrip_N = (byte)(0) ;
      gxTv_SdtSDTrip_Tripattractions = value ;
   }

   protected byte gxTv_SdtSDTrip_Tripdate_N ;
   protected byte gxTv_SdtSDTrip_Tripattractions_N ;
   protected byte gxTv_SdtSDTrip_N ;
   protected short gxTv_SdtSDTrip_Tripid ;
   protected String gxTv_SdtSDTrip_Tripdescription ;
   protected java.util.Date gxTv_SdtSDTrip_Tripdate ;
   protected java.util.Vector<com.kbbaru.StructSdtSDTrip_TripAttractionsItem> gxTv_SdtSDTrip_Tripattractions=null ;
}

