package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtTrips_Attrations extends GxSilentTrnSdt
{
   public SdtTrips_Attrations( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtTrips_Attrations.class));
   }

   public SdtTrips_Attrations( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle, context, "SdtTrips_Attrations");
      initialize( remoteHandle) ;
   }

   public SdtTrips_Attrations( int remoteHandle ,
                               StructSdtTrips_Attrations struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtTrips_Attrations( )
   {
      super( new ModelContext(SdtTrips_Attrations.class), "SdtTrips_Attrations");
      initialize( ) ;
   }

   private static java.util.HashMap mapper = new java.util.HashMap();
   static
   {
   }

   public String getJsonMap( String value )
   {
      return (String) mapper.get(value);
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"AttractionsId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Attrations");
      metadata.set("BT", "TripsAttrations");
      metadata.set("PK", "[ \"AttractionsId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"AttractionsId\" ],\"FKMap\":[  ] },{ \"FK\":[ \"TripsId\" ],\"FKMap\":[  ] } ]");
      metadata.set("AllowInsert", "True");
      metadata.set("AllowUpdate", "True");
      metadata.set("AllowDelete", "True");
      return metadata ;
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
               gxTv_SdtTrips_Attrations_Attractionsid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AttractionsName") )
            {
               gxTv_SdtTrips_Attrations_Attractionsname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtTrips_Attrations_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtTrips_Attrations_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtTrips_Attrations_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AttractionsId_Z") )
            {
               gxTv_SdtTrips_Attrations_Attractionsid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "AttractionsName_Z") )
            {
               gxTv_SdtTrips_Attrations_Attractionsname_Z = oReader.getValue() ;
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
         sName = "Trips.Attrations" ;
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
      oWriter.writeElement("AttractionsId", GXutil.trim( GXutil.str( gxTv_SdtTrips_Attrations_Attractionsid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      oWriter.writeElement("AttractionsName", gxTv_SdtTrips_Attrations_Attractionsname);
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtTrips_Attrations_Mode);
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtTrips_Attrations_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtTrips_Attrations_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("AttractionsId_Z", GXutil.trim( GXutil.str( gxTv_SdtTrips_Attrations_Attractionsid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("AttractionsName_Z", gxTv_SdtTrips_Attrations_Attractionsname_Z);
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
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
      AddObjectProperty("AttractionsId", gxTv_SdtTrips_Attrations_Attractionsid, false, includeNonInitialized);
      AddObjectProperty("AttractionsName", gxTv_SdtTrips_Attrations_Attractionsname, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtTrips_Attrations_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtTrips_Attrations_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtTrips_Attrations_Initialized, false, includeNonInitialized);
         AddObjectProperty("AttractionsId_Z", gxTv_SdtTrips_Attrations_Attractionsid_Z, false, includeNonInitialized);
         AddObjectProperty("AttractionsName_Z", gxTv_SdtTrips_Attrations_Attractionsname_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.kbbaru.SdtTrips_Attrations sdt )
   {
      if ( sdt.IsDirty("AttractionsId") )
      {
         gxTv_SdtTrips_Attrations_N = (byte)(0) ;
         gxTv_SdtTrips_Attrations_Attractionsid = sdt.getgxTv_SdtTrips_Attrations_Attractionsid() ;
      }
      if ( sdt.IsDirty("AttractionsName") )
      {
         gxTv_SdtTrips_Attrations_N = (byte)(0) ;
         gxTv_SdtTrips_Attrations_Attractionsname = sdt.getgxTv_SdtTrips_Attrations_Attractionsname() ;
      }
   }

   public short getgxTv_SdtTrips_Attrations_Attractionsid( )
   {
      return gxTv_SdtTrips_Attrations_Attractionsid ;
   }

   public void setgxTv_SdtTrips_Attrations_Attractionsid( short value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Modified = (short)(1) ;
      SetDirty("Attractionsid");
      gxTv_SdtTrips_Attrations_Attractionsid = value ;
   }

   public String getgxTv_SdtTrips_Attrations_Attractionsname( )
   {
      return gxTv_SdtTrips_Attrations_Attractionsname ;
   }

   public void setgxTv_SdtTrips_Attrations_Attractionsname( String value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Modified = (short)(1) ;
      SetDirty("Attractionsname");
      gxTv_SdtTrips_Attrations_Attractionsname = value ;
   }

   public String getgxTv_SdtTrips_Attrations_Mode( )
   {
      return gxTv_SdtTrips_Attrations_Mode ;
   }

   public void setgxTv_SdtTrips_Attrations_Mode( String value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtTrips_Attrations_Mode = value ;
   }

   public void setgxTv_SdtTrips_Attrations_Mode_SetNull( )
   {
      gxTv_SdtTrips_Attrations_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtTrips_Attrations_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtTrips_Attrations_Modified( )
   {
      return gxTv_SdtTrips_Attrations_Modified ;
   }

   public void setgxTv_SdtTrips_Attrations_Modified( short value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtTrips_Attrations_Modified = value ;
   }

   public void setgxTv_SdtTrips_Attrations_Modified_SetNull( )
   {
      gxTv_SdtTrips_Attrations_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtTrips_Attrations_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtTrips_Attrations_Initialized( )
   {
      return gxTv_SdtTrips_Attrations_Initialized ;
   }

   public void setgxTv_SdtTrips_Attrations_Initialized( short value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtTrips_Attrations_Initialized = value ;
   }

   public void setgxTv_SdtTrips_Attrations_Initialized_SetNull( )
   {
      gxTv_SdtTrips_Attrations_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtTrips_Attrations_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtTrips_Attrations_Attractionsid_Z( )
   {
      return gxTv_SdtTrips_Attrations_Attractionsid_Z ;
   }

   public void setgxTv_SdtTrips_Attrations_Attractionsid_Z( short value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Modified = (short)(1) ;
      SetDirty("Attractionsid_Z");
      gxTv_SdtTrips_Attrations_Attractionsid_Z = value ;
   }

   public void setgxTv_SdtTrips_Attrations_Attractionsid_Z_SetNull( )
   {
      gxTv_SdtTrips_Attrations_Attractionsid_Z = (short)(0) ;
      SetDirty("Attractionsid_Z");
   }

   public boolean getgxTv_SdtTrips_Attrations_Attractionsid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtTrips_Attrations_Attractionsname_Z( )
   {
      return gxTv_SdtTrips_Attrations_Attractionsname_Z ;
   }

   public void setgxTv_SdtTrips_Attrations_Attractionsname_Z( String value )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(0) ;
      gxTv_SdtTrips_Attrations_Modified = (short)(1) ;
      SetDirty("Attractionsname_Z");
      gxTv_SdtTrips_Attrations_Attractionsname_Z = value ;
   }

   public void setgxTv_SdtTrips_Attrations_Attractionsname_Z_SetNull( )
   {
      gxTv_SdtTrips_Attrations_Attractionsname_Z = "" ;
      SetDirty("Attractionsname_Z");
   }

   public boolean getgxTv_SdtTrips_Attrations_Attractionsname_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtTrips_Attrations_N = (byte)(1) ;
      gxTv_SdtTrips_Attrations_Attractionsname = "" ;
      gxTv_SdtTrips_Attrations_Mode = "" ;
      gxTv_SdtTrips_Attrations_Attractionsname_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtTrips_Attrations_N ;
   }

   public com.kbbaru.SdtTrips_Attrations Clone( )
   {
      return (com.kbbaru.SdtTrips_Attrations)(clone()) ;
   }

   public void setStruct( com.kbbaru.StructSdtTrips_Attrations struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtTrips_Attrations_Attractionsid(struct.getAttractionsid());
         setgxTv_SdtTrips_Attrations_Attractionsname(struct.getAttractionsname());
         setgxTv_SdtTrips_Attrations_Mode(struct.getMode());
         setgxTv_SdtTrips_Attrations_Modified(struct.getModified());
         setgxTv_SdtTrips_Attrations_Initialized(struct.getInitialized());
         setgxTv_SdtTrips_Attrations_Attractionsid_Z(struct.getAttractionsid_Z());
         setgxTv_SdtTrips_Attrations_Attractionsname_Z(struct.getAttractionsname_Z());
      }
   }

   @SuppressWarnings("unchecked")
   public com.kbbaru.StructSdtTrips_Attrations getStruct( )
   {
      com.kbbaru.StructSdtTrips_Attrations struct = new com.kbbaru.StructSdtTrips_Attrations ();
      struct.setAttractionsid(getgxTv_SdtTrips_Attrations_Attractionsid());
      struct.setAttractionsname(getgxTv_SdtTrips_Attrations_Attractionsname());
      struct.setMode(getgxTv_SdtTrips_Attrations_Mode());
      struct.setModified(getgxTv_SdtTrips_Attrations_Modified());
      struct.setInitialized(getgxTv_SdtTrips_Attrations_Initialized());
      struct.setAttractionsid_Z(getgxTv_SdtTrips_Attrations_Attractionsid_Z());
      struct.setAttractionsname_Z(getgxTv_SdtTrips_Attrations_Attractionsname_Z());
      return struct ;
   }

   private byte gxTv_SdtTrips_Attrations_N ;
   private short gxTv_SdtTrips_Attrations_Attractionsid ;
   private short gxTv_SdtTrips_Attrations_Modified ;
   private short gxTv_SdtTrips_Attrations_Initialized ;
   private short gxTv_SdtTrips_Attrations_Attractionsid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtTrips_Attrations_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtTrips_Attrations_Attractionsname ;
   private String gxTv_SdtTrips_Attrations_Attractionsname_Z ;
}

