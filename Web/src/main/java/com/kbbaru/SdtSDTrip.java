package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTrip extends GxUserType
{
   public SdtSDTrip( )
   {
      this(  new ModelContext(SdtSDTrip.class));
   }

   public SdtSDTrip( ModelContext context )
   {
      super( context, "SdtSDTrip");
   }

   public SdtSDTrip( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTrip");
   }

   public SdtSDTrip( StructSdtSDTrip struct )
   {
      this();
      setStruct(struct);
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public short readxml( com.genexus.xml.XMLReader oReader ,
                         String sName )
   {
      short GXSoapError = 1;
      formatError = false ;
      sTagName = oReader.getName() ;
      if ( oReader.getIsSimple() == 0 )
      {
         GXSoapError = oReader.read() ;
         nOutParmCount = (short)(0) ;
         while ( ( ( GXutil.strcmp(oReader.getName(), sTagName) != 0 ) || ( oReader.getNodeType() == 1 ) ) && ( GXSoapError > 0 ) )
         {
            readOk = (short)(0) ;
            readElement = false ;
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripId") )
            {
               gxTv_SdtSDTrip_Tripid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripDate") )
            {
               if ( ( GXutil.strcmp(oReader.getValue(), "") == 0 ) || ( oReader.existsAttribute("xsi:nil") == 1 ) )
               {
                  gxTv_SdtSDTrip_Tripdate = GXutil.nullDate() ;
                  gxTv_SdtSDTrip_Tripdate_N = (byte)(1) ;
               }
               else
               {
                  gxTv_SdtSDTrip_Tripdate_N = (byte)(0) ;
                  gxTv_SdtSDTrip_Tripdate = localUtil.ymdtod( (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 1, 4), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 6, 2), "."))), (int)(DecimalUtil.decToDouble(CommonUtil.decimalVal( GXutil.substring( oReader.getValue(), 9, 2), ".")))) ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripDescription") )
            {
               gxTv_SdtSDTrip_Tripdescription = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "TripAttractions") )
            {
               if ( gxTv_SdtSDTrip_Tripattractions == null )
               {
                  gxTv_SdtSDTrip_Tripattractions = new GXBaseCollection<com.kbbaru.SdtSDTrip_TripAttractionsItem>(com.kbbaru.SdtSDTrip_TripAttractionsItem.class, "SDTrip.TripAttractionsItem", "KBBaru", remoteHandle);
               }
               if ( oReader.getIsSimple() == 0 )
               {
                  GXSoapError = gxTv_SdtSDTrip_Tripattractions.readxmlcollection(oReader, "TripAttractions", "TripAttractionsItem") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "TripAttractions") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( ! readElement )
            {
               readOk = (short)(1) ;
               GXSoapError = oReader.read() ;
            }
            nOutParmCount = (short)(nOutParmCount+1) ;
            if ( ( readOk == 0 ) || formatError )
            {
               context.globals.sSOAPErrMsg += "Error reading " + sTagName + GXutil.newLine( ) ;
               context.globals.sSOAPErrMsg += "Message: " + oReader.readRawXML() ;
               GXSoapError = (short)(nOutParmCount*-1) ;
            }
         }
      }
      return GXSoapError ;
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace )
   {
      writexml(oWriter, sName, sNameSpace, true);
   }

   public void writexml( com.genexus.xml.XMLWriter oWriter ,
                         String sName ,
                         String sNameSpace ,
                         boolean sIncludeState )
   {
      if ( (GXutil.strcmp("", sName)==0) )
      {
         sName = "SDTrip" ;
      }
      if ( (GXutil.strcmp("", sNameSpace)==0) )
      {
         sNameSpace = "KBBaru" ;
      }
      oWriter.writeStartElement(sName);
      if ( GXutil.strcmp(GXutil.left( sNameSpace, 10), "[*:nosend]") != 0 )
      {
         oWriter.writeAttribute("xmlns", sNameSpace);
      }
      else
      {
         sNameSpace = GXutil.right( sNameSpace, GXutil.len( sNameSpace)-10) ;
      }
      oWriter.writeElement("TripId", GXutil.trim( GXutil.str( gxTv_SdtSDTrip_Tripid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(gxTv_SdtSDTrip_Tripdate)) && ( gxTv_SdtSDTrip_Tripdate_N == 1 ) )
      {
         oWriter.writeElement("TripDate", "");
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
      }
      else
      {
         sDateCnv = "" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTrip_Tripdate), 10, 0)) ;
         sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTrip_Tripdate), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         sDateCnv += "-" ;
         sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTrip_Tripdate), 10, 0)) ;
         sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
         oWriter.writeElement("TripDate", sDateCnv);
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
      }
      oWriter.writeElement("TripDescription", gxTv_SdtSDTrip_Tripdescription);
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      if ( gxTv_SdtSDTrip_Tripattractions != null )
      {
         String sNameSpace1;
         if ( GXutil.strcmp(sNameSpace, "KBBaru") == 0 )
         {
            sNameSpace1 = "[*:nosend]" + "KBBaru" ;
         }
         else
         {
            sNameSpace1 = "KBBaru" ;
         }
         gxTv_SdtSDTrip_Tripattractions.writexmlcollection(oWriter, "TripAttractions", sNameSpace1, "TripAttractionsItem", sNameSpace1);
      }
      oWriter.writeEndElement();
   }

   public long getnumericvalue( String value )
   {
      if ( GXutil.notNumeric( value) )
      {
         formatError = true ;
      }
      return GXutil.lval( value) ;
   }

   public void tojson( )
   {
      tojson( true) ;
   }

   public void tojson( boolean includeState )
   {
      tojson( includeState, true) ;
   }

   public void tojson( boolean includeState ,
                       boolean includeNonInitialized )
   {
      AddObjectProperty("TripId", gxTv_SdtSDTrip_Tripid, false, false);
      sDateCnv = "" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.year( gxTv_SdtSDTrip_Tripdate), 10, 0)) ;
      sDateCnv += GXutil.substring( "0000", 1, 4-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.month( gxTv_SdtSDTrip_Tripdate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      sDateCnv += "-" ;
      sNumToPad = GXutil.trim( GXutil.str( GXutil.day( gxTv_SdtSDTrip_Tripdate), 10, 0)) ;
      sDateCnv += GXutil.substring( "00", 1, 2-GXutil.len( sNumToPad)) + sNumToPad ;
      AddObjectProperty("TripDate", sDateCnv, false, false);
      AddObjectProperty("TripDescription", gxTv_SdtSDTrip_Tripdescription, false, false);
      if ( gxTv_SdtSDTrip_Tripattractions != null )
      {
         AddObjectProperty("TripAttractions", gxTv_SdtSDTrip_Tripattractions, false, false);
      }
   }

   public short getgxTv_SdtSDTrip_Tripid( )
   {
      return gxTv_SdtSDTrip_Tripid ;
   }

   public void setgxTv_SdtSDTrip_Tripid( short value )
   {
      gxTv_SdtSDTrip_N = (byte)(0) ;
      gxTv_SdtSDTrip_Tripid = value ;
   }

   public java.util.Date getgxTv_SdtSDTrip_Tripdate( )
   {
      return gxTv_SdtSDTrip_Tripdate ;
   }

   public void setgxTv_SdtSDTrip_Tripdate( java.util.Date value )
   {
      gxTv_SdtSDTrip_Tripdate_N = (byte)(0) ;
      gxTv_SdtSDTrip_N = (byte)(0) ;
      gxTv_SdtSDTrip_Tripdate = value ;
   }

   public String getgxTv_SdtSDTrip_Tripdescription( )
   {
      return gxTv_SdtSDTrip_Tripdescription ;
   }

   public void setgxTv_SdtSDTrip_Tripdescription( String value )
   {
      gxTv_SdtSDTrip_N = (byte)(0) ;
      gxTv_SdtSDTrip_Tripdescription = value ;
   }

   public GXBaseCollection<com.kbbaru.SdtSDTrip_TripAttractionsItem> getgxTv_SdtSDTrip_Tripattractions( )
   {
      if ( gxTv_SdtSDTrip_Tripattractions == null )
      {
         gxTv_SdtSDTrip_Tripattractions = new GXBaseCollection<com.kbbaru.SdtSDTrip_TripAttractionsItem>(com.kbbaru.SdtSDTrip_TripAttractionsItem.class, "SDTrip.TripAttractionsItem", "KBBaru", remoteHandle);
      }
      gxTv_SdtSDTrip_Tripattractions_N = (byte)(0) ;
      gxTv_SdtSDTrip_N = (byte)(0) ;
      return gxTv_SdtSDTrip_Tripattractions ;
   }

   public void setgxTv_SdtSDTrip_Tripattractions( GXBaseCollection<com.kbbaru.SdtSDTrip_TripAttractionsItem> value )
   {
      gxTv_SdtSDTrip_Tripattractions_N = (byte)(0) ;
      gxTv_SdtSDTrip_N = (byte)(0) ;
      gxTv_SdtSDTrip_Tripattractions = value ;
   }

   public void setgxTv_SdtSDTrip_Tripattractions_SetNull( )
   {
      gxTv_SdtSDTrip_Tripattractions_N = (byte)(1) ;
      gxTv_SdtSDTrip_Tripattractions = null ;
   }

   public boolean getgxTv_SdtSDTrip_Tripattractions_IsNull( )
   {
      if ( gxTv_SdtSDTrip_Tripattractions == null )
      {
         return true ;
      }
      return false ;
   }

   public byte getgxTv_SdtSDTrip_Tripattractions_N( )
   {
      return gxTv_SdtSDTrip_Tripattractions_N ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTrip_N = (byte)(1) ;
      gxTv_SdtSDTrip_Tripdate = GXutil.nullDate() ;
      gxTv_SdtSDTrip_Tripdate_N = (byte)(1) ;
      gxTv_SdtSDTrip_Tripdescription = "" ;
      gxTv_SdtSDTrip_Tripattractions_N = (byte)(1) ;
      sTagName = "" ;
      sDateCnv = "" ;
      sNumToPad = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTrip_N ;
   }

   public com.kbbaru.SdtSDTrip Clone( )
   {
      return (com.kbbaru.SdtSDTrip)(clone()) ;
   }

   public void setStruct( com.kbbaru.StructSdtSDTrip struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtSDTrip_Tripid(struct.getTripid());
         if ( struct.gxTv_SdtSDTrip_Tripdate_N == 0 )
         {
            setgxTv_SdtSDTrip_Tripdate(struct.getTripdate());
         }
         setgxTv_SdtSDTrip_Tripdescription(struct.getTripdescription());
         GXBaseCollection<com.kbbaru.SdtSDTrip_TripAttractionsItem> gxTv_SdtSDTrip_Tripattractions_aux = new GXBaseCollection<com.kbbaru.SdtSDTrip_TripAttractionsItem>(com.kbbaru.SdtSDTrip_TripAttractionsItem.class, "SDTrip.TripAttractionsItem", "KBBaru", remoteHandle);
         Vector<com.kbbaru.StructSdtSDTrip_TripAttractionsItem> gxTv_SdtSDTrip_Tripattractions_aux1 = struct.getTripattractions();
         if (gxTv_SdtSDTrip_Tripattractions_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtSDTrip_Tripattractions_aux1.size(); i++)
            {
               gxTv_SdtSDTrip_Tripattractions_aux.add(new com.kbbaru.SdtSDTrip_TripAttractionsItem(gxTv_SdtSDTrip_Tripattractions_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtSDTrip_Tripattractions(gxTv_SdtSDTrip_Tripattractions_aux);
      }
   }

   @SuppressWarnings("unchecked")
   public com.kbbaru.StructSdtSDTrip getStruct( )
   {
      com.kbbaru.StructSdtSDTrip struct = new com.kbbaru.StructSdtSDTrip ();
      struct.setTripid(getgxTv_SdtSDTrip_Tripid());
      if ( gxTv_SdtSDTrip_Tripdate_N == 0 )
      {
         struct.setTripdate(getgxTv_SdtSDTrip_Tripdate());
      }
      struct.setTripdescription(getgxTv_SdtSDTrip_Tripdescription());
      struct.setTripattractions(getgxTv_SdtSDTrip_Tripattractions().getStruct());
      return struct ;
   }

   protected byte gxTv_SdtSDTrip_N ;
   protected byte gxTv_SdtSDTrip_Tripdate_N ;
   protected byte gxTv_SdtSDTrip_Tripattractions_N ;
   protected short gxTv_SdtSDTrip_Tripid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected String sDateCnv ;
   protected String sNumToPad ;
   protected java.util.Date gxTv_SdtSDTrip_Tripdate ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTrip_Tripdescription ;
   protected GXBaseCollection<com.kbbaru.SdtSDTrip_TripAttractionsItem> gxTv_SdtSDTrip_Tripattractions_aux ;
   protected GXBaseCollection<com.kbbaru.SdtSDTrip_TripAttractionsItem> gxTv_SdtSDTrip_Tripattractions=null ;
}

