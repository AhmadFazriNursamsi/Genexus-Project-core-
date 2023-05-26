package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class viewcategory_impl extends GXDataArea
{
   public viewcategory_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public viewcategory_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( viewcategory_impl.class ));
   }

   public viewcategory_impl( int remoteHandle ,
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
         gxfirstwebparm = httpContext.GetFirstPar( "CategoryId") ;
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
            gxfirstwebparm = httpContext.GetFirstPar( "CategoryId") ;
         }
         else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
         {
            if ( ! httpContext.IsValidAjaxCall( true) )
            {
               GxWebError = (byte)(1) ;
               return  ;
            }
            gxfirstwebparm = httpContext.GetFirstPar( "CategoryId") ;
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
            AV12CategoryId = (short)(GXutil.lval( gxfirstwebparm)) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV12CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12CategoryId), 4, 0));
            com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATEGORYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12CategoryId), "ZZZ9")));
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
            {
               AV6TabCode = httpContext.GetPar( "TabCode") ;
               httpContext.ajax_rsp_assign_attri("", false, "AV6TabCode", AV6TabCode);
               com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6TabCode, ""))));
            }
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
      pa1N2( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         start1N2( ) ;
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
      httpContext.AddJavascriptSource("shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/BasicTabRender.js", "", false, true);
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.viewcategory", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV12CategoryId,4,0)),GXutil.URLEncode(GXutil.rtrim(AV6TabCode))}, new String[] {"CategoryId","TabCode"}) +"\">") ;
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
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vCATEGORYID", GXutil.ltrim( localUtil.ntoc( AV12CategoryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATEGORYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12CategoryId), "ZZZ9")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vTABCODE", GXutil.rtrim( AV6TabCode));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6TabCode, ""))));
      GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"ViewCategory");
      forbiddenHiddens.add("CategoryName", GXutil.rtrim( localUtil.format( A4CategoryName, "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("viewcategory:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_boolean_hidden_field( httpContext, "vLOADALLTABS", AV11LoadAllTabs);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vSELECTEDTABCODE", GXutil.rtrim( AV7SelectedTabCode));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vCATEGORYID", GXutil.ltrim( localUtil.ntoc( AV12CategoryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATEGORYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12CategoryId), "ZZZ9")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vTABCODE", GXutil.rtrim( AV6TabCode));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6TabCode, ""))));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "TAB_Activepagecontrolname", GXutil.rtrim( Tab_Activepagecontrolname));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "TAB_Pagecount", GXutil.ltrim( localUtil.ntoc( Tab_Pagecount, (byte)(9), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "TAB_Class", GXutil.rtrim( Tab_Class));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "TAB_Historymanagement", GXutil.booltostr( Tab_Historymanagement));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "TAB_Activepagecontrolname", GXutil.rtrim( Tab_Activepagecontrolname));
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
      if ( ! ( WebComp_Generalwc == null ) )
      {
         WebComp_Generalwc.componentjscripts();
      }
      if ( ! ( WebComp_Attractionswc == null ) )
      {
         WebComp_Attractionswc.componentjscripts();
      }
   }

   public void renderHtmlContent( )
   {
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      if ( ( gxajaxcallmode == 0 ) && ( GxWebError == 0 ) )
      {
         httpContext.writeText( "<div") ;
         com.kbbaru.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
         httpContext.writeText( ">") ;
         we1N2( ) ;
         httpContext.writeText( "</div>") ;
      }
   }

   public void dispatchEvents( )
   {
      evt1N2( ) ;
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
      return formatLink("com.kbbaru.viewcategory", new String[] {GXutil.URLEncode(GXutil.ltrimstr(AV12CategoryId,4,0)),GXutil.URLEncode(GXutil.rtrim(AV6TabCode))}, new String[] {"CategoryId","TabCode"})  ;
   }

   public String getPgmname( )
   {
      return "ViewCategory" ;
   }

   public String getPgmdesc( )
   {
      return "View Category" ;
   }

   public void wb1N0( )
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
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divTabletop_Internalname, 1, 0, "px", 0, "px", "ww__actions-container", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 ww__view__button-back__cell", "left", "top", "", "", "div");
         /* Text block */
         com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblViewall_Internalname, "Categories", lblViewall_Link, "", lblViewall_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "ww__view__button-back", 0, "", lblViewall_Visible, 1, 0, (short)(0), "HLP_ViewCategory.htm");
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
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divTablefixeddata_1_Internalname, 1, 0, "px", 0, "px", "Flex ww__view__title-table", "left", "top", " "+"data-gx-flex"+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "", "left", "top", " "+"classref"+" ", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", " gx-attribute", "left", "top", "", "", "div");
         /* Attribute/Variable Label */
         com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCategoryName_Internalname, "Name", "gx-form-item heading-01Label", 0, true, "width: 25%;");
         /* Single line edit */
         com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCategoryName_Internalname, A4CategoryName, GXutil.rtrim( localUtil.format( A4CategoryName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCategoryName_Jsonclick, 0, "heading-01", "", "", "", "", 1, edtCategoryName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_ViewCategory.htm");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         /* User Defined Control */
         ucTab.setProperty("PageCount", Tab_Pagecount);
         ucTab.setProperty("Class", Tab_Class);
         ucTab.setProperty("HistoryManagement", Tab_Historymanagement);
         ucTab.render(context, "basictab", Tab_Internalname, "TABContainer");
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABContainer"+"title1"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblGeneral_title_Internalname, "General", "", "", lblGeneral_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ViewCategory.htm");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "General") ;
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABContainer"+"panel1"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divTablegeneral_Internalname, 1, 0, "px", 0, "px", "ww__view__tab__form-container", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "W0026"+"", GXutil.rtrim( WebComp_Generalwc_Component));
            httpContext.writeText( "<div") ;
            com.kbbaru.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0026"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldGeneralwc), GXutil.lower( WebComp_Generalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0026"+"");
               }
               WebComp_Generalwc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldGeneralwc), GXutil.lower( WebComp_Generalwc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABContainer"+"title2"+"\" style=\"display:none;\">") ;
         /* Text block */
         com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblAttractions_title_Internalname, "Attractions", "", "", lblAttractions_title_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "TextBlock", 0, "", 1, 1, 0, (short)(0), "HLP_ViewCategory.htm");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", "", "display:none;", "div");
         httpContext.writeText( "Attractions") ;
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         httpContext.writeText( "<div class=\"gx_usercontrol_child\" id=\""+"TABContainer"+"panel2"+"\" style=\"display:none;\">") ;
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, divTableattractions_Internalname, 1, 0, "px", 0, "px", "ww__view__tab__form-container", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
         /* Div Control */
         com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
         if ( ! isFullAjaxMode( ) )
         {
            /* WebComponent */
            com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "W0034"+"", GXutil.rtrim( WebComp_Attractionswc_Component));
            httpContext.writeText( "<div") ;
            com.kbbaru.GxWebStd.classAttribute( httpContext, "gxwebcomponent");
            httpContext.writeText( " id=\""+"gxHTMLWrpW0034"+""+"\""+"") ;
            httpContext.writeText( ">") ;
            if ( GXutil.len( WebComp_Attractionswc_Component) != 0 )
            {
               if ( GXutil.strcmp(GXutil.lower( OldAttractionswc), GXutil.lower( WebComp_Attractionswc_Component)) != 0 )
               {
                  httpContext.ajax_rspStartCmp("gxHTMLWrpW0034"+"");
               }
               WebComp_Attractionswc.componentdraw();
               if ( GXutil.strcmp(GXutil.lower( OldAttractionswc), GXutil.lower( WebComp_Attractionswc_Component)) != 0 )
               {
                  httpContext.ajax_rspEndCmp();
               }
            }
            httpContext.writeText( "</div>") ;
         }
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         httpContext.writeText( "</div>") ;
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
         com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      }
      wbLoad = true ;
   }

   public void start1N2( )
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
         Form.getMeta().addItem("description", "View Category", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      wbErr = false ;
      strup1N0( ) ;
   }

   public void ws1N2( )
   {
      start1N2( ) ;
      evt1N2( ) ;
   }

   public void evt1N2( )
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
                        else if ( GXutil.strcmp(sEvt, "START") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Start */
                           e111N2 ();
                        }
                        else if ( GXutil.strcmp(sEvt, "LOAD") == 0 )
                        {
                           httpContext.wbHandled = (byte)(1) ;
                           dynload_actions( ) ;
                           /* Execute user event: Load */
                           e121N2 ();
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
                  else if ( GXutil.strcmp(sEvtType, "W") == 0 )
                  {
                     sEvtType = GXutil.left( sEvt, 4) ;
                     sEvt = GXutil.right( sEvt, GXutil.len( sEvt)-4) ;
                     nCmpId = (short)(GXutil.lval( sEvtType)) ;
                     if ( nCmpId == 26 )
                     {
                        OldGeneralwc = httpContext.cgiGet( "W0026") ;
                        if ( ( GXutil.len( OldGeneralwc) == 0 ) || ( GXutil.strcmp(OldGeneralwc, WebComp_Generalwc_Component) != 0 ) )
                        {
                           WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "com.kbbaru." + OldGeneralwc + "_impl", remoteHandle, context);
                           WebComp_Generalwc_Component = OldGeneralwc ;
                        }
                        if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
                        {
                           WebComp_Generalwc.componentprocess("W0026", "", sEvt);
                        }
                        WebComp_Generalwc_Component = OldGeneralwc ;
                     }
                     else if ( nCmpId == 34 )
                     {
                        OldAttractionswc = httpContext.cgiGet( "W0034") ;
                        if ( ( GXutil.len( OldAttractionswc) == 0 ) || ( GXutil.strcmp(OldAttractionswc, WebComp_Attractionswc_Component) != 0 ) )
                        {
                           WebComp_Attractionswc = WebUtils.getWebComponent(getClass(), "com.kbbaru." + OldAttractionswc + "_impl", remoteHandle, context);
                           WebComp_Attractionswc_Component = OldAttractionswc ;
                        }
                        if ( GXutil.len( WebComp_Attractionswc_Component) != 0 )
                        {
                           WebComp_Attractionswc.componentprocess("W0034", "", sEvt);
                        }
                        WebComp_Attractionswc_Component = OldAttractionswc ;
                     }
                  }
                  httpContext.wbHandled = (byte)(1) ;
               }
            }
         }
      }
   }

   public void we1N2( )
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

   public void pa1N2( )
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
      rf1N2( ) ;
      if ( isFullAjaxMode( ) )
      {
         send_integrity_footer_hashes( ) ;
      }
      /* End function Refresh */
   }

   public void initialize_formulas( )
   {
      /* GeneXus formulas. */
      AV15Pgmname = "ViewCategory" ;
      Gx_err = (short)(0) ;
   }

   public void rf1N2( )
   {
      initialize_formulas( ) ;
      clear_multi_value_controls( ) ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
            {
               WebComp_Generalwc.componentstart();
            }
         }
      }
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         if ( 1 != 0 )
         {
            if ( GXutil.len( WebComp_Attractionswc_Component) != 0 )
            {
               WebComp_Attractionswc.componentstart();
            }
         }
      }
      gxdyncontrolsrefreshing = true ;
      fix_multi_value_controls( ) ;
      gxdyncontrolsrefreshing = false ;
      if ( ! httpContext.willRedirect( ) && ( httpContext.nUserReturn != 1 ) )
      {
         /* Using cursor H001N2 */
         pr_default.execute(0, new Object[] {Short.valueOf(AV12CategoryId)});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A3CategoryId = H001N2_A3CategoryId[0] ;
            A4CategoryName = H001N2_A4CategoryName[0] ;
            httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
            /* Execute user event: Load */
            e121N2 ();
            /* Exiting from a For First loop. */
            if (true) break;
         }
         pr_default.close(0);
         wb1N0( ) ;
      }
   }

   public void send_integrity_lvl_hashes1N2( )
   {
   }

   public void before_start_formulas( )
   {
      AV15Pgmname = "ViewCategory" ;
      Gx_err = (short)(0) ;
      fix_multi_value_controls( ) ;
   }

   public void strup1N0( )
   {
      /* Before Start, stand alone formulas. */
      before_start_formulas( ) ;
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e111N2 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      /* After Start, stand alone formulas. */
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read saved SDTs. */
         /* Read saved values. */
         AV12CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( "vCATEGORYID"), ".", ",")) ;
         AV11LoadAllTabs = GXutil.strtobool( httpContext.cgiGet( "vLOADALLTABS")) ;
         AV7SelectedTabCode = httpContext.cgiGet( "vSELECTEDTABCODE") ;
         Tab_Activepagecontrolname = httpContext.cgiGet( "TAB_Activepagecontrolname") ;
         Tab_Pagecount = (int)(localUtil.ctol( httpContext.cgiGet( "TAB_Pagecount"), ".", ",")) ;
         Tab_Class = httpContext.cgiGet( "TAB_Class") ;
         Tab_Historymanagement = GXutil.strtobool( httpContext.cgiGet( "TAB_Historymanagement")) ;
         /* Read variables values. */
         A4CategoryName = httpContext.cgiGet( edtCategoryName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
         /* Read subfile selected row values. */
         /* Read hidden variables. */
         GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
         forbiddenHiddens = new com.genexus.util.GXProperties() ;
         forbiddenHiddens.add("hshsalt", "hsh"+"ViewCategory");
         A4CategoryName = httpContext.cgiGet( edtCategoryName_Internalname) ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
         forbiddenHiddens.add("CategoryName", GXutil.rtrim( localUtil.format( A4CategoryName, "")));
         hsh = httpContext.cgiGet( "hsh") ;
         if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
         {
            GXutil.writeLogError("viewcategory:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
            GxWebError = (byte)(1) ;
            httpContext.sendError( 403 );
            GXutil.writeLog("send_http_error_code 403");
            return  ;
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
      e111N2 ();
      if (returnInSub) return;
   }

   public void e111N2( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.kbbaru.general.security.isauthorized(remoteHandle, context).executeUdp( AV15Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.kbbaru.general.security.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV15Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV16GXLvl7 = (byte)(0) ;
      /* Using cursor H001N3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV12CategoryId)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CategoryId = H001N3_A3CategoryId[0] ;
         A4CategoryName = H001N3_A4CategoryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
         AV16GXLvl7 = (byte)(1) ;
         Form.setCaption( A4CategoryName );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         lblViewall_Link = formatLink("com.kbbaru.wwcategory", new String[] {}, new String[] {})  ;
         httpContext.ajax_rsp_assign_prop("", false, lblViewall_Internalname, "Link", lblViewall_Link, true);
         AV10Exists = true ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(1);
      if ( AV16GXLvl7 == 0 )
      {
         Form.setCaption( "Record not found" );
         httpContext.ajax_rsp_assign_prop("", false, "FORM", "Caption", Form.getCaption(), true);
         lblViewall_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, lblViewall_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(lblViewall_Visible), 5, 0), true);
         AV10Exists = false ;
      }
      AV11LoadAllTabs = false ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11LoadAllTabs", AV11LoadAllTabs);
      if ( AV10Exists )
      {
         AV7SelectedTabCode = AV6TabCode ;
         httpContext.ajax_rsp_assign_attri("", false, "AV7SelectedTabCode", AV7SelectedTabCode);
         Tab_Activepagecontrolname = AV7SelectedTabCode ;
         ucTab.sendProperty(context, "", false, Tab_Internalname, "ActivePageControlName", Tab_Activepagecontrolname);
         /* Execute user subroutine: 'LOAD TAB' */
         S112 ();
         if (returnInSub) return;
      }
   }

   public void S112( )
   {
      /* 'LOAD TAB' Routine */
      returnInSub = false ;
      if ( AV11LoadAllTabs || ( GXutil.strcmp(AV7SelectedTabCode, "") == 0 ) || ( GXutil.strcmp(AV7SelectedTabCode, "General") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Generalwc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Generalwc_Component), GXutil.lower( "CategoryGeneral")) != 0 )
         {
            WebComp_Generalwc = WebUtils.getWebComponent(getClass(), "com.kbbaru.categorygeneral_impl", remoteHandle, context);
            WebComp_Generalwc_Component = "CategoryGeneral" ;
         }
         if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
         {
            WebComp_Generalwc.setjustcreated();
            WebComp_Generalwc.componentprepare(new Object[] {"W0026","",Short.valueOf(AV12CategoryId)});
            WebComp_Generalwc.componentbind(new Object[] {""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Generalwc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0026"+"");
            WebComp_Generalwc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
      if ( AV11LoadAllTabs || ( GXutil.strcmp(AV7SelectedTabCode, "Attractions") == 0 ) )
      {
         /* Object Property */
         if ( true )
         {
            bDynCreated_Attractionswc = true ;
         }
         if ( GXutil.strcmp(GXutil.lower( WebComp_Attractionswc_Component), GXutil.lower( "CategoryAttractionsWC")) != 0 )
         {
            WebComp_Attractionswc = WebUtils.getWebComponent(getClass(), "com.kbbaru.categoryattractionswc_impl", remoteHandle, context);
            WebComp_Attractionswc_Component = "CategoryAttractionsWC" ;
         }
         if ( GXutil.len( WebComp_Attractionswc_Component) != 0 )
         {
            WebComp_Attractionswc.setjustcreated();
            WebComp_Attractionswc.componentprepare(new Object[] {"W0034","",Short.valueOf(AV12CategoryId)});
            WebComp_Attractionswc.componentbind(new Object[] {""});
         }
         if ( isFullAjaxMode( ) || isAjaxCallMode( ) && bDynCreated_Attractionswc )
         {
            httpContext.ajax_rspStartCmp("gxHTMLWrpW0034"+"");
            WebComp_Attractionswc.componentdraw();
            httpContext.ajax_rspEndCmp();
         }
      }
   }

   protected void nextLoad( )
   {
   }

   protected void e121N2( )
   {
      /* Load Routine */
      returnInSub = false ;
   }

   @SuppressWarnings("unchecked")
   public void setparameters( Object[] obj )
   {
      AV12CategoryId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      httpContext.ajax_rsp_assign_attri("", false, "AV12CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV12CategoryId), 4, 0));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCATEGORYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV12CategoryId), "ZZZ9")));
      AV6TabCode = (String)getParm(obj,1) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV6TabCode", AV6TabCode);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTABCODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( AV6TabCode, ""))));
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
      pa1N2( ) ;
      ws1N2( ) ;
      we1N2( ) ;
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
      httpContext.AddStyleSheetFile("Tab/BasicTab.css", "");
      httpContext.AddThemeStyleSheetFile("", context.getHttpContext().getTheme( )+".css", "?"+httpContext.getCacheInvalidationToken( ));
      if ( ! ( WebComp_Generalwc == null ) )
      {
         if ( GXutil.len( WebComp_Generalwc_Component) != 0 )
         {
            WebComp_Generalwc.componentthemes();
         }
      }
      if ( ! ( WebComp_Attractionswc == null ) )
      {
         if ( GXutil.len( WebComp_Attractionswc_Component) != 0 )
         {
            WebComp_Attractionswc.componentthemes();
         }
      }
      boolean outputEnabled = httpContext.isOutputEnabled( );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
      idxLst = 1 ;
      while ( idxLst <= Form.getJscriptsrc().getCount() )
      {
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20235231552564", true, true);
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
      httpContext.AddJavascriptSource("viewcategory.js", "?20235231552564", false, true);
      httpContext.AddJavascriptSource("shared/HistoryManager/HistoryManager.js", "", false, true);
      httpContext.AddJavascriptSource("shared/HistoryManager/rsh/json2005.js", "", false, true);
      httpContext.AddJavascriptSource("shared/HistoryManager/rsh/rsh.js", "", false, true);
      httpContext.AddJavascriptSource("shared/HistoryManager/HistoryManagerCreate.js", "", false, true);
      httpContext.AddJavascriptSource("Tab/BasicTabRender.js", "", false, true);
      /* End function include_jscripts */
   }

   public void init_default_properties( )
   {
      lblViewall_Internalname = "VIEWALL" ;
      divTabletop_Internalname = "TABLETOP" ;
      edtCategoryName_Internalname = "CATEGORYNAME" ;
      divTablefixeddata_1_Internalname = "TABLEFIXEDDATA_1" ;
      lblGeneral_title_Internalname = "GENERAL_TITLE" ;
      divTablegeneral_Internalname = "TABLEGENERAL" ;
      lblAttractions_title_Internalname = "ATTRACTIONS_TITLE" ;
      divTableattractions_Internalname = "TABLEATTRACTIONS" ;
      Tab_Internalname = "TAB" ;
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
      edtCategoryName_Jsonclick = "" ;
      edtCategoryName_Enabled = 0 ;
      lblViewall_Link = "" ;
      lblViewall_Visible = 1 ;
      Tab_Historymanagement = GXutil.toBoolean( -1) ;
      Tab_Class = "ww__view__tab" ;
      Tab_Pagecount = 2 ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "View Category" );
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
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'AV12CategoryId',fld:'vCATEGORYID',pic:'ZZZ9',hsh:true},{av:'AV6TabCode',fld:'vTABCODE',pic:'',hsh:true},{av:'A4CategoryName',fld:'CATEGORYNAME',pic:''}]");
      setEventMetadata("REFRESH",",oparms:[]}");
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
      wcpOAV6TabCode = "" ;
      Tab_Activepagecontrolname = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      AV6TabCode = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXKey = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      A4CategoryName = "" ;
      AV7SelectedTabCode = "" ;
      GX_FocusControl = "" ;
      sPrefix = "" ;
      lblViewall_Jsonclick = "" ;
      ucTab = new com.genexus.webpanels.GXUserControl();
      lblGeneral_title_Jsonclick = "" ;
      WebComp_Generalwc_Component = "" ;
      OldGeneralwc = "" ;
      lblAttractions_title_Jsonclick = "" ;
      WebComp_Attractionswc_Component = "" ;
      OldAttractionswc = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      AV15Pgmname = "" ;
      scmdbuf = "" ;
      H001N2_A3CategoryId = new short[1] ;
      H001N2_A4CategoryName = new String[] {""} ;
      hsh = "" ;
      H001N3_A3CategoryId = new short[1] ;
      H001N3_A4CategoryName = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.viewcategory__default(),
         new Object[] {
             new Object[] {
            H001N2_A3CategoryId, H001N2_A4CategoryName
            }
            , new Object[] {
            H001N3_A3CategoryId, H001N3_A4CategoryName
            }
         }
      );
      AV15Pgmname = "ViewCategory" ;
      /* GeneXus formulas. */
      AV15Pgmname = "ViewCategory" ;
      Gx_err = (short)(0) ;
      WebComp_Generalwc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
      WebComp_Attractionswc = new com.genexus.webpanels.GXWebComponentNull(remoteHandle, context);
   }

   private byte nGotPars ;
   private byte GxWebError ;
   private byte gxajaxcallmode ;
   private byte nDonePA ;
   private byte AV16GXLvl7 ;
   private byte nGXWrapped ;
   private short wcpOAV12CategoryId ;
   private short nRcdExists_3 ;
   private short nIsMod_3 ;
   private short AV12CategoryId ;
   private short wbEnd ;
   private short wbStart ;
   private short nCmpId ;
   private short gxcookieaux ;
   private short Gx_err ;
   private short A3CategoryId ;
   private int Tab_Pagecount ;
   private int lblViewall_Visible ;
   private int edtCategoryName_Enabled ;
   private int idxLst ;
   private String wcpOAV6TabCode ;
   private String Tab_Activepagecontrolname ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String AV6TabCode ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXKey ;
   private String AV7SelectedTabCode ;
   private String Tab_Class ;
   private String GX_FocusControl ;
   private String sPrefix ;
   private String divMaintable_Internalname ;
   private String divTabletop_Internalname ;
   private String lblViewall_Internalname ;
   private String lblViewall_Link ;
   private String lblViewall_Jsonclick ;
   private String divTablefixeddata_1_Internalname ;
   private String edtCategoryName_Internalname ;
   private String edtCategoryName_Jsonclick ;
   private String Tab_Internalname ;
   private String lblGeneral_title_Internalname ;
   private String lblGeneral_title_Jsonclick ;
   private String divTablegeneral_Internalname ;
   private String WebComp_Generalwc_Component ;
   private String OldGeneralwc ;
   private String lblAttractions_title_Internalname ;
   private String lblAttractions_title_Jsonclick ;
   private String divTableattractions_Internalname ;
   private String WebComp_Attractionswc_Component ;
   private String OldAttractionswc ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String AV15Pgmname ;
   private String scmdbuf ;
   private String hsh ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean AV11LoadAllTabs ;
   private boolean Tab_Historymanagement ;
   private boolean wbLoad ;
   private boolean Rfr0gs ;
   private boolean wbErr ;
   private boolean gxdyncontrolsrefreshing ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private boolean AV10Exists ;
   private boolean bDynCreated_Generalwc ;
   private boolean bDynCreated_Attractionswc ;
   private String A4CategoryName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private GXWebComponent WebComp_Generalwc ;
   private GXWebComponent WebComp_Attractionswc ;
   private com.genexus.webpanels.GXUserControl ucTab ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] H001N2_A3CategoryId ;
   private String[] H001N2_A4CategoryName ;
   private short[] H001N3_A3CategoryId ;
   private String[] H001N3_A4CategoryName ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class viewcategory__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("H001N2", "SELECT CategoryId, CategoryName FROM Category WHERE CategoryId = ? ORDER BY CategoryId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("H001N3", "SELECT CategoryId, CategoryName FROM Category WHERE CategoryId = ? ORDER BY CategoryId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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

