package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.xml.*;
import com.genexus.search.*;
import com.genexus.webpanels.*;
import java.util.*;

public final  class SdtCountry extends GxSilentTrnSdt
{
   public SdtCountry( int remoteHandle )
   {
      this( remoteHandle,  new ModelContext(SdtCountry.class));
   }

   public SdtCountry( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle, context, "SdtCountry");
      initialize( remoteHandle) ;
   }

   public SdtCountry( int remoteHandle ,
                      StructSdtCountry struct )
   {
      this(remoteHandle);
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

   public void Load( short AV5CountryId )
   {
      IGxSilentTrn obj;
      obj = getTransaction() ;
      obj.LoadKey(new Object[] {Short.valueOf(AV5CountryId)});
   }

   public Object[][] GetBCKey( )
   {
      return (Object[][])(new Object[][]{new Object[]{"CountryId", short.class}}) ;
   }

   public com.genexus.util.GXProperties getMetadata( )
   {
      com.genexus.util.GXProperties metadata = new com.genexus.util.GXProperties();
      metadata.set("Name", "Country");
      metadata.set("BT", "Country");
      metadata.set("PK", "[ \"CountryId\" ]");
      metadata.set("PKAssigned", "[ \"CountryId\" ]");
      metadata.set("Levels", "[ \"City\" ]");
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
            if ( GXutil.strcmp2( oReader.getLocalName(), "CountryId") )
            {
               gxTv_SdtCountry_Countryid = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CountryName") )
            {
               gxTv_SdtCountry_Countryname = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "City") )
            {
               if ( gxTv_SdtCountry_City == null )
               {
                  gxTv_SdtCountry_City = new GXBCLevelCollection<com.kbbaru.SdtCountry_City>(com.kbbaru.SdtCountry_City.class, "Country.City", "KBBaru", remoteHandle);
               }
               if ( ( oReader.getIsSimple() == 0 ) || ( oReader.getAttributeCount() > 0 ) )
               {
                  GXSoapError = gxTv_SdtCountry_City.readxml(oReader, "City") ;
               }
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               if ( GXutil.strcmp2( oReader.getLocalName(), "City") )
               {
                  GXSoapError = oReader.read() ;
               }
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Mode") )
            {
               gxTv_SdtCountry_Mode = oReader.getValue() ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "Initialized") )
            {
               gxTv_SdtCountry_Initialized = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CountryId_Z") )
            {
               gxTv_SdtCountry_Countryid_Z = (short)(getnumericvalue(oReader.getValue())) ;
               readElement = true ;
               if ( GXSoapError > 0 )
               {
                  readOk = (short)(1) ;
               }
               GXSoapError = oReader.read() ;
            }
            if ( GXutil.strcmp2( oReader.getLocalName(), "CountryName_Z") )
            {
               gxTv_SdtCountry_Countryname_Z = oReader.getValue() ;
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
         sName = "Country" ;
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
      oWriter.writeElement("CountryId", GXutil.trim( GXutil.str( gxTv_SdtCountry_Countryid, 4, 0)));
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      oWriter.writeElement("CountryName", gxTv_SdtCountry_Countryname);
      if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
      {
         oWriter.writeAttribute("xmlns", "KBBaru");
      }
      if ( gxTv_SdtCountry_City != null )
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
         gxTv_SdtCountry_City.writexml(oWriter, "City", sNameSpace1, sIncludeState);
      }
      if ( sIncludeState )
      {
         oWriter.writeElement("Mode", gxTv_SdtCountry_Mode);
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("Initialized", GXutil.trim( GXutil.str( gxTv_SdtCountry_Initialized, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("CountryId_Z", GXutil.trim( GXutil.str( gxTv_SdtCountry_Countryid_Z, 4, 0)));
         if ( GXutil.strcmp(sNameSpace, "KBBaru") != 0 )
         {
            oWriter.writeAttribute("xmlns", "KBBaru");
         }
         oWriter.writeElement("CountryName_Z", gxTv_SdtCountry_Countryname_Z);
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
      AddObjectProperty("CountryId", gxTv_SdtCountry_Countryid, false, includeNonInitialized);
      AddObjectProperty("CountryName", gxTv_SdtCountry_Countryname, false, includeNonInitialized);
      if ( gxTv_SdtCountry_City != null )
      {
         AddObjectProperty("City", gxTv_SdtCountry_City, includeState, includeNonInitialized);
      }
      if ( includeState )
      {
         AddObjectProperty("Mode", gxTv_SdtCountry_Mode, false, includeNonInitialized);
         AddObjectProperty("Initialized", gxTv_SdtCountry_Initialized, false, includeNonInitialized);
         AddObjectProperty("CountryId_Z", gxTv_SdtCountry_Countryid_Z, false, includeNonInitialized);
         AddObjectProperty("CountryName_Z", gxTv_SdtCountry_Countryname_Z, false, includeNonInitialized);
      }
   }

   public void updateDirties( com.kbbaru.SdtCountry sdt )
   {
      if ( sdt.IsDirty("CountryId") )
      {
         gxTv_SdtCountry_N = (byte)(0) ;
         gxTv_SdtCountry_Countryid = sdt.getgxTv_SdtCountry_Countryid() ;
      }
      if ( sdt.IsDirty("CountryName") )
      {
         gxTv_SdtCountry_N = (byte)(0) ;
         gxTv_SdtCountry_Countryname = sdt.getgxTv_SdtCountry_Countryname() ;
      }
      if ( gxTv_SdtCountry_City != null )
      {
         GXBCLevelCollection<com.kbbaru.SdtCountry_City> newCollectionCity = sdt.getgxTv_SdtCountry_City();
         com.kbbaru.SdtCountry_City currItemCity;
         com.kbbaru.SdtCountry_City newItemCity;
         short idx = 1;
         while ( idx <= newCollectionCity.size() )
         {
            newItemCity = (com.kbbaru.SdtCountry_City)((com.kbbaru.SdtCountry_City)newCollectionCity.elementAt(-1+idx));
            currItemCity = (com.kbbaru.SdtCountry_City)gxTv_SdtCountry_City.getByKey(newItemCity.getgxTv_SdtCountry_City_Countrycityid());
            if ( GXutil.strcmp(currItemCity.getgxTv_SdtCountry_City_Mode(), "UPD") == 0 )
            {
               currItemCity.updateDirties(newItemCity);
               if ( GXutil.strcmp(newItemCity.getgxTv_SdtCountry_City_Mode(), "DLT") == 0 )
               {
                  currItemCity.setgxTv_SdtCountry_City_Mode( "DLT" );
               }
               currItemCity.setgxTv_SdtCountry_City_Modified( (short)(1) );
            }
            else
            {
               gxTv_SdtCountry_City.add(newItemCity, 0);
            }
            idx = (short)(idx+1) ;
         }
      }
   }

   public short getgxTv_SdtCountry_Countryid( )
   {
      return gxTv_SdtCountry_Countryid ;
   }

   public void setgxTv_SdtCountry_Countryid( short value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      if ( gxTv_SdtCountry_Countryid != value )
      {
         gxTv_SdtCountry_Mode = "INS" ;
         this.setgxTv_SdtCountry_Countryid_Z_SetNull( );
         this.setgxTv_SdtCountry_Countryname_Z_SetNull( );
         if ( gxTv_SdtCountry_City != null )
         {
            GXBCLevelCollection<com.kbbaru.SdtCountry_City> collectionCity = gxTv_SdtCountry_City;
            com.kbbaru.SdtCountry_City currItemCity;
            short idx = 1;
            while ( idx <= collectionCity.size() )
            {
               currItemCity = (com.kbbaru.SdtCountry_City)((com.kbbaru.SdtCountry_City)collectionCity.elementAt(-1+idx));
               currItemCity.setgxTv_SdtCountry_City_Mode( "INS" );
               currItemCity.setgxTv_SdtCountry_City_Modified( (short)(1) );
               idx = (short)(idx+1) ;
            }
         }
      }
      SetDirty("Countryid");
      gxTv_SdtCountry_Countryid = value ;
   }

   public String getgxTv_SdtCountry_Countryname( )
   {
      return gxTv_SdtCountry_Countryname ;
   }

   public void setgxTv_SdtCountry_Countryname( String value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      SetDirty("Countryname");
      gxTv_SdtCountry_Countryname = value ;
   }

   public GXBCLevelCollection<com.kbbaru.SdtCountry_City> getgxTv_SdtCountry_City( )
   {
      if ( gxTv_SdtCountry_City == null )
      {
         gxTv_SdtCountry_City = new GXBCLevelCollection<com.kbbaru.SdtCountry_City>(com.kbbaru.SdtCountry_City.class, "Country.City", "KBBaru", remoteHandle);
      }
      gxTv_SdtCountry_N = (byte)(0) ;
      return gxTv_SdtCountry_City ;
   }

   public void setgxTv_SdtCountry_City( GXBCLevelCollection<com.kbbaru.SdtCountry_City> value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      SetDirty("City");
      gxTv_SdtCountry_City = value ;
   }

   public void setgxTv_SdtCountry_City_SetNull( )
   {
      gxTv_SdtCountry_City = null ;
      SetDirty("City");
   }

   public boolean getgxTv_SdtCountry_City_IsNull( )
   {
      if ( gxTv_SdtCountry_City == null )
      {
         return true ;
      }
      return false ;
   }

   public String getgxTv_SdtCountry_Mode( )
   {
      return gxTv_SdtCountry_Mode ;
   }

   public void setgxTv_SdtCountry_Mode( String value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      SetDirty("Mode");
      gxTv_SdtCountry_Mode = value ;
   }

   public void setgxTv_SdtCountry_Mode_SetNull( )
   {
      gxTv_SdtCountry_Mode = "" ;
      SetDirty("Mode");
   }

   public boolean getgxTv_SdtCountry_Mode_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCountry_Initialized( )
   {
      return gxTv_SdtCountry_Initialized ;
   }

   public void setgxTv_SdtCountry_Initialized( short value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      SetDirty("Initialized");
      gxTv_SdtCountry_Initialized = value ;
   }

   public void setgxTv_SdtCountry_Initialized_SetNull( )
   {
      gxTv_SdtCountry_Initialized = (short)(0) ;
      SetDirty("Initialized");
   }

   public boolean getgxTv_SdtCountry_Initialized_IsNull( )
   {
      return false ;
   }

   public short getgxTv_SdtCountry_Countryid_Z( )
   {
      return gxTv_SdtCountry_Countryid_Z ;
   }

   public void setgxTv_SdtCountry_Countryid_Z( short value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      SetDirty("Countryid_Z");
      gxTv_SdtCountry_Countryid_Z = value ;
   }

   public void setgxTv_SdtCountry_Countryid_Z_SetNull( )
   {
      gxTv_SdtCountry_Countryid_Z = (short)(0) ;
      SetDirty("Countryid_Z");
   }

   public boolean getgxTv_SdtCountry_Countryid_Z_IsNull( )
   {
      return false ;
   }

   public String getgxTv_SdtCountry_Countryname_Z( )
   {
      return gxTv_SdtCountry_Countryname_Z ;
   }

   public void setgxTv_SdtCountry_Countryname_Z( String value )
   {
      gxTv_SdtCountry_N = (byte)(0) ;
      SetDirty("Countryname_Z");
      gxTv_SdtCountry_Countryname_Z = value ;
   }

   public void setgxTv_SdtCountry_Countryname_Z_SetNull( )
   {
      gxTv_SdtCountry_Countryname_Z = "" ;
      SetDirty("Countryname_Z");
   }

   public boolean getgxTv_SdtCountry_Countryname_Z_IsNull( )
   {
      return false ;
   }

   public void initialize( int remoteHandle )
   {
      initialize( ) ;
      com.kbbaru.country_bc obj;
      obj = new com.kbbaru.country_bc( remoteHandle, context) ;
      obj.initialize();
      obj.SetSDT(this, (byte)(1));
      setTransaction( obj) ;
      obj.SetMode("INS");
   }

   public void initialize( )
   {
      gxTv_SdtCountry_N = (byte)(1) ;
      gxTv_SdtCountry_Countryname = "" ;
      gxTv_SdtCountry_Mode = "" ;
      gxTv_SdtCountry_Countryname_Z = "" ;
      sTagName = "" ;
   }

   public byte isNull( )
   {
      return gxTv_SdtCountry_N ;
   }

   public com.kbbaru.SdtCountry Clone( )
   {
      com.kbbaru.SdtCountry sdt;
      com.kbbaru.country_bc obj;
      sdt = (com.kbbaru.SdtCountry)(clone()) ;
      obj = (com.kbbaru.country_bc)(sdt.getTransaction()) ;
      obj.SetSDT(sdt, (byte)(0));
      return sdt ;
   }

   public void setStruct( com.kbbaru.StructSdtCountry struct )
   {
      if ( struct != null )
      {
         setgxTv_SdtCountry_Countryid(struct.getCountryid());
         setgxTv_SdtCountry_Countryname(struct.getCountryname());
         GXBCLevelCollection<com.kbbaru.SdtCountry_City> gxTv_SdtCountry_City_aux = new GXBCLevelCollection<com.kbbaru.SdtCountry_City>(com.kbbaru.SdtCountry_City.class, "Country.City", "KBBaru", remoteHandle);
         Vector<com.kbbaru.StructSdtCountry_City> gxTv_SdtCountry_City_aux1 = struct.getCity();
         if (gxTv_SdtCountry_City_aux1 != null)
         {
            for (int i = 0; i < gxTv_SdtCountry_City_aux1.size(); i++)
            {
               gxTv_SdtCountry_City_aux.add(new com.kbbaru.SdtCountry_City(remoteHandle, gxTv_SdtCountry_City_aux1.elementAt(i)));
            }
         }
         setgxTv_SdtCountry_City(gxTv_SdtCountry_City_aux);
         setgxTv_SdtCountry_Mode(struct.getMode());
         setgxTv_SdtCountry_Initialized(struct.getInitialized());
         setgxTv_SdtCountry_Countryid_Z(struct.getCountryid_Z());
         setgxTv_SdtCountry_Countryname_Z(struct.getCountryname_Z());
      }
   }

   @SuppressWarnings("unchecked")
   public com.kbbaru.StructSdtCountry getStruct( )
   {
      com.kbbaru.StructSdtCountry struct = new com.kbbaru.StructSdtCountry ();
      struct.setCountryid(getgxTv_SdtCountry_Countryid());
      struct.setCountryname(getgxTv_SdtCountry_Countryname());
      struct.setCity(getgxTv_SdtCountry_City().getStruct());
      struct.setMode(getgxTv_SdtCountry_Mode());
      struct.setInitialized(getgxTv_SdtCountry_Initialized());
      struct.setCountryid_Z(getgxTv_SdtCountry_Countryid_Z());
      struct.setCountryname_Z(getgxTv_SdtCountry_Countryname_Z());
      return struct ;
   }

   private byte gxTv_SdtCountry_N ;
   private short gxTv_SdtCountry_Countryid ;
   private short gxTv_SdtCountry_Initialized ;
   private short gxTv_SdtCountry_Countryid_Z ;
   private short readOk ;
   private short nOutParmCount ;
   private String gxTv_SdtCountry_Mode ;
   private String sTagName ;
   private boolean readElement ;
   private boolean formatError ;
   private String gxTv_SdtCountry_Countryname ;
   private String gxTv_SdtCountry_Countryname_Z ;
   private GXBCLevelCollection<com.kbbaru.SdtCountry_City> gxTv_SdtCountry_City_aux ;
   private GXBCLevelCollection<com.kbbaru.SdtCountry_City> gxTv_SdtCountry_City=null ;
}

