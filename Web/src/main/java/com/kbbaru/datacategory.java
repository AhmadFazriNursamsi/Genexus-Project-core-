package com.kbbaru ;
import com.kbbaru.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class datacategory extends GXProcedure
{
   public datacategory( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( datacategory.class ), "" );
   }

   public datacategory( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem> executeUdp( )
   {
      datacategory.this.aP0 = new GXBaseCollection[] {new GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem>()};
      execute_int(aP0);
      return aP0[0];
   }

   public void execute( GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem>[] aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem>[] aP0 )
   {
      datacategory.this.aP0 = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00042 */
      pr_default.execute(0);
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CategoryId = P00042_A3CategoryId[0] ;
         A4CategoryName = P00042_A4CategoryName[0] ;
         Gxm1sdtcategory = (com.kbbaru.SdtSDTCategory_SDTCategoryItem)new com.kbbaru.SdtSDTCategory_SDTCategoryItem(remoteHandle, context);
         Gxm2rootcol.add(Gxm1sdtcategory, 0);
         Gxm1sdtcategory.setgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryid( A3CategoryId );
         Gxm1sdtcategory.setgxTv_SdtSDTCategory_SDTCategoryItem_Sdtcategoryname( A4CategoryName );
         Gxm1sdtcategory.setgxTv_SdtSDTCategory_SDTCategoryItem_Ischeck( false );
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP0[0] = datacategory.this.Gxm2rootcol;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      Gxm2rootcol = new GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem>(com.kbbaru.SdtSDTCategory_SDTCategoryItem.class, "SDTCategoryItem", "KBBaru", remoteHandle);
      scmdbuf = "" ;
      P00042_A3CategoryId = new short[1] ;
      P00042_A4CategoryName = new String[] {""} ;
      A4CategoryName = "" ;
      Gxm1sdtcategory = new com.kbbaru.SdtSDTCategory_SDTCategoryItem(remoteHandle, context);
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.datacategory__default(),
         new Object[] {
             new Object[] {
            P00042_A3CategoryId, P00042_A4CategoryName
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A3CategoryId ;
   private short Gx_err ;
   private String scmdbuf ;
   private String A4CategoryName ;
   private GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem>[] aP0 ;
   private IDataStoreProvider pr_default ;
   private short[] P00042_A3CategoryId ;
   private String[] P00042_A4CategoryName ;
   private GXBaseCollection<com.kbbaru.SdtSDTCategory_SDTCategoryItem> Gxm2rootcol ;
   private com.kbbaru.SdtSDTCategory_SDTCategoryItem Gxm1sdtcategory ;
}

final  class datacategory__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00042", "SELECT CategoryId, CategoryName FROM Category ORDER BY CategoryId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
      }
   }

}

