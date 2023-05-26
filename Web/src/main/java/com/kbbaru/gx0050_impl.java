package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class gx0050_impl extends GXDataArea
{
   public gx0050_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public gx0050_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gx0050_impl.class ));
   }

   public gx0050_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "pAttractionsId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "pAttractionsId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "pAttractionsId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Grid1") == 0 )
         {
            gxnrgrid1_newrow_invoke( ) ;
            return  ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxGridRefresh_"+"Grid1") == 0 )
         {
            gxgrgrid1_refresh_invoke( ) ;
            return  ;
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
            AV11pAttractionsId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV11pAttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11pAttractionsId), 4, 0));
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

   public void gxnrgrid1_newrow_invoke( )
   {
      nRC_GXsfl_64 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_64"))) ;
      nGXsfl_64_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_64_idx"))) ;
      sGXsfl_64_idx = httpContext.GetPar( "sGXsfl_64_idx") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgrid1_newrow( ) ;
      /* End function gxnrGrid1_newrow_invoke */
   }

   public void gxgrgrid1_refresh_invoke( )
   {
      subGrid1_Rows = (int)(GXutil.lval( httpContext.GetPar( "subGrid1_Rows"))) ;
      AV6cAttractionsId = (short)(GXutil.lval( httpContext.GetPar( "cAttractionsId"))) ;
      AV7cAttractionsName = httpContext.GetPar( "cAttractionsName") ;
      AV8cCategoryId = (short)(GXutil.lval( httpContext.GetPar( "cCategoryId"))) ;
      AV9cCountryId = (short)(GXutil.lval( httpContext.GetPar( "cCountryId"))) ;
      AV10cCountryCityId = (short)(GXutil.lval( httpContext.GetPar( "cCountryCityId"))) ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxgrgrid1_refresh( subGrid1_Rows, AV6cAttractionsId, AV7cAttractionsName, AV8cCategoryId, AV9cCountryId, AV10cCountryCityId) ;
      addString( httpContext.getJSONResponse( )) ;
      /* End function gxgrGrid1_refresh_invoke */
   }

   public void webExecute( )
   {
      initweb( ) ;
      if ( ! isAjaxCallMode( ) )
      {
         MasterPageObj= createMasterPage(remoteHandle, "com.kbbaru.general.ui.masterprompt");
         MasterPageObj.setDataArea(this,true);
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
      pa1T2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1T2( ) ;
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
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.gx0050", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11pAttractionsId,4,0))}, new String[] {"pAttractionsId"}) +"\">") ;
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
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vCATTRACTIONSID", GXutil.ltrim( localUtil.ntoc( AV6cAttractionsId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vCATTRACTIONSNAME", AV7cAttractionsName);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vCCATEGORYID", GXutil.ltrim( localUtil.ntoc( AV8cCategoryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vCCOUNTRYID", GXutil.ltrim( localUtil.ntoc( AV9cCountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GXH_vCCOUNTRYCITYID", GXutil.ltrim( localUtil.ntoc( AV10cCountryCityId, (byte)(4), (byte)(0), ".", "")));
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_64", GXutil.ltrim( localUtil.ntoc( nRC_GXsfl_64, (byte)(8), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vPATTRACTIONSID", GXutil.ltrim( localUtil.ntoc( AV11pAttractionsId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "ADVANCEDCONTAINER_Class", GXutil.rtrim( divAdvancedcontainer_Class));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "BTNTOGGLE_Class", GXutil.rtrim( bttBtntoggle_Class));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "ATTRACTIONSIDFILTERCONTAINER_Class", GXutil.rtrim( divAttractionsidfiltercontainer_Class));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "ATTRACTIONSNAMEFILTERCONTAINER_Class", GXutil.rtrim( divAttractionsnamefiltercontainer_Class));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "CATEGORYIDFILTERCONTAINER_Class", GXutil.rtrim( divCategoryidfiltercontainer_Class));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "COUNTRYIDFILTERCONTAINER_Class", GXutil.rtrim( divCountryidfiltercontainer_Class));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "COUNTRYCITYIDFILTERCONTAINER_Class", GXutil.rtrim( divCountrycityidfiltercontainer_Class));
   }

   public void renderHtmlCloseForm( )
   {
      sendCloseFormHiddens( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GX_FocusControl", "notset");
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
         we1T2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1T2( ) ;
   }

   public boolean hasEnterEvent( )
   {
      return true ;
   }

   public com.genexus.webpanels.GXWebForm getForm( )
   {
      return Form ;
   }

   public String getSelfLink( )
   {
      return formatLink("com.kbbaru.gx0050", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV11pAttractionsId,4,0))}, new String[] {"pAttractionsId"})  ;
   }

   public String getPgmname( )
   {
      return "Gx0050" ;
   }

   public String getPgmdesc( )
   {
      return "Selection List Attractions" ;
   }

   public void wb1T0( )
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
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divMain_Internalname, 1, 0, "px", 0, "px", "ContainerFluid PromptContainer", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-3 PromptAdvancedBarCell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divAdvancedcontainer_Internalname, 1, 0, "px", 0, "px", divAdvancedcontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divAttractionsidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divAttractionsidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblLblattractionsidfilter_Internalname, "Attractions Id", "", "", lblLblattractionsidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e111t1_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavCattractionsid_Internalname, "Attractions Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 16,'',false,'" + sGXsfl_64_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavCattractionsid_Internalname, GXutil.ltrim( localUtil.ntoc( AV6cAttractionsId, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( ((edtavCattractionsid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV6cAttractionsId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV6cAttractionsId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,16);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCattractionsid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCattractionsid_Visible, edtavCattractionsid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divAttractionsnamefiltercontainer_Internalname, 1, 0, "px", 0, "px", divAttractionsnamefiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblLblattractionsnamefilter_Internalname, "Attractions Name", "", "", lblLblattractionsnamefilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e121t1_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavCattractionsname_Internalname, "Attractions Name", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 26,'',false,'" + sGXsfl_64_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavCattractionsname_Internalname, AV7cAttractionsName, GXutil.rtrim( localUtil.format( AV7cAttractionsName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,26);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCattractionsname_Jsonclick, 0, "Attribute", "", "", "", "", edtavCattractionsname_Visible, edtavCattractionsname_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "", "left", true, "", "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divCategoryidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divCategoryidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblLblcategoryidfilter_Internalname, "Category Id", "", "", lblLblcategoryidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e131t1_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavCcategoryid_Internalname, "Category Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 36,'',false,'" + sGXsfl_64_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavCcategoryid_Internalname, GXutil.ltrim( localUtil.ntoc( AV8cCategoryId, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( ((edtavCcategoryid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV8cCategoryId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV8cCategoryId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,36);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCcategoryid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCcategoryid_Visible, edtavCcategoryid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divCountryidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divCountryidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblLblcountryidfilter_Internalname, "Country Id", "", "", lblLblcountryidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e141t1_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavCcountryid_Internalname, "Country Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 46,'',false,'" + sGXsfl_64_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavCcountryid_Internalname, GXutil.ltrim( localUtil.ntoc( AV9cCountryId, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( ((edtavCcountryid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV9cCountryId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV9cCountryId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,46);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCcountryid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCcountryid_Visible, edtavCcountryid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divCountrycityidfiltercontainer_Internalname, 1, 0, "px", 0, "px", divCountrycityidfiltercontainer_Class, "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Text block */
         com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblLblcountrycityidfilter_Internalname, "Country City Id", "", "", lblLblcountrycityidfilter_Jsonclick, "'"+""+"'"+",false,"+"'"+"e151t1_client"+"'", "", "WWAdvancedLabel WWFilterLabel", 7, "", 1, 1, 0, (short)(1), "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 WWFiltersCell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtavCcountrycityid_Internalname, "Country City Id", "col-sm-3 AttributeLabel", 0, true, "");
         /* Single line edit */
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 56,'',false,'" + sGXsfl_64_idx + "',0)\"" ;
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtavCcountrycityid_Internalname, GXutil.ltrim( localUtil.ntoc( AV10cCountryCityId, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( ((edtavCcountrycityid_Enabled!=0) ? localUtil.format( DecimalUtil.doubleToDec(AV10cCountryCityId), "ZZZ9") : localUtil.format( DecimalUtil.doubleToDec(AV10cCountryCityId), "ZZZ9"))), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,56);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtavCcountrycityid_Jsonclick, 0, "Attribute", "", "", "", "", edtavCcountrycityid_Visible, edtavCcountrycityid_Enabled, 0, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "", "right", false, "", "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 WWGridCell", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divGridtable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 hidden-sm hidden-md hidden-lg ToggleCell", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 61,'',false,'',0)\"" ;
         ClassString = bttBtntoggle_Class ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtntoggle_Internalname, "gx.evt.setGridEvt("+GXutil.str( 64, 2, 0)+","+"null"+");", "|||", bttBtntoggle_Jsonclick, 7, "|||", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"e161t1_client"+"'", TempTags, "", 2, "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /*  Grid Control  */
         Grid1Container.SetWrapped(nGXWrapped);
         startgridcontrol64( ) ;
      }
      if ( wbEnd == 64 )
      {
         wbEnd = (short)(0) ;
         nRC_GXsfl_64 = (int)(nGXsfl_64_idx-1) ;
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "</table>") ;
            httpContext.writeText( "</div>") ;
         }
         else
         {
            Grid1Container.AddObjectProperty("GRID1_nEOF", GRID1_nEOF);
            Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
            sStyleString = "" ;
            httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
            httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container, subGrid1_Internalname);
            if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
            {
               com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
            }
            if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
            {
               com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
            }
            else
            {
               httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
            }
         }
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
         ClassString = "BtnCancel" ;
         StyleString = "" ;
         com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "gx.evt.setGridEvt("+GXutil.str( 64, 2, 0)+","+"null"+");", "Cancel", bttBtn_cancel_Jsonclick, 1, "Cancel", "", StyleString, ClassString, 1, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Gx0050.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      if ( wbEnd == 64 )
      {
         wbEnd = (short)(0) ;
         if ( isFullAjaxMode( ) )
         {
            if ( Grid1Container.GetWrapped() == 1 )
            {
               httpContext.writeText( "</table>") ;
               httpContext.writeText( "</div>") ;
            }
            else
            {
               Grid1Container.AddObjectProperty("GRID1_nEOF", GRID1_nEOF);
               Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
               sStyleString = "" ;
               httpContext.writeText( "<div id=\""+"Grid1Container"+"Div\" "+sStyleString+">"+"</div>") ;
               httpContext.ajax_rsp_assign_grid("_"+"Grid1", Grid1Container, subGrid1_Internalname);
               if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
               {
                  com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData", Grid1Container.ToJavascriptSource());
               }
               if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
               {
                  com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Grid1ContainerData"+"V", Grid1Container.GridValuesHidden());
               }
               else
               {
                  httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Grid1ContainerData"+"V"+"\" value='"+Grid1Container.GridValuesHidden()+"'/>") ;
               }
            }
         }
      }
      wbLoad = true ;
   }

   public void start1T2( )
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
         Form.getMeta().addItem("description", "Selection List Attractions", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1T0( ) ;
   }

   public void ws1T2( )
   {
      start1T2( ) ;
      evt1T2( ) ;
   }

   public void evt1T2( )
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
                           /* No code required for Cancel button. It is implemented as the Reset button. */
                        }
                        else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                        }
                        else if ( GXutil.strcmp(sEvt, "GRID1PAGING") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           sEvt = httpContext.cgiGet( "GRID1PAGING") ;
                           if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                           {
                              subgrid1_firstpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "PREV") == 0 )
                           {
                              subgrid1_previouspage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                           {
                              subgrid1_nextpage( ) ;
                           }
                           else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                           {
                              subgrid1_lastpage( ) ;
                           }
                           dynload_actions( ) ;
                        }
                     }
                     else
                     {
                        sEvtType = GXutil.right( sEvt, 4) ;
                        sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                        if ( ( GXutil.strcmp(GXutil.left( sEvt, 5), "START") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 4), "LOAD") == 0 ) || ( GXutil.strcmp(GXutil.left( sEvt, 5), "ENTER") == 0 ) )
                        {
                           nGXsfl_64_idx = (int)(GXutil.lval( sEvtType)) ;
                           sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
                           subsflControlProps_642( ) ;
                           AV5LinkSelection = httpContext.cgiGet( edtavLinkselection_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtavLinkselection_Internalname, "Bitmap", ((GXutil.strcmp("", AV5LinkSelection)==0) ? AV15Linkselection_GXI : httpContext.convertURL( httpContext.getResourceRelative(AV5LinkSelection))), !bGXsfl_64_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtavLinkselection_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( AV5LinkSelection), true);
                           A9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( edtAttractionsId_Internalname), ".", ",")) ;
                           A10AttractionsName = httpContext.cgiGet( edtAttractionsName_Internalname) ;
                           A11AttractionsPhoto = httpContext.cgiGet( edtAttractionsPhoto_Internalname) ;
                           httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_64_Refreshing);
                           httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
                           A3CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCategoryId_Internalname), ".", ",")) ;
                           A5CountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ".", ",")) ;
                           A12CountryCityId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryCityId_Internalname), ".", ",")) ;
                           sEvtType = GXutil.right( sEvt, 1) ;
                           if ( GXutil.strcmp(sEvtType, ".") == 0 )
                           {
                              sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-1) ;
                              if ( GXutil.strcmp(sEvt, "START") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Start */
                                 e171T2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                                 /* Execute user event: Load */
                                 e181T2 ();
                              }
                              else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 if ( ! wbErr )
                                 {
                                    Rfr0gs = false ;
                                    /* Set Refresh If Cattractionsid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCATTRACTIONSID"), ".", ",") != AV6cAttractionsId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Cattractionsname Changed */
                                    if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCATTRACTIONSNAME"), AV7cAttractionsName) != 0 )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ccategoryid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCATEGORYID"), ".", ",") != AV8cCategoryId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ccountryid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCOUNTRYID"), ".", ",") != AV9cCountryId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    /* Set Refresh If Ccountrycityid Changed */
                                    if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCOUNTRYCITYID"), ".", ",") != AV10cCountryCityId )
                                    {
                                       Rfr0gs = true ;
                                    }
                                    if ( ! Rfr0gs )
                                    {
                                       /* Execute user event: Enter */
                                       e191T2 ();
                                    }
                                    dynload_actions( ) ;
                                 }
                              }
                              else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                              {
                                 httpContext.wbHandled = (byte)(1) ;
                                 dynload_actions( ) ;
                              }
                           }
                           else
                           {
                           }
                        }
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1T2( )
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

   public void pa1T2( )
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
         nDonePA = (byte)(1) ;
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgrid1_newrow( )
   {
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      subsflControlProps_642( ) ;
      while ( nGXsfl_64_idx <= nRC_GXsfl_64 )
      {
         sendrow_642( ) ;
         nGXsfl_64_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_64_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_64_idx+1) ;
         sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_642( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Grid1Container)) ;
      /* End function gxnrGrid1_newrow */
   }

   public void gxgrgrid1_refresh( int subGrid1_Rows ,
                                  short AV6cAttractionsId ,
                                  String AV7cAttractionsName ,
                                  short AV8cCategoryId ,
                                  short AV9cCountryId ,
                                  short AV10cCountryCityId )
   {
      initialize_formulas( ) ;
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      GRID1_nCurrentRecord = 0 ;
      rf1T2( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      send_integrity_footer_hashes( ) ;
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      /* End function gxgrGrid1_refresh */
   }

   public void send_integrity_hashes( )
   {
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_ATTRACTIONSID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "ATTRACTIONSID", GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")));
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
      rf1T2( ) ;
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
   }

   public void rf1T2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( isAjaxCallMode( ) )
      {
         Grid1Container.ClearRows();
      }
      wbStart = (short)(64) ;
      nGXsfl_64_idx = 1 ;
      sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_642( ) ;
      bGXsfl_64_Refreshing = true ;
      Grid1Container.AddObjectProperty("GridName", "Grid1");
      Grid1Container.AddObjectProperty("CmpContext", "");
      Grid1Container.AddObjectProperty("InMasterPage", "false");
      Grid1Container.AddObjectProperty("Class", "PromptGrid");
      Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Grid1Container.setPageSize( subgrid1_fnc_recordsperpage( ) );
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         subsflControlProps_642( ) ;
         GXPagingFrom2 = (int)(GRID1_nFirstRecordOnPage) ;
         GXPagingTo2 = (int)(subgrid1_fnc_recordsperpage( )+1) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV7cAttractionsName ,
                                              Short.valueOf(AV8cCategoryId) ,
                                              Short.valueOf(AV9cCountryId) ,
                                              Short.valueOf(AV10cCountryCityId) ,
                                              A10AttractionsName ,
                                              Short.valueOf(A3CategoryId) ,
                                              Short.valueOf(A5CountryId) ,
                                              Short.valueOf(A12CountryCityId) ,
                                              Short.valueOf(AV6cAttractionsId) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                              }
         });
         lV7cAttractionsName = GXutil.concat( GXutil.rtrim( AV7cAttractionsName), "%", "") ;
         /* Using cursor H001T2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV6cAttractionsId), lV7cAttractionsName, Short.valueOf(AV8cCategoryId), Short.valueOf(AV9cCountryId), Short.valueOf(AV10cCountryCityId), Integer.valueOf(GXPagingFrom2), Integer.valueOf(GXPagingTo2), Integer.valueOf(GXPagingTo2)});
         nGXsfl_64_idx = 1 ;
         sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_642( ) ;
         while ( ( (pr_default.getStatus(0) != 101) ) && ( ( GRID1_nCurrentRecord < subgrid1_fnc_recordsperpage( ) ) ) )
         {
            A12CountryCityId = H001T2_A12CountryCityId[0] ;
            A5CountryId = H001T2_A5CountryId[0] ;
            A3CategoryId = H001T2_A3CategoryId[0] ;
            A11AttractionsPhoto = H001T2_A11AttractionsPhoto[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_64_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A40000AttractionsPhoto_GXI = H001T2_A40000AttractionsPhoto_GXI[0] ;
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), !bGXsfl_64_Refreshing);
            httpContext.ajax_rsp_assign_prop("", false, edtAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
            A10AttractionsName = H001T2_A10AttractionsName[0] ;
            A9AttractionsId = H001T2_A9AttractionsId[0] ;
            /* Execute user event: Load */
            e181T2 ();
            pr_default.readNext(0);
         }
         GRID1_nEOF = (byte)(((pr_default.getStatus(0) == 101) ? 1 : 0)) ;
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID1_nEOF", GXutil.ltrim( localUtil.ntoc( GRID1_nEOF, (byte)(1), (byte)(0), ".", "")));
         pr_default.close(0);
         wbEnd = (short)(64) ;
         wb1T0( ) ;
      }
      bGXsfl_64_Refreshing = true ;
   }

   public void send_integrity_lvl_hashes1T2( )
   {
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_ATTRACTIONSID"+"_"+sGXsfl_64_idx, getSecureSignedToken( sGXsfl_64_idx, localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9")));
   }

   public int subgrid1_fnc_pagecount( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
      {
         return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID1_nRecordCount).divide(DecimalUtil.doubleToDec(subgrid1_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))) ;
      }
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID1_nRecordCount).divide(DecimalUtil.doubleToDec(subgrid1_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public int subgrid1_fnc_recordcount( )
   {
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV7cAttractionsName ,
                                           Short.valueOf(AV8cCategoryId) ,
                                           Short.valueOf(AV9cCountryId) ,
                                           Short.valueOf(AV10cCountryCityId) ,
                                           A10AttractionsName ,
                                           Short.valueOf(A3CategoryId) ,
                                           Short.valueOf(A5CountryId) ,
                                           Short.valueOf(A12CountryCityId) ,
                                           Short.valueOf(AV6cAttractionsId) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.SHORT
                                           }
      });
      lV7cAttractionsName = GXutil.concat( GXutil.rtrim( AV7cAttractionsName), "%", "") ;
      /* Using cursor H001T3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV6cAttractionsId), lV7cAttractionsName, Short.valueOf(AV8cCategoryId), Short.valueOf(AV9cCountryId), Short.valueOf(AV10cCountryCityId)});
      GRID1_nRecordCount = H001T3_AGRID1_nRecordCount[0] ;
      pr_default.close(1);
      return (int)(GRID1_nRecordCount) ;
   }

   public int subgrid1_fnc_recordsperpage( )
   {
      return 10*1 ;
   }

   public int subgrid1_fnc_currentpage( )
   {
      return (int)(GXutil.Int( DecimalUtil.decToDouble(DecimalUtil.doubleToDec(GRID1_nFirstRecordOnPage).divide(DecimalUtil.doubleToDec(subgrid1_fnc_recordsperpage( )), java.math.MathContext.DECIMAL128)))+1) ;
   }

   public short subgrid1_firstpage( )
   {
      GRID1_nFirstRecordOnPage = 0 ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cAttractionsId, AV7cAttractionsName, AV8cCategoryId, AV9cCountryId, AV10cCountryCityId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_nextpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( ( GRID1_nRecordCount >= subgrid1_fnc_recordsperpage( ) ) && ( GRID1_nEOF == 0 ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage+subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      Grid1Container.AddObjectProperty("GRID1_nFirstRecordOnPage", GRID1_nFirstRecordOnPage);
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cAttractionsId, AV7cAttractionsName, AV8cCategoryId, AV9cCountryId, AV10cCountryCityId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(((GRID1_nEOF==0) ? 0 : 2)) ;
   }

   public short subgrid1_previouspage( )
   {
      if ( GRID1_nFirstRecordOnPage >= subgrid1_fnc_recordsperpage( ) )
      {
         GRID1_nFirstRecordOnPage = (long)(GRID1_nFirstRecordOnPage-subgrid1_fnc_recordsperpage( )) ;
      }
      else
      {
         return (short)(2) ;
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cAttractionsId, AV7cAttractionsName, AV8cCategoryId, AV9cCountryId, AV10cCountryCityId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public short subgrid1_lastpage( )
   {
      GRID1_nRecordCount = subgrid1_fnc_recordcount( ) ;
      if ( GRID1_nRecordCount > subgrid1_fnc_recordsperpage( ) )
      {
         if ( ((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( )))) == 0 )
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-subgrid1_fnc_recordsperpage( )) ;
         }
         else
         {
            GRID1_nFirstRecordOnPage = (long)(GRID1_nRecordCount-((int)((GRID1_nRecordCount) % (subgrid1_fnc_recordsperpage( ))))) ;
         }
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cAttractionsId, AV7cAttractionsName, AV8cCategoryId, AV9cCountryId, AV10cCountryCityId) ;
      }
      send_integrity_footer_hashes( ) ;
      return (short)(0) ;
   }

   public int subgrid1_gotopage( int nPageNo )
   {
      if ( nPageNo > 0 )
      {
         GRID1_nFirstRecordOnPage = (long)(subgrid1_fnc_recordsperpage( )*(nPageNo-1)) ;
      }
      else
      {
         GRID1_nFirstRecordOnPage = 0 ;
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "GRID1_nFirstRecordOnPage", GXutil.ltrim( localUtil.ntoc( GRID1_nFirstRecordOnPage, (byte)(15), (byte)(0), ".", "")));
      if ( isFullAjaxMode( ) )
      {
         gxgrgrid1_refresh( subGrid1_Rows, AV6cAttractionsId, AV7cAttractionsName, AV8cCategoryId, AV9cCountryId, AV10cCountryCityId) ;
      }
      send_integrity_footer_hashes( ) ;
      return 0 ;
   }

   public void before_start_formulas( )
   {
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup1T0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e171T2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         nRC_GXsfl_64 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_64"), ".", ",")) ;
         GRID1_nFirstRecordOnPage = localUtil.ctol( httpContext.cgiGet( "GRID1_nFirstRecordOnPage"), ".", ",") ;
         GRID1_nEOF = (byte)(localUtil.ctol( httpContext.cgiGet( "GRID1_nEOF"), ".", ",")) ;
         /* Read variables values. */
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCattractionsid_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCattractionsid_Internalname), ".", ",") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCATTRACTIONSID");
            GX_FocusControl = edtavCattractionsid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV6cAttractionsId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6cAttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6cAttractionsId), 4, 0));
         }
         else
         {
            AV6cAttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCattractionsid_Internalname), ".", ",")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV6cAttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV6cAttractionsId), 4, 0));
         }
         AV7cAttractionsName = httpContext.cgiGet( edtavCattractionsname_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7cAttractionsName", AV7cAttractionsName);
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCcategoryid_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCcategoryid_Internalname), ".", ",") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCCATEGORYID");
            GX_FocusControl = edtavCcategoryid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV8cCategoryId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8cCategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8cCategoryId), 4, 0));
         }
         else
         {
            AV8cCategoryId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCcategoryid_Internalname), ".", ",")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV8cCategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV8cCategoryId), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCcountryid_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCcountryid_Internalname), ".", ",") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCCOUNTRYID");
            GX_FocusControl = edtavCcountryid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV9cCountryId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9cCountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9cCountryId), 4, 0));
         }
         else
         {
            AV9cCountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCcountryid_Internalname), ".", ",")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV9cCountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV9cCountryId), 4, 0));
         }
         if ( ( ( localUtil.ctol( httpContext.cgiGet( edtavCcountrycityid_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtavCcountrycityid_Internalname), ".", ",") > 9999 ) ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "vCCOUNTRYCITYID");
            GX_FocusControl = edtavCcountrycityid_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            wbErr = true ;
            AV10cCountryCityId = (short)(0) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10cCountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10cCountryCityId), 4, 0));
         }
         else
         {
            AV10cCountryCityId = (short)(localUtil.ctol( httpContext.cgiGet( edtavCcountrycityid_Internalname), ".", ",")) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV10cCountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV10cCountryCityId), 4, 0));
         }
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         /* Check if conditions changed and reset current page numbers */
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCATTRACTIONSID"), ".", ",") != AV6cAttractionsId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( GXutil.strcmp(httpContext.cgiGet( "GXH_vCATTRACTIONSNAME"), AV7cAttractionsName) != 0 )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCATEGORYID"), ".", ",") != AV8cCategoryId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCOUNTRYID"), ".", ",") != AV9cCountryId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
         if ( localUtil.ctol( httpContext.cgiGet( "GXH_vCCOUNTRYCITYID"), ".", ",") != AV10cCountryCityId )
         {
            GRID1_nFirstRecordOnPage = 0 ;
         }
      }
      else
      {
         dynload_actions( ) ;
      }
   }

   protected void GXStart( )
   {
      /* Execute user event: Start */
      e171T2 ();
      if (returnInSub) return;
   }

   public void e171T2( )
   {
      /* Start Routine */
      returnInSub = false ;
      Form.setCaption( GXutil.format( "Selection List %1", "Attractions", "", "", "", "", "", "", "", "") );
      httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
      AV12ADVANCED_LABEL_TEMPLATE = "%1 <strong>%2</strong>" ;
   }

   private void e181T2( )
   {
      /* Load Routine */
      returnInSub = false ;
      edtavLinkselection_gximage = "selectRow" ;
      AV5LinkSelection = context.getHttpContext().getImagePath( "3914535b-0c03-44c5-9538-906a99cdd2bc", "", context.getHttpContext().getTheme( )) ;
      httpContext.ajax_rsp_assign_attri("", false, edtavLinkselection_Internalname, AV5LinkSelection);
      AV15Linkselection_GXI = GXDbFile.pathToUrl( context.getHttpContext().getImagePath( "3914535b-0c03-44c5-9538-906a99cdd2bc", "", context.getHttpContext().getTheme( )), context.getHttpContext()) ;
      sendrow_642( ) ;
      GRID1_nCurrentRecord = (long)(GRID1_nCurrentRecord+1) ;
      if ( isFullAjaxMode( ) && ! bGXsfl_64_Refreshing )
      {
         httpContext.doAjaxLoad(64, Grid1Row);
      }
   }

   public void GXEnter( )
   {
      /* Execute user event: Enter */
      e191T2 ();
      if (returnInSub) return;
   }

   public void e191T2( )
   {
      /* Enter Routine */
      returnInSub = false ;
      AV11pAttractionsId = A9AttractionsId ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11pAttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11pAttractionsId), 4, 0));
      httpContext.setWebReturnParms(new Object[] {Short.valueOf(AV11pAttractionsId)});
      httpContext.setWebReturnParmsMetadata(new Object[] {"AV11pAttractionsId"});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      returnInSub = true;
      if (true) return;
      /*  Sending Event outputs  */
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV11pAttractionsId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11pAttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11pAttractionsId), 4, 0));
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
      pa1T2( ) ;
      ws1T2( ) ;
      we1T2( ) ;
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20235231554350", true, true);
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
      httpContext.AddJavascriptSource("gx0050.js", "?20235231554350", false, true);
      /* End function include_jscripts */
   }

   public void subsflControlProps_642( )
   {
      edtavLinkselection_Internalname = "vLINKSELECTION_"+sGXsfl_64_idx ;
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_64_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_64_idx ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO_"+sGXsfl_64_idx ;
      edtCategoryId_Internalname = "CATEGORYID_"+sGXsfl_64_idx ;
      edtCountryId_Internalname = "COUNTRYID_"+sGXsfl_64_idx ;
      edtCountryCityId_Internalname = "COUNTRYCITYID_"+sGXsfl_64_idx ;
   }

   public void subsflControlProps_fel_642( )
   {
      edtavLinkselection_Internalname = "vLINKSELECTION_"+sGXsfl_64_fel_idx ;
      edtAttractionsId_Internalname = "ATTRACTIONSID_"+sGXsfl_64_fel_idx ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME_"+sGXsfl_64_fel_idx ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO_"+sGXsfl_64_fel_idx ;
      edtCategoryId_Internalname = "CATEGORYID_"+sGXsfl_64_fel_idx ;
      edtCountryId_Internalname = "COUNTRYID_"+sGXsfl_64_fel_idx ;
      edtCountryCityId_Internalname = "COUNTRYCITYID_"+sGXsfl_64_fel_idx ;
   }

   public void sendrow_642( )
   {
      subsflControlProps_642( ) ;
      wb1T0( ) ;
      if ( ( 10 * 1 == 0 ) || ( nGXsfl_64_idx <= subgrid1_fnc_recordsperpage( ) * 1 ) )
      {
         Grid1Row = GXWebRow.GetNew(context,Grid1Container) ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            /* None style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 1 )
         {
            /* Uniform style subfile background logic. */
            subGrid1_Backstyle = (byte)(0) ;
            subGrid1_Backcolor = subGrid1_Allbackcolor ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Uniform" ;
            }
         }
         else if ( subGrid1_Backcolorstyle == 2 )
         {
            /* Header style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Odd" ;
            }
            subGrid1_Backcolor = (int)(0x0) ;
         }
         else if ( subGrid1_Backcolorstyle == 3 )
         {
            /* Report style subfile background logic. */
            subGrid1_Backstyle = (byte)(1) ;
            if ( ((int)((nGXsfl_64_idx) % (2))) == 0 )
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Even" ;
               }
            }
            else
            {
               subGrid1_Backcolor = (int)(0x0) ;
               if ( GXutil.strcmp(subGrid1_Class, "") != 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Odd" ;
               }
            }
         }
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<tr ") ;
            httpContext.writeText( " class=\""+"PromptGrid"+"\" style=\""+""+"\"") ;
            httpContext.writeText( " gxrow=\""+sGXsfl_64_idx+"\">") ;
         }
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         edtavLinkselection_Link = "javascript:gx.popup.gxReturn(["+"'"+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")))+"'"+"]);" ;
         httpContext.ajax_rsp_assign_prop("", false, edtavLinkselection_Internalname, "Link", edtavLinkselection_Link, !bGXsfl_64_Refreshing);
         ClassString = "SelectionAttribute" + " " + ((GXutil.strcmp(edtavLinkselection_gximage, "")==0) ? "" : "GX_Image_"+edtavLinkselection_gximage+"_Class") ;
         StyleString = "" ;
         AV5LinkSelection_IsBlob = (boolean)(((GXutil.strcmp("", AV5LinkSelection)==0)&&(GXutil.strcmp("", AV15Linkselection_GXI)==0))||!(GXutil.strcmp("", AV5LinkSelection)==0)) ;
         sImgUrl = ((GXutil.strcmp("", AV5LinkSelection)==0) ? AV15Linkselection_GXI : httpContext.getResourceRelative(AV5LinkSelection)) ;
         Grid1Row.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtavLinkselection_Internalname,sImgUrl,edtavLinkselection_Link,"","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(1),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWActionColumn","","","","","","",Integer.valueOf(1),Boolean.valueOf(AV5LinkSelection_IsBlob),Boolean.valueOf(false),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsId_Internalname,GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtAttractionsId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"left"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "DescriptionAttribute" ;
         edtAttractionsName_Link = "javascript:gx.popup.gxReturn(["+"'"+PrivateUtilities.encodeJSConstant( GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")))+"'"+"]);" ;
         httpContext.ajax_rsp_assign_prop("", false, edtAttractionsName_Internalname, "Link", edtAttractionsName_Link, !bGXsfl_64_Refreshing);
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtAttractionsName_Internalname,A10AttractionsName,"","","'"+""+"'"+",false,"+"'"+""+"'",edtAttractionsName_Link,"","","",edtAttractionsName_Jsonclick,Integer.valueOf(0),"DescriptionAttribute","",ROClassString,"WWColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+""+"\""+" style=\""+""+"\">") ;
         }
         /* Static Bitmap Variable */
         ClassString = "ImageAttribute" ;
         StyleString = "" ;
         A11AttractionsPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A11AttractionsPhoto)==0)&&(GXutil.strcmp("", A40000AttractionsPhoto_GXI)==0))||!(GXutil.strcmp("", A11AttractionsPhoto)==0)) ;
         sImgUrl = ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.getResourceRelative(A11AttractionsPhoto)) ;
         Grid1Row.AddColumnProperties("bitmap", 1, isAjaxCallMode( ), new Object[] {edtAttractionsPhoto_Internalname,sImgUrl,"","","",context.getHttpContext().getTheme( ),Integer.valueOf(-1),Integer.valueOf(0),"","",Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),"px",Integer.valueOf(0),"px",Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(0),"","",StyleString,ClassString,"WWColumn OptionalColumn","","","","","","",Integer.valueOf(1),Boolean.valueOf(A11AttractionsPhoto_IsBlob),Boolean.valueOf(true),context.getHttpContext().getImageSrcSet( sImgUrl)});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCategoryId_Internalname,GXutil.ltrim( localUtil.ntoc( A3CategoryId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CategoryId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCategoryId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryId_Internalname,GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A5CountryId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         /* Subfile cell */
         if ( Grid1Container.GetWrapped() == 1 )
         {
            httpContext.writeText( "<td valign=\"middle\" align=\""+"right"+"\""+" style=\""+""+"\">") ;
         }
         /* Single line edit */
         ROClassString = "Attribute" ;
         Grid1Row.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryCityId_Internalname,GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A12CountryCityId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryCityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"WWColumn OptionalColumn","",Integer.valueOf(-1),Integer.valueOf(0),Integer.valueOf(0),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(64),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
         send_integrity_lvl_hashes1T2( ) ;
         Grid1Container.AddRow(Grid1Row);
         nGXsfl_64_idx = ((subGrid1_Islastpage==1)&&(nGXsfl_64_idx+1>subgrid1_fnc_recordsperpage( )) ? 1 : nGXsfl_64_idx+1) ;
         sGXsfl_64_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_64_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_642( ) ;
      }
      /* End function sendrow_642 */
   }

   public void startgridcontrol64( )
   {
      if ( Grid1Container.GetWrapped() == 1 )
      {
         httpContext.writeText( "<div id=\""+"Grid1Container"+"DivS\" data-gxgridid=\"64\">") ;
         sStyleString = "" ;
         com.kbbaru.GxWebStd.gx_table_start( httpContext, subGrid1_Internalname, subGrid1_Internalname, "", "PromptGrid", 0, "", "", 1, 2, sStyleString, "", "", 0);
         /* Subfile titles */
         httpContext.writeText( "<tr") ;
         httpContext.writeTextNL( ">") ;
         if ( subGrid1_Backcolorstyle == 0 )
         {
            subGrid1_Titlebackstyle = (byte)(0) ;
            if ( GXutil.len( subGrid1_Class) > 0 )
            {
               subGrid1_Linesclass = subGrid1_Class+"Title" ;
            }
         }
         else
         {
            subGrid1_Titlebackstyle = (byte)(1) ;
            if ( subGrid1_Backcolorstyle == 1 )
            {
               subGrid1_Titlebackcolor = subGrid1_Allbackcolor ;
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"UniformTitle" ;
               }
            }
            else
            {
               if ( GXutil.len( subGrid1_Class) > 0 )
               {
                  subGrid1_Linesclass = subGrid1_Class+"Title" ;
               }
            }
         }
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"SelectionAttribute"+" "+((GXutil.strcmp(edtavLinkselection_gximage, "")==0) ? "" : "GX_Image_"+edtavLinkselection_gximage+"_Class")+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"left"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"DescriptionAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Name") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+""+"\" "+" nowrap=\"nowrap\" "+" class=\""+"ImageAttribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Photo") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Category Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Country Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeText( "<th align=\""+"right"+"\" "+" nowrap=\"nowrap\" "+" class=\""+"Attribute"+"\" "+" style=\""+""+""+"\" "+">") ;
         httpContext.writeValue( "Country City Id") ;
         httpContext.writeTextNL( "</th>") ;
         httpContext.writeTextNL( "</tr>") ;
         Grid1Container.AddObjectProperty("GridName", "Grid1");
      }
      else
      {
         if ( isAjaxCallMode( ) )
         {
            Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
         }
         else
         {
            Grid1Container.Clear();
         }
         Grid1Container.SetWrapped(nGXWrapped);
         Grid1Container.AddObjectProperty("GridName", "Grid1");
         Grid1Container.AddObjectProperty("Header", subGrid1_Header);
         Grid1Container.AddObjectProperty("Class", "PromptGrid");
         Grid1Container.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGrid1_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("CmpContext", "");
         Grid1Container.AddObjectProperty("InMasterPage", "false");
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", httpContext.convertURL( AV5LinkSelection));
         Grid1Column.AddObjectProperty("Link", GXutil.rtrim( edtavLinkselection_Link));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", ""))));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( A10AttractionsName));
         Grid1Column.AddObjectProperty("Link", GXutil.rtrim( edtAttractionsName_Link));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", httpContext.convertURL( A11AttractionsPhoto));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A3CategoryId, (byte)(4), (byte)(0), ".", ""))));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", ""))));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Column = GXWebColumn.GetNew(isAjaxCallMode( )) ;
         Grid1Column.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", ""))));
         Grid1Container.AddColumnProperties(Grid1Column);
         Grid1Container.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectedindex, (byte)(4), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowselection, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowhovering, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGrid1_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGrid1_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
         Grid1Container.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGrid1_Collapsed, (byte)(1), (byte)(0), ".", "")));
      }
   }

   public void init_default_properties( )
   {
      lblLblattractionsidfilter_Internalname = "LBLATTRACTIONSIDFILTER" ;
      edtavCattractionsid_Internalname = "vCATTRACTIONSID" ;
      divAttractionsidfiltercontainer_Internalname = "ATTRACTIONSIDFILTERCONTAINER" ;
      lblLblattractionsnamefilter_Internalname = "LBLATTRACTIONSNAMEFILTER" ;
      edtavCattractionsname_Internalname = "vCATTRACTIONSNAME" ;
      divAttractionsnamefiltercontainer_Internalname = "ATTRACTIONSNAMEFILTERCONTAINER" ;
      lblLblcategoryidfilter_Internalname = "LBLCATEGORYIDFILTER" ;
      edtavCcategoryid_Internalname = "vCCATEGORYID" ;
      divCategoryidfiltercontainer_Internalname = "CATEGORYIDFILTERCONTAINER" ;
      lblLblcountryidfilter_Internalname = "LBLCOUNTRYIDFILTER" ;
      edtavCcountryid_Internalname = "vCCOUNTRYID" ;
      divCountryidfiltercontainer_Internalname = "COUNTRYIDFILTERCONTAINER" ;
      lblLblcountrycityidfilter_Internalname = "LBLCOUNTRYCITYIDFILTER" ;
      edtavCcountrycityid_Internalname = "vCCOUNTRYCITYID" ;
      divCountrycityidfiltercontainer_Internalname = "COUNTRYCITYIDFILTERCONTAINER" ;
      divAdvancedcontainer_Internalname = "ADVANCEDCONTAINER" ;
      bttBtntoggle_Internalname = "BTNTOGGLE" ;
      edtavLinkselection_Internalname = "vLINKSELECTION" ;
      edtAttractionsId_Internalname = "ATTRACTIONSID" ;
      edtAttractionsName_Internalname = "ATTRACTIONSNAME" ;
      edtAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO" ;
      edtCategoryId_Internalname = "CATEGORYID" ;
      edtCountryId_Internalname = "COUNTRYID" ;
      edtCountryCityId_Internalname = "COUNTRYCITYID" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      divGridtable_Internalname = "GRIDTABLE" ;
      divMain_Internalname = "MAIN" ;
      Form.setInternalname( "FORM" );
      subGrid1_Internalname = "GRID1" ;
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
      subGrid1_Allowcollapsing = (byte)(0) ;
      subGrid1_Allowselection = (byte)(0) ;
      subGrid1_Header = "" ;
      edtCountryCityId_Jsonclick = "" ;
      edtCountryId_Jsonclick = "" ;
      edtCategoryId_Jsonclick = "" ;
      edtAttractionsName_Jsonclick = "" ;
      edtAttractionsName_Link = "" ;
      edtAttractionsId_Jsonclick = "" ;
      edtavLinkselection_gximage = "" ;
      edtavLinkselection_Link = "" ;
      subGrid1_Class = "PromptGrid" ;
      subGrid1_Backcolorstyle = (byte)(0) ;
      edtavCcountrycityid_Jsonclick = "" ;
      edtavCcountrycityid_Enabled = 1 ;
      edtavCcountrycityid_Visible = 1 ;
      edtavCcountryid_Jsonclick = "" ;
      edtavCcountryid_Enabled = 1 ;
      edtavCcountryid_Visible = 1 ;
      edtavCcategoryid_Jsonclick = "" ;
      edtavCcategoryid_Enabled = 1 ;
      edtavCcategoryid_Visible = 1 ;
      edtavCattractionsname_Jsonclick = "" ;
      edtavCattractionsname_Enabled = 1 ;
      edtavCattractionsname_Visible = 1 ;
      edtavCattractionsid_Jsonclick = "" ;
      edtavCattractionsid_Enabled = 1 ;
      edtavCattractionsid_Visible = 1 ;
      divCountrycityidfiltercontainer_Class = "AdvancedContainerItem" ;
      divCountryidfiltercontainer_Class = "AdvancedContainerItem" ;
      divCategoryidfiltercontainer_Class = "AdvancedContainerItem" ;
      divAttractionsnamefiltercontainer_Class = "AdvancedContainerItem" ;
      divAttractionsidfiltercontainer_Class = "AdvancedContainerItem" ;
      bttBtntoggle_Class = "BtnToggle" ;
      divAdvancedcontainer_Class = "AdvancedContainerVisible" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Selection List Attractions" );
      subGrid1_Rows = 10 ;
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cAttractionsId',fld:'vCATTRACTIONSID',pic:'ZZZ9'},{av:'AV7cAttractionsName',fld:'vCATTRACTIONSNAME',pic:''},{av:'AV8cCategoryId',fld:'vCCATEGORYID',pic:'ZZZ9'},{av:'AV9cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV10cCountryCityId',fld:'vCCOUNTRYCITYID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("'TOGGLE'","{handler:'e161T1',iparms:[{av:'divAdvancedcontainer_Class',ctrl:'ADVANCEDCONTAINER',prop:'Class'},{ctrl:'BTNTOGGLE',prop:'Class'}]");
      setEventMetadata("'TOGGLE'",",oparms:[{av:'divAdvancedcontainer_Class',ctrl:'ADVANCEDCONTAINER',prop:'Class'},{ctrl:'BTNTOGGLE',prop:'Class'}]}");
      setEventMetadata("LBLATTRACTIONSIDFILTER.CLICK","{handler:'e111T1',iparms:[{av:'divAttractionsidfiltercontainer_Class',ctrl:'ATTRACTIONSIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLATTRACTIONSIDFILTER.CLICK",",oparms:[{av:'divAttractionsidfiltercontainer_Class',ctrl:'ATTRACTIONSIDFILTERCONTAINER',prop:'Class'},{av:'edtavCattractionsid_Visible',ctrl:'vCATTRACTIONSID',prop:'Visible'}]}");
      setEventMetadata("LBLATTRACTIONSNAMEFILTER.CLICK","{handler:'e121T1',iparms:[{av:'divAttractionsnamefiltercontainer_Class',ctrl:'ATTRACTIONSNAMEFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLATTRACTIONSNAMEFILTER.CLICK",",oparms:[{av:'divAttractionsnamefiltercontainer_Class',ctrl:'ATTRACTIONSNAMEFILTERCONTAINER',prop:'Class'},{av:'edtavCattractionsname_Visible',ctrl:'vCATTRACTIONSNAME',prop:'Visible'}]}");
      setEventMetadata("LBLCATEGORYIDFILTER.CLICK","{handler:'e131T1',iparms:[{av:'divCategoryidfiltercontainer_Class',ctrl:'CATEGORYIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLCATEGORYIDFILTER.CLICK",",oparms:[{av:'divCategoryidfiltercontainer_Class',ctrl:'CATEGORYIDFILTERCONTAINER',prop:'Class'},{av:'edtavCcategoryid_Visible',ctrl:'vCCATEGORYID',prop:'Visible'}]}");
      setEventMetadata("LBLCOUNTRYIDFILTER.CLICK","{handler:'e141T1',iparms:[{av:'divCountryidfiltercontainer_Class',ctrl:'COUNTRYIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLCOUNTRYIDFILTER.CLICK",",oparms:[{av:'divCountryidfiltercontainer_Class',ctrl:'COUNTRYIDFILTERCONTAINER',prop:'Class'},{av:'edtavCcountryid_Visible',ctrl:'vCCOUNTRYID',prop:'Visible'}]}");
      setEventMetadata("LBLCOUNTRYCITYIDFILTER.CLICK","{handler:'e151T1',iparms:[{av:'divCountrycityidfiltercontainer_Class',ctrl:'COUNTRYCITYIDFILTERCONTAINER',prop:'Class'}]");
      setEventMetadata("LBLCOUNTRYCITYIDFILTER.CLICK",",oparms:[{av:'divCountrycityidfiltercontainer_Class',ctrl:'COUNTRYCITYIDFILTERCONTAINER',prop:'Class'},{av:'edtavCcountrycityid_Visible',ctrl:'vCCOUNTRYCITYID',prop:'Visible'}]}");
      setEventMetadata("ENTER","{handler:'e191T2',iparms:[{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[{av:'AV11pAttractionsId',fld:'vPATTRACTIONSID',pic:'ZZZ9'}]}");
      setEventMetadata("GRID1_FIRSTPAGE","{handler:'subgrid1_firstpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cAttractionsId',fld:'vCATTRACTIONSID',pic:'ZZZ9'},{av:'AV7cAttractionsName',fld:'vCATTRACTIONSNAME',pic:''},{av:'AV8cCategoryId',fld:'vCCATEGORYID',pic:'ZZZ9'},{av:'AV9cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV10cCountryCityId',fld:'vCCOUNTRYCITYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_FIRSTPAGE",",oparms:[]}");
      setEventMetadata("GRID1_PREVPAGE","{handler:'subgrid1_previouspage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cAttractionsId',fld:'vCATTRACTIONSID',pic:'ZZZ9'},{av:'AV7cAttractionsName',fld:'vCATTRACTIONSNAME',pic:''},{av:'AV8cCategoryId',fld:'vCCATEGORYID',pic:'ZZZ9'},{av:'AV9cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV10cCountryCityId',fld:'vCCOUNTRYCITYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_PREVPAGE",",oparms:[]}");
      setEventMetadata("GRID1_NEXTPAGE","{handler:'subgrid1_nextpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cAttractionsId',fld:'vCATTRACTIONSID',pic:'ZZZ9'},{av:'AV7cAttractionsName',fld:'vCATTRACTIONSNAME',pic:''},{av:'AV8cCategoryId',fld:'vCCATEGORYID',pic:'ZZZ9'},{av:'AV9cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV10cCountryCityId',fld:'vCCOUNTRYCITYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_NEXTPAGE",",oparms:[]}");
      setEventMetadata("GRID1_LASTPAGE","{handler:'subgrid1_lastpage',iparms:[{av:'GRID1_nFirstRecordOnPage'},{av:'GRID1_nEOF'},{av:'subGrid1_Rows',ctrl:'GRID1',prop:'Rows'},{av:'AV6cAttractionsId',fld:'vCATTRACTIONSID',pic:'ZZZ9'},{av:'AV7cAttractionsName',fld:'vCATTRACTIONSNAME',pic:''},{av:'AV8cCategoryId',fld:'vCCATEGORYID',pic:'ZZZ9'},{av:'AV9cCountryId',fld:'vCCOUNTRYID',pic:'ZZZ9'},{av:'AV10cCountryCityId',fld:'vCCOUNTRYCITYID',pic:'ZZZ9'}]");
      setEventMetadata("GRID1_LASTPAGE",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Countrycityid',iparms:[]");
      setEventMetadata("NULL",",oparms:[]}");
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
      AV7cAttractionsName = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblLblattractionsidfilter_Jsonclick = "" ;
      TempTags = "" ;
      lblLblattractionsnamefilter_Jsonclick = "" ;
      lblLblcategoryidfilter_Jsonclick = "" ;
      lblLblcountryidfilter_Jsonclick = "" ;
      lblLblcountrycityidfilter_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      bttBtntoggle_Jsonclick = "" ;
      Grid1Container = new com.genexus.webpanels.GXWebGrid(context);
      sStyleString = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV5LinkSelection = "" ;
      AV15Linkselection_GXI = "" ;
      A10AttractionsName = "" ;
      A11AttractionsPhoto = "" ;
      A40000AttractionsPhoto_GXI = "" ;
      scmdbuf = "" ;
      lV7cAttractionsName = "" ;
      H001T2_A12CountryCityId = new short[1] ;
      H001T2_A5CountryId = new short[1] ;
      H001T2_A3CategoryId = new short[1] ;
      H001T2_A11AttractionsPhoto = new String[] {""} ;
      H001T2_A40000AttractionsPhoto_GXI = new String[] {""} ;
      H001T2_A10AttractionsName = new String[] {""} ;
      H001T2_A9AttractionsId = new short[1] ;
      H001T3_AGRID1_nRecordCount = new long[1] ;
      AV12ADVANCED_LABEL_TEMPLATE = "" ;
      Grid1Row = new com.genexus.webpanels.GXWebRow();
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      subGrid1_Linesclass = "" ;
      sImgUrl = "" ;
      ROClassString = "" ;
      Grid1Column = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.gx0050__default(),
         new Object[] {
             new Object[] {
            H001T2_A12CountryCityId, H001T2_A5CountryId, H001T2_A3CategoryId, H001T2_A11AttractionsPhoto, H001T2_A40000AttractionsPhoto_GXI, H001T2_A10AttractionsName, H001T2_A9AttractionsId
            }
            , new Object[] {
            H001T3_AGRID1_nRecordCount
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte GRID1_nEOF ;
   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte subGrid1_Backcolorstyle ;
   private byte nGXWrapped ;
   private byte subGrid1_Backstyle ;
   private byte subGrid1_Titlebackstyle ;
   private byte subGrid1_Allowselection ;
   private byte subGrid1_Allowhovering ;
   private byte subGrid1_Allowcollapsing ;
   private byte subGrid1_Collapsed ;
   private short AV11pAttractionsId ;
   private short AV6cAttractionsId ;
   private short AV8cCategoryId ;
   private short AV9cCountryId ;
   private short AV10cCountryCityId ;
   private short wbEnd ;
   private short wbStart ;
   private short A9AttractionsId ;
   private short A3CategoryId ;
   private short A5CountryId ;
   private short A12CountryCityId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private int nRC_GXsfl_64 ;
   private int subGrid1_Rows ;
   private int nGXsfl_64_idx=1 ;
   private int edtavCattractionsid_Enabled ;
   private int edtavCattractionsid_Visible ;
   private int edtavCattractionsname_Visible ;
   private int edtavCattractionsname_Enabled ;
   private int edtavCcategoryid_Enabled ;
   private int edtavCcategoryid_Visible ;
   private int edtavCcountryid_Enabled ;
   private int edtavCcountryid_Visible ;
   private int edtavCcountrycityid_Enabled ;
   private int edtavCcountrycityid_Visible ;
   private int subGrid1_Islastpage ;
   private int GXPagingFrom2 ;
   private int GXPagingTo2 ;
   private int idxLst ;
   private int subGrid1_Backcolor ;
   private int subGrid1_Allbackcolor ;
   private int subGrid1_Titlebackcolor ;
   private int subGrid1_Selectedindex ;
   private int subGrid1_Selectioncolor ;
   private int subGrid1_Hoveringcolor ;
   private long GRID1_nFirstRecordOnPage ;
   private long GRID1_nCurrentRecord ;
   private long GRID1_nRecordCount ;
   private String divAdvancedcontainer_Class ;
   private String bttBtntoggle_Class ;
   private String divAttractionsidfiltercontainer_Class ;
   private String divAttractionsnamefiltercontainer_Class ;
   private String divCategoryidfiltercontainer_Class ;
   private String divCountryidfiltercontainer_Class ;
   private String divCountrycityidfiltercontainer_Class ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String sGXsfl_64_idx="0001" ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMain_Internalname ;
   private String divAdvancedcontainer_Internalname ;
   private String divAttractionsidfiltercontainer_Internalname ;
   private String lblLblattractionsidfilter_Internalname ;
   private String lblLblattractionsidfilter_Jsonclick ;
   private String edtavCattractionsid_Internalname ;
   private String TempTags ;
   private String edtavCattractionsid_Jsonclick ;
   private String divAttractionsnamefiltercontainer_Internalname ;
   private String lblLblattractionsnamefilter_Internalname ;
   private String lblLblattractionsnamefilter_Jsonclick ;
   private String edtavCattractionsname_Internalname ;
   private String edtavCattractionsname_Jsonclick ;
   private String divCategoryidfiltercontainer_Internalname ;
   private String lblLblcategoryidfilter_Internalname ;
   private String lblLblcategoryidfilter_Jsonclick ;
   private String edtavCcategoryid_Internalname ;
   private String edtavCcategoryid_Jsonclick ;
   private String divCountryidfiltercontainer_Internalname ;
   private String lblLblcountryidfilter_Internalname ;
   private String lblLblcountryidfilter_Jsonclick ;
   private String edtavCcountryid_Internalname ;
   private String edtavCcountryid_Jsonclick ;
   private String divCountrycityidfiltercontainer_Internalname ;
   private String lblLblcountrycityidfilter_Internalname ;
   private String lblLblcountrycityidfilter_Jsonclick ;
   private String edtavCcountrycityid_Internalname ;
   private String edtavCcountrycityid_Jsonclick ;
   private String divGridtable_Internalname ;
   private String ClassString ;
   private String StyleString ;
   private String bttBtntoggle_Internalname ;
   private String bttBtntoggle_Jsonclick ;
   private String sStyleString ;
   private String subGrid1_Internalname ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String edtavLinkselection_Internalname ;
   private String edtAttractionsId_Internalname ;
   private String edtAttractionsName_Internalname ;
   private String edtAttractionsPhoto_Internalname ;
   private String edtCategoryId_Internalname ;
   private String edtCountryId_Internalname ;
   private String edtCountryCityId_Internalname ;
   private String scmdbuf ;
   private String AV12ADVANCED_LABEL_TEMPLATE ;
   private String edtavLinkselection_gximage ;
   private String sGXsfl_64_fel_idx="0001" ;
   private String subGrid1_Class ;
   private String subGrid1_Linesclass ;
   private String edtavLinkselection_Link ;
   private String sImgUrl ;
   private String ROClassString ;
   private String edtAttractionsId_Jsonclick ;
   private String edtAttractionsName_Link ;
   private String edtAttractionsName_Jsonclick ;
   private String edtCategoryId_Jsonclick ;
   private String edtCountryId_Jsonclick ;
   private String edtCountryCityId_Jsonclick ;
   private String subGrid1_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean bGXsfl_64_Refreshing=false ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean AV5LinkSelection_IsBlob ;
   private boolean A11AttractionsPhoto_IsBlob ;
   private String AV7cAttractionsName ;
   private String AV15Linkselection_GXI ;
   private String A10AttractionsName ;
   private String A40000AttractionsPhoto_GXI ;
   private String lV7cAttractionsName ;
   private String AV5LinkSelection ;
   private String A11AttractionsPhoto ;
   private com.genexus.webpanels.GXWebGrid Grid1Container ;
   private com.genexus.webpanels.GXWebRow Grid1Row ;
   private com.genexus.webpanels.GXWebColumn Grid1Column ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private IDataStoreProvider pr_default ;
   private short[] H001T2_A12CountryCityId ;
   private short[] H001T2_A5CountryId ;
   private short[] H001T2_A3CategoryId ;
   private String[] H001T2_A11AttractionsPhoto ;
   private String[] H001T2_A40000AttractionsPhoto_GXI ;
   private String[] H001T2_A10AttractionsName ;
   private short[] H001T2_A9AttractionsId ;
   private long[] H001T3_AGRID1_nRecordCount ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class gx0050__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_H001T2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV7cAttractionsName ,
                                          short AV8cCategoryId ,
                                          short AV9cCountryId ,
                                          short AV10cCountryCityId ,
                                          String A10AttractionsName ,
                                          short A3CategoryId ,
                                          short A5CountryId ,
                                          short A12CountryCityId ,
                                          short AV6cAttractionsId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[8];
      Object[] GXv_Object2 = new Object[2];
      String sSelectString;
      String sFromString;
      String sOrderString;
      sSelectString = " CountryCityId, CountryId, CategoryId, AttractionsPhoto, AttractionsPhoto_GXI, AttractionsName, AttractionsId" ;
      sFromString = " FROM Attractions" ;
      sOrderString = "" ;
      addWhere(sWhereString, "(AttractionsId >= ?)");
      if ( ! (GXutil.strcmp("", AV7cAttractionsName)==0) )
      {
         addWhere(sWhereString, "(AttractionsName like ?)");
      }
      else
      {
         GXv_int1[1] = (byte)(1) ;
      }
      if ( ! (0==AV8cCategoryId) )
      {
         addWhere(sWhereString, "(CategoryId >= ?)");
      }
      else
      {
         GXv_int1[2] = (byte)(1) ;
      }
      if ( ! (0==AV9cCountryId) )
      {
         addWhere(sWhereString, "(CountryId >= ?)");
      }
      else
      {
         GXv_int1[3] = (byte)(1) ;
      }
      if ( ! (0==AV10cCountryCityId) )
      {
         addWhere(sWhereString, "(CountryCityId >= ?)");
      }
      else
      {
         GXv_int1[4] = (byte)(1) ;
      }
      sOrderString += " ORDER BY AttractionsId" ;
      scmdbuf = "SELECT " + sSelectString + sFromString + sWhereString + sOrderString + "" + " OFFSET " + "?" + " LIMIT CASE WHEN " + "?" + " > 0 THEN " + "?" + " ELSE 1e9 END" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   protected Object[] conditional_H001T3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV7cAttractionsName ,
                                          short AV8cCategoryId ,
                                          short AV9cCountryId ,
                                          short AV10cCountryCityId ,
                                          String A10AttractionsName ,
                                          short A3CategoryId ,
                                          short A5CountryId ,
                                          short A12CountryCityId ,
                                          short AV6cAttractionsId )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[5];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT COUNT(*) FROM Attractions" ;
      addWhere(sWhereString, "(AttractionsId >= ?)");
      if ( ! (GXutil.strcmp("", AV7cAttractionsName)==0) )
      {
         addWhere(sWhereString, "(AttractionsName like ?)");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      if ( ! (0==AV8cCategoryId) )
      {
         addWhere(sWhereString, "(CategoryId >= ?)");
      }
      else
      {
         GXv_int3[2] = (byte)(1) ;
      }
      if ( ! (0==AV9cCountryId) )
      {
         addWhere(sWhereString, "(CountryId >= ?)");
      }
      else
      {
         GXv_int3[3] = (byte)(1) ;
      }
      if ( ! (0==AV10cCountryCityId) )
      {
         addWhere(sWhereString, "(CountryCityId >= ?)");
      }
      else
      {
         GXv_int3[4] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 0 :
                  return conditional_H001T2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() );
            case 1 :
                  return conditional_H001T3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).shortValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).shortValue() , (String)dynConstraints[4] , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001T2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("H001T3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[3])[0] = rslt.getMultimediaFile(4, rslt.getVarchar(5));
               ((String[]) buf[4])[0] = rslt.getMultimediaUri(5);
               ((String[]) buf[5])[0] = rslt.getVarchar(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[9], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[12]).shortValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[13]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setVarchar(sIdx, (String)parms[6], 40);
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               return;
      }
   }

}

