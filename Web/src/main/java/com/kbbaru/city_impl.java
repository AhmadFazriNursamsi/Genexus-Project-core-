package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class city_impl extends GXDataArea
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
      gxfirstwebparm = httpContext.GetNextPar( ) ;
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
         gxfirstwebparm = httpContext.GetNextPar( ) ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxfullajaxEvt") == 0 )
      {
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxfirstwebparm = httpContext.GetNextPar( ) ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxNewRow_"+"Gridcity_kecamatan") == 0 )
      {
         gxnrgridcity_kecamatan_newrow_invoke( ) ;
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
         Form.getMeta().addItem("description", "City", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtCityName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("KBBaru", true);
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public void gxnrgridcity_kecamatan_newrow_invoke( )
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
      gxnrgridcity_kecamatan_newrow( ) ;
      /* End function gxnrGridcity_kecamatan_newrow_invoke */
   }

   public city_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public city_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( city_impl.class ));
   }

   public city_impl( int remoteHandle ,
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
      com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "City", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "heading-01", 0, "", 1, 1, 0, (short)(0), "HLP_City.htm");
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
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_City.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-prev" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_City.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-next" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_City.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-last" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_City.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "Button button-secondary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Select", bttBtn_select_Jsonclick, 5, "Select", "", StyleString, ClassString, bttBtn_select_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_City.htm");
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
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCityName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCityName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCityName_Internalname, A8CityName, GXutil.rtrim( localUtil.format( A8CityName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCityName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCityName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_City.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, divKecamatantable_Internalname, 1, 0, "px", 0, "px", "form__table-level", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
      /* Text block */
      com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblTitlekecamatan_Internalname, "Kecamatan", "", "", lblTitlekecamatan_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "heading-04", 0, "", 1, 1, 0, (short)(0), "HLP_City.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      gxdraw_gridcity_kecamatan( ) ;
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
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirm", bttBtn_enter_Jsonclick, 5, "Confirm", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_City.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 52,'',false,'',0)\"" ;
      ClassString = "Button button-tertiary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancel", bttBtn_cancel_Jsonclick, 1, "Cancel", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_City.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 54,'',false,'',0)\"" ;
      ClassString = "Button button-tertiary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Delete", bttBtn_delete_Jsonclick, 5, "Delete", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_City.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "Right", "Middle", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
   }

   public void gxdraw_gridcity_kecamatan( )
   {
      /*  Grid Control  */
      startgridcontrol43( ) ;
      nGXsfl_43_idx = 0 ;
      if ( ( nKeyPressed == 1 ) && ( AnyError == 0 ) )
      {
         /* Enter key processing. */
         nBlankRcdCount17 = (short)(5) ;
         if ( ! isIns( ) )
         {
            /* Display confirmed (stored) records */
            nRcdExists_17 = (short)(1) ;
            scanStart0417( ) ;
            while ( RcdFound17 != 0 )
            {
               init_level_properties17( ) ;
               getByPrimaryKey0417( ) ;
               addRow0417( ) ;
               scanNext0417( ) ;
            }
            scanEnd0417( ) ;
            nBlankRcdCount17 = (short)(5) ;
         }
      }
      else if ( ( nKeyPressed == 3 ) || ( nKeyPressed == 4 ) || ( ( nKeyPressed == 1 ) && ( AnyError != 0 ) ) )
      {
         /* Button check  or addlines. */
         standaloneNotModal0417( ) ;
         standaloneModal0417( ) ;
         sMode17 = Gx_mode ;
         while ( nGXsfl_43_idx < nRC_GXsfl_43 )
         {
            bGXsfl_43_Refreshing = true ;
            readRow0417( ) ;
            edtCityKecamatanId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CITYKECAMATANID_"+sGXsfl_43_idx+"Enabled"), ".", ",")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCityKecamatanId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityKecamatanId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
            edtCityKecamatanName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CITYKECAMATANNAME_"+sGXsfl_43_idx+"Enabled"), ".", ",")) ;
            httpContext.ajax_rsp_assign_prop("", false, edtCityKecamatanName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityKecamatanName_Enabled), 5, 0), !bGXsfl_43_Refreshing);
            if ( ( nRcdExists_17 == 0 ) && ! isIns( ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal0417( ) ;
            }
            sendRow0417( ) ;
            bGXsfl_43_Refreshing = false ;
         }
         Gx_mode = sMode17 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         /* Get or get-alike key processing. */
         nBlankRcdCount17 = (short)(5) ;
         nRcdExists_17 = (short)(1) ;
         if ( ! isIns( ) )
         {
            scanStart0417( ) ;
            while ( RcdFound17 != 0 )
            {
               sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx+1), 4, 0), (short)(4), "0") ;
               subsflControlProps_4317( ) ;
               init_level_properties17( ) ;
               standaloneNotModal0417( ) ;
               getByPrimaryKey0417( ) ;
               standaloneModal0417( ) ;
               addRow0417( ) ;
               scanNext0417( ) ;
            }
            scanEnd0417( ) ;
         }
      }
      /* Initialize fields for 'new' records and send them. */
      sMode17 = Gx_mode ;
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx+1), 4, 0), (short)(4), "0") ;
      subsflControlProps_4317( ) ;
      initAll0417( ) ;
      init_level_properties17( ) ;
      nRcdExists_17 = (short)(0) ;
      nIsMod_17 = (short)(0) ;
      nRcdDeleted_17 = (short)(0) ;
      nBlankRcdCount17 = (short)(nBlankRcdUsr17+nBlankRcdCount17) ;
      fRowAdded = 0 ;
      while ( nBlankRcdCount17 > 0 )
      {
         standaloneNotModal0417( ) ;
         standaloneModal0417( ) ;
         addRow0417( ) ;
         if ( ( nKeyPressed == 4 ) && ( fRowAdded == 0 ) )
         {
            fRowAdded = 1 ;
            GX_FocusControl = edtCityKecamatanId_Internalname ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
         nBlankRcdCount17 = (short)(nBlankRcdCount17-1) ;
      }
      Gx_mode = sMode17 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      sStyleString = "" ;
      httpContext.writeText( "<div id=\""+"Gridcity_kecamatanContainer"+"Div\" "+sStyleString+">"+"</div>") ;
      httpContext.ajax_rsp_assign_grid("_"+"Gridcity_kecamatan", Gridcity_kecamatanContainer, subGridcity_kecamatan_Internalname);
      if ( ! httpContext.isAjaxRequest( ) && ! httpContext.isSpaRequest( ) )
      {
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Gridcity_kecamatanContainerData", Gridcity_kecamatanContainer.ToJavascriptSource());
      }
      if ( httpContext.isAjaxRequest( ) || httpContext.isSpaRequest( ) )
      {
         com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Gridcity_kecamatanContainerData"+"V", Gridcity_kecamatanContainer.GridValuesHidden());
      }
      else
      {
         httpContext.writeText( "<input type=\"hidden\" "+"name=\""+"Gridcity_kecamatanContainerData"+"V"+"\" value='"+Gridcity_kecamatanContainer.GridValuesHidden()+"'/>") ;
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
      e11042 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z7CityId = (short)(localUtil.ctol( httpContext.cgiGet( "Z7CityId"), ".", ",")) ;
            Z8CityName = httpContext.cgiGet( "Z8CityName") ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ".", ",")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ".", ",")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            nRC_GXsfl_43 = (int)(localUtil.ctol( httpContext.cgiGet( "nRC_GXsfl_43"), ".", ",")) ;
            A7CityId = (short)(localUtil.ctol( httpContext.cgiGet( "CITYID"), ".", ",")) ;
            /* Read variables values. */
            A8CityName = httpContext.cgiGet( edtCityName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A8CityName", A8CityName);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"City");
            forbiddenHiddens.add("CityId", localUtil.format( DecimalUtil.doubleToDec(A7CityId), "ZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("city:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
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
               A7CityId = (short)(GXutil.lval( httpContext.GetPar( "CityId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A7CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CityId), 4, 0));
               getEqualNoModal( ) ;
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               disable_std_buttons_dsp( ) ;
               standaloneModal( ) ;
            }
            else
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               standaloneModal( ) ;
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
                        e11042 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        dynload_actions( ) ;
                        /* Execute user event: After Trn */
                        e12042 ();
                     }
                     else if ( GXutil.strcmp(sEvt, "ENTER") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_enter( ) ;
                        /* No code required for Cancel button. It is implemented as the Reset button. */
                     }
                     else if ( GXutil.strcmp(sEvt, "FIRST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_first( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "PREVIOUS") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_previous( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "NEXT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_next( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LAST") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_last( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "SELECT") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_select( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "DELETE") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        btn_delete( ) ;
                     }
                     else if ( GXutil.strcmp(sEvt, "LSCR") == 0 )
                     {
                        httpContext.wbHandled = (byte)(1) ;
                        afterkeyloadscreen( ) ;
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
         e12042 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll044( ) ;
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
      if ( isIns( ) )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
   }

   public void disable_std_buttons_dsp( )
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
      bttBtn_delete_Visible = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Visible), 5, 0), true);
      if ( isDsp( ) )
      {
         bttBtn_enter_Visible = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_enter_Internalname, "Visible", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_enter_Visible), 5, 0), true);
      }
      disableAttributes044( ) ;
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

   public void confirm_0417( )
   {
      nGXsfl_43_idx = 0 ;
      while ( nGXsfl_43_idx < nRC_GXsfl_43 )
      {
         readRow0417( ) ;
         if ( ( nRcdExists_17 != 0 ) || ( nIsMod_17 != 0 ) )
         {
            getKey0417( ) ;
            if ( ( nRcdExists_17 == 0 ) && ( nRcdDeleted_17 == 0 ) )
            {
               if ( RcdFound17 == 0 )
               {
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  beforeValidate0417( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0417( ) ;
                     closeExtendedTableCursors0417( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                        httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
                     }
                  }
               }
               else
               {
                  GXCCtl = "CITYKECAMATANID_" + sGXsfl_43_idx ;
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, GXCCtl);
                  AnyError = (short)(1) ;
                  GX_FocusControl = edtCityKecamatanId_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               }
            }
            else
            {
               if ( RcdFound17 != 0 )
               {
                  if ( nRcdDeleted_17 != 0 )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     getByPrimaryKey0417( ) ;
                     load0417( ) ;
                     beforeValidate0417( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0417( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_17 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        beforeValidate0417( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0417( ) ;
                           closeExtendedTableCursors0417( ) ;
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
                  if ( nRcdDeleted_17 == 0 )
                  {
                     GXCCtl = "CITYKECAMATANID_" + sGXsfl_43_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCityKecamatanId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCityKecamatanId_Internalname, GXutil.ltrim( localUtil.ntoc( A28CityKecamatanId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( edtCityKecamatanName_Internalname, A29CityKecamatanName) ;
         httpContext.changePostValue( "ZT_"+"Z28CityKecamatanId_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( Z28CityKecamatanId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z29CityKecamatanName_"+sGXsfl_43_idx, Z29CityKecamatanName) ;
         httpContext.changePostValue( "nRcdDeleted_17_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_17, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nRcdExists_17_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_17, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nIsMod_17_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_17, (byte)(4), (byte)(0), ".", ""))) ;
         if ( nIsMod_17 != 0 )
         {
            httpContext.changePostValue( "CITYKECAMATANID_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityKecamatanId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CITYKECAMATANNAME_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityKecamatanName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void resetCaption040( )
   {
   }

   public void e11042( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e12042( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm044( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z8CityName = T00045_A8CityName[0] ;
         }
         else
         {
            Z8CityName = A8CityName ;
         }
      }
      if ( GX_JID == -1 )
      {
         Z7CityId = A7CityId ;
         Z8CityName = A8CityName ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") == 0 )
      {
         bttBtn_delete_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
      else
      {
         bttBtn_delete_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      }
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

   public void load044( )
   {
      /* Using cursor T00046 */
      pr_default.execute(4, new Object[] {Short.valueOf(A7CityId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A8CityName = T00046_A8CityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CityName", A8CityName);
         zm044( -1) ;
      }
      pr_default.close(4);
      onLoadActions044( ) ;
   }

   public void onLoadActions044( )
   {
   }

   public void checkExtendedTable044( )
   {
      nIsDirty_4 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors044( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey044( )
   {
      /* Using cursor T00047 */
      pr_default.execute(5, new Object[] {Short.valueOf(A7CityId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound4 = (short)(1) ;
      }
      else
      {
         RcdFound4 = (short)(0) ;
      }
      pr_default.close(5);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00045 */
      pr_default.execute(3, new Object[] {Short.valueOf(A7CityId)});
      if ( (pr_default.getStatus(3) != 101) )
      {
         zm044( 1) ;
         RcdFound4 = (short)(1) ;
         A7CityId = T00045_A7CityId[0] ;
         A8CityName = T00045_A8CityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A8CityName", A8CityName);
         Z7CityId = A7CityId ;
         sMode4 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         load044( ) ;
         if ( AnyError == 1 )
         {
            RcdFound4 = (short)(0) ;
            initializeNonKey044( ) ;
         }
         Gx_mode = sMode4 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound4 = (short)(0) ;
         initializeNonKey044( ) ;
         sMode4 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode4 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(3);
   }

   public void getEqualNoModal( )
   {
      getKey044( ) ;
      if ( RcdFound4 == 0 )
      {
         Gx_mode = "INS" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound4 = (short)(0) ;
      /* Using cursor T00048 */
      pr_default.execute(6, new Object[] {Short.valueOf(A7CityId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         while ( (pr_default.getStatus(6) != 101) && ( ( T00048_A7CityId[0] < A7CityId ) ) )
         {
            pr_default.readNext(6);
         }
         if ( (pr_default.getStatus(6) != 101) && ( ( T00048_A7CityId[0] > A7CityId ) ) )
         {
            A7CityId = T00048_A7CityId[0] ;
            RcdFound4 = (short)(1) ;
         }
      }
      pr_default.close(6);
   }

   public void move_previous( )
   {
      RcdFound4 = (short)(0) ;
      /* Using cursor T00049 */
      pr_default.execute(7, new Object[] {Short.valueOf(A7CityId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         while ( (pr_default.getStatus(7) != 101) && ( ( T00049_A7CityId[0] > A7CityId ) ) )
         {
            pr_default.readNext(7);
         }
         if ( (pr_default.getStatus(7) != 101) && ( ( T00049_A7CityId[0] < A7CityId ) ) )
         {
            A7CityId = T00049_A7CityId[0] ;
            RcdFound4 = (short)(1) ;
         }
      }
      pr_default.close(7);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey044( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtCityName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert044( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound4 == 1 )
         {
            if ( A7CityId != Z7CityId )
            {
               A7CityId = Z7CityId ;
               httpContext.ajax_rsp_assign_attri("", false, "A7CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CityId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtCityName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               Gx_mode = "UPD" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Update record */
               update044( ) ;
               GX_FocusControl = edtCityName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A7CityId != Z7CityId )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               /* Insert record */
               GX_FocusControl = edtCityName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert044( ) ;
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
                  Gx_mode = "INS" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  /* Insert record */
                  GX_FocusControl = edtCityName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert044( ) ;
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
   }

   public void btn_delete( )
   {
      if ( A7CityId != Z7CityId )
      {
         A7CityId = Z7CityId ;
         httpContext.ajax_rsp_assign_attri("", false, "A7CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CityId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "");
         AnyError = (short)(1) ;
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtCityName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         getByPrimaryKey( ) ;
      }
      CloseOpenCursors();
   }

   public void btn_get( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      if ( RcdFound4 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      GX_FocusControl = edtCityName_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_first( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart044( ) ;
      if ( RcdFound4 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCityName_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd044( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_previous( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_previous( ) ;
      if ( RcdFound4 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCityName_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_next( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      move_next( ) ;
      if ( RcdFound4 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCityName_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_last( )
   {
      nKeyPressed = (byte)(2) ;
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      scanStart044( ) ;
      if ( RcdFound4 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_norectobrow"), 0, "", true);
      }
      else
      {
         while ( RcdFound4 != 0 )
         {
            scanNext044( ) ;
         }
         Gx_mode = "UPD" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      GX_FocusControl = edtCityName_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      scanEnd044( ) ;
      getByPrimaryKey( ) ;
      standaloneNotModal( ) ;
      standaloneModal( ) ;
   }

   public void btn_select( )
   {
      getEqualNoModal( ) ;
   }

   public void checkOptimisticConcurrency044( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00044 */
         pr_default.execute(2, new Object[] {Short.valueOf(A7CityId)});
         if ( (pr_default.getStatus(2) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"City"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(2) == 101) || ( GXutil.strcmp(Z8CityName, T00044_A8CityName[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z8CityName, T00044_A8CityName[0]) != 0 )
            {
               GXutil.writeLogln("city:[seudo value changed for attri]"+"CityName");
               GXutil.writeLogRaw("Old: ",Z8CityName);
               GXutil.writeLogRaw("Current: ",T00044_A8CityName[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"City"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert044( )
   {
      beforeValidate044( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable044( ) ;
      }
      if ( AnyError == 0 )
      {
         zm044( 0) ;
         checkOptimisticConcurrency044( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm044( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert044( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000410 */
                  pr_default.execute(8, new Object[] {A8CityName});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000411 */
                  pr_default.execute(9);
                  A7CityId = T000411_A7CityId[0] ;
                  pr_default.close(9);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("City");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel044( ) ;
                        if ( AnyError == 0 )
                        {
                           /* Save values for previous() function. */
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                           endTrnMsgCod = "SuccessfullyAdded" ;
                           resetCaption040( ) ;
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
            load044( ) ;
         }
         endLevel044( ) ;
      }
      closeExtendedTableCursors044( ) ;
   }

   public void update044( )
   {
      beforeValidate044( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable044( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency044( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm044( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate044( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000412 */
                  pr_default.execute(10, new Object[] {A8CityName, Short.valueOf(A7CityId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("City");
                  if ( (pr_default.getStatus(10) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"City"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate044( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel044( ) ;
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
                           resetCaption040( ) ;
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
         endLevel044( ) ;
      }
      closeExtendedTableCursors044( ) ;
   }

   public void deferredUpdate044( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate044( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency044( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls044( ) ;
         afterConfirm044( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete044( ) ;
            if ( AnyError == 0 )
            {
               scanStart0417( ) ;
               while ( RcdFound17 != 0 )
               {
                  getByPrimaryKey0417( ) ;
                  delete0417( ) ;
                  scanNext0417( ) ;
               }
               scanEnd0417( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000413 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A7CityId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("City");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        move_next( ) ;
                        if ( RcdFound4 == 0 )
                        {
                           initAll044( ) ;
                           Gx_mode = "INS" ;
                           httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        }
                        else
                        {
                           getByPrimaryKey( ) ;
                           Gx_mode = "UPD" ;
                           httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        }
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                        endTrnMsgCod = "SuccessfullyDeleted" ;
                        resetCaption040( ) ;
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
      sMode4 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel044( ) ;
      Gx_mode = sMode4 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls044( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void processNestedLevel0417( )
   {
      nGXsfl_43_idx = 0 ;
      while ( nGXsfl_43_idx < nRC_GXsfl_43 )
      {
         readRow0417( ) ;
         if ( ( nRcdExists_17 != 0 ) || ( nIsMod_17 != 0 ) )
         {
            standaloneNotModal0417( ) ;
            getKey0417( ) ;
            if ( ( nRcdExists_17 == 0 ) && ( nRcdDeleted_17 == 0 ) )
            {
               Gx_mode = "INS" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               insert0417( ) ;
            }
            else
            {
               if ( RcdFound17 != 0 )
               {
                  if ( ( nRcdDeleted_17 != 0 ) && ( nRcdExists_17 != 0 ) )
                  {
                     Gx_mode = "DLT" ;
                     httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                     delete0417( ) ;
                  }
                  else
                  {
                     if ( nRcdExists_17 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                        update0417( ) ;
                     }
                  }
               }
               else
               {
                  if ( nRcdDeleted_17 == 0 )
                  {
                     GXCCtl = "CITYKECAMATANID_" + sGXsfl_43_idx ;
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, GXCCtl);
                     AnyError = (short)(1) ;
                     GX_FocusControl = edtCityKecamatanId_Internalname ;
                     httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  }
               }
            }
         }
         httpContext.changePostValue( edtCityKecamatanId_Internalname, GXutil.ltrim( localUtil.ntoc( A28CityKecamatanId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( edtCityKecamatanName_Internalname, A29CityKecamatanName) ;
         httpContext.changePostValue( "ZT_"+"Z28CityKecamatanId_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( Z28CityKecamatanId, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "ZT_"+"Z29CityKecamatanName_"+sGXsfl_43_idx, Z29CityKecamatanName) ;
         httpContext.changePostValue( "nRcdDeleted_17_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_17, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nRcdExists_17_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nRcdExists_17, (byte)(4), (byte)(0), ".", ""))) ;
         httpContext.changePostValue( "nIsMod_17_"+sGXsfl_43_idx, GXutil.ltrim( localUtil.ntoc( nIsMod_17, (byte)(4), (byte)(0), ".", ""))) ;
         if ( nIsMod_17 != 0 )
         {
            httpContext.changePostValue( "CITYKECAMATANID_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityKecamatanId_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
            httpContext.changePostValue( "CITYKECAMATANNAME_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityKecamatanName_Enabled, (byte)(5), (byte)(0), ".", ""))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0417( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_17 = (short)(0) ;
      nIsMod_17 = (short)(0) ;
      nRcdDeleted_17 = (short)(0) ;
   }

   public void processLevel044( )
   {
      /* Save parent mode. */
      sMode4 = Gx_mode ;
      processNestedLevel0417( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode4 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      /* ' Update level parameters */
   }

   public void endLevel044( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(2);
      }
      if ( AnyError == 0 )
      {
         beforeComplete044( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "city");
         if ( AnyError == 0 )
         {
            confirmValues040( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "city");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart044( )
   {
      /* Scan By routine */
      /* Using cursor T000414 */
      pr_default.execute(12);
      RcdFound4 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A7CityId = T000414_A7CityId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext044( )
   {
      /* Scan next routine */
      pr_default.readNext(12);
      RcdFound4 = (short)(0) ;
      if ( (pr_default.getStatus(12) != 101) )
      {
         RcdFound4 = (short)(1) ;
         A7CityId = T000414_A7CityId[0] ;
      }
   }

   public void scanEnd044( )
   {
      pr_default.close(12);
   }

   public void afterConfirm044( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert044( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate044( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete044( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete044( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate044( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes044( )
   {
      edtCityName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCityName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityName_Enabled), 5, 0), true);
   }

   public void zm0417( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z29CityKecamatanName = T00043_A29CityKecamatanName[0] ;
         }
         else
         {
            Z29CityKecamatanName = A29CityKecamatanName ;
         }
      }
      if ( GX_JID == -2 )
      {
         Z7CityId = A7CityId ;
         Z28CityKecamatanId = A28CityKecamatanId ;
         Z29CityKecamatanName = A29CityKecamatanName ;
      }
   }

   public void standaloneNotModal0417( )
   {
   }

   public void standaloneModal0417( )
   {
      if ( GXutil.strcmp(Gx_mode, "INS") != 0 )
      {
         edtCityKecamatanId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCityKecamatanId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityKecamatanId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      }
      else
      {
         edtCityKecamatanId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCityKecamatanId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityKecamatanId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      }
   }

   public void load0417( )
   {
      /* Using cursor T000415 */
      pr_default.execute(13, new Object[] {Short.valueOf(A7CityId), Short.valueOf(A28CityKecamatanId)});
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A29CityKecamatanName = T000415_A29CityKecamatanName[0] ;
         zm0417( -2) ;
      }
      pr_default.close(13);
      onLoadActions0417( ) ;
   }

   public void onLoadActions0417( )
   {
   }

   public void checkExtendedTable0417( )
   {
      nIsDirty_17 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0417( ) ;
   }

   public void closeExtendedTableCursors0417( )
   {
   }

   public void enableDisable0417( )
   {
   }

   public void getKey0417( )
   {
      /* Using cursor T000416 */
      pr_default.execute(14, new Object[] {Short.valueOf(A7CityId), Short.valueOf(A28CityKecamatanId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound17 = (short)(1) ;
      }
      else
      {
         RcdFound17 = (short)(0) ;
      }
      pr_default.close(14);
   }

   public void getByPrimaryKey0417( )
   {
      /* Using cursor T00043 */
      pr_default.execute(1, new Object[] {Short.valueOf(A7CityId), Short.valueOf(A28CityKecamatanId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm0417( 2) ;
         RcdFound17 = (short)(1) ;
         initializeNonKey0417( ) ;
         A28CityKecamatanId = T00043_A28CityKecamatanId[0] ;
         A29CityKecamatanName = T00043_A29CityKecamatanName[0] ;
         Z7CityId = A7CityId ;
         Z28CityKecamatanId = A28CityKecamatanId ;
         sMode17 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0417( ) ;
         load0417( ) ;
         Gx_mode = sMode17 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound17 = (short)(0) ;
         initializeNonKey0417( ) ;
         sMode17 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal0417( ) ;
         Gx_mode = sMode17 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0417( ) ;
      }
      pr_default.close(1);
   }

   public void checkOptimisticConcurrency0417( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00042 */
         pr_default.execute(0, new Object[] {Short.valueOf(A7CityId), Short.valueOf(A28CityKecamatanId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CityKecamatan"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z29CityKecamatanName, T00042_A29CityKecamatanName[0]) != 0 ) )
         {
            if ( GXutil.strcmp(Z29CityKecamatanName, T00042_A29CityKecamatanName[0]) != 0 )
            {
               GXutil.writeLogln("city:[seudo value changed for attri]"+"CityKecamatanName");
               GXutil.writeLogRaw("Old: ",Z29CityKecamatanName);
               GXutil.writeLogRaw("Current: ",T00042_A29CityKecamatanName[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"CityKecamatan"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0417( )
   {
      beforeValidate0417( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0417( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0417( 0) ;
         checkOptimisticConcurrency0417( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0417( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0417( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000417 */
                  pr_default.execute(15, new Object[] {Short.valueOf(A7CityId), Short.valueOf(A28CityKecamatanId), A29CityKecamatanName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CityKecamatan");
                  if ( (pr_default.getStatus(15) == 1) )
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
            load0417( ) ;
         }
         endLevel0417( ) ;
      }
      closeExtendedTableCursors0417( ) ;
   }

   public void update0417( )
   {
      beforeValidate0417( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0417( ) ;
      }
      if ( ( nIsMod_17 != 0 ) || ( nIsDirty_17 != 0 ) )
      {
         if ( AnyError == 0 )
         {
            checkOptimisticConcurrency0417( ) ;
            if ( AnyError == 0 )
            {
               afterConfirm0417( ) ;
               if ( AnyError == 0 )
               {
                  beforeUpdate0417( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Using cursor T000418 */
                     pr_default.execute(16, new Object[] {A29CityKecamatanName, Short.valueOf(A7CityId), Short.valueOf(A28CityKecamatanId)});
                     Application.getSmartCacheProvider(remoteHandle).setUpdated("CityKecamatan");
                     if ( (pr_default.getStatus(16) == 103) )
                     {
                        httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CityKecamatan"}), "RecordIsLocked", 1, "");
                        AnyError = (short)(1) ;
                     }
                     deferredUpdate0417( ) ;
                     if ( AnyError == 0 )
                     {
                        /* Start of After( update) rules */
                        /* End of After( update) rules */
                        if ( AnyError == 0 )
                        {
                           getByPrimaryKey0417( ) ;
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
            endLevel0417( ) ;
         }
      }
      closeExtendedTableCursors0417( ) ;
   }

   public void deferredUpdate0417( )
   {
   }

   public void delete0417( )
   {
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      beforeValidate0417( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0417( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0417( ) ;
         afterConfirm0417( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0417( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000419 */
               pr_default.execute(17, new Object[] {Short.valueOf(A7CityId), Short.valueOf(A28CityKecamatanId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("CityKecamatan");
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
      sMode17 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel0417( ) ;
      Gx_mode = sMode17 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls0417( )
   {
      standaloneModal0417( ) ;
      /* No delete mode formulas found. */
   }

   public void endLevel0417( )
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

   public void scanStart0417( )
   {
      /* Scan By routine */
      /* Using cursor T000420 */
      pr_default.execute(18, new Object[] {Short.valueOf(A7CityId)});
      RcdFound17 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A28CityKecamatanId = T000420_A28CityKecamatanId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext0417( )
   {
      /* Scan next routine */
      pr_default.readNext(18);
      RcdFound17 = (short)(0) ;
      if ( (pr_default.getStatus(18) != 101) )
      {
         RcdFound17 = (short)(1) ;
         A28CityKecamatanId = T000420_A28CityKecamatanId[0] ;
      }
   }

   public void scanEnd0417( )
   {
      pr_default.close(18);
   }

   public void afterConfirm0417( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0417( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0417( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0417( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0417( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0417( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0417( )
   {
      edtCityKecamatanId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCityKecamatanId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityKecamatanId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
      edtCityKecamatanName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCityKecamatanName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityKecamatanName_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void send_integrity_lvl_hashes0417( )
   {
   }

   public void send_integrity_lvl_hashes044( )
   {
   }

   public void subsflControlProps_4317( )
   {
      edtCityKecamatanId_Internalname = "CITYKECAMATANID_"+sGXsfl_43_idx ;
      edtCityKecamatanName_Internalname = "CITYKECAMATANNAME_"+sGXsfl_43_idx ;
   }

   public void subsflControlProps_fel_4317( )
   {
      edtCityKecamatanId_Internalname = "CITYKECAMATANID_"+sGXsfl_43_fel_idx ;
      edtCityKecamatanName_Internalname = "CITYKECAMATANNAME_"+sGXsfl_43_fel_idx ;
   }

   public void addRow0417( )
   {
      nGXsfl_43_idx = (int)(nGXsfl_43_idx+1) ;
      sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4317( ) ;
      sendRow0417( ) ;
   }

   public void sendRow0417( )
   {
      Gridcity_kecamatanRow = GXWebRow.GetNew(context) ;
      if ( subGridcity_kecamatan_Backcolorstyle == 0 )
      {
         /* None style subfile background logic. */
         subGridcity_kecamatan_Backstyle = (byte)(0) ;
         if ( GXutil.strcmp(subGridcity_kecamatan_Class, "") != 0 )
         {
            subGridcity_kecamatan_Linesclass = subGridcity_kecamatan_Class+"Odd" ;
         }
      }
      else if ( subGridcity_kecamatan_Backcolorstyle == 1 )
      {
         /* Uniform style subfile background logic. */
         subGridcity_kecamatan_Backstyle = (byte)(0) ;
         subGridcity_kecamatan_Backcolor = subGridcity_kecamatan_Allbackcolor ;
         if ( GXutil.strcmp(subGridcity_kecamatan_Class, "") != 0 )
         {
            subGridcity_kecamatan_Linesclass = subGridcity_kecamatan_Class+"Uniform" ;
         }
      }
      else if ( subGridcity_kecamatan_Backcolorstyle == 2 )
      {
         /* Header style subfile background logic. */
         subGridcity_kecamatan_Backstyle = (byte)(1) ;
         if ( GXutil.strcmp(subGridcity_kecamatan_Class, "") != 0 )
         {
            subGridcity_kecamatan_Linesclass = subGridcity_kecamatan_Class+"Odd" ;
         }
         subGridcity_kecamatan_Backcolor = (int)(0x0) ;
      }
      else if ( subGridcity_kecamatan_Backcolorstyle == 3 )
      {
         /* Report style subfile background logic. */
         subGridcity_kecamatan_Backstyle = (byte)(1) ;
         if ( ((int)((nGXsfl_43_idx) % (2))) == 0 )
         {
            subGridcity_kecamatan_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridcity_kecamatan_Class, "") != 0 )
            {
               subGridcity_kecamatan_Linesclass = subGridcity_kecamatan_Class+"Even" ;
            }
         }
         else
         {
            subGridcity_kecamatan_Backcolor = (int)(0x0) ;
            if ( GXutil.strcmp(subGridcity_kecamatan_Class, "") != 0 )
            {
               subGridcity_kecamatan_Linesclass = subGridcity_kecamatan_Class+"Odd" ;
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
         Expression: [ t('iif(',1),t('Gx_mode',23),t(=,10),t('''DSP''',3),t('OR',9),t('Gx_mode',23),t(=,10),t('''UPD''',3),t(',',7),t('""',3),t(',',7),t('"javascript:"',3),t(+,5),t('"gx.popup.openPrompt(''"',3),t(+,5),t('"com.kbbaru.gx00h1"',3),t(+,5),t('"'',["',3),t(+,5),t('"''"',3),t(+,5),t('htmlencode(',1),t('strreplace(',1),t('ltrim(',1),t('ntoc(',1),t(7,2),t(',',7),t(4,3),t(',',7),t(0,3),t(',',7),t('"."',3),t(',',7),t('""',3),t(')',4),t(')',4),t(',',7),t('"''"',3),t(',',7),t('"\''"',3),t(')',4),t(')',4),t(+,5),t('"''"',3),t(+,5),t('","',3),t(+,5),t('"{Ctrl:gx.dom.el(''"',3),t(+,5),t('"CITYKECAMATANID_"',3),t(+,5),t(sGXsfl_43_idx,23),t(+,5),t('"''), id:''"',3),t(+,5),t('"CITYKECAMATANID_"',3),t(+,5),t(sGXsfl_43_idx,23),t(+,5),t('"''"',3),t(+,5),t('",IOType:''out''}"',3),t(+,5),t('"],"',3),t(+,5),t('"gx.dom.form()."',3),t(+,5),t('"nIsMod_17_"',3),t(+,5),t(sGXsfl_43_idx,23),t(+,5),t('","',3),t(+,5),t('"'''', false"',3),t(+,5),t('","',3),t(+,5),t('"false"',3),t(+,5),t('");"',3),t(')',4) ]
         Target    : [ t(prompt_7,3),t('Link',3) ]
         ForType   : 29
         Type      : []
      */
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_17_" + sGXsfl_43_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 44,'',false,'" + sGXsfl_43_idx + "',43)\"" ;
      ROClassString = "Attribute" ;
      Gridcity_kecamatanRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCityKecamatanId_Internalname,GXutil.ltrim( localUtil.ntoc( A28CityKecamatanId, (byte)(4), (byte)(0), ".", "")),GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A28CityKecamatanId), "ZZZ9"))," inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,44);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCityKecamatanId_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtCityKecamatanId_Enabled),Integer.valueOf(1),"text","1",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(4),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(0),Boolean.valueOf(true),"Id","right",Boolean.valueOf(false),""});
      /* Subfile cell */
      /* Single line edit */
      TempTags = " data-gxoch1=\"gx.fn.setControlValue('nIsMod_17_" + sGXsfl_43_idx + "',1);\"  onfocus=\"gx.evt.onfocus(this, 45,'',false,'" + sGXsfl_43_idx + "',43)\"" ;
      ROClassString = "Attribute" ;
      Gridcity_kecamatanRow.AddColumnProperties("edit", 1, isAjaxCallMode( ), new Object[] {edtCityKecamatanName_Internalname,A29CityKecamatanName,"",TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,45);\"","'"+""+"'"+",false,"+"'"+""+"'","","","","",edtCityKecamatanName_Jsonclick,Integer.valueOf(0),"Attribute","",ROClassString,"","",Integer.valueOf(-1),Integer.valueOf(edtCityKecamatanName_Enabled),Integer.valueOf(0),"text","",Integer.valueOf(0),"px",Integer.valueOf(17),"px",Integer.valueOf(40),Integer.valueOf(0),Integer.valueOf(0),Integer.valueOf(43),Integer.valueOf(0),Integer.valueOf(-1),Integer.valueOf(-1),Boolean.valueOf(true),"Name","left",Boolean.valueOf(true),""});
      httpContext.ajax_sending_grid_row(Gridcity_kecamatanRow);
      send_integrity_lvl_hashes0417( ) ;
      GXCCtl = "Z28CityKecamatanId_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( Z28CityKecamatanId, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "Z29CityKecamatanName_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, Z29CityKecamatanName);
      GXCCtl = "nRcdDeleted_17_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdDeleted_17, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "nRcdExists_17_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nRcdExists_17, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "nIsMod_17_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( nIsMod_17, (byte)(4), (byte)(0), ".", "")));
      GXCCtl = "CITYID_" + sGXsfl_43_idx ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtl, GXutil.ltrim( localUtil.ntoc( A7CityId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "CITYKECAMATANID_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityKecamatanId_Enabled, (byte)(5), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "CITYKECAMATANNAME_"+sGXsfl_43_idx+"Enabled", GXutil.ltrim( localUtil.ntoc( edtCityKecamatanName_Enabled, (byte)(5), (byte)(0), ".", "")));
      httpContext.ajax_sending_grid_row(null);
      Gridcity_kecamatanContainer.AddRow(Gridcity_kecamatanRow);
   }

   public void readRow0417( )
   {
      nGXsfl_43_idx = (int)(nGXsfl_43_idx+1) ;
      sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4317( ) ;
      edtCityKecamatanId_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CITYKECAMATANID_"+sGXsfl_43_idx+"Enabled"), ".", ",")) ;
      edtCityKecamatanName_Enabled = (int)(localUtil.ctol( httpContext.cgiGet( "CITYKECAMATANNAME_"+sGXsfl_43_idx+"Enabled"), ".", ",")) ;
      if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCityKecamatanId_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCityKecamatanId_Internalname), ".", ",") > 9999 ) ) )
      {
         GXCCtl = "CITYKECAMATANID_" + sGXsfl_43_idx ;
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, GXCCtl);
         AnyError = (short)(1) ;
         GX_FocusControl = edtCityKecamatanId_Internalname ;
         wbErr = true ;
         A28CityKecamatanId = (short)(0) ;
      }
      else
      {
         A28CityKecamatanId = (short)(localUtil.ctol( httpContext.cgiGet( edtCityKecamatanId_Internalname), ".", ",")) ;
      }
      A29CityKecamatanName = httpContext.cgiGet( edtCityKecamatanName_Internalname) ;
      GXCCtl = "Z28CityKecamatanId_" + sGXsfl_43_idx ;
      Z28CityKecamatanId = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
      GXCCtl = "Z29CityKecamatanName_" + sGXsfl_43_idx ;
      Z29CityKecamatanName = httpContext.cgiGet( GXCCtl) ;
      GXCCtl = "nRcdDeleted_17_" + sGXsfl_43_idx ;
      nRcdDeleted_17 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
      GXCCtl = "nRcdExists_17_" + sGXsfl_43_idx ;
      nRcdExists_17 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
      GXCCtl = "nIsMod_17_" + sGXsfl_43_idx ;
      nIsMod_17 = (short)(localUtil.ctol( httpContext.cgiGet( GXCCtl), ".", ",")) ;
   }

   public void assign_properties_default( )
   {
      defedtCityKecamatanId_Enabled = edtCityKecamatanId_Enabled ;
   }

   public void confirmValues040( )
   {
      nGXsfl_43_idx = 0 ;
      sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
      subsflControlProps_4317( ) ;
      while ( nGXsfl_43_idx < nRC_GXsfl_43 )
      {
         nGXsfl_43_idx = (int)(nGXsfl_43_idx+1) ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4317( ) ;
         httpContext.changePostValue( "Z28CityKecamatanId_"+sGXsfl_43_idx, httpContext.cgiGet( "ZT_"+"Z28CityKecamatanId_"+sGXsfl_43_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z28CityKecamatanId_"+sGXsfl_43_idx) ;
         httpContext.changePostValue( "Z29CityKecamatanName_"+sGXsfl_43_idx, httpContext.cgiGet( "ZT_"+"Z29CityKecamatanName_"+sGXsfl_43_idx)) ;
         httpContext.deletePostValue( "ZT_"+"Z29CityKecamatanName_"+sGXsfl_43_idx) ;
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
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.city", new String[] {}, new String[] {}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"City");
      forbiddenHiddens.add("CityId", localUtil.format( DecimalUtil.doubleToDec(A7CityId), "ZZZ9"));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("city:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z7CityId", GXutil.ltrim( localUtil.ntoc( Z7CityId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z8CityName", Z8CityName);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "nRC_GXsfl_43", GXutil.ltrim( localUtil.ntoc( nGXsfl_43_idx, (byte)(8), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "CITYID", GXutil.ltrim( localUtil.ntoc( A7CityId, (byte)(4), (byte)(0), ".", "")));
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
      return formatLink("com.kbbaru.city", new String[] {}, new String[] {})  ;
   }

   public String getPgmname( )
   {
      return "City" ;
   }

   public String getPgmdesc( )
   {
      return "City" ;
   }

   public void initializeNonKey044( )
   {
      A8CityName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A8CityName", A8CityName);
      Z8CityName = "" ;
   }

   public void initAll044( )
   {
      A7CityId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A7CityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A7CityId), 4, 0));
      initializeNonKey044( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0417( )
   {
      A29CityKecamatanName = "" ;
      Z29CityKecamatanName = "" ;
   }

   public void initAll0417( )
   {
      A28CityKecamatanId = (short)(0) ;
      initializeNonKey0417( ) ;
   }

   public void standaloneModalInsert0417( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?202352611211986", true, true);
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
      httpContext.AddJavascriptSource("city.js", "?202352611211987", false, true);
      /* End function include_jscripts */
   }

   public void init_level_properties17( )
   {
      edtCityKecamatanId_Enabled = defedtCityKecamatanId_Enabled ;
      httpContext.ajax_rsp_assign_prop("", false, edtCityKecamatanId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCityKecamatanId_Enabled), 5, 0), !bGXsfl_43_Refreshing);
   }

   public void startgridcontrol43( )
   {
      Gridcity_kecamatanContainer.AddObjectProperty("GridName", "Gridcity_kecamatan");
      Gridcity_kecamatanContainer.AddObjectProperty("Header", subGridcity_kecamatan_Header);
      Gridcity_kecamatanContainer.AddObjectProperty("Class", "Grid");
      Gridcity_kecamatanContainer.AddObjectProperty("Cellpadding", GXutil.ltrim( localUtil.ntoc( 1, (byte)(4), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddObjectProperty("Cellspacing", GXutil.ltrim( localUtil.ntoc( 2, (byte)(4), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddObjectProperty("Backcolorstyle", GXutil.ltrim( localUtil.ntoc( subGridcity_kecamatan_Backcolorstyle, (byte)(1), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddObjectProperty("CmpContext", "");
      Gridcity_kecamatanContainer.AddObjectProperty("InMasterPage", "false");
      Gridcity_kecamatanColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridcity_kecamatanColumn.AddObjectProperty("Value", WebUtils.htmlEncode( GXutil.ltrim( localUtil.ntoc( A28CityKecamatanId, (byte)(4), (byte)(0), ".", ""))));
      Gridcity_kecamatanColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCityKecamatanId_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddColumnProperties(Gridcity_kecamatanColumn);
      Gridcity_kecamatanColumn = GXWebColumn.GetNew(isAjaxCallMode( )) ;
      Gridcity_kecamatanColumn.AddObjectProperty("Value", WebUtils.htmlEncode( A29CityKecamatanName));
      Gridcity_kecamatanColumn.AddObjectProperty("Enabled", GXutil.ltrim( localUtil.ntoc( edtCityKecamatanName_Enabled, (byte)(5), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddColumnProperties(Gridcity_kecamatanColumn);
      Gridcity_kecamatanContainer.AddObjectProperty("Selectedindex", GXutil.ltrim( localUtil.ntoc( subGridcity_kecamatan_Selectedindex, (byte)(4), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddObjectProperty("Allowselection", GXutil.ltrim( localUtil.ntoc( subGridcity_kecamatan_Allowselection, (byte)(1), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddObjectProperty("Selectioncolor", GXutil.ltrim( localUtil.ntoc( subGridcity_kecamatan_Selectioncolor, (byte)(9), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddObjectProperty("Allowhover", GXutil.ltrim( localUtil.ntoc( subGridcity_kecamatan_Allowhovering, (byte)(1), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddObjectProperty("Hovercolor", GXutil.ltrim( localUtil.ntoc( subGridcity_kecamatan_Hoveringcolor, (byte)(9), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddObjectProperty("Allowcollapsing", GXutil.ltrim( localUtil.ntoc( subGridcity_kecamatan_Allowcollapsing, (byte)(1), (byte)(0), ".", "")));
      Gridcity_kecamatanContainer.AddObjectProperty("Collapsed", GXutil.ltrim( localUtil.ntoc( subGridcity_kecamatan_Collapsed, (byte)(1), (byte)(0), ".", "")));
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
      edtCityName_Internalname = "CITYNAME" ;
      lblTitlekecamatan_Internalname = "TITLEKECAMATAN" ;
      edtCityKecamatanId_Internalname = "CITYKECAMATANID" ;
      edtCityKecamatanName_Internalname = "CITYKECAMATANNAME" ;
      divKecamatantable_Internalname = "KECAMATANTABLE" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      subGridcity_kecamatan_Internalname = "GRIDCITY_KECAMATAN" ;
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
      subGridcity_kecamatan_Allowcollapsing = (byte)(0) ;
      subGridcity_kecamatan_Allowselection = (byte)(0) ;
      subGridcity_kecamatan_Header = "" ;
      Form.setHeaderrawhtml( "" );
      Form.setBackground( "" );
      Form.setTextcolor( 0 );
      Form.setIBackground( (int)(0xFFFFFF) );
      Form.setCaption( "City" );
      edtCityKecamatanName_Jsonclick = "" ;
      edtCityKecamatanId_Jsonclick = "" ;
      subGridcity_kecamatan_Class = "Grid" ;
      subGridcity_kecamatan_Backcolorstyle = (byte)(0) ;
      edtCityKecamatanName_Enabled = 1 ;
      edtCityKecamatanId_Enabled = 1 ;
      bttBtn_delete_Enabled = 1 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      edtCityName_Jsonclick = "" ;
      edtCityName_Enabled = 1 ;
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

   public void gxnrgridcity_kecamatan_newrow( )
   {
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      Gx_mode = "INS" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      subsflControlProps_4317( ) ;
      while ( nGXsfl_43_idx <= nRC_GXsfl_43 )
      {
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         standaloneNotModal0417( ) ;
         standaloneModal0417( ) ;
         init_web_controls( ) ;
         dynload_actions( ) ;
         sendRow0417( ) ;
         nGXsfl_43_idx = (int)(nGXsfl_43_idx+1) ;
         sGXsfl_43_idx = GXutil.padl( GXutil.ltrimstr( DecimalUtil.doubleToDec(nGXsfl_43_idx), 4, 0), (short)(4), "0") ;
         subsflControlProps_4317( ) ;
      }
      addString( httpContext.getJSONContainerResponse( Gridcity_kecamatanContainer)) ;
      /* End function gxnrGridcity_kecamatan_newrow */
   }

   public void init_web_controls( )
   {
      /* End function init_web_controls */
   }

   public void afterkeyloadscreen( )
   {
      IsConfirmed = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      getEqualNoModal( ) ;
      GX_FocusControl = edtCityName_Internalname ;
      httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      standaloneNotModal( ) ;
      standaloneModal( ) ;
      /* End function AfterKeyLoadScreen */
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
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'A7CityId',fld:'CITYID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12042',iparms:[]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_CITYKECAMATANID","{handler:'valid_Citykecamatanid',iparms:[]");
      setEventMetadata("VALID_CITYKECAMATANID",",oparms:[]}");
      setEventMetadata("NULL","{handler:'valid_Citykecamatanname',iparms:[]");
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
      Z8CityName = "" ;
      Z29CityKecamatanName = "" ;
      scmdbuf = "" ;
      gxfirstwebparm = "" ;
      gxfirstwebparm_bkp = "" ;
      GXKey = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Form = new com.genexus.webpanels.GXWebForm();
      GX_FocusControl = "" ;
      Gx_mode = "" ;
      lblTitle_Jsonclick = "" ;
      ClassString = "" ;
      StyleString = "" ;
      TempTags = "" ;
      bttBtn_first_Jsonclick = "" ;
      bttBtn_previous_Jsonclick = "" ;
      bttBtn_next_Jsonclick = "" ;
      bttBtn_last_Jsonclick = "" ;
      bttBtn_select_Jsonclick = "" ;
      A8CityName = "" ;
      lblTitlekecamatan_Jsonclick = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      Gridcity_kecamatanContainer = new com.genexus.webpanels.GXWebGrid(context);
      sMode17 = "" ;
      sStyleString = "" ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      GXCCtl = "" ;
      A29CityKecamatanName = "" ;
      T00046_A7CityId = new short[1] ;
      T00046_A8CityName = new String[] {""} ;
      T00047_A7CityId = new short[1] ;
      T00045_A7CityId = new short[1] ;
      T00045_A8CityName = new String[] {""} ;
      sMode4 = "" ;
      T00048_A7CityId = new short[1] ;
      T00049_A7CityId = new short[1] ;
      T00044_A7CityId = new short[1] ;
      T00044_A8CityName = new String[] {""} ;
      T000411_A7CityId = new short[1] ;
      T000414_A7CityId = new short[1] ;
      T000415_A7CityId = new short[1] ;
      T000415_A28CityKecamatanId = new short[1] ;
      T000415_A29CityKecamatanName = new String[] {""} ;
      T000416_A7CityId = new short[1] ;
      T000416_A28CityKecamatanId = new short[1] ;
      T00043_A7CityId = new short[1] ;
      T00043_A28CityKecamatanId = new short[1] ;
      T00043_A29CityKecamatanName = new String[] {""} ;
      T00042_A7CityId = new short[1] ;
      T00042_A28CityKecamatanId = new short[1] ;
      T00042_A29CityKecamatanName = new String[] {""} ;
      T000420_A7CityId = new short[1] ;
      T000420_A28CityKecamatanId = new short[1] ;
      Gridcity_kecamatanRow = new com.genexus.webpanels.GXWebRow();
      subGridcity_kecamatan_Linesclass = "" ;
      ROClassString = "" ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      Gridcity_kecamatanColumn = new com.genexus.webpanels.GXWebColumn();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.city__default(),
         new Object[] {
             new Object[] {
            T00042_A7CityId, T00042_A28CityKecamatanId, T00042_A29CityKecamatanName
            }
            , new Object[] {
            T00043_A7CityId, T00043_A28CityKecamatanId, T00043_A29CityKecamatanName
            }
            , new Object[] {
            T00044_A7CityId, T00044_A8CityName
            }
            , new Object[] {
            T00045_A7CityId, T00045_A8CityName
            }
            , new Object[] {
            T00046_A7CityId, T00046_A8CityName
            }
            , new Object[] {
            T00047_A7CityId
            }
            , new Object[] {
            T00048_A7CityId
            }
            , new Object[] {
            T00049_A7CityId
            }
            , new Object[] {
            }
            , new Object[] {
            T000411_A7CityId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000414_A7CityId
            }
            , new Object[] {
            T000415_A7CityId, T000415_A28CityKecamatanId, T000415_A29CityKecamatanName
            }
            , new Object[] {
            T000416_A7CityId, T000416_A28CityKecamatanId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000420_A7CityId, T000420_A28CityKecamatanId
            }
         }
      );
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte Gx_BScreen ;
   private byte subGridcity_kecamatan_Backcolorstyle ;
   private byte subGridcity_kecamatan_Backstyle ;
   private byte gxajaxcallmode ;
   private byte subGridcity_kecamatan_Allowselection ;
   private byte subGridcity_kecamatan_Allowhovering ;
   private byte subGridcity_kecamatan_Allowcollapsing ;
   private byte subGridcity_kecamatan_Collapsed ;
   private short Z7CityId ;
   private short Z28CityKecamatanId ;
   private short nRcdDeleted_17 ;
   private short nRcdExists_17 ;
   private short nIsMod_17 ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short nBlankRcdCount17 ;
   private short RcdFound17 ;
   private short nBlankRcdUsr17 ;
   private short A7CityId ;
   private short A28CityKecamatanId ;
   private short RcdFound4 ;
   private short nIsDirty_4 ;
   private short nIsDirty_17 ;
   private int nRC_GXsfl_43 ;
   private int nGXsfl_43_idx=1 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtCityName_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int edtCityKecamatanId_Enabled ;
   private int edtCityKecamatanName_Enabled ;
   private int fRowAdded ;
   private int GX_JID ;
   private int subGridcity_kecamatan_Backcolor ;
   private int subGridcity_kecamatan_Allbackcolor ;
   private int defedtCityKecamatanId_Enabled ;
   private int idxLst ;
   private int subGridcity_kecamatan_Selectedindex ;
   private int subGridcity_kecamatan_Selectioncolor ;
   private int subGridcity_kecamatan_Hoveringcolor ;
   private long GRIDCITY_KECAMATAN_nFirstRecordOnPage ;
   private String sPrefix ;
   private String scmdbuf ;
   private String gxfirstwebparm ;
   private String gxfirstwebparm_bkp ;
   private String GXKey ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String GX_FocusControl ;
   private String edtCityName_Internalname ;
   private String sGXsfl_43_idx="0001" ;
   private String Gx_mode ;
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
   private String edtCityName_Jsonclick ;
   private String divKecamatantable_Internalname ;
   private String lblTitlekecamatan_Internalname ;
   private String lblTitlekecamatan_Jsonclick ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String sMode17 ;
   private String edtCityKecamatanId_Internalname ;
   private String edtCityKecamatanName_Internalname ;
   private String sStyleString ;
   private String subGridcity_kecamatan_Internalname ;
   private String hsh ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String GXCCtl ;
   private String sMode4 ;
   private String sGXsfl_43_fel_idx="0001" ;
   private String subGridcity_kecamatan_Class ;
   private String subGridcity_kecamatan_Linesclass ;
   private String ROClassString ;
   private String edtCityKecamatanId_Jsonclick ;
   private String edtCityKecamatanName_Jsonclick ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String subGridcity_kecamatan_Header ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean bGXsfl_43_Refreshing=false ;
   private boolean returnInSub ;
   private String Z8CityName ;
   private String Z29CityKecamatanName ;
   private String A8CityName ;
   private String A29CityKecamatanName ;
   private com.genexus.webpanels.GXWebGrid Gridcity_kecamatanContainer ;
   private com.genexus.webpanels.GXWebRow Gridcity_kecamatanRow ;
   private com.genexus.webpanels.GXWebColumn Gridcity_kecamatanColumn ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private short[] T00046_A7CityId ;
   private String[] T00046_A8CityName ;
   private short[] T00047_A7CityId ;
   private short[] T00045_A7CityId ;
   private String[] T00045_A8CityName ;
   private short[] T00048_A7CityId ;
   private short[] T00049_A7CityId ;
   private short[] T00044_A7CityId ;
   private String[] T00044_A8CityName ;
   private short[] T000411_A7CityId ;
   private short[] T000414_A7CityId ;
   private short[] T000415_A7CityId ;
   private short[] T000415_A28CityKecamatanId ;
   private String[] T000415_A29CityKecamatanName ;
   private short[] T000416_A7CityId ;
   private short[] T000416_A28CityKecamatanId ;
   private short[] T00043_A7CityId ;
   private short[] T00043_A28CityKecamatanId ;
   private String[] T00043_A29CityKecamatanName ;
   private short[] T00042_A7CityId ;
   private short[] T00042_A28CityKecamatanId ;
   private String[] T00042_A29CityKecamatanName ;
   private short[] T000420_A7CityId ;
   private short[] T000420_A28CityKecamatanId ;
   private com.genexus.webpanels.GXWebForm Form ;
}

final  class city__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00042", "SELECT CityId, CityKecamatanId, CityKecamatanName FROM CityKecamatan WHERE CityId = ? AND CityKecamatanId = ?  FOR UPDATE OF CityKecamatan NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00043", "SELECT CityId, CityKecamatanId, CityKecamatanName FROM CityKecamatan WHERE CityId = ? AND CityKecamatanId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00044", "SELECT CityId, CityName FROM City WHERE CityId = ?  FOR UPDATE OF City NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00045", "SELECT CityId, CityName FROM City WHERE CityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00046", "SELECT TM1.CityId, TM1.CityName FROM City TM1 WHERE TM1.CityId = ? ORDER BY TM1.CityId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00047", "SELECT CityId FROM City WHERE CityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00048", "SELECT CityId FROM City WHERE ( CityId > ?) ORDER BY CityId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T00049", "SELECT CityId FROM City WHERE ( CityId < ?) ORDER BY CityId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000410", "SAVEPOINT gxupdate;INSERT INTO City(CityName) VALUES(?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000411", "SELECT currval('CityId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000412", "SAVEPOINT gxupdate;UPDATE City SET CityName=?  WHERE CityId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000413", "SAVEPOINT gxupdate;DELETE FROM City  WHERE CityId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000414", "SELECT CityId FROM City ORDER BY CityId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000415", "SELECT CityId, CityKecamatanId, CityKecamatanName FROM CityKecamatan WHERE CityId = ? and CityKecamatanId = ? ORDER BY CityId, CityKecamatanId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000416", "SELECT CityId, CityKecamatanId FROM CityKecamatan WHERE CityId = ? AND CityKecamatanId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000417", "SAVEPOINT gxupdate;INSERT INTO CityKecamatan(CityId, CityKecamatanId, CityKecamatanName) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000418", "SAVEPOINT gxupdate;UPDATE CityKecamatan SET CityKecamatanName=?  WHERE CityId = ? AND CityKecamatanId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000419", "SAVEPOINT gxupdate;DELETE FROM CityKecamatan  WHERE CityId = ? AND CityKecamatanId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000420", "SELECT CityId, CityKecamatanId FROM CityKecamatan WHERE CityId = ? ORDER BY CityId, CityKecamatanId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 18 :
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
            case 13 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 14 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 15 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               return;
            case 16 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

