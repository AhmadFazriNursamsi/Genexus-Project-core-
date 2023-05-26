package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class country_impl extends GXDataArea
{
   public void initenv( )
   {
      if ( GxWebError != 0 )
      {
         return  ;
      }
   }

   public void inittrn( )
   {
      initialize_properties( ) ;
      entryPointCalled = false ;
      gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
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
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetFirstPar( "Mode") ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridcountry_cityy") == 0 )
      {
         gxnrgridcountry_cityy_newrow_invoke( ) ;
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
         Gx_mode = gxfirstwebparm ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         if ( GXutil.strcmp(gxfirstwebparm, "viewer") != 0 )
         {
            AV7CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV7CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV7CountryId), 4, 0));
            com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCOUNTRYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CountryId), "ZZZ9")));
         }
      }
      if ( toggleJsOutput )
      {
         if ( httpContext.isSpaRequest( ) )
         {
            httpContext.enableJsOutput();
         }
      }
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
      if ( ! httpContext.isSpaRequest( ) )
      {
         if ( httpContext.exposeMetadata( ) )
         {
            Form.getMeta().addItem("generator", "GeneXus Java 18_0_2-169539", (short)(0)) ;
         }
         Form.getMeta().addItem("description", "Country", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCountryName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("KBBaru", true);
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridcountry_cityy_newrow_invoke( )
   {
      nRC_GXsfl_43 = (int)(GXutil.lval( httpContext.GetPar( "nRC_GXsfl_43"))) ;
      nGXsfl_43_idx = (int)(GXutil.lval( httpContext.GetPar( "nGXsfl_43_idx"))) ;
      sGXsfl_43_idx = httpContext.GetPar( "sGXsfl_43_idx") ;
      Gx_mode = httpContext.GetPar( "Mode") ;
      httpContext.setAjaxCallMode();
      if ( ! httpContext.IsValidAjaxCall( true) )
      {
         GxWebError = (byte)(1) ;
         return  ;
      }
      gxnrgridcountry_cityy_newrow( ) ;
      /* End function gxnrGridcountry_cityy_newrow_invoke */
   }

   public country_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public country_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( country_impl.class ));
   }

   public country_impl( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context);
   }

   protected void createObjects( )
   {
   }

   public void webExecute( )
   {
      initenv( ) ;
      inittrn( ) ;
      if ( ( GxWebError == 0 ) && ! isAjaxCallMode( ) )
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

   public void fix_multi_value_controls( )
   {
   }

   public void draw( )
   {
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.disableOutput();
      }
      if ( ! com.kbbaru.GxWebStd.gx_redirect( httpContext) )
      {
         disable_std_buttons( ) ;
         enableDisable( ) ;
         set_caption( ) ;
         /* Form start */
         drawControls( ) ;
         fix_multi_value_controls( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "Section", "left", "top", " "+"data-gx-base-lib=\"none\""+" "+"data-abstract-form"+" ", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divMaintable_Internalname, 1, 0, "px", 0, "px", "Table", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divTitlecontainer_Internalname, 1, 0, "px", 0, "px", "title-container", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Text block */
      com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Country", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "heading-01", 0, "", 1, 1, 0, (short)(0), "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      ClassString = "ErrorViewer" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_msg_list( httpContext, "", httpContext.GX_msglist.getDisplaymode(), StyleString, ClassString, "", "false");
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
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divFormcontainer_Internalname, 1, 0, "px", 0, "px", "form-container", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divToolbarcell_Internalname, 1, 0, "px", 0, "px", "col-xs-12 col-sm-9 col-sm-offset-3 form__toolbar-cell", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "btn-group", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 21,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-first" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-prev" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-next" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-last" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "Button button-secondary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Select", bttBtn_select_Jsonclick, 5, "Select", "", StyleString, ClassString, bttBtn_select_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell-advanced", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCountryName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryName_Internalname, A6CountryName, GXutil.rtrim( localUtil.format( A6CountryName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divCityytable_Internalname, 1, 0, "px", 0, "px", "form__table-level", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
      /* Text block */
      com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblTitlecityy_Internalname, "Cityy", "", "", lblTitlecityy_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "heading-04", 0, "", 1, 1, 0, (short)(0), "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      gxdraw_gridcountry_cityy( ) ;
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__actions--fixed", "Right", "Middle", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-action-group ActionGroup", "left", "top", " "+"data-gx-actiongroup-type=\"toolbar\""+" ", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 50,'',false,'',0)\"" ;
      ClassString = "Button button-primary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirm", bttBtn_enter_Jsonclick, 5, "Confirm", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "Button button-tertiary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancel", bttBtn_cancel_Jsonclick, 1, "Cancel", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "Button button-tertiary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Delete", bttBtn_delete_Jsonclick, 5, "Delete", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Country.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "Right", "Middle", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridcountry_cityy( )
   {
      /*  Grid Control  */
      startgridcontrol43( ) ;
      nGXsfl_43_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount10 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_10 = (short)(1) ;
            scanStart0310( ) ;
            while ( RcdFound10 != 0 )
            {
               init_level_properties10( ) ;
               getByPrimaryKey0310( ) ;
               addRow0310( ) ;
               scanNext0310( ) ;
            }
            scanEnd0310( ) ;
            nBlankRcdCount10 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0310( ) ;
         standaloneModal0310( ) ;
         sMode10 = Gx_mode ;
         while ( nGXsfl_43_idx < nRC_GXsfl_43 )
         {
            bGXsfl_43_Refreshing = true ;
            readRow0310( ) ;
            edtCountryCityId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COUNTRYCITYID_"+sGXsfl_43_idx+"Enabled"), ".", ",")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCountryCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
            edtCountryCityName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COUNTRYCITYNAME_"+sGXsfl_43_idx+"Enabled"), ".", ",")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCountryCityName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityName_Enabled), 5, 0), !bGXsfl_43_Refreshing);
            if ( ( nRcdExists_10 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0310( ) ;
            }
            sendRow0310( ) ;
            bGXsfl_43_Refreshing = false ;
         }
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount10 = (short)(5) ;
         nRcdExists_10 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0310( ) ;
            while ( RcdFound10 != 0 )
            {
               sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_4310( ) ;
               init_level_properties10( ) ;
               standaloneNotModal0310( ) ;
               getByPrimaryKey0310( ) ;
               standaloneModal0310( ) ;
               addRow0310( ) ;
               scanNext0310( ) ;
            }
            scanEnd0310( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      if ( ! isDsp( ) && ! isDlt( ) )
      {
         sMode10 = Gx_mode ;
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx+1), 4, 0), (short)(4), "0") ;
         subsflControlProps_4310( ) ;
         initAll0310( ) ;
         init_level_properties10( ) ;
         nRcdExists_10 = (short)(0) ;
         nIsMod_10 = (short)(0) ;
         nRcdDeleted_10 = (short)(0) ;
         nBlankRcdCount10 = (short)(nBlankRcdUsr10+nBlankRcdCount10) ;
         fRowAdded = 0 ;
         while ( nBlankRcdCount10 > 0 )
         {
            standaloneNotModal0310( ) ;
            standaloneModal0310( ) ;
            addRow0310( ) ;
            if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
            {
               fRowAdded = 1 ;
               GX_FocusControl = edtCountryCityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            nBlankRcdCount10 = (short)(nBlankRcdCount10-1) ;
         }
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridcountry_cityyContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridcountry_cityy", Gridcountry_cityyContainer, subGridcountry_cityy_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Gridcountry_cityyContainerData", Gridcountry_cityyContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Gridcountry_cityyContainerData"+"V", Gridcountry_cityyContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridcountry_cityyContainerData"+"V"+"\" value='"+Gridcountry_cityyContainer.GridValuesHidden()+"'/>") ;
      }
   }

   public void userMain( )
   {
      standaloneStartup( ) ;
   }

   public void userMainFullajax( )
   {
      initenv( ) ;
      inittrn( ) ;
      userMain( ) ;
      draw( ) ;
      sendCloseFormHiddens( ) ;
   }

   public void standaloneStartup( )
   {
      standaloneStartupServer( ) ;
      disable_std_buttons( ) ;
      enableDisable( ) ;
      process( ) ;
   }

   public void standaloneStartupServer( )
   {
      /* Execute Start event if defined. */
      httpContext.wbGlbDoneStart = (byte)(0) ;
      /* Execute user event: Start */
      e11032 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z5CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "Z5CountryId"), ".", ",")) ;
            Z6CountryName = httpContext.cgiGet( "Z6CountryName") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ".", ",")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ".", ",")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ".", ",")) ;
            AV7CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "vCOUNTRYID"), ".", ",")) ;
            A5CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "COUNTRYID"), ".", ",")) ;
            AV11Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            /* Read variables values. */
            A6CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Country");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("CountryId", localUtil.format( DecimalUtil.doubleToDec(A5CountryId), "ZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("country:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            /* Check if conditions changed and reset current page numbers */
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A5CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons( ) ;
               standaloneModal( ) ;
            }
            else
            {
               if ( isDsp( ) )
               {
                  sMode3 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode3 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound3 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_030( ) ;
                        if ( AnyError == 0 )
                        {
                           GX_FocusControl = bttBtn_enter_Internalname ;
                           httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noinsert"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
   }

   public void process( )
   {
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
         /* Read Transaction buttons. */
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
                     if ( GXutil.strcmp(sEvt, "START") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: Start */
                        e11032 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12032 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        if ( ! isDsp( ) )
                        {
                           btn_enter( ) ;
                        }
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                  }
                  else
                  {
                     sEvtType = GXutil.right( sEvt, 4) ;
                     sEvt = GXutil.left( sEvt, GXutil.len( sEvt)-4) ;
                  }
               }
               httpContext.wbHandled = (byte)(1) ;
            }
         }
      }
   }

   public void afterTrn( )
   {
      if ( trnEnded == 1 )
      {
         if ( ! (GXutil.strcmp("", endTrnMsgTxt)==0) )
         {
            httpContext.GX_msglist.addItem(endTrnMsgTxt, endTrnMsgCod, 0, "", true);
         }
         /* Execute user event: After Trn */
         e12032 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll033( ) ;
            standaloneNotModal( ) ;
            standaloneModal( ) ;
         }
      }
      endTrnMsgTxt = "" ;
   }

   public String toString( )
   {
      return "" ;
   }

   public GXContentInfo getContentInfo( )
   {
      return (GXContentInfo)(null) ;
   }

   public void disable_std_buttons( )
   {
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      bttBtn_first_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_first_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_first_Visible), 5, 0), true);
      bttBtn_previous_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_previous_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_previous_Visible), 5, 0), true);
      bttBtn_next_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_next_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_next_Visible), 5, 0), true);
      bttBtn_last_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_last_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_last_Visible), 5, 0), true);
      bttBtn_select_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_select_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_select_Visible), 5, 0), true);
      if ( isDsp( ) || isDlt( ) )
      {
         bttBtn_delete_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
         if ( isDsp( ) )
         {
            bttBtn_enter_Visible = 0 ;
            httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
         }
         disableAttributes033( ) ;
      }
   }

   public void set_caption( )
   {
      if ( ( IsConfirmed == 1 ) && ( AnyError == 0 ) )
      {
         if ( isDlt( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_confdelete"), 0, "", true);
         }
         else
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_mustconfirm"), 0, "", true);
         }
      }
   }

   public void confirm_030( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls033( ) ;
         }
         else
         {
            checkExtendedTable033( ) ;
            closeExtendedTableCursors033( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode3 = Gx_mode ;
         confirm_0310( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode3 ;
            httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
            IsConfirmed = (short)(1) ;
            httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
         }
         /* Restore parent mode. */
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
   }

   public void confirm_0310( )
   {
      nGXsfl_43_idx = 0 ;
      while ( nGXsfl_43_idx < nRC_GXsfl_43 )
      {
         readRow0310( ) ;
         if ( ( nRcdExists_10 != 0 ) || ( nIsMod_10 != 0 ) )
         {
            getKey0310( ) ;
            if ( ( nRcdExists_10 == 0 ) && ( nRcdDeleted_10 == 0 ) )
            {
               if ( RcdFound10 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0310( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0310( ) ;
                     closeExtendedTableCursors0310( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "COUNTRYCITYID_" + sGXsfl_43_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCountryCityId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound10 != 0 )
               {
                  if ( nRcdDeleted_10 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0310( ) ;
                     load0310( ) ;
                     beforeValidate0310( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0310( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_10 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0310( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0310( ) ;
                           closeExtendedTableCursors0310( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                              httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_10 == 0 )
                  {
                     GXCCtl = "COUNTRYCITYID_" + sGXsfl_43_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCountryCityId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCountryCityId_Internalname, GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( edtCountryCityName_Internalname, A16CountryCityName) ;
         httpContext.changePostValue( "ZT_"+"Z12CountryCityId_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( Z12CountryCityId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z16CountryCityName_"+sGXsfl_43_idx, Z16CountryCityName) ;
         httpContext.changePostValue( "nRcdDeleted_10_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_10, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nRcdExists_10_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_10, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nIsMod_10_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_10, (byte)(4), (byte)(0), ".", ""))) ;
         if ( nIsMod_10 != 0 )
         {
            httpContext.changePostValue( "COUNTRYCITYID_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCountryCityId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COUNTRYCITYNAME_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCountryCityName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption030( )
   {
   }

   public void e11032( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.kbbaru.general.security.isauthorized(remoteHandle, context).executeUdp( AV11Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.kbbaru.general.security.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV11Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
   }

   public void e12032( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.kbbaru.wwcountry", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(3);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm033( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z6CountryName = T00035_A6CountryName[0] ;
         }
         else
         {
            Z6CountryName = A6CountryName ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z5CountryId = A5CountryId ;
         Z6CountryName = A6CountryName ;
      }
   }

   public void standaloneNotModal( )
   {
      bttBtn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV7CountryId) )
      {
         A5CountryId = AV7CountryId ;
         httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
      }
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "DSP") == 0 )
      {
         bttBtn_enter_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_enter_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Enabled), 5, 0), true);
      }
   }

   public void load033( )
   {
      /* Using cursor T00036 */
      pr_default.execute(4, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A6CountryName = T00036_A6CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
         zm033( -2) ;
      }
      pr_default.close(4);
      onLoadActions033( ) ;
   }

   public void onLoadActions033( )
   {
      AV11Pgmname = "Country" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Pgmname", AV11Pgmname);
   }

   public void checkExtendedTable033( )
   {
      nIsDirty_3 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV11Pgmname = "Country" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Pgmname", AV11Pgmname);
   }

   public void closeExtendedTableCursors033( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey033( )
   {
      /* Using cursor T00037 */
      pr_default.execute(5, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound3 = (short)(1) ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00035 */
      pr_default.execute(3, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm033( 2) ;
         RcdFound3 = (short)(1) ;
         A5CountryId = T00035_A5CountryId[0] ;
         A6CountryName = T00035_A6CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
         Z5CountryId = A5CountryId ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load033( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey033( ) ;
         }
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey033( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey033( ) ;
      if ( RcdFound3 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T00038 */
      pr_default.execute(6, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00038_A5CountryId[0] < A5CountryId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00038_A5CountryId[0] > A5CountryId ) ) )
         {
            A5CountryId = T00038_A5CountryId[0] ;
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound3 = (short)(0) ;
      /* Using cursor T00039 */
      pr_default.execute(7, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00039_A5CountryId[0] > A5CountryId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00039_A5CountryId[0] < A5CountryId ) ) )
         {
            A5CountryId = T00039_A5CountryId[0] ;
            RcdFound3 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey033( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCountryName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert033( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound3 == 1 )
         {
            if ( A5CountryId != Z5CountryId )
            {
               A5CountryId = Z5CountryId ;
               httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCountryName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update033( ) ;
               GX_FocusControl = edtCountryName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A5CountryId != Z5CountryId )
            {
               /* Insert record */
               GX_FocusControl = edtCountryName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert033( ) ;
               if ( AnyError == 1 )
               {
                  GX_FocusControl = "" ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( GXutil.strcmp(Gx_mode, "UPD") == 0 )
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                  AnyError = (short)(1) ;
               }
               else
               {
                  /* Insert record */
                  GX_FocusControl = edtCountryName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert033( ) ;
                  if ( AnyError == 1 )
                  {
                     GX_FocusControl = "" ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
      }
      afterTrn( ) ;
      if ( isUpd( ) || isDlt( ) )
      {
         if ( AnyError == 0 )
         {
            httpContext.nUserReturn = (byte)(1) ;
         }
      }
   }

   public void btn_delete( )
   {
      if ( A5CountryId != Z5CountryId )
      {
         A5CountryId = Z5CountryId ;
         httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "");
         AnyError = (short)(1) ;
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCountryName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency033( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00034 */
         pr_default.execute(2, new Object[] {Short.valueOf(A5CountryId)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Country"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z6CountryName, T00034_A6CountryName[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z6CountryName, T00034_A6CountryName[0]) != 0 )
            {
               GXutil.writeLogln("country:[seudo value changed for attri]"+"CountryName");
               GXutil.writeLogRaw("Old: ",Z6CountryName);
               GXutil.writeLogRaw("Current: ",T00034_A6CountryName[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Country"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         zm033( 0) ;
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert033( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000310 */
                  pr_default.execute(8, new Object[] {A6CountryName});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000311 */
                  pr_default.execute(9);
                  A5CountryId = T000311_A5CountryId[0] ;
                  pr_default.close(9);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Country");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel033( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption030( ) ;
                        }
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load033( ) ;
         }
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void update033( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable033( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm033( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate033( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000312 */
                  pr_default.execute(10, new Object[] {A6CountryName, Short.valueOf(A5CountryId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Country");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Country"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate033( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel033( ) ;
                        if ( AnyError == 0 )
                        {
                           if ( isUpd( ) || isDlt( ) )
                           {
                              if ( AnyError == 0 )
                              {
                                 httpContext.nUserReturn = (byte)(1) ;
                              }
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
         endLevel033( ) ;
      }
      closeExtendedTableCursors033( ) ;
   }

   public void deferredUpdate033( )
   {
   }

   public void delete( )
   {
      beforeValidate033( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency033( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls033( ) ;
         afterConfirm033( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete033( ) ;
            if ( AnyError == 0 )
            {
               scanStart0310( ) ;
               while ( RcdFound10 != 0 )
               {
                  getByPrimaryKey0310( ) ;
                  delete0310( ) ;
                  scanNext0310( ) ;
               }
               scanEnd0310( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000313 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A5CountryId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Country");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        if ( isUpd( ) || isDlt( ) )
                        {
                           if ( AnyError == 0 )
                           {
                              httpContext.nUserReturn = (byte)(1) ;
                           }
                        }
                     }
                  }
                  else
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
         }
      }
      sMode3 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel033( ) ;
      Gx_mode = sMode3 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls033( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV11Pgmname = "Country" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV11Pgmname", AV11Pgmname);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000314 */
         pr_default.execute(12, new Object[] {Short.valueOf(A5CountryId)});
         if ( (pr_default.getStatus(12) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Attractions"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(12);
      }
   }

   public void processNestedLevel0310( )
   {
      nGXsfl_43_idx = 0 ;
      while ( nGXsfl_43_idx < nRC_GXsfl_43 )
      {
         readRow0310( ) ;
         if ( ( nRcdExists_10 != 0 ) || ( nIsMod_10 != 0 ) )
         {
            standaloneNotModal0310( ) ;
            getKey0310( ) ;
            if ( ( nRcdExists_10 == 0 ) && ( nRcdDeleted_10 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0310( ) ;
            }
            else
            {
               if ( RcdFound10 != 0 )
               {
                  if ( ( nRcdDeleted_10 != 0 ) && ( nRcdExists_10 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0310( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_10 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0310( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_10 == 0 )
                  {
                     GXCCtl = "COUNTRYCITYID_" + sGXsfl_43_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCountryCityId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCountryCityId_Internalname, GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( edtCountryCityName_Internalname, A16CountryCityName) ;
         httpContext.changePostValue( "ZT_"+"Z12CountryCityId_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( Z12CountryCityId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z16CountryCityName_"+sGXsfl_43_idx, Z16CountryCityName) ;
         httpContext.changePostValue( "nRcdDeleted_10_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_10, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nRcdExists_10_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_10, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nIsMod_10_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_10, (byte)(4), (byte)(0), ".", ""))) ;
         if ( nIsMod_10 != 0 )
         {
            httpContext.changePostValue( "COUNTRYCITYID_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCountryCityId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "COUNTRYCITYNAME_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCountryCityName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0310( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_10 = (short)(0) ;
      nIsMod_10 = (short)(0) ;
      nRcdDeleted_10 = (short)(0) ;
   }

   public void processLevel033( )
   {
      /* Save parent mode. */
      sMode3 = Gx_mode ;
      processNestedLevel0310( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode3 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel033( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete033( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "country");
         if ( AnyError == 0 )
         {
            confirmValues030( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "country");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart033( )
   {
      /* Scan By routine */
      /* Using cursor T000315 */
      pr_default.execute(13);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A5CountryId = T000315_A5CountryId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext033( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A5CountryId = T000315_A5CountryId[0] ;
      }
   }

   public void scanEnd033( )
   {
      pr_default.close(13);
   }

   public void afterConfirm033( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert033( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate033( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete033( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete033( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate033( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes033( )
   {
      edtCountryName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryName_Enabled), 5, 0), true);
   }

   public void zm0310( int GX_JID )
   {
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z16CountryCityName = T00033_A16CountryCityName[0] ;
         }
         else
         {
            Z16CountryCityName = A16CountryCityName ;
         }
      }
      if ( GX_JID == -3 )
      {
         Z5CountryId = A5CountryId ;
         Z12CountryCityId = A12CountryCityId ;
         Z16CountryCityName = A16CountryCityName ;
      }
   }

   public void standaloneNotModal0310( )
   {
   }

   public void standaloneModal0310( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCountryCityId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCountryCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      }
      else
      {
         edtCountryCityId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCountryCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      }
   }

   public void load0310( )
   {
      /* Using cursor T000316 */
      pr_default.execute(14, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A16CountryCityName = T000316_A16CountryCityName[0] ;
         zm0310( -3) ;
      }
      pr_default.close(14);
      onLoadActions0310( ) ;
   }

   public void onLoadActions0310( )
   {
   }

   public void checkExtendedTable0310( )
   {
      nIsDirty_10 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0310( ) ;
   }

   public void closeExtendedTableCursors0310( )
   {
   }

   public void enableDisable0310( )
   {
   }

   public void getKey0310( )
   {
      /* Using cursor T000317 */
      pr_default.execute(15, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
      if ( (pr_default.getStatus(15) != 101) )
      {
         RcdFound10 = (short)(1) ;
      }
      else
      {
         RcdFound10 = (short)(0) ;
      }
      pr_default.close(15);
   }

   public void getByPrimaryKey0310( )
   {
      /* Using cursor T00033 */
      pr_default.execute(1, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0310( 3) ;
         RcdFound10 = (short)(1) ;
         initializeNonKey0310( ) ;
         A12CountryCityId = T00033_A12CountryCityId[0] ;
         A16CountryCityName = T00033_A16CountryCityName[0] ;
         Z5CountryId = A5CountryId ;
         Z12CountryCityId = A12CountryCityId ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load0310( ) ;
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound10 = (short)(0) ;
         initializeNonKey0310( ) ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0310( ) ;
         Gx_mode = sMode10 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0310( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0310( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00032 */
         pr_default.execute(0, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CountryCity"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z16CountryCityName, T00032_A16CountryCityName[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z16CountryCityName, T00032_A16CountryCityName[0]) != 0 )
            {
               GXutil.writeLogln("country:[seudo value changed for attri]"+"CountryCityName");
               GXutil.writeLogRaw("Old: ",Z16CountryCityName);
               GXutil.writeLogRaw("Current: ",T00032_A16CountryCityName[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CountryCity"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0310( )
   {
      beforeValidate0310( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0310( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0310( 0) ;
         checkOptimisticConcurrency0310( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0310( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0310( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000318 */
                  pr_default.execute(16, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId), A16CountryCityName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CountryCity");
                  if ( (pr_default.getStatus(16) == 1) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
         else
         {
            load0310( ) ;
         }
         endLevel0310( ) ;
      }
      closeExtendedTableCursors0310( ) ;
   }

   public void update0310( )
   {
      beforeValidate0310( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0310( ) ;
      }
      if ( ( nIsMod_10 != 0 ) || ( nIsDirty_10 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0310( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0310( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0310( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000319 */
                     pr_default.execute(17, new Object[] {A16CountryCityName, Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("CountryCity");
                     if ( (pr_default.getStatus(17) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CountryCity"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0310( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0310( ) ;
                        }
                     }
                     else
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                        AnyError = (short)(1) ;
                     }
                  }
               }
            }
            endLevel0310( ) ;
         }
      }
      closeExtendedTableCursors0310( ) ;
   }

   public void deferredUpdate0310( )
   {
   }

   public void delete0310( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0310( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0310( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0310( ) ;
         afterConfirm0310( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0310( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000320 */
               pr_default.execute(18, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CountryCity");
               if ( AnyError == 0 )
               {
                  /* Start of After( delete) rules */
                  /* End of After( delete) rules */
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_unexp"), 1, "");
                  AnyError = (short)(1) ;
               }
            }
         }
      }
      sMode10 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0310( ) ;
      Gx_mode = sMode10 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0310( )
   {
      standaloneModal0310( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor T000321 */
         pr_default.execute(19, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
         if ( (pr_default.getStatus(19) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Attractions"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(19);
      }
   }

   public void endLevel0310( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart0310( )
   {
      /* Scan By routine */
      /* Using cursor T000322 */
      pr_default.execute(20, new Object[] {Short.valueOf(A5CountryId)});
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A12CountryCityId = T000322_A12CountryCityId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0310( )
   {
      /* Scan next routine */
      pr_default.readNext(20);
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(20) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A12CountryCityId = T000322_A12CountryCityId[0] ;
      }
   }

   public void scanEnd0310( )
   {
      pr_default.close(20);
   }

   public void afterConfirm0310( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0310( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0310( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0310( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0310( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0310( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0310( )
   {
      edtCountryCityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtCountryCityName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryCityName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityName_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void send_integrity_lvl_hashes0310( )
   {
   }

   public void send_integrity_lvl_hashes033( )
   {
   }

   public void subsflControlProps_4310( )
   {
      edtCountryCityId_Internalname = "COUNTRYCITYID_"+sGXsfl_43_idx ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME_"+sGXsfl_43_idx ;
   }

   public void subsflControlProps_fel_4310( )
   {
      edtCountryCityId_Internalname = "COUNTRYCITYID_"+sGXsfl_43_fel_idx ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME_"+sGXsfl_43_fel_idx ;
   }

   public void addRow0310( )
   {
      nGXsfl_43_idx = (int)(nGXsfl_43_idx+1) ;
      sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4310( ) ;
      sendRow0310( ) ;
   }

   public void sendRow0310( )
   {
      Gridcountry_cityyRow = GXWebRow.GetNew(context) ;
      if ( subGridcountry_cityy_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridcountry_cityy_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridcountry_cityy_Class, "") != 0 )
         {
            subGridcountry_cityy_Linesclass = subGridcountry_cityy_Class+"Odd" ;
         }
      }
      else if ( subGridcountry_cityy_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridcountry_cityy_Backstyle = (byte)(0) ;
         subGridcountry_cityy_Backcolor = subGridcountry_cityy_Allbackcolor ;
         if ( GXutil.strcmp(subGridcountry_cityy_Class, "") != 0 )
         {
            subGridcountry_cityy_Linesclass = subGridcountry_cityy_Class+"Uniform" ;
         }
      }
      else if ( subGridcountry_cityy_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridcountry_cityy_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridcountry_cityy_Class, "") != 0 )
         {
            subGridcountry_cityy_Linesclass = subGridcountry_cityy_Class+"Odd" ;
         }
         subGridcountry_cityy_Backcolor = (int)(0x0) ;
      }
      else if ( subGridcountry_cityy_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridcountry_cityy_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_43_idx) % (2))) == 0 )
         {
            subGridcountry_cityy_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridcountry_cityy_Class, "") != 0 )
            {
               subGridcountry_cityy_Linesclass = subGridcountry_cityy_Class+"Even" ;
            }
         }
         else
         {
            subGridcountry_cityy_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridcountry_cityy_Class, "") != 0 )
            {
               subGridcountry_cityy_Linesclass = subGridcountry_cityy_Class+"Odd" ;
            }
         }
      }
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /* * Property Link not supported in */
      /*
         Assignment error:
         ================
         Expression: [ t('iif(',1),t('Gx_mode',23),t(=,10),t('''DSP''',3),t('OR',9),t('Gx_mode',23),t(=,10),t('''UPD''',3),t(',',7),t('""',3),t(',',7),t('"javascript:"',3),t(+,5),t('"gx.popup.openPrompt(''"',3),t(+,5),t('"com.kbbaru.gx00a1"',3),t(+,5),t('"'',["',3),t(+,5),t('"''"',3),t(+,5),t('htmlencode(',1),t('strreplace(',1),t('ltrim(',1),t('ntoc(',1),t(5,2),t(',',7),t(4,3),t(',',7),t(0,3),t(',',7),t('"."',3),t(',',7),t('""',3),t(')',4),t(')',4),t(',',7),t('"''"',3),t(',',7),t('"\''"',3),t(')',4),t(')',4),t(+,5),t('"''"',3),t(+,5),t('","',3),t(+,5),t('"{Ctrl:gx.dom.el(''"',3),t(+,5),t('"COUNTRYCITYID_"',3),t(+,5),t(sGXsfl_43_idx,23),t(+,5),t('"''), id:''"',3),t(+,5),t('"COUNTRYCITYID_"',3),t(+,5),t(sGXsfl_43_idx,23),t(+,5),t('"''"',3),t(+,5),t('",IOType:''out''}"',3),t(+,5),t('"],"',3),t(+,5),t('"gx.dom.form()."',3),t(+,5),t('"nIsMod_10_"',3),t(+,5),t(sGXsfl_43_idx,23),t(+,5),t('","',3),t(+,5),t('"'''', false"',3),t(+,5),t('","',3),t(+,5),t('"false"',3),t(+,5),t('");"',3),t(')',4) ]
         Target    : [ t(prompt_5,3),t('Link',3) ]
         ForType   : 29
         Type      : []
      */
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_10_" + sGXsfl_43_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 44,'',false,'" + sGXsfl_43_idx + "',43)\"" ;
      ROClassString = "Attribute" ;
      Gridcountry_cityyRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryCityId_Internalname,GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A12CountryCityId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,44);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryCityId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtCountryCityId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_10_" + sGXsfl_43_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_43_idx + "',43)\"" ;
      ROClassString = "Attribute" ;
      Gridcountry_cityyRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCountryCityName_Internalname,A16CountryCityName,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCountryCityName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtCountryCityName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridcountry_cityyRow);
      send_integrity_lvl_hashes0310( ) ;
      GXCCtl = "Z12CountryCityId_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z12CountryCityId, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "Z16CountryCityName_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z16CountryCityName);
      GXCCtl = "nRcdDeleted_10_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_10, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "nRcdExists_10_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_10, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "nIsMod_10_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_10, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "vMODE_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.rtrim( Gx_mode));
      GXCCtl = "vTRNCONTEXT_" + sGXsfl_43_idx ;
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, GXCCtl, AV9TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt(GXCCtl, AV9TrnContext);
      }
      GXCCtl = "vCOUNTRYID_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( AV7CountryId, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "COUNTRYID_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "COUNTRYCITYID_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCountryCityId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "COUNTRYCITYNAME_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCountryCityName_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridcountry_cityyContainer.AddRow(Gridcountry_cityyRow);
   }

   public void readRow0310( )
   {
      nGXsfl_43_idx = (int)(nGXsfl_43_idx+1) ;
      sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4310( ) ;
      edtCountryCityId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COUNTRYCITYID_"+sGXsfl_43_idx+"Enabled"), ".", ",")) ;
      edtCountryCityName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "COUNTRYCITYNAME_"+sGXsfl_43_idx+"Enabled"), ".", ",")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCountryCityId_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCountryCityId_Internalname), ".", ",") > 9999 ) ) )
      {
         GXCCtl = "COUNTRYCITYID_" + sGXsfl_43_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryCityId_Internalname ;
         wbErr = true ;
         A12CountryCityId = (short)(0) ;
      }
      else
      {
         A12CountryCityId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryCityId_Internalname), ".", ",")) ;
      }
      A16CountryCityName = httpContext.cgiGet( edtCountryCityName_Internalname) ;
      GXCCtl = "Z12CountryCityId_" + sGXsfl_43_idx ;
      Z12CountryCityId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
      GXCCtl = "Z16CountryCityName_" + sGXsfl_43_idx ;
      Z16CountryCityName = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_10_" + sGXsfl_43_idx ;
      nRcdDeleted_10 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
      GXCCtl = "nRcdExists_10_" + sGXsfl_43_idx ;
      nRcdExists_10 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
      GXCCtl = "nIsMod_10_" + sGXsfl_43_idx ;
      nIsMod_10 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
   }

   public void assign_properties_default( )
   {
      defedtCountryCityId_Enabled = edtCountryCityId_Enabled ;
   }

   public void confirmValues030( )
   {
      nGXsfl_43_idx = 0 ;
      sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4310( ) ;
      while ( nGXsfl_43_idx < nRC_GXsfl_43 )
      {
         nGXsfl_43_idx = (int)(nGXsfl_43_idx+1) ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4310( ) ;
         httpContext.changePostValue( "Z12CountryCityId_"+sGXsfl_43_idx, httpContext.cgiGet( "ZT_"+"Z12CountryCityId_"+sGXsfl_43_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z12CountryCityId_"+sGXsfl_43_idx) ;
         httpContext.changePostValue( "Z16CountryCityName_"+sGXsfl_43_idx, httpContext.cgiGet( "ZT_"+"Z16CountryCityName_"+sGXsfl_43_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z16CountryCityName_"+sGXsfl_43_idx) ;
      }
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
      MasterPageObj.master_styles();
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
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      if ( ! ( (GXutil.strcmp("", Form.getBackground())==0) ) )
      {
         bodyStyle += " background-image:url(" + httpContext.convertURL( Form.getBackground()) + ")" ;
      }
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.country", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CountryId,4,0))}, new String[] {"Gx_mode","CountryId"}) +"\">") ;
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
      forbiddenHiddens = new com.genexus.util.GXProperties() ;
      forbiddenHiddens.add("hshsalt", "hsh"+"Country");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("CountryId", localUtil.format( DecimalUtil.doubleToDec(A5CountryId), "ZZZ9"));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("country:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z5CountryId", GXutil.ltrim( localUtil.ntoc( Z5CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z6CountryName", Z6CountryName);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_43", GXutil.ltrim( localUtil.ntoc( nGXsfl_43_idx, (byte)(8), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vMODE", GXutil.rtrim( Gx_mode));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vMODE", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      if ( httpContext.isAjaxRequest( ) )
      {
         httpContext.ajax_rsp_assign_sdt_attri("", false, "vTRNCONTEXT", AV9TrnContext);
      }
      else
      {
         httpContext.ajax_rsp_assign_hidden_sdt("vTRNCONTEXT", AV9TrnContext);
      }
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vTRNCONTEXT", getSecureSignedToken( "", AV9TrnContext));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vCOUNTRYID", GXutil.ltrim( localUtil.ntoc( AV7CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vCOUNTRYID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV7CountryId), "ZZZ9")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "COUNTRYID", GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV11Pgmname));
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

   public byte executeStartEvent( )
   {
      standaloneStartup( ) ;
      gxajaxcallmode = (byte)((isAjaxCallMode( ) ? 1 : 0)) ;
      return gxajaxcallmode ;
   }

   public void renderHtmlContent( )
   {
      httpContext.writeText( "<div") ;
      com.kbbaru.GxWebStd.classAttribute( httpContext, "gx-ct-body"+" "+((GXutil.strcmp("", Form.getThemeClass())==0) ? "form-horizontal Form" : Form.getThemeClass())+"-fx");
      httpContext.writeText( ">") ;
      draw( ) ;
      httpContext.writeText( "</div>") ;
   }

   public void dispatchEvents( )
   {
      process( ) ;
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
      return formatLink("com.kbbaru.country", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV7CountryId,4,0))}, new String[] {"Gx_mode","CountryId"})  ;
   }

   public String getPgmname( )
   {
      return "Country" ;
   }

   public String getPgmdesc( )
   {
      return "Country" ;
   }

   public void initializeNonKey033( )
   {
      A6CountryName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
      Z6CountryName = "" ;
   }

   public void initAll033( )
   {
      A5CountryId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
      initializeNonKey033( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0310( )
   {
      A16CountryCityName = "" ;
      Z16CountryCityName = "" ;
   }

   public void initAll0310( )
   {
      A12CountryCityId = (short)(0) ;
      initializeNonKey0310( ) ;
   }

   public void standaloneModalInsert0310( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?2023526959150", true, true);
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
      httpContext.AddJavascriptSource("country.js", "?2023526959151", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties10( )
   {
      edtCountryCityId_Enabled = defedtCountryCityId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void startgridcontrol43( )
   {
      Gridcountry_cityyContainer.AddObjectProperty("GridName", "Gridcountry_cityy");
      Gridcountry_cityyContainer.AddObjectProperty("Header", subGridcountry_cityy_Header);
      Gridcountry_cityyContainer.AddObjectProperty("Class", "Grid");
      Gridcountry_cityyContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridcountry_cityy_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddObjectProperty("CmpContext", "");
      Gridcountry_cityyContainer.AddObjectProperty("InMasterPage", "false");
      Gridcountry_cityyColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridcountry_cityyColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", ""))));
      Gridcountry_cityyColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCountryCityId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddColumnProperties(Gridcountry_cityyColumn);
      Gridcountry_cityyColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridcountry_cityyColumn.AddObjectProperty("Value", WebUtils.htmlEncode( A16CountryCityName));
      Gridcountry_cityyColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCountryCityName_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddColumnProperties(Gridcountry_cityyColumn);
      Gridcountry_cityyContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridcountry_cityy_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridcountry_cityy_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridcountry_cityy_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridcountry_cityy_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridcountry_cityy_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridcountry_cityy_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridcountry_cityyContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridcountry_cityy_Collapsed, (byte)(1), (byte)(0), ".", "")));
   }

   public void init_default_properties( )
   {
      lblTitle_Internalname = "TITLE" ;
      divTitlecontainer_Internalname = "TITLECONTAINER" ;
      bttBtn_first_Internalname = "BTN_FIRST" ;
      bttBtn_previous_Internalname = "BTN_PREVIOUS" ;
      bttBtn_next_Internalname = "BTN_NEXT" ;
      bttBtn_last_Internalname = "BTN_LAST" ;
      bttBtn_select_Internalname = "BTN_SELECT" ;
      divToolbarcell_Internalname = "TOOLBARCELL" ;
      edtCountryName_Internalname = "COUNTRYNAME" ;
      lblTitlecityy_Internalname = "TITLECITYY" ;
      edtCountryCityId_Internalname = "COUNTRYCITYID" ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME" ;
      divCityytable_Internalname = "CITYYTABLE" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridcountry_cityy_Internalname = "GRIDCOUNTRY_CITYY" ;
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
      subGridcountry_cityy_Allowcollapsing = (byte)(0) ;
      subGridcountry_cityy_Allowselection = (byte)(0) ;
      subGridcountry_cityy_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "Country" );
      edtCountryCityName_Jsonclick = "" ;
      edtCountryCityId_Jsonclick = "" ;
      subGridcountry_cityy_Class = "Grid" ;
      subGridcountry_cityy_Backcolorstyle = (byte)(0) ;
      edtCountryCityName_Enabled = 1 ;
      edtCountryCityId_Enabled = 1 ;
      bttBtn_delete_Enabled = 0 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtCountryName_Jsonclick = "" ;
      edtCountryName_Enabled = 1 ;
      bttBtn_select_Visible = 1 ;
      bttBtn_last_Visible = 1 ;
      bttBtn_next_Visible = 1 ;
      bttBtn_previous_Visible = 1 ;
      bttBtn_first_Visible = 1 ;
      httpContext.GX_msglist.setDisplaymode( (short)(1) );
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableJsOutput();
      }
   }

   public void dynload_actions( )
   {
      /* End function dynload_actions */
   }

   public void gxnrgridcountry_cityy_newrow( )
   {
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_4310( ) ;
      while ( nGXsfl_43_idx <= nRC_GXsfl_43 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0310( ) ;
         standaloneModal0310( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0310( ) ;
         nGXsfl_43_idx = (int)(nGXsfl_43_idx+1) ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4310( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridcountry_cityyContainer)) ;
      /* End function gxnrGridcountry_cityy_newrow */
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public boolean isIns( )
   {
      return ((GXutil.strcmp(Gx_mode, "INS")==0) ? true : false) ;
   }

   public boolean isDlt( )
   {
      return ((GXutil.strcmp(Gx_mode, "DLT")==0) ? true : false) ;
   }

   public boolean isUpd( )
   {
      return ((GXutil.strcmp(Gx_mode, "UPD")==0) ? true : false) ;
   }

   public boolean isDsp( )
   {
      return ((GXutil.strcmp(Gx_mode, "DSP")==0) ? true : false) ;
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV7CountryId',fld:'vCOUNTRYID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV7CountryId',fld:'vCOUNTRYID',pic:'ZZZ9',hsh:true},{av:'A5CountryId',fld:'COUNTRYID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12032',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_COUNTRYCITYID","{handler:'valid_Countrycityid',iparms:[]");
      setEventMetadata("VALID_COUNTRYCITYID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Countrycityname',iparms:[]");
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
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z6CountryName = "" ;
      Z16CountryCityName = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      Gx_mode = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A6CountryName = "" ;
      lblTitlecityy_Jsonclick = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gridcountry_cityyContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode10 = "" ;
      sStyleString = "" ;
      AV11Pgmname = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode3 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A16CountryCityName = "" ;
      AV9TrnContext = new com.kbbaru.general.ui.SdtTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      T00036_A5CountryId = new short[1] ;
      T00036_A6CountryName = new String[] {""} ;
      T00037_A5CountryId = new short[1] ;
      T00035_A5CountryId = new short[1] ;
      T00035_A6CountryName = new String[] {""} ;
      T00038_A5CountryId = new short[1] ;
      T00039_A5CountryId = new short[1] ;
      T00034_A5CountryId = new short[1] ;
      T00034_A6CountryName = new String[] {""} ;
      T000311_A5CountryId = new short[1] ;
      T000314_A9AttractionsId = new short[1] ;
      T000315_A5CountryId = new short[1] ;
      T000316_A5CountryId = new short[1] ;
      T000316_A12CountryCityId = new short[1] ;
      T000316_A16CountryCityName = new String[] {""} ;
      T000317_A5CountryId = new short[1] ;
      T000317_A12CountryCityId = new short[1] ;
      T00033_A5CountryId = new short[1] ;
      T00033_A12CountryCityId = new short[1] ;
      T00033_A16CountryCityName = new String[] {""} ;
      T00032_A5CountryId = new short[1] ;
      T00032_A12CountryCityId = new short[1] ;
      T00032_A16CountryCityName = new String[] {""} ;
      T000321_A9AttractionsId = new short[1] ;
      T000322_A5CountryId = new short[1] ;
      T000322_A12CountryCityId = new short[1] ;
      Gridcountry_cityyRow = new com.genexus.webpanels.GXWebRow();
      subGridcountry_cityy_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridcountry_cityyColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.country__default(),
         new Object[] {
             new Object[] {
            T00032_A5CountryId, T00032_A12CountryCityId, T00032_A16CountryCityName
            }
            , new Object[] {
            T00033_A5CountryId, T00033_A12CountryCityId, T00033_A16CountryCityName
            }
            , new Object[] {
            T00034_A5CountryId, T00034_A6CountryName
            }
            , new Object[] {
            T00035_A5CountryId, T00035_A6CountryName
            }
            , new Object[] {
            T00036_A5CountryId, T00036_A6CountryName
            }
            , new Object[] {
            T00037_A5CountryId
            }
            , new Object[] {
            T00038_A5CountryId
            }
            , new Object[] {
            T00039_A5CountryId
            }
            , new Object[] {
            }
            , new Object[] {
            T000311_A5CountryId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000314_A9AttractionsId
            }
            , new Object[] {
            T000315_A5CountryId
            }
            , new Object[] {
            T000316_A5CountryId, T000316_A12CountryCityId, T000316_A16CountryCityName
            }
            , new Object[] {
            T000317_A5CountryId, T000317_A12CountryCityId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000321_A9AttractionsId
            }
            , new Object[] {
            T000322_A5CountryId, T000322_A12CountryCityId
            }
         }
      );
      AV11Pgmname = "Country" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridcountry_cityy_Backcolorstyle ;
   private byte subGridcountry_cityy_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridcountry_cityy_Allowselection ;
   private byte subGridcountry_cityy_Allowhovering ;
   private byte subGridcountry_cityy_Allowcollapsing ;
   private byte subGridcountry_cityy_Collapsed ;
   private short wcpOAV7CountryId ;
   private short Z5CountryId ;
   private short Z12CountryCityId ;
   private short nRcdDeleted_10 ;
   private short nRcdExists_10 ;
   private short nIsMod_10 ;
   private short AV7CountryId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount10 ;
   private short RcdFound10 ;
   private short nBlankRcdUsr10 ;
   private short A5CountryId ;
   private short RcdFound3 ;
   private short A12CountryCityId ;
   private short nIsDirty_3 ;
   private short nIsDirty_10 ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtCountryName_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int edtCountryCityId_Enabled ;
   private int edtCountryCityName_Enabled ;
   private int fRowAdded ;
   private int GX_JID ;
   private int subGridcountry_cityy_Backcolor ;
   private int subGridcountry_cityy_Allbackcolor ;
   private int defedtCountryCityId_Enabled ;
   private int idxLst ;
   private int subGridcountry_cityy_Selectedindex ;
   private int subGridcountry_cityy_Selectioncolor ;
   private int subGridcountry_cityy_Hoveringcolor ;
   private long GRIDCOUNTRY_CITYY_nFirstRecordOnPage ;
   private String sPrefix ;
   private String wcpOGx_mode ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String Gx_mode ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCountryName_Internalname ;
   private String sGXsfl_43_idx="0001" ;
   private String divMaintable_Internalname ;
   private String divTitlecontainer_Internalname ;
   private String lblTitle_Internalname ;
   private String lblTitle_Jsonclick ;
   private String ClassString ;
   private String StyleString ;
   private String divFormcontainer_Internalname ;
   private String divToolbarcell_Internalname ;
   private String TempTags ;
   private String bttBtn_first_Internalname ;
   private String bttBtn_first_Jsonclick ;
   private String bttBtn_previous_Internalname ;
   private String bttBtn_previous_Jsonclick ;
   private String bttBtn_next_Internalname ;
   private String bttBtn_next_Jsonclick ;
   private String bttBtn_last_Internalname ;
   private String bttBtn_last_Jsonclick ;
   private String bttBtn_select_Internalname ;
   private String bttBtn_select_Jsonclick ;
   private String edtCountryName_Jsonclick ;
   private String divCityytable_Internalname ;
   private String lblTitlecityy_Internalname ;
   private String lblTitlecityy_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String sMode10 ;
   private String edtCountryCityId_Internalname ;
   private String edtCountryCityName_Internalname ;
   private String sStyleString ;
   private String subGridcountry_cityy_Internalname ;
   private String AV11Pgmname ;
   private String hsh ;
   private String sMode3 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String subGridcountry_cityy_Class ;
   private String subGridcountry_cityy_Linesclass ;
   private String ROClassString ;
   private String edtCountryCityId_Jsonclick ;
   private String edtCountryCityName_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridcountry_cityy_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String Z6CountryName ;
   private String Z16CountryCityName ;
   private String A6CountryName ;
   private String A16CountryCityName ;
   private com.genexus.webpanels.GXWebGrid Gridcountry_cityyContainer ;
   private com.genexus.webpanels.GXWebRow Gridcountry_cityyRow ;
   private com.genexus.webpanels.GXWebColumn Gridcountry_cityyColumn ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] T00036_A5CountryId ;
   private String[] T00036_A6CountryName ;
   private short[] T00037_A5CountryId ;
   private short[] T00035_A5CountryId ;
   private String[] T00035_A6CountryName ;
   private short[] T00038_A5CountryId ;
   private short[] T00039_A5CountryId ;
   private short[] T00034_A5CountryId ;
   private String[] T00034_A6CountryName ;
   private short[] T000311_A5CountryId ;
   private short[] T000314_A9AttractionsId ;
   private short[] T000315_A5CountryId ;
   private short[] T000316_A5CountryId ;
   private short[] T000316_A12CountryCityId ;
   private String[] T000316_A16CountryCityName ;
   private short[] T000317_A5CountryId ;
   private short[] T000317_A12CountryCityId ;
   private short[] T00033_A5CountryId ;
   private short[] T00033_A12CountryCityId ;
   private String[] T00033_A16CountryCityName ;
   private short[] T00032_A5CountryId ;
   private short[] T00032_A12CountryCityId ;
   private String[] T00032_A16CountryCityName ;
   private short[] T000321_A9AttractionsId ;
   private short[] T000322_A5CountryId ;
   private short[] T000322_A12CountryCityId ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.kbbaru.general.ui.SdtTransactionContext AV9TrnContext ;
}

final  class country__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00032", "SELECT CountryId, CountryCityId, CountryCityName FROM CountryCity WHERE CountryId = ? AND CountryCityId = ?  FOR UPDATE OF CountryCity NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00033", "SELECT CountryId, CountryCityId, CountryCityName FROM CountryCity WHERE CountryId = ? AND CountryCityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00034", "SELECT CountryId, CountryName FROM Country WHERE CountryId = ?  FOR UPDATE OF Country NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00035", "SELECT CountryId, CountryName FROM Country WHERE CountryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00036", "SELECT TM1.CountryId, TM1.CountryName FROM Country TM1 WHERE TM1.CountryId = ? ORDER BY TM1.CountryId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00037", "SELECT CountryId FROM Country WHERE CountryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00038", "SELECT CountryId FROM Country WHERE ( CountryId > ?) ORDER BY CountryId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00039", "SELECT CountryId FROM Country WHERE ( CountryId < ?) ORDER BY CountryId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000310", "SAVEPOINT gxupdate;INSERT INTO Country(CountryName) VALUES(?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000311", "SELECT currval('CountryId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000312", "SAVEPOINT gxupdate;UPDATE Country SET CountryName=?  WHERE CountryId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000313", "SAVEPOINT gxupdate;DELETE FROM Country  WHERE CountryId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000314", "SELECT AttractionsId FROM Attractions WHERE CountryId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000315", "SELECT CountryId FROM Country ORDER BY CountryId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000316", "SELECT CountryId, CountryCityId, CountryCityName FROM CountryCity WHERE CountryId = ? and CountryCityId = ? ORDER BY CountryId, CountryCityId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000317", "SELECT CountryId, CountryCityId FROM CountryCity WHERE CountryId = ? AND CountryCityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000318", "SAVEPOINT gxupdate;INSERT INTO CountryCity(CountryId, CountryCityId, CountryCityName) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000319", "SAVEPOINT gxupdate;UPDATE CountryCity SET CountryCityName=?  WHERE CountryId = ? AND CountryCityId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000320", "SAVEPOINT gxupdate;DELETE FROM CountryCity  WHERE CountryId = ? AND CountryCityId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000321", "SELECT AttractionsId FROM Attractions WHERE CountryId = ? AND CountryCityId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000322", "SELECT CountryId, CountryCityId FROM CountryCity WHERE CountryId = ? ORDER BY CountryId, CountryCityId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 2 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 15 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 19 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 8 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               return;
            case 10 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               return;
            case 17 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

