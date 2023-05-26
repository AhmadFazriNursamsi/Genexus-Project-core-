package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtSDTrip_TripAttractionsItem extends GxUserType
{
   public SdtSDTrip_TripAttractionsItem( )
   {
      this(  new ModelContext(SdtSDTrip_TripAttractionsItem.class));
   }

   public SdtSDTrip_TripAttractionsItem( ModelContext context )
   {
      super( context, "SdtSDTrip_TripAttractionsItem");
   }

   public SdtSDTrip_TripAttractionsItem( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle, context, "SdtSDTrip_TripAttractionsItem");
   }

   public SdtSDTrip_TripAttractionsItem( StructSdtSDTrip_TripAttractionsItem struct )
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "AttractionsId") )
            {
               gxTv_SdtSDTrip_TripAttractionsItem_Attractionsid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AttractionsName") )
            {
               gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
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
         sName = "SDTrip.TripAttractionsItem" ;
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
      oWriter.writeElement("AttractionsId", GXutil.trim( GXutil.str( gxTv_SdtSDTrip_TripAttractionsItem_Attractionsid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      oWriter.writeElement("AttractionsName", gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname);
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
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
      AddObjectProperty("AttractionsId", gxTv_SdtSDTrip_TripAttractionsItem_Attractionsid, false, false);
      AddObjectProperty("AttractionsName", gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname, false, false);
   }

   public short getgxTv_SdtSDTrip_TripAttractionsItem_Attractionsid( )
   {
      return gxTv_SdtSDTrip_TripAttractionsItem_Attractionsid ;
   }

   public void setgxTv_SdtSDTrip_TripAttractionsItem_Attractionsid( short value )
   {
      gxTv_SdtSDTrip_TripAttractionsItem_N = (byte)(0) ;
      gxTv_SdtSDTrip_TripAttractionsItem_Attractionsid = value ;
   }

   public String getgxTv_SdtSDTrip_TripAttractionsItem_Attractionsname( )
   {
      return gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname ;
   }

   public void setgxTv_SdtSDTrip_TripAttractionsItem_Attractionsname( String value )
   {
      gxTv_SdtSDTrip_TripAttractionsItem_N = (byte)(0) ;
      gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname = value ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtSDTrip_TripAttractionsItem_N = (byte)(1) ;
      gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtSDTrip_TripAttractionsItem_N ;
   }

   public com.kbbaru.SdtSDTrip_TripAttractionsItem Clone( )
   {
      return (com.kbbaru.SdtSDTrip_TripAttractionsItem)(clone()) ;
   }

   public void setStruct( com.kbbaru.StructSdtSDTrip_TripAttractionsItem struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtSDTrip_TripAttractionsItem_Attractionsid(struct.getAttractionsid());
         setgxTv_SdtSDTrip_TripAttractionsItem_Attractionsname(struct.getAttractionsname());
      }
   }

   @SuppressWarnings("unchecked")
   public com.kbbaru.StructSdtSDTrip_TripAttractionsItem getStruct( )
   {
      com.kbbaru.StructSdtSDTrip_TripAttractionsItem struct = new com.kbbaru.StructSdtSDTrip_TripAttractionsItem ();
      struct.setAttractionsid(getgxTv_SdtSDTrip_TripAttractionsItem_Attractionsid());
      struct.setAttractionsname(getgxTv_SdtSDTrip_TripAttractionsItem_Attractionsname());
      return struct ;
   }

   protected byte gxTv_SdtSDTrip_TripAttractionsItem_N ;
   protected short gxTv_SdtSDTrip_TripAttractionsItem_Attractionsid ;
   protected short readOk ;
   protected short nOutParmCount ;
   protected String sTagName ;
   protected boolean readElement ;
   protected boolean formatError ;
   protected String gxTv_SdtSDTrip_TripAttractionsItem_Attractionsname ;
}

