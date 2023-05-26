package com.kbbaru ;
import com.kbbaru.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class attractionscategoryupdate extends GXProcedure
{
   public static void main( String args[] )
   {
      Application.init(com.kbbaru.GXcfg.class);
      attractionscategoryupdate pgm = new attractionscategoryupdate (-1);
      Application.realMainProgram = pgm;
      pgm.executeCmdLine(args);
      GXRuntime.exit( );
   }

   public void executeCmdLine( String args[] )
   {

      execute();
   }

   public attractionscategoryupdate( )
   {
      super( -1 , new ModelContext( attractionscategoryupdate.class ), "" );
      Application.init(com.kbbaru.GXcfg.class);
   }

   public attractionscategoryupdate( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( attractionscategoryupdate.class ), "" );
   }

   public attractionscategoryupdate( int remoteHandle ,
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
      /* GeneXus formulas */
      /* Output device settings */
   }

   protected void cleanup( )
   {
      CloseOpenCursors();
      Application.cleanup(context, this, remoteHandle);
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
}

