package com.kbbaru ;
import com.kbbaru.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.util.*;

public final  class reorg extends GXProcedure
{
   public reorg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( reorg.class ), "" );
   }

   public reorg( int remoteHandle ,
                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      if ( previousCheck() )
      {
         executeReorganization( ) ;
      }
   }

   private void FirstActions( )
   {
      /* Load data into tables. */
   }

   public void CreateCityKecamatan( ) throws SQLException
   {
      String cmdBufferCreate = "";
      String cmdBuffer = "";
      /* Indices for table CityKecamatan */
      try
      {
         cmdBufferCreate = " CREATE TABLE CityKecamatan (CityId smallint NOT NULL , CityKecamatanId smallint NOT NULL , CityKecamatanName VARCHAR(40) NOT NULL , PRIMARY KEY(CityId, CityKecamatanId)) ";
         cmdBufferCreate += "   ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " DROP TABLE CityKecamatan CASCADE ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
            try
            {
               cmdBuffer = " DROP VIEW CityKecamatan CASCADE ";
               ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
            }
            catch(SQLException sqlex2)
            {
               try
               {
                  cmdBuffer = " DROP FUNCTION CityKecamatan CASCADE ";
                  ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
               }
               catch(SQLException sqlex3)
               {
               }
            }
         }
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBufferCreate) ;
      }
   }

   public void RICityKecamatanCity( ) throws SQLException
   {
      String cmdBuffer;
      try
      {
         cmdBuffer = " ALTER TABLE CityKecamatan ADD CONSTRAINT ICITYKECAMATAN1 FOREIGN KEY (CityId) REFERENCES City (CityId) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
      catch(SQLException ex)
      {
         try
         {
            cmdBuffer = " ALTER TABLE CityKecamatan DROP CONSTRAINT ICITYKECAMATAN1 ";
            ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
         }
         catch(SQLException sqlex1)
         {
         }
         cmdBuffer = " ALTER TABLE CityKecamatan ADD CONSTRAINT ICITYKECAMATAN1 FOREIGN KEY (CityId) REFERENCES City (CityId) ";
         ExecuteDirectSQL.executeWithThrow(context, remoteHandle, "DEFAULT", cmdBuffer) ;
      }
   }

   private void tablesCount( )
   {
   }

   private boolean previousCheck( )
   {
      if ( ! GXReorganization.mustRunCheck( ) )
      {
         return true ;
      }
      sSchemaVar = context.getUserId( "Server", remoteHandle, pr_default) ;
      if ( tableexist("CityKecamatan",sSchemaVar) )
      {
         GXReorganization.setCheckError ( localUtil.getMessages().getMessage("GXM_table_exist", new Object[] {"CityKecamatan"}) ) ;
         return false ;
      }
      return true ;
   }

   private boolean tableexist( String sTableName ,
                               String sMySchemaName )
   {
      boolean result;
      result = false ;
      /* Using cursor P00012 */
      pr_default.execute(0, new Object[] {sTableName, sMySchemaName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         tablename = P00012_Atablename[0] ;
         ntablename = P00012_ntablename[0] ;
         schemaname = P00012_Aschemaname[0] ;
         nschemaname = P00012_nschemaname[0] ;
         result = true ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P00023 */
      pr_default.execute(1, new Object[] {sTableName, sMySchemaName});
      while ( (pr_default.getStatus(1) != 101) )
      {
         tablename = P00023_Atablename[0] ;
         ntablename = P00023_ntablename[0] ;
         schemaname = P00023_Aschemaname[0] ;
         nschemaname = P00023_nschemaname[0] ;
         result = true ;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      return result ;
   }

   private void executeOnlyTablesReorganization( )
   {
      callSubmit( "CreateCityKecamatan" ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"CityKecamatan",""}) ,  1 , new Object[]{ });
   }

   private void executeOnlyRisReorganization( )
   {
      callSubmit( "RICityKecamatanCity" ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"ICITYKECAMATAN1"}) ,  2 , new Object[]{ });
   }

   private void executeTablesReorganization( )
   {
      executeOnlyTablesReorganization( ) ;
      executeOnlyRisReorganization( ) ;
      ReorgSubmitThreadPool.startProcess();
   }

   private void setPrecedence( )
   {
      setPrecedencetables( ) ;
      setPrecedenceris( ) ;
   }

   private void setPrecedencetables( )
   {
      GXReorganization.addMsg( 1 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"CityKecamatan",""}) );
      ReorgSubmitThreadPool.addBlock( "CreateCityKecamatan" );
   }

   private void setPrecedenceris( )
   {
      GXReorganization.addMsg( 2 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"ICITYKECAMATAN1"}) );
      ReorgSubmitThreadPool.addBlock( "RICityKecamatanCity" );
      ReorgSubmitThreadPool.addPrecedence( "RICityKecamatanCity" ,  "CreateCityKecamatan" );
   }

   private void executeReorganization( )
   {
      if ( ErrCode == 0 )
      {
         tablesCount( ) ;
         if ( ! GXReorganization.getRecordCount( ) )
         {
            FirstActions( ) ;
            setPrecedence( ) ;
            executeTablesReorganization( ) ;
         }
      }
   }

   public void UtilsCleanup( )
   {
      cleanup();
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void submitReorg( int submitId ,
                            Object [] submitParms ) throws SQLException
   {
      UserInformation submitUI = Application.getConnectionManager().createUserInformation(Namespace.getNamespace(context.getNAME_SPACE()));
      switch ( submitId )
      {
            case 1 :
               GXReorganization.replaceMsg( 1 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"CityKecamatan",""})+" STARTED" );
               CreateCityKecamatan( ) ;
               GXReorganization.replaceMsg( 1 ,  localUtil.getMessages().getMessage("GXM_filecrea", new Object[] {"CityKecamatan",""})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
            case 2 :
               GXReorganization.replaceMsg( 2 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"ICITYKECAMATAN1"})+" STARTED" );
               RICityKecamatanCity( ) ;
               GXReorganization.replaceMsg( 2 ,  localUtil.getMessages().getMessage("GXM_refintcrea", new Object[] {"ICITYKECAMATAN1"})+" ENDED" );
               try { submitUI.disconnect(); } catch(Exception submitExc) { ; }
               break;
      }
   }

   public void initialize( )
   {
      sSchemaVar = "" ;
      sTableName = "" ;
      sMySchemaName = "" ;
      tablename = "" ;
      ntablename = false ;
      schemaname = "" ;
      nschemaname = false ;
      scmdbuf = "" ;
      P00012_Atablename = new String[] {""} ;
      P00012_ntablename = new boolean[] {false} ;
      P00012_Aschemaname = new String[] {""} ;
      P00012_nschemaname = new boolean[] {false} ;
      P00023_Atablename = new String[] {""} ;
      P00023_ntablename = new boolean[] {false} ;
      P00023_Aschemaname = new String[] {""} ;
      P00023_nschemaname = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new com.kbbaru.reorg__default(),
         new Object[] {
             new Object[] {
            P00012_Atablename, P00012_Aschemaname
            }
            , new Object[] {
            P00023_Atablename, P00023_Aschemaname
            }
         }
      );
      /* GeneXus formulas. */
   }

   protected short ErrCode ;
   protected String sSchemaVar ;
   protected String sTableName ;
   protected String sMySchemaName ;
   protected String scmdbuf ;
   protected boolean ntablename ;
   protected boolean nschemaname ;
   protected String tablename ;
   protected String schemaname ;
   protected IDataStoreProvider pr_default ;
   protected String[] P00012_Atablename ;
   protected boolean[] P00012_ntablename ;
   protected String[] P00012_Aschemaname ;
   protected boolean[] P00012_nschemaname ;
   protected String[] P00023_Atablename ;
   protected boolean[] P00023_ntablename ;
   protected String[] P00023_Aschemaname ;
   protected boolean[] P00023_nschemaname ;
}

final  class reorg__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00012", "SELECT TABLENAME, TABLEOWNER FROM PG_TABLES WHERE (UPPER(TABLENAME) = ( UPPER(?))) AND (UPPER(TABLEOWNER) = ( UPPER(?))) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00023", "SELECT VIEWNAME, VIEWOWNER FROM PG_VIEWS WHERE (UPPER(VIEWNAME) = ( UPPER(?))) AND (UPPER(VIEWOWNER) = ( UPPER(?))) ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
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
               stmt.setString(1, (String)parms[0], 255);
               stmt.setString(2, (String)parms[1], 255);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 255);
               stmt.setString(2, (String)parms[1], 255);
               return;
      }
   }

}

