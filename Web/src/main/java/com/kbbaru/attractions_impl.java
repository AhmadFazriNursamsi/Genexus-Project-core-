package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class attractions_impl extends GXWebPanel
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
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_15") == 0 )
      {
         A5CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_15( A5CountryId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_16") == 0 )
      {
         A5CountryId = (short)(GXutil.lval( httpContext.GetPar( "CountryId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
         A12CountryCityId = (short)(GXutil.lval( httpContext.GetPar( "CountryCityId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryCityId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_16( A5CountryId, A12CountryCityId) ;
         return  ;
      }
      else if ( GXutil.strcmp(gxfirstwebparm, "gxajaxExecAct_"+"gxLoad_14") == 0 )
      {
         A3CategoryId = (short)(GXutil.lval( httpContext.GetPar( "CategoryId"))) ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CategoryId), 4, 0));
         httpContext.setAjaxCallMode();
         if ( ! httpContext.IsValidAjaxCall( true) )
         {
            GxWebError = (byte)(1) ;
            return  ;
         }
         gxload_14( A3CategoryId) ;
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
            AV15AttractionsId = (short)(GXutil.lval( httpContext.GetPar( "AttractionsId"))) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV15AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV15AttractionsId), 4, 0));
            com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vATTRACTIONSID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15AttractionsId), "ZZZ9")));
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
         Form.getMeta().addItem("description", "Attractions", (short)(0)) ;
      }
      httpContext.wjLoc = "" ;
      httpContext.nUserReturn = (byte)(0) ;
      httpContext.wbHandled = (byte)(0) ;
      if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
      {
      }
      if ( ! httpContext.isAjaxRequest( ) )
      {
         GX_FocusControl = edtAttractionsName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      wbErr = false ;
      httpContext.setDefaultTheme("KBBaru", true);
      if ( ! httpContext.isLocalStorageSupported( ) )
      {
         httpContext.pushCurrentUrl();
      }
   }

   public attractions_impl( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public attractions_impl( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( attractions_impl.class ));
   }

   public attractions_impl( int remoteHandle ,
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
         validateSpaRequest();
         userMain( ) ;
         if ( ! isFullAjaxMode( ) && ( nDynComponent == 0 ) )
         {
            draw( ) ;
         }
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
      cleanup();
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
         renderHtmlCloseForm055( ) ;
      }
      /* Execute Exit event if defined. */
   }

   public void drawControls( )
   {
      renderHtmlHeaders( ) ;
      renderHtmlOpenForm( ) ;
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
      com.kbbaru.GxWebStd.gx_label_ctrl( httpContext, lblTitle_Internalname, "Attractions", "", "", lblTitle_Jsonclick, "'"+""+"'"+",false,"+"'"+""+"'", "", "heading-01", 0, "", 1, 1, 0, (short)(0), "HLP_Attractions.htm");
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
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_first_Internalname, "", "", bttBtn_first_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_first_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EFIRST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 23,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-prev" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_previous_Internalname, "", "", bttBtn_previous_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_previous_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"EPREVIOUS."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 25,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-next" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_next_Internalname, "", "", bttBtn_next_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_next_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ENEXT."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 27,'',false,'',0)\"" ;
      ClassString = "Button button-auxiliary ico__arrow-last" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_last_Internalname, "", "", bttBtn_last_Jsonclick, 5, "", "", StyleString, ClassString, bttBtn_last_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ELAST."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 29,'',false,'',0)\"" ;
      ClassString = "Button button-secondary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_select_Internalname, "", "Select", bttBtn_select_Jsonclick, 5, "Select", "", StyleString, ClassString, bttBtn_select_Visible, 0, "standard", "'"+""+"'"+",false,"+"'"+"ESELECT."+"'", TempTags, "", 2, "HLP_Attractions.htm");
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
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtAttractionsName_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtAttractionsName_Internalname, "Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 34,'',false,'',0)\"" ;
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtAttractionsName_Internalname, A10AttractionsName, GXutil.rtrim( localUtil.format( A10AttractionsName, "")), TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,34);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtAttractionsName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtAttractionsName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCountryId_Internalname, "Country Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 39,'',false,'',0)\"" ;
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryId_Internalname, GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A5CountryId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,39);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Attractions.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_5_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_5_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.kbbaru.GxWebStd.gx_bitmap( httpContext, imgprompt_5_Internalname, sImgUrl, imgprompt_5_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_5_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Attractions.htm");
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
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryName_Internalname, A6CountryName, GXutil.rtrim( localUtil.format( A6CountryName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCountryCityId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCountryCityId_Internalname, "Country City Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 49,'',false,'',0)\"" ;
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryCityId_Internalname, GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A12CountryCityId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,49);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryCityId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryCityId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Attractions.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_12_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_12_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.kbbaru.GxWebStd.gx_bitmap( httpContext, imgprompt_12_Internalname, sImgUrl, imgprompt_12_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_12_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Attractions.htm");
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
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCountryCityName_Internalname, "Country City Name", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCountryCityName_Internalname, A16CountryCityName, GXutil.rtrim( localUtil.format( A16CountryCityName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCountryCityName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCountryCityName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+edtCategoryId_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, edtCategoryId_Internalname, "Category Id", "col-sm-3 AttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Single line edit */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 59,'',false,'',0)\"" ;
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCategoryId_Internalname, GXutil.ltrim( localUtil.ntoc( A3CategoryId, (byte)(4), (byte)(0), ".", "")), GXutil.ltrim( localUtil.format( DecimalUtil.doubleToDec(A3CategoryId), "ZZZ9")), " inputmode=\"numeric\" pattern=\"[0-9]*\""+TempTags+" onchange=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onchange(this, event)\" "+" onblur=\""+"gx.num.valid_integer( this,',');"+";gx.evt.onblur(this,59);\"", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCategoryId_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCategoryId_Enabled, 1, "text", "1", 4, "chr", 1, "row", 4, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(0), true, "Id", "right", false, "", "HLP_Attractions.htm");
      /* Static images/pictures */
      ClassString = "gx-prompt Image" + " " + ((GXutil.strcmp(imgprompt_3_gximage, "")==0) ? "" : "GX_Image_"+imgprompt_3_gximage+"_Class") ;
      StyleString = "" ;
      sImgUrl = context.getHttpContext().getImagePath( "prompt.gif", "", context.getHttpContext().getTheme( )) ;
      com.kbbaru.GxWebStd.gx_bitmap( httpContext, imgprompt_3_Internalname, sImgUrl, imgprompt_3_Link, "", "", context.getHttpContext().getTheme( ), imgprompt_3_Visible, 1, "", "", 0, 0, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", "", "", "", "", 1, false, false, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Attractions.htm");
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
      com.kbbaru.GxWebStd.gx_single_line_edit( httpContext, edtCategoryName_Internalname, A4CategoryName, GXutil.rtrim( localUtil.format( A4CategoryName, "")), "", "'"+""+"'"+",false,"+"'"+""+"'", "", "", "", "", edtCategoryName_Jsonclick, 0, "Attribute", "", "", "", "", 1, edtCategoryName_Enabled, 0, "text", "", 40, "chr", 1, "row", 40, (byte)(0), (short)(0), 0, (byte)(0), (byte)(-1), (byte)(-1), true, "Name", "left", true, "", "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "row", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-xs-12 form__cell", "left", "top", "", "", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "form-group gx-form-group", "left", "top", ""+" data-gx-for=\""+imgAttractionsPhoto_Internalname+"\"", "", "div");
      /* Attribute/Variable Label */
      com.kbbaru.GxWebStd.gx_label_element( httpContext, "", "Photo", "col-sm-3 ImageAttributeLabel", 1, true, "");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "col-sm-9 gx-attribute", "left", "top", "", "", "div");
      /* Static Bitmap Variable */
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 69,'',false,'',0)\"" ;
      ClassString = "ImageAttribute" ;
      StyleString = "" ;
      A11AttractionsPhoto_IsBlob = (boolean)(((GXutil.strcmp("", A11AttractionsPhoto)==0)&&(GXutil.strcmp("", A40000AttractionsPhoto_GXI)==0))||!(GXutil.strcmp("", A11AttractionsPhoto)==0)) ;
      sImgUrl = ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.getResourceRelative(A11AttractionsPhoto)) ;
      com.kbbaru.GxWebStd.gx_bitmap( httpContext, imgAttractionsPhoto_Internalname, sImgUrl, "", "", "", context.getHttpContext().getTheme( ), 1, imgAttractionsPhoto_Enabled, "", "", 0, -1, 0, "", 0, "", 0, 0, 0, "", "", StyleString, ClassString, "", "", "", TempTags+" onchange=\""+""+";gx.evt.onchange(this, event)\" "+" onblur=\""+""+";gx.evt.onblur(this,69);\"", "", "", "", 0, A11AttractionsPhoto_IsBlob, true, context.getHttpContext().getImageSrcSet( sImgUrl), "HLP_Attractions.htm");
      httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "URL", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.getResourceRelative(A11AttractionsPhoto)), true);
      httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "IsBlob", GXutil.booltostr( A11AttractionsPhoto_IsBlob), true);
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
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 74,'',false,'',0)\"" ;
      ClassString = "Button button-primary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_enter_Internalname, "", "Confirm", bttBtn_enter_Jsonclick, 5, "Confirm", "", StyleString, ClassString, bttBtn_enter_Visible, bttBtn_enter_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EENTER."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 76,'',false,'',0)\"" ;
      ClassString = "Button button-tertiary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_cancel_Internalname, "", "Cancel", bttBtn_cancel_Jsonclick, 1, "Cancel", "", StyleString, ClassString, bttBtn_cancel_Visible, 1, "standard", "'"+""+"'"+",false,"+"'"+"ECANCEL."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      /* Div Control */
      com.kbbaru.GxWebStd.gx_div_start( httpContext, "", 1, 0, "px", 0, "px", "gx-button", "left", "top", "", "", "div");
      TempTags = "  onfocus=\"gx.evt.onfocus(this, 78,'',false,'',0)\"" ;
      ClassString = "Button button-tertiary" ;
      StyleString = "" ;
      com.kbbaru.GxWebStd.gx_button_ctrl( httpContext, bttBtn_delete_Internalname, "", "Delete", bttBtn_delete_Jsonclick, 5, "Delete", "", StyleString, ClassString, bttBtn_delete_Visible, bttBtn_delete_Enabled, "standard", "'"+""+"'"+",false,"+"'"+"EDELETE."+"'", TempTags, "", httpContext.getButtonType( ), "HLP_Attractions.htm");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "Right", "Middle", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
      com.kbbaru.GxWebStd.gx_div_end( httpContext, "left", "top", "div");
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
      e11052 ();
      httpContext.wbGlbDoneStart = (byte)(1) ;
      assign_properties_default( ) ;
      if ( AnyError == 0 )
      {
         if ( GXutil.strcmp(httpContext.getRequestMethod( ), "POST") == 0 )
         {
            /* Read saved SDTs. */
            /* Read saved values. */
            Z9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( "Z9AttractionsId"), ".", ",")) ;
            Z10AttractionsName = httpContext.cgiGet( "Z10AttractionsName") ;
            Z3CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( "Z3CategoryId"), ".", ",")) ;
            Z5CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "Z5CountryId"), ".", ",")) ;
            Z12CountryCityId = (short)(localUtil.ctol( httpContext.cgiGet( "Z12CountryCityId"), ".", ",")) ;
            IsConfirmed = (short)(localUtil.ctol( httpContext.cgiGet( "IsConfirmed"), ".", ",")) ;
            IsModified = (short)(localUtil.ctol( httpContext.cgiGet( "IsModified"), ".", ",")) ;
            Gx_mode = httpContext.cgiGet( "Mode") ;
            N5CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "N5CountryId"), ".", ",")) ;
            N12CountryCityId = (short)(localUtil.ctol( httpContext.cgiGet( "N12CountryCityId"), ".", ",")) ;
            N3CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( "N3CategoryId"), ".", ",")) ;
            AV15AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( "vATTRACTIONSID"), ".", ",")) ;
            A9AttractionsId = (short)(localUtil.ctol( httpContext.cgiGet( "ATTRACTIONSID"), ".", ",")) ;
            AV11Insert_CountryId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_COUNTRYID"), ".", ",")) ;
            AV16Insert_CountryCityId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_COUNTRYCITYID"), ".", ",")) ;
            AV13Insert_CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( "vINSERT_CATEGORYID"), ".", ",")) ;
            A40000AttractionsPhoto_GXI = httpContext.cgiGet( "ATTRACTIONSPHOTO_GXI") ;
            AV18Pgmname = httpContext.cgiGet( "vPGMNAME") ;
            /* Read variables values. */
            A10AttractionsName = httpContext.cgiGet( edtAttractionsName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A10AttractionsName", A10AttractionsName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ".", ",") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "COUNTRYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCountryId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A5CountryId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
            }
            else
            {
               A5CountryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryId_Internalname), ".", ",")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
            }
            A6CountryName = httpContext.cgiGet( edtCountryName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCountryCityId_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCountryCityId_Internalname), ".", ",") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "COUNTRYCITYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCountryCityId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A12CountryCityId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A12CountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryCityId), 4, 0));
            }
            else
            {
               A12CountryCityId = (short)(localUtil.ctol( httpContext.cgiGet( edtCountryCityId_Internalname), ".", ",")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A12CountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryCityId), 4, 0));
            }
            A16CountryCityName = httpContext.cgiGet( edtCountryCityName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
            if ( ( ( localUtil.ctol( httpContext.cgiGet( edtCategoryId_Internalname), ".", ",") < 0 ) ) || ( ( localUtil.ctol( httpContext.cgiGet( edtCategoryId_Internalname), ".", ",") > 9999 ) ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_badnum"), 1, "CATEGORYID");
               AnyError = (short)(1) ;
               GX_FocusControl = edtCategoryId_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               wbErr = true ;
               A3CategoryId = (short)(0) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CategoryId), 4, 0));
            }
            else
            {
               A3CategoryId = (short)(localUtil.ctol( httpContext.cgiGet( edtCategoryId_Internalname), ".", ",")) ;
               httpContext.ajax_rsp_assign_attri("", false, "A3CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CategoryId), 4, 0));
            }
            A4CategoryName = httpContext.cgiGet( edtCategoryName_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
            A11AttractionsPhoto = httpContext.cgiGet( imgAttractionsPhoto_Internalname) ;
            httpContext.ajax_rsp_assign_attri("", false, "A11AttractionsPhoto", A11AttractionsPhoto);
            /* Read subfile selected row values. */
            /* Read hidden variables. */
            GXv_char1[0] = A11AttractionsPhoto ;
            GXv_char2[0] = A40000AttractionsPhoto_GXI ;
            httpContext.getMultimediaValue(imgAttractionsPhoto_Internalname, GXv_char1, GXv_char2);
            attractions_impl.this.A11AttractionsPhoto = GXv_char1[0] ;
            attractions_impl.this.A40000AttractionsPhoto_GXI = GXv_char2[0] ;
            GXKey = httpContext.decrypt64( httpContext.getCookie( "GX_SESSION_ID"), context.getServerKey( )) ;
            forbiddenHiddens = new com.genexus.util.GXProperties() ;
            forbiddenHiddens.add("hshsalt", "hsh"+"Attractions");
            forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
            forbiddenHiddens.add("AttractionsId", localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9"));
            hsh = httpContext.cgiGet( "hsh") ;
            if ( ! GXutil.checkEncryptedSignature( forbiddenHiddens.toString(), hsh, GXKey) )
            {
               GXutil.writeLogError("attractions:[ SecurityCheckFailed (403 Forbidden) value for]"+forbiddenHiddens.toJSonString());
               GxWebError = (byte)(1) ;
               httpContext.sendError( 403 );
               GXutil.writeLog("send_http_error_code 403");
               AnyError = (short)(1) ;
               return  ;
            }
            standaloneNotModal( ) ;
         }
         else
         {
            standaloneNotModal( ) ;
            if ( GXutil.strcmp(gxfirstwebparm, "viewer") == 0 )
            {
               Gx_mode = "DSP" ;
               httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               A9AttractionsId = (short)(GXutil.lval( httpContext.GetPar( "AttractionsId"))) ;
               httpContext.ajax_rsp_assign_attri("", false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
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
                  sMode5 = Gx_mode ;
                  Gx_mode = "UPD" ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
                  Gx_mode = sMode5 ;
                  httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
               }
               standaloneModal( ) ;
               if ( ! isIns( ) )
               {
                  getByPrimaryKey( ) ;
                  if ( RcdFound5 == 1 )
                  {
                     if ( isDlt( ) )
                     {
                        /* Confirm record */
                        confirm_050( ) ;
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
                     e11052 ();
                  }
                  else if ( GXutil.strcmp(sEvt, "AFTER TRN") == 0 )
                  {
                     httpContext.wbHandled = (byte)(1) ;
                     dynload_actions( ) ;
                     /* Execute user event: After Trn */
                     e12052 ();
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
               }
            }
            httpContext.wbHandled = (byte)(1) ;
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
         e12052 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            /* Clear variables for new insertion. */
            initAll055( ) ;
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
         disableAttributes055( ) ;
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

   public void confirm_050( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls055( ) ;
         }
         else
         {
            checkExtendedTable055( ) ;
            closeExtendedTableCursors055( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         IsConfirmed = (short)(1) ;
         httpContext.ajax_rsp_assign_attri("", false, "IsConfirmed", GXutil.ltrimstr( DecimalUtil.doubleToDec(IsConfirmed), 4, 0));
      }
   }

   public void resetCaption050( )
   {
   }

   public void e11052( )
   {
      /* Start Routine */
      returnInSub = false ;
      if ( ! new com.kbbaru.general.security.isauthorized(remoteHandle, context).executeUdp( AV18Pgmname) )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         callWebObject(formatLink("com.kbbaru.general.security.notauthorized", new String[] {GXutil.URLEncode(GXutil.rtrim(AV18Pgmname))}, new String[] {"GxObject"}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      AV9TrnContext.fromxml(AV10WebSession.getValue("TrnContext"), null, null);
      AV11Insert_CountryId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_CountryId), 4, 0));
      AV16Insert_CountryCityId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_CountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16Insert_CountryCityId), 4, 0));
      AV13Insert_CategoryId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_CategoryId), 4, 0));
      if ( ( GXutil.strcmp(AV9TrnContext.getgxTv_SdtTransactionContext_Transactionname(), AV18Pgmname) == 0 ) && ( GXutil.strcmp(Gx_mode, "INS") == 0 ) )
      {
         AV19GXV1 = 1 ;
         httpContext.ajax_rsp_assign_attri("", false, "AV19GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19GXV1), 8, 0));
         while ( AV19GXV1 <= AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().size() )
         {
            AV14TrnContextAtt = (com.kbbaru.general.ui.SdtTransactionContext_Attribute)((com.kbbaru.general.ui.SdtTransactionContext_Attribute)AV9TrnContext.getgxTv_SdtTransactionContext_Attributes().elementAt(-1+AV19GXV1));
            if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "CountryId") == 0 )
            {
               AV11Insert_CountryId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV11Insert_CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV11Insert_CountryId), 4, 0));
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "CountryCityId") == 0 )
            {
               AV16Insert_CountryCityId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV16Insert_CountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV16Insert_CountryCityId), 4, 0));
            }
            else if ( GXutil.strcmp(AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributename(), "CategoryId") == 0 )
            {
               AV13Insert_CategoryId = (short)(GXutil.lval( AV14TrnContextAtt.getgxTv_SdtTransactionContext_Attribute_Attributevalue())) ;
               httpContext.ajax_rsp_assign_attri("", false, "AV13Insert_CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV13Insert_CategoryId), 4, 0));
            }
            AV19GXV1 = (int)(AV19GXV1+1) ;
            httpContext.ajax_rsp_assign_attri("", false, "AV19GXV1", GXutil.ltrimstr( DecimalUtil.doubleToDec(AV19GXV1), 8, 0));
         }
      }
   }

   public void e12052( )
   {
      /* After Trn Routine */
      returnInSub = false ;
      if ( ( GXutil.strcmp(Gx_mode, "DLT") == 0 ) && ! AV9TrnContext.getgxTv_SdtTransactionContext_Callerondelete() )
      {
         callWebObject(formatLink("com.kbbaru.wwattractions", new String[] {}, new String[] {}) );
         httpContext.wjLocDisableFrm = (byte)(1) ;
      }
      httpContext.setWebReturnParms(new Object[] {});
      httpContext.setWebReturnParmsMetadata(new Object[] {});
      httpContext.wjLocDisableFrm = (byte)(1) ;
      httpContext.nUserReturn = (byte)(1) ;
      pr_default.close(4);
      pr_default.close(3);
      pr_default.close(2);
      pr_default.close(1);
      returnInSub = true;
      if (true) return;
   }

   public void zm055( int GX_JID )
   {
      if ( ( GX_JID == 13 ) || ( GX_JID == 0 ) )
      {
         if ( ! isIns( ) )
         {
            Z10AttractionsName = T00053_A10AttractionsName[0] ;
            Z3CategoryId = T00053_A3CategoryId[0] ;
            Z5CountryId = T00053_A5CountryId[0] ;
            Z12CountryCityId = T00053_A12CountryCityId[0] ;
         }
         else
         {
            Z10AttractionsName = A10AttractionsName ;
            Z3CategoryId = A3CategoryId ;
            Z5CountryId = A5CountryId ;
            Z12CountryCityId = A12CountryCityId ;
         }
      }
      if ( GX_JID == -13 )
      {
         Z9AttractionsId = A9AttractionsId ;
         Z10AttractionsName = A10AttractionsName ;
         Z11AttractionsPhoto = A11AttractionsPhoto ;
         Z40000AttractionsPhoto_GXI = A40000AttractionsPhoto_GXI ;
         Z3CategoryId = A3CategoryId ;
         Z5CountryId = A5CountryId ;
         Z12CountryCityId = A12CountryCityId ;
         Z6CountryName = A6CountryName ;
         Z16CountryCityName = A16CountryCityName ;
         Z4CategoryName = A4CategoryName ;
      }
   }

   public void standaloneNotModal( )
   {
      imgprompt_5_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.kbbaru.gx0030"+"',["+"{Ctrl:gx.dom.el('"+"COUNTRYID"+"'), id:'"+"COUNTRYID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_12_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.kbbaru.gx00a1"+"',["+"{Ctrl:gx.dom.el('"+"COUNTRYID"+"'), id:'"+"COUNTRYID"+"'"+",IOType:'in'}"+","+"{Ctrl:gx.dom.el('"+"COUNTRYCITYID"+"'), id:'"+"COUNTRYCITYID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      imgprompt_3_Link = ((GXutil.strcmp(Gx_mode, "DSP")==0) ? "" : "javascript:"+"gx.popup.openPrompt('"+"com.kbbaru.gx0020"+"',["+"{Ctrl:gx.dom.el('"+"CATEGORYID"+"'), id:'"+"CATEGORYID"+"'"+",IOType:'out'}"+"],"+"null"+","+"'', false"+","+"false"+");") ;
      bttBtn_delete_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, bttBtn_delete_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(bttBtn_delete_Enabled), 5, 0), true);
      if ( ! (0==AV15AttractionsId) )
      {
         A9AttractionsId = AV15AttractionsId ;
         httpContext.ajax_rsp_assign_attri("", false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_CountryId) )
      {
         edtCountryId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCountryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryId_Enabled), 5, 0), true);
      }
      else
      {
         edtCountryId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCountryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_CountryCityId) )
      {
         edtCountryCityId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCountryCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityId_Enabled), 5, 0), true);
      }
      else
      {
         edtCountryCityId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCountryCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityId_Enabled), 5, 0), true);
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CategoryId) )
      {
         edtCategoryId_Enabled = 0 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCategoryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCategoryId_Enabled), 5, 0), true);
      }
      else
      {
         edtCategoryId_Enabled = 1 ;
         httpContext.ajax_rsp_assign_prop("", false, edtCategoryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCategoryId_Enabled), 5, 0), true);
      }
   }

   public void standaloneModal( )
   {
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV13Insert_CategoryId) )
      {
         A3CategoryId = AV13Insert_CategoryId ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CategoryId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV16Insert_CountryCityId) )
      {
         A12CountryCityId = AV16Insert_CountryCityId ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryCityId), 4, 0));
      }
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ! (0==AV11Insert_CountryId) )
      {
         A5CountryId = AV11Insert_CountryId ;
         httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
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
      if ( ( GXutil.strcmp(Gx_mode, "INS") == 0 ) && ( Gx_BScreen == 0 ) )
      {
         AV18Pgmname = "Attractions" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
         /* Using cursor T00054 */
         pr_default.execute(2, new Object[] {Short.valueOf(A3CategoryId)});
         A4CategoryName = T00054_A4CategoryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
         pr_default.close(2);
         /* Using cursor T00055 */
         pr_default.execute(3, new Object[] {Short.valueOf(A5CountryId)});
         A6CountryName = T00055_A6CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
         pr_default.close(3);
         /* Using cursor T00056 */
         pr_default.execute(4, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
         A16CountryCityName = T00056_A16CountryCityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
         pr_default.close(4);
      }
   }

   public void load055( )
   {
      /* Using cursor T00057 */
      pr_default.execute(5, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A10AttractionsName = T00057_A10AttractionsName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10AttractionsName", A10AttractionsName);
         A6CountryName = T00057_A6CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
         A16CountryCityName = T00057_A16CountryCityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
         A4CategoryName = T00057_A4CategoryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
         A11AttractionsPhoto = T00057_A11AttractionsPhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11AttractionsPhoto", A11AttractionsPhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
         A40000AttractionsPhoto_GXI = T00057_A40000AttractionsPhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
         A3CategoryId = T00057_A3CategoryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CategoryId), 4, 0));
         A5CountryId = T00057_A5CountryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
         A12CountryCityId = T00057_A12CountryCityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryCityId), 4, 0));
         zm055( -13) ;
      }
      pr_default.close(5);
      onLoadActions055( ) ;
   }

   public void onLoadActions055( )
   {
      AV18Pgmname = "Attractions" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
   }

   public void checkExtendedTable055( )
   {
      nIsDirty_5 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal( ) ;
      AV18Pgmname = "Attractions" ;
      httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
      /* Using cursor T00055 */
      pr_default.execute(3, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(3) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'Country'.", "ForeignKeyNotFound", 1, "COUNTRYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A6CountryName = T00055_A6CountryName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
      pr_default.close(3);
      /* Using cursor T00056 */
      pr_default.execute(4, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
      if ( (pr_default.getStatus(4) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'City'.", "ForeignKeyNotFound", 1, "COUNTRYCITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A16CountryCityName = T00056_A16CountryCityName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
      pr_default.close(4);
      /* Using cursor T00054 */
      pr_default.execute(2, new Object[] {Short.valueOf(A3CategoryId)});
      if ( (pr_default.getStatus(2) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'Category'.", "ForeignKeyNotFound", 1, "CATEGORYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCategoryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A4CategoryName = T00054_A4CategoryName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
      pr_default.close(2);
   }

   public void closeExtendedTableCursors055( )
   {
      pr_default.close(3);
      pr_default.close(4);
      pr_default.close(2);
   }

   public void enableDisable( )
   {
   }

   public void gxload_15( short A5CountryId )
   {
      /* Using cursor T00058 */
      pr_default.execute(6, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(6) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'Country'.", "ForeignKeyNotFound", 1, "COUNTRYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A6CountryName = T00058_A6CountryName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A6CountryName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(6) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(6);
   }

   public void gxload_16( short A5CountryId ,
                          short A12CountryCityId )
   {
      /* Using cursor T00059 */
      pr_default.execute(7, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
      if ( (pr_default.getStatus(7) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'City'.", "ForeignKeyNotFound", 1, "COUNTRYCITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A16CountryCityName = T00059_A16CountryCityName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A16CountryCityName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(7) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(7);
   }

   public void gxload_14( short A3CategoryId )
   {
      /* Using cursor T000510 */
      pr_default.execute(8, new Object[] {Short.valueOf(A3CategoryId)});
      if ( (pr_default.getStatus(8) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'Category'.", "ForeignKeyNotFound", 1, "CATEGORYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCategoryId_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      A4CategoryName = T000510_A4CategoryName[0] ;
      httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
      com.kbbaru.GxWebStd.set_html_headers( httpContext, 0, "", "");
      addString( "[[") ;
      addString( "\""+PrivateUtilities.encodeJSConstant( A4CategoryName)+"\"") ;
      addString( "]") ;
      if ( (pr_default.getStatus(8) == 101) )
      {
         addString( ",") ;
         addString( "101") ;
      }
      addString( "]") ;
      pr_default.close(8);
   }

   public void getKey055( )
   {
      /* Using cursor T000511 */
      pr_default.execute(9, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(9) != 101) )
      {
         RcdFound5 = (short)(1) ;
      }
      else
      {
         RcdFound5 = (short)(0) ;
      }
      pr_default.close(9);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor T00053 */
      pr_default.execute(1, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(1) != 101) )
      {
         zm055( 13) ;
         RcdFound5 = (short)(1) ;
         A9AttractionsId = T00053_A9AttractionsId[0] ;
         A10AttractionsName = T00053_A10AttractionsName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A10AttractionsName", A10AttractionsName);
         A11AttractionsPhoto = T00053_A11AttractionsPhoto[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A11AttractionsPhoto", A11AttractionsPhoto);
         httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
         A40000AttractionsPhoto_GXI = T00053_A40000AttractionsPhoto_GXI[0] ;
         httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
         httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
         A3CategoryId = T00053_A3CategoryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A3CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CategoryId), 4, 0));
         A5CountryId = T00053_A5CountryId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
         A12CountryCityId = T00053_A12CountryCityId[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A12CountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryCityId), 4, 0));
         Z9AttractionsId = A9AttractionsId ;
         sMode5 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         load055( ) ;
         if ( AnyError == 1 )
         {
            RcdFound5 = (short)(0) ;
            initializeNonKey055( ) ;
         }
         Gx_mode = sMode5 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      else
      {
         RcdFound5 = (short)(0) ;
         initializeNonKey055( ) ;
         sMode5 = Gx_mode ;
         Gx_mode = "DSP" ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
         standaloneModal( ) ;
         Gx_mode = sMode5 ;
         httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      }
      pr_default.close(1);
   }

   public void getEqualNoModal( )
   {
      getKey055( ) ;
      if ( RcdFound5 == 0 )
      {
      }
      else
      {
      }
      getByPrimaryKey( ) ;
   }

   public void move_next( )
   {
      RcdFound5 = (short)(0) ;
      /* Using cursor T000512 */
      pr_default.execute(10, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(10) != 101) )
      {
         while ( (pr_default.getStatus(10) != 101) && ( ( T000512_A9AttractionsId[0] < A9AttractionsId ) ) )
         {
            pr_default.readNext(10);
         }
         if ( (pr_default.getStatus(10) != 101) && ( ( T000512_A9AttractionsId[0] > A9AttractionsId ) ) )
         {
            A9AttractionsId = T000512_A9AttractionsId[0] ;
            RcdFound5 = (short)(1) ;
         }
      }
      pr_default.close(10);
   }

   public void move_previous( )
   {
      RcdFound5 = (short)(0) ;
      /* Using cursor T000513 */
      pr_default.execute(11, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(11) != 101) )
      {
         while ( (pr_default.getStatus(11) != 101) && ( ( T000513_A9AttractionsId[0] > A9AttractionsId ) ) )
         {
            pr_default.readNext(11);
         }
         if ( (pr_default.getStatus(11) != 101) && ( ( T000513_A9AttractionsId[0] < A9AttractionsId ) ) )
         {
            A9AttractionsId = T000513_A9AttractionsId[0] ;
            RcdFound5 = (short)(1) ;
         }
      }
      pr_default.close(11);
   }

   public void btn_enter( )
   {
      nKeyPressed = (byte)(1) ;
      getKey055( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         GX_FocusControl = edtAttractionsName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         insert055( ) ;
         if ( AnyError == 1 )
         {
            GX_FocusControl = "" ;
            httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
         }
      }
      else
      {
         if ( RcdFound5 == 1 )
         {
            if ( A9AttractionsId != Z9AttractionsId )
            {
               A9AttractionsId = Z9AttractionsId ;
               httpContext.ajax_rsp_assign_attri("", false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
               GX_FocusControl = edtAttractionsName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
            else
            {
               /* Update record */
               update055( ) ;
               GX_FocusControl = edtAttractionsName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
            }
         }
         else
         {
            if ( A9AttractionsId != Z9AttractionsId )
            {
               /* Insert record */
               GX_FocusControl = edtAttractionsName_Internalname ;
               httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
               insert055( ) ;
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
                  GX_FocusControl = edtAttractionsName_Internalname ;
                  httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
                  insert055( ) ;
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
      if ( A9AttractionsId != Z9AttractionsId )
      {
         A9AttractionsId = Z9AttractionsId ;
         httpContext.ajax_rsp_assign_attri("", false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforedlt"), 1, "");
         AnyError = (short)(1) ;
      }
      else
      {
         delete( ) ;
         afterTrn( ) ;
         GX_FocusControl = edtAttractionsName_Internalname ;
         httpContext.ajax_rsp_assign_attri("", false, "GX_FocusControl", GX_FocusControl);
      }
      if ( AnyError != 0 )
      {
      }
   }

   public void checkOptimisticConcurrency055( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor T00052 */
         pr_default.execute(0, new Object[] {Short.valueOf(A9AttractionsId)});
         if ( (pr_default.getStatus(0) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Attractions"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(0) == 101) || ( GXutil.strcmp(Z10AttractionsName, T00052_A10AttractionsName[0]) != 0 ) || ( Z3CategoryId != T00052_A3CategoryId[0] ) || ( Z5CountryId != T00052_A5CountryId[0] ) || ( Z12CountryCityId != T00052_A12CountryCityId[0] ) )
         {
            if ( GXutil.strcmp(Z10AttractionsName, T00052_A10AttractionsName[0]) != 0 )
            {
               GXutil.writeLogln("attractions:[seudo value changed for attri]"+"AttractionsName");
               GXutil.writeLogRaw("Old: ",Z10AttractionsName);
               GXutil.writeLogRaw("Current: ",T00052_A10AttractionsName[0]);
            }
            if ( Z3CategoryId != T00052_A3CategoryId[0] )
            {
               GXutil.writeLogln("attractions:[seudo value changed for attri]"+"CategoryId");
               GXutil.writeLogRaw("Old: ",Z3CategoryId);
               GXutil.writeLogRaw("Current: ",T00052_A3CategoryId[0]);
            }
            if ( Z5CountryId != T00052_A5CountryId[0] )
            {
               GXutil.writeLogln("attractions:[seudo value changed for attri]"+"CountryId");
               GXutil.writeLogRaw("Old: ",Z5CountryId);
               GXutil.writeLogRaw("Current: ",T00052_A5CountryId[0]);
            }
            if ( Z12CountryCityId != T00052_A12CountryCityId[0] )
            {
               GXutil.writeLogln("attractions:[seudo value changed for attri]"+"CountryCityId");
               GXutil.writeLogRaw("Old: ",Z12CountryCityId);
               GXutil.writeLogRaw("Current: ",T00052_A12CountryCityId[0]);
            }
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Attractions"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert055( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable055( ) ;
      }
      if ( AnyError == 0 )
      {
         zm055( 0) ;
         checkOptimisticConcurrency055( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm055( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert055( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000514 */
                  pr_default.execute(12, new Object[] {A10AttractionsName, A11AttractionsPhoto, A40000AttractionsPhoto_GXI, Short.valueOf(A3CategoryId), Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
                  /* Retrieving last key number assigned */
                  /* Using cursor T000515 */
                  pr_default.execute(13);
                  A9AttractionsId = T000515_A9AttractionsId[0] ;
                  pr_default.close(13);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Attractions");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        /* Save values for previous() function. */
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucadded") ;
                        endTrnMsgCod = "SuccessfullyAdded" ;
                        resetCaption050( ) ;
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
            load055( ) ;
         }
         endLevel055( ) ;
      }
      closeExtendedTableCursors055( ) ;
   }

   public void update055( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable055( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency055( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm055( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate055( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor T000516 */
                  pr_default.execute(14, new Object[] {A10AttractionsName, Short.valueOf(A3CategoryId), Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId), Short.valueOf(A9AttractionsId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Attractions");
                  if ( (pr_default.getStatus(14) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Attractions"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate055( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
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
         endLevel055( ) ;
      }
      closeExtendedTableCursors055( ) ;
   }

   public void deferredUpdate055( )
   {
      if ( AnyError == 0 )
      {
         /* Using cursor T000517 */
         pr_default.execute(15, new Object[] {A11AttractionsPhoto, A40000AttractionsPhoto_GXI, Short.valueOf(A9AttractionsId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Attractions");
      }
   }

   public void delete( )
   {
      beforeValidate055( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency055( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls055( ) ;
         afterConfirm055( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete055( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor T000518 */
               pr_default.execute(16, new Object[] {Short.valueOf(A9AttractionsId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("Attractions");
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
      sMode5 = Gx_mode ;
      Gx_mode = "DLT" ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
      endLevel055( ) ;
      Gx_mode = sMode5 ;
      httpContext.ajax_rsp_assign_attri("", false, "Gx_mode", Gx_mode);
   }

   public void onDeleteControls055( )
   {
      standaloneModal( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         AV18Pgmname = "Attractions" ;
         httpContext.ajax_rsp_assign_attri("", false, "AV18Pgmname", AV18Pgmname);
         /* Using cursor T000519 */
         pr_default.execute(17, new Object[] {Short.valueOf(A5CountryId)});
         A6CountryName = T000519_A6CountryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
         pr_default.close(17);
         /* Using cursor T000520 */
         pr_default.execute(18, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
         A16CountryCityName = T000520_A16CountryCityName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
         pr_default.close(18);
         /* Using cursor T000521 */
         pr_default.execute(19, new Object[] {Short.valueOf(A3CategoryId)});
         A4CategoryName = T000521_A4CategoryName[0] ;
         httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
         pr_default.close(19);
      }
      if ( AnyError == 0 )
      {
         /* Using cursor T000522 */
         pr_default.execute(20, new Object[] {Short.valueOf(A9AttractionsId)});
         if ( (pr_default.getStatus(20) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Attrations"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(20);
      }
   }

   public void endLevel055( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(0);
      }
      if ( AnyError == 0 )
      {
         beforeComplete055( ) ;
      }
      if ( AnyError == 0 )
      {
         Application.commitDataStores(context, remoteHandle, pr_default, "attractions");
         if ( AnyError == 0 )
         {
            confirmValues050( ) ;
         }
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
         Application.rollbackDataStores(context, remoteHandle, pr_default, "attractions");
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanStart055( )
   {
      /* Scan By routine */
      /* Using cursor T000523 */
      pr_default.execute(21);
      RcdFound5 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A9AttractionsId = T000523_A9AttractionsId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanNext055( )
   {
      /* Scan next routine */
      pr_default.readNext(21);
      RcdFound5 = (short)(0) ;
      if ( (pr_default.getStatus(21) != 101) )
      {
         RcdFound5 = (short)(1) ;
         A9AttractionsId = T000523_A9AttractionsId[0] ;
      }
   }

   public void scanEnd055( )
   {
      pr_default.close(21);
   }

   public void afterConfirm055( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert055( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate055( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete055( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete055( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate055( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes055( )
   {
      edtAttractionsName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtAttractionsName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtAttractionsName_Enabled), 5, 0), true);
      edtCountryId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryId_Enabled), 5, 0), true);
      edtCountryName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryName_Enabled), 5, 0), true);
      edtCountryCityId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryCityId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityId_Enabled), 5, 0), true);
      edtCountryCityName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCountryCityName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCountryCityName_Enabled), 5, 0), true);
      edtCategoryId_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCategoryId_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCategoryId_Enabled), 5, 0), true);
      edtCategoryName_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, edtCategoryName_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(edtCategoryName_Enabled), 5, 0), true);
      imgAttractionsPhoto_Enabled = 0 ;
      httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "Enabled", GXutil.ltrimstr( DecimalUtil.doubleToDec(imgAttractionsPhoto_Enabled), 5, 0), true);
   }

   public void send_integrity_lvl_hashes055( )
   {
   }

   public void assign_properties_default( )
   {
   }

   public void confirmValues050( )
   {
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
      httpContext.writeValue( "Attractions") ;
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
      httpContext.closeHtmlHeader();
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.disableOutput();
      }
      FormProcess = " data-HasEnter=\"true\" data-Skiponenter=\"false\"" ;
      httpContext.writeText( "<body ") ;
      bodyStyle = "" ;
      bodyStyle += "-moz-opacity:0;opacity:0;" ;
      httpContext.writeText( " "+"class=\"form-horizontal Form\""+" "+ "style='"+bodyStyle+"'") ;
      httpContext.writeText( FormProcess+">") ;
      httpContext.skipLines( 1 );
      httpContext.writeTextNL( "<form id=\"MAINFORM\" autocomplete=\"off\" name=\"MAINFORM\" method=\"post\" tabindex=-1  class=\"form-horizontal Form\" data-gx-class=\"form-horizontal Form\" novalidate action=\""+formatLink("com.kbbaru.attractions", new String[] {GXutil.URLEncode(GXutil.rtrim(Gx_mode)),GXutil.URLEncode(GXutil.ltrimstr(AV15AttractionsId,4,0))}, new String[] {"Gx_mode","AttractionsId"}) +"\">") ;
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
      forbiddenHiddens.add("hshsalt", "hsh"+"Attractions");
      forbiddenHiddens.add("Gx_mode", GXutil.rtrim( localUtil.format( Gx_mode, "@!")));
      forbiddenHiddens.add("AttractionsId", localUtil.format( DecimalUtil.doubleToDec(A9AttractionsId), "ZZZ9"));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "hsh", httpContext.getEncryptedSignature( forbiddenHiddens.toString(), GXKey));
      GXutil.writeLogInfo("attractions:[ SendSecurityCheck value for]"+forbiddenHiddens.toJSonString());
   }

   public void sendCloseFormHiddens( )
   {
      /* Send hidden variables. */
      /* Send saved values. */
      send_integrity_footer_hashes( ) ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z9AttractionsId", GXutil.ltrim( localUtil.ntoc( Z9AttractionsId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z10AttractionsName", Z10AttractionsName);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z3CategoryId", GXutil.ltrim( localUtil.ntoc( Z3CategoryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z5CountryId", GXutil.ltrim( localUtil.ntoc( Z5CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Z12CountryCityId", GXutil.ltrim( localUtil.ntoc( Z12CountryCityId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "IsConfirmed", GXutil.ltrim( localUtil.ntoc( IsConfirmed, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "IsModified", GXutil.ltrim( localUtil.ntoc( IsModified, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "Mode", GXutil.rtrim( Gx_mode));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_Mode", getSecureSignedToken( "", GXutil.rtrim( localUtil.format( Gx_mode, "@!"))));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "N5CountryId", GXutil.ltrim( localUtil.ntoc( A5CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "N12CountryCityId", GXutil.ltrim( localUtil.ntoc( A12CountryCityId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "N3CategoryId", GXutil.ltrim( localUtil.ntoc( A3CategoryId, (byte)(4), (byte)(0), ".", "")));
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
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vATTRACTIONSID", GXutil.ltrim( localUtil.ntoc( AV15AttractionsId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "gxhash_vATTRACTIONSID", getSecureSignedToken( "", localUtil.format( DecimalUtil.doubleToDec(AV15AttractionsId), "ZZZ9")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "ATTRACTIONSID", GXutil.ltrim( localUtil.ntoc( A9AttractionsId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vINSERT_COUNTRYID", GXutil.ltrim( localUtil.ntoc( AV11Insert_CountryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vINSERT_COUNTRYCITYID", GXutil.ltrim( localUtil.ntoc( AV16Insert_CountryCityId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vINSERT_CATEGORYID", GXutil.ltrim( localUtil.ntoc( AV13Insert_CategoryId, (byte)(4), (byte)(0), ".", "")));
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "ATTRACTIONSPHOTO_GXI", A40000AttractionsPhoto_GXI);
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, "vPGMNAME", GXutil.rtrim( AV18Pgmname));
      GXCCtlgxBlob = "ATTRACTIONSPHOTO" + "_gxBlob" ;
      com.kbbaru.GxWebStd.gx_hidden_field( httpContext, GXCCtlgxBlob, A11AttractionsPhoto);
   }

   public void renderHtmlCloseForm055( )
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
      httpContext.writeTextNL( "</body>") ;
      httpContext.writeTextNL( "</html>") ;
      if ( httpContext.isSpaRequest( ) )
      {
         httpContext.enableOutput();
      }
   }

   public String getPgmname( )
   {
      return "Attractions" ;
   }

   public String getPgmdesc( )
   {
      return "Attractions" ;
   }

   public void initializeNonKey055( )
   {
      A5CountryId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A5CountryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A5CountryId), 4, 0));
      A12CountryCityId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A12CountryCityId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A12CountryCityId), 4, 0));
      A3CategoryId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A3CategoryId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A3CategoryId), 4, 0));
      A10AttractionsName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A10AttractionsName", A10AttractionsName);
      A6CountryName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
      A16CountryCityName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
      A4CategoryName = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
      A11AttractionsPhoto = "" ;
      httpContext.ajax_rsp_assign_attri("", false, "A11AttractionsPhoto", A11AttractionsPhoto);
      httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
      A40000AttractionsPhoto_GXI = "" ;
      httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "Bitmap", ((GXutil.strcmp("", A11AttractionsPhoto)==0) ? A40000AttractionsPhoto_GXI : httpContext.convertURL( httpContext.getResourceRelative(A11AttractionsPhoto))), true);
      httpContext.ajax_rsp_assign_prop("", false, imgAttractionsPhoto_Internalname, "SrcSet", context.getHttpContext().getImageSrcSet( A11AttractionsPhoto), true);
      Z10AttractionsName = "" ;
      Z3CategoryId = (short)(0) ;
      Z5CountryId = (short)(0) ;
      Z12CountryCityId = (short)(0) ;
   }

   public void initAll055( )
   {
      A9AttractionsId = (short)(0) ;
      httpContext.ajax_rsp_assign_attri("", false, "A9AttractionsId", GXutil.ltrimstr( DecimalUtil.doubleToDec(A9AttractionsId), 4, 0));
      initializeNonKey055( ) ;
   }

   public void standaloneModalInsert( )
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
         httpContext.AddJavascriptSource(GXutil.rtrim( Form.getJscriptsrc().item(idxLst)), "?20235231552959", true, true);
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
      httpContext.AddJavascriptSource("attractions.js", "?20235231552959", false, true);
      /* End function include_jscripts */
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
      edtAttractionsName_Internalname = "ATTRACTIONSNAME" ;
      edtCountryId_Internalname = "COUNTRYID" ;
      edtCountryName_Internalname = "COUNTRYNAME" ;
      edtCountryCityId_Internalname = "COUNTRYCITYID" ;
      edtCountryCityName_Internalname = "COUNTRYCITYNAME" ;
      edtCategoryId_Internalname = "CATEGORYID" ;
      edtCategoryName_Internalname = "CATEGORYNAME" ;
      imgAttractionsPhoto_Internalname = "ATTRACTIONSPHOTO" ;
      divFormcontainer_Internalname = "FORMCONTAINER" ;
      bttBtn_enter_Internalname = "BTN_ENTER" ;
      bttBtn_cancel_Internalname = "BTN_CANCEL" ;
      bttBtn_delete_Internalname = "BTN_DELETE" ;
      divMaintable_Internalname = "MAINTABLE" ;
      Form.setInternalname( "FORM" );
      imgprompt_5_Internalname = "PROMPT_5" ;
      imgprompt_12_Internalname = "PROMPT_12" ;
      imgprompt_3_Internalname = "PROMPT_3" ;
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
      bttBtn_delete_Enabled = 0 ;
      bttBtn_delete_Visible = 1 ;
      bttBtn_cancel_Visible = 1 ;
      bttBtn_enter_Enabled = 1 ;
      bttBtn_enter_Visible = 1 ;
      imgAttractionsPhoto_Enabled = 1 ;
      edtCategoryName_Jsonclick = "" ;
      edtCategoryName_Enabled = 0 ;
      imgprompt_3_Visible = 1 ;
      imgprompt_3_Link = "" ;
      edtCategoryId_Jsonclick = "" ;
      edtCategoryId_Enabled = 1 ;
      edtCountryCityName_Jsonclick = "" ;
      edtCountryCityName_Enabled = 0 ;
      imgprompt_12_Visible = 1 ;
      imgprompt_12_Link = "" ;
      edtCountryCityId_Jsonclick = "" ;
      edtCountryCityId_Enabled = 1 ;
      edtCountryName_Jsonclick = "" ;
      edtCountryName_Enabled = 0 ;
      imgprompt_5_Visible = 1 ;
      imgprompt_5_Link = "" ;
      edtCountryId_Jsonclick = "" ;
      edtCountryId_Enabled = 1 ;
      edtAttractionsName_Jsonclick = "" ;
      edtAttractionsName_Enabled = 1 ;
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

   public void valid_Countryid( )
   {
      /* Using cursor T000519 */
      pr_default.execute(17, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(17) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'Country'.", "ForeignKeyNotFound", 1, "COUNTRYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
      }
      A6CountryName = T000519_A6CountryName[0] ;
      pr_default.close(17);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A6CountryName", A6CountryName);
   }

   public void valid_Countrycityid( )
   {
      /* Using cursor T000520 */
      pr_default.execute(18, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
      if ( (pr_default.getStatus(18) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'City'.", "ForeignKeyNotFound", 1, "COUNTRYCITYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCountryId_Internalname ;
      }
      A16CountryCityName = T000520_A16CountryCityName[0] ;
      pr_default.close(18);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A16CountryCityName", A16CountryCityName);
   }

   public void valid_Categoryid( )
   {
      /* Using cursor T000521 */
      pr_default.execute(19, new Object[] {Short.valueOf(A3CategoryId)});
      if ( (pr_default.getStatus(19) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'Category'.", "ForeignKeyNotFound", 1, "CATEGORYID");
         AnyError = (short)(1) ;
         GX_FocusControl = edtCategoryId_Internalname ;
      }
      A4CategoryName = T000521_A4CategoryName[0] ;
      pr_default.close(19);
      dynload_actions( ) ;
      /*  Sending validation outputs */
      httpContext.ajax_rsp_assign_attri("", false, "A4CategoryName", A4CategoryName);
   }

   public boolean supportAjaxEvent( )
   {
      return true ;
   }

   public void initializeDynEvents( )
   {
      setEventMetadata("ENTER","{handler:'userMainFullajax',iparms:[{postForm:true},{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV15AttractionsId',fld:'vATTRACTIONSID',pic:'ZZZ9',hsh:true}]");
      setEventMetadata("ENTER",",oparms:[]}");
      setEventMetadata("REFRESH","{handler:'refresh',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true},{av:'AV15AttractionsId',fld:'vATTRACTIONSID',pic:'ZZZ9',hsh:true},{av:'A9AttractionsId',fld:'ATTRACTIONSID',pic:'ZZZ9'}]");
      setEventMetadata("REFRESH",",oparms:[]}");
      setEventMetadata("AFTER TRN","{handler:'e12052',iparms:[{av:'Gx_mode',fld:'vMODE',pic:'@!',hsh:true},{av:'AV9TrnContext',fld:'vTRNCONTEXT',pic:'',hsh:true}]");
      setEventMetadata("AFTER TRN",",oparms:[]}");
      setEventMetadata("VALID_COUNTRYID","{handler:'valid_Countryid',iparms:[{av:'A5CountryId',fld:'COUNTRYID',pic:'ZZZ9'},{av:'A6CountryName',fld:'COUNTRYNAME',pic:''}]");
      setEventMetadata("VALID_COUNTRYID",",oparms:[{av:'A6CountryName',fld:'COUNTRYNAME',pic:''}]}");
      setEventMetadata("VALID_COUNTRYCITYID","{handler:'valid_Countrycityid',iparms:[{av:'A5CountryId',fld:'COUNTRYID',pic:'ZZZ9'},{av:'A12CountryCityId',fld:'COUNTRYCITYID',pic:'ZZZ9'},{av:'A16CountryCityName',fld:'COUNTRYCITYNAME',pic:''}]");
      setEventMetadata("VALID_COUNTRYCITYID",",oparms:[{av:'A16CountryCityName',fld:'COUNTRYCITYNAME',pic:''}]}");
      setEventMetadata("VALID_CATEGORYID","{handler:'valid_Categoryid',iparms:[{av:'A3CategoryId',fld:'CATEGORYID',pic:'ZZZ9'},{av:'A4CategoryName',fld:'CATEGORYNAME',pic:''}]");
      setEventMetadata("VALID_CATEGORYID",",oparms:[{av:'A4CategoryName',fld:'CATEGORYNAME',pic:''}]}");
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
      pr_default.close(19);
      pr_default.close(17);
      pr_default.close(18);
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      sPrefix = "" ;
      wcpOGx_mode = "" ;
      Z10AttractionsName = "" ;
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
      A10AttractionsName = "" ;
      imgprompt_5_gximage = "" ;
      sImgUrl = "" ;
      A6CountryName = "" ;
      imgprompt_12_gximage = "" ;
      A16CountryCityName = "" ;
      imgprompt_3_gximage = "" ;
      A4CategoryName = "" ;
      A11AttractionsPhoto = "" ;
      A40000AttractionsPhoto_GXI = "" ;
      bttBtn_enter_Jsonclick = "" ;
      bttBtn_cancel_Jsonclick = "" ;
      bttBtn_delete_Jsonclick = "" ;
      AV18Pgmname = "" ;
      GXv_char1 = new String[1] ;
      GXv_char2 = new String[1] ;
      forbiddenHiddens = new com.genexus.util.GXProperties();
      hsh = "" ;
      sMode5 = "" ;
      sEvt = "" ;
      EvtGridId = "" ;
      EvtRowId = "" ;
      sEvtType = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      AV9TrnContext = new com.kbbaru.general.ui.SdtTransactionContext(remoteHandle, context);
      AV10WebSession = httpContext.getWebSession();
      AV14TrnContextAtt = new com.kbbaru.general.ui.SdtTransactionContext_Attribute(remoteHandle, context);
      Z11AttractionsPhoto = "" ;
      Z40000AttractionsPhoto_GXI = "" ;
      Z6CountryName = "" ;
      Z16CountryCityName = "" ;
      Z4CategoryName = "" ;
      T00054_A4CategoryName = new String[] {""} ;
      T00055_A6CountryName = new String[] {""} ;
      T00056_A16CountryCityName = new String[] {""} ;
      T00057_A9AttractionsId = new short[1] ;
      T00057_A10AttractionsName = new String[] {""} ;
      T00057_A6CountryName = new String[] {""} ;
      T00057_A16CountryCityName = new String[] {""} ;
      T00057_A4CategoryName = new String[] {""} ;
      T00057_A11AttractionsPhoto = new String[] {""} ;
      T00057_A40000AttractionsPhoto_GXI = new String[] {""} ;
      T00057_A3CategoryId = new short[1] ;
      T00057_A5CountryId = new short[1] ;
      T00057_A12CountryCityId = new short[1] ;
      T00058_A6CountryName = new String[] {""} ;
      T00059_A16CountryCityName = new String[] {""} ;
      T000510_A4CategoryName = new String[] {""} ;
      T000511_A9AttractionsId = new short[1] ;
      T00053_A9AttractionsId = new short[1] ;
      T00053_A10AttractionsName = new String[] {""} ;
      T00053_A11AttractionsPhoto = new String[] {""} ;
      T00053_A40000AttractionsPhoto_GXI = new String[] {""} ;
      T00053_A3CategoryId = new short[1] ;
      T00053_A5CountryId = new short[1] ;
      T00053_A12CountryCityId = new short[1] ;
      T000512_A9AttractionsId = new short[1] ;
      T000513_A9AttractionsId = new short[1] ;
      T00052_A9AttractionsId = new short[1] ;
      T00052_A10AttractionsName = new String[] {""} ;
      T00052_A11AttractionsPhoto = new String[] {""} ;
      T00052_A40000AttractionsPhoto_GXI = new String[] {""} ;
      T00052_A3CategoryId = new short[1] ;
      T00052_A5CountryId = new short[1] ;
      T00052_A12CountryCityId = new short[1] ;
      T000515_A9AttractionsId = new short[1] ;
      T000519_A6CountryName = new String[] {""} ;
      T000520_A16CountryCityName = new String[] {""} ;
      T000521_A4CategoryName = new String[] {""} ;
      T000522_A25TripsId = new short[1] ;
      T000522_A9AttractionsId = new short[1] ;
      T000523_A9AttractionsId = new short[1] ;
      sDynURL = "" ;
      FormProcess = "" ;
      bodyStyle = "" ;
      GXCCtlgxBlob = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.attractions__default(),
         new Object[] {
             new Object[] {
            T00052_A9AttractionsId, T00052_A10AttractionsName, T00052_A11AttractionsPhoto, T00052_A40000AttractionsPhoto_GXI, T00052_A3CategoryId, T00052_A5CountryId, T00052_A12CountryCityId
            }
            , new Object[] {
            T00053_A9AttractionsId, T00053_A10AttractionsName, T00053_A11AttractionsPhoto, T00053_A40000AttractionsPhoto_GXI, T00053_A3CategoryId, T00053_A5CountryId, T00053_A12CountryCityId
            }
            , new Object[] {
            T00054_A4CategoryName
            }
            , new Object[] {
            T00055_A6CountryName
            }
            , new Object[] {
            T00056_A16CountryCityName
            }
            , new Object[] {
            T00057_A9AttractionsId, T00057_A10AttractionsName, T00057_A6CountryName, T00057_A16CountryCityName, T00057_A4CategoryName, T00057_A11AttractionsPhoto, T00057_A40000AttractionsPhoto_GXI, T00057_A3CategoryId, T00057_A5CountryId, T00057_A12CountryCityId
            }
            , new Object[] {
            T00058_A6CountryName
            }
            , new Object[] {
            T00059_A16CountryCityName
            }
            , new Object[] {
            T000510_A4CategoryName
            }
            , new Object[] {
            T000511_A9AttractionsId
            }
            , new Object[] {
            T000512_A9AttractionsId
            }
            , new Object[] {
            T000513_A9AttractionsId
            }
            , new Object[] {
            }
            , new Object[] {
            T000515_A9AttractionsId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            T000519_A6CountryName
            }
            , new Object[] {
            T000520_A16CountryCityName
            }
            , new Object[] {
            T000521_A4CategoryName
            }
            , new Object[] {
            T000522_A25TripsId, T000522_A9AttractionsId
            }
            , new Object[] {
            T000523_A9AttractionsId
            }
         }
      );
      AV18Pgmname = "Attractions" ;
   }

   private byte GxWebError ;
   private byte nKeyPressed ;
   private byte nDynComponent ;
   private byte Gx_BScreen ;
   private short wcpOAV15AttractionsId ;
   private short Z9AttractionsId ;
   private short Z3CategoryId ;
   private short Z5CountryId ;
   private short Z12CountryCityId ;
   private short N5CountryId ;
   private short N12CountryCityId ;
   private short N3CategoryId ;
   private short A5CountryId ;
   private short A12CountryCityId ;
   private short A3CategoryId ;
   private short AV15AttractionsId ;
   private short gxcookieaux ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short A9AttractionsId ;
   private short AV11Insert_CountryId ;
   private short AV16Insert_CountryCityId ;
   private short AV13Insert_CategoryId ;
   private short RcdFound5 ;
   private short nIsDirty_5 ;
   private int trnEnded ;
   private int bttBtn_first_Visible ;
   private int bttBtn_previous_Visible ;
   private int bttBtn_next_Visible ;
   private int bttBtn_last_Visible ;
   private int bttBtn_select_Visible ;
   private int edtAttractionsName_Enabled ;
   private int edtCountryId_Enabled ;
   private int imgprompt_5_Visible ;
   private int edtCountryName_Enabled ;
   private int edtCountryCityId_Enabled ;
   private int imgprompt_12_Visible ;
   private int edtCountryCityName_Enabled ;
   private int edtCategoryId_Enabled ;
   private int imgprompt_3_Visible ;
   private int edtCategoryName_Enabled ;
   private int imgAttractionsPhoto_Enabled ;
   private int bttBtn_enter_Visible ;
   private int bttBtn_enter_Enabled ;
   private int bttBtn_cancel_Visible ;
   private int bttBtn_delete_Visible ;
   private int bttBtn_delete_Enabled ;
   private int AV19GXV1 ;
   private int GX_JID ;
   private int idxLst ;
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
   private String edtAttractionsName_Internalname ;
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
   private String edtAttractionsName_Jsonclick ;
   private String edtCountryId_Internalname ;
   private String edtCountryId_Jsonclick ;
   private String imgprompt_5_gximage ;
   private String sImgUrl ;
   private String imgprompt_5_Internalname ;
   private String imgprompt_5_Link ;
   private String edtCountryName_Internalname ;
   private String edtCountryName_Jsonclick ;
   private String edtCountryCityId_Internalname ;
   private String edtCountryCityId_Jsonclick ;
   private String imgprompt_12_gximage ;
   private String imgprompt_12_Internalname ;
   private String imgprompt_12_Link ;
   private String edtCountryCityName_Internalname ;
   private String edtCountryCityName_Jsonclick ;
   private String edtCategoryId_Internalname ;
   private String edtCategoryId_Jsonclick ;
   private String imgprompt_3_gximage ;
   private String imgprompt_3_Internalname ;
   private String imgprompt_3_Link ;
   private String edtCategoryName_Internalname ;
   private String edtCategoryName_Jsonclick ;
   private String imgAttractionsPhoto_Internalname ;
   private String bttBtn_enter_Internalname ;
   private String bttBtn_enter_Jsonclick ;
   private String bttBtn_cancel_Internalname ;
   private String bttBtn_cancel_Jsonclick ;
   private String bttBtn_delete_Internalname ;
   private String bttBtn_delete_Jsonclick ;
   private String AV18Pgmname ;
   private String GXv_char1[] ;
   private String GXv_char2[] ;
   private String hsh ;
   private String sMode5 ;
   private String sEvt ;
   private String EvtGridId ;
   private String EvtRowId ;
   private String sEvtType ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sDynURL ;
   private String FormProcess ;
   private String bodyStyle ;
   private String GXCCtlgxBlob ;
   private boolean entryPointCalled ;
   private boolean toggleJsOutput ;
   private boolean wbErr ;
   private boolean A11AttractionsPhoto_IsBlob ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String Z10AttractionsName ;
   private String A10AttractionsName ;
   private String A6CountryName ;
   private String A16CountryCityName ;
   private String A4CategoryName ;
   private String A40000AttractionsPhoto_GXI ;
   private String Z40000AttractionsPhoto_GXI ;
   private String Z6CountryName ;
   private String Z16CountryCityName ;
   private String Z4CategoryName ;
   private String A11AttractionsPhoto ;
   private String Z11AttractionsPhoto ;
   private com.genexus.webpanels.GXWebForm Form ;
   private com.genexus.webpanels.WebSession AV10WebSession ;
   private com.genexus.util.GXProperties forbiddenHiddens ;
   private IDataStoreProvider pr_default ;
   private String[] T00054_A4CategoryName ;
   private String[] T00055_A6CountryName ;
   private String[] T00056_A16CountryCityName ;
   private short[] T00057_A9AttractionsId ;
   private String[] T00057_A10AttractionsName ;
   private String[] T00057_A6CountryName ;
   private String[] T00057_A16CountryCityName ;
   private String[] T00057_A4CategoryName ;
   private String[] T00057_A11AttractionsPhoto ;
   private String[] T00057_A40000AttractionsPhoto_GXI ;
   private short[] T00057_A3CategoryId ;
   private short[] T00057_A5CountryId ;
   private short[] T00057_A12CountryCityId ;
   private String[] T00058_A6CountryName ;
   private String[] T00059_A16CountryCityName ;
   private String[] T000510_A4CategoryName ;
   private short[] T000511_A9AttractionsId ;
   private short[] T00053_A9AttractionsId ;
   private String[] T00053_A10AttractionsName ;
   private String[] T00053_A11AttractionsPhoto ;
   private String[] T00053_A40000AttractionsPhoto_GXI ;
   private short[] T00053_A3CategoryId ;
   private short[] T00053_A5CountryId ;
   private short[] T00053_A12CountryCityId ;
   private short[] T000512_A9AttractionsId ;
   private short[] T000513_A9AttractionsId ;
   private short[] T00052_A9AttractionsId ;
   private String[] T00052_A10AttractionsName ;
   private String[] T00052_A11AttractionsPhoto ;
   private String[] T00052_A40000AttractionsPhoto_GXI ;
   private short[] T00052_A3CategoryId ;
   private short[] T00052_A5CountryId ;
   private short[] T00052_A12CountryCityId ;
   private short[] T000515_A9AttractionsId ;
   private String[] T000519_A6CountryName ;
   private String[] T000520_A16CountryCityName ;
   private String[] T000521_A4CategoryName ;
   private short[] T000522_A25TripsId ;
   private short[] T000522_A9AttractionsId ;
   private short[] T000523_A9AttractionsId ;
   private com.kbbaru.general.ui.SdtTransactionContext AV9TrnContext ;
   private com.kbbaru.general.ui.SdtTransactionContext_Attribute AV14TrnContextAtt ;
}

final  class attractions__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("T00052", "SELECT AttractionsId, AttractionsName, AttractionsPhoto, AttractionsPhoto_GXI, CategoryId, CountryId, CountryCityId FROM Attractions WHERE AttractionsId = ?  FOR UPDATE OF Attractions NOWAIT",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00053", "SELECT AttractionsId, AttractionsName, AttractionsPhoto, AttractionsPhoto_GXI, CategoryId, CountryId, CountryCityId FROM Attractions WHERE AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00054", "SELECT CategoryName FROM Category WHERE CategoryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00055", "SELECT CountryName FROM Country WHERE CountryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00056", "SELECT CountryCityName FROM CountryCity WHERE CountryId = ? AND CountryCityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00057", "SELECT TM1.AttractionsId, TM1.AttractionsName, T2.CountryName, T3.CountryCityName, T4.CategoryName, TM1.AttractionsPhoto, TM1.AttractionsPhoto_GXI, TM1.CategoryId, TM1.CountryId, TM1.CountryCityId FROM (((Attractions TM1 INNER JOIN Country T2 ON T2.CountryId = TM1.CountryId) INNER JOIN CountryCity T3 ON T3.CountryId = TM1.CountryId AND T3.CountryCityId = TM1.CountryCityId) INNER JOIN Category T4 ON T4.CategoryId = TM1.CategoryId) WHERE TM1.AttractionsId = ? ORDER BY TM1.AttractionsId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00058", "SELECT CountryName FROM Country WHERE CountryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T00059", "SELECT CountryCityName FROM CountryCity WHERE CountryId = ? AND CountryCityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000510", "SELECT CategoryName FROM Category WHERE CategoryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000511", "SELECT AttractionsId FROM Attractions WHERE AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000512", "SELECT AttractionsId FROM Attractions WHERE ( AttractionsId > ?) ORDER BY AttractionsId  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000513", "SELECT AttractionsId FROM Attractions WHERE ( AttractionsId < ?) ORDER BY AttractionsId DESC  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("T000514", "SAVEPOINT gxupdate;INSERT INTO Attractions(AttractionsName, AttractionsPhoto, AttractionsPhoto_GXI, CategoryId, CountryId, CountryCityId) VALUES(?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000515", "SELECT currval('AttractionsId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("T000516", "SAVEPOINT gxupdate;UPDATE Attractions SET AttractionsName=?, CategoryId=?, CountryId=?, CountryCityId=?  WHERE AttractionsId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000517", "SAVEPOINT gxupdate;UPDATE Attractions SET AttractionsPhoto=?, AttractionsPhoto_GXI=?  WHERE AttractionsId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("T000518", "SAVEPOINT gxupdate;DELETE FROM Attractions  WHERE AttractionsId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("T000519", "SELECT CountryName FROM Country WHERE CountryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000520", "SELECT CountryCityName FROM CountryCity WHERE CountryId = ? AND CountryCityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000521", "SELECT CategoryName FROM Category WHERE CategoryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("T000522", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE AttractionsId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("T000523", "SELECT AttractionsId FROM Attractions ORDER BY AttractionsId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(4));
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getMultimediaFile(3, rslt.getVarchar(4));
               ((String[]) buf[3])[0] = rslt.getMultimediaUri(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((String[]) buf[3])[0] = rslt.getVarchar(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
               ((String[]) buf[5])[0] = rslt.getMultimediaFile(6, rslt.getVarchar(7));
               ((String[]) buf[6])[0] = rslt.getMultimediaUri(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((short[]) buf[8])[0] = rslt.getShort(9);
               ((short[]) buf[9])[0] = rslt.getShort(10);
               return;
            case 6 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 7 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 8 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 11 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 17 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 18 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 19 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 20 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
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
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 3 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 4 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 5 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 6 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 7 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 8 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 10 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 11 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 12 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setBLOBFile(2, (String)parms[1], true);
               stmt.setGXDbFileURI(3, (String)parms[2], (String)parms[1], 2048,"Attractions","AttractionsPhoto");
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               return;
            case 14 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setShort(4, ((Number) parms[3]).shortValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               return;
            case 15 :
               stmt.setBLOBFile(1, (String)parms[0], true);
               stmt.setGXDbFileURI(2, (String)parms[1], (String)parms[0], 2048,"Attractions","AttractionsPhoto");
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 16 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

