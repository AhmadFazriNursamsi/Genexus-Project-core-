package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCountry_City extends GxSilentTrnSdt
{
   public SdtCountry_City( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCountry_City.class));
   }

   public SdtCountry_City( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle, context, "SdtCountry_City");
      initialize( remoteHandle) ;
   }

   public SdtCountry_City( int remoteHandle ,
                           StructSdtCountry_City struct )
   {
      this(remoteHandle);
      setStruct(struct);
   }

   public SdtCountry_City( )
   {
      super( new ModelContext(SdtCountry_City.class), "SdtCountry_City");
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
      return (Object[][])(new Object[][]{new Object[]{"CountryCityId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "City");
      metadata.set("BT", "CountryCity");
      metadata.set("PK", "[ \"CountryCityId\" ]");
      metadata.set("FKList", "[ { \"FK\":[ \"CountryId\" ],\"FKMap\":[  ] } ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CountryCityId") )
            {
               gxTv_SdtCountry_City_Countrycityid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CountryCityName") )
            {
               gxTv_SdtCountry_City_Countrycityname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCountry_City_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Modified") )
            {
               gxTv_SdtCountry_City_Modified = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCountry_City_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CountryCityId_Z") )
            {
               gxTv_SdtCountry_City_Countrycityid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CountryCityName_Z") )
            {
               gxTv_SdtCountry_City_Countrycityname_Z = oReader.getValue() ;
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
         sName = "Country.City" ;
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
      oWriter.writeElement("CountryCityId", GXutil.trim( GXutil.str( gxTv_SdtCountry_City_Countrycityid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      oWriter.writeElement("CountryCityName", gxTv_SdtCountry_City_Countrycityname);
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtCountry_City_Mode);
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("Modified", GXutil.trim( GXutil.str( gxTv_SdtCountry_City_Modified, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCountry_City_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("CountryCityId_Z", GXutil.trim( GXutil.str( gxTv_SdtCountry_City_Countrycityid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("CountryCityName_Z", gxTv_SdtCountry_City_Countrycityname_Z);
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
      AddObjectProperty("CountryCityId", gxTv_SdtCountry_City_Countrycityid, false, includeNonInitialized);
      AddObjectProperty("CountryCityName", gxTv_SdtCountry_City_Countrycityname, false, includeNonInitialized);
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCountry_City_Mode, false, includeNonInitialized);
         AddObjectProperty("Modified", gxTv_SdtCountry_City_Modified, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCountry_City_Initialized, false, includeNonInitialized);
         AddObjectProperty("CountryCityId_Z", gxTv_SdtCountry_City_Countrycityid_Z, false, includeNonInitialized);
         AddObjectProperty("CountryCityName_Z", gxTv_SdtCountry_City_Countrycityname_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.kbbaru.SdtCountry_City sdt )
   {
      if ( sdt.IsDirty("CountryCityId") )
      {
         gxTv_SdtCountry_City_N = (byte)(0) ;
         gxTv_SdtCountry_City_Countrycityid = sdt.getgxTv_SdtCountry_City_Countrycityid() ;
      }
      if ( sdt.IsDirty("CountryCityName") )
      {
         gxTv_SdtCountry_City_N = (byte)(0) ;
         gxTv_SdtCountry_City_Countrycityname = sdt.getgxTv_SdtCountry_City_Countrycityname() ;
      }
   }

   public short getgxTv_SdtCountry_City_Countrycityid( )
   {
      return gxTv_SdtCountry_City_Countrycityid ;
   }

   public void setgxTv_SdtCountry_City_Countrycityid( short value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Modified = (short)(1) ;
      SetDirty("Countrycityid");
      gxTv_SdtCountry_City_Countrycityid = value ;
   }

   public String getgxTv_SdtCountry_City_Countrycityname( )
   {
      return gxTv_SdtCountry_City_Countrycityname ;
   }

   public void setgxTv_SdtCountry_City_Countrycityname( String value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Modified = (short)(1) ;
      SetDirty("Countrycityname");
      gxTv_SdtCountry_City_Countrycityname = value ;
   }

   public String getgxTv_SdtCountry_City_Mode( )
   {
      return gxTv_SdtCountry_City_Mode ;
   }

   public void setgxTv_SdtCountry_City_Mode( String value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCountry_City_Mode = value ;
   }

   public void setgxTv_SdtCountry_City_Mode_SetNull( )
   {
      gxTv_SdtCountry_City_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtCountry_City_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCountry_City_Modified( )
   {
      return gxTv_SdtCountry_City_Modified ;
   }

   public void setgxTv_SdtCountry_City_Modified( short value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      SetDirty("Modified");
      gxTv_SdtCountry_City_Modified = value ;
   }

   public void setgxTv_SdtCountry_City_Modified_SetNull( )
   {
      gxTv_SdtCountry_City_Modified = (short)(0) ;
      SetDirty("Modified");
   }

   public boolean getgxTv_SdtCountry_City_Modified_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCountry_City_Initialized( )
   {
      return gxTv_SdtCountry_City_Initialized ;
   }

   public void setgxTv_SdtCountry_City_Initialized( short value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Modified = (short)(1) ;
      SetDirty("Initialized");
      gxTv_SdtCountry_City_Initialized = value ;
   }

   public void setgxTv_SdtCountry_City_Initialized_SetNull( )
   {
      gxTv_SdtCountry_City_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtCountry_City_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCountry_City_Countrycityid_Z( )
   {
      return gxTv_SdtCountry_City_Countrycityid_Z ;
   }

   public void setgxTv_SdtCountry_City_Countrycityid_Z( short value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Modified = (short)(1) ;
      SetDirty("Countrycityid_Z");
      gxTv_SdtCountry_City_Countrycityid_Z = value ;
   }

   public void setgxTv_SdtCountry_City_Countrycityid_Z_SetNull( )
   {
      gxTv_SdtCountry_City_Countrycityid_Z = (short)(0) ;
      SetDirty("Countrycityid_Z");
   }

   public boolean getgxTv_SdtCountry_City_Countrycityid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCountry_City_Countrycityname_Z( )
   {
      return gxTv_SdtCountry_City_Countrycityname_Z ;
   }

   public void setgxTv_SdtCountry_City_Countrycityname_Z( String value )
   {
      gxTv_SdtCountry_City_N = (byte)(0) ;
      gxTv_SdtCountry_City_Modified = (short)(1) ;
      SetDirty("Countrycityname_Z");
      gxTv_SdtCountry_City_Countrycityname_Z = value ;
   }

   public void setgxTv_SdtCountry_City_Countrycityname_Z_SetNull( )
   {
      gxTv_SdtCountry_City_Countrycityname_Z = "" ;
      SetDirty("Countrycityname_Z");
   }

   public boolean getgxTv_SdtCountry_City_Countrycityname_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
   }

   public void initialize( )
   {
      gxTv_SdtCountry_City_N = (byte)(1) ;
      gxTv_SdtCountry_City_Countrycityname = "" ;
      gxTv_SdtCountry_City_Mode = "" ;
      gxTv_SdtCountry_City_Countrycityname_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCountry_City_N ;
   }

   public com.kbbaru.SdtCountry_City Clone( )
   {
      return (com.kbbaru.SdtCountry_City)(clone()) ;
   }

   public void setStruct( com.kbbaru.StructSdtCountry_City struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtCountry_City_Countrycityid(struct.getCountrycityid());
         setgxTv_SdtCountry_City_Countrycityname(struct.getCountrycityname());
         setgxTv_SdtCountry_City_Mode(struct.getMode());
         setgxTv_SdtCountry_City_Modified(struct.getModified());
         setgxTv_SdtCountry_City_Initialized(struct.getInitialized());
         setgxTv_SdtCountry_City_Countrycityid_Z(struct.getCountrycityid_Z());
         setgxTv_SdtCountry_City_Countrycityname_Z(struct.getCountrycityname_Z());
      }
   }

   @SuppressWarnings("unchecked")
   public com.kbbaru.StructSdtCountry_City getStruct( )
   {
      com.kbbaru.StructSdtCountry_City struct = new com.kbbaru.StructSdtCountry_City ();
      struct.setCountrycityid(getgxTv_SdtCountry_City_Countrycityid());
      struct.setCountrycityname(getgxTv_SdtCountry_City_Countrycityname());
      struct.setMode(getgxTv_SdtCountry_City_Mode());
      struct.setModified(getgxTv_SdtCountry_City_Modified());
      struct.setInitialized(getgxTv_SdtCountry_City_Initialized());
      struct.setCountrycityid_Z(getgxTv_SdtCountry_City_Countrycityid_Z());
      struct.setCountrycityname_Z(getgxTv_SdtCountry_City_Countrycityname_Z());
      return struct ;
   }

   private byte gxTv_SdtCountry_City_N ;
   private short gxTv_SdtCountry_City_Countrycityid ;
   private short gxTv_SdtCountry_City_Modified ;
   private short gxTv_SdtCountry_City_Initialized ;
   private short gxTv_SdtCountry_City_Countrycityid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtCountry_City_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtCountry_City_Countrycityname ;
   private String gxTv_SdtCountry_City_Countrycityname_Z ;
}

