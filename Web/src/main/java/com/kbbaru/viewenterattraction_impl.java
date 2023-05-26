package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class viewenterattraction_impl extends GXDataArea
{
   public viewenterattraction_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public viewenterattraction_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( viewenterattraction_impl.class ));
   }

   public viewenterattraction_impl( int remoteHandle ,
                                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void initweb( )
   {
      initialize_properties( ) ;
      if ( nGotPars == 0 )
      {
         entryPointCalled = false ;
         gxfirstwebparm = httpContext.GetFirstPar( "AttractionsId") ;
         gxfirstwebparm_bkp = gxfirstwebparm ;
         gxfirstwebparm = httpContext.DecryptAjaxCall( gxfirstwebparm) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         if ( GXutil.strcmp(gxfirstwebparm, "dyncall") == 0 )
         {
            httpContext.setAjaxCallMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            dyncall( httpContext.GetNextPar( )) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxEvt") == 0 )
         {
            httpContext.setAjaxEventMode();
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "AttractionsId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "AttractionsId") ;
         }
         else
         {
            if ( ! httpContext.IsValidAjaxCall( false) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = gxfirstwebparm_bkp ;
         }
         if ( ! entryPointCalled && ! ( isAjaxCallMode( ) || isFullAjaxMode( ) ) )
         {
            A9AttractionsId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
         }
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
      }
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.kbbaru.general.ui.masterunanimosidebar");
         MasterPageObj.setDataArea(this,false);
         validateSpaRequest();
         MasterPageObj.webExecute();
         if ( ( GxWebError == 0 ) && httpContext.isAjaxRequest( ) )
         {
            httpContext.enableOutput();
            if ( ! httpContext.isAjaxRequest( ) )
            {
               httpContext.GX_webresponse.addHeader("Cache-Control", "no-store");
            }
            if ( ! httpContext.willRedirect( ) )
            {
               addString( httpContext.getJSONResponse( )) ;
            }
            else
            {
               if ( httpContext.isAjaxRequest( ) )
               {
                  httpContext.disableOutput();
               }
               renderHtmlHeaders( ) ;
               httpContext.redirect( httpContext.wjLoc );
               httpContext.dispatchAjaxCommands();
            }
         }
      }
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
   }

   public byte executeStartEvent( )
   {
      pa242( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start242( ) ;
      }
      return gxajaxcallmode ;
   }

   public void renderHtmlHeaders( )
   {
      com.kbbaru.GxWebStd.gx_html_headers( httpContext, 0, "", "", Form.getMeta(), Form.getMetaequiv(), true);
   }

   public void renderHtmlOpenForm( )
   {
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( "<title>") ;
      httpContext.writeValue( Form.getCaption()) ;
      httpContext.writeTextNL( "</title>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( GXutil.len( sDynURL) > 0 )
      {
         httpContext.writeText( "<BASE href=\""+sDynURL+"\" />") ;
      }
      define_styles( ) ;
      if ( nGXWrapped != 1 )
      {
         MasterPageObj.master_styles();
      }
      httpContext.CloseStyles();
      if ( ( ( httpContext.getBrowserType( ) == 1 ) || ( httpContext.getBrowserType( ) == 5 ) ) && ( GXutil.strcmp(httpContext.getBrowserVersion( ), "7.0") == 0 ) )
      {
         httpContext.AddJavascriptSource("json2.js", "?"+httpContext.getBuildNumber( 2054360), false, true);
      }
      httpContext.AddJavascriptSource("jquery.js", "?"+httpContext.getBuildNumber( 2054360), false, true);
      httpContext.AddJavascriptSource("gxgral.js", "?"+httpContext.getBuildNumber( 2054360), false, true);
      httpContext.AddJavascriptSource("gxcfg.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      httpContext.writeText( Form.getHeaderrawhtml()) ;
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"false\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" + "background-color:" + WebUtils.getHTMLColor( Form.getIBackground()) + ";color:" + WebUtils.getHTMLColor( Form.getTextcolor()) + ";" ;
      if ( nGXWrapped == 0 )
      {
         bodyStyle += "-moz-opacity:0;opacity:0;" ;
      }
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.viewenterattraction", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A9AttractionsId,4,0))}, new String[] {"AttractionsId"}) +"\">") ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventName", "");
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventGridId", "");
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "_EventRowId", "");
      httpContext.writeText( "<div style=\"height:0;overflow:hidden\"><input type=\"submit\" title=\"submit\"  disabled></div>") ;
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Class", "form-horizontal Form", true);
      toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
   }

   public void send_integrity_footer_hashes( )
   {
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "COUNTRYID", GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_COUNTRYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A5CountryId), "ZZZ9")));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "COUNTRYID", GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_COUNTRYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A5CountryId), "ZZZ9")));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", GX_FocusControl);
      httpContext.SendAjaxEncryptionKey();
      sendSecurityToken(sPrefix);
      httpContext.SendComponentObjects();
      httpContext.SendServerCommands();
      httpContext.SendState();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      httpContext.writeTextNL( "</form>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      include_jscripts( ) ;
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.kbbaru.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we242( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt242( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return false ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.kbbaru.viewenterattraction", new String[] {GXutil.URLEncode(GXutil.ltrimstr(A9AttractionsId,4,0))}, new String[] {"AttractionsId"})  ;
   }

   public String getPgmname( )
   {
      return "ViewEnterAttraction" ;
   }

   public String getPgmdesc( )
   {
      return "View Enter Attraction" ;
   }

   public void wb240( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! wbLoad )
      {
         if ( nGXWrapped == 1 )
         {
            renderHtmlHeaders( ) ;
            renderHtmlOpenForm( ) ;
         }
         com.kbbaru.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), "", "", "", "false");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"none\""+" "+"data-abstract-form"+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divTable2_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAttractionsId_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtAttractionsId_Internalname, "Id", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtAttractionsId_Internalname, GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( ((edtAttractionsId_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAttractionsId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAttractionsId_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_ViewEnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAttractionsName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtAttractionsName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtAttractionsName_Internalname, A10AttractionsName, GXutil.rtrim( localUtil.format( A10AttractionsName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAttractionsName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAttractionsName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_ViewEnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCountryName_Internalname, "Country Name", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryName_Internalname, A6CountryName, GXutil.rtrim( localUtil.format( A6CountryName, "")), "", "'"+""+"'"+",false,"+"'"+"e11241_client"+"'", "", "", "", "", edtCountryName_Jsonclick, 7, "Attribute", "", "", "", "", 1, edtCountryName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_ViewEnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCategoryName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCategoryName_Internalname, "Category Name", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCategoryName_Internalname, A4CategoryName, GXutil.rtrim( localUtil.format( A4CategoryName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCategoryName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCategoryName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_ViewEnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryCityName_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCountryCityName_Internalname, "City Name", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryCityName_Internalname, A16CountryCityName, GXutil.rtrim( localUtil.format( A16CountryCityName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryCityName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryCityName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_ViewEnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtavTripss_Internalname+"\"", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavTripss_Internalname, "Tripss", "col-sm-3 AttributeLabel", 1, true, "");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavTripss_Internalname, GXutil.ltrim( localUtil.ntoc( AV12Tripss, (byte)(10), (byte)(0), ".", "")), GXutil.ltrim( ((edtavTripss_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV12Tripss), "ZZZZZZZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV12Tripss), "ZZZZZZZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,36);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavTripss_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtavTripss_Enabled, 0, "text", "1", 10, "chr", 1, "row", 10, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_ViewEnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-6", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divTable1_Internalname, 1, 0, "px", 0, "px", "Flex", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", " "+"classref"+" ", "flex-grow:1;", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group gx-default-form-group", "left", "top", ""+" data-gx-for=\""+imgAttractionsPhoto_Internalname+"\"", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 75, "%", 0, "px", "gx-form-item gx-attribute", "left", "top", "", "", "div");
         /* Static Bitmap Variable */
         ClassString = "ImageAttribute" ;
         StyleString = "" ;
         A11AttractionsPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A11AttractionsPhoto)==0)&&(GXutil.strcmp("", A40001AttractionsPhoto_GXI)==0))||!(GXutil.strcmp("", A11AttractionsPhoto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.getResourceRelative(A11AttractionsPhoto)) ;
         com.kbbaru.GxWebStd.gx_bitmap( httpContext, imgAttractionsPhoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, 0, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, A11AttractionsPhoto_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_ViewEnterAttraction.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start242( )
   {
      wbLoad = false ;
      wbEnd = 0 ;
      wbStart = 0 ;
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 18_0_2-169539", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "View Enter Attraction", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup240( ) ;
   }

   public void ws242( )
   {
      start242( ) ;
      evt242( ) ;
   }

   public void evt242( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) && ! wbErr )
         {
            /* Read Web Panel buttons. */
            sEvt = httpContext.cgiGet( "_EventName") ;
            EvtGridId = httpContext.cgiGet( "_EventGridId") ;
            EvtRowId = httpContext.cgiGet( "_EventRowId") ;
            if ( GXutil.len( sEvt) > 0 )
            {
               sEvtType = GXutil.left( sEvt, 1) ;
               sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-1) ;
               if ( GXutil.strcmp(sEvtType, "M") != 0 )
               {
                  if ( GXutil.strcmp(sEvtType, "E") == 0 )
                  {
                     sEvtType = GXutil.right( sEvt, 1) ;
                     if ( GXutil.strcmp(sEvtType, ".") == 0 )
                     {
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                        if ( GXutil.strcmp(sEvt, "RFR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e12242 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           if ( ! wbErr )
                           {
                              Rfr0gs = false ;
                              if ( ! Rfr0gs )
                              {
                              }
                              dynload_actions( ) ;
                           }
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we242( )
   {
      if ( ! com.kbbaru.GxWebStd.gx_redirect( httpContext) )
      {
         Rfr0gs = true ;
         refresh( ) ;
         if ( ! com.kbbaru.GxWebStd.gx_redirect( httpContext) )
         {
            if ( nGXWrapped == 1 )
            {
               renderHtmlCloseForm( ) ;
            }
         }
      }
   }

   public void pa242( )
   {
      if ( nDonePA == 0 )
      {
         if ( (GXutil.strcmp("", httpContext.getCookie( "GX_SESSION_ID"))==0) )
         {
            gxcookieaux = httpContext.setCookie( "GX_SESSION_ID", httpContext.encrypt64( com.genexus.util.Encryption.getNewKey( ), context.getServerKey( )), "", GXutil.nullDate(), "", (short)(httpContext.getHttpSecure( ))) ;
         }
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         toggleJsOutput = httpContext.isJsOutputEnabled( ) ;
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableJsOutput();
         }
         init_web_controls( ) ;
         if ( toggleJsOutput )
         {
            if ( httpContext.isSpaRequest( ) )
            {
               httpContext.enableJsOutput();
            }
         }
         if ( ! httpContext.isAjaxRequest( ) )
         {
            GX_FocusControl = edtavTripss_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void send_integrity_hashes( )
   {
   }

   public void clear_multi_value_controls( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         dynload_actions( ) ;
         before_start_formulas( ) ;
      }
   }

   public void fix_multi_value_controls( )
   {
   }

   public void refresh( )
   {
      send_integrity_hashes( ) ;
      rf242( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavTripss_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTripss_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTripss_Enabled), 5, 0), true);
   }

   public void rf242( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H00243 */
         pr_default.execute(0, new Object[] {Short.valueOf(A9AttractionsId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CategoryId = H00243_A3CategoryId[0] ;
            A12CountryCityId = H00243_A12CountryCityId[0] ;
            A5CountryId = H00243_A5CountryId[0] ;
            A11AttractionsPhoto = H00243_A11AttractionsPhoto[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A11AttractionsPhoto", A11AttractionsPhoto);
            httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
            httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A40001AttractionsPhoto_GXI = H00243_A40001AttractionsPhoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40001AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
            httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A16CountryCityName = H00243_A16CountryCityName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
            A4CategoryName = H00243_A4CategoryName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
            A6CountryName = H00243_A6CountryName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
            A10AttractionsName = H00243_A10AttractionsName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A10AttractionsName", A10AttractionsName);
            A40000GXC1 = H00243_A40000GXC1[0] ;
            n40000GXC1 = H00243_n40000GXC1[0] ;
            A4CategoryName = H00243_A4CategoryName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
            A6CountryName = H00243_A6CountryName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
            A16CountryCityName = H00243_A16CountryCityName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
            A40000GXC1 = H00243_A40000GXC1[0] ;
            n40000GXC1 = H00243_n40000GXC1[0] ;
            /* Execute user event: Load */
            e12242 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb240( ) ;
      }
   }

   public void send_integrity_lvl_hashes242( )
   {
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "COUNTRYID", GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_COUNTRYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A5CountryId), "ZZZ9")));
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      edtavTripss_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtavTripss_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtavTripss_Enabled), 5, 0), true);
      /* Using cursor H00245 */
      pr_default.execute(1, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         A40000GXC1 = H00245_A40000GXC1[0] ;
         n40000GXC1 = H00245_n40000GXC1[0] ;
      }
      else
      {
         A40000GXC1 = 0 ;
         n40000GXC1 = false ;
         httpContext.ajax_rsp_assign_attri("", false, "A40000GXC1", GXutil.ltrimstr( DecimalUtil.doubleToDec(A40000GXC1), 9, 0));
      }
      pr_default.close(1);
      pr_default.close(1);
      fix_multi_value_controls( ) ;
   }

   public void strup240( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         A5CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "COUNTRYID"), ".", ",")) ;
         /* Read variables values. */
         A10AttractionsName = httpContext.cgiGet( edtAttractionsName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A10AttractionsName", A10AttractionsName);
         A6CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
         A4CategoryName = httpContext.cgiGet( edtCategoryName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
         A16CountryCityName = httpContext.cgiGet( edtCountryCityName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavTripss_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavTripss_Internalname), ".", ",") > 9999999999L ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vTRIPSS");
            GX_FocusControl = edtavTripss_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV12Tripss = 0 ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12Tripss", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Tripss), 10, 0));
         }
         else
         {
            AV12Tripss = localUtil.ctol( httpContext.cgiGet( edtavTripss_Internalname), ".", ",") ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12Tripss", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Tripss), 10, 0));
         }
         A11AttractionsPhoto = httpContext.cgiGet( imgAttractionsPhoto_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A11AttractionsPhoto", A11AttractionsPhoto);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e12242( )
   {
      /* Load Routine */
      returnInSub = false ;
      AV12Tripss = A40000GXC1 ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12Tripss", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12Tripss), 10, 0));
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      A9AttractionsId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
   }

   public String getresponse( String sGXDynURL )
   {
      initialize_properties( ) ;
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      sDynURL = sGXDynURL ;
      nGotPars = 1 ;
      nGXWrapped = 1 ;
      httpContext.setWrapped(true);
      pa242( ) ;
      ws242( ) ;
      we242( ) ;
      if ( isAjaxCallMode( ) )
      {
         cleanup();
      }
      httpContext.setWrapped(false);
      httpContext.GX_msglist = BackMsgLst ;
      String response = "";
      try
      {
         response = ((java.io.ByteArrayOutputStream) httpContext.getOutputStream()).toString("UTF8");
      }
      catch (java.io.UnsupportedEncodingException e)
      {
         Application.printWarning(e.getMessage(), e);
      }
      finally
      {
         httpContext.closeOutputStream();
      }
      return response;
   }

   public void responsestatic( String sGXDynURL )
   {
   }

   public void define_styles( )
   {
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20235231553872", true, true);
         idxLst = (int)(idxLst+1) ;
      }
      if ( ! outputEnabled )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.disableOutput();
         }
      }
      /* End function define_styles */
   }

   public void include_jscripts( )
   {
      httpContext.AddJavascriptSource("messages.eng.js", "?"+httpContext.getCacheInvalidationToken( ), false, true);
      httpContext.AddJavascriptSource("viewenterattraction.js", "?20235231553873", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      edtAttractionsId_Internalname = "ATTRACTIONSID" ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME" ;
      edtCountryName_Internalname = "COUNTRYNAME" ;
      edtCategoryName_Internalname = "CATEGORYNAME" ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME" ;
      edtavTripss_Internalname = "vTRIPSS" ;
      divTable2_Internalname = "TABLE2" ;
      imgAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO" ;
      divTable1_Internalname = "TABLE1" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
   }

   public void initialize_properties( )
   {
      httpContext.setAjaxOnSessionTimeout(ajaxOnSessionTimeout());
      httpContext.setDefaultTheme("KBBaru", true);
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableJsOutput();
      }
      init_default_properties( ) ;
      edtavTripss_Jsonclick = "" ;
      edtavTripss_Enabled = 1 ;
      edtCountryCityName_Jsonclick = "" ;
      edtCountryCityName_Enabled = 0 ;
      edtCategoryName_Jsonclick = "" ;
      edtCategoryName_Enabled = 0 ;
      edtCountryName_Jsonclick = "" ;
      edtCountryName_Enabled = 0 ;
      edtAttractionsName_Jsonclick = "" ;
      edtAttractionsName_Enabled = 0 ;
      edtAttractionsId_Jsonclick = "" ;
      edtAttractionsId_Enabled = 0 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "View Enter Attraction" );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9'},{av:'A5CountryId',fld:'COUNTRYID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("COUNTRYNAME.CLICK","{handler:'e11241',iparms:[{av:'A5CountryId',fld:'COUNTRYID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("COUNTRYNAME.CLICK",",oparms:[]}");
      setEventMetadata("VALID_ATTRACTIONSID","{handler:'valid_Attractionsid',iparms:[]");
      setEventMetadata("VALID_ATTRACTIONSID",",oparms:[]}");
   }

   protected boolean IntegratedSecurityEnabled( )
   {
      return false;
   }

   protected int IntegratedSecurityLevel( )
   {
      return 0;
   }

   protected String IntegratedSecurityPermissionPrefix( )
   {
      return "";
   }

   protected String EncryptURLParameters( )
   {
      return "NO";
   }

   protected void cleanup( )
   {
      super.cleanup();
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      A10AttractionsName = "" ;
      A6CountryName = "" ;
      A4CategoryName = "" ;
      A16CountryCityName = "" ;
      TempTags = "" ;
      ClassString = "" ;
      StyleString = "" ;
      A11AttractionsPhoto = "" ;
      A40001AttractionsPhoto_GXI = "" ;
      sImgUrl = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      scmdbuf = "" ;
      H00243_A3CategoryId = new short[1] ;
      H00243_A12CountryCityId = new short[1] ;
      H00243_A9AttractionsId = new short[1] ;
      H00243_A5CountryId = new short[1] ;
      H00243_A11AttractionsPhoto = new String[] {""} ;
      H00243_A40001AttractionsPhoto_GXI = new String[] {""} ;
      H00243_A16CountryCityName = new String[] {""} ;
      H00243_A4CategoryName = new String[] {""} ;
      H00243_A6CountryName = new String[] {""} ;
      H00243_A10AttractionsName = new String[] {""} ;
      H00243_A40000GXC1 = new int[1] ;
      H00243_n40000GXC1 = new boolean[] {false} ;
      H00245_A40000GXC1 = new int[1] ;
      H00245_n40000GXC1 = new boolean[] {false} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.viewenterattraction__default(),
         new Object[] {
             new Object[] {
            H00243_A3CategoryId, H00243_A12CountryCityId, H00243_A9AttractionsId, H00243_A5CountryId, H00243_A11AttractionsPhoto, H00243_A40001AttractionsPhoto_GXI, H00243_A16CountryCityName, H00243_A4CategoryName, H00243_A6CountryName, H00243_A10AttractionsName,
            H00243_A40000GXC1, H00243_n40000GXC1
            }
            , new Object[] {
            H00245_A40000GXC1, H00245_n40000GXC1
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
      edtavTripss_Enabled = 0 ;
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte nGXWrapped ;
   private short wcpOA9AttractionsId ;
   private short A9AttractionsId ;
   private short A5CountryId ;
   private short wbEnd ;
   private short wbStart ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A3CategoryId ;
   private short A12CountryCityId ;
   private int edtAttractionsId_Enabled ;
   private int edtAttractionsName_Enabled ;
   private int edtCountryName_Enabled ;
   private int edtCategoryName_Enabled ;
   private int edtCountryCityName_Enabled ;
   private int edtavTripss_Enabled ;
   private int A40000GXC1 ;
   private int idxLst ;
   private long AV12Tripss ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTable2_Internalname ;
   private String edtAttractionsId_Internalname ;
   private String edtAttractionsId_Jsonclick ;
   private String edtAttractionsName_Internalname ;
   private String edtAttractionsName_Jsonclick ;
   private String edtCountryName_Internalname ;
   private String edtCountryName_Jsonclick ;
   private String edtCategoryName_Internalname ;
   private String edtCategoryName_Jsonclick ;
   private String edtCountryCityName_Internalname ;
   private String edtCountryCityName_Jsonclick ;
   private String edtavTripss_Internalname ;
   private String TempTags ;
   private String edtavTripss_Jsonclick ;
   private String divTable1_Internalname ;
   private String imgAttractionsPhoto_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String sImgUrl ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String scmdbuf ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean A11AttractionsPhoto_IsBlob ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean n40000GXC1 ;
   private boolean returnInSub ;
   private String A10AttractionsName ;
   private String A6CountryName ;
   private String A4CategoryName ;
   private String A16CountryCityName ;
   private String A40001AttractionsPhoto_GXI ;
   private String A11AttractionsPhoto ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private IDataStoreProvider pr_default ;
   private short[] H00243_A3CategoryId ;
   private short[] H00243_A12CountryCityId ;
   private short[] H00243_A9AttractionsId ;
   private short[] H00243_A5CountryId ;
   private String[] H00243_A11AttractionsPhoto ;
   private String[] H00243_A40001AttractionsPhoto_GXI ;
   private String[] H00243_A16CountryCityName ;
   private String[] H00243_A4CategoryName ;
   private String[] H00243_A6CountryName ;
   private String[] H00243_A10AttractionsName ;
   private int[] H00243_A40000GXC1 ;
   private boolean[] H00243_n40000GXC1 ;
   private int[] H00245_A40000GXC1 ;
   private boolean[] H00245_n40000GXC1 ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class viewenterattraction__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H00243", "SELECT T1.CategoryId, T1.CountryCityId, T1.AttractionsId, T1.CountryId, T1.AttractionsPhoto, T1.AttractionsPhoto_GXI, T4.CountryCityName, T2.CategoryName, T3.CountryName, T1.AttractionsName, COALESCE( T5.GXC1, 0) AS GXC1 FROM ((((Attractions T1 INNER JOIN Category T2 ON T2.CategoryId = T1.CategoryId) INNER JOIN Country T3 ON T3.CountryId = T1.CountryId) INNER JOIN CountryCity T4 ON T4.CountryId = T1.CountryId AND T4.CountryCityId = T1.CountryCityId) LEFT JOIN LATERAL (SELECT COUNT(*) AS GXC1, T6.AttractionsId FROM (TripsAttrations T6 INNER JOIN Trips T7 ON T7.TripsId = T6.TripsId) WHERE T1.AttractionsId = T6.AttractionsId GROUP BY T6.AttractionsId ) T5 ON T5.AttractionsId = T1.AttractionsId) WHERE T1.AttractionsId = ? ORDER BY T1.AttractionsId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H00245", "SELECT COALESCE( T1.GXC1, 0) AS GXC1 FROM (SELECT COUNT(*) AS GXC1, T2.AttractionsId FROM (TripsAttrations T2 INNER JOIN Trips T3 ON T3.TripsId = T2.TripsId) GROUP BY T2.AttractionsId ) T1 WHERE T1.AttractionsId = ? ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((String[]) buf[4])[0] = rslt.getMultimediaFile(5, rslt.getVarchar(6));
               ((String[]) buf[5])[0] = rslt.getMultimediaUri(6);
               ((String[]) buf[6])[0] = rslt.getVarchar(7);
               ((String[]) buf[7])[0] = rslt.getVarchar(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((String[]) buf[9])[0] = rslt.getVarchar(10);
               ((int[]) buf[10])[0] = rslt.getInt(11);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

