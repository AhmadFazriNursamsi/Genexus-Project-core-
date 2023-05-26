package com.kbbaru ;
import com.kbbaru.*;
import com.genexus.*;
import com.genexus.db.*;
import com.genexus.webpanels.*;
import java.sql.*;
import com.genexus.search.*;

public final  class trips_bc extends GXWebPanel implements IGxSilentTrn
{
   public trips_bc( com.genexus.internet.HttpContext context )
   {
      super(context);
   }

   public trips_bc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( trips_bc.class ));
   }

   public trips_bc( int remoteHandle ,
                    ModelContext context )
   {
      super( remoteHandle , context);
   }

   public void inittrn( )
   {
   }

   public void getInsDefault( )
   {
      readRow0815( ) ;
      standaloneNotModal( ) ;
      initializeNonKey0815( ) ;
      standaloneModal( ) ;
      addRow0815( ) ;
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
         trnEnded = 0 ;
         standaloneNotModal( ) ;
         standaloneModal( ) ;
         if ( isIns( )  )
         {
            Z25TripsId = A25TripsId ;
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

   public void confirm_080( )
   {
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         if ( isDlt( ) )
         {
            onDeleteControls0815( ) ;
         }
         else
         {
            checkExtendedTable0815( ) ;
            if ( AnyError == 0 )
            {
            }
            closeExtendedTableCursors0815( ) ;
         }
      }
      if ( AnyError == 0 )
      {
         /* Save parent mode. */
         sMode15 = Gx_mode ;
         confirm_0816( ) ;
         if ( AnyError == 0 )
         {
            /* Restore parent mode. */
            Gx_mode = sMode15 ;
            IsConfirmed = (short)(1) ;
         }
         /* Restore parent mode. */
         Gx_mode = sMode15 ;
      }
   }

   public void confirm_0816( )
   {
      nGXsfl_16_idx = 0 ;
      while ( nGXsfl_16_idx < bcTrips.getgxTv_SdtTrips_Attrations().size() )
      {
         readRow0816( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound16 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_16 != 0 ) )
         {
            getKey0816( ) ;
            if ( isIns( ) && ! isDlt( ) )
            {
               if ( RcdFound16 == 0 )
               {
                  Gx_mode = "INS" ;
                  beforeValidate0816( ) ;
                  if ( AnyError == 0 )
                  {
                     checkExtendedTable0816( ) ;
                     if ( AnyError == 0 )
                     {
                        zm0816( 3) ;
                     }
                     closeExtendedTableCursors0816( ) ;
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
               if ( RcdFound16 != 0 )
               {
                  if ( isDlt( ) )
                  {
                     Gx_mode = "DLT" ;
                     getByPrimaryKey0816( ) ;
                     load0816( ) ;
                     beforeValidate0816( ) ;
                     if ( AnyError == 0 )
                     {
                        onDeleteControls0816( ) ;
                     }
                  }
                  else
                  {
                     if ( nIsMod_16 != 0 )
                     {
                        Gx_mode = "UPD" ;
                        beforeValidate0816( ) ;
                        if ( AnyError == 0 )
                        {
                           checkExtendedTable0816( ) ;
                           if ( AnyError == 0 )
                           {
                              zm0816( 3) ;
                           }
                           closeExtendedTableCursors0816( ) ;
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
            VarsToRow16( ((com.kbbaru.SdtTrips_Attrations)bcTrips.getgxTv_SdtTrips_Attrations().elementAt(-1+nGXsfl_16_idx))) ;
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
   }

   public void zm0815( int GX_JID )
   {
      if ( ( GX_JID == 1 ) || ( GX_JID == 0 ) )
      {
         Z26TripsDate = A26TripsDate ;
         Z27TripsDescription = A27TripsDescription ;
      }
      if ( GX_JID == -1 )
      {
         Z25TripsId = A25TripsId ;
         Z26TripsDate = A26TripsDate ;
         Z27TripsDescription = A27TripsDescription ;
      }
   }

   public void standaloneNotModal( )
   {
   }

   public void standaloneModal( )
   {
   }

   public void load0815( )
   {
      /* Using cursor BC00087 */
      pr_default.execute(5, new Object[] {Short.valueOf(A25TripsId)});
      if ( (pr_default.getStatus(5) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A26TripsDate = BC00087_A26TripsDate[0] ;
         A27TripsDescription = BC00087_A27TripsDescription[0] ;
         zm0815( -1) ;
      }
      pr_default.close(5);
      onLoadActions0815( ) ;
   }

   public void onLoadActions0815( )
   {
   }

   public void checkExtendedTable0815( )
   {
      nIsDirty_15 = (short)(0) ;
      standaloneModal( ) ;
   }

   public void closeExtendedTableCursors0815( )
   {
   }

   public void enableDisable( )
   {
   }

   public void getKey0815( )
   {
      /* Using cursor BC00088 */
      pr_default.execute(6, new Object[] {Short.valueOf(A25TripsId)});
      if ( (pr_default.getStatus(6) != 101) )
      {
         RcdFound15 = (short)(1) ;
      }
      else
      {
         RcdFound15 = (short)(0) ;
      }
      pr_default.close(6);
   }

   public void getByPrimaryKey( )
   {
      /* Using cursor BC00089 */
      pr_default.execute(7, new Object[] {Short.valueOf(A25TripsId)});
      if ( (pr_default.getStatus(7) != 101) )
      {
         zm0815( 1) ;
         RcdFound15 = (short)(1) ;
         A25TripsId = BC00089_A25TripsId[0] ;
         A26TripsDate = BC00089_A26TripsDate[0] ;
         A27TripsDescription = BC00089_A27TripsDescription[0] ;
         Z25TripsId = A25TripsId ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         load0815( ) ;
         if ( AnyError == 1 )
         {
            RcdFound15 = (short)(0) ;
            initializeNonKey0815( ) ;
         }
         Gx_mode = sMode15 ;
      }
      else
      {
         RcdFound15 = (short)(0) ;
         initializeNonKey0815( ) ;
         sMode15 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal( ) ;
         Gx_mode = sMode15 ;
      }
      pr_default.close(7);
   }

   public void getEqualNoModal( )
   {
      getKey0815( ) ;
      if ( RcdFound15 == 0 )
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
      confirm_080( ) ;
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

   public void checkOptimisticConcurrency0815( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000810 */
         pr_default.execute(8, new Object[] {Short.valueOf(A25TripsId)});
         if ( (pr_default.getStatus(8) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Trips"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(8) == 101) || !( GXutil.dateCompare(GXutil.resetTime(Z26TripsDate), GXutil.resetTime(BC000810_A26TripsDate[0])) ) || ( GXutil.strcmp(Z27TripsDescription, BC000810_A27TripsDescription[0]) != 0 ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"Trips"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0815( )
   {
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0815( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0815( 0) ;
         checkOptimisticConcurrency0815( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0815( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0815( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000811 */
                  pr_default.execute(9, new Object[] {A26TripsDate, A27TripsDescription});
                  /* Retrieving last key number assigned */
                  /* Using cursor BC000812 */
                  pr_default.execute(10);
                  A25TripsId = BC000812_A25TripsId[0] ;
                  pr_default.close(10);
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Trips");
                  if ( AnyError == 0 )
                  {
                     /* Start of After( Insert) rules */
                     /* End of After( Insert) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0815( ) ;
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
            load0815( ) ;
         }
         endLevel0815( ) ;
      }
      closeExtendedTableCursors0815( ) ;
   }

   public void update0815( )
   {
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0815( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0815( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0815( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0815( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000813 */
                  pr_default.execute(11, new Object[] {A26TripsDate, A27TripsDescription, Short.valueOf(A25TripsId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Trips");
                  if ( (pr_default.getStatus(11) == 103) )
                  {
                     httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"Trips"}), "RecordIsLocked", 1, "");
                     AnyError = (short)(1) ;
                  }
                  deferredUpdate0815( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        processLevel0815( ) ;
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
         endLevel0815( ) ;
      }
      closeExtendedTableCursors0815( ) ;
   }

   public void deferredUpdate0815( )
   {
   }

   public void delete( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0815( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0815( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0815( ) ;
         afterConfirm0815( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0815( ) ;
            if ( AnyError == 0 )
            {
               scanKeyStart0816( ) ;
               while ( RcdFound16 != 0 )
               {
                  getByPrimaryKey0816( ) ;
                  delete0816( ) ;
                  scanKeyNext0816( ) ;
               }
               scanKeyEnd0816( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000814 */
                  pr_default.execute(12, new Object[] {Short.valueOf(A25TripsId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("Trips");
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
      sMode15 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0815( ) ;
      Gx_mode = sMode15 ;
   }

   public void onDeleteControls0815( )
   {
      standaloneModal( ) ;
      /* No delete mode formulas found. */
   }

   public void processNestedLevel0816( )
   {
      nGXsfl_16_idx = 0 ;
      while ( nGXsfl_16_idx < bcTrips.getgxTv_SdtTrips_Attrations().size() )
      {
         readRow0816( ) ;
         if ( (GXutil.strcmp("", Gx_mode)==0) )
         {
            if ( RcdFound16 == 0 )
            {
               Gx_mode = "INS" ;
            }
            else
            {
               Gx_mode = "UPD" ;
            }
         }
         if ( ! isIns( ) || ( nIsMod_16 != 0 ) )
         {
            standaloneNotModal0816( ) ;
            if ( isIns( ) )
            {
               Gx_mode = "INS" ;
               insert0816( ) ;
            }
            else
            {
               if ( isDlt( ) )
               {
                  Gx_mode = "DLT" ;
                  delete0816( ) ;
               }
               else
               {
                  Gx_mode = "UPD" ;
                  update0816( ) ;
               }
            }
         }
         KeyVarsToRow16( ((com.kbbaru.SdtTrips_Attrations)bcTrips.getgxTv_SdtTrips_Attrations().elementAt(-1+nGXsfl_16_idx))) ;
      }
      if ( AnyError == 0 )
      {
         /* Batch update SDT rows */
         nGXsfl_16_idx = 0 ;
         while ( nGXsfl_16_idx < bcTrips.getgxTv_SdtTrips_Attrations().size() )
         {
            readRow0816( ) ;
            if ( (GXutil.strcmp("", Gx_mode)==0) )
            {
               if ( RcdFound16 == 0 )
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
               bcTrips.getgxTv_SdtTrips_Attrations().removeElement(nGXsfl_16_idx);
               nGXsfl_16_idx = (int)(nGXsfl_16_idx-1) ;
            }
            else
            {
               Gx_mode = "UPD" ;
               getByPrimaryKey0816( ) ;
               VarsToRow16( ((com.kbbaru.SdtTrips_Attrations)bcTrips.getgxTv_SdtTrips_Attrations().elementAt(-1+nGXsfl_16_idx))) ;
            }
         }
      }
      /* Start of After( level) rules */
      /* End of After( level) rules */
      initAll0816( ) ;
      if ( AnyError != 0 )
      {
      }
      nRcdExists_16 = (short)(0) ;
      nIsMod_16 = (short)(0) ;
      Gxremove16 = (byte)(0) ;
   }

   public void processLevel0815( )
   {
      /* Save parent mode. */
      sMode15 = Gx_mode ;
      processNestedLevel0816( ) ;
      if ( AnyError != 0 )
      {
      }
      /* Restore parent mode. */
      Gx_mode = sMode15 ;
      /* ' Update level parameters */
   }

   public void endLevel0815( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(8);
      }
      if ( AnyError == 0 )
      {
         beforeComplete0815( ) ;
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

   public void scanKeyStart0815( )
   {
      /* Using cursor BC000815 */
      pr_default.execute(13, new Object[] {Short.valueOf(A25TripsId)});
      RcdFound15 = (short)(0) ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A25TripsId = BC000815_A25TripsId[0] ;
         A26TripsDate = BC000815_A26TripsDate[0] ;
         A27TripsDescription = BC000815_A27TripsDescription[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0815( )
   {
      /* Scan next routine */
      pr_default.readNext(13);
      RcdFound15 = (short)(0) ;
      scanKeyLoad0815( ) ;
   }

   public void scanKeyLoad0815( )
   {
      sMode15 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(13) != 101) )
      {
         RcdFound15 = (short)(1) ;
         A25TripsId = BC000815_A25TripsId[0] ;
         A26TripsDate = BC000815_A26TripsDate[0] ;
         A27TripsDescription = BC000815_A27TripsDescription[0] ;
      }
      Gx_mode = sMode15 ;
   }

   public void scanKeyEnd0815( )
   {
      pr_default.close(13);
   }

   public void afterConfirm0815( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0815( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0815( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0815( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0815( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0815( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0815( )
   {
   }

   public void zm0816( int GX_JID )
   {
      if ( ( GX_JID == 2 ) || ( GX_JID == 0 ) )
      {
      }
      if ( ( GX_JID == 3 ) || ( GX_JID == 0 ) )
      {
         Z10AttractionsName = A10AttractionsName ;
      }
      if ( GX_JID == -2 )
      {
         Z25TripsId = A25TripsId ;
         Z9AttractionsId = A9AttractionsId ;
         Z10AttractionsName = A10AttractionsName ;
      }
   }

   public void standaloneNotModal0816( )
   {
   }

   public void standaloneModal0816( )
   {
   }

   public void load0816( )
   {
      /* Using cursor BC000816 */
      pr_default.execute(14, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(14) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A10AttractionsName = BC000816_A10AttractionsName[0] ;
         zm0816( -2) ;
      }
      pr_default.close(14);
      onLoadActions0816( ) ;
   }

   public void onLoadActions0816( )
   {
   }

   public void checkExtendedTable0816( )
   {
      nIsDirty_16 = (short)(0) ;
      Gx_BScreen = (byte)(1) ;
      standaloneModal0816( ) ;
      Gx_BScreen = (byte)(0) ;
      /* Using cursor BC000817 */
      pr_default.execute(15, new Object[] {Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(15) == 101) )
      {
         httpContext.GX_msglist.addItem("No matching 'Attractions'.", "ForeignKeyNotFound", 1, "ATTRACTIONSID");
         AnyError = (short)(1) ;
      }
      A10AttractionsName = BC000817_A10AttractionsName[0] ;
      pr_default.close(15);
   }

   public void closeExtendedTableCursors0816( )
   {
      pr_default.close(15);
   }

   public void enableDisable0816( )
   {
   }

   public void getKey0816( )
   {
      /* Using cursor BC000818 */
      pr_default.execute(16, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(16) != 101) )
      {
         RcdFound16 = (short)(1) ;
      }
      else
      {
         RcdFound16 = (short)(0) ;
      }
      pr_default.close(16);
   }

   public void getByPrimaryKey0816( )
   {
      /* Using cursor BC000819 */
      pr_default.execute(17, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
      if ( (pr_default.getStatus(17) != 101) )
      {
         zm0816( 2) ;
         RcdFound16 = (short)(1) ;
         initializeNonKey0816( ) ;
         A9AttractionsId = BC000819_A9AttractionsId[0] ;
         Z25TripsId = A25TripsId ;
         Z9AttractionsId = A9AttractionsId ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0816( ) ;
         load0816( ) ;
         Gx_mode = sMode16 ;
      }
      else
      {
         RcdFound16 = (short)(0) ;
         initializeNonKey0816( ) ;
         sMode16 = Gx_mode ;
         Gx_mode = "DSP" ;
         standaloneModal0816( ) ;
         Gx_mode = sMode16 ;
      }
      if ( isDsp( ) || isDlt( ) )
      {
         disableAttributes0816( ) ;
      }
      pr_default.close(17);
   }

   public void checkOptimisticConcurrency0816( )
   {
      if ( ! isIns( ) )
      {
         /* Using cursor BC000820 */
         pr_default.execute(18, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
         if ( (pr_default.getStatus(18) == 103) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_lock", new Object[] {"TripsAttrations"}), "RecordIsLocked", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
         if ( (pr_default.getStatus(18) == 101) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_waschg", new Object[] {"TripsAttrations"}), "RecordWasChanged", 1, "");
            AnyError = (short)(1) ;
            return  ;
         }
      }
   }

   public void insert0816( )
   {
      beforeValidate0816( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0816( ) ;
      }
      if ( AnyError == 0 )
      {
         zm0816( 0) ;
         checkOptimisticConcurrency0816( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0816( ) ;
            if ( AnyError == 0 )
            {
               beforeInsert0816( ) ;
               if ( AnyError == 0 )
               {
                  /* Using cursor BC000821 */
                  pr_default.execute(19, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
                  Application.getSmartCacheProvider(remoteHandle).setUpdated("TripsAttrations");
                  if ( (pr_default.getStatus(19) == 1) )
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
            load0816( ) ;
         }
         endLevel0816( ) ;
      }
      closeExtendedTableCursors0816( ) ;
   }

   public void update0816( )
   {
      beforeValidate0816( ) ;
      if ( AnyError == 0 )
      {
         checkExtendedTable0816( ) ;
      }
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0816( ) ;
         if ( AnyError == 0 )
         {
            afterConfirm0816( ) ;
            if ( AnyError == 0 )
            {
               beforeUpdate0816( ) ;
               if ( AnyError == 0 )
               {
                  /* No attributes to update on table TripsAttrations */
                  deferredUpdate0816( ) ;
                  if ( AnyError == 0 )
                  {
                     /* Start of After( update) rules */
                     /* End of After( update) rules */
                     if ( AnyError == 0 )
                     {
                        getByPrimaryKey0816( ) ;
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
         endLevel0816( ) ;
      }
      closeExtendedTableCursors0816( ) ;
   }

   public void deferredUpdate0816( )
   {
   }

   public void delete0816( )
   {
      Gx_mode = "DLT" ;
      beforeValidate0816( ) ;
      if ( AnyError == 0 )
      {
         checkOptimisticConcurrency0816( ) ;
      }
      if ( AnyError == 0 )
      {
         onDeleteControls0816( ) ;
         afterConfirm0816( ) ;
         if ( AnyError == 0 )
         {
            beforeDelete0816( ) ;
            if ( AnyError == 0 )
            {
               /* No cascading delete specified. */
               /* Using cursor BC000822 */
               pr_default.execute(20, new Object[] {Short.valueOf(A25TripsId), Short.valueOf(A9AttractionsId)});
               Application.getSmartCacheProvider(remoteHandle).setUpdated("TripsAttrations");
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
      sMode16 = Gx_mode ;
      Gx_mode = "DLT" ;
      endLevel0816( ) ;
      Gx_mode = sMode16 ;
   }

   public void onDeleteControls0816( )
   {
      standaloneModal0816( ) ;
      if ( AnyError == 0 )
      {
         /* Delete mode formulas */
         /* Using cursor BC000823 */
         pr_default.execute(21, new Object[] {Short.valueOf(A9AttractionsId)});
         A10AttractionsName = BC000823_A10AttractionsName[0] ;
         pr_default.close(21);
      }
   }

   public void endLevel0816( )
   {
      if ( ! isIns( ) )
      {
         pr_default.close(18);
      }
      if ( AnyError != 0 )
      {
         httpContext.wjLoc = "" ;
         httpContext.nUserReturn = (byte)(0) ;
      }
   }

   public void scanKeyStart0816( )
   {
      /* Scan By routine */
      /* Using cursor BC000824 */
      pr_default.execute(22, new Object[] {Short.valueOf(A25TripsId)});
      RcdFound16 = (short)(0) ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A10AttractionsName = BC000824_A10AttractionsName[0] ;
         A9AttractionsId = BC000824_A9AttractionsId[0] ;
      }
      /* Load Subordinate Levels */
   }

   public void scanKeyNext0816( )
   {
      /* Scan next routine */
      pr_default.readNext(22);
      RcdFound16 = (short)(0) ;
      scanKeyLoad0816( ) ;
   }

   public void scanKeyLoad0816( )
   {
      sMode16 = Gx_mode ;
      Gx_mode = "DSP" ;
      if ( (pr_default.getStatus(22) != 101) )
      {
         RcdFound16 = (short)(1) ;
         A10AttractionsName = BC000824_A10AttractionsName[0] ;
         A9AttractionsId = BC000824_A9AttractionsId[0] ;
      }
      Gx_mode = sMode16 ;
   }

   public void scanKeyEnd0816( )
   {
      pr_default.close(22);
   }

   public void afterConfirm0816( )
   {
      /* After Confirm Rules */
   }

   public void beforeInsert0816( )
   {
      /* Before Insert Rules */
   }

   public void beforeUpdate0816( )
   {
      /* Before Update Rules */
   }

   public void beforeDelete0816( )
   {
      /* Before Delete Rules */
   }

   public void beforeComplete0816( )
   {
      /* Before Complete Rules */
   }

   public void beforeValidate0816( )
   {
      /* Before Validate Rules */
   }

   public void disableAttributes0816( )
   {
   }

   public void send_integrity_lvl_hashes0816( )
   {
   }

   public void send_integrity_lvl_hashes0815( )
   {
   }

   public void addRow0815( )
   {
      VarsToRow15( bcTrips) ;
   }

   public void readRow0815( )
   {
      RowToVars15( bcTrips, 1) ;
   }

   public void addRow0816( )
   {
      com.kbbaru.SdtTrips_Attrations obj16;
      obj16 = new com.kbbaru.SdtTrips_Attrations(remoteHandle);
      VarsToRow16( obj16) ;
      bcTrips.getgxTv_SdtTrips_Attrations().add(obj16, 0);
      obj16.setgxTv_SdtTrips_Attrations_Mode( "UPD" );
      obj16.setgxTv_SdtTrips_Attrations_Modified( (short)(0) );
   }

   public void readRow0816( )
   {
      nGXsfl_16_idx = (int)(nGXsfl_16_idx+1) ;
      RowToVars16( ((com.kbbaru.SdtTrips_Attrations)bcTrips.getgxTv_SdtTrips_Attrations().elementAt(-1+nGXsfl_16_idx)), 1) ;
   }

   public void initializeNonKey0815( )
   {
      A26TripsDate = GXutil.nullDate() ;
      A27TripsDescription = "" ;
      Z26TripsDate = GXutil.nullDate() ;
      Z27TripsDescription = "" ;
   }

   public void initAll0815( )
   {
      A25TripsId = (short)(0) ;
      initializeNonKey0815( ) ;
   }

   public void standaloneModalInsert( )
   {
   }

   public void initializeNonKey0816( )
   {
      A10AttractionsName = "" ;
   }

   public void initAll0816( )
   {
      A9AttractionsId = (short)(0) ;
      initializeNonKey0816( ) ;
   }

   public void standaloneModalInsert0816( )
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

   public void VarsToRow15( com.kbbaru.SdtTrips obj15 )
   {
      obj15.setgxTv_SdtTrips_Mode( Gx_mode );
      obj15.setgxTv_SdtTrips_Tripsdate( A26TripsDate );
      obj15.setgxTv_SdtTrips_Tripsdescription( A27TripsDescription );
      obj15.setgxTv_SdtTrips_Tripsid( A25TripsId );
      obj15.setgxTv_SdtTrips_Tripsid_Z( Z25TripsId );
      obj15.setgxTv_SdtTrips_Tripsdate_Z( Z26TripsDate );
      obj15.setgxTv_SdtTrips_Tripsdescription_Z( Z27TripsDescription );
      obj15.setgxTv_SdtTrips_Mode( Gx_mode );
   }

   public void KeyVarsToRow15( com.kbbaru.SdtTrips obj15 )
   {
      obj15.setgxTv_SdtTrips_Tripsid( A25TripsId );
   }

   public void RowToVars15( com.kbbaru.SdtTrips obj15 ,
                            int forceLoad )
   {
      Gx_mode = obj15.getgxTv_SdtTrips_Mode() ;
      A26TripsDate = obj15.getgxTv_SdtTrips_Tripsdate() ;
      A27TripsDescription = obj15.getgxTv_SdtTrips_Tripsdescription() ;
      A25TripsId = obj15.getgxTv_SdtTrips_Tripsid() ;
      Z25TripsId = obj15.getgxTv_SdtTrips_Tripsid_Z() ;
      Z26TripsDate = obj15.getgxTv_SdtTrips_Tripsdate_Z() ;
      Z27TripsDescription = obj15.getgxTv_SdtTrips_Tripsdescription_Z() ;
      Gx_mode = obj15.getgxTv_SdtTrips_Mode() ;
   }

   public void VarsToRow16( com.kbbaru.SdtTrips_Attrations obj16 )
   {
      obj16.setgxTv_SdtTrips_Attrations_Mode( Gx_mode );
      obj16.setgxTv_SdtTrips_Attrations_Attractionsname( A10AttractionsName );
      obj16.setgxTv_SdtTrips_Attrations_Attractionsid( A9AttractionsId );
      obj16.setgxTv_SdtTrips_Attrations_Attractionsid_Z( Z9AttractionsId );
      obj16.setgxTv_SdtTrips_Attrations_Attractionsname_Z( Z10AttractionsName );
      obj16.setgxTv_SdtTrips_Attrations_Modified( nIsMod_16 );
   }

   public void KeyVarsToRow16( com.kbbaru.SdtTrips_Attrations obj16 )
   {
      obj16.setgxTv_SdtTrips_Attrations_Attractionsid( A9AttractionsId );
   }

   public void RowToVars16( com.kbbaru.SdtTrips_Attrations obj16 ,
                            int forceLoad )
   {
      Gx_mode = obj16.getgxTv_SdtTrips_Attrations_Mode() ;
      A10AttractionsName = obj16.getgxTv_SdtTrips_Attrations_Attractionsname() ;
      A9AttractionsId = obj16.getgxTv_SdtTrips_Attrations_Attractionsid() ;
      Z9AttractionsId = obj16.getgxTv_SdtTrips_Attrations_Attractionsid_Z() ;
      Z10AttractionsName = obj16.getgxTv_SdtTrips_Attrations_Attractionsname_Z() ;
      nIsMod_16 = obj16.getgxTv_SdtTrips_Attrations_Modified() ;
   }

   public void LoadKey( Object[] obj )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      A25TripsId = ((Number) GXutil.testNumericType( getParm(obj,0), TypeConstants.SHORT)).shortValue() ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      initializeNonKey0815( ) ;
      scanKeyStart0815( ) ;
      if ( RcdFound15 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z25TripsId = A25TripsId ;
      }
      zm0815( -1) ;
      onLoadActions0815( ) ;
      addRow0815( ) ;
      bcTrips.getgxTv_SdtTrips_Attrations().clearCollection();
      if ( RcdFound15 == 1 )
      {
         scanKeyStart0816( ) ;
         nGXsfl_16_idx = 1 ;
         while ( RcdFound16 != 0 )
         {
            Z25TripsId = A25TripsId ;
            Z9AttractionsId = A9AttractionsId ;
            zm0816( -2) ;
            onLoadActions0816( ) ;
            nRcdExists_16 = (short)(1) ;
            nIsMod_16 = (short)(0) ;
            addRow0816( ) ;
            nGXsfl_16_idx = (int)(nGXsfl_16_idx+1) ;
            scanKeyNext0816( ) ;
         }
         scanKeyEnd0816( ) ;
      }
      scanKeyEnd0815( ) ;
      if ( RcdFound15 == 0 )
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
      RowToVars15( bcTrips, 0) ;
      scanKeyStart0815( ) ;
      if ( RcdFound15 == 0 )
      {
         Gx_mode = "INS" ;
      }
      else
      {
         Gx_mode = "UPD" ;
         Z25TripsId = A25TripsId ;
      }
      zm0815( -1) ;
      onLoadActions0815( ) ;
      addRow0815( ) ;
      bcTrips.getgxTv_SdtTrips_Attrations().clearCollection();
      if ( RcdFound15 == 1 )
      {
         scanKeyStart0816( ) ;
         nGXsfl_16_idx = 1 ;
         while ( RcdFound16 != 0 )
         {
            Z25TripsId = A25TripsId ;
            Z9AttractionsId = A9AttractionsId ;
            zm0816( -2) ;
            onLoadActions0816( ) ;
            nRcdExists_16 = (short)(1) ;
            nIsMod_16 = (short)(0) ;
            addRow0816( ) ;
            nGXsfl_16_idx = (int)(nGXsfl_16_idx+1) ;
            scanKeyNext0816( ) ;
         }
         scanKeyEnd0816( ) ;
      }
      scanKeyEnd0815( ) ;
      if ( RcdFound15 == 0 )
      {
         httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_keynfound"), "PrimaryKeyNotFound", 1, "");
         AnyError = (short)(1) ;
      }
      httpContext.GX_msglist = BackMsgLst ;
   }

   public void saveImpl( )
   {
      nKeyPressed = (byte)(1) ;
      getKey0815( ) ;
      if ( isIns( ) )
      {
         /* Insert record */
         insert0815( ) ;
      }
      else
      {
         if ( RcdFound15 == 1 )
         {
            if ( A25TripsId != Z25TripsId )
            {
               A25TripsId = Z25TripsId ;
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
               update0815( ) ;
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
               if ( A25TripsId != Z25TripsId )
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
                     insert0815( ) ;
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
                     insert0815( ) ;
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
      RowToVars15( bcTrips, 1) ;
      saveImpl( ) ;
      VarsToRow15( bcTrips) ;
      httpContext.GX_msglist = BackMsgLst ;
   }

   public boolean Insert( )
   {
      BackMsgLst = httpContext.GX_msglist ;
      httpContext.GX_msglist = LclMsgLst ;
      AnyError = (short)(0) ;
      httpContext.GX_msglist.removeAllItems();
      IsConfirmed = (short)(1) ;
      RowToVars15( bcTrips, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0815( ) ;
      afterTrn( ) ;
      VarsToRow15( bcTrips) ;
      httpContext.GX_msglist = BackMsgLst ;
      return (AnyError==0) ;
   }

   public void updateImpl( )
   {
      if ( isUpd( ) )
      {
         saveImpl( ) ;
         VarsToRow15( bcTrips) ;
      }
      else
      {
         com.kbbaru.SdtTrips auxBC = new com.kbbaru.SdtTrips( remoteHandle, context);
         IGxSilentTrn auxTrn = auxBC.getTransaction();
         auxBC.Load(A25TripsId);
         if ( auxTrn.Errors() == 0 )
         {
            auxBC.updateDirties(bcTrips);
            auxBC.Save();
            bcTrips.copy(auxBC);
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
      RowToVars15( bcTrips, 1) ;
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
      RowToVars15( bcTrips, 1) ;
      Gx_mode = "INS" ;
      /* Insert record */
      insert0815( ) ;
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
            VarsToRow15( bcTrips) ;
         }
      }
      else
      {
         afterTrn( ) ;
         VarsToRow15( bcTrips) ;
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
      RowToVars15( bcTrips, 0) ;
      nKeyPressed = (byte)(3) ;
      IsConfirmed = (short)(0) ;
      getKey0815( ) ;
      if ( RcdFound15 == 1 )
      {
         if ( isIns( ) )
         {
            httpContext.GX_msglist.addItem(localUtil.getMessages().getMessage("GXM_noupdate"), "DuplicatePrimaryKey", 1, "");
            AnyError = (short)(1) ;
         }
         else if ( A25TripsId != Z25TripsId )
         {
            A25TripsId = Z25TripsId ;
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
         if ( A25TripsId != Z25TripsId )
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
      Application.rollbackDataStores(context, remoteHandle, pr_default, "trips_bc");
      VarsToRow15( bcTrips) ;
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
      Gx_mode = bcTrips.getgxTv_SdtTrips_Mode() ;
      return Gx_mode ;
   }

   public void SetMode( String lMode )
   {
      Gx_mode = lMode ;
      bcTrips.setgxTv_SdtTrips_Mode( Gx_mode );
   }

   public void SetSDT( com.kbbaru.SdtTrips sdt ,
                       byte sdtToBc )
   {
      if ( sdt != bcTrips )
      {
         bcTrips = sdt ;
         if ( GXutil.strcmp(bcTrips.getgxTv_SdtTrips_Mode(), "") == 0 )
         {
            bcTrips.setgxTv_SdtTrips_Mode( "INS" );
         }
         if ( sdtToBc == 1 )
         {
            VarsToRow15( bcTrips) ;
         }
         else
         {
            RowToVars15( bcTrips, 1) ;
         }
      }
      else
      {
         if ( GXutil.strcmp(bcTrips.getgxTv_SdtTrips_Mode(), "") == 0 )
         {
            bcTrips.setgxTv_SdtTrips_Mode( "INS" );
         }
      }
   }

   public void ReloadFromSDT( )
   {
      RowToVars15( bcTrips, 1) ;
   }

   public void ForceCommitOnExit( )
   {
      mustCommit = true ;
   }

   public SdtTrips getTrips_BC( )
   {
      return bcTrips ;
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
      sMode15 = "" ;
      Z26TripsDate = GXutil.nullDate() ;
      A26TripsDate = GXutil.nullDate() ;
      Z27TripsDescription = "" ;
      A27TripsDescription = "" ;
      BC00087_A25TripsId = new short[1] ;
      BC00087_A26TripsDate = new java.util.Date[] {GXutil.nullDate()} ;
      BC00087_A27TripsDescription = new String[] {""} ;
      BC00088_A25TripsId = new short[1] ;
      BC00089_A25TripsId = new short[1] ;
      BC00089_A26TripsDate = new java.util.Date[] {GXutil.nullDate()} ;
      BC00089_A27TripsDescription = new String[] {""} ;
      BC000810_A25TripsId = new short[1] ;
      BC000810_A26TripsDate = new java.util.Date[] {GXutil.nullDate()} ;
      BC000810_A27TripsDescription = new String[] {""} ;
      BC000812_A25TripsId = new short[1] ;
      BC000815_A25TripsId = new short[1] ;
      BC000815_A26TripsDate = new java.util.Date[] {GXutil.nullDate()} ;
      BC000815_A27TripsDescription = new String[] {""} ;
      Z10AttractionsName = "" ;
      A10AttractionsName = "" ;
      BC000816_A25TripsId = new short[1] ;
      BC000816_A10AttractionsName = new String[] {""} ;
      BC000816_A9AttractionsId = new short[1] ;
      BC000817_A10AttractionsName = new String[] {""} ;
      BC000818_A25TripsId = new short[1] ;
      BC000818_A9AttractionsId = new short[1] ;
      BC000819_A25TripsId = new short[1] ;
      BC000819_A9AttractionsId = new short[1] ;
      sMode16 = "" ;
      BC000820_A25TripsId = new short[1] ;
      BC000820_A9AttractionsId = new short[1] ;
      BC000823_A10AttractionsName = new String[] {""} ;
      BC000824_A25TripsId = new short[1] ;
      BC000824_A10AttractionsName = new String[] {""} ;
      BC000824_A9AttractionsId = new short[1] ;
      BackMsgLst = new com.genexus.internet.MsgList();
      LclMsgLst = new com.genexus.internet.MsgList();
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.trips_bc__default(),
         new Object[] {
             new Object[] {
            BC00082_A25TripsId, BC00082_A9AttractionsId
            }
            , new Object[] {
            BC00083_A25TripsId, BC00083_A9AttractionsId
            }
            , new Object[] {
            BC00084_A10AttractionsName
            }
            , new Object[] {
            BC00085_A25TripsId, BC00085_A26TripsDate, BC00085_A27TripsDescription
            }
            , new Object[] {
            BC00086_A25TripsId, BC00086_A26TripsDate, BC00086_A27TripsDescription
            }
            , new Object[] {
            BC00087_A25TripsId, BC00087_A26TripsDate, BC00087_A27TripsDescription
            }
            , new Object[] {
            BC00088_A25TripsId
            }
            , new Object[] {
            BC00089_A25TripsId, BC00089_A26TripsDate, BC00089_A27TripsDescription
            }
            , new Object[] {
            BC000810_A25TripsId, BC000810_A26TripsDate, BC000810_A27TripsDescription
            }
            , new Object[] {
            }
            , new Object[] {
            BC000812_A25TripsId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000815_A25TripsId, BC000815_A26TripsDate, BC000815_A27TripsDescription
            }
            , new Object[] {
            BC000816_A25TripsId, BC000816_A10AttractionsName, BC000816_A9AttractionsId
            }
            , new Object[] {
            BC000817_A10AttractionsName
            }
            , new Object[] {
            BC000818_A25TripsId, BC000818_A9AttractionsId
            }
            , new Object[] {
            BC000819_A25TripsId, BC000819_A9AttractionsId
            }
            , new Object[] {
            BC000820_A25TripsId, BC000820_A9AttractionsId
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            BC000823_A10AttractionsName
            }
            , new Object[] {
            BC000824_A25TripsId, BC000824_A10AttractionsName, BC000824_A9AttractionsId
            }
         }
      );
      /* Execute Start event if defined. */
      standaloneNotModal( ) ;
   }

   private byte nKeyPressed ;
   private byte Gxremove16 ;
   private byte Gx_BScreen ;
   private short IsConfirmed ;
   private short IsModified ;
   private short AnyError ;
   private short Z25TripsId ;
   private short A25TripsId ;
   private short nIsMod_16 ;
   private short RcdFound16 ;
   private short RcdFound15 ;
   private short nIsDirty_15 ;
   private short nRcdExists_16 ;
   private short Z9AttractionsId ;
   private short A9AttractionsId ;
   private short nIsDirty_16 ;
   private int trnEnded ;
   private int nGXsfl_16_idx=1 ;
   private int GX_JID ;
   private String scmdbuf ;
   private String PreviousTooltip ;
   private String PreviousCaption ;
   private String Gx_mode ;
   private String endTrnMsgTxt ;
   private String endTrnMsgCod ;
   private String sMode15 ;
   private String sMode16 ;
   private java.util.Date Z26TripsDate ;
   private java.util.Date A26TripsDate ;
   private boolean mustCommit ;
   private String Z27TripsDescription ;
   private String A27TripsDescription ;
   private String Z10AttractionsName ;
   private String A10AttractionsName ;
   private com.genexus.internet.MsgList BackMsgLst ;
   private com.genexus.internet.MsgList LclMsgLst ;
   private com.kbbaru.SdtTrips bcTrips ;
   private IDataStoreProvider pr_default ;
   private short[] BC00087_A25TripsId ;
   private java.util.Date[] BC00087_A26TripsDate ;
   private String[] BC00087_A27TripsDescription ;
   private short[] BC00088_A25TripsId ;
   private short[] BC00089_A25TripsId ;
   private java.util.Date[] BC00089_A26TripsDate ;
   private String[] BC00089_A27TripsDescription ;
   private short[] BC000810_A25TripsId ;
   private java.util.Date[] BC000810_A26TripsDate ;
   private String[] BC000810_A27TripsDescription ;
   private short[] BC000812_A25TripsId ;
   private short[] BC000815_A25TripsId ;
   private java.util.Date[] BC000815_A26TripsDate ;
   private String[] BC000815_A27TripsDescription ;
   private short[] BC000816_A25TripsId ;
   private String[] BC000816_A10AttractionsName ;
   private short[] BC000816_A9AttractionsId ;
   private String[] BC000817_A10AttractionsName ;
   private short[] BC000818_A25TripsId ;
   private short[] BC000818_A9AttractionsId ;
   private short[] BC000819_A25TripsId ;
   private short[] BC000819_A9AttractionsId ;
   private short[] BC000820_A25TripsId ;
   private short[] BC000820_A9AttractionsId ;
   private String[] BC000823_A10AttractionsName ;
   private short[] BC000824_A25TripsId ;
   private String[] BC000824_A10AttractionsName ;
   private short[] BC000824_A9AttractionsId ;
   private short[] BC00082_A25TripsId ;
   private short[] BC00082_A9AttractionsId ;
   private short[] BC00083_A25TripsId ;
   private short[] BC00083_A9AttractionsId ;
   private String[] BC00084_A10AttractionsName ;
   private short[] BC00085_A25TripsId ;
   private java.util.Date[] BC00085_A26TripsDate ;
   private String[] BC00085_A27TripsDescription ;
   private short[] BC00086_A25TripsId ;
   private java.util.Date[] BC00086_A26TripsDate ;
   private String[] BC00086_A27TripsDescription ;
}

final  class trips_bc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("BC00082", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE TripsId = ? AND AttractionsId = ?  FOR UPDATE OF TripsAttrations",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00083", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE TripsId = ? AND AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00084", "SELECT AttractionsName FROM Attractions WHERE AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00085", "SELECT TripsId, TripsDate, TripsDescription FROM Trips WHERE TripsId = ?  FOR UPDATE OF Trips",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00086", "SELECT TripsId, TripsDate, TripsDescription FROM Trips WHERE TripsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00087", "SELECT TM1.TripsId, TM1.TripsDate, TM1.TripsDescription FROM Trips TM1 WHERE TM1.TripsId = ? ORDER BY TM1.TripsId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00088", "SELECT TripsId FROM Trips WHERE TripsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC00089", "SELECT TripsId, TripsDate, TripsDescription FROM Trips WHERE TripsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000810", "SELECT TripsId, TripsDate, TripsDescription FROM Trips WHERE TripsId = ?  FOR UPDATE OF Trips",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000811", "SAVEPOINT gxupdate;INSERT INTO Trips(TripsDate, TripsDescription) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000812", "SELECT currval('TripsId') ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000813", "SAVEPOINT gxupdate;UPDATE Trips SET TripsDate=?, TripsDescription=?  WHERE TripsId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000814", "SAVEPOINT gxupdate;DELETE FROM Trips  WHERE TripsId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000815", "SELECT TM1.TripsId, TM1.TripsDate, TM1.TripsDescription FROM Trips TM1 WHERE TM1.TripsId = ? ORDER BY TM1.TripsId ",true, GX_NOMASK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000816", "SELECT T1.TripsId, T2.AttractionsName, T1.AttractionsId FROM (TripsAttrations T1 INNER JOIN Attractions T2 ON T2.AttractionsId = T1.AttractionsId) WHERE T1.TripsId = ? and T1.AttractionsId = ? ORDER BY T1.TripsId, T1.AttractionsId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000817", "SELECT AttractionsName FROM Attractions WHERE AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000818", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE TripsId = ? AND AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000819", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE TripsId = ? AND AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000820", "SELECT TripsId, AttractionsId FROM TripsAttrations WHERE TripsId = ? AND AttractionsId = ?  FOR UPDATE OF TripsAttrations",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("BC000821", "SAVEPOINT gxupdate;INSERT INTO TripsAttrations(TripsId, AttractionsId) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new UpdateCursor("BC000822", "SAVEPOINT gxupdate;DELETE FROM TripsAttrations  WHERE TripsId = ? AND AttractionsId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK)
         ,new ForEachCursor("BC000823", "SELECT AttractionsName FROM Attractions WHERE AttractionsId = ? ",true, GX_NOMASK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("BC000824", "SELECT T1.TripsId, T2.AttractionsName, T1.AttractionsId FROM (TripsAttrations T1 INNER JOIN Attractions T2 ON T2.AttractionsId = T1.AttractionsId) WHERE T1.TripsId = ? ORDER BY T1.TripsId, T1.AttractionsId ",true, GX_NOMASK, false, this,11, GxCacheFrequency.OFF,false )
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
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 3 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 4 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 5 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 6 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 7 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 8 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 10 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               return;
            case 13 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               return;
            case 14 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 15 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 16 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 17 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 18 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               return;
            case 21 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               return;
            case 22 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 9 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               return;
            case 11 :
               stmt.setDate(1, (java.util.Date)parms[0]);
               stmt.setVarchar(2, (String)parms[1], 200, false);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
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
               return;
            case 19 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 20 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 21 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
            case 22 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

