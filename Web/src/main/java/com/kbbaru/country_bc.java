package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class country_bc extends GXWebPanel implements IGxSilentTrn
{
   public country_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public country_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( country_bc.class ));
   }

   public country_bc( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow033( ) ;
      standaloneNotModal( ) ;
      initializeNonKey033( ) ;
      standaloneModal( ) ;
      addRow033( ) ;
      Gx_mode = "INS" ;
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
         e11032 ();
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z5CountryId = A5CountryId ;
            SetMode( "UPD") ;
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

   public boolean Reindex( )
   {
      return true ;
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
            if ( AnyError == 0 )
            {
            }
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
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode3 ;
      }
   }

   public void confirm_0310( )
   {
      nGXsfl_10_idx = 0 ;
      while ( nGXsfl_10_idx < bcCountry.getgxTv_SdtCountry_City().size() )
      {
         readRow0310( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound10 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_10 != 0 ) )
         {
            getKey0310( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound10 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0310( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0310( ) ;
                     if ( AnyError == 0 )
                     {
                     }
                     closeExtendedTableCursors0310( ) ;
                     if ( AnyError == 0 )
                     {
                        IsConfirmed = (short)(1) ;
                     }
                  }
               }
               else
               {
                  httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
                  AnyError = (short)(1) ;
               }
            }
            else
            {
               if ( RcdFound10 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
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
                        beforeValidate0310( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0310( ) ;
                           if ( AnyError == 0 )
                           {
                           }
                           closeExtendedTableCursors0310( ) ;
                           if ( AnyError == 0 )
                           {
                              IsConfirmed = (short)(1) ;
                           }
                        }
                     }
                  }
               }
               else
               {
                  if ( ! isDlt( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
                     AnyError = (short)(1) ;
                  }
               }
            }
            VarsToRow10( ((com.kbbaru.SdtCountry_City)bcCountry.getgxTv_SdtCountry_City().elementAt(-1+nGXsfl_10_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void e12032( )
   {
      /* Start Routine */
      returnInSub = false ;
   }

   public void e11032( )
   {
      /* After Trn Routine */
      returnInSub = false ;
   }

   public void zm033( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         Z6CountryName = A6CountryName ;
      }
      if ( GX_JID == -1 )
      {
         Z5CountryId = A5CountryId ;
         Z6CountryName = A6CountryName ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load033( )
   {
      /* Using cursor BC00036 */
      pr_default.execute(4, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(4) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A6CountryName = BC00036_A6CountryName[0] ;
         zm033( -1) ;
      }
      pr_default.close(4);
      onLoadActions033( ) ;
   }

   public void onLoadActions033( )
   {
   }

   public void checkExtendedTable033( )
   {
      nIsDirty_3 = (short)(0) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors033( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey033( )
   {
      /* Using cursor BC00037 */
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
      /* Using cursor BC00038 */
      pr_default.execute(6, new Object[] {Short.valueOf(A5CountryId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         zm033( 1) ;
         RcdFound3 = (short)(1) ;
         A5CountryId = BC00038_A5CountryId[0] ;
         A6CountryName = BC00038_A6CountryName[0] ;
         Z5CountryId = A5CountryId ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load033( ) ;
         if ( AnyError == 1 )
         {
            RcdFound3 = (short)(0) ;
            initializeNonKey033( ) ;
         }
         Gx_mode = sMode3 ;
      }
      else
      {
         RcdFound3 = (short)(0) ;
         initializeNonKey033( ) ;
         sMode3 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode3 ;
      }
      pr_default.close(6);
   }

   public void getEqualNoModal( )
   {
      getKey033( ) ;
      if ( RcdFound3 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
      }
      getByPrimaryKey( ) ;
   }

   public void insert_check( )
   {
      confirm_030( ) ;
      IsConfirmed = (short)(0) ;
   }

   public void update_check( )
   {
      insert_check( ) ;
   }

   public void delete_check( )
   {
      insert_check( ) ;
   }

   public void checkOptimisticConcurrency033( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC00039 */
         pr_default.execute(7, new Object[] {Short.valueOf(A5CountryId)});
         if ( (pr_default.getStatus(7) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Country"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(7) == 101) || ( GXutil.strcmp(Z6CountryName, BC00039_A6CountryName[0]) != 0 ) )
         {
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
                  /* Using cursor BC000310 */
                  pr_default.execute(8, new Object[] {A6CountryName});
                  /* Retrieving last key number assigned */
                  /* Using cursor BC000311 */
                  pr_default.execute(9);
                  A5CountryId = BC000311_A5CountryId[0] ;
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
                  /* Using cursor BC000312 */
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
                           getByPrimaryKey( ) ;
                           endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucupdated") ;
                           endTrnMsgCod = "SuccessfullyUpdated" ;
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
      Gx_mode = "DLT" ;
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
               scanKeyStart0310( ) ;
               while ( RcdFound10 != 0 )
               {
                  getByPrimaryKey0310( ) ;
                  delete0310( ) ;
                  scanKeyNext0310( ) ;
               }
               scanKeyEnd0310( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000313 */
                  pr_default.execute(11, new Object[] {Short.valueOf(A5CountryId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Country");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( delete) rules */
                     /* End of After( delete) rules */
                     if ( AnyError == 0 )
                     {
                        endTrnMsgTxt = localUtil.getMessages().getMessage("GXM_sucdeleted") ;
                        endTrnMsgCod = "SuccessfullyDeleted" ;
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
      endLevel033( ) ;
      Gx_mode = sMode3 ;
   }

   public void onDeleteControls033( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor BC000314 */
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
      nGXsfl_10_idx = 0 ;
      while ( nGXsfl_10_idx < bcCountry.getgxTv_SdtCountry_City().size() )
      {
         readRow0310( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound10 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_10 != 0 ) )
         {
            standaloneNotModal0310( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0310( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0310( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0310( ) ;
               }
            }
         }
         KeyVarsToRow10( ((com.kbbaru.SdtCountry_City)bcCountry.getgxTv_SdtCountry_City().elementAt(-1+nGXsfl_10_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_10_idx = 0 ;
         while ( nGXsfl_10_idx < bcCountry.getgxTv_SdtCountry_City().size() )
         {
            readRow0310( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound10 == 0 )
               {
                  Gx_mode = "INS" ;
               }
               else
               {
                  Gx_mode = "UPD" ;
               }
            }
            /* Update SDT row */
            if ( isDlt( ) )
            {
               bcCountry.getgxTv_SdtCountry_City().removeElement(nGXsfl_10_idx);
               nGXsfl_10_idx = (int)(nGXsfl_10_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0310( ) ;
               VarsToRow10( ((com.kbbaru.SdtCountry_City)bcCountry.getgxTv_SdtCountry_City().elementAt(-1+nGXsfl_10_idx))) ;
            }
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
      Gxremove10 = (byte)(0) ;
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
      /* ' Update level parameters */
   }

   public void endLevel033( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(7);
      }
      if ( AnyError == 0 )
      {
         beforeComplete033( ) ;
      }
      if ( AnyError == 0 )
      {
         /* After transaction rules */
         /* Execute 'After Trn' event if defined. */
         trnEnded = 1 ;
      }
      else
      {
      }
      IsModified = (short)(0) ;
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart033( )
   {
      /* Scan By routine */
      /* Using cursor BC000315 */
      pr_default.execute(13, new Object[] {Short.valueOf(A5CountryId)});
      RcdFound3 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A5CountryId = BC000315_A5CountryId[0] ;
         A6CountryName = BC000315_A6CountryName[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext033( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound3 = (short)(0) ;
      scanKeyLoad033( ) ;
   }

   public void scanKeyLoad033( )
   {
      sMode3 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound3 = (short)(1) ;
         A5CountryId = BC000315_A5CountryId[0] ;
         A6CountryName = BC000315_A6CountryName[0] ;
      }
      Gx_mode = sMode3 ;
   }

   public void scanKeyEnd033( )
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
   }

   public void zm0310( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
         Z16CountryCityName = A16CountryCityName ;
      }
      if ( GX_JID == -2 )
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
   }

   public void load0310( )
   {
      /* Using cursor BC000316 */
      pr_default.execute(14, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A16CountryCityName = BC000316_A16CountryCityName[0] ;
         zm0310( -2) ;
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
      Gx_BScreen = (byte)(0) ;
   }

   public void closeExtendedTableCursors0310( )
   {
   }

   public void enableDisable0310( )
   {
   }

   public void getKey0310( )
   {
      /* Using cursor BC000317 */
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
      /* Using cursor BC000318 */
      pr_default.execute(16, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         zm0310( 2) ;
         RcdFound10 = (short)(1) ;
         initializeNonKey0310( ) ;
         A12CountryCityId = BC000318_A12CountryCityId[0] ;
         A16CountryCityName = BC000318_A16CountryCityName[0] ;
         Z5CountryId = A5CountryId ;
         Z12CountryCityId = A12CountryCityId ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0310( ) ;
         load0310( ) ;
         Gx_mode = sMode10 ;
      }
      else
      {
         RcdFound10 = (short)(0) ;
         initializeNonKey0310( ) ;
         sMode10 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0310( ) ;
         Gx_mode = sMode10 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0310( ) ;
      }
      pr_default.close(16);
   }

   public void checkOptimisticConcurrency0310( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000319 */
         pr_default.execute(17, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
         if ( (pr_default.getStatus(17) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"CountryCity"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(17) == 101) || ( GXutil.strcmp(Z16CountryCityName, BC000319_A16CountryCityName[0]) != 0 ) )
         {
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
                  /* Using cursor BC000320 */
                  pr_default.execute(18, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId), A16CountryCityName});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CountryCity");
                  if ( (pr_default.getStatus(18) == 1) )
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
                  /* Using cursor BC000321 */
                  pr_default.execute(19, new Object[] {A16CountryCityName, Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("CountryCity");
                  if ( (pr_default.getStatus(19) == 103) )
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
      closeExtendedTableCursors0310( ) ;
   }

   public void deferredUpdate0310( )
   {
   }

   public void delete0310( )
   {
      Gx_mode = "DLT" ;
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
               /* Using cursor BC000322 */
               pr_default.execute(20, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
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
      endLevel0310( ) ;
      Gx_mode = sMode10 ;
   }

   public void onDeleteControls0310( )
   {
      standaloneModal0310( ) ;
      /* No delete mode formulas found. */
      if ( AnyError == 0 )
      {
         /* Using cursor BC000323 */
         pr_default.execute(21, new Object[] {Short.valueOf(A5CountryId), Short.valueOf(A12CountryCityId)});
         if ( (pr_default.getStatus(21) != 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_del", new Object[] {"Attractions"}), "CannotDeleteReferencedRecord", 1, "");
            AnyError = (short)(1) ;
         }
         pr_default.close(21);
      }
   }

   public void endLevel0310( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(17);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0310( )
   {
      /* Scan By routine */
      /* Using cursor BC000324 */
      pr_default.execute(22, new Object[] {Short.valueOf(A5CountryId)});
      RcdFound10 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A12CountryCityId = BC000324_A12CountryCityId[0] ;
         A16CountryCityName = BC000324_A16CountryCityName[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0310( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound10 = (short)(0) ;
      scanKeyLoad0310( ) ;
   }

   public void scanKeyLoad0310( )
   {
      sMode10 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound10 = (short)(1) ;
         A12CountryCityId = BC000324_A12CountryCityId[0] ;
         A16CountryCityName = BC000324_A16CountryCityName[0] ;
      }
      Gx_mode = sMode10 ;
   }

   public void scanKeyEnd0310( )
   {
      pr_default.close(22);
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
   }

   public void send_integrity_lvl_hashes0310( )
   {
   }

   public void send_integrity_lvl_hashes033( )
   {
   }

   public void addRow033( )
   {
      VarsToRow3( bcCountry) ;
   }

   public void readRow033( )
   {
      RowToVars3( bcCountry, 1) ;
   }

   public void addRow0310( )
   {
      com.kbbaru.SdtCountry_City obj10;
      obj10 = new com.kbbaru.SdtCountry_City(remoteHandle);
      VarsToRow10( obj10) ;
      bcCountry.getgxTv_SdtCountry_City().add(obj10, 0);
      obj10.setgxTv_SdtCountry_City_Mode( "UPD" );
      obj10.setgxTv_SdtCountry_City_Modified( (short)(0) );
   }

   public void readRow0310( )
   {
      nGXsfl_10_idx = (int)(nGXsfl_10_idx+1) ;
      RowToVars10( ((com.kbbaru.SdtCountry_City)bcCountry.getgxTv_SdtCountry_City().elementAt(-1+nGXsfl_10_idx)), 1) ;
   }

   public void initializeNonKey033( )
   {
      A6CountryName = "" ;
      Z6CountryName = "" ;
   }

   public void initAll033( )
   {
      A5CountryId = (short)(0) ;
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

   public void VarsToRow3( com.kbbaru.SdtCountry obj3 )
   {
      obj3.setgxTv_SdtCountry_Mode( Gx_mode );
      obj3.setgxTv_SdtCountry_Countryname( A6CountryName );
      obj3.setgxTv_SdtCountry_Countryid( A5CountryId );
      obj3.setgxTv_SdtCountry_Countryid_Z( Z5CountryId );
      obj3.setgxTv_SdtCountry_Countryname_Z( Z6CountryName );
      obj3.setgxTv_SdtCountry_Mode( Gx_mode );
   }

   public void KeyVarsToRow3( com.kbbaru.SdtCountry obj3 )
   {
      obj3.setgxTv_SdtCountry_Countryid( A5CountryId );
   }

   public void RowToVars3( com.kbbaru.SdtCountry obj3 ,
                           int forceLoad )
   {
      Gx_mode = obj3.getgxTv_SdtCountry_Mode() ;
      A6CountryName = obj3.getgxTv_SdtCountry_Countryname() ;
      A5CountryId = obj3.getgxTv_SdtCountry_Countryid() ;
      Z5CountryId = obj3.getgxTv_SdtCountry_Countryid_Z() ;
      Z6CountryName = obj3.getgxTv_SdtCountry_Countryname_Z() ;
      Gx_mode = obj3.getgxTv_SdtCountry_Mode() ;
   }

   public void VarsToRow10( com.kbbaru.SdtCountry_City obj10 )
   {
      obj10.setgxTv_SdtCountry_City_Mode( Gx_mode );
      obj10.setgxTv_SdtCountry_City_Countrycityname( A16CountryCityName );
      obj10.setgxTv_SdtCountry_City_Countrycityid( A12CountryCityId );
      obj10.setgxTv_SdtCountry_City_Countrycityid_Z( Z12CountryCityId );
      obj10.setgxTv_SdtCountry_City_Countrycityname_Z( Z16CountryCityName );
      obj10.setgxTv_SdtCountry_City_Modified( nIsMod_10 );
   }

   public void KeyVarsToRow10( com.kbbaru.SdtCountry_City obj10 )
   {
      obj10.setgxTv_SdtCountry_City_Countrycityid( A12CountryCityId );
   }

   public void RowToVars10( com.kbbaru.SdtCountry_City obj10 ,
                            int forceLoad )
   {
      Gx_mode = obj10.getgxTv_SdtCountry_City_Mode() ;
      A16CountryCityName = obj10.getgxTv_SdtCountry_City_Countrycityname() ;
      A12CountryCityId = obj10.getgxTv_SdtCountry_City_Countrycityid() ;
      Z12CountryCityId = obj10.getgxTv_SdtCountry_City_Countrycityid_Z() ;
      Z16CountryCityName = obj10.getgxTv_SdtCountry_City_Countrycityname_Z() ;
      nIsMod_10 = obj10.getgxTv_SdtCountry_City_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A5CountryId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey033( ) ;
      scanKeyStart033( ) ;
      if ( RcdFound3 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z5CountryId = A5CountryId ;
      }
      zm033( -1) ;
      onLoadActions033( ) ;
      addRow033( ) ;
      bcCountry.getgxTv_SdtCountry_City().clearCollection();
      if ( RcdFound3 == 1 )
      {
         scanKeyStart0310( ) ;
         nGXsfl_10_idx = 1 ;
         while ( RcdFound10 != 0 )
         {
            Z5CountryId = A5CountryId ;
            Z12CountryCityId = A12CountryCityId ;
            zm0310( -2) ;
            onLoadActions0310( ) ;
            nRcdExists_10 = (short)(1) ;
            nIsMod_10 = (short)(0) ;
            addRow0310( ) ;
            nGXsfl_10_idx = (int)(nGXsfl_10_idx+1) ;
            scanKeyNext0310( ) ;
         }
         scanKeyEnd0310( ) ;
      }
      scanKeyEnd033( ) ;
      if ( RcdFound3 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void Load( )
   {
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      RowToVars3( bcCountry, 0) ;
      scanKeyStart033( ) ;
      if ( RcdFound3 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z5CountryId = A5CountryId ;
      }
      zm033( -1) ;
      onLoadActions033( ) ;
      addRow033( ) ;
      bcCountry.getgxTv_SdtCountry_City().clearCollection();
      if ( RcdFound3 == 1 )
      {
         scanKeyStart0310( ) ;
         nGXsfl_10_idx = 1 ;
         while ( RcdFound10 != 0 )
         {
            Z5CountryId = A5CountryId ;
            Z12CountryCityId = A12CountryCityId ;
            zm0310( -2) ;
            onLoadActions0310( ) ;
            nRcdExists_10 = (short)(1) ;
            nIsMod_10 = (short)(0) ;
            addRow0310( ) ;
            nGXsfl_10_idx = (int)(nGXsfl_10_idx+1) ;
            scanKeyNext0310( ) ;
         }
         scanKeyEnd0310( ) ;
      }
      scanKeyEnd033( ) ;
      if ( RcdFound3 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey033( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert033( ) ;
      }
      else
      {
         if ( RcdFound3 == 1 )
         {
            if ( A5CountryId != Z5CountryId )
            {
               A5CountryId = Z5CountryId ;
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else if ( isDlt( ) )
            {
               delete( ) ;
               afterTrn( ) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               /* Update record */
               update033( ) ;
            }
         }
         else
         {
            if ( isDlt( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "CandidateKeyNotFound", 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               if ( A5CountryId != Z5CountryId )
               {
                  if ( isUpd( ) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
                     AnyError = (short)(1) ;
                  }
                  else
                  {
                     Gx_mode = "INS" ;
                     /* Insert record */
                     insert033( ) ;
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
                     /* Insert record */
                     insert033( ) ;
                  }
               }
            }
         }
      }
      afterTrn( ) ;
   }

   public void Save( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars3( bcCountry, 1) ;
      saveImpl( ) ;
      VarsToRow3( bcCountry) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars3( bcCountry, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert033( ) ;
      afterTrn( ) ;
      VarsToRow3( bcCountry) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
         VarsToRow3( bcCountry) ;
      }
      else
      {
         com.kbbaru.SdtCountry auxBC = new com.kbbaru.SdtCountry( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A5CountryId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcCountry);
            auxBC.Save();
            bcCountry.copy(auxBC);
         }
         LclMsgLst = auxTrn.GetMessages() ;
         AnyError = (short)(auxTrn.Errors()) ;
         httpContext.GX_msglist = LclMsgLst ;
         if ( auxTrn.Errors() == 0 )
         {
            Gx_mode = auxTrn.GetMode() ;
            afterTrn( ) ;
         }
      }
   }

   public boolean Update( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars3( bcCountry, 1) ;
      updateImpl( ) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public boolean InsertOrUpdate( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars3( bcCountry, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert033( ) ;
      if ( AnyError == 1 )
      {
         if ( GXutil.strcmp(httpContext.GX_msglist.getItemValue((short)(1)), "DuplicatePrimaryKey") == 0 )
         {
            AnyError = (short)(0) ;
            httpContext.GX_msglist.removeAllItems();
            updateImpl( ) ;
         }
         else
         {
            VarsToRow3( bcCountry) ;
         }
      }
      else
      {
         afterTrn( ) ;
         VarsToRow3( bcCountry) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void Check( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      RowToVars3( bcCountry, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey033( ) ;
      if ( RcdFound3 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A5CountryId != Z5CountryId )
         {
            A5CountryId = Z5CountryId ;
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_getbeforeupd"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( isDlt( ) )
         {
            delete_check( ) ;
         }
         else
         {
            Gx_mode = "UPD" ;
            update_check( ) ;
         }
      }
      else
      {
         if ( A5CountryId != Z5CountryId )
         {
            Gx_mode = "INS" ;
            insert_check( ) ;
         }
         else
         {
            if ( isUpd( ) )
            {
               httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_recdeleted"), 1, "");
               AnyError = (short)(1) ;
            }
            else
            {
               Gx_mode = "INS" ;
               insert_check( ) ;
            }
         }
      }
      Application.rollbackDataStores(context, remoteHandle, pr_default, "country_bc");
      VarsToRow3( bcCountry) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public int Errors( )
   {
      if ( AnyError == 0 )
      {
         return 0 ;
      }
      return 1 ;
   }

   public com.genexus.internet.MsgList GetMessages( )
   {
      return LclMsgLst ;
   }

   public String GetMode( )
   {
      Gx_mode = bcCountry.getgxTv_SdtCountry_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcCountry.setgxTv_SdtCountry_Mode( Gx_mode );
   }

   public void SetSDT( com.kbbaru.SdtCountry sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcCountry )
      {
         bcCountry = sdt ;
         if ( GXutil.strcmp(bcCountry.getgxTv_SdtCountry_Mode(), "") == 0 )
         {
            bcCountry.setgxTv_SdtCountry_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow3( bcCountry) ;
         }
         else
         {
            RowToVars3( bcCountry, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcCountry.getgxTv_SdtCountry_Mode(), "") == 0 )
         {
            bcCountry.setgxTv_SdtCountry_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars3( bcCountry, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtCountry getCountry_BC( )
   {
      return bcCountry ;
   }


   public void webExecute( )
   {
   }

   protected void createObjects( )
   {
   }

   protected void Process( )
   {
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
      scmdbuf = "" ;
      PreviousTooltip = "" ;
      PreviousCaption = "" ;
      Gx_mode = "" ;
      endTrnMsgTxt = "" ;
      endTrnMsgCod = "" ;
      sMode3 = "" ;
      Z6CountryName = "" ;
      A6CountryName = "" ;
      BC00036_A5CountryId = new short[1] ;
      BC00036_A6CountryName = new String[] {""} ;
      BC00037_A5CountryId = new short[1] ;
      BC00038_A5CountryId = new short[1] ;
      BC00038_A6CountryName = new String[] {""} ;
      BC00039_A5CountryId = new short[1] ;
      BC00039_A6CountryName = new String[] {""} ;
      BC000311_A5CountryId = new short[1] ;
      BC000314_A9AttractionsId = new short[1] ;
      BC000315_A5CountryId = new short[1] ;
      BC000315_A6CountryName = new String[] {""} ;
      Z16CountryCityName = "" ;
      A16CountryCityName = "" ;
      BC000316_A5CountryId = new short[1] ;
      BC000316_A12CountryCityId = new short[1] ;
      BC000316_A16CountryCityName = new String[] {""} ;
      BC000317_A5CountryId = new short[1] ;
      BC000317_A12CountryCityId = new short[1] ;
      BC000318_A5CountryId = new short[1] ;
      BC000318_A12CountryCityId = new short[1] ;
      BC000318_A16CountryCityName = new String[] {""} ;
      sMode10 = "" ;
      BC000319_A5CountryId = new short[1] ;
      BC000319_A12CountryCityId = new short[1] ;
      BC000319_A16CountryCityName = new String[] {""} ;
      BC000323_A9AttractionsId = new short[1] ;
      BC000324_A5CountryId = new short[1] ;
      BC000324_A12CountryCityId = new short[1] ;
      BC000324_A16CountryCityName = new String[] {""} ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.country_bc__default(),
         new Object[] {
             new Object[] {
            BC00032_A5CountryId, BC00032_A12CountryCityId, BC00032_A16CountryCityName
            }
            , new Object[] {
            BC00033_A5CountryId, BC00033_A12CountryCityId, BC00033_A16CountryCityName
            }
            , new Object[] {
            BC00034_A5CountryId, BC00034_A6CountryName
            }
            , new Object[] {
            BC00035_A5CountryId, BC00035_A6CountryName
            }
            , new Object[] {
            BC00036_A5CountryId, BC00036_A6CountryName
            }
            , new Object[] {
            BC00037_A5CountryId
            }
            , new Object[] {
            BC00038_A5CountryId, BC00038_A6CountryName
            }
            , new Object[] {
            BC00039_A5CountryId, BC00039_A6CountryName
            }
            , new Object[] {
            }
            , new Object[] {
            BC000311_A5CountryId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000314_A9AttractionsId
            }
            , new Object[] {
            BC000315_A5CountryId, BC000315_A6CountryName
            }
            , new Object[] {
            BC000316_A5CountryId, BC000316_A12CountryCityId, BC000316_A16CountryCityName
            }
            , new Object[] {
            BC000317_A5CountryId, BC000317_A12CountryCityId
            }
            , new Object[] {
            BC000318_A5CountryId, BC000318_A12CountryCityId, BC000318_A16CountryCityName
            }
            , new Object[] {
            BC000319_A5CountryId, BC000319_A12CountryCityId, BC000319_A16CountryCityName
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000323_A9AttractionsId
            }
            , new Object[] {
            BC000324_A5CountryId, BC000324_A12CountryCityId, BC000324_A16CountryCityName
            }
         }
      );
      /* Execute Start event if defined. */
      /* Execute user event: Start */
      e12032 ();
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gxremove10 ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z5CountryId ;
   private short A5CountryId ;
   private short nIsMod_10 ;
   private short RcdFound10 ;
   private short RcdFound3 ;
   private short nIsDirty_3 ;
   private short nRcdExists_10 ;
   private short Z12CountryCityId ;
   private short A12CountryCityId ;
   private short nIsDirty_10 ;
   private int trnEnded ;
   private int nGXsfl_10_idx=1 ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode3 ;
   private String sMode10 ;
   private boolean returnInSub ;
   private boolean mustCommit ;
   private String Z6CountryName ;
   private String A6CountryName ;
   private String Z16CountryCityName ;
   private String A16CountryCityName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.kbbaru.SdtCountry bcCountry ;
   private IDataStoreProvider pr_default ;
   private short[] BC00036_A5CountryId ;
   private String[] BC00036_A6CountryName ;
   private short[] BC00037_A5CountryId ;
   private short[] BC00038_A5CountryId ;
   private String[] BC00038_A6CountryName ;
   private short[] BC00039_A5CountryId ;
   private String[] BC00039_A6CountryName ;
   private short[] BC000311_A5CountryId ;
   private short[] BC000314_A9AttractionsId ;
   private short[] BC000315_A5CountryId ;
   private String[] BC000315_A6CountryName ;
   private short[] BC000316_A5CountryId ;
   private short[] BC000316_A12CountryCityId ;
   private String[] BC000316_A16CountryCityName ;
   private short[] BC000317_A5CountryId ;
   private short[] BC000317_A12CountryCityId ;
   private short[] BC000318_A5CountryId ;
   private short[] BC000318_A12CountryCityId ;
   private String[] BC000318_A16CountryCityName ;
   private short[] BC000319_A5CountryId ;
   private short[] BC000319_A12CountryCityId ;
   private String[] BC000319_A16CountryCityName ;
   private short[] BC000323_A9AttractionsId ;
   private short[] BC000324_A5CountryId ;
   private short[] BC000324_A12CountryCityId ;
   private String[] BC000324_A16CountryCityName ;
   private short[] BC00032_A5CountryId ;
   private short[] BC00032_A12CountryCityId ;
   private String[] BC00032_A16CountryCityName ;
   private short[] BC00033_A5CountryId ;
   private short[] BC00033_A12CountryCityId ;
   private String[] BC00033_A16CountryCityName ;
   private short[] BC00034_A5CountryId ;
   private String[] BC00034_A6CountryName ;
   private short[] BC00035_A5CountryId ;
   private String[] BC00035_A6CountryName ;
}

final  class country_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00032", "SELECT CountryId, CountryCityId, CountryCityName FROM CountryCity WHERE CountryId = ? AND CountryCityId = ?  FOR UPDATE OF CountryCity",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00033", "SELECT CountryId, CountryCityId, CountryCityName FROM CountryCity WHERE CountryId = ? AND CountryCityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00034", "SELECT CountryId, CountryName FROM Country WHERE CountryId = ?  FOR UPDATE OF Country",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00035", "SELECT CountryId, CountryName FROM Country WHERE CountryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00036", "SELECT TM1.CountryId, TM1.CountryName FROM Country TM1 WHERE TM1.CountryId = ? ORDER BY TM1.CountryId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00037", "SELECT CountryId FROM Country WHERE CountryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00038", "SELECT CountryId, CountryName FROM Country WHERE CountryId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00039", "SELECT CountryId, CountryName FROM Country WHERE CountryId = ?  FOR UPDATE OF Country",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000310", "SAVEPOINT gxupdate;INSERT INTO Country(CountryName) VALUES(?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000311", "SELECT currval('CountryId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000312", "SAVEPOINT gxupdate;UPDATE Country SET CountryName=?  WHERE CountryId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000313", "SAVEPOINT gxupdate;DELETE FROM Country  WHERE CountryId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000314", "SELECT AttractionsId FROM Attractions WHERE CountryId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000315", "SELECT TM1.CountryId, TM1.CountryName FROM Country TM1 WHERE TM1.CountryId = ? ORDER BY TM1.CountryId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000316", "SELECT CountryId, CountryCityId, CountryCityName FROM CountryCity WHERE CountryId = ? and CountryCityId = ? ORDER BY CountryId, CountryCityId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000317", "SELECT CountryId, CountryCityId FROM CountryCity WHERE CountryId = ? AND CountryCityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000318", "SELECT CountryId, CountryCityId, CountryCityName FROM CountryCity WHERE CountryId = ? AND CountryCityId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000319", "SELECT CountryId, CountryCityId, CountryCityName FROM CountryCity WHERE CountryId = ? AND CountryCityId = ?  FOR UPDATE OF CountryCity",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000320", "SAVEPOINT gxupdate;INSERT INTO CountryCity(CountryId, CountryCityId, CountryCityName) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000321", "SAVEPOINT gxupdate;UPDATE CountryCity SET CountryCityName=?  WHERE CountryId = ? AND CountryCityId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000322", "SAVEPOINT gxupdate;DELETE FROM CountryCity  WHERE CountryId = ? AND CountryCityId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000323", "SELECT AttractionsId FROM Attractions WHERE CountryId = ? AND CountryCityId = ?  LIMIT 1",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("BC000324", "SELECT CountryId, CountryCityId, CountryCityName FROM CountryCity WHERE CountryId = ? ORDER BY CountryId, CountryCityId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 9 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 12 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
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
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 21 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
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
            case 13 :
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
               return;
            case 17 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 18 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setVarchar(3, (String)parms[2], 40, false);
               return;
            case 19 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

